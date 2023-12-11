<template>
    <div class="block">
        <div class="fixed-container">
            <el-input placeholder="请输入内容" v-model="input3" class="input-with-select" size="small">
                <el-select v-model="select" slot="prepend" placeholder="请选择">
                    <el-option label="前" value="1"></el-option>
                    <el-option label="中" value="2"></el-option>
                    <el-option label="后" value="3"></el-option>
                </el-select>
                <el-button slot="append" icon="el-icon-search"></el-button>
            </el-input>
        </div>
        <el-timeline>
            <el-timeline-item v-for="(item, index) in timelineItems" :key="index" :timestamp="item.milestoneDate"
                placement="top" :icon="item.icon" :style="{ '--icon-color': '#0bbd87' }">
                <el-card style="width: 90%;">
                    <h4>名称：{{ item.milestoneTitle }}</h4>
                    <p>详情：{{ item.milestoneRemark }}</p>
                    <div v-for="(oss, ossIndex) in item.sysOsses" :key="ossIndex">
                        附件：
                        <el-link :href="oss.url" target="_blank" :underline="false">
                            {{ oss.originalName }}
                        </el-link>
                    </div>
                    <el-button type="success" icon="el-icon-edit" size="mini" circle
                        @click="editMilestone(item)"></el-button>
                    <el-button type="danger" icon="el-icon-delete" size="mini" circle
                        @click="deleteMilestone(item)"></el-button>
                </el-card>
            </el-timeline-item>
        </el-timeline>
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

export default {
    props: {
        projectId: {
            type: String,
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
            input: '',
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
            }
        };
    },
    created() {
        console.log("fujian 组件接收到的附件数据:", this.value);
    },
    mounted() {
        console.log("传过来的项目id", this.projectId);
        // 获取数据
        request({
            url: '/project/list/milestonelist',
            method: 'get',
            params: {
                projectId: this.projectId
            }
        })
            .then((resp) => {
                console.log((resp));
                // 根据 milestoneDate 对 timelineItems 进行排序
                this.timelineItems = resp.data.sort((a, b) => {
                    return new Date(a.milestoneDate) - new Date(b.milestoneDate);
                });
                this.timelineItems.forEach(item => {
                    this.milestoneIds.push(item.milestoneId);
                });
                console.log(this.timelineItems);
            })
            .catch((error) => {
                console.error('获取数据时出错：', error);
            })
    },
    methods: {
        editMilestone(item) {
            this.form.milestoneId = item.milestoneId;
            this.form.milestoneTitle = item.milestoneTitle;
            this.form.milestoneRemark = item.milestoneRemark;
            this.form.milestoneDate = item.milestoneDate;
            this.eventsDialogVisibleEdit = true;
            this.form.sysOsses = item.sysOsses;
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
                .then((resp) => {
                    console.log(resp);
                    this.fetchMilestoneList();
                })
        },
        editMilestoneBtn() {
            // 验证关键字段是否为空
            if (!this.form.milestoneTitle || !this.form.milestoneDate || !this.form.milestoneRemark) {
                this.$message.error('请填写完整的信息');
                return;
            }
            this.form.ossIds = this.ossids.map(item => item.ossId);
            // 请求修改接口
            request({
                url: '/project/my/milestoneedit',
                method: 'put',
                data: this.form,
            })
                .then((resp) => {
                    console.log(resp);
                    this.$modal.msgSuccess("修改成功");
                    this.eventsDialogVisibleEdit = false;
                    this.fetchMilestoneList();
                })
                .catch((error) => {
                    console.error("修改失败", error);
                });
        },
        fetchMilestoneList() {
            // 重新获取数据逻辑
            request({
                url: '/project/list/milestonelist',
                method: 'get',
                params: {
                    projectId: this.projectId,
                },
            })
                .then((resp) => {
                    console.log(resp);
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
                });
        },
        close() {
            this.$refs.eventsDialogEdit.close();
        },
        submitUpload() {
            this.$refs.upload.submit();
        },
        onSubmit() {
            console.log('submit!');
        },
        handleRemove(file, fileList) {
            console.log(file, fileList);
        },
        handlePreview(file) {
            console.log(file);
        },
        handleExceed(files, fileList) {
            Message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
        },
        beforeRemove(file, fileList) {
            return MessageBox.confirm(`确定移除 ${file.name}？`);
        },
    },

};
</script>

<style>
.fixed-container {
    position: fixed;
    left: 50%;
    /* 水平居中 */
    margin-top: -25px;
    transform: translate(-50%, -50%);
    z-index: 999;
    /* 保证固定部分位于其他内容之上 */
}

.input-with-select .el-input-group__prepend {
    background-color: #fff;
}
</style>
