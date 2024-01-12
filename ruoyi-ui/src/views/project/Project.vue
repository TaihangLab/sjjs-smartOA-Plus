<template>
    <el-card class="box-card" style="margin: auto;">
        <div>
            <el-table ref="multipleTable" :data="projectList" border style="width: 100%" :row-style="{ height: '50px' }"
                      :key="tableKey"
                      :cell-style="{ padding: '0px' }">
                <!--                <el-table-column type="selection" :resizable="false" align="center" width="40"></el-table-column>-->
                <el-table-column label="项目任务书编号" :resizable="false" align="center"
                                 prop="projectAssignmentSerialNo"
                                 width="130">
                </el-table-column>
                <el-table-column label="项目名称" :resizable="false" align="center" prop="assignedSubjectName"
                                 width="150">
                </el-table-column>
                <el-table-column label="项目级别" :resizable="false" align="center" prop="projectLevel"
                                 :formatter="projectLevelss" width="110">
                </el-table-column>
                <el-table-column label="项目牵头单位" :resizable="false" align="center" prop="leadingUnit" width="180">
                </el-table-column>
                <el-table-column label="负责课题" :resizable="false" align="center" prop="assignedSubjectSection"
                                 width="150">
                </el-table-column>
                <el-table-column label="项目推进情况" :resizable="false" align="center" prop="projectProgressStatus"
                                 :formatter="projectProgressStatuss" width="150">
                </el-table-column>
                <el-table-column label="有无合作单位" :resizable="false" align="center" prop="hasCooperativeUnit"
                                 :formatter="hasCooperativeUnits" width="150">
                </el-table-column>
                <el-table-column label="立项时间" :resizable="false" align="center" prop="projectEstablishTime"
                                 width="170">
                </el-table-column>
                <el-table-column label="项目计划验收时间" :resizable="false" align="center"
                                 prop="projectScheduledCompletionTime"
                                 width="170">
                </el-table-column>
                <el-table-column label="操作" :resizable="false" align="center" min-width="230px" fixed="right">
                    <template v-slot="scope">
                        <el-button size="mini" type="text" icon="el-icon-tickets"
                                   @click="lookEdit(scope.$index, scope.row)" v-hasPermi="['project:list:getDetails']">详情
                        </el-button>
                        <el-button size="mini" type="text" icon="el-icon-edit" v-if="buttonType === 1"
                                   @click="handleUpdate(scope.row)" v-hasPermi="['project:my:edit']" >修改
                        </el-button>
                        <el-button size="mini" type="text" icon="el-icon-delete" v-if="buttonType === 1"
                                   @click="handleDelete(scope.row)" v-hasPermi="['project:my:delete']">删除
                        </el-button>
                        <el-button v-if="buttonType !== 1" size="mini" type="text" icon="el-icon-reading"
                                   @click="handleDropdownCommand({ 'command': 'view', 'row': scope.row })" v-hasPermi="['project:list:queryMilestone']">大事记
                        </el-button>
                        <el-dropdown v-else size="mini" @command="handleDropdownCommand">
                            <el-button size="mini" type="text" icon="el-icon-reading" v-hasPermi="['project:list:queryMilestone']">大事记</el-button>
                            <el-dropdown-menu v-slot="dropdown">
                                <el-dropdown-item :command="{ 'command': 'view', 'row': scope.row }"
                                                  icon="el-icon-view" v-hasPermi="['project:list:queryMilestone']">查看
                                </el-dropdown-item>
                                <!-- 根据 buttonType 的值有条件地渲染 "新增" 按钮 -->
                                <el-dropdown-item v-if="buttonType === 1"
                                                  :command="{ 'command': 'add', 'row': scope.row }"
                                                  icon="el-icon-document-add" v-hasPermi="['project:my:milestoneadd']">新增
                                </el-dropdown-item>
                            </el-dropdown-menu>
                        </el-dropdown>
                    </template>
                </el-table-column>
            </el-table>
            <!-- 详情打开的界面 -->
            <el-dialog :model="formLook" v-show="dialogFormVisibleLook" :visible.sync="dialogFormVisibleLook"
                       width="50%">
                <div class="dialog-content">
                    <ProjectDetail :visible.sync="dialogFormVisibleLook" :formLook="formLook"></ProjectDetail>
                </div>
            </el-dialog>
            <!-- 大事记查看打开的界面 -->
            <el-dialog :visible.sync="eventsDialogVisibleLook" width="50%" v-if="eventsDialogVisibleLook"
                       :key="refreshEventsPage" @open="handleEventsDialogOpen" :modal="false">
                <div style="max-height: 600px; overflow-y: auto;">
                    <CheckEvents :projectId="projectId.toString()" :visible.sync="eventsDialogVisibleLook"
                                 :buttonType="parseInt(buttonType)">
                    </CheckEvents>
                </div>
            </el-dialog>
            <!--新增大事记-->
            <el-dialog :visible.sync="eventsDialogVisibleAdd" width="50%">
                <AddEvents :projectId="projectId.toString()" :visible.sync="eventsDialogVisibleAdd"
                           @close-dialog="closeEventsDialog">
                </AddEvents>
            </el-dialog>
            <!-- 页号 -->
            <el-pagination :current-page="this.queryParam.pageNum" :page-size="this.queryParam.pageSize"
                           :page-sizes="[5, 10, 20, 50, 100]" :total="total"
                           layout="total ,sizes,prev,pager,next,jumper"
                           style="margin-top: 30px" @size-change="sizeChangeHandle"
                           @current-change="CurrentChangeHandle">
            </el-pagination>
            <!-- 修改项目弹出的对话框-->
            <el-dialog title="修改项目" :visible.sync="newProjectDialogVisible" fullscreen
                       :key="refreshUpdateDialog">
                <NewProject :visible.sync="newProjectDialogVisible" :updateId="updateId" @refresh="refreshList"
                ></NewProject>
            </el-dialog>
        </div>
    </el-card>
