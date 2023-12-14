<template>
    <el-form
        ref="dataForm"
        :inline="true"
        :model="myProjectFrom"
        class="demo-form-inline"
        style="margin-left: 30px; margin-top: 20px;"
    >
        <el-form-item label="承担课题名称">
            <el-input
                v-model="myProjectFrom.projectName"
                clearable
                placeholder="请输入承担课题名称"
                @keyup.enter.native="handleQuery"
            ></el-input>
        </el-form-item>
        <el-form-item label="负责课题">
            <el-input
                v-model="myProjectFrom.projectTask"
                clearable
                placeholder="请输入负责课题名称"
                @keyup.enter.native="handleQuery"
            ></el-input>
        </el-form-item>
        <el-form-item label="项目成员">
            <el-cascader
                v-model="myProjectFrom.responsiblePerson"
                :options="cascaderOptions"
                clearable
                placeholder="请选择项目成员"
                @keyup.enter.native="handleQuery"
            ></el-cascader>
        </el-form-item>
        <el-form-item label="有无合作单位">
            <el-cascader
                v-model="myProjectFrom.CoCompany"
                :options="cocompanyOptions"
                clearable
                placeholder="请选择有无合作单位"
                @keyup.enter.native="handleQuery"
            ></el-cascader>
        </el-form-item>
        <el-form-item label="立项日期">
            <el-date-picker
                v-model="myProjectFrom.projectStartDate"
                type="daterange"
                unlink-panels
                clearable
                start-placeholder="请输入查询范围"
                end-placeholder="如：2000-01-01"
                @change="getList"
                :picker-options="pickerOptions"
            ></el-date-picker>
        </el-form-item>
        <el-form-item label="项目计划验收时间">
            <el-date-picker
                v-model="myProjectFrom.projectEndDate"
                type="daterange"
                unlink-panels
                clearable
                start-placeholder="请输入查询范围"
                end-placeholder="如：2000-01-01"
                @change="getList"
                :picker-options="pickerOptions"
            ></el-date-picker>
        </el-form-item>
        <el-form-item label="项目级别">
            <el-cascader
                v-model="myProjectFrom.projectLevel"
                :options="levelOptions"
                clearable
                placeholder="请选择项目级别"
            ></el-cascader>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
            <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
        </el-form-item>
    </el-form>
</template>


<script>
import { listUser, deptTreeSelect } from "@/api/system/user";
export default {
    name: "CheakProject",
    data() {
        return {
            myProjectFrom: {
                projectName: "",
                responsiblePerson: "",
                projectStartDate: "",
                projectLevel: "",
                projectTask: "",
                projectEndDate: "",
                CoCompany: "",
            },
            levelOptions: [
                {
                    value: '0',
                    label: '国家级'
                },
                {
                    value: '1',
                    label: '省级'
                },
                {
                    value: '2',
                    label: '企业项目'
                }
            ],
            cocompanyOptions: [
                {
                    value: '0',
                    label: '有'
                },
                {
                    value: '1',
                    label: '无'
                },
            ],
            cascaderOptions: [],
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
    created() {
        this.getDeptAndUserList();
    },
    methods: {
        async getDeptAndUserList() {
            console.log('1', this.cascaderOptions);
            await this.getDeptTree(); // 等待部门数据加载完成
            await this.getList(); // 等待用户数据加载完成
            this.cascaderOptions = this.adaptData(this.deptOptions);
        },
        /** 查询部门下拉树结构 */
        async getDeptTree() {
            const response = await deptTreeSelect();
            this.deptOptions = response.data;
            console.log('1', this.deptOptions);
        },
        /** 查询用户列表 */
        async getList() {
            const response = await listUser();
            this.userList = response.rows;
            this.total = response.total;
            console.log('2', this.total);
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
    },
}
</script>

