<template>
    <div >
        <div style="margin-top: 10px;"></div>
        <el-table v-loading="loading" :data="userList"  style=" margin: 0; padding: 0;">
            <el-table-column label="用户名称" align="center" key="nickName" prop="nickName" v-if="columns[0].visible" :show-overflow-tooltip="true" />
            <el-table-column label="邮箱" align="center" key="email" prop="email" v-if="columns[1].visible" :show-overflow-tooltip="true" />
            <el-table-column label="手机号码" align="center" key="phonenumber" prop="phonenumber" v-if="columns[2].visible" :show-overflow-tooltip="true" />
            <el-table-column label="所属部门" align="center" key="deptName" prop="deptName" v-if="columns[3].visible" width="120" />
            <el-table-column label="项目角色" align="center"  v-if="columns[4].visible" width="120" />
        </el-table>
    </div>
</template>
<script>

import request from '@/utils/request';
export default {
    props: {
        projectid: String,
    },
    name: "User",
    data() {
        return {
            // 遮罩层
            loading: true,
            // 用户表格数据
            userList: [],
            // 查询参数
            projectId: 0,

            // 列信息
            columns: [
                { key: 0, label: `用户名称`, visible: true },
                { key: 1, label: `邮箱`, visible: true },
                { key: 2, label: `电话号码`, visible: true },
                { key: 3, label: `所属部门`, visible: true },
                { key: 4, label: `项目角色`, visible: true },
            ],
        };
    },
    created() {
        this.projectpepole();
    },
    watch: {
        // 监听 projectid 的变化，一旦变化就调用 projectpepole 方法
        projectid: 'projectpepole',
    },
    methods:{
        projectpepole(){
            console.log("传过来的项目123", this.$props.projectid);
            // 使用正确的用户列表接口，假设接口为 /user/list
            request({
                url: '/project/list/getDetails',
                method: 'get',
                params: {
                    projectId: this.$props.projectid,
                },
            })
                .then((resp) => {
                    // 处理获取的用户数据
                    console.log('Response Data:', resp);
                    this.userList = resp.data.projectUserVoList;
                    this.loading = false; // 关闭 loading 遮罩层
                })
                .catch((error) => {
                    console.error('获取用户数据时出错：', error);
                    this.loading = false; // 处理错误，关闭 loading 遮罩层
                });
            console.log("项目成员", resp.projectUserVoList);
        },
    },
};
</script>
