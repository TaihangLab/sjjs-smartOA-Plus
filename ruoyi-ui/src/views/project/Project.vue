<template>
    <el-card class="box-card" style="margin: auto;">
        <div>
            <!-- 角色数据表单 -->
            <el-table ref="multipleTable" :data="dataList" border style="width: 100%" :row-style="{height: '50px'}"
                      :cell-style="{padding:'0px'}">
                <el-table-column type="selection" resizable="false" align="center" width="40"></el-table-column>
                <el-table-column label="#" :resizable="false" align="center"  prop="projectId" width="80">
                </el-table-column>
                <el-table-column label="项目编号" :resizable="false" align="center"  prop="projectId" width="80">
                </el-table-column>
                <el-table-column label="项目名称" :resizable="false" align="center"  prop="project.name" width="150">
                </el-table-column>
                <el-table-column label="负责人" :resizable="false" align="center"  prop="user.username" width="150">
                </el-table-column>
                <el-table-column label="所属单位" :resizable="false" align="center"  prop="project.name" width="150">
                </el-table-column>
                <el-table-column label="负责人电话" :resizable="false" align="center"  prop="user.username" width="150">
                </el-table-column>
                <el-table-column label="经办人" :resizable="false" align="center"  prop="user.username" width="150">
                </el-table-column>
                <el-table-column label="经办人电话" :resizable="false" align="center"  prop="user.username" width="150">
                </el-table-column>
                <el-table-column label="项目分类" :resizable="false" align="center"  prop="project.type" width="110">
                </el-table-column>
                <el-table-column label="负责人邮箱" :resizable="false" align="center"  prop="user.username" width="150">
                </el-table-column>
                <el-table-column label="立项日期" :resizable="false" align="center"  prop="createTime" width="170">
                </el-table-column>
                <el-table-column label="开始日期" :resizable="false" align="center"  prop="createTime" width="170">
                </el-table-column>
                <el-table-column label="操作" :resizable="false" align="center" min-width="230px" fixed="right">
                    <template v-slot="scope">
                        <el-button
                            size="mini"
                            type="text"
                            icon="el-icon-tickets"
                            @click="lookEdit(scope.$index, scope.row)"
                        >详情</el-button>
                        <el-button
                            size="mini"
                            type="text"
                            icon="el-icon-edit"
                            @click="handleUpdate(scope.row)"
                            v-hasPermi="['system:role:edit']"
                        >修改</el-button>
                        <el-button
                            size="mini"
                            type="text"
                            icon="el-icon-delete"
                            @click="handleDelete(scope.row)"
                            v-hasPermi="['system:role:remove']"
                        >删除</el-button>
                        <el-dropdown size="mini" @command="handleDropdownCommand">
                          <el-button size="mini" type="text" icon="el-icon-reading">大事记</el-button>
                          <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item command="view" icon="el-icon-view">查看</el-dropdown-item>
                          </el-dropdown-menu>
                        </el-dropdown>
                    </template>
                </el-table-column>
            </el-table>
            <!-- 详情打开的界面 -->
            <el-dialog
              :model="formLook"
              :visible.sync="dialogFormVisibleLook"
              width="50%"
            >
               <ProjectDetail 
               :visible.sync="dialogFormVisibleLook"
               :formLook="formLook"
               ></ProjectDetail>
            </el-dialog>
            <!-- 大事记查看打开的界面 -->
            <el-dialog
              :visible.sync="eventsDialogVisibleLook"
              width="50%"
            >
              <CheckEvents
              :visible.sync="eventsDialogVisibleLook"
              ></CheckEvents>
            </el-dialog>
            <!-- 页号 -->
            <el-pagination
                :current-page="pageIndex"
                :page-size="pageSize"
                :page-sizes="[5, 10, 20, 50, 100]"
                :total="totalPage"
                layout="total ,sizes,prev,pager,next,jumper"
                style="margin-top: 30px"
                @size-change="sizeChangeHandle"
                @current-change="CurrentChangeHandle"
            >
            </el-pagination>
        </div>
    </el-card>
</template>
<script>
import ProjectDetail from "@/views/project/components/ProjectDetail.vue";
import CheckEvents from "@/views/project/components/CheckEvents.vue";

