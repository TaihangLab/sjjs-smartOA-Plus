<template>
    <div>
        <el-form ref="form" :rules="rules" :model="form" label-width="120px">
            <el-row>
                <el-col :span="12">
                    <el-form-item label="项目名称" prop="ipName">
                        <el-input v-model="form.ipName" style="width: 520px"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="专项/自筹" prop="ipType">
                        <el-select v-model="form.ipType" placeholder="请选择类别">
                            <el-option v-for="item in ipTypeOptions" :key="item.ipTypeId" :label="item.ipTypeName"
                                :value="item.ipTypeId" :disabled="item.status === 1"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="凭证号" prop="responseProject">
                        <el-input v-model="form.ipName" style="width: 192px"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="科研粗分" prop="responseProject">
                        <el-input v-model="form.ipName" style="width: 192px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="科研细分" prop="responseProject">
                        <el-input v-model="form.ipName" style="width: 192px"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="日期" prop="ipDate">
                        <el-col :span="11">
                            <el-date-picker type="date" placeholder="选择日期" v-model="form.ipDate" style="width: 192px"
                                value-format="yyyy-MM-dd"></el-date-picker>
                        </el-col>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="金额" prop="responseProject">
                        <el-input v-model="form.ipName" style="width: 192px"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item label="摘要">
                <el-input type="textarea" v-model="form.milestoneRemark"></el-input>
            </el-form-item>
            <el-form-item style="text-align: center;margin-left: -100px;">
                <el-button type="primary" @click="onSubmit">确定</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import { listUser, deptTreeSelect } from "@/api/system/user";
import request from '@/utils/request';
export default {
    props: ['ipId'],
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
            },
            rules: {
                ipName: [
                    { required: true, message: '请输入项目名称', trigger: 'blur' }
                ],
            },
        };
    },
    created() {
        this.createdData();
    },
    methods: {
        async createdData() {
            this.getProjectTree();
            await this.getDeptAndUserList();
        },
        handleIdData(node) {
            this.projectId = node.projectId;
            this.responseProject = this.findPathByValue(this.projectTree, this.projectId);
        },
        findPathByValue(data, targetValue, path = []) {
            for (const item of data) {
                const currentPath = [...path, item.value];
                if (item.value === targetValue) {
                    // 找到目标值，返回当前路径
                    return currentPath;
                }
                if (item.children) {
                    // 如果有子节点，递归查找
                    const result = this.findPathByValue(item.children, targetValue, currentPath);
                    if (result) {
                        // 找到了目标值，直接返回结果
                        return result;
                    }
                }
            }
            return null;
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
        onSubmit() {
            if (this.responseProject && this.responseProject.length > 0) {
                this.form.projectId = this.responseProject[this.responseProject.length - 1];
            }
            if (this.responsePerson && this.responsePerson.length > 0) {
                this.form.userIdList = this.responsePerson.map(subArray => subArray[subArray.length - 1]);
            }
            this.form.ossIdList = this.ossIds;
            request({
                url: '/ip/add',
                method: 'post',
                data: this.form
            }).then((resp) => {
                console.log(resp);
                console.log("this.form.", this.form.ossIds);
                this.$modal.msgSuccess("新增成功");
                this.$refs.fujian.reset();
                this.$emit('close-dialog'); // 触发一个事件通知父组件关闭弹窗
            }).catch(error => {
                console.error("新增失败", error);
                // 处理错误情况，例如显示错误提示
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
            };
            this.ossIds = [];
            this.fileList = [];
            this.responseProject = undefined;
            this.responsePerson = undefined;
        },
    },
};
</script>
