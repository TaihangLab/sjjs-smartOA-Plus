<template>
  <div>
    <el-form ref="dataForm" :inline="true" :model="myProjectFrom" class="demo-form-inline"
      style="margin-left: 30px; margin-top: 20px;margin-bottom: -10px;" v-show="showSearch">
      <el-form-item label="项目名称">
        <el-input v-model="myProjectFrom.projectName" size="mini" clearable placeholder="请输入项目名称"
          @keyup.enter.native="handleQuery"></el-input>
      </el-form-item>
      <el-form-item label="项目成员">
        <el-cascader v-model="myProjectFrom.responsiblePerson" :options="cascaderOptions" size="mini" clearable
          placeholder="请选择项目成员" @keyup.enter.native="handleQuery"></el-cascader>
      </el-form-item>
      <el-form-item label="项目立项时间">
        <el-date-picker v-model="myProjectFrom.projectStartDate" type="daterange" unlink-panels size="mini" clearable
          start-placeholder="请输入查询范围" end-placeholder="如：2000-01-01" @change="getList"
          :picker-options="pickerOptions"></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

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
    <Project :buttonType="1" :myProjectLook="myProjectLook" />
  </div>
</template>

<script>
import request from '@/utils/request';
import Project from "@/views/project/Project.vue";
import NewProject from "@/views/project/components/NewProject.vue";
import AddEvents from "@/views/project/components/AddEvents.vue";
import { listUser, deptTreeSelect } from "@/api/system/user";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default {
  name: "MyProject",
  components: { Project, NewProject, AddEvents },
  data() {
    return {
      myProjectLook: {},
      projectList: [],
      pageIndex: 1,
      pageSize: 10,
      total: 0,
      newProjectDialogVisible: false,
      eventsDialogVisibleAdd: false,
      showSearch: true,
      myProjectFrom: {
        projectNumber: "",
        projectName: "",
        responsiblePerson: "",
        projectStartDate: "",
      },
      // 菜单列表
      menuOptions: [],
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
    this.getprojectList();
    this.getDeptAndUserList();
  },
  methods: {
    getprojectList() {
      request({
        url: '/project/my/getMyList',
        method: 'post',
        data: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
        },
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
    async getDeptAndUserList() {
      await this.getDeptTree(); // 等待部门数据加载完成
      await this.getList(); // 等待用户数据加载完成
      this.cascaderOptions = this.adaptData(this.deptOptions);
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
      this.total = response.total;
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
