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
                <el-table-column label="操作" :resizable="false" align="center" min-width="180px" fixed="right">
                    <template v-slot="scope">
                        <el-button
                            size="mini"
                            type="text"
                            @click="lookEdit(scope.$index, scope.row)"
                        >
                            详情
                        </el-button>
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
                    </template>
                </el-table-column>
            </el-table>
            <!-- 查看打开的界面 -->
            <el-dialog
                :model="formLook"
                :visible.sync="dialogFormVisibleLook"
                title="项目详情"
                width="50%"
            >
                <el-tabs v-model="activeName" @tab-click="handleClick">
                    <el-tab-pane label="基本信息" name="first">
                        <el-radio-group v-model="size">
                          <el-radio label="">默认</el-radio>
                          <el-radio label="medium">中等</el-radio>
                          <el-radio label="small">小型</el-radio>
                          <el-radio label="mini">超小</el-radio>
                        </el-radio-group>

                        <el-descriptions class="margin-top" title="" :column="2" :size="size" border>
                          <el-descriptions-item>
                            <template slot="label">
                              <i class="el-icon-user"></i>
                              项目名称
                            </template>

                        </el-descriptions-item>
                        <el-descriptions-item>
                          <template slot="label">
                            <i class="el-icon-mobile-phone"></i>
                            项目负责人
                          </template>
                          18100000000
                        </el-descriptions-item>
                        <el-descriptions-item>
                          <template slot="label">
                            <i class="el-icon-location-outline"></i>
                            所属单位
                          </template>
                          苏州市
                        </el-descriptions-item>
                        <el-descriptions-item>
                          <template slot="label">
                            <i class="el-icon-location-outline"></i>
                            负责人电话
                          </template>
                          1234234
                        </el-descriptions-item>
                        <el-descriptions-item>
                          <template slot="label">
                            <i class="el-icon-office-building"></i>
                            负责人邮箱
                          </template>
                          江
                        </el-descriptions-item>
                        <el-descriptions-item>
                          <template slot="label">
                            <i class="el-icon-office-building"></i>
                            经办人
                          </template>
                          江
                        </el-descriptions-item>
                        <el-descriptions-item>
                          <template slot="label">
                            <i class="el-icon-office-building"></i>
                            经办人电话
                          </template>
                          江
                        </el-descriptions-item>
                        <el-descriptions-item>
                          <template slot="label">
                            <i class="el-icon-office-building"></i>
                            项目分类
                          </template>
                          江
                        </el-descriptions-item>
                        <el-descriptions-item>
                          <template slot="label">
                            <i class="el-icon-office-building"></i>
                            项目状态
                          </template>
                          江
                        </el-descriptions-item>
                        <el-descriptions-item>
                          <template slot="label">
                            <i class="el-icon-office-building"></i>
                            立项日期
                          </template>
                          江
                        </el-descriptions-item>
                        <el-descriptions-item>
                          <template slot="label">
                            <i class="el-icon-office-building"></i>
                            开始日期
                          </template>
                          江
                        </el-descriptions-item>
                        <el-descriptions-item>
                          <template slot="label">
                            <i class="el-icon-office-building"></i>
                            计划结项日期
                          </template>
                          江
                        </el-descriptions-item>
                        <el-descriptions-item>
                          <template slot="label">
                            <i class="el-icon-office-building"></i>
                            实际结项日期
                          </template>
                          江
                        </el-descriptions-item>
                        </el-descriptions>
                        <el-descriptions-item>
                          <template slot="label">
                            <i class="el-icon-office-building"></i>
                            批准经费
                          </template>
                          江
                        </el-descriptions-item>
                        <el-descriptions-item>
                          <template slot="label">
                            <i class="el-icon-office-building"></i>
                            成果形式
                          </template>
                          江
                        </el-descriptions-item>
                        <el-descriptions-item>
                          <template slot="label">
                            <i class="el-icon-office-building"></i>
                            备注
                          </template>
                          江
                        </el-descriptions-item>

                        <el-descriptions class="margin-top" title="详细信息" :column="2" :size="size" :border="border">
                          <template slot="extra">
                            <el-switch v-model="toggleDetails" active-color="#13ce66" inactive-color="#ff4949" />
                          </template>

                          <!-- 其他详细信息项，使用 v-if 控制显示/隐藏 -->
                          <el-descriptions-item v-if="toggleDetails" label="统计归属">kooriookami</el-descriptions-item>
                          <el-descriptions-item v-if="toggleDetails" label="统计年度">18100000000</el-descriptions-item>
                          <el-descriptions-item v-if="toggleDetails" label="一级学科">苏州市</el-descriptions-item>
                          <el-descriptions-item v-if="toggleDetails" label="社会经济目标">学校</el-descriptions-item>
                          <el-descriptions-item v-if="toggleDetails" label="项目来源">江苏省苏州市吴中区吴中大道 1188 号</el-descriptions-item>
                          <el-descriptions-item v-if="toggleDetails" label="研究类别">江苏省苏州市吴中区吴中大道 1188 号</el-descriptions-item>
                          <el-descriptions-item v-if="toggleDetails" label="合作形式">江苏省苏州市吴中区吴中大道 1188 号</el-descriptions-item>
                          <el-descriptions-item v-if="toggleDetails" label="国民经济行业">江苏省苏州市吴中区吴中大道 1188 号</el-descriptions-item>
                        </el-descriptions>
                    </el-tab-pane>
                    <el-tab-pane label="项目成员" name="second">配置管理</el-tab-pane>
                    <el-tab-pane label="项目经费" name="third">角色管理</el-tab-pane>
                </el-tabs>
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
export default {
    name: "ProjectList",
    data() {
        return {
            size: '',
            border: true,
            toggleDetails: true, // 控制详细信息项的显示/隐藏
            score: 0, //要修改的评分
            low_threshold: 4, //低分和中分分界点，此分数包含在低分中
            high_threshold: 7, //低分和高分分界点，此分数包含在高分中
            colors: ["#99A9BF", "#F7BA2A", "#EB5E26"],
            //搜索框
            dataFrom: {
                name: "",
            },
            //提交用户打分
            Score: {
                userId: 0,
                username: "",
                projectId: 0,
                score: 0,
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
        status: '待审核',
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
        //用户评分
        getScore(value) {
            this.score = value;
        },
        //提交用户评分
        getItemScore(item) {
            this.Score.score = this.score;
            this.Score.id = item.projectId;
            this.$http.post("/project/score", this.Score).then(() => {
                this.getDataList()
            });
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
        //查看按钮
        lookEdit(index, item) {
            this.dialogFormVisibleLook = true;
            this.formLook = item;
            console.log(this.formLook)
        },
       
    },
    mounted() {
        this.getDataList();
    },
};
</script>
