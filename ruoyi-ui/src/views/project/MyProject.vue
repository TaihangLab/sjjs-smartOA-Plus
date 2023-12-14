<template>
    <div>
        <CheakProject />
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
        <Project :buttonType="1"/>
    </div>
</template>

<script>
import CheckProject from "./CheckProject.vue";
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
            newProjectDialogVisible: false,
            eventsDialogVisibleAdd: false,
            showSearch: true,
        };
    },
    methods: {
        // 新增项目
        handleAdd() {
            this.newProjectDialogVisible = true;
        },
        handleDelete() {

        },
        handleExport() {

        },
        /** 搜索按钮操作 */
        handleQuery() {
            this.myProjectFrom.pageNum = 1;
            this.getDataList();
        },
        /** 重置按钮操作 */
        resetQuery() {
            // 清空数据模型中的值
            this.myProjectFrom.projectNumber = "";
            this.myProjectFrom.projectName = "";
            this.myProjectFrom.responsiblePerson = "";

            // 使用 resetFields 方法重置表单
            this.$refs.dataForm.resetFields();

            // 重置后重新查询
            this.handleQuery();
        },
    },
};
</script>
