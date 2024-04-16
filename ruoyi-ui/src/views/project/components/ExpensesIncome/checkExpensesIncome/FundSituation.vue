<template>
    <div>
        <div style="margin-top: 10px;"></div>
        <el-table @row-mouseenter="handleRowMouseEnter" @row-mouseleave="handleRowMouseLeave"
            :row-class-name="getRowClassName" :data="tableDataList" style="width: 100%"
            height="525px" row-key="id" border :cell-style="columnStyle"
            :tree-props="{ children: 'children', hasChildren: 'hasChildren' }" highlight-current-row>
            <el-table-column prop="label" width="180" >
                <template slot="header" slot-scope="scope">
                    <div style="text-align: center;">
                        <span>预算科目名称</span>
                        <br>
                        <span style="font-size: 12px; color: #F56C6C;">（单位：万元）</span>
                    </div>
                </template>
            </el-table-column>
            <el-table-column align="center" label="预算">
                <el-table-column align="center" label="合计" prop="budget"></el-table-column>
                <el-table-column align="center" label="专项经费" prop="specialBudget"></el-table-column>
                <el-table-column align="center" label="自筹经费" prop="selfBudget"></el-table-column>
            </el-table-column>
            <el-table-column align="center" label="专项已支付" prop="specialPaid"></el-table-column>
            <el-table-column align="center" label="专项未支付" prop="specialUnpaid"></el-table-column>
            <el-table-column align="center" label="自筹已支付" prop="selfPaid"></el-table-column>
            <el-table-column align="center" label="自筹未支付" prop="selfUnpaid"></el-table-column>
            <el-table-column align="center" label="已支付" prop="totalPaid"></el-table-column>
            <el-table-column align="center" label="未支付" prop="totalUnpaid"></el-table-column>
        </el-table>
    </div>
</template>

<script>
import { categoryOptions3 } from "@/views/project/components/fundkeys";

