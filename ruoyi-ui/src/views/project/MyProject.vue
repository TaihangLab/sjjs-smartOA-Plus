<template>
  <div>
    <el-form
      ref="dataForm"
      :inline="true"
      :model="dataFrom"
      class="demo-form-inline"
      style="margin-left: 30px; margin-top: 20px;"
    >
      <el-form-item label="项目编号">
        <el-input
          v-model="dataFrom.projectNumber"
          clearable
          placeholder="请输入项目编号"
          @keyup.enter.native="handleQuery"
        ></el-input>
      </el-form-item>
      <el-form-item label="项目名称">
        <el-input
          v-model="dataFrom.projectName"
          clearable
          placeholder="请输入项目名称"
          @keyup.enter.native="handleQuery"
        ></el-input>
      </el-form-item>
      <el-form-item label="负责人">
        <el-input
          v-model="dataFrom.responsiblePerson"
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

    <el-row :gutter="10" class="mb8" style="margin-left: 20px;">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:role:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:role:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:role:export']"
        >导入</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <Project />
  </div>
</template>

<script>
import Project from "@/views/project/Project.vue";

export default {
  name: "MyProject",
  components: { Project },
  data() {
    return {
      dataFrom: {
        projectNumber: "",
        projectName: "",
        responsiblePerson: "",
      },
    };
  },
  methods: {
      /** 搜索按钮操作 */
    handleQuery() {
      this.dataFrom.pageNum = 1;
      this.getDataList();
    },
    /** 重置按钮操作 */
    resetQuery() {
  // 清空数据模型中的值
      this.dataFrom.projectNumber = "";
      this.dataFrom.projectName = "";
      this.dataFrom.responsiblePerson = "";

      // 使用 resetFields 方法重置表单
      this.$refs.dataForm.resetFields();

      // 重置后重新查询
      this.handleQuery();
    },
  },
};
</script>
