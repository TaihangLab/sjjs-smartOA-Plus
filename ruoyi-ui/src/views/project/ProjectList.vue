<template>
    <div>
        <CheckProject />
        <Project/>
    </div>
</template>

<script>
import CheckProject from "./CheckProject.vue";
import Project from "@/views/project/Project.vue";
import {listUser, deptTreeSelect} from "@/api/system/user";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default {
    name: "ProjectList",
    components: {CheckProject, Project},
    data() {
        return {

        };
    },

    methods: {
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
}
</script>

