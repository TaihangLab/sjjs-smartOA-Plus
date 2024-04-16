<template>
    <div>
        <el-form ref="dataForm" :inline="true" :model="myProjectFrom" class="demo-form-inline" style="margin-left: 30px; margin-top: 20px;">
            <el-form-item label="项目名称">
                <el-input v-model="datas.assignedSubjectName" clearable placeholder="请输入项目名称"
                    @keyup.enter.native="handleQuery"></el-input>
            </el-form-item>
            <el-form-item label="课题名称">
                <el-input v-model="datas.assignedSubjectSection" clearable placeholder="请输入课题名称"
                    @keyup.enter.native="handleQuery"></el-input>
            </el-form-item>
            <el-form-item label="项目级别">
                <el-cascader v-model="projectLevel" :options="levelOptions" clearable placeholder="请选择项目级别"
                    @keyup.enter.native="handleQuery"></el-cascader>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>
        </el-form>
        <el-card class="box-card" style="margin: auto;">
            <div>
                <el-table ref="multipleTable" :data="projectlist" border style="width: 100%"
                    :row-style="{ height: '50px' }" :cell-style="{ padding: '0px' }">
                    <!--                 <el-table-column type="selection" :resizable="false" align="center" width="40"></el-table-column>-->
                    <el-table-column label="项目名称" :resizable="false" align="center" prop="assignedSubjectName"
                        width="300">
                    </el-table-column>
                    <el-table-column label="课题名称" :resizable="false" align="center" prop="assignedSubjectSection"
                        width="300">
                    </el-table-column>
                    <el-table-column label="级别" :resizable="false" align="center" prop="projectLevel"
                        :formatter="projectLevelFormatter" width="200">
                    </el-table-column>
                    <el-table-column label="项目经费总额（万元）" :resizable="false" align="center" prop="totalFundsAll"
                        width="200">
                    </el-table-column>
                    <el-table-column label="专项经费预算（万元）" :resizable="false" align="center" prop="totalFundsZx"
                        width="200">
                    </el-table-column>
                    <el-table-column label="专项经费已支付（万元）" :resizable="false" align="center" prop="totalFundsZxPaid"
                        width="200">
                    </el-table-column>
                    <el-table-column label="专项经费未支付（万元）" :resizable="false" align="center" prop="totalFundsZxUnpaid"
                        width="200">
                    </el-table-column>
                    <el-table-column label="自筹经费预算（万元）" :resizable="false" align="center" prop="totalFundsZc"
                        width="200">
                    </el-table-column>
                    <el-table-column label="自筹经费已支付（万元）" :resizable="false" align="center" prop="totalFundsZcPaid"
                        width="200">
                    </el-table-column>
                    <el-table-column label="自筹经费未支付（万元）" :resizable="false" align="center" prop="totalFundsZcUnpaid"
                        width="200">
                    </el-table-column>
                    <el-table-column label="操作" :resizable="false" align="center" min-width="250px" fixed="right">
                        <template v-slot="scope">
                            <el-button size="mini" type="text" icon="el-icon-tickets"
                                @click="lookDetail(scope.row.projectId)">详情</el-button>
                            <el-dropdown size="mini" @command="handleDropdownCommand">
                                <el-button size="mini" type="text" icon="el-icon-notebook-2">支出录入</el-button>
                                <el-dropdown-menu v-slot="dropdown">
                                    <el-dropdown-item :command="{ 'command': 'view', 'row': scope.row }"
                                        icon="el-icon-view">查看
                                    </el-dropdown-item>
                                    <el-dropdown-item :command="{ 'command': 'add', 'row': scope.row }"
                                        icon="el-icon-document-add">录入
                                    </el-dropdown-item>
                                </el-dropdown-menu>
                            </el-dropdown>
                            <el-button size="mini" type="text" icon="el-icon-finished"
                                @click="handleIncome(scope.row.projectId)">经费到账
                            </el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <!-- 详情打开的界面 -->
                <el-dialog :visible.sync="dialogDetailLook" width="86%">
                    <CheckDetail :projectId="Number(projectId)"></CheckDetail>
                </el-dialog>
                <!--经费到账-->
                <el-dialog title="经费到账" :visible.sync="appropriationlDialogVisibleEdit" width="60%"
                    @close="closeIncomeDialog">
                    <AppropriationAccount :projectId="Number(projectId)"></AppropriationAccount>
                </el-dialog>
                <!--支出录入-->
                <el-dialog title="支出录入" :visible.sync="expenditureDialogVisibleEdit" width="90%"
                    @close="closeExpenselDialog">
                    <ExpenditureEntry ref="ExpenditureEntry" :projectId="Number(projectId)"></ExpenditureEntry>
                </el-dialog>
                <!--支出查看-->
                <el-dialog title="支出查看" :visible.sync="expenditureDialogVisibleCheck" width="90%"
                    @close="closeExpenselCheckDialog">
                    <ExpenditureCheck :projectId="Number(projectId)"></ExpenditureCheck>
                </el-dialog>
            </div>
            <el-pagination :current-page="queryParam.pageNum" :page-size="queryParam.pageSize"
                :page-sizes="[5, 10, 20, 50, 100]" :total="total" layout="total ,sizes,prev,pager,next,jumper"
                style="margin-top: 30px" @size-change="sizeChangeHandle" @current-change="CurrentChangeHandle">
            </el-pagination>
        </el-card>
    </div>
</template>

<script>
import { listUser, deptTreeSelect } from "@/api/system/user";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";
import request from '@/utils/request';
import AppropriationAccount from "@/views/project/components/ExpensesIncome/AppropriationAccount.vue";
import ExpenditureEntry from "@/views/project/components/ExpenditureEntry.vue";
import ExpenditureCheck from "@/views/project/components/ExpenditureCheck.vue";
import CheckDetail from "@/views/project/components/ExpensesIncome/checkExpensesIncome/CheckDetail.vue";