export default {
    name: "ProjectList",
    components: {
    ProjectDetail,
    CheckEvents
  },
    data() {
        return {
            rowCenter:{
              "text-align":"center"
            },
            size: '',
            border: true,
            toggleDetails: true, // 控制详细信息项的显示/隐藏
            //搜索框
            dataFrom: {
                name: "",
            },
            //新增
            form: {
                project: {
                    name: "",
                    content: "",
                    type: "",
                    money: "",
                    mobile: "",
                },
                user: {
                    username: "",
                },
            },
            //查看
            formLook: {
                project: {},
                user: {},
            },
            //编辑
            formChange: {
                id: "",
                project: {
                    id: "",
                    name: "",
                    content: "",
                    type: "",
                    money: "",
                    remark: "",
                },
            },
            dataList: [], //页面展示的数据集合
            pageIndex: 1,
            pageSize: 10,
            totalPage: 0,
            begin: 0,
            end: this.pageSize - 1,
            dialogFormVisible: false, //默认关闭新建用户界面
            dialogFormVisibleChange: false, //默认关闭编辑用户界面
            dialogFormVisibleLook: false,
            eventsDialogVisibleLook: false,
            dataListFrom: "getDataList",//当前数据来源于搜索还是全局
            activeName: 'first',
        };
    },
    created() {
    // 用于测试目的的模拟数据
    const mockData = [
      {
        projectId: 1,
        project: { id: 1, name: '项目A', type: '类型A', money: 1000, remark: 'Lorem ipsum' },
        user: { id: 1, username: '用户1', name: '用户一' },
        createTime: '2023-01-01',
        updateTime: '2023-01-02',
      },
      // 根据需要添加更多的模拟数据
    ];

    // 将模拟数据分配给 dataList
    this.dataList = mockData;
  },
    methods: {
        //改变数组大小
        sizeChangeHandle(val) {
            this.pageSize = val;
            this.SizeOrCurrentChangeAfter();
        },
        //改变当前页号
        CurrentChangeHandle(val) {
            this.pageIndex = val;
            this.SizeOrCurrentChangeAfter();
        },
        //在更改数组大小或者页号前，判断数据来源
        SizeOrCurrentChangeAfter() {
            if (this.dataListFrom === "getDataList")
                this.getDataList();
            else this.getDataListByName();
        },
        //检查创建项目时是否有未填项
        checkItemBeforeInsert() {
            if (this.form.project.money === "") {
                this.$confirm("当前申请资金为0,是否继续创建项目？", "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning",
                }).then(() => {
                    this.handleInsert()
                }).catch(() => {
                    this.$message({
                        type: "info",
                        message: "已取消创建项目",
                    });
                });
            } else {
                this.handleInsert()
            }
        },
        //新增页面的确认键
        handleInsert() {
            this.$http.post("/item/insert", this.form).then(() => {
                this.dialogFormVisible = false; //关闭窗口
                this.getDataList();
            });
        },
        //查询所有数据
        getDataList() {
            this.dataListFrom = "getDataList";
            const pageInfo = this.$getPageInfo(this.pageSize, this.pageIndex)
            this.$http.post("/item/getList", pageInfo).then((res) => {
                this.cutDataList(res);
            });
        },
        //查询单条数据
        getDataListByName() {
            const name = this.dataFrom.name
            if (name !== "") {
                const data = {
                    name: name,
                    pageBo: this.$getPageInfo(this.pageSize, this.pageIndex)
                }
                this.dataListFrom = "getDataListByName";
                this.$http.post("/item/getList/search", data).then((res) => {
                    this.cutDataList(res);
                });
            } else this.getDataList();
        },
        cutDataList(res) {
            const data = this.$cutPageDataList(res)
            this.dataList = data.dataList
            this.totalPage = data.totalPage
        },
        //详情按钮
        lookEdit(index, item) {
            this.dialogFormVisibleLook = true;
            this.formLook = item;
        },
        handleDropdownCommand(command) {
          if (command === 'view') {
            this.eventsDialogVisibleLook = true; // 处理查看操作
          } else if (command === 'add') {
            // 处理新增操作，可以添加相应的逻辑
            this.eventsDialogVisibleAdd = true;// 处理新增操作
          }
        },
    },
    mounted() {
        this.getDataList();
    },
};
</script>

