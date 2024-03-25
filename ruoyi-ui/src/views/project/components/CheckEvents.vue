<template>
    <div class="block">
        <div v-if="timelineItems.length" class="fixed-container">
            <el-input placeholder="请输入关键字" v-model="searchKeyword" class="input-with-select" size="mini"
                :clearable="true" @keyup.enter.native="handleQuery" style="border-radius: 0;"></el-input>
            <el-date-picker v-model="dateRange" type="daterange" unlink-panels clearable start-placeholder="请输入查询范围"
                end-placeholder="如：2000-01-01" value-format="yyyy-MM-dd" @keyup.enter.native="handleQuery"
                :picker-options="pickerOptions" size="mini"></el-date-picker>
            <el-cascader v-model="milestoneCategorySelectSet" :options="categorySelect" size="mini" clearable
                placeholder="请选择标签" @keyup.enter.native="handleQuery">
            </el-cascader>
            <el-button type="primary" icon="el-icon-search" @click="handleQuery" size="mini"
                class="no-border-radius"></el-button>
        </div>
        <el-timeline v-show="showTimeline">
            <el-timeline-item v-for="item in timelineItems" :key="item.milestoneId" :timestamp="item.milestoneDate"
                placement="top" :icon="item.icon" :style="{ '--icon-color': '#0bbd87' }">
                <el-card style="width: 90%; display: flex; flex-direction: column;">
                    <h4>名称：{{ item.milestoneTitle }}</h4>
                    <el-tag v-for="(type, index) in item.categoryTypeSet" :key="index" :type="getLabelType(type)"
                        effect="light" plain size="mini" :style="{ color: getTextColor(type), marginRight: '8px' }">
                        {{ getLabel(type) }}
                    </el-tag>
                    <p>详情：{{ item.milestoneRemark }}</p>
                    <div class="attachments-container">
                        <el-button v-for="(oss, ossIndex) in item.sysOsses" :key="ossIndex" size="mini" type="text"
                            icon="el-icon-download" @click="handleDownload(oss)">
                            {{ oss.originalName }}</el-button>
                    </div>
                    <div style="margin-top: 10px;">
                        <el-button type="success" icon="el-icon-edit" size="mini" circle @click="editMilestone(item)"
                            v-if="buttonType === 1" v-hasPermi="['project:my:milestoneedit']"></el-button>
                        <el-button type="danger" icon="el-icon-delete" size="mini" circle
                            @click="confirmDeleteMilestone(item)" v-if="buttonType === 1"
                            v-hasPermi="['project:my:milestonedelete']"></el-button>
                    </div>
                </el-card>
            </el-timeline-item>
        </el-timeline>
        <div v-show="!showTimeline" class="no-data-message"
            style="color: #909399; font-size: 14px; text-align: center;">
            暂无大事记数据
        </div>
        <!-- 修改大事记页面弹出框 -->
        <el-dialog ref="eventsDialogEdit" title="修改大事记" :visible.sync="eventsDialogVisibleEdit"
            @update:visible="eventsDialogVisibleEdit = arguments[0]" :lock-scroll="false" :append-to-body="true"
            width="50%">
            <div id="app">
                <el-form ref="form" :rules="rules" :model="form" label-width="80px">
                    <el-form-item label="名称" prop="milestoneTitle">
                        <el-input v-model="form.milestoneTitle"></el-input>
                    </el-form-item>
                    <!-- 标签选择 -->
                    <el-form-item label="标签" prop="tags" class="add_advice" id="adviceTag"
                        style="display: flex; align-items: center;">
                        <div class="tag-container">
                            <div class="selected-tags">
                                <el-tag v-for="(type, index) in categoryTypeSet" :key="index" closable
                                    @close="handleClose(type)" :type="getLabelType(type)"
                                    :style="{ color: getTextColor(type), marginRight: '8px' }">
                                    {{ getLabel(type) }}
                                </el-tag>
                            </div>
                            <el-select size="mini" v-model="selectedTag" placeholder="请选择" @change="addTag"
                                style="flex: 1;width: 120px;">
                                <el-option v-for="tag in tagOptions" :key="tag.value" :label="tag.label"
                                    :value="tag.label"></el-option>
                            </el-select>
                        </div>
                    </el-form-item>
                    <el-form-item label="时间" prop="milestoneDate">
                        <el-col :span="11">
                            <el-date-picker type="date" placeholder="选择日期" v-model="form.milestoneDate"
                                style="width: 100%;" value-format="yyyy-MM-dd"></el-date-picker>
                        </el-col>
                    </el-form-item>
                    <el-form-item label="详请" prop="milestoneRemark">
                        <el-input type="textarea" v-model="form.milestoneRemark"></el-input>
                    </el-form-item>
                    <el-form-item label="附件">
                        <fujian :value="form.sysOsses" :idList="ossids" />
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" size="small" @click="editMilestoneBtn()">
                            确定
                        </el-button>
                    </el-form-item>
                </el-form>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import request from '@/utils/request';
