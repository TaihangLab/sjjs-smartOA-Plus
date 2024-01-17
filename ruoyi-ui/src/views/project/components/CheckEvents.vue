<template>
    <div class="block">
        <div v-if="timelineItems.length" class="fixed-container">
            <el-input placeholder="请输入内容" v-model="searchKeyword" class="input-with-select" size="mini" :clearable="true"
                @keyup.enter.native="handleQuery" style="border-radius: 0;"></el-input>
            <el-date-picker v-model="dateRange" type="daterange" unlink-panels clearable start-placeholder="请输入查询范围"
                end-placeholder="如：2000-01-01" value-format="yyyy-MM-dd" @keyup.enter.native="handleQuery"
                :picker-options="pickerOptions" size="mini"></el-date-picker>
            <el-button type="primary" icon="el-icon-search" @click="handleQuery" size="mini"
                class="no-border-radius"></el-button>
        </div>
        <el-timeline v-if="timelineItems.length">
            <el-timeline-item v-for="item in timelineItems" :key="item.milestoneId" :timestamp="item.milestoneDate"
                placement="top" :icon="item.icon" :style="{ '--icon-color': '#0bbd87' }">
                <el-card style="width: 90%; display: flex; flex-direction: column;">
                    <h4>名称：{{ item.milestoneTitle }}</h4>
                    <p>详情：{{ item.milestoneRemark }}</p>
                    <div class="attachments-container">
<!--                        <el-link v-for="(oss, ossIndex) in item.sysOsses" :key="ossIndex" :href="oss.url" target="_blank"-->
<!--                            :underline="false" class="attachment-item">-->
<!--                            {{ oss.originalName }}-->
<!--                        </el-link>-->
                        <el-button v-for="(oss, ossIndex) in item.sysOsses" :key="ossIndex" size="mini" type="text" icon="el-icon-download" @click="handleDownload(oss)">
                            {{ oss.originalName }}</el-button>
                    </div>
                    <div style="margin-top: 10px;">
                        <el-button type="success" icon="el-icon-edit" size="mini" circle @click="editMilestone(item)"
                            v-if="buttonType === 1" v-hasPermi="['project:my:milestoneedit']"></el-button>
                        <el-button type="danger" icon="el-icon-delete" size="mini" circle
                            @click="confirmDeleteMilestone(item)" v-if="buttonType === 1" v-hasPermi="['project:my:milestonedelete']"></el-button>
                    </div>
                </el-card>
            </el-timeline-item>
        </el-timeline>
        <div v-else class="no-data-message" style="color: #909399; font-size: 14px; text-align: center;">
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
                    <el-form-item label="时间" prop="milestoneDate">
                        <el-col :span="11">
                            <el-date-picker type="date" placeholder="选择日期" v-model="form.milestoneDate" style="width: 100%;"
                                value-format="yyyy-MM-dd"></el-date-picker>
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
            visible: true,
            select: '',
            keyword: '',
            searchKeyword: '',
            milestoneStaTime: '',
            milestoneEndTime: '',
            projectEstablishTime: '',
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
        // 获取数据
        request({
            url: '/project/list/milestonequery',
            method: 'post',
            data: {
                projectId: this.projectId,
                keyword: this.keyword,
                milestoneStaTime: this.milestoneStaTime,
                milestoneEndTime: this.milestoneEndTime
            }
        })
            .then((resp) => {
                // 根据 milestoneDate 对 timelineItems 进行排序
                this.timelineItems = resp.data.sort((a, b) => {
                    return new Date(a.milestoneDate) - new Date(b.milestoneDate);
                });
                this.timelineItems.forEach(item => {
                    this.milestoneIds.push(item.milestoneId);
                });
            })
            .catch((error) => {
                console.error('获取数据时出错：', error);
            })
    },
    methods: {
        /** 下载按钮操作 */
        handleDownload(row) {
            this.$download.oss(row.ossId)
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
            };
            // 重新获取数据逻辑
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
                    this.timelineItems.forEach(item => {
                        this.milestoneIds.push(item.milestoneId);
                    });
                    this.$forceUpdate();
                })
                .catch((error) => {
                    console.error('获取数据时出错：', error);
                });
        },
        handleQuery() {
            // 设置搜索参数
            const searchData = {
                projectId: this.projectId,
                keyword: this.searchKeyword,
                milestoneStaTime: this.dateRange[0],
                milestoneEndTime: this.dateRange[1],
            };

            this.fetchMilestoneList(searchData);
        },
        handleQuery() {
            // 设置搜索参数
            const searchData = {
                projectId: this.projectId,
                keyword: this.searchKeyword,
                milestoneStaTime: '',
                milestoneEndTime: '',
            };
            if (this.dateRange && this.dateRange.length === 2) {
                this.milestoneStaTime = this.dateRange[0];
                this.milestoneEndTime = this.dateRange[1];
            } else {
                this.milestoneStaTime = undefined;
                this.milestoneEndTime = undefined;
            }
            this.fetchMilestoneList(searchData);
        },
        close() {
            this.$refs.eventsDialogEdit.close();
        },
        mounted() {
            this.fetchMilestoneList();
        },
    },
};
</script>

<style>
.fixed-container {
    position: fixed;
    left: 52%;
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


