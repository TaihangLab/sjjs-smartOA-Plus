<template>
  <div>
    <el-form
      ref="dataForm"
      :inline="true"
      :model="myProjectFrom"
      class="demo-form-inline"
      style="margin-left: 30px; margin-top: 20px;"
    >
      <el-form-item label="项目编号">
        <el-input
          v-model="myProjectFrom.projectNumber"
          clearable
          placeholder="请输入项目编号"
          @keyup.enter.native="handleQuery"
        ></el-input>
      </el-form-item>
      <el-form-item label="项目名称">
        <el-input
          v-model="myProjectFrom.projectName"
          clearable
          placeholder="请输入项目名称"
          @keyup.enter.native="handleQuery"
        ></el-input>
      </el-form-item>
      <el-form-item label="负责人">
        <el-input
          v-model="myProjectFrom.responsiblePerson"
          clearable
          placeholder="请输入负责人"
          @keyup.enter.native="handleQuery"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <Project />
  </div>
</template>

<script>
import Project from "@/views/project/Project.vue";

export default {
name:"ProjectList",
components: { Project },
data() {
    return {
        myProjectFrom: {
        projectNumber: "",
        projectName: "",
        responsiblePerson: "",
      },
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

