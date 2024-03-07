<template>
    <div>
        <el-form ref="dataForm" :inline="true" class="demo-form-inline" style="margin-left: 30px; margin-top: 20px;">
            <el-form-item label="项目名称">
                <el-cascader v-model="responsibleproject" :options="this.projecttree" clearable :show-all-levels="false"
                    placeholder="请选择项目" @keyup.enter.native="handleQuery"></el-cascader>
            </el-form-item>
            <el-form-item label="项目级别">
                <el-select v-model="responsibleType" placeholder="请选择项目级别">
                    <el-option v-for="(label, value) in ipType" :label="label" :value="value" :key="value"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="立项时间">
                <el-date-picker v-model="projectEstablishTime" type="daterange" unlink-panels clearable
                    start-placeholder="请输入查询范围" end-placeholder="如：2000-01-01" value-format="yyyy-MM-dd"
                    @change="getList" :picker-options="pickerOptions"
                    @keyup.enter.native="handleQuery"></el-date-picker>
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
                                @click="lookExpense(scope.row.projectId)"
                                v-hasPermi="['project:ip:getDetails']">查看</el-button>
                            <el-button size="mini" type="text" icon="el-icon-notebook-2"
                                @click="handleDisburse(scope.row.projectId)">支出录入
                            </el-button>
                            <el-button size="mini" type="text" icon="el-icon-finished"
                                @click="handleIncome(scope.row.projectId)">经费到账
                            </el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <!-- 详情打开的界面 -->
                <el-dialog :visible.sync="dialogExpenseLook" width="50%">
                    <CheckExpense :projectId="String(projectId)" @close-dialog="closeExpenseDialogLook">
                    </CheckExpense>
                </el-dialog>
                <!--经费到账-->
                <el-dialog title="经费到账" :visible.sync="appropriationlDialogVisibleEdit" width="70%">
                    <AppropriationAccount :ipId="Number(ipId)">
                    </AppropriationAccount>
                </el-dialog>
                <!--支出录入-->
                <el-dialog title="支出录入" :visible.sync="expenditureDialogVisibleEdit" width="90%"
                    @close="closeExpenselDialog">
                    <ExpenditureEntry ref="ExpenditureEntry" :projectId="Number(projectId)"></ExpenditureEntry>
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
import CheckExpense from "@/views/project/components/CheckExpense.vue";

import AppropriationAccount from "@/views/project/components/AppropriationAccount.vue";
import ExpenditureEntry from "@/views/project/components/ExpenditureEntry.vue";

export default {
    components: { CheckExpense, ExpenditureEntry, AppropriationAccount },
    data() {
        return {
            projecttree: undefined,
            total: 0,
            projectEstablishTime: [],
            responsibleIp: undefined,
            responsibleType: undefined,
            responsibleJobTitle: undefined,
            responsiblePerson: [],
            responsibleproject: [],
            cascaderOptions: [],
            projectId: undefined,
            projectlist: undefined,
            dialogExpenseLook: false,
            appropriationlDialogVisibleEdit: false,
            expenditureDialogVisibleEdit: false,
            datas: {
                "projectId": undefined,
                "ipName": undefined,
                "ipType": undefined,
                "ipStatus": undefined,
                "userId": undefined,
                "ipDateSta": undefined,
                "ipDateEnd": undefined,
            },
            queryParam: {
                pageNum: 1,
                pageSize: 10,
            },
            myProjectFrom: {},
            formLook: {},
            pickerOptions: {}
        };
    },
    created() {
        this.checkFundsList();
    },
    methods: {
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
        /** 查询部门下拉树结构 */
        async getDeptTree() {
            const response = await deptTreeSelect();
            this.deptOptions = response.data;
        },
        /** 查询用户列表 */
        async getList() {
            const response = await listUser();
            this.userList = response.rows;
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
            this.datas.ipName = this.responsibleIp;
            this.datas.projectId = this.responsibleproject[this.responsibleproject.length - 1];
            this.datas.userId = this.responsiblePerson[this.responsiblePerson.length - 1];
            this.datas.ipType = this.responsibleType;
            this.datas.ipStatus = this.responsibleJobTitle;
            if (this.projectEstablishTime) {
                this.datas.ipDateSta = this.projectEstablishTime[0];
                this.datas.ipDateEnd = this.projectEstablishTime[1];
            } else {
                this.datas.ipDateSta = undefined;
                this.datas.ipDateEnd = undefined;
            }
            this.checkmembers();
        },
        // 处理按钮点击事件重置
        resetQuery() {
            this.datas = {
                projectId: undefined,
                ipName: undefined,
                ipType: undefined,
                ipStatus: undefined,
                userId: undefined,
                ipDateSta: undefined,
                ipDateEnd: undefined,
            };
            this.projectEstablishTime = [];
            this.responsibleIp = undefined;
            this.responsibleType = undefined;
            this.responsibleJobTitle = undefined;
            this.responsiblePerson = [];
            this.responsibleproject = [];
            this.ipId = undefined;
            this.checkmembers();
        },
        lookExpense(projectId) {
            this.dialogExpenseLook = true;
            this.projectId = projectId;
        },
        //支出录入
        handleDisburse(projectId) {
            this.expenditureDialogVisibleEdit = true;
            this.projectId = projectId;
        },
        //经费到账
        handleIncome(ipId) {
            this.appropriationlDialogVisibleEdit = true;
            this.ipId = ipId;
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
