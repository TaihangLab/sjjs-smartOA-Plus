<template>
    <div>
        <el-form ref="form" :model="form" label-width="100px">
            <el-row>
                <el-col :span="12">
                    <el-form-item label="知识产权名">
                        <el-input v-model="form.ipName" style="width: 192px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="关联项目名称">
                        <el-select v-model="form.projectId" placeholder="请选择项目">
                            <el-option label="区域一" value="shanghai"></el-option>
                            <el-option label="区域二" value="beijing"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="知识产权类别">
                        <el-select v-model="form.ipType" placeholder="请选择类别">
                            <el-option v-for="item in ipTypeOptions" :key="item.ipTypeId" :label="item.ipTypeName"
                                :value="item.ipTypeId" :disabled="item.status == 1"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="知识产权状态">
                        <el-select v-model="form.ipStatus" placeholder="请选择状态">
                            <el-option v-for="item in ipStatusOptions" :key="item.ipStatusId" :label="item.ipStatusName"
                                :value="item.ipStatusId" :disabled="item.status == 1"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="获得日期">
                        <el-col :span="11">
                            <el-date-picker type="date" placeholder="选择日期" v-model="form.date1"
                                style="width: 192px"></el-date-picker>
                        </el-col>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="知识产权成员">
                        <el-select v-model="form.userIdList" placeholder="请选择成员">
                            <el-option label="区域一" value="shanghai"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item label="附件">
                <fujian ref="fujian" :idList="ossids" />
            </el-form-item>
            <el-form-item style="text-align: center;margin-left: -100px;">
                <el-button type="primary" @click="onSubmit">确定</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import fujian from "./../../../components/FileUpload/index.vue";
import request from '@/utils/request';

export default {
    components: {
        fujian,
    },
    data() {
        const getCurrentDate = () => {
            const today = new Date();
            const year = today.getFullYear();
            const month = (today.getMonth() + 1).toString().padStart(2, '0');
            const day = today.getDate().toString().padStart(2, '0');
            return `${year}-${month}-${day}`;
        };
        return {
            // 知识产权类别
            ipTypeOptions: [{
                ipTypeId: '0',
                ipTypeName: '国内发明专利'
            }, {
                ipTypeId: '1',
                ipTypeName: '软件著作权'
            }, {
                ipTypeId: '2',
                ipTypeName: '论文'
            }, {
                ipTypeId: '3',
                ipTypeName: '标准'
            }],
            // 知识产权状态
            ipStatusOptions: [{
                ipStatusId: '0',
                ipStatusName: '专利受理'
            }, {
                ipStatusId: '1',
                ipStatusName: '专利授权'
            }, {
                ipStatusId: '2',
                ipStatusName: '软著已获取'
            }, {
                ipStatusId: '3',
                ipStatusName: '标准正在申报'
            }, {
                ipStatusId: '4',
                ipStatusName: '标准已通过'
            }, {
                ipStatusId: '5',
                ipStatusName: '论文已发表'
            }],
            value: '',
            form: {
                ipId: this.ipId,
                projectId: this.projectId,
                ipName: '',
                ipType: '',
                ipStatus: '',
                ipDate: getCurrentDate(), 
                userIdList: [],
                ossIds: [],
            },
            ossids: [],
        }
    },
    methods: {
        onSubmit() {
            // 验证关键字段是否为空
            // if (!this.form.milestoneTitle || !this.form.milestoneDate || !this.form.milestoneRemark) {
            //     this.$message.error('请填写完整的信息');
            //     return;
            // }
            this.form.userIdList = this.form.userIdList || [];
            this.form.ossIds = this.ossids;
            request({
                url: '/ip/add',
                method: 'post',
                data: this.form
            })
                .then((resp) => {
                    console.log(resp);
                    this.$modal.msgSuccess("新增成功");
                    // this.$emit('milestoneAdded');
                    this.$refs.fujian.reset();
                    this.$emit('close-dialog'); // 触发一个事件通知父组件关闭弹窗

                })
                .catch(error => {
                    console.error("Error while adding milestone:", error);
                    // 处理错误情况，例如显示错误提示
                });
            this.reset();
        },
        // 表单重置
        reset() {
            this.form = {
                ipId: this.ipId,
                projectId: this.projectId,
                ipName: '',
                ipType: '',
                ipStatus: '',
                ipDate: '',
                userIdList: [],
                ossIds: [],
            };
            this.ossids = [];
            this.fileList = [];
        },
    },
};
</script>