export default {
    props: {
        checkOthers: {
            type: Array,
            required: true,
        },
    },
    data() {
        return {
            tableDataList: categoryOptions3,
            loading: false, // Assuming you have a loading state
        };
    },
    watch: {
        checkOthers: {
            handler(newVal) {
                this.handleData(newVal);
                console.log("newval", newVal);
            },
            immediate: true, // 立即执行一次
        },
    },
    methods: {
        columnStyle({ row, column, rowIndex, columnIndex }) {
            if (columnIndex === 0) {
                return "background:#f3f5f8";
            } else if (columnIndex === 1) {
                return "background:#e2e280";
            } else if (columnIndex === 2 || columnIndex === 3) {
                return "background:#c9db7e";
            } else if (columnIndex === 4 || columnIndex === 5) {
                return "background:#aed37f";
            } else if (columnIndex === 6 || columnIndex === 7) {
                return "background:#96cb7e";
            } else if (columnIndex === 8 || columnIndex === 9) {
                return "background:#7bc37b";
            }
        },
        handleRowMouseEnter(row, event, rowIndex) {
            this.hoverRowIndex = rowIndex;
        },
        handleRowMouseLeave() {
            this.hoverRowIndex = -1;
        },
        getRowClassName({ rowIndex }) {
            if (rowIndex === this.hoverRowIndex) {
                return 'row-hover';
            }
            return '';
        },
        handleData(newVal) {
            /* 一、经费支出 */
            this.tableDataList[0].budget = newVal.projectFunds.totalFundsAll;
            this.tableDataList[0].specialBudget = newVal.projectFunds.totalFundsZx;
            this.tableDataList[0].selfBudget = newVal.projectFunds.totalFundsZc;
            this.tableDataList[0].specialPaid = newVal.projectBalance.totalFundsZxPaid;
            this.tableDataList[0].specialUnpaid = newVal.projectBalance.totalFundsZxUnpaid;
            this.tableDataList[0].selfPaid = newVal.projectBalance.totalFundsZcPaid;
            this.tableDataList[0].selfUnpaid = newVal.projectBalance.totalFundsZcUnpaid;
            this.tableDataList[0].totalPaid = newVal.projectBalance.totalFundsAllPaid;
            this.tableDataList[0].totalUnpaid = newVal.projectBalance.totalFundsAllUnpaid;

            /* （一）直接费用 */
            this.tableDataList[1].budget = newVal.projectFunds.totalFundsZj;
            this.tableDataList[1].specialBudget = newVal.projectFunds.totalFundsZxZj;
            this.tableDataList[1].selfBudget = newVal.projectFunds.totalFundsZcZj;
            this.tableDataList[1].specialPaid = newVal.projectBalance.totalFundsZxZjPaid;
            this.tableDataList[1].specialUnpaid = newVal.projectBalance.totalFundsZxZjUnpaid;
            this.tableDataList[1].selfPaid = newVal.projectBalance.totalFundsZcZjPaid;
            this.tableDataList[1].selfUnpaid = newVal.projectBalance.totalFundsZcZjUnpaid;
            this.tableDataList[1].totalPaid = newVal.projectBalance.totalFundsZjPaid;
            this.tableDataList[1].totalUnpaid = newVal.projectBalance.totalFundsZjUnpaid;

            /* 设备费 */
            this.tableDataList[2].budget = newVal.projectFunds.sbfZj;
            this.tableDataList[2].specialBudget = newVal.projectFunds.sbfZxZj;
            this.tableDataList[2].selfBudget = newVal.projectFunds.sbfZcZj;
            this.tableDataList[2].specialPaid = newVal.projectBalance.sbfZxZjPaid;
            this.tableDataList[2].specialUnpaid = newVal.projectBalance.sbfZxZjUnpaid;
            this.tableDataList[2].selfPaid = newVal.projectBalance.sbfZcZjPaid;
            this.tableDataList[2].selfUnpaid = newVal.projectBalance.sbfZcZjUnpaid;
            this.tableDataList[2].totalPaid = newVal.projectBalance.sbfZjPaid;
            this.tableDataList[2].totalUnpaid = newVal.projectBalance.sbfZjUnpaid;
            /* 设备费_购置设备费 */
            this.tableDataList[2].children[0].specialBudget = newVal.projectFunds.sbfGzsbZxZj;
            this.tableDataList[2].children[0].selfBudget = newVal.projectFunds.sbfGzsbZcZj;
            this.tableDataList[2].children[0].specialPaid = newVal.projectBalance.sbfGzsbZxZjPaid;
            this.tableDataList[2].children[0].specialUnpaid = newVal.projectBalance.sbfGzsbZxZjUnpaid;
            this.tableDataList[2].children[0].selfPaid = newVal.projectBalance.sbfGzsbZcZjPaid;
            this.tableDataList[2].children[0].selfUnpaid = newVal.projectBalance.sbfGzsbZcZjUnpaid;
            this.tableDataList[2].children[0].totalPaid = newVal.projectBalance.sbfGzsbZjPaid;
            this.tableDataList[2].children[0].totalUnpaid = newVal.projectBalance.sbfGzsbZjUnpaid;
            /* 设备费_试制设备费 */
            this.tableDataList[2].children[1].specialBudget = newVal.projectFunds.sbfSzsbZxZj;
            this.tableDataList[2].children[1].selfBudget = newVal.projectFunds.sbfSzsbZcZj;
            this.tableDataList[2].children[1].specialPaid = newVal.projectBalance.sbfSzsbZxZjPaid;
            this.tableDataList[2].children[1].specialUnpaid = newVal.projectBalance.sbfSzsbZxZjUnpaid;
            this.tableDataList[2].children[1].selfPaid = newVal.projectBalance.sbfSzsbZcZjPaid;
            this.tableDataList[2].children[1].selfUnpaid = newVal.projectBalance.sbfSzsbZcZjUnpaid;
            this.tableDataList[2].children[1].totalPaid = newVal.projectBalance.sbfSzsbZjPaid;
            this.tableDataList[2].children[1].totalUnpaid = newVal.projectBalance.sbfSzsbZjUnpaid;
            /* 设备费_设备升级改造费 */
            this.tableDataList[2].children[2].specialBudget = newVal.projectFunds.sbfSbsjgzZxZj;
            this.tableDataList[2].children[2].selfBudget = newVal.projectFunds.sbfSbsjgzZcZj;
            this.tableDataList[2].children[2].specialPaid = newVal.projectBalance.sbfSbsjgzZxZjPaid;
            this.tableDataList[2].children[2].specialUnpaid = newVal.projectBalance.sbfSbsjgzZxZjUnpaid;
            this.tableDataList[2].children[2].selfPaid = newVal.projectBalance.sbfSbsjgzZcZjPaid;
            this.tableDataList[2].children[2].selfUnpaid = newVal.projectBalance.sbfSbsjgzZcZjUnpaid;
            this.tableDataList[2].children[2].totalPaid = newVal.projectBalance.sbfSbsjgzZjPaid;
            this.tableDataList[2].children[2].totalUnpaid = newVal.projectBalance.sbfSbsjgzZjUnpaid;
            /* 设备费_设备租赁费 */
            this.tableDataList[2].children[3].specialBudget = newVal.projectFunds.sbfSbzlZxZj;
            this.tableDataList[2].children[3].selfBudget = newVal.projectFunds.sbfSbzlZcZj;
            this.tableDataList[2].children[3].specialPaid = newVal.projectBalance.sbfSbzlZxZjPaid;
            this.tableDataList[2].children[3].specialUnpaid = newVal.projectBalance.sbfSbzlZxZjUnpaid;
            this.tableDataList[2].children[3].selfPaid = newVal.projectBalance.sbfSbzlZcZjPaid;
            this.tableDataList[2].children[3].selfUnpaid = newVal.projectBalance.sbfSbzlZcZjUnpaid;
            this.tableDataList[2].children[3].totalPaid = newVal.projectBalance.sbfSbzlZjPaid;
            this.tableDataList[2].children[3].totalUnpaid = newVal.projectBalance.sbfSbzlZjUnpaid;

            /* 业务费 */
            this.tableDataList[3].budget = newVal.projectFunds.ywfZj;
            this.tableDataList[3].specialBudget = newVal.projectFunds.ywfZxZj;
            this.tableDataList[3].selfBudget = newVal.projectFunds.ywfZcZj;
            this.tableDataList[3].specialPaid = newVal.projectBalance.ywfZxZjPaid;
            this.tableDataList[3].specialUnpaid = newVal.projectBalance.ywfZxZjUnpaid;
            this.tableDataList[3].selfPaid = newVal.projectBalance.ywfZcZjPaid;
            this.tableDataList[3].selfUnpaid = newVal.projectBalance.ywfZcZjUnpaid;
            this.tableDataList[3].totalPaid = newVal.projectBalance.ywfZjPaid;
            this.tableDataList[3].totalUnpaid = newVal.projectBalance.ywfZjUnpaid;
            /* 业务费_材料费 */
            this.tableDataList[3].children[0].specialBudget = newVal.projectFunds.ywfClfZxZj;
            this.tableDataList[3].children[0].selfBudget = newVal.projectFunds.ywfClfZcZj;
            this.tableDataList[3].children[0].specialPaid = newVal.projectBalance.ywfClfZxZjPaid;
            this.tableDataList[3].children[0].specialUnpaid = newVal.projectBalance.ywfClfZxZjUnpaid;
            this.tableDataList[3].children[0].selfPaid = newVal.projectBalance.ywfClfZcZjPaid;
            this.tableDataList[3].children[0].selfUnpaid = newVal.projectBalance.ywfClfZcZjUnpaid;
            this.tableDataList[3].children[0].totalPaid = newVal.projectBalance.ywfClfZjPaid;
            this.tableDataList[3].children[0].totalUnpaid = newVal.projectBalance.ywfClfZjUnpaid;
            /* 业务费_资料费 */
            this.tableDataList[3].children[1].specialBudget = newVal.projectFunds.ywfZlfZxZj;
            this.tableDataList[3].children[1].selfBudget = newVal.projectFunds.ywfZlfZcZj;
            this.tableDataList[3].children[1].specialPaid = newVal.projectBalance.ywfZlfZxZjPaid;
            this.tableDataList[3].children[1].specialUnpaid = newVal.projectBalance.ywfZlfZxZjUnpaid;
            this.tableDataList[3].children[1].selfPaid = newVal.projectBalance.ywfZlfZcZjPaid;
            this.tableDataList[3].children[1].selfUnpaid = newVal.projectBalance.ywfZlfZcZjUnpaid;
            this.tableDataList[3].children[1].totalPaid = newVal.projectBalance.ywfZlfZjPaid;
            this.tableDataList[3].children[1].totalUnpaid = newVal.projectBalance.ywfZlfZjUnpaid;
            /* 业务费_数据/样本采集费 */
            this.tableDataList[3].children[2].specialBudget = newVal.projectFunds.ywfSjybcjfZxZj;
            this.tableDataList[3].children[2].selfBudget = newVal.projectFunds.ywfSjybcjfZcZj;
            this.tableDataList[3].children[2].specialPaid = newVal.projectBalance.ywfSjybcjfZxZjPaid;
            this.tableDataList[3].children[2].specialUnpaid = newVal.projectBalance.ywfSjybcjfZxZjUnpaid;
            this.tableDataList[3].children[2].selfPaid = newVal.projectBalance.ywfSjybcjfZcZjPaid;
            this.tableDataList[3].children[2].selfUnpaid = newVal.projectBalance.ywfSjybcjfZcZjUnpaid;
            this.tableDataList[3].children[2].totalPaid = newVal.projectBalance.ywfSjybcjfZjPaid;
            this.tableDataList[3].children[2].totalUnpaid = newVal.projectBalance.ywfSjybcjfZjUnpaid;
            /* 业务费_测试化验加工费 */
            this.tableDataList[3].children[3].specialBudget = newVal.projectFunds.ywfCshyjgfZxZj;
            this.tableDataList[3].children[3].selfBudget = newVal.projectFunds.ywfCshyjgfZcZj;
            this.tableDataList[3].children[3].specialPaid = newVal.projectBalance.ywfCshyjgfZxZjPaid;
            this.tableDataList[3].children[3].specialUnpaid = newVal.projectBalance.ywfCshyjgfZxZjUnpaid;
            this.tableDataList[3].children[3].selfPaid = newVal.projectBalance.ywfCshyjgfZcZjPaid;
            this.tableDataList[3].children[3].selfUnpaid = newVal.projectBalance.ywfCshyjgfZcZjUnpaid;
            this.tableDataList[3].children[3].totalPaid = newVal.projectBalance.ywfCshyjgfZjPaid;
            this.tableDataList[3].children[3].totalUnpaid = newVal.projectBalance.ywfCshyjgfZjUnpaid;
            /* 业务费_燃料动力费 */
            this.tableDataList[3].children[4].specialBudget = newVal.projectFunds.ywfRldlfZxZj;
            this.tableDataList[3].children[4].selfBudget = newVal.projectFunds.ywfRldlfZcZj;
            this.tableDataList[3].children[4].specialPaid = newVal.projectBalance.ywfRldlfZxZjPaid;
            this.tableDataList[3].children[4].specialUnpaid = newVal.projectBalance.ywfRldlfZxZjUnpaid;
            this.tableDataList[3].children[4].selfPaid = newVal.projectBalance.ywfRldlfZcZjPaid;
            this.tableDataList[3].children[4].selfUnpaid = newVal.projectBalance.ywfRldlfZcZjUnpaid;
            this.tableDataList[3].children[4].totalPaid = newVal.projectBalance.ywfRldlfZjPaid;
            this.tableDataList[3].children[4].totalUnpaid = newVal.projectBalance.ywfRldlfZjUnpaid;
            /* 业务费_办公费 */
            this.tableDataList[3].children[5].specialBudget = newVal.projectFunds.ywfBgfZxZj;
            this.tableDataList[3].children[5].selfBudget = newVal.projectFunds.ywfBgfZcZj;
            this.tableDataList[3].children[5].specialPaid = newVal.projectBalance.ywfBgfZxZjPaid;
            this.tableDataList[3].children[5].specialUnpaid = newVal.projectBalance.ywfBgfZxZjUnpaid;
            this.tableDataList[3].children[5].selfPaid = newVal.projectBalance.ywfBgfZcZjPaid;
            this.tableDataList[3].children[5].selfUnpaid = newVal.projectBalance.ywfBgfZcZjUnpaid;
            this.tableDataList[3].children[5].totalPaid = newVal.projectBalance.ywfBgfZjPaid;
            this.tableDataList[3].children[5].totalUnpaid = newVal.projectBalance.ywfBgfZjUnpaid;
            /* 业务费_印刷/出版费 */
            this.tableDataList[3].children[6].specialBudget = newVal.projectFunds.ywfYscbfZxZj;
            this.tableDataList[3].children[6].selfBudget = newVal.projectFunds.ywfYscbfZcZj;
            this.tableDataList[3].children[6].specialPaid = newVal.projectBalance.ywfYscbfZxZjPaid;
            this.tableDataList[3].children[6].specialUnpaid = newVal.projectBalance.ywfYscbfZxZjUnpaid;
            this.tableDataList[3].children[6].selfPaid = newVal.projectBalance.ywfYscbfZcZjPaid;
            this.tableDataList[3].children[6].selfUnpaid = newVal.projectBalance.ywfYscbfZcZjUnpaid;
            this.tableDataList[3].children[6].totalPaid = newVal.projectBalance.ywfYscbfZjPaid;
            this.tableDataList[3].children[6].totalUnpaid = newVal.projectBalance.ywfYscbfZjUnpaid;
            /* 业务费_知识产权事务费 */
            this.tableDataList[3].children[7].specialBudget = newVal.projectFunds.ywfZscqswfZxZj;
            this.tableDataList[3].children[7].selfBudget = newVal.projectFunds.ywfZscqswfZcZj;
            this.tableDataList[3].children[7].specialPaid = newVal.projectBalance.ywfZscqswfZxZjPaid;
            this.tableDataList[3].children[7].specialUnpaid = newVal.projectBalance.ywfZscqswfZxZjUnpaid;
            this.tableDataList[3].children[7].selfPaid = newVal.projectBalance.ywfZscqswfZcZjPaid;
            this.tableDataList[3].children[7].selfUnpaid = newVal.projectBalance.ywfZscqswfZcZjUnpaid;
            this.tableDataList[3].children[7].totalPaid = newVal.projectBalance.ywfZscqswfZjPaid;
            this.tableDataList[3].children[7].totalUnpaid = newVal.projectBalance.ywfZscqswfZjUnpaid;
            /* 业务费_车辆使用费 */
            this.tableDataList[3].children[8].specialBudget = newVal.projectFunds.ywfClsyfZxZj;
            this.tableDataList[3].children[8].selfBudget = newVal.projectFunds.ywfClsyfZcZj;
            this.tableDataList[3].children[8].specialPaid = newVal.projectBalance.ywfClsyfZxZjPaid;
            this.tableDataList[3].children[8].specialUnpaid = newVal.projectBalance.ywfClsyfZxZjUnpaid;
            this.tableDataList[3].children[8].selfPaid = newVal.projectBalance.ywfClsyfZcZjPaid;
            this.tableDataList[3].children[8].selfUnpaid = newVal.projectBalance.ywfClsyfZcZjUnpaid;
            this.tableDataList[3].children[8].totalPaid = newVal.projectBalance.ywfClsyfZjPaid;
            this.tableDataList[3].children[8].totalUnpaid = newVal.projectBalance.ywfClsyfZjUnpaid;
            /* 业务费_出版/文献费 */
            this.tableDataList[3].children[9].specialBudget = newVal.projectFunds.ywfCbwxxxcbzscqswfZxZj;
            this.tableDataList[3].children[9].selfBudget = newVal.projectFunds.ywfCbwxxxcbzscqswfZcZj;
            this.tableDataList[3].children[9].specialPaid = newVal.projectBalance.ywfCbwxxxcbzscqswfZxZjPaid;
            this.tableDataList[3].children[9].specialUnpaid = newVal.projectBalance.ywfCbwxxxcbzscqswfZxZjUnpaid;
            this.tableDataList[3].children[9].selfPaid = newVal.projectBalance.ywfCbwxxxcbzscqswfZcZjPaid;
            this.tableDataList[3].children[9].selfUnpaid = newVal.projectBalance.ywfCbwxxxcbzscqswfZcZjUnpaid;
            this.tableDataList[3].children[9].totalPaid = newVal.projectBalance.ywfCbwxxxcbzscqswfZjPaid;
            this.tableDataList[3].children[9].totalUnpaid = newVal.projectBalance.ywfCbwxxxcbzscqswfZjUnpaid;
            /* 业务费_差旅费 */
            this.tableDataList[3].children[10].specialBudget = newVal.projectFunds.ywfChlfZxZj;
            this.tableDataList[3].children[10].selfBudget = newVal.projectFunds.ywfChlfZcZj;
            this.tableDataList[3].children[10].specialPaid = newVal.projectBalance.ywfChlfZxZjPaid;
            this.tableDataList[3].children[10].specialUnpaid = newVal.projectBalance.ywfChlfZxZjUnpaid;
            this.tableDataList[3].children[10].selfPaid = newVal.projectBalance.ywfChlfZcZjPaid;
            this.tableDataList[3].children[10].selfUnpaid = newVal.projectBalance.ywfChlfZcZjUnpaid;
            this.tableDataList[3].children[10].totalPaid = newVal.projectBalance.ywfChlfZjPaid;
            this.tableDataList[3].children[10].totalUnpaid = newVal.projectBalance.ywfChlfZjUnpaid;
            /* 业务费_会议会务费费 */
            this.tableDataList[3].children[11].specialBudget = newVal.projectFunds.ywfHyhwfZxZj;
            this.tableDataList[3].children[11].selfBudget = newVal.projectFunds.ywfHyhwfZcZj;
            this.tableDataList[3].children[11].specialPaid = newVal.projectBalance.ywfHyhwfZxZjPaid;
            this.tableDataList[3].children[11].specialUnpaid = newVal.projectBalance.ywfHyhwfZxZjUnpaid;
            this.tableDataList[3].children[11].selfPaid = newVal.projectBalance.ywfHyhwfZcZjPaid;
            this.tableDataList[3].children[11].selfUnpaid = newVal.projectBalance.ywfHyhwfZcZjUnpaid;
            this.tableDataList[3].children[11].totalPaid = newVal.projectBalance.ywfHyhwfZjPaid;
            this.tableDataList[3].children[11].totalUnpaid = newVal.projectBalance.ywfHyhwfZjUnpaid;
            /* 业务费_国内协作费 */
            this.tableDataList[3].children[12].specialBudget = newVal.projectFunds.ywfGnxzfZxZj;
            this.tableDataList[3].children[12].selfBudget = newVal.projectFunds.ywfGnxzfZcZj;
            this.tableDataList[3].children[12].specialPaid = newVal.projectBalance.ywfGnxzfZxZjPaid;
            this.tableDataList[3].children[12].specialUnpaid = newVal.projectBalance.ywfGnxzfZxZjUnpaid;
            this.tableDataList[3].children[12].selfPaid = newVal.projectBalance.ywfGnxzfZcZjPaid;
            this.tableDataList[3].children[12].selfUnpaid = newVal.projectBalance.ywfGnxzfZcZjUnpaid;
            this.tableDataList[3].children[12].totalPaid = newVal.projectBalance.ywfGnxzfZjPaid;
            this.tableDataList[3].children[12].totalUnpaid = newVal.projectBalance.ywfGnxzfZjUnpaid;
            /* 业务费_国际合作交流费 */
            this.tableDataList[3].children[13].specialBudget = newVal.projectFunds.ywfGjhzjlfZxZj;
            this.tableDataList[3].children[13].selfBudget = newVal.projectFunds.ywfGjhzjlfZcZj;
            this.tableDataList[3].children[13].specialPaid = newVal.projectBalance.ywfGjhzjlfZxZjPaid;
            this.tableDataList[3].children[13].specialUnpaid = newVal.projectBalance.ywfGjhzjlfZxZjUnpaid;
            this.tableDataList[3].children[13].selfPaid = newVal.projectBalance.ywfGjhzjlfZcZjPaid;
            this.tableDataList[3].children[13].selfUnpaid = newVal.projectBalance.ywfGjhzjlfZcZjUnpaid;
            this.tableDataList[3].children[13].totalPaid = newVal.projectBalance.ywfGjhzjlfZjPaid;
            this.tableDataList[3].children[13].totalUnpaid = newVal.projectBalance.ywfGjhzjlfZjUnpaid;
            /* 业务费_会议/差旅/国际合作与交流费 */
            this.tableDataList[3].children[14].specialBudget = newVal.projectFunds.ywfHyclgjhzyjlfZxZj;
            this.tableDataList[3].children[14].selfBudget = newVal.projectFunds.ywfHyclgjhzyjlfZcZj;
            this.tableDataList[3].children[14].specialPaid = newVal.projectBalance.ywfHyclgjhzyjlfZxZjPaid;
            this.tableDataList[3].children[14].specialUnpaid = newVal.projectBalance.ywfHyclgjhzyjlfZxZjUnpaid;
            this.tableDataList[3].children[14].selfPaid = newVal.projectBalance.ywfHyclgjhzyjlfZcZjPaid;
            this.tableDataList[3].children[14].selfUnpaid = newVal.projectBalance.ywfHyclgjhzyjlfZcZjUnpaid;
            this.tableDataList[3].children[14].totalPaid = newVal.projectBalance.ywfHyclgjhzyjlfZjPaid;
            this.tableDataList[3].children[14].totalUnpaid = newVal.projectBalance.ywfHyclgjhzyjlfZjUnpaid;

            /* 劳务费 */
            this.tableDataList[4].budget = newVal.projectFunds.lwfZj;
            this.tableDataList[4].specialBudget = newVal.projectFunds.lwfZxZj;
            this.tableDataList[4].selfBudget = newVal.projectFunds.lwfZcZj;
            this.tableDataList[4].specialPaid = newVal.projectBalance.lwfZxZjPaid;
            this.tableDataList[4].specialUnpaid = newVal.projectBalance.lwfZxZjUnpaid;
            this.tableDataList[4].selfPaid = newVal.projectBalance.lwfZcZjPaid;
            this.tableDataList[4].selfUnpaid = newVal.projectBalance.lwfZcZjUnpaid;
            this.tableDataList[4].totalPaid = newVal.projectBalance.lwfZjPaid;
            this.tableDataList[4].totalUnpaid = newVal.projectBalance.lwfZjUnpaid;
            /* 劳务费_专家咨询费 */
            this.tableDataList[4].children[0].specialBudget = newVal.projectFunds.lwfZjzxfZxZj;
            this.tableDataList[4].children[0].selfBudget = newVal.projectFunds.lwfZjzxfZcZj;
            this.tableDataList[4].children[0].specialPaid = newVal.projectBalance.lwfZjzxfZxZjPaid;
            this.tableDataList[4].children[0].specialUnpaid = newVal.projectBalance.lwfZjzxfZxZjUnpaid;
            this.tableDataList[4].children[0].selfPaid = newVal.projectBalance.lwfZjzxfZcZjPaid;
            this.tableDataList[4].children[0].selfUnpaid = newVal.projectBalance.lwfZjzxfZcZjUnpaid;
            this.tableDataList[4].children[0].totalPaid = newVal.projectBalance.lwfZjzxfZjPaid;
            this.tableDataList[4].children[0].totalUnpaid = newVal.projectBalance.lwfZjzxfZjUnpaid;
            /* 劳务费_人员劳务费 */
            this.tableDataList[4].children[1].specialBudget = newVal.projectFunds.lwfRylwfZxZj;
            this.tableDataList[4].children[1].selfBudget = newVal.projectFunds.lwfRylwfZcZj;
            this.tableDataList[4].children[1].specialPaid = newVal.projectBalance.lwfRylwfZxZjPaid;
            this.tableDataList[4].children[1].specialUnpaid = newVal.projectBalance.lwfRylwfZxZjUnpaid;
            this.tableDataList[4].children[1].selfPaid = newVal.projectBalance.lwfRylwfZcZjPaid;
            this.tableDataList[4].children[1].selfUnpaid = newVal.projectBalance.lwfRylwfZcZjUnpaid;
            this.tableDataList[4].children[1].totalPaid = newVal.projectBalance.lwfRylwfZjPaid;
            this.tableDataList[4].children[1].totalUnpaid = newVal.projectBalance.lwfRylwfZjUnpaid;

            /* 材料费 */
            this.tableDataList[5].budget = newVal.projectFunds.clfZj;
            this.tableDataList[5].specialBudget = newVal.projectFunds.clfZxZj;
            this.tableDataList[5].selfBudget = newVal.projectFunds.clfZcZj;
            this.tableDataList[5].specialPaid = newVal.projectBalance.clfZxZjPaid;
            this.tableDataList[5].specialUnpaid = newVal.projectBalance.clfZxZjUnpaid;
            this.tableDataList[5].selfPaid = newVal.projectBalance.clfZcZjPaid;
            this.tableDataList[5].selfUnpaid = newVal.projectBalance.clfZcZjUnpaid;
            this.tableDataList[5].totalPaid = newVal.projectBalance.clfZjPaid;
            this.tableDataList[5].totalUnpaid = newVal.projectBalance.clfZjUnpaid;
            /* 材料费_材料费 */
            this.tableDataList[5].children[0].specialBudget = newVal.projectFunds.clfClfZxZj;
            this.tableDataList[5].children[0].selfBudget = newVal.projectFunds.clfClfZcZj;
            this.tableDataList[5].children[0].specialPaid = newVal.projectBalance.clfClfZxZjPaid;
            this.tableDataList[5].children[0].specialUnpaid = newVal.projectBalance.clfClfZxZjUnpaid;
            this.tableDataList[5].children[0].selfPaid = newVal.projectBalance.clfClfZcZjPaid;
            this.tableDataList[5].children[0].selfUnpaid = newVal.projectBalance.clfClfZcZjUnpaid;
            this.tableDataList[5].children[0].totalPaid = newVal.projectBalance.clfClfZjPaid;
            this.tableDataList[5].children[0].totalUnpaid = newVal.projectBalance.clfClfZjUnpaid;

            /* 科研活动费 */
            this.tableDataList[6].budget = newVal.projectFunds.kyhdfZj;
            this.tableDataList[6].specialBudget = newVal.projectFunds.kyhdfZxZj;
            this.tableDataList[6].selfBudget = newVal.projectFunds.kyhdfZcZj;
            this.tableDataList[6].specialPaid = newVal.projectBalance.kyhdfZxZjPaid;
            this.tableDataList[6].specialUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            this.tableDataList[6].selfPaid = newVal.projectBalance.kyhdfZcZjPaid;
            this.tableDataList[6].selfUnpaid = newVal.projectBalance.kyhdfZcZjUnpaid;
            this.tableDataList[6].totalPaid = newVal.projectBalance.kyhdfZjPaid;
            this.tableDataList[6].totalUnpaid = newVal.projectBalance.kyhdfZjUnpaid;
            /* 科研活动费_资料费 */
            this.tableDataList[6].children[0].specialBudget = newVal.projectFunds.kyhdfZlZxZj;
            this.tableDataList[6].children[0].selfBudget = newVal.projectFunds.kyhdfZlZcZj;
            this.tableDataList[6].children[0].specialPaid = newVal.projectBalance.kyhdfZlZxZjPaid;
            this.tableDataList[6].children[0].specialUnpaid = newVal.projectBalance.kyhdfZlZxZjUnpaid;
            this.tableDataList[6].children[0].selfPaid = newVal.projectBalance.kyhdfZlZcZjPaid;
            this.tableDataList[6].children[0].selfUnpaid = newVal.projectBalance.kyhdfZlZcZjUnpaid;
            this.tableDataList[6].children[0].totalPaid = newVal.projectBalance.kyhdfZlZjPaid;
            this.tableDataList[6].children[0].totalUnpaid = newVal.projectBalance.kyhdfZlZjUnpaid;
            /* 科研活动费_数据/样本采集费 */
            this.tableDataList[6].children[1].specialBudget = newVal.projectFunds.kyhdfSjybcjZxZj;
            this.tableDataList[6].children[1].selfBudget = newVal.projectFunds.kyhdfSjybcjZcZj;
            this.tableDataList[6].children[1].specialPaid = newVal.projectBalance.kyhdfSjybcjZxZjPaid;
            this.tableDataList[6].children[1].specialUnpaid = newVal.projectBalance.kyhdfSjybcjZxZjUnpaid;
            this.tableDataList[6].children[1].selfPaid = newVal.projectBalance.kyhdfSjybcjZcZjPaid;
            this.tableDataList[6].children[1].selfUnpaid = newVal.projectBalance.kyhdfSjybcjZcZjUnpaid;
            this.tableDataList[6].children[1].totalPaid = newVal.projectBalance.kyhdfSjybcjZjPaid;
            this.tableDataList[6].children[1].totalUnpaid = newVal.projectBalance.kyhdfSjybcjZjUnpaid;
            /* 科研活动费_测试化验加工费 */
            this.tableDataList[6].children[2].specialBudget = newVal.projectFunds.kyhdfSjybcjZxZj;
            this.tableDataList[6].children[2].selfBudget = newVal.projectFunds.kyhdfSjybcjZcZj;
            this.tableDataList[6].children[2].specialPaid = newVal.projectBalance.kyhdfCshyjgZxZjPaid;
            this.tableDataList[6].children[2].specialUnpaid = newVal.projectBalance.kyhdfCshyjgZxZjUnpaid;
            this.tableDataList[6].children[2].selfPaid = newVal.projectBalance.kyhdfCshyjgZcZjPaid;
            this.tableDataList[6].children[2].selfUnpaid = newVal.projectBalance.kyhdfCshyjgZcZjUnpaid;
            this.tableDataList[6].children[2].totalPaid = newVal.projectBalance.kyhdfCshyjgZjPaid;
            this.tableDataList[6].children[2].totalUnpaid = newVal.projectBalance.kyhdfCshyjgZjUnpaid;
            /* 科研活动费_燃料动力费 */
            this.tableDataList[6].children[3].specialBudget = newVal.projectFunds.kyhdfRldlZxZj;
            this.tableDataList[6].children[3].selfBudget = newVal.projectFunds.kyhdfRldlZcZj;
            this.tableDataList[6].children[3].specialPaid = newVal.projectBalance.kyhdfRldlZxZjPaid;
            this.tableDataList[6].children[3].specialUnpaid = newVal.projectBalance.kyhdfRldlZxZjUnpaid;
            this.tableDataList[6].children[3].selfPaid = newVal.projectBalance.kyhdfRldlZcZjPaid;
            this.tableDataList[6].children[3].selfUnpaid = newVal.projectBalance.kyhdfRldlZcZjUnpaid;
            this.tableDataList[6].children[3].totalPaid = newVal.projectBalance.kyhdfRldlZjPaid;
            this.tableDataList[6].children[3].totalUnpaid = newVal.projectBalance.kyhdfRldlZjUnpaid;
            /* 科研活动费_办公费 */
            this.tableDataList[6].children[4].specialBudget = newVal.projectFunds.kyhdfBgZxZj;
            this.tableDataList[6].children[4].selfBudget = newVal.projectFunds.kyhdfBgZcZj;
            this.tableDataList[6].children[4].specialPaid = newVal.projectBalance.kyhdfBgZxZjPaid;
            this.tableDataList[6].children[4].specialUnpaid = newVal.projectBalance.kyhdfBgZxZjUnpaid;
            this.tableDataList[6].children[4].selfPaid = newVal.projectBalance.kyhdfBgZcZjUnpaid;
            this.tableDataList[6].children[4].selfUnpaid = newVal.projectBalance.kyhdfBgZcZjUnpaid;
            this.tableDataList[6].children[4].totalPaid = newVal.projectBalance.kyhdfBgZjPaid;
            this.tableDataList[6].children[4].totalUnpaid = newVal.projectBalance.kyhdfBgZjUnpaid;
            /* 科研活动费_印刷/出版费 */
            this.tableDataList[6].children[5].specialBudget = newVal.projectFunds.kyhdfYscbZxZj;
            this.tableDataList[6].children[5].selfBudget = newVal.projectFunds.kyhdfYscbZcZj;
            this.tableDataList[6].children[5].specialPaid = newVal.projectBalance.kyhdfYscbZxZjPaid;
            this.tableDataList[6].children[5].specialUnpaid = newVal.projectBalance.kyhdfYscbZxZjUnpaid;
            this.tableDataList[6].children[5].selfPaid = newVal.projectBalance.kyhdfYscbZcZjPaid;
            this.tableDataList[6].children[5].selfUnpaid = newVal.projectBalance.kyhdfYscbZcZjUnpaid;
            this.tableDataList[6].children[5].totalPaid = newVal.projectBalance.kyhdfYscbZjPaid;
            this.tableDataList[6].children[5].totalUnpaid = newVal.projectBalance.kyhdfYscbZjUnpaid;
            /* 科研活动费_知识产权事务费 */
            this.tableDataList[6].children[6].specialBudget = newVal.projectFunds.kyhdfZscqswZxZj;
            this.tableDataList[6].children[6].selfBudget = newVal.projectFunds.kyhdfZscqswZcZj;
            this.tableDataList[6].children[6].specialPaid = newVal.projectBalance.kyhdfZscqswZxZjPaid;
            this.tableDataList[6].children[6].specialUnpaid = newVal.projectBalance.kyhdfZscqswZxZjUnpaid;
            this.tableDataList[6].children[6].selfPaid = newVal.projectBalance.kyhdfZscqswZcZjPaid;
            this.tableDataList[6].children[6].selfUnpaid = newVal.projectBalance.kyhdfZscqswZcZjUnpaid;
            this.tableDataList[6].children[6].totalPaid = newVal.projectBalance.kyhdfZscqswZjPaid;
            this.tableDataList[6].children[6].totalUnpaid = newVal.projectBalance.kyhdfZscqswZjUnpaid;
            /* 科研活动费_车辆使用费 */
            this.tableDataList[6].children[7].specialBudget = newVal.projectFunds.kyhdfClsyZxZj;
            this.tableDataList[6].children[7].selfBudget = newVal.projectFunds.kyhdfClsyZcZj;
            this.tableDataList[6].children[7].specialPaid = newVal.projectBalance.kyhdfClsyZxZjPaid;
            this.tableDataList[6].children[7].specialUnpaid = newVal.projectBalance.kyhdfClsyZxZjUnpaid;
            this.tableDataList[6].children[7].selfPaid = newVal.projectBalance.kyhdfClsyZcZjPaid;
            this.tableDataList[6].children[7].selfUnpaid = newVal.projectBalance.kyhdfClsyZcZjUnpaid;
            this.tableDataList[6].children[7].totalPaid = newVal.projectBalance.kyhdfClsyZjPaid;
            this.tableDataList[6].children[7].totalUnpaid = newVal.projectBalance.kyhdfClsyZjUnpaid;

            /* 科研服务费 */
            this.tableDataList[7].budget = newVal.projectFunds.kyfwfZj;
            this.tableDataList[7].specialBudget = newVal.projectFunds.kyfwfZxZj;
            this.tableDataList[7].selfBudget = newVal.projectFunds.kyfwfZcZj;
            this.tableDataList[7].specialPaid = newVal.projectBalance.kyfwfZxZjPaid;
            this.tableDataList[7].specialUnpaid = newVal.projectBalance.kyfwfZxZjUnpaid;
            this.tableDataList[7].selfPaid = newVal.projectBalance.kyfwfZcZjPaid;
            this.tableDataList[7].selfUnpaid = newVal.projectBalance.kyfwfZcZjUnpaid;
            this.tableDataList[7].totalPaid = newVal.projectBalance.kyfwfZjPaid;
            this.tableDataList[7].totalUnpaid = newVal.projectBalance.kyfwfZjUnpaid;
            /* 科研服务费_会议/会务费 */
            this.tableDataList[7].children[0].specialBudget = newVal.projectFunds.kyfwfHyhwZxZj;
            this.tableDataList[7].children[0].selfBudget = newVal.projectFunds.kyfwfHyhwZcZj;
            this.tableDataList[7].children[0].specialPaid = newVal.projectBalance.kyfwfHyhwZxZjPaid;
            this.tableDataList[7].children[0].specialUnpaid = newVal.projectBalance.kyfwfHyhwZxZjUnpaid;
            this.tableDataList[7].children[0].selfPaid = newVal.projectBalance.kyfwfHyhwZcZjPaid;
            this.tableDataList[7].children[0].selfUnpaid = newVal.projectBalance.kyfwfHyhwZcZjUnpaid;
            this.tableDataList[7].children[0].totalPaid = newVal.projectBalance.kyfwfHyhwZjPaid;
            this.tableDataList[7].children[0].totalUnpaid = newVal.projectBalance.kyfwfHyhwZjUnpaid;
            /* 科研服务费_差旅费*/
            this.tableDataList[7].children[1].specialBudget = newVal.projectFunds.kyfwfClZxZj;
            this.tableDataList[7].children[1].selfBudget = newVal.projectFunds.kyfwfClZcZj;
            this.tableDataList[7].children[1].specialPaid = newVal.projectBalance.kyfwfClZxZjPaid;
            this.tableDataList[7].children[1].specialUnpaid = newVal.projectBalance.kyfwfClZxZjUnpaid;
            this.tableDataList[7].children[1].selfPaid = newVal.projectBalance.kyfwfClZcZjPaid;
            this.tableDataList[7].children[1].selfUnpaid = newVal.projectBalance.kyfwfClZcZjUnpaid;
            this.tableDataList[7].children[1].totalPaid = newVal.projectBalance.kyfwfClZjPaid;
            this.tableDataList[7].children[1].totalUnpaid = newVal.projectBalance.kyfwfClZjUnpaid;
            /* 科研服务费_国内协作费*/
            this.tableDataList[7].children[2].specialBudget = newVal.projectFunds.kyfwfGnxzZxZj;
            this.tableDataList[7].children[2].selfBudget = newVal.projectFunds.kyfwfGnxzZcZj;
            this.tableDataList[7].children[2].specialPaid = newVal.projectBalance.kyfwfGnxzZxZjPaid;
            this.tableDataList[7].children[2].specialUnpaid = newVal.projectBalance.kyfwfGnxzZxZjUnpaid;
            this.tableDataList[7].children[2].selfPaid = newVal.projectBalance.kyfwfGnxzZcZjPaid;
            this.tableDataList[7].children[2].selfUnpaid = newVal.projectBalance.kyfwfGnxzZcZjUnpaid;
            this.tableDataList[7].children[2].totalPaid = newVal.projectBalance.kyfwfGnxzZjPaid;
            this.tableDataList[7].children[2].totalUnpaid = newVal.projectBalance.kyfwfGnxzZjUnpaid;
            /* 科研服务费_国际合作交流*/
            this.tableDataList[7].children[3].specialBudget = newVal.projectFunds.kyfwfGjhzjlZxZj;
            this.tableDataList[7].children[3].selfBudget = newVal.projectFunds.kyfwfGjhzjlZcZj;
            this.tableDataList[7].children[3].specialPaid = newVal.projectBalance.kyfwfGjhzjlZxZjPaid;
            this.tableDataList[7].children[3].specialUnpaid = newVal.projectBalance.kyfwfGjhzjlZxZjUnpaid;
            this.tableDataList[7].children[3].selfPaid = newVal.projectBalance.kyfwfGjhzjlZcZjPaid;
            this.tableDataList[7].children[3].selfUnpaid = newVal.projectBalance.kyfwfGjhzjlZcZjUnpaid;
            this.tableDataList[7].children[3].totalPaid = newVal.projectBalance.kyfwfGjhzjlZjPaid;
            this.tableDataList[7].children[3].totalUnpaid = newVal.projectBalance.kyfwfGjhzjlZjUnpaid;
            /* 科研服务费_专家咨询费*/
            this.tableDataList[7].children[4].specialBudget = newVal.projectFunds.kyfwfZjzxZxZj;
            this.tableDataList[7].children[4].selfBudget = newVal.projectFunds.kyfwfZjzxZcZj;
            this.tableDataList[7].children[4].specialPaid = newVal.projectBalance.kyfwfZjzxZxZjPaid;
            this.tableDataList[7].children[4].specialUnpaid = newVal.projectBalance.kyfwfZjzxZxZjUnpaid;
            this.tableDataList[7].children[4].selfPaid = newVal.projectBalance.kyfwfZjzxZcZjPaid;
            this.tableDataList[7].children[4].selfUnpaid = newVal.projectBalance.kyfwfZjzxZcZjUnpaid;
            this.tableDataList[7].children[4].totalPaid = newVal.projectBalance.kyfwfZjzxZjPaid;
            this.tableDataList[7].children[4].totalUnpaid = newVal.projectBalance.kyfwfZjzxZjUnpaid;

            /* 人员和劳务补助费 */
            this.tableDataList[8].budget = newVal.projectFunds.ryhlwbzfZj;
            this.tableDataList[8].specialBudget = newVal.projectFunds.ryhlwbzfZxZj;
            this.tableDataList[8].selfBudget = newVal.projectFunds.ryhlwbzfZcZj;
            this.tableDataList[8].specialPaid = newVal.projectBalance.ryhlwbzfZxZjPaid;
            this.tableDataList[8].specialUnpaid = newVal.projectBalance.ryhlwbzfZxZjUnpaid;
            this.tableDataList[8].selfPaid = newVal.projectBalance.ryhlwbzfZcZjPaid;
            this.tableDataList[8].selfUnpaid = newVal.projectBalance.ryhlwbzfZcZjUnpaid;
            this.tableDataList[8].totalPaid = newVal.projectBalance.ryhlwbzfZjPaid;
            this.tableDataList[8].totalUnpaid = newVal.projectBalance.ryhlwbzfZjUnpaid;
            /* 人员和劳务补助费_人员劳务费 */
            this.tableDataList[8].children[0].specialBudget = newVal.projectFunds.ryhlwbzfRylwZxZj;
            this.tableDataList[8].children[0].selfBudget = newVal.projectFunds.ryhlwbzfRylwZcZj;
            this.tableDataList[8].children[0].specialPaid = newVal.projectBalance.ryhlwbzfRylwZxZjPaid;
            this.tableDataList[8].children[0].specialUnpaid = newVal.projectBalance.ryhlwbzfRylwZxZjUnpaid;
            this.tableDataList[8].children[0].selfPaid = newVal.projectBalance.ryhlwbzfRylwZcZjPaid;
            this.tableDataList[8].children[0].selfUnpaid = newVal.projectBalance.ryhlwbzfRylwZcZjUnpaid;
            this.tableDataList[8].children[0].totalPaid = newVal.projectBalance.ryhlwbzfRylwZjPaid;
            this.tableDataList[8].children[0].totalUnpaid = newVal.projectBalance.ryhlwbzfRylwZjUnpaid;

            /* （二）间接费用 */
            this.tableDataList[9].budget = newVal.projectFunds.totalFundsJj;
            this.tableDataList[9].specialBudget = newVal.projectFunds.totalFundsZxJj;
            this.tableDataList[9].selfBudget = newVal.projectFunds.totalFundsZcJj;
            this.tableDataList[9].specialPaid = newVal.projectBalance.totalFundsZxJjPaid;
            this.tableDataList[9].specialUnpaid = newVal.projectBalance.totalFundsZxJjUnpaid;
            this.tableDataList[9].selfPaid = newVal.projectBalance.totalFundsZcJjPaid;
            this.tableDataList[9].selfUnpaid = newVal.projectBalance.totalFundsZcJjUnpaid;
            this.tableDataList[9].totalPaid = newVal.projectBalance.totalFundsJjPaid;
            this.tableDataList[9].totalUnpaid = newVal.projectBalance.totalFundsJjUnpaid;
            /* 绩效支出 */
            this.tableDataList[9].children[0].budget = newVal.projectFunds.jxzcJj;
            this.tableDataList[9].children[0].specialBudget = newVal.projectFunds.jxzcZxJj;
            this.tableDataList[9].children[0].selfBudget = newVal.projectFunds.jxzcZcJj;
            this.tableDataList[9].children[0].specialPaid = newVal.projectBalance.jxzcZxJjPaid;
            this.tableDataList[9].children[0].specialUnpaid = newVal.projectBalance.jxzcZxJjUnpaid;
            this.tableDataList[9].children[0].selfPaid = newVal.projectBalance.jxzcZcJjPaid;
            this.tableDataList[9].children[0].selfUnpaid = newVal.projectBalance.jxzcZcJjUnpaid;
            this.tableDataList[9].children[0].totalPaid = newVal.projectBalance.jxzcJjPaid;
            this.tableDataList[9].children[0].totalUnpaid = newVal.projectBalance.jxzcJjUnpaid;
            /* 管理费 */
            this.tableDataList[9].children[1].budget = newVal.projectFunds.glfJj;
            this.tableDataList[9].children[1].specialBudget = newVal.projectFunds.glfZxJj;
            this.tableDataList[9].children[1].selfBudget = newVal.projectFunds.glfZcJj;
            this.tableDataList[9].children[1].specialPaid = newVal.projectBalance.glfZxJjPaid;
            this.tableDataList[9].children[1].specialUnpaid = newVal.projectBalance.glfZxJjUnpaid;
            this.tableDataList[9].children[1].selfPaid = newVal.projectBalance.glfZcJjPaid;
            this.tableDataList[9].children[1].selfUnpaid = newVal.projectBalance.glfZcJjUnpaid;
            this.tableDataList[9].children[1].totalPaid = newVal.projectBalance.glfJjPaid;
            this.tableDataList[9].children[1].totalUnpaid = newVal.projectBalance.glfJjUnpaid;
            /* 房屋租赁费 */
            this.tableDataList[9].children[2].budget = newVal.projectFunds.fwzjfJj;
            this.tableDataList[9].children[2].specialBudget = newVal.projectFunds.fwzjfZxJj;
            this.tableDataList[9].children[2].selfBudget = newVal.projectFunds.fwzjfZcJj;
            this.tableDataList[9].children[2].specialPaid = newVal.projectBalance.fwzjfZxJjPaid;
            this.tableDataList[9].children[2].specialUnpaid = newVal.projectBalance.fwzjfZxJjUnpaid;
            this.tableDataList[9].children[2].selfPaid = newVal.projectBalance.fwzjfZcJjPaid;
            this.tableDataList[9].children[2].selfUnpaid = newVal.projectBalance.fwzjfZcJjUnpaid;
            this.tableDataList[9].children[2].totalPaid = newVal.projectBalance.fwzjfJjPaid;
            this.tableDataList[9].children[2].totalUnpaid = newVal.projectBalance.fwzjfJjUnpaid;
            /* 日常水、电、暖费 */
            this.tableDataList[9].children[3].budget = newVal.projectFunds.rcsdnfJj;
            this.tableDataList[9].children[3].specialBudget = newVal.projectFunds.rcsdnfZxJj;
            this.tableDataList[9].children[3].selfBudget = newVal.projectFunds.rcsdnfZcJj;
            this.tableDataList[9].children[3].specialPaid = newVal.projectBalance.rcsdnfZxJjPaid;
            this.tableDataList[9].children[3].specialUnpaid = newVal.projectBalance.rcsdnfZxJjUnpaid;
            this.tableDataList[9].children[3].selfPaid = newVal.projectBalance.rcsdnfZcJjPaid;
            this.tableDataList[9].children[3].selfUnpaid = newVal.projectBalance.rcsdnfZcJjUnpaid;
            this.tableDataList[9].children[3].totalPaid = newVal.projectBalance.rcsdnfJjPaid;
            this.tableDataList[9].children[3].totalUnpaid = newVal.projectBalance.rcsdnfJjUnpaid;
            /* 设备费 */
            this.tableDataList[9].children[4].budget = newVal.projectFunds.sbfJj;
            this.tableDataList[9].children[4].specialBudget = newVal.projectFunds.sbfZxJj;
            this.tableDataList[9].children[4].selfBudget = newVal.projectFunds.sbfZcJj;
            this.tableDataList[9].children[4].specialPaid = newVal.projectBalance.sbfZxJjPaid;
            this.tableDataList[9].children[4].specialUnpaid = newVal.projectBalance.sbfZxJjUnpaid;
            this.tableDataList[9].children[4].selfPaid = newVal.projectBalance.sbfZcJjPaid;
            this.tableDataList[9].children[4].selfUnpaid = newVal.projectBalance.sbfZcJjUnpaid;
            this.tableDataList[9].children[4].totalPaid = newVal.projectBalance.sbfJjPaid;
            this.tableDataList[9].children[4].totalUnpaid = newVal.projectBalance.sbfJjUnpaid;
            /* 材料费 */
            this.tableDataList[9].children[5].budget = newVal.projectFunds.clfJj;
            this.tableDataList[9].children[5].specialBudget = newVal.projectFunds.clfZxJj;
            this.tableDataList[9].children[5].selfBudget = newVal.projectFunds.clfZcJj;
            this.tableDataList[9].children[5].specialPaid = newVal.projectBalance.clfZxJjPaid;
            this.tableDataList[9].children[5].specialUnpaid = newVal.projectBalance.clfZxJjUnpaid;
            this.tableDataList[9].children[5].selfPaid = newVal.projectBalance.clfZcJjPaid;
            this.tableDataList[9].children[5].selfUnpaid = newVal.projectBalance.clfZcJjUnpaid;
            this.tableDataList[9].children[5].totalPaid = newVal.projectBalance.clfJjPaid;
            this.tableDataList[9].children[5].totalUnpaid = newVal.projectBalance.clfJjUnpaid;
            /* 资料费 */
            this.tableDataList[9].children[6].budget = newVal.projectFunds.zlfJj;
            this.tableDataList[9].children[6].specialBudget = newVal.projectFunds.zlfZxJj;
            this.tableDataList[9].children[6].selfBudget = newVal.projectFunds.zlfZcJj;
            this.tableDataList[9].children[6].specialPaid = newVal.projectBalance.zlfZxJjPaid;
            this.tableDataList[9].children[6].specialUnpaid = newVal.projectBalance.zlfZxJjUnpaid;
            this.tableDataList[9].children[6].selfPaid = newVal.projectBalance.zlfZcJjPaid;
            this.tableDataList[9].children[6].selfUnpaid = newVal.projectBalance.zlfZcJjUnpaid;
            this.tableDataList[9].children[6].totalPaid = newVal.projectBalance.zlfJjPaid;
            this.tableDataList[9].children[6].totalUnpaid = newVal.projectBalance.zlfJjUnpaid;
            /* 数据/样本采集费 */
            this.tableDataList[9].children[7].budget = newVal.projectFunds.sjybcjfJj;
            this.tableDataList[9].children[7].specialBudget = newVal.projectFunds.sjybcjfZxJj;
            this.tableDataList[9].children[7].selfBudget = newVal.projectFunds.sjybcjfZcJj;
            this.tableDataList[9].children[7].specialPaid = newVal.projectBalance.sjybcjfZxJjPaid;
            this.tableDataList[9].children[7].specialUnpaid = newVal.projectBalance.sjybcjfZxJjUnpaid;
            this.tableDataList[9].children[7].selfPaid = newVal.projectBalance.sjybcjfZcJjPaid;
            this.tableDataList[9].children[7].selfUnpaid = newVal.projectBalance.sjybcjfZcJjUnpaid;
            this.tableDataList[9].children[7].totalPaid = newVal.projectBalance.sjybcjfJjPaid;
            this.tableDataList[9].children[7].totalUnpaid = newVal.projectBalance.sjybcjfJjUnpaid;
            /* 测试化验加工费 */
            this.tableDataList[9].children[8].budget = newVal.projectFunds.cshyjgfJj;
            this.tableDataList[9].children[8].specialBudget = newVal.projectFunds.cshyjgfZxJj;
            this.tableDataList[9].children[8].selfBudget = newVal.projectFunds.cshyjgfZcJj;
            this.tableDataList[9].children[8].specialPaid = newVal.projectBalance.cshyjgfZxJjPaid;
            this.tableDataList[9].children[8].specialUnpaid = newVal.projectBalance.cshyjgfZxJjUnpaid;
            this.tableDataList[9].children[8].selfPaid = newVal.projectBalance.cshyjgfZcJjPaid;
            this.tableDataList[9].children[8].selfUnpaid = newVal.projectBalance.cshyjgfZcJjUnpaid;
            this.tableDataList[9].children[8].totalPaid = newVal.projectBalance.cshyjgfJjPaid;
            this.tableDataList[9].children[8].totalUnpaid = newVal.projectBalance.cshyjgfJjUnpaid;
            /* 燃料动力费 */
            this.tableDataList[9].children[9].budget = newVal.projectFunds.rldlfJj;
            this.tableDataList[9].children[9].specialBudget = newVal.projectFunds.rldlfZxJj;
            this.tableDataList[9].children[9].selfBudget = newVal.projectFunds.rldlfZcJj;
            this.tableDataList[9].children[9].specialPaid = newVal.projectBalance.rldlfZxJjPaid;
            this.tableDataList[9].children[9].specialUnpaid = newVal.projectBalance.rldlfZxJjUnpaid;
            this.tableDataList[9].children[9].selfPaid = newVal.projectBalance.rldlfZcJjPaid;
            this.tableDataList[9].children[9].selfUnpaid = newVal.projectBalance.rldlfZcJjUnpaid;
            this.tableDataList[9].children[9].totalPaid = newVal.projectBalance.rldlfJjPaid;
            this.tableDataList[9].children[9].totalUnpaid = newVal.projectBalance.rldlfJjUnpaid;
            /* 办公费 */
            this.tableDataList[9].children[10].budget = newVal.projectFunds.bgfJj;
            this.tableDataList[9].children[10].specialBudget = newVal.projectFunds.bgfZxJj;
            this.tableDataList[9].children[10].selfBudget = newVal.projectFunds.bgfZcJj;
            this.tableDataList[9].children[10].specialPaid = newVal.projectBalance.bgfZxJjPaid;
            this.tableDataList[9].children[10].specialUnpaid = newVal.projectBalance.bgfZxJjUnpaid;
            this.tableDataList[9].children[10].selfPaid = newVal.projectBalance.bgfZcJjPaid;
            this.tableDataList[9].children[10].selfUnpaid = newVal.projectBalance.bgfZcJjUnpaid;
            this.tableDataList[9].children[10].totalPaid = newVal.projectBalance.bgfJjPaid;
            this.tableDataList[9].children[10].totalUnpaid = newVal.projectBalance.bgfJjUnpaid;
            /* 印刷/出版费 */
            this.tableDataList[9].children[11].budget = newVal.projectFunds.yscbfJj;
            this.tableDataList[9].children[11].specialBudget = newVal.projectFunds.yscbfZxJj;
            this.tableDataList[9].children[11].selfBudget = newVal.projectFunds.yscbfZcJj;
            this.tableDataList[9].children[11].specialPaid = newVal.projectBalance.yscbfZxJjPaid;
            this.tableDataList[9].children[11].specialUnpaid = newVal.projectBalance.yscbfZxJjUnpaid;
            this.tableDataList[9].children[11].selfPaid = newVal.projectBalance.yscbfZcJjPaid;
            this.tableDataList[9].children[11].selfUnpaid = newVal.projectBalance.yscbfZcJjUnpaid;
            this.tableDataList[9].children[11].totalPaid = newVal.projectBalance.yscbfJjPaid;
            this.tableDataList[9].children[11].totalUnpaid = newVal.projectBalance.yscbfJjUnpaid;
            /* 知识产权事务费 */
            this.tableDataList[9].children[12].budget = newVal.projectFunds.zscqswfJj;
            this.tableDataList[9].children[12].specialBudget = newVal.projectFunds.zscqswfZxJj;
            this.tableDataList[9].children[12].selfBudget = newVal.projectFunds.zscqswfZcJj;
            this.tableDataList[9].children[12].specialPaid = newVal.projectBalance.zscqswfZxJjPaid;
            this.tableDataList[9].children[12].specialUnpaid = newVal.projectBalance.zscqswfZxJjUnpaid;
            this.tableDataList[9].children[12].selfPaid = newVal.projectBalance.zscqswfZcJjPaid;
            this.tableDataList[9].children[12].selfUnpaid = newVal.projectBalance.zscqswfZcJjUnpaid;
            this.tableDataList[9].children[12].totalPaid = newVal.projectBalance.zscqswfJjPaid;
            this.tableDataList[9].children[12].totalUnpaid = newVal.projectBalance.zscqswfJjUnpaid;
            /* 车辆使用费 */
            this.tableDataList[9].children[13].budget = newVal.projectFunds.clsyfJj;
            this.tableDataList[9].children[13].specialBudget = newVal.projectFunds.clsyfZxJj;
            this.tableDataList[9].children[13].selfBudget = newVal.projectFunds.clsyfZcJj;
            this.tableDataList[9].children[13].specialPaid = newVal.projectBalance.clsyfZxJjPaid;
            this.tableDataList[9].children[13].specialUnpaid = newVal.projectBalance.clsyfZxJjUnpaid;
            this.tableDataList[9].children[13].selfPaid = newVal.projectBalance.clsyfZcJjPaid;
            this.tableDataList[9].children[13].selfUnpaid = newVal.projectBalance.clsyfZcJjUnpaid;
            this.tableDataList[9].children[13].totalPaid = newVal.projectBalance.clsyfJjPaid;
            this.tableDataList[9].children[13].totalUnpaid = newVal.projectBalance.clsyfJjUnpaid;
            /* 差旅费 */
            this.tableDataList[9].children[14].budget = newVal.projectFunds.chlfJj;
            this.tableDataList[9].children[14].specialBudget = newVal.projectFunds.chlfZxJj;
            this.tableDataList[9].children[14].selfBudget = newVal.projectFunds.chlfZcJj;
            this.tableDataList[9].children[14].specialPaid = newVal.projectBalance.chlfZxJjPaid;
            this.tableDataList[9].children[14].specialUnpaid = newVal.projectBalance.chlfZxJjUnpaid;
            this.tableDataList[9].children[14].selfPaid = newVal.projectBalance.chlfZcJjPaid;
            this.tableDataList[9].children[14].selfUnpaid = newVal.projectBalance.chlfZcJjUnpaid;
            this.tableDataList[9].children[14].totalPaid = newVal.projectBalance.chlfJjPaid;
            this.tableDataList[9].children[14].totalUnpaid = newVal.projectBalance.chlfJjUnpaid;
            /* 会议/会务费 */
            this.tableDataList[9].children[15].budget = newVal.projectFunds.hyhwfJj;
            this.tableDataList[9].children[15].specialBudget = newVal.projectFunds.hyhwfZxJj;
            this.tableDataList[9].children[15].selfBudget = newVal.projectFunds.hyhwfZcJj;
            this.tableDataList[9].children[15].specialPaid = newVal.projectBalance.hyhwfZxJjPaid;
            this.tableDataList[9].children[15].specialUnpaid = newVal.projectBalance.hyhwfZxJjUnpaid;
            this.tableDataList[9].children[15].selfPaid = newVal.projectBalance.hyhwfZcJjPaid;
            this.tableDataList[9].children[15].selfUnpaid = newVal.projectBalance.hyhwfZcJjUnpaid;
            this.tableDataList[9].children[15].totalPaid = newVal.projectBalance.hyhwfJjPaid;
            this.tableDataList[9].children[15].totalUnpaid = newVal.projectBalance.hyhwfJjUnpaid;
            /* 专家咨询费 */
            this.tableDataList[9].children[16].budget = newVal.projectFunds.zjzxfJj;
            this.tableDataList[9].children[16].specialBudget = newVal.projectFunds.zjzxfZxJj;
            this.tableDataList[9].children[16].selfBudget = newVal.projectFunds.zjzxfZcJj;
            this.tableDataList[9].children[16].specialPaid = newVal.projectBalance.zjzxfZxJjPaid;
            this.tableDataList[9].children[16].specialUnpaid = newVal.projectBalance.zjzxfZxJjUnpaid;
            this.tableDataList[9].children[16].selfPaid = newVal.projectBalance.zjzxfZcJjPaid;
            this.tableDataList[9].children[16].selfUnpaid = newVal.projectBalance.zjzxfZcJjUnpaid;
            this.tableDataList[9].children[16].totalPaid = newVal.projectBalance.zjzxfJjPaid;
            this.tableDataList[9].children[16].totalUnpaid = newVal.projectBalance.zjzxfJjUnpaid;
            /* 其他 */
            this.tableDataList[9].children[17].budget = newVal.projectFunds.othersJj;
            this.tableDataList[9].children[17].specialBudget = newVal.projectFunds.othersZxJj;
            this.tableDataList[9].children[17].selfBudget = newVal.projectFunds.othersZcJj;
            this.tableDataList[9].children[17].specialPaid = newVal.projectBalance.othersZxPaid;
            this.tableDataList[9].children[17].specialUnpaid = newVal.projectBalance.othersZxUnpaid;
            this.tableDataList[9].children[17].selfPaid = newVal.projectBalance.othersZcPaid;
            this.tableDataList[9].children[17].selfUnpaid = newVal.projectBalance.othersZcUnpaid;
            this.tableDataList[9].children[17].totalPaid = newVal.projectBalance.othersJjPaid;
            this.tableDataList[9].children[17].totalUnpaid = newVal.projectBalance.othersJjUnpaid;
        }
    },
};
</script>
<style scoped>
.row-hover {
    background-color: #eef1f6 !important;
    /* 悬浮行的背景色 */
}

::v-deep .el-table tbody tr:hover>td {
    background-color: rgb(44, 133, 44) !important;
    color: #eef1f6
}

::v-deep .el-table__body tr.current-row>td {
    background-color: rgb(44, 133, 44) !important;
    color: #eef1f6
}
</style>
