<template>
    <div class="sticky-container">
        <el-tabs v-model="activeNames" @tab-click="handleTabClick">
            <el-tab-pane label="基本信息" name="first">
                <div style="margin-top: 10px;"></div>
                <el-descriptions-item label="基本信息" :span="2"></el-descriptions-item>
                <el-descriptions class="margin-top" title="" :column="3" :size="size" :labelStyle="{ width: '15%' }"
                    :contentStyle="{ width: '20%' }" border>
                    <el-descriptions-item label="项目名称">{{
                    this.lookDetail.projectInfoVO.assignedSubjectName
                        }}
                    </el-descriptions-item>
                    <el-descriptions-item label="项目任务书编号">{{
                        this.lookDetail.projectInfoVO.projectAssignmentSerialNo
                    }}
                    </el-descriptions-item>
                    <el-descriptions-item label="负责课题">{{
                        this.lookDetail.projectInfoVO.assignedSubjectSection
                    }}
                    </el-descriptions-item>
                    <el-descriptions-item label="课题任务书编号">{{
                        this.lookDetail.projectInfoVO.subjectAssignmentSerialNo
                    }}
                    </el-descriptions-item>
                    <el-descriptions-item label="项目牵头单位">{{
                        this.lookDetail.projectInfoVO.leadingUnit
                    }}
                    </el-descriptions-item>
                    <el-descriptions-item label="是否牵头单位">{{
                        this.hasLeading[this.lookDetail.projectInfoVO.hasLeadingRole]
                    }}
                    </el-descriptions-item>
                    <el-descriptions-item label="项目专员/联系人">{{
                            this.lookDetail.projectInfoVO.projectContact
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目级别">{{
                            this.projectLevel[this.lookDetail.projectInfoVO.projectLevel]
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目来源">{{
                            this.lookDetail.projectInfoVO.projectSource
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="立项时间">{{
                            this.lookDetail.projectInfoVO.projectEstablishTime
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目计划验收时间">{{
                            this.lookDetail.projectInfoVO.projectScheduledCompletionTime
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目执行时间（年）">{{
                            this.lookDetail.projectInfoVO.projectDuration
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目推进情况">{{
                            this.projectProgressStatus[this.lookDetail.projectInfoVO.projectProgressStatus]
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="合作单位">{{
                            this.lookDetail.projectInfoVO.collaboratingUnit
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="涉及专家、团队">{{
                            this.lookDetail.projectInfoVO.expertTeam
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目经费总额">{{
                            this.lookDetail.projectFundsVO.totalFundsAll
                        }}
                        </el-descriptions-item>
<!--                        <el-descriptions-item>{{ }}</el-descriptions-item>-->
                        <el-descriptions-item label="专项经费">{{
                            this.lookDetail.projectFundsVO.totalFundsZx
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="自筹经费">{{
                            this.lookDetail.projectFundsVO.totalFundsZc
                        }}
                        </el-descriptions-item>
                </el-descriptions>
                <el-collapse >
                    <el-collapse>
                        <el-collapse-item style="font-size: 20px;" name="2">
                            <template slot="title">
                                <span style="font-size: 14px;">项目简介</span>
                            </template>
                            <div class="unselectable-textbox" style="font-size: 14px; color: #606266;">
                                {{ projectdescription }}
                            </div>
                        </el-collapse-item>
                    </el-collapse>
                </el-collapse>
            </el-tab-pane>
            <el-tab-pane label="支出信息" name="second">
                <div style="margin-top: 10px;"></div>
                <el-table ref="multipleTable" :data="expenditureEntry" border
                    style="width: 100%; max-height: 500px; overflow-y: auto;" :row-style="{ height: '50px' }"
                    :cell-style="{ padding: '0px' }">
                    <el-table-column label="日期" :resizable="false" align="center">
                        <!-- 使用 slot-scope 定制显示日期 -->
                        <template slot-scope="scope">
                            {{ formatDate(scope.row.expenditureDate) }}
                        </template>
                    </el-table-column>
                    <el-table-column label="项目名称" :resizable="false" align="center" prop="projectName" width="250px">
                    </el-table-column>
                    <el-table-column label="凭证号" :resizable="false" align="center" prop="voucherNo" width="100px">
                    </el-table-column>
                    <el-table-column label="摘要" :resizable="false" align="center" prop="expenditureAbstract"
                        min-width="400px">
                    </el-table-column>
                    <el-table-column label="专项/自筹" :resizable="false" align="center" prop="zxzc"
                        :formatter="zxzcFormatter">
                    </el-table-column>
                    <el-table-column label="一级科目" :resizable="false" align="center" prop="firstLevelSubject"
                        :formatter="firstLevelSubjectFormatter">
                    </el-table-column>
                    <el-table-column label="二级科目" :resizable="false" align="center" prop="secondLevelSubject"
                        :formatter="secondLevelSubjectFormatter">
                    </el-table-column>
                    <el-table-column label="三级科目" :resizable="false" align="center" prop="secondLevelSubject"
                        :formatter="secondLevelSubjectFormatter">
                    </el-table-column>
                    <el-table-column :resizable="false" align="center" prop="amount" width="150px">
                        <template slot="header" slot-scope="scope">
                            <div style="text-align: center;">
                                <span>金额</span>
                                <span style="font-size: 12px; color: #F56C6C;">（元）</span>
                            </div>
                        </template>
                    </el-table-column>
                </el-table>
            </el-tab-pane>
            <el-tab-pane label="经费到账" name="third">
                <CheckAppropriationAccount :appropriationAccount="this.appropriationAccount">
                </CheckAppropriationAccount>
            </el-tab-pane>
            <el-tab-pane label="其他" name="fourth">
                <FundSituation  :checkOthers="this.checkOthers">
                </FundSituation>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>
<script>
import request from '@/utils/request';
import { defineComponent } from "vue";
import CheckAppropriationAccount from "@/views/project/components/ExpensesIncome/checkExpensesIncome/CheckAppropriationAccount.vue";
import FundSituation from "@/views/project/components/ExpensesIncome/checkExpensesIncome/FundSituation.vue";

export default {
    name: "CheckDetail",
    components: {CheckAppropriationAccount,FundSituation},
    props: {
        projectId: {
            type: [Number, String],
            required: true,
        },
    },
    data() {
        return {
            activeNames: 'first', // 设置初始激活的选项卡
            // 遮罩层
            loading: true,
            checkOthers: undefined,
            appropriationAccount: undefined,
            projectdescription: undefined,
            expenditureEntry:undefined,
            lookDetail: undefined,
            hasLeading: {
                0: '否',
                1: '是',
            },
            projectLevel: {
                0: '国家级',
                1: '省部级',
                2: '企业级',
            },
            projectProgressStatus: {
                0: '正在需求申报',
                1: '已完成需求申报',
                2: '正在项目申报',
                3: '已完成项目申报',
                4: '已签订任务书并推进中',
                5: '已完成中期评审',
                6: '已完成验收',
                7: '未通过评审',
            },
        }
    },
    watch: {
        projectId: {
            handler(newVal) {
                this.activeNames = 'first';
                this.checkDetail();
                this.checkExpenditureEntryDetail();
                this.checkFundsReceivedDetail();
                this.checkOther();
            },
            immediate: true, // 立即执行一次
        },
    },
    created() {
        this.handleTabClick({ name: 'first' });
        console.log('projectId:', this.$props.projectId);
    },
    methods: {
        handleClick(tab, event) {
            console.log(tab, event);
        },
        handleTabClick(tab) {
            if (tab.name === 'second') {
                this.checkExpenditureEntryDetail();
            }else if (tab.name === 'third'){
                this.checkFundsReceivedDetail();
            }
            else if (tab.name === 'fourth'){
                this.checkOther();
            }
        },
        // 格式化日期方法
        formatDate(date) {
            // 假设日期格式为 "YYYY-MM-DD"
            const parts = date.split('-');
            if (parts.length === 3) {
                const year = parts[0];
                const month = parts[1];
                const day = parts[2];
                return `${year}-${month}-${day}`;
            }
            // 如果日期格式不正确，直接返回原始日期
            return date;
        },
        // 科目粗分
        firstLevelSubjectFormatter(row) {
            const firstLevelSubject = {
                0: '设备费',
                1: '业务费',
                2: '劳务费',
                3: '材料费',
                4: '科研活动费',
                5: '科研服务费',
                6: '人员和劳务补助费',
                7: '绩效支出',
            };
            return firstLevelSubject[row.firstLevelSubject];
        },
        // 科目细分
        secondLevelSubjectFormatter(row) {
            const secondLevelSubject = {
                0: '购置设备费',
                1: '试制设备费',
                2: '设备升级改造费',
                3: '设备租赁费',
                4: '材料费',
                5: '资料费',
                6: '数据样本采集费',
                7: '测试化验加工费',
                8: '燃料动力费',
                9: '办公费',
                10: '印刷/出版费',
                11: '知识产权事务费',
                12: '车辆使用费',
                13: '出版/文献/信息传播/知识产权事务费',
                14: '差旅费',
                15: '会议/会务费',
                16: '国内协作费',
                17: '国际合作交流费',
                18: '会议/差旅/国际合作与交流费',
                19: '专家咨询费',
                21: '人员劳务费',
            };
            return secondLevelSubject[row.secondLevelSubject];
        },
        // 专项自筹
        zxzcFormatter(row) {
            const zxzc = {
                0: '专项',
                1: '自筹',
            };
            return zxzc[row.zxzc];
        },
        // 查看详情
        checkDetail() {
            request({
                url: '/project/list/getDetails',
                method: 'get',
                params: {
                    projectId: this.$props.projectId,
                },
            })
                .then((resp) => {
                    this.lookDetail = resp.data;
                    this.projectdescription = this.lookDetail.projectInfoVO.projectDescription;
                    loading.close();
                })
                .catch((error) => {
                    console.error('获取用户数据时出错：', error);
                    loading.close();
                });
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
                    loading.close();
                })
                .catch((error) => {
                    console.error('获取用户数据时出错：', error);
                    loading.close();
                });
        },
        // 查看经费到账
        checkFundsReceivedDetail() {
            request({
                url: '/project/funds/getFundsReceived',
                method: 'get',
                params: {
                    projectId: this.$props.projectId,
                },
            })
                .then((resp) => {
                    this.appropriationAccount = resp.data;
                    loading.close();
                })
                .catch((error) => {
                    console.error('获取用户数据时出错：', error);
                    loading.close();
                });
        },
        // 查看其他
        checkOther() {
            request({
                url: '/project/balance/fundsAndBalance',
                method: 'get',
                params: {
                    projectId: this.$props.projectId,
                },
            })
                .then((resp) => {
                    this.checkOthers = resp.data;
                    loading.close();
                })
                .catch((error) => {
                    console.error('获取用户数据时出错：', error);
                    loading.close();
                });
        },
    },
}
</script>

<style>
.sticky-container {
    position: sticky;
    top: 0;
    z-index: 1000;
    /* 使容器在最上层 */
    background-color: #fff;
    /* 设置容器背景颜色 */
}
</style>
