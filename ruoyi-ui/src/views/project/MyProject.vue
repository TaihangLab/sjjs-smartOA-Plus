<template>
    <div>
        <CheakProject @query-request="handleQueryRequest"></CheakProject>
        <el-row :gutter="10" class="mb8" style="margin-left: 20px;margin-top: 10px;">
            <el-col :span="1.5">
                <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd">新增
                </el-button>
            </el-col>
            <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>

        <!-- 新增项目弹出的对话框-->
        <el-dialog title="新增项目" :visible.sync="newProjectDialogVisible" fullscreen>
            <!-- :before-close="handleClose">-->
            <NewProject :visible.sync="newProjectDialogVisible"></NewProject>
        </el-dialog>
        <!-- 大事记新增打开的界面 -->
        <el-dialog title="大事记" :visible.sync="eventsDialogVisibleAdd" width="50%">
            <AddEvents :visible.sync="eventsDialogVisibleAdd">
            </AddEvents>
        </el-dialog>
        <Project :buttonType="1" :myProjectLook="myProjectLook"/>
    </div>
</template>

<script>
import request from '@/utils/request';
import Project from "@/views/project/Project.vue";
import NewProject from "@/views/project/components/NewProject.vue";
import AddEvents from "@/views/project/components/AddEvents.vue";
import {listUser, deptTreeSelect} from "@/api/system/user";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";
import CheakProject from "./CheckProject.vue";

export default {
    name: "MyProject",
    components: {CheakProject, Project, NewProject, AddEvents},
    data() {
        return {
            queryParam: {
                pageNum: 1,
                pageSize: 5,
            },
            myProjectLook: {},
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
        handleQueryRequest(queryParams) {
            // 执行后端查询等操作
            if (queryParams && Object.keys(queryParams).length > 0) {
                this.queryParam = queryParams;
            }
            console.log('projectlistquery', this.queryParam);
            this.getprojectList();
        },
        getprojectList() {
            request({
                url: '/project/my/getMyList',
                method: 'post',
                data: this.queryParam,
            })
                .then((resp) => {
                    this.myProjectLook = resp.rows;
                    this.total = resp.total;
                    console.log('项目', this.myProjectLook);
                })
                .catch((error) => {
                    console.error('获取数据时出错：', error);
                });
        },
        // 新增项目
        handleAdd() {
            this.newProjectDialogVisible = true;
        },
    },
};
</script>