</template>
<script>
import request from '@/utils/request';
import ProjectDetail from "@/views/project/components/ProjectDetail.vue";
import CheckEvents from "@/views/project/components/CheckEvents.vue";
import AddEvents from "@/views/project/components/AddEvents.vue";
import NewProject from "@/views/project/components/NewProject.vue";

export default {
    name      : "Project",
    props     : {
        projectListLook: {
            type    : Array,
            required: true,
        },
        myProjectLook  : {
            type    : Array,
            required: true,
        },
        buttonType     : {
            type: Number,
        },
        total          : {
            type    : Number, // 你的数据类型可以根据实际情况进行调整
            required: true, // 如果希望 total 是必须的，请设置为 true
        },

    },
    components: {
        NewProject,
        ProjectDetail,
        CheckEvents,
        AddEvents,
    },
    data() {
        return {
            tableKey               : true,
            hasCooperativeUnit     : {
                0: '有',
                1: '无',
            },
            projectLevel           : {
                0: '国家级',
                1: '省部级',
                2: '企业级',
            },
            projectProgressStatus  : {
                0: '正在需求申报',
                1: '已完成需求申报',
                2: '正在项目申报',
                3: '已完成项目申报',
                4: '已签订任务书并推进中',
                5: '已完成中期评审',
                6: '已完成验收',
                7: '未通过评审',
            },
            refreshUpdateDialog    : false,
            updateId               : '',
            newProjectDialogVisible: false,
            queryParam             : {
                pageNum : 1,
                pageSize: 10,
            },
            projectId              : '',
            rowCenter              : {
                "text-align": "center"
            },
            size                   : '',
            border                 : true,
            visible                : true,
            refreshEventsPage      : false,
            toggleDetails          : true, // 控制详细信息项的显示/隐藏
            eventsDialogKey        : 0,
            //搜索框
            dataFrom: {},
            //新增
            form: {},
            //查看
            formLook: {},
            //编辑
            formChange             : {},
            projectList            : [],
            pageIndex              : 1,
            pageSize               : 5,
            begin                  : 0,
            end                    : this.pageSize - 1,
            dialogFormVisible      : false, //默认关闭新建用户界面
            dialogFormVisibleChange: false, //默认关闭编辑用户界面
            dialogFormVisibleLook  : false,
            eventsDialogVisibleLook: false,
            eventsDialogVisibleAdd : false,
            dataListFrom           : "getDataList",//当前数据来源于搜索还是全局
            activeName             : 'first',
        };
    },

    methods: {
        hasCooperativeUnits(row, column, cellValue) {
            // 使用映射关系来获取对应的文字描述
            return this.hasCooperativeUnit[cellValue] || cellValue;
        },
        projectLevelss(row, column, cellValue) {
            // 使用映射关系来获取对应的文字描述
            return this.projectLevel[cellValue] || cellValue;
        },
        projectProgressStatuss(row, column, cellValue) {
            // 使用映射关系来获取对应的文字描述
            return this.projectProgressStatus[cellValue] || cellValue;
        },
        // hry
        handleUpdate(row) {
            this.updateId = row.projectId;
            console.log(this.updateId);
            this.refreshUpdateDialog     = !this.refreshUpdateDialog;
            this.newProjectDialogVisible = true;
        },
        /** 删除按钮操作 */
        handleDelete(row) {
            const projectId              = row.projectId;
            const assignedSubjectSection = row.assignedSubjectSection;
            this.$modal.confirm('负责课题：' + assignedSubjectSection + '，确认删除该数据项？'
            ).then(() => {
                return this.deleteUser(projectId);
            }).then(() => {
                this.$emit('reloadProjectList');
                this.$modal.msgSuccess("删除成功");
            }).catch(() => {
                // 删除失败的处理逻辑
                console.error('删除失败');
            });
        },
        // 删除用户
        deleteUser(projectId) {
            return request({
                url   : '/project/my/delete',
                method: 'get',
                params: {
                    projectId: projectId,
                },
            })
        },
        // 关闭弹窗的方法
        closeEventsDialog() {
            this.eventsDialogVisibleAdd = false;
        },
        sizeChangeHandle(val) {
            this.$set(this.queryParam, 'pageSize', val);
            this.fetchData();
        },
        CurrentChangeHandle(val) {
            this.$set(this.queryParam, 'pageNum', val);
            this.fetchData();
        },
        fetchData() {
            this.$parent.reloadProjectList(this.queryParam);
        },
        //详情按钮
        lookEdit(index, item) {
            this.dialogFormVisibleLook = true;
            this.formLook              = item;
        },
        handleDropdownCommand(command) {
            if (command.command === 'view') {
                this.eventsDialogVisibleLook = true;
                this.projectId               = command.row.projectId;
            } else if (command.command === 'add') {
                // 处理新增操作，可以添加相应的逻辑
                this.projectId              = command.row.projectId;
                this.eventsDialogVisibleAdd = true; // 处理新增操作
            }
        },
        handleEventsDialogOpen() {
            // 切换刷新标志位
            this.refreshEventsPage = !this.refreshEventsPage;
        },
        async refreshList() {
            this.$nextTick(() => {
                this.$emit('reloadProjectList');
            });
        },

    },
    watch  : {

        projectListLook: {
            handler(newVal) {
                console.log('Watch - projectListLook updated:', newVal);
                this.projectList = [...newVal];
            },
            deep: true,
        },
        myProjectLook  : {
            handler(newVal) {
                console.log('Watch - myProjectLook updated:', newVal);
                this.projectList = [...newVal];
            },
            deep: true,
        },
        queryParam     : {
            handler(newVal, oldVal) {
                // 在这里处理 queryParam 变化的逻辑
                console.log('queryParam changed:', newVal);
                const pageSizeChanged = newVal.pageSize !== oldVal.pageSize;
                const pageNumChanged  = newVal.pageNum !== oldVal.pageNum;

                if (pageSizeChanged || pageNumChanged) {
                    console.log('pageSize or pageNum changed!');
                }
            },
            deep: true, // 深度监测对象内部属性的变化
        },
    },
    mounted() {
        this.$set(this, 'projectList', [...this.myProjectLook]);
    },
};
</script>

<style scoped>
.dialog-content {
    max-height: 700px; /* 适当设置最大高度 */
    overflow-y: auto; /* 添加垂直滚动条 */
}
</style>
