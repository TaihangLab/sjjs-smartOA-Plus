<template>
    <el-card class="box-card" style="margin: auto;">
        <div>
            <el-table ref="multipleTable" :data="projectList" border style="width: 100%" :row-style="{ height: '50px' }"
                :cell-style="{ padding: '0px' }">
                <el-table-column type="selection" :resizable="false" align="center" width="40"></el-table-column>
                <el-table-column label="项目牵头单位" :resizable="false" align="center" prop="leadingUnit" width="180">
                </el-table-column>
                <el-table-column label="承担课题名称" :resizable="false" align="center" prop="assignedSubjectSection" width="150">
                </el-table-column>
                <el-table-column label="项目任务书编号" :resizable="false" align="center" prop="projectAssignmentSerialNo"
                    width="130">
                </el-table-column>
                <el-table-column label="级别（国家级、省级、企业项目）" :resizable="false" align="center" prop="projectLevel" width="110">
                </el-table-column>
                <el-table-column label="负责课题" :resizable="false" align="center" prop="assignedSubjectSection" width="150">
                </el-table-column>
                <el-table-column label="项目推进情况" :resizable="false" align="center" prop="projectProgressStatus" width="150">
                </el-table-column>
                <el-table-column label="合作单位" :resizable="false" align="center" prop="hasCooperativeUnit" width="150">
                </el-table-column>
                <el-table-column label="立项时间" :resizable="false" align="center" prop="projectEstablishTime" width="170">
                </el-table-column>
                <el-table-column label="项目计划验收时间" :resizable="false" align="center" prop="projectScheduledCompletionTime"
                    width="170">
                </el-table-column>
                <el-table-column label="操作" :resizable="false" align="center" min-width="230px" fixed="right">
                    <template v-slot="scope">
                        <el-button size="mini" type="text" icon="el-icon-tickets"
                            @click="lookEdit(scope.$index, scope.row)">详情
                        </el-button>
                        <el-button size="mini" type="text" icon="el-icon-edit" v-if="buttonType === 1"
                            @click="handleUpdate(scope.row)">修改
                        </el-button>
                        <el-button size="mini" type="text" icon="el-icon-delete" v-if="buttonType === 1"
                            @click="handleDelete(scope.row)">删除
                        </el-button>
                        <el-button v-if="buttonType !== 1" size="mini" type="text" icon="el-icon-reading"
                            @click="handleDropdownCommand({ 'command': 'view', 'row': scope.row })">大事记</el-button>
                        <el-dropdown v-else size="mini" @command="handleDropdownCommand">
                            <el-button size="mini" type="text" icon="el-icon-reading">大事记</el-button>
                            <el-dropdown-menu v-slot="dropdown">
                                <el-dropdown-item :command="{ 'command': 'view', 'row': scope.row }"
                                    icon="el-icon-view">查看</el-dropdown-item>
                                <!-- 根据 buttonType 的值有条件地渲染 "新增" 按钮 -->
                                <el-dropdown-item v-if="buttonType === 1" :command="{ 'command': 'add', 'row': scope.row }"
                                    icon="el-icon-document-add">新增</el-dropdown-item>
                            </el-dropdown-menu>
                        </el-dropdown>
                    </template>
                </el-table-column>
            </el-table>
            <!-- 详情打开的界面 -->
            <el-dialog :model="formLook" :visible.sync="dialogFormVisibleLook" width="50%">
                <ProjectDetail :visible.sync="dialogFormVisibleLook" :formLook="formLook"></ProjectDetail>
            </el-dialog>
            <!-- 大事记查看打开的界面 -->
            <el-dialog :visible.sync="eventsDialogVisibleLook" width="50%" :key="refreshEventsPage"
                @open="handleEventsDialogOpen" :modal="false">
                <div style="max-height: 600px; overflow-y: auto;">
                    <CheckEvents :projectId="projectId" :visible.sync="eventsDialogVisibleLook" :buttonType="buttonType">
                    </CheckEvents>
                </div>
            </el-dialog>
            <!--新增大事记-->
            <el-dialog :visible.sync="eventsDialogVisibleAdd" width="50%">
                <AddEvents :projectId="projectId" :visible.sync="eventsDialogVisibleAdd" @close-dialog="closeEventsDialog">
                </AddEvents>
            </el-dialog>
            <!-- 页号 -->
            <el-pagination :current-page="pageIndex" :page-size="pageSize" :page-sizes="[5, 10, 20, 50, 100]" :total="total"
                layout="total ,sizes,prev,pager,next,jumper" style="margin-top: 30px" @size-change="sizeChangeHandle"
                @current-change="CurrentChangeHandle">
            </el-pagination>
        </div>
    </el-card>
