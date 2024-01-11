<template>
    <div>
        <el-form ref="form" :model="form" label-width="120px">
            <el-row>
                <el-col :span="12">
                    <el-form-item label="知识产权名">
                        <el-input v-model="form.ipName" style="width: 192px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="关联项目名称" prop="responseProject">
                        <el-cascader v-model="responseProject" :options="this.projectTree" clearable
                            :show-all-levels="false" placeholder="请选择关联项目名称"></el-cascader>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="知识产权类别">
                        <el-select v-model="form.ipType" placeholder="请选择类别">
                            <el-option v-for="item in ipTypeOptions" :key="item.ipTypeId" :label="item.ipTypeName"
                                :value="item.ipTypeId" :disabled="item.status === 1"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="知识产权状态">
                        <el-select v-model="form.ipStatus" placeholder="请选择状态">
                            <el-option v-for="item in ipStatusOptions" :key="item.ipStatusId" :label="item.ipStatusName"
                                :value="item.ipStatusId" :disabled="item.status === 1"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="获得日期">
                        <el-col :span="11">
                            <el-date-picker type="date" placeholder="选择日期" v-model="form.ipDate" style="width: 192px"
                                value-format="yyyy-MM-dd"></el-date-picker>
                        </el-col>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="知识产权成员">
                        <el-cascader v-model="responsePerson" :options="cascadeOptions" :props="props" collapse-tags
                            clearable :show-all-levels="false" placeholder="请选择成员"></el-cascader>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item label="附件">
                <fujian ref="fujian" :value="form.sysOssVoList" :idList="ossIds" />
            </el-form-item>
            <el-form-item style="text-align: center;margin-left: -100px;">
                <el-button type="primary" @click="onSubmit">确定</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import { listUser, deptTreeSelect } from "@/api/system/user";
import fujian from "./../../../components/FileUpload/index.vue";
import request from '@/utils/request';
export default {
    components: {
        fujian,
    },
    props: {
        ipId: {
            type: Number,
            required: true,
        },
    },
    data() {
        return {
            props: { multiple: true },
            responsePerson: [],
            projectId: undefined,
            responseProject: [],
            cascadeOptions: [],
            projectTree: [],
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
            ossIds: [],
            params: {
                ipId: null
            },
            form: {
                ipId: null,
                projectId: undefined,
                ipName: '',
                ipType: '',
                ipStatus: '',
                ipDate: '',
                userIdList: [],
                ossIdList: [],
            },
        };
    },
    created() {
        this.createdData().then(() => {
            if (this.$props.ipId) {
                const ipId = parseInt(this.$props.ipId, 10);
                if (!isNaN(ipId)) {
                    this.params.ipId = ipId;
                    this.checkIntellectual().then(() => {
                        console.log('createdData.ipId', this.params.ipId);
                        console.log('this.form', this.form);
                    });
                } else {
                    console.error('Invalid ipId:', this.$props.ipId);
                    // 处理无效 ipId 的情况
                }
            }
        });
    },
    watch: {
        ipId: {
            handler(newVal) {
                this.params.ipId = newVal;
                this.checkIntellectual();
            },
            immediate: true, // 立即执行一次
        },
    },
    methods: {
        async createdData() {
            this.getProjectTree();
            await this.getDeptAndUserList();
        },
        handleIdData(node) {
            this.projectId = node.projectId;
            this.responseProject = node.projectPath;
        },
        getProjectTree() {
            request({
                url: '/ip/getProjectMapping',
                method: 'get',
                params: this.header,
            })
                .then((resp) => {
                    this.projectTree = resp.data;
                })
                .catch((error) => {
                    console.error('获取用户数据时出错：', error);
                });
        },
        // 按部门-人员搜索
        async getDeptAndUserList() {
            await this.getDeptTree(); // 等待部门数据加载完成
            await this.getList(); // 等待用户数据加载完成
            this.cascadeOptions = this.adaptData(this.deptOptions);
            return this.cascadeOptions;
        },
        /** 查询部门下拉树结构 */
        async getDeptTree() {
            const response = await deptTreeSelect();
            this.deptOptions = response.data;
        },
        /** 查询用户列表 */
        async getList() {
            const response = await listUser();
            this.userList = response.rows;
        },
        // 适配数据的方法
        adaptData(data) {
            return data.map(item => {
                const newItem = {
                    value: item.id,
                    label: item.label,
                    children: []
                };
                if (item.children && item.children.length > 0) {
                    newItem.children = this.adaptData(item.children);
                } else {
                    const usersInDept = this.userList.filter(user => user.deptId === item.id);
                    newItem.children = this.adaptUserData(usersInDept);
                }
                return newItem;
            });
        },

        adaptUserData(data) {
            return data.map(item => {
                const newItem = {
                    value: item.userId,
                    label: item.nickName,
                };
                return newItem;
            });
        },
        async checkIntellectual() {
            request({
                url: '/ip/getDetails',
                method: 'get',
                params: {
                    ipId: this.params.ipId,
                },
            })
                .then((resp) => {
                    this.form = resp.data;
                    this.responsePerson = resp.data.userPathList;
                    this.handleIdData(resp.data);
                    console.log('详情数据', this.form);
                })
                .catch(error => {
                    console.error("获取数据时出错1：", error);
                });
        },

        onSubmit() {
            this.form.projectId = parseInt(this.responseProject[this.responseProject.length - 1], 10);
            this.form.userIdList = this.responsePerson.map(subArray => subArray[subArray.length - 1]);
            this.form.ossIdList = this.ossIds;
            // 请求修改接口
            request({
                url: '/ip/update',
                method: 'post',
                data: this.form,
            }).then(() => {
                this.$modal.msgSuccess("修改成功");
                this.$refs.fujian.reset();
                // this.reset();
                this.$emit('close-dialog');
            }).catch((error) => {
                console.error("修改失败", error);
            });
            this.reset();
        },
        // 表单重置
        reset() {
            this.form = {
                ipId: null,
                projectId: undefined,
                ipName: '',
                ipType: '',
                ipStatus: '',
                ipDate: '',
                userIdList: [],
                ossIds: [],
            };
            this.ossIds = [];
            this.fileList = [];
            this.responseProject = undefined;
            this.responsePerson = undefined;
        },
    },
};
</script>