export default {
    components: { CheckDetail, ExpenditureEntry, AppropriationAccount, ExpenditureCheck },
    data() {
        return {
            dialogDetailLook: false,
            projecttree: undefined,
            total: 0,
            projectId: undefined,
            projectlist: undefined,
            dialogExpenseLook: false,
            appropriationlDialogVisibleEdit: false,
            expenditureDialogVisibleEdit: false,
            expenditureDialogVisibleCheck: false,
            datas: {
                "projectId": undefined,
                "ipName": undefined,
                "ipType": undefined,
                "ipStatus": undefined,
                "userId": undefined,
                "ipDateSta": undefined,
                "ipDateEnd": undefined,
                assignedSubjectName: undefined,
                projectLevel: undefined,
                assignedSubjectSection: undefined,
            },
            queryParam: {
                pageNum: 1,
                pageSize: 10,
            },
            levelOptions: [
                {
                    value: 0,
                    label: '国家级'
                },
                {
                    value: 1,
                    label: '省级'
                },
                {
                    value: 2,
                    label: '企业级'
                }
            ],
            projectLevel:[],
            myProjectFrom: {},
            formLook: {},
            pickerOptions: {}
        };
    },
    created() {
        this.checkFundsList();
        this.handleTabClick({ name: 'view' });
    },
    methods: {
        handleTabClick(tab) {
            if (tab.name === 'view') {
                this.checkExpenditureEntryDetail();
            }
        },
        async checkFundsList() {
            this.getDeptAndUserList();
            this.getProjectTree();
            this.checkfunds();
        },
        // 级别
        projectLevelFormatter(row) {
            const projectLevel = {
                0: '国家级',
                1: '省级',
                2: '企业级',
            };
            return projectLevel[row.projectLevel];
        },
        // 按项目级别-项目搜索
        getProjectTree() {
            request({
                url: '/ip/getProjectMapping',
                method: 'get',
                params: this.header,
            })
                .then((resp) => {
                    this.projecttree = resp.data;
                })
                .catch((error) => {
                    console.error('获取用户数据时出错：', error);
                });
        },
        // 按部门-人员搜索
        async getDeptAndUserList() {
            // this.queryParam.pageNum = 1;
            // this.queryParam.pageSize = 10;
            await this.getDeptTree(); // 等待部门数据加载完成
            await this.getList(); // 等待用户数据加载完成
            this.cascaderOptions = this.adaptData(this.deptOptions);
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
        // 处理按钮点击事件搜索
        handleQuery() {
            this.datas.projectLevel = this.projectLevel[0];
            this.checkfunds();
        },
        // 处理按钮点击事件重置
        resetQuery(){
        // 重置查询参数
        this.queryParam.pageNum = 1;
        this.queryParam.pageSize = 10;
        this.projectLevel = [];
        this.datas.assignedSubjectName = undefined;
        this.datas.assignedSubjectSection = undefined;
        this.checkfunds();
    },
        lookDetail(projectId) {
            this.dialogDetailLook = true;
            this.projectId = projectId;
        },
        //经费到账
        handleIncome(projectId) {
            this.appropriationlDialogVisibleEdit = true;
            this.projectId = projectId;
        },
        closeIncomeDialog() {
            this.appropriationlDialogVisibleEdit = false;
        },
        closeExpenseDialogLook() {
            this.resetQuery();
        },
        closeExpenseDialog() {
            this.resetQuery();
        },
        // 关闭弹窗的方法
        closeExpenselDialog() {
            this.expenditureDialogVisibleEdit = false;
            if (this.$refs.ExpenditureEntry) {
                this.$refs.ExpenditureEntry.clearDataOnPageClose();
            }
        },
        closeExpenselCheckDialog() {
            this.expenditureDialogVisibleCheck = false;
        },
        // 查看经费列表
        checkfunds() {
            request({
                url: '/project/funds/getProjectList',
                method: 'post',
                data: this.datas,
                params: this.queryParam,
            })
                .then((resp) => {
                    // 处理获取的经费数据
                    this.projectlist = resp.rows;
                    this.total = resp.total;
                })
                .catch((error) => {
                    console.error('获取经费数据时出错：', error);
                });
        },
        handleDropdownCommand(command) {
            if (command.command === 'view') {
                this.expenditureDialogVisibleCheck = true;
                this.projectId = command.row.projectId;
                this.checkExpenditureEntryDetail();
            } else if (command.command === 'add') {
                // 处理新增操作，可以添加相应的逻辑
                this.projectId = command.row.projectId;
                this.expenditureDialogVisibleEdit = true; // 处理新增操作
                this.checkExpenditureEntryDetail();
            }
        },
        // 查看支出信息
        checkExpenditureEntryDetail() {
            request({
                url: '/project/funds/getProjectExpenditure',
                method: 'get',
                params: {
                    projectId: this.$props.projectId,
                },
            })
                .then((resp) => {
                    this.expenditureEntry = resp.data;
                    this.loading = false; // 关闭遮罩层
                })
                .catch((error) => {
                    console.error('获取用户数据时出错：', error);
                    this.loading = false; // 关闭遮罩层
                });
        },
        sizeChangeHandle(val) {
            this.$set(this.queryParam, 'pageSize', val);
            this.queryParam.pageNum = 1;
            this.fetchData();
        },
        CurrentChangeHandle(val) {
            this.$set(this.queryParam, 'pageNum', val);
            this.fetchData();
        },
        fetchData() {
            this.checkfunds();
        },
    },

};
</script>

<style>
.box-card {
    width: 100%;
    margin-bottom: 20px;
}
</style>