</template>
<script>
import ProjectDetail from "@/views/project/components/ProjectDetail.vue";
import CheckEvents from "@/views/project/components/CheckEvents.vue";
import AddEvents from "@/views/project/components/AddEvents.vue";

export default {
    name: "Projec",
    props: {
        projectListLook: {
            type: Array,
            required: true,
        },
        myProjectLook: {
            type: Array,
            required: true,
        },
        buttonType: {
            type: Number,
        }
    },
    components: {
        ProjectDetail,
        CheckEvents,
        AddEvents,
    },
    data() {
        return {
            projectId: '',
            rowCenter: {
                "text-align": "center"
            },
            size: '',
            border: true,
            visible: true,
            refreshEventsPage: false,
            toggleDetails: true, // 控制详细信息项的显示/隐藏
            eventsDialogKey: 0,
            //搜索框
            dataFrom: {
                name: "",
            },
            //新增
            form: {
                projectName: "",
                projectManager: "",
                projectStatus: "",
                projectInfo: "",
                projectType: "",
                startTime: "",
                establishTime: "",
            },
            //查看
            formLook: {
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
            projectList: [],
            pageIndex: 1,
            pageSize: 10,
            total: 0,
            begin: 0,
            end: this.pageSize - 1,
            dialogFormVisible: false, //默认关闭新建用户界面
            dialogFormVisibleChange: false, //默认关闭编辑用户界面
            dialogFormVisibleLook: false,
            eventsDialogVisibleLook: false,
            eventsDialogVisibleAdd: false,
            dataListFrom: "getDataList",//当前数据来源于搜索还是全局
            activeName: 'first',
        };
    },
    created() {

    },
    methods: {
        // 关闭弹窗的方法
        closeEventsDialog() {
            this.eventsDialogVisibleAdd = false;
        },
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
            console.log('formLook:', this.formLook);
            this.dialogFormVisibleLook = true;
            this.formLook = item;
        },
        handleDropdownCommand(command) {
            if (command.command === 'view') {
                this.eventsDialogVisibleLook = true;
                this.projectId = command.row.projectId;
            } else if (command.command === 'add') {
                // 处理新增操作，可以添加相应的逻辑
                this.projectId = command.row.projectId;
                this.eventsDialogVisibleAdd = true; // 处理新增操作
            }
        },
        handleEventsDialogOpen() {
            // 切换刷新标志位
            this.refreshEventsPage = !this.refreshEventsPage;
        },
    },
    // mounted() {
    //     // 判断按钮类型，设置当前数据来源
    //     if (this.buttonType === 1) {
    //         this.$set(this, 'projectList', [...this.projectListLook]);
    //     } else {
    //         this.$set(this, 'projectList', [...this.myProjectLook]);
    //     }
    //     console.log('Current List:', this.projectList);
    // },
    // watch: {
    //     // 监听按钮类型的变化，根据不同类型更新表格数据
    //     buttonType(newVal) {
    //         if (newVal === 1) {
    //             this.$set(this, 'projectList', [...this.projectListLook]);
    //         } else {
    //             this.$set(this, 'projectList', [...this.myProjectLook]);
    //         }
    //     },
    // },
    mounted() {
        this.$set(this, 'projectList', [...this.projectListLook]);
    },
    watch: {
        projectListLook: {
            handler(newVal) {
                this.projectList = [...newVal];
            },
            deep: true,
        },
    },
};
</script>

