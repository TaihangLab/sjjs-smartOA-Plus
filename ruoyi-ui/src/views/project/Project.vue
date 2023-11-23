<template>
    <el-card class="box-card" style="margin: auto;">
        <div>
            <!-- 角色数据表单 -->
            <el-table ref="multipleTable" :data="dataList" border style="width: 100%" :row-style="{height: '50px'}"
                      :cell-style="{padding:'0px'}">
                <!--        <el-table-column type="selection" width="39"></el-table-column>-->
                <el-table-column label="项目编号" :resizable="false" align="center"  prop="projectId" width="80">
                </el-table-column>
                <el-table-column label="项目名称" :resizable="false" align="center"  prop="project.name" width="150">
                </el-table-column>
                <el-table-column label="项目类型" :resizable="false" align="center"  prop="project.type" width="110">
                </el-table-column>
                <el-table-column label="项目审核状态" :resizable="false" align="center"  prop="status" width="120">
                    <template v-slot="scope">
                        <span>{{ scope.row.status === null ? "没有分配审核" : scope.row.status }}</span>
                    </template>
                </el-table-column>
                <el-table-column label="项目创建人" :resizable="false" align="center"  prop="user.username" width="150">
                </el-table-column>
                <el-table-column label="创建时间" :resizable="false" align="center"  prop="createTime" width="170">
                </el-table-column>
                <el-table-column
                    label="最近一次的修改时间"
                    :resizable="false"
                    align="center"
                    prop="updateTime"
                    width="180"
                >
                </el-table-column>
                <el-table-column label="操作" :resizable="false" align="center" min-width="110px">
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
                <el-descriptions title="项目信息">
                    <el-descriptions-item label="项目编号">
                        {{ this.formLook.project.id }}
                    </el-descriptions-item>
                    <el-descriptions-item label="项目名称">
                        {{ this.formLook.project.name }}
                    </el-descriptions-item>
                    <el-descriptions-item label="项目类型">
                        {{ this.formLook.project.type }}
                    </el-descriptions-item>
                    <el-descriptions-item label="项目状态">
                        {{ this.formLook.status === null ? "没有分配审核" : this.formLook.status }}
                    </el-descriptions-item>
                    <el-descriptions-item label="项目创建人">
                        <el-tag size="small">{{ this.formLook.user.name }}</el-tag>
                    </el-descriptions-item>
                    <el-descriptions-item label="项目说明"
                    >{{ this.formLook.project.remark }}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions column:2>
                    <el-descriptions-item label="创建时间"
                    >{{ this.formLook.createTime }}
                    </el-descriptions-item>
                    <el-descriptions-item label="申请资金"
                    >{{ this.formLook.project.money }}
                    </el-descriptions-item>
                </el-descriptions>
                <el-descriptions>
                    <el-descriptions-item label="最近一次修改时间" prop="updateTime"
                    >{{ this.formLook.updateTime }}
                    </el-descriptions-item>
                </el-descriptions>

                <el-divider></el-divider>
                <el-descriptions title="项目创建者信息">
                    <el-descriptions-item label="账号">
                        {{ this.formLook.user.username }}
                    </el-descriptions-item>
                    <el-descriptions-item label="姓名">
                        <el-tag size="small">{{ this.formLook.user.name }}</el-tag>
                    </el-descriptions-item>
                    <el-descriptions-item label="邮箱"
                    >{{ this.formLook.user.email }}
                    </el-descriptions-item>
                    <el-descriptions-item label="手机号码"
                    >{{ this.formLook.user.mobile }}
                    </el-descriptions-item>
                    <el-descriptions-item label="账号状态"
                    >{{ this.formLook.user.status === 1 ? "正常" : "禁用" }}
                    </el-descriptions-item>
                </el-descriptions>

                <!--                新增项目状态-->
                <el-divider></el-divider>
                <el-descriptions title="项目状态" :column="1">
                    <el-descriptions-item label="当前状态">
                        {{ this.formLook.status === null ? "没有分配审核" : this.formLook.status }}
                    </el-descriptions-item>

                    <el-descriptions-item label="审核信息"
                                          v-if="this.formLook.status&&this.formLook.status!=='未分配审核'"
                                          labelStyle="white-space:nowrap;"
                                          contentStyle="word-break:break-all; white-space:nowrap;overflow: auto;">

                        <el-tag size="small"
                                v-for="item in auditList"
                                :type="item.type"
                                style="margin-right: 5px;"
                        >
                            {{ item.name }}:
                            {{ item.process }}
                        </el-tag>

                    </el-descriptions-item>
                </el-descriptions>
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
        createTime: '2023-01-01 12:00:00',
        updateTime: '2023-01-02 14:30:00',
      },
      // 根据需要添加更多的模拟数据
    ];

    // 将模拟数据分配给 dataList
    this.dataList = mockData;
  },
    computed: {
        auditList() {
            if (!this.formLook.processList) {
                return [];
            }
            let list = [];
            for (const i of this.formLook.processList) {
                let obj = {}
                switch (i.process) {
                    case "审核通过":
                        obj.type = "success";
                        break;
                    case "审核未通过":
                        obj.type = "danger";
                        break;
                    case "未审核":
                        obj.type = "info";
                        break;
                }
                obj.process = i.process;
                obj.name = i.user.name;
                list.push(obj)
            }
            return list;
        }
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
