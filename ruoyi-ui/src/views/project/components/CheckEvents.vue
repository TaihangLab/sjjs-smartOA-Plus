<template>
    <div class="block">
        <el-timeline>
            <el-timeline-item
                v-for="(item, index) in timelineItems"
                :key="index"
                :timestamp="item.milestoneDate"
                placement="top"
                :icon="item.icon"
                :style="{ '--icon-color': '#0bbd87'}"
            >
                <el-card>
                    <h4>{{ item.milestoneTitle }}</h4>
                    <p>{{ item.milestoneRemark }} 提交于 {{ item.milestoneDate }}</p>
                    <el-button
                        type="success"
                        icon="el-icon-edit"
                        size="mini"
                        circle
                        @click="editMilestone(item)"
                    ></el-button>
                    <el-button
                        type="danger"
                        icon="el-icon-delete"
                        size="mini"
                        circle
                        @click="deleteMilestone(item)"
                    ></el-button>
                    <el-link
                        v-if="item.attachment"
                        :href="item.attachment"
                        target="_blank"
                        type="primary"
                        icon="el-icon-share"
                        :underline="false"
                        style="margin-left: 10px;"
                    >
                        附件
                    </el-link>
                </el-card>
            </el-timeline-item>
        </el-timeline>
        <!-- 修改大事记页面弹出框 -->
        <el-dialog
            title="修改大事记"
            :visible.sync="eventsDialogVisibleEdit"
            :lock-scroll="false"
            :append-to-body="true"
            width="50%"
        >
            <div id="app">
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item label="名称">
                        <el-input v-model="form.milestoneTitle"></el-input>
                    </el-form-item>
                    <el-form-item label="时间">
                        <el-col :span="11">
                            <el-date-picker
                                type="date"
                                placeholder="选择日期"
                                v-model="form.milestoneDate"
                                style="width: 100%;"
                                value-format="yyyy-MM-dd"
                            ></el-date-picker>
                        </el-col>
                    </el-form-item>
                    <el-form-item label="详请">
                        <el-input type="textarea" v-model="form.milestoneRemark"></el-input>
                    </el-form-item>
                    <el-form-item label="附件">
                        <fujian :idList="ossids"/>
                    </el-form-item>
                    <el-form-item>
                        <el-button
                            type="primary"
                            size="small"
                            @click="editMilestoneBtn"
                        >
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
            fileList: [
                {
                    name: 'food.jpeg',
                    url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
                }
            ],
            eventsDialogVisibleEdit: false,
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
        };
    },
    created() {

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
            })
            .catch((error) => {
                console.error('获取数据时出错：', error);
            })
    },
    mounted() {
        console.log("传过来的项目id", this.projectId);
        // this.getDataList();
    },
    methods: {
        editMilestone(item) {
            this.form.milestoneTitle = item.milestoneTitle;
            this.form.milestoneRemark = item.milestoneRemark;
            this.form.ossIds = item.ossids || [];
            this.form.milestoneDate = item.milestoneDate;
            this.eventsDialogVisibleEdit = true;
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
                    this.getDataList();
                })
        },
        editMilestoneBtn() {
            request({url: '/project/my/milestoneedit', method: 'put', data: this.form})
                .then((resp) => {
                    console.log(resp);
                    this.$modal.msgSuccess("修改成功");
                    this.$emit('close-dialog');
                });
            console.log(this.form);
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