import fujian from "./../../../components/FileUpload/index.vue";
import { MessageBox, Message } from 'element-ui';

export default {
    props: {
        projectId: {
            type: String,
            required: true
        },
        buttonType: {
            type: Number,
            default: "",
        },
    },
    components: {
        fujian,
    },
    data() {
        return {
            eventsDialogVisibleEdit: false,
            showTimeline: false,
            visible: true,
            select: '',
            keyword: '',
            milestoneType: '',
            searchKeyword: '',
            milestoneStaTime: '',
            milestoneEndTime: '',
            projectEstablishTime: '',
            projectLevel: [],
            dateRange: [],
            timelineItems: [],
            milestoneIds: [],
            title: "",// 初始化 title
            form: {
                projectId: this.projectId,
                milestoneTitle: '',
                milestoneRemark: '',
                milestoneDate: '',
                ossIds: [],
            },
            ossids: [],
            categoryTypeSet: [],
            milestoneCategorySelectSet: [],
            categorySelect: [],
            tagOptions: [], // 标签选项从 milestoneCategorySelectList 方法中获取
            selectedTag: '', // 用户选择的标签（中文文字）
            dynamicTags: [], // 用于存储用户选择的标签（中文文字）
            params: {
                projectId: null,
            },
            labelMappings: {
                0: '其他',
                1: '申报书',
                2: '任务书',
                3: '科研协作合同',
                4: '专项经费文件',
                5: '经费管理表',
                6: '中期文件',
                7: '验收文件',
                8: '结题文件',
                9: '知识产权',
                10: '论文',
                11: '专利',
                12: '软著',
                13: '标准',
                14: '示范应用',
                15: '获奖',
                16: '报告',
                17: '专家咨询',
                18: '经费变更',
                19: '人员变更',
                20: '批复文件',
                21: '通知',
                22: '合同'
            },
            rules: {
                milestoneTitle: [
                    { required: true, message: '请输入名称', trigger: 'blur' },
                ],
                milestoneDate: [
                    { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
                ],
                milestoneRemark: [
                    { required: true, message: '请填写详情', trigger: 'blur' }
                ]
            },
            pickerOptions: {
                shortcuts: [{
                    text: '最近一周',
                    onClick(picker) {
                        const end = new Date();
                        const start = new Date();
                        start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
                        picker.$emit('pick', [start, end]);
                    }
                }, {
                    text: '最近一个月',
                    onClick(picker) {
                        const end = new Date();
                        const start = new Date();
                        start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
                        picker.$emit('pick', [start, end]);
                    }
                }, {
                    text: '最近三个月',
                    onClick(picker) {
                        const end = new Date();
                        const start = new Date();
                        start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
                        picker.$emit('pick', [start, end]);
                    }
                }, {
                    text: '最近半年',
                    onClick(picker) {
                        const end = new Date();
                        const start = new Date();
                        start.setTime(start.getTime() - 3600 * 1000 * 24 * 183);
                        picker.$emit('pick', [start, end]);
                    }
                }, {
                    text: '最近一年',
                    onClick(picker) {
                        const end = new Date();
                        const start = new Date();
                        start.setTime(start.getTime() - 3600 * 1000 * 24 * 365);
                        picker.$emit('pick', [start, end]);
                    }
                }]
            },
        };
    },
    mounted() {
        this.fetchMilestoneList();
        this.milestoneCategorySelectSetList();
        this.milestoneCategorySelectList();
    },
    methods: {
        /** 下载按钮操作 */
        handleDownload(row) {
            this.$download.oss(row.ossId)
        },
        addTag() {
            if (this.selectedTag && !this.categoryTypeSet.includes(this.selectedTag)) {
                this.categoryTypeSet.push(this.selectedTag); // 将选择的标签添加到 categoryTypeSet 数组中
            }
        },
        handleClose(tag) {
            this.categoryTypeSet.splice(this.categoryTypeSet.indexOf(tag), 1);
        },
        editMilestone(item) {
            this.form.milestoneId = item.milestoneId;
            this.form.milestoneTitle = item.milestoneTitle;
            this.form.milestoneRemark = item.milestoneRemark;
            this.form.milestoneDate = item.milestoneDate;
            this.eventsDialogVisibleEdit = true;
            this.form.sysOsses = item.sysOsses;
            // 获取已有的ossids
            this.ossids = item.sysOsses.map(item => item.ossId);
            // 将对应的标签数据存储到 categoryTypeSet 中
            this.categoryTypeSet = item.categoryTypeSet;
        },
        deleteMilestone(item) {
            const milestoneId = item.milestoneId;
            request({
                url: `/project/my/milestonedelete`,
                method: 'delete',
                params: {
                    milestoneId: milestoneId
                }
            })
                .then(() => {
                    this.fetchMilestoneList();
                })
        },
        confirmDeleteMilestone(item) {
            MessageBox.confirm('确定删除该大事记吗？', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning',
            })
                .then(() => {
                    // 用户点击确定按钮时执行删除逻辑
                    this.deleteMilestone(item);
                })
                .catch(() => {
                    // 用户点击取消按钮时不执行任何操作
                });
        },
        editMilestoneBtn() {
            // 验证关键字段是否为空
            if (!this.form.milestoneTitle || !this.form.milestoneDate || !this.form.milestoneRemark) {
                this.$message.error('请填写完整的信息');
                return;
            }
            // this.form.ossIds = this.ossids.map(item => item.ossId);
            this.form.ossIds = this.ossids;
            // 请求修改接口
            request({
                url: '/project/my/milestoneedit',
                method: 'put',
                data: this.form,
            })
                .then(() => {
                    this.$modal.msgSuccess("修改成功");
                    this.eventsDialogVisibleEdit = false;
                    this.fetchMilestoneList();
                })
                .catch((error) => {
                    console.error("修改失败", error);
                });
        },
        fetchMilestoneList() {
            const combinedSearchData = {
                projectId: this.projectId,
                keyword: this.searchKeyword,
                milestoneStaTime: this.milestoneStaTime,
                milestoneEndTime: this.milestoneEndTime,
                milestoneType: this.milestoneCategorySelectSet.join(','),
            };
            request({
                url: '/project/list/milestonequery',
                method: 'post',
                data: combinedSearchData,
                params: this.queryPara,
            })
                .then((resp) => {
                    // 根据 milestoneDate 对 timelineItems 进行排序
                    this.timelineItems = resp.data.sort((a, b) => {
                        return new Date(a.milestoneDate) - new Date(b.milestoneDate);
                    });

                    // 清空 milestoneIds 数组
                    this.milestoneIds = [];
                    // 清空 categoryTypeSet 数组
                    this.categoryTypeSet = [];
                    // 获取标签数据
                    this.timelineItems.forEach(item => {
                        this.milestoneIds.push(item.milestoneId);
                        const types = Array.from(item.categoryTypeSet);
                        types.forEach(type => {
                            if (!this.categoryTypeSet.includes(type)) {
                                this.categoryTypeSet.push(type);
                            }
                        });
                    });
                    this.$forceUpdate();
                    this.updateTimelineDisplay();
                })
                .catch((error) => {
                    console.error('获取数据时出错：', error);
                });
        },
        milestoneCategorySelectSetList() {
            this.params.projectId = this.$props.projectId;
            const combinedSearchData = {
                projectId: this.projectId,
                keyword: this.searchKeyword,
                milestoneStaTime: this.milestoneStaTime,
                milestoneEndTime: this.milestoneEndTime,
            };
            request({
                url: '/project/list/milestoneCategorySelectSet',
                method: 'get',
                data: combinedSearchData,
                params: this.params,
            })
                .then((resp) => {
                    // 将数字值转换为 labelMappings 中的文字描述
                    this.categorySelect = resp.data.map(item => ({
                        label: this.getLabel(item),
                        value: item
                    }));
                })
                .catch((error) => {
                    console.error('获取数据时出错：', error);
                });
        },
        milestoneCategorySelectList() {
            request({
                url: '/project/list/milestoneCategorySelect',
                method: 'get',
                data: this.data,
            })
                .then((resp) => {
                    // 将数字值转换为 labelMappings 中的文字描述
                    this.tagOptions = resp.data.map(item => ({
                        label: this.getLabel(item),
                        value: item
                    }));
                })
                .catch((error) => {
                    console.error('获取数据时出错：', error);
                });
        },
        getLabelType(typeId) {
            // 根据标签类型返回不同的标签类型
            switch (typeId) {
                case 0:
                    return 'default'; // 其他
                case 1:
                    return 'danger'; // 大事记标签
                case 2:
                    return 'primary'; // 申报书
                case 3:
                    return 'success'; // 任务书
                case 4:
                    return 'info'; // 科研协作合同
                case 5:
                    return 'warning'; // 专项经费文件
                case 6:
                    return 'purple'; // 经费管理表
                case 7:
                    return 'deep-blue'; // 中期文件
                case 8:
                    return 'teal'; // 验收文件
                case 9:
                    return 'amber'; // 结题文件
                case 10:
                    return 'cyan'; // 知识产权
                case 11:
                    return 'flame'; // 论文
                case 12:
                    return 'purple'; // 专利
                case 13:
                    return 'amber'; // 软著
                case 14:
                    return 'blue'; // 标准
                case 15:
                    return 'success'; // 示范应用
                case 16:
                    return 'danger'; // 获奖
                case 17:
                    return 'purple'; // 报告
                case 18:
                    return 'info'; // 专家咨询
                case 19:
                    return 'cyan'; // 经费变更
                case 20:
                    return 'deep-blue'; // 人员变更
                case 21:
                    return 'teal'; // 批复文件
                case 22:
                    return 'flame'; // 通知
                case 23:
                    return 'default'; // 合同
                default:
                    return 'default';
            }
        },
        getLabel(typeId) {
            // 如果标签值在labelMappings中有对应的文字描述，则返回对应的描述，否则返回标签值本身
            return this.labelMappings[typeId] || typeId.toString();
        },
        getTextColor(typeId) {
            // 根据标签类型返回不同的字体颜色
            switch (typeId) {
                case 0:
                    return '#999'; // 其他 - 灰色
                case 1:
                    return '#f50'; // 大事记标签 - 红色
                case 2:
                    return '#2db7f5'; // 申报书 - 蓝色
                case 3:
                    return '#87d068'; // 任务书 - 绿色
                case 4:
                    return '#eb2f96'; // 科研协作合同 - 紫红色
                case 5:
                    return '#ff6600'; // 专项经费文件 - 橙色
                case 6:
                    return '#722ed1'; // 经费管理表 - 紫色
                case 7:
                    return '#1890ff'; // 中期文件 - 深蓝色
                case 8:
                    return '#52c41a'; // 验收文件 - 青绿色
                case 9:
                    return '#fa8c16'; // 结题文件 - 琥珀色
                case 10:
                    return '#13c2c2'; // 知识产权 - 青色
                case 11:
                    return '#fa541c'; // 论文 - 火焰色
                case 12:
                    return '#722ed1'; // 专利 - 紫色
                case 13:
                    return '#fa8c16'; // 软著 - 琥珀色
                case 14:
                    return '#2db7f5'; // 标准 - 蓝色
                case 15:
                    return '#87d068'; // 示范应用 - 绿色
                case 16:
                    return '#f50'; // 获奖 - 红色
                case 17:
                    return '#722ed1'; // 报告 - 紫色
                case 18:
                    return '#eb2f96'; // 专家咨询 - 紫红色
                case 19:
                    return '#13c2c2'; // 经费变更 - 青色
                case 20:
                    return '#1890ff'; // 人员变更 - 深蓝色
                case 21:
                    return '#52c41a'; // 批复文件 - 青绿色
                case 22:
                    return '#fa541c'; // 通知 - 火焰色
                case 23:
                    return '#108ee9'; // 合同 - 默认蓝色
            }
        },
        handleQuery() {
            // 设置搜索参数
            const searchData = {
                projectId: this.projectId,
                keyword: this.searchKeyword,
                milestoneStaTime: '',
                milestoneEndTime: '',
                milestoneType: this.milestoneCategorySelectSet.join(','),
            };
            console.log('Search data:', searchData);
            // 判断是否选择了时间范围
            if (this.dateRange && this.dateRange.length === 2) {
                this.milestoneStaTime = this.dateRange[0];
                this.milestoneEndTime = this.dateRange[1];
            } else {
                this.milestoneStaTime = undefined;
                this.milestoneEndTime = undefined;
            }
            // 发起请求，获取符合搜索条件的数据
            this.fetchMilestoneList(searchData);
            // 显示搜索框
            this.updateTimelineDisplay();
        },
        updateTimelineDisplay() {
            // 检查是否有大事记项
            const hasMilestones = this.timelineItems.length > 0;
            // 检查搜索结果是否为空
            const hasSearchResults = this.searchKeyword.trim() !== '';
            // 根据两个条件确定是否显示搜索框
            if (hasMilestones && !hasSearchResults) {
                this.showTimeline = true; // 显示大事记时间轴
            } else {
                this.showTimeline = false; // 隐藏大事记时间轴
            }
        },
        close() {
            this.$refs.eventsDialogEdit.close();
        },
    },
};
</script>

<style>
.fixed-container {
    position: fixed;
    left: 49%;
    width: 40%;
    margin-top: -25px;
    transform: translate(-50%, -50%);
    z-index: 999;
    display: flex;
    align-items: center;
}

.input-with-select {
    width: 150px;
}

.attachments-container {
    display: flex;
}

.attachment-item {
    margin-right: 20px;
}
</style>
