<template>
    <div>
        <CheakProject @query-request="handleQueryRequest" v-show="showSearch"></CheakProject>
        <el-row :gutter="10" class="mb8" style="margin-left: 20px;margin-top: 10px;">
            <el-col :span="1.5">
                <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd">新增
                </el-button>
            </el-col>
            <right-toolbar :showSearch.sync="showSearch"></right-toolbar>
        </el-row>
        <!-- 新增项目弹出的对话框-->
        <el-dialog title="新增项目" :visible.sync="newProjectDialogVisible" fullscreen>
            <NewProject :visible.sync="newProjectDialogVisible" @refresh="refreshList"></NewProject>
        </el-dialog>
        <Project  :buttonType="1"
                  :myProjectLook="myProjectLook"
                  :projectListLook="projectListLook"
                  :total="total"
                  :queryParam="queryParam"
                  @reloadProjectList="getprojectList"/>
    </div>
</template>

<script>
import request from '@/utils/request';
import Project from "@/views/project/Project.vue";
import NewProject from "@/views/project/components/NewProject.vue";
import AddEvents from "@/views/project/components/AddEvents.vue";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";
import CheakProject from "./CheckProject.vue";

export default {
    name: "MyProject",
    components: {CheakProject, Project, NewProject, AddEvents},
    data() {
        return {
            projectKey: 0,
            queryParams: {
                pageNum: 2,
                pageSize: 5,
            },
            queryParam: {
                pageNum: 1,
                pageSize: 10,
            },
            projectListLook: [],
            myProjectLook: [],
            projectList: [],
            total: 0,
            newProjectDialogVisible: false,
            eventsDialogVisibleAdd: false,
            showSearch: true,
        };
    },
    created() {
        this.getprojectList();
    },
    methods: {
        reloadProjectList(queryParam){
            this.queryParam = queryParam;
            this.getprojectList(); // 调用原来的获取数据方法
            this.projectKey += 1; // 修改 key 强制组件重新加载
        },
        handleQueryRequest(queryParams) {
            // 执行后端查询等操作
            if (queryParams && Object.keys(queryParams).length > 0) {
                this.queryParams = queryParams;
            }
            this.queryParam.pageNum = 1;
            this.getprojectList();
        },
        getprojectList() {
            request({
                url: '/project/my/getMyList',
                method: 'post',
                data: this.queryParams,
                params: this.queryParam,
            })
                .then((resp) => {
                    this.$set(this, 'projectListLook', resp.rows);
                    this.$set(this, 'total', resp.total);
                    // this.myProjectLook = resp.rows;
                    // this.total = resp.total;
                })
                .catch((error) => {
                    console.error('获取数据时出错：', error);
                });
        },
        // 新增项目
        handleAdd() {
            this.newProjectDialogVisible = true;
        },
        refreshList() {
            this.$nextTick(() => {
                this.getprojectList();
            });
        },
    },
};
</script>
