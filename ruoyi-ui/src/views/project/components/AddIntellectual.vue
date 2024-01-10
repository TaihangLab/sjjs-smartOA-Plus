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
                        <el-cascader v-model="responsibleproject" :options="this.projecttree" clearable
                                     :show-all-levels="false" placeholder="请选择关联项目名称"></el-cascader>
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
                            <el-date-picker type="date" placeholder="选择日期" v-model="form.ipDate" style="width: 192px"
                                            value-format="yyyy-MM-dd"></el-date-picker>
                        </el-col>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="知识产权成员">
                        <el-cascader v-model="responsiblePerson" :options="cascaderOptions" :props="props"
                                     collapse-tags clearable :show-all-levels="false" placeholder="请选择成员"></el-cascader>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item label="附件">
                <fujian ref="fujian" :value="form.sysOsses" :idList="ossids" />
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
            type: String,
            required: true,
        },
    },
    data() {
        return {
            props: { multiple: true },
            responsiblePerson: [],
            person: undefined,
            projectId: undefined,
            responsibleproject: [],
            cascaderOptions: [],
            projecttree: undefined,
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
            ossids: [],
            params: {
                ipId: undefined,
            },
            form: {
                ipId: undefined,
                projectId: undefined,
                ipName: '',
                ipType: '',
                ipStatus: '',
                ipDate: '',
                userIdList: [],
                ossIdList: [],
            },
            formss: undefined,
        };
    },
    created() {
        this.createdData().then(() => {
            if (this.$props.ipId) {
                this.cheakIntellectual().then(() => {
                    console.log('0');
                    // 执行其他代码
                    console.log('this.form', this.form);

                });
            }
        });
    },
    watch: {
        ipId: {
            handler(newVal) {
                // 监听到memberid变化时，重新获取项目详情数据
                this.params.ipId = newVal;
                this.cheakIntellectual();

            },
            immediate: true, // 立即执行一次
        },
    },
    methods: {
        handleDateChange(date) {
            this.form.ipDate = date.substring(0, 10);
        },
        async createdData() {
            this.getProjectTree();
            this.getDeptAndUserList();
        },
        handleIdData(node) {
            this.person = node.ipUserVOList;
            this.projectId = node.projectId;
            this.responsibleproject = this.findPathByValue(this.projecttree, this.projectId);
            this.formss = this.getDeptAndUserList();
            this.person.forEach(item => {
                const path = this.findPathByValue(this.cascaderOptions, item.userId);
                if (path.length !== 0) {
                    // 将路径保存到 this.responsiblePerson 数组中
                    this.responsiblePerson.push(path);
                }
            });
        },
        findPathByValue(data, targetValue, path = []) {
            console.log('data',data,targetValue);

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
            // 未找到目标值
            return null;
        },

        // 按项目级别-项目搜索
        getProjectTree() {
            request({
                url: '/ip/getProjectMapping',
                method: 'get',
                params: this.header,
            })
                .then((resp) => {
                    this.projecttree = resp.data;
                })
                .catch((error) => {
                    console.error('获取用户数据时出错：', error);
                });
        },
        // 按部门-人员搜索
        async getDeptAndUserList() {
            // this.queryParam.pageNum = 1;
            // this.queryParam.pageSize = 10;
            await this.getDeptTree(); // 等待部门数据加载完成
            await this.getList(); // 等待用户数据加载完成
            this.cascaderOptions = this.adaptData(this.deptOptions);
            return this.cascaderOptions;
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
        async cheakIntellectual() {
            if (this.$props.ipId) {
                this.params.ipId = this.$props.ipId;
                try {
                    const resp = await request({
                        url: '/ip/getDetails',
                        method: 'get',
                        params: {
                            ipId: this.$props.ipId,
                        },
                    });
                    this.form = resp.data;
                    this.handleIdData(resp.data);
                    console.log('详情数据', this.form);
                } catch (error) {
                    console.error('获取数据时出错1：', error);
                }
            }
        },

        onSubmit() {
            if (this.$props.ipId) {
                this.EditIntellectual();
            } else {
                this.AddIntellectual();
            }
        },
        AddIntellectual() {
            this.form.projectId = this.responsibleproject[this.responsibleproject.length - 1];
            this.form.userIdList = this.responsiblePerson.map(subArray => subArray[subArray.length - 1]);
            this.form.ossIdList = this.ossids;

            request({
                url: '/ip/add',
                method: 'post',
                data: this.form
            })
                .then((resp) => {
                    console.log(resp);
                    this.$modal.msgSuccess("新增成功");
                    this.$refs.fujian.reset();
                    this.$emit('close-dialog'); // 触发一个事件通知父组件关闭弹窗

                })
                .catch(error => {
                    console.error("新增失败", error);
                    // 处理错误情况，例如显示错误提示
                });
            this.reset();
        },
        EditIntellectual() {

            this.form.projectId = this.responsibleproject[this.responsibleproject.length - 1];
            this.form.userIdList = this.responsiblePerson.map(subArray => subArray[subArray.length - 1]);
            this.form.ossIdList = this.ossids;
            // 请求修改接口
            request({
                url: '/ip/update',
                method: 'post',
                data: this.form,
            })
                .then((resp) => {
                    console.log(resp);
                    this.$modal.msgSuccess("修改成功");
                    this.$refs.fujian.reset();
                    this.$emit('close-dialog');
                })
                .catch((error) => {
                    console.error("修改失败", error);
                });
        },
        // 表单重置
        reset() {
            this.form = {
                ipId: undefined,
                projectId: undefined,
                ipName: '',
                ipType: '',
                ipStatus: '',
                ipDate: '',
                userIdList: [],
                ossIds: [],
            };
            this.ossids = [];
            this.fileList = [];
            this.responsibleproject = undefined;
            this.responsiblePerson = undefined;
        },
    },
};
</script>
