<template>
    <div >
        <div style="margin-top: 10px;"></div>
        <el-table v-loading="loading" :data="userList"  style=" margin: 0; padding: 0;">
            <el-table-column label="用户名称" align="center" key="userName" prop="userName" v-if="columns[0].visible" :show-overflow-tooltip="true" />
            <el-table-column label="用户昵称" align="center" key="nickName" prop="nickName" v-if="columns[1].visible" :show-overflow-tooltip="true" />
            <el-table-column label="部门" align="center" key="deptName" prop="dept.deptName" v-if="columns[2].visible" :show-overflow-tooltip="true" />
            <el-table-column label="手机号码" align="center" key="phonenumber" prop="phonenumber" v-if="columns[3].visible" width="120" />
        </el-table>
    </div>
</template>
<script>
import { listUser, getUsers,} from "@/api/system/user";

export default {
    name: "User",
    data() {
        return {
            // 遮罩层
            loading: true,
            // 用户表格数据
            userList: null,
            // 部门名称
            deptName: undefined,
            // 查询参数
            queryParams: {
                userId: undefined,
            },
            // 列信息
            columns: [
                { key: 0, label: `用户编号`, visible: true },
                { key: 1, label: `用户名称`, visible: true },
                { key: 2, label: `用户昵称`, visible: true },
                { key: 3, label: `部门`, visible: true },
            ],
        };
    },
    created() {
        this.getList();
    },
    methods: {
        /** 查询用户列表 */
        getList() {
            this.loading = true;
            listUser(this.queryParams).then(response => {
                    this.userList = response.rows;
                    this.loading = false;
                    console.log("fujian 组件接收到的附件数据:", this.userList);
                }
            );
        },
    }
};
</script>
