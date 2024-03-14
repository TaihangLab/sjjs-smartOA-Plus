<template>
    <div>
        <div style="margin-top: 10px;"></div>
        <el-table @row-mouseenter="handleRowMouseEnter" @row-mouseleave="handleRowMouseLeave"
            :row-class-name="getRowClassName" :data="tableDataList" style="width: 100%;margin-bottom: 20px;"
            height="550px" row-key="id" border :cell-style="columnStyle"
            :tree-props="{ children: 'children', hasChildren: 'hasChildren' }" highlight-current-row>
            <el-table-column prop="label" label="预算科目名称" sortable width="180"></el-table-column>
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
            /* 设备费 */
            this.tableDataList[2].budget = 10;
            this.tableDataList[2].specialBudget = newVal.projectFunds.sbfZxZj;
            this.tableDataList[2].selfBudget = newVal.projectFunds.sbfZcZj;
            this.tableDataList[2].specialPaid = newVal.projectBalance.sbfZxZjPaid;
            this.tableDataList[2].specialUnpaid = newVal.projectBalance.sbfZxZjUnpaid;
            this.tableDataList[2].selfPaid = newVal.projectBalance.sbfZcZjPaid;
            this.tableDataList[2].selfUnpaid = newVal.projectBalance.sbfZcZjUnpaid;
            // this.tableDataList[2].totalPaid = newVal.projectBalance.;
            // this.tableDataList[2].totalUnpaid = newVal.projectBalance.;
            /* 设备费_购置设备费 */
            this.tableDataList[2].children[0].specialBudget = newVal.projectFunds.sbfGzsbZxZj;
            this.tableDataList[2].children[0].selfBudget = newVal.projectFunds.sbfGzsbZcZj;
            this.tableDataList[2].children[0].specialPaid = newVal.projectBalance.sbfGzsbZxZjPaid;
            this.tableDataList[2].children[0].specialUnpaid = newVal.projectBalance.sbfGzsbZxZjUnpaid;
            this.tableDataList[2].children[0].selfPaid = newVal.projectBalance.sbfGzsbZcZjPaid;
            this.tableDataList[2].children[0].selfUnpaid = newVal.projectBalance.sbfGzsbZcZjUnpaid;
            // this.tableDataList[2].children[0].totalPaid = newVal.projectBalance.;
            // this.tableDataList[2].children[0].totalUnpaid = newVal.projectBalance.;
            /* 设备费_试制设备费 */
            this.tableDataList[2].children[1].specialBudget = newVal.projectFunds.sbfSzsbZxZj;
            this.tableDataList[2].children[1].selfBudget = newVal.projectFunds.sbfSzsbZcZj;
            this.tableDataList[2].children[1].specialPaid = newVal.projectBalance.sbfSzsbZxZjPaid;
            this.tableDataList[2].children[1].specialUnpaid = newVal.projectBalance.sbfSzsbZxZjUnpaid;
            this.tableDataList[2].children[1].selfPaid = newVal.projectBalance.sbfSzsbZcZjPaid;
            this.tableDataList[2].children[1].selfUnpaid = newVal.projectBalance.sbfSzsbZcZjUnpaid;
            // this.tableDataList[2].children[1].totalPaid = newVal.projectBalance.;
            // this.tableDataList[2].children[1].totalUnpaid = newVal.projectBalance.;
            /* 设备费_设备升级改造费 */
            this.tableDataList[2].children[2].specialBudget = newVal.projectFunds.sbfSbsjgzZxZj;
            this.tableDataList[2].children[2].selfBudget = newVal.projectFunds.sbfSbsjgzZcZj;
            this.tableDataList[2].children[2].specialPaid = newVal.projectBalance.sbfSbsjgzZxZjPaid;
            this.tableDataList[2].children[2].specialUnpaid = newVal.projectBalance.sbfSbsjgzZxZjUnpaid;
            this.tableDataList[2].children[2].selfPaid = newVal.projectBalance.sbfSbsjgzZcZjPaid;
            this.tableDataList[2].children[2].selfUnpaid = newVal.projectBalance.sbfSbsjgzZcZjUnpaid;
            // this.tableDataList[2].children[2].totalPaid = newVal.projectBalance.;
            // this.tableDataList[2].children[2].totalUnpaid = newVal.projectBalance.;
            /* 设备费_设备租赁费 */
            this.tableDataList[2].children[3].specialBudget = newVal.projectFunds.sbfSbzlZxZj;
            this.tableDataList[2].children[3].selfBudget = newVal.projectFunds.sbfSbzlZcZj;
            this.tableDataList[2].children[3].specialPaid = newVal.projectBalance.sbfSbzlZxZjPaid;
            this.tableDataList[2].children[3].specialUnpaid = newVal.projectBalance.sbfSbzlZxZjUnpaid;
            this.tableDataList[2].children[3].selfPaid = newVal.projectBalance.sbfSbzlZcZjPaid;
            this.tableDataList[2].children[3].selfUnpaid = newVal.projectBalance.sbfSbzlZcZjUnpaid;
            // this.tableDataList[2].children[3].totalPaid = newVal.projectBalance.;
            // this.tableDataList[2].children[3].totalUnpaid = newVal.projectBalance.;

            /* 业务费 */
            this.tableDataList[3].budget = 10;
            this.tableDataList[3].specialBudget = newVal.projectFunds.ywfZxZj;
            this.tableDataList[3].selfBudget = newVal.projectFunds.ywfZcZj;
            this.tableDataList[3].specialPaid = newVal.projectBalance.ywfZxZjPaid;
            this.tableDataList[3].specialUnpaid = newVal.projectBalance.ywfZxZjUnpaid;
            this.tableDataList[3].selfPaid = newVal.projectBalance.ywfZcZjPaid;
            this.tableDataList[3].selfUnpaid = newVal.projectBalance.ywfZcZjUnpaid;
            // this.tableDataList[3].totalPaid = newVal.projectBalance.;
            // this.tableDataList[3].totalUnpaid = newVal.projectBalance.;
            /* 业务费_材料费 */
            this.tableDataList[3].children[0].specialBudget = newVal.projectFunds.ywfClfZxZj;
            this.tableDataList[3].children[0].selfBudget = newVal.projectFunds.ywfClfZcZj;
            this.tableDataList[3].children[0].specialPaid = newVal.projectBalance.ywfClfZxZjPaid;
            this.tableDataList[3].children[0].specialUnpaid = newVal.projectBalance.ywfClfZxZjUnpaid;
            this.tableDataList[3].children[0].selfPaid = newVal.projectBalance.ywfClfZcZjPaid;
            this.tableDataList[3].children[0].selfUnpaid = newVal.projectBalance.ywfClfZcZjUnpaid;
            // this.tableDataList[3].children[0].totalPaid = newVal.projectBalance.;
            // this.tableDataList[3].children[0].totalUnpaid = newVal.projectBalance.;
            /* 业务费_资料费 */
            this.tableDataList[3].children[1].specialBudget = newVal.projectFunds.ywfZlfZxZj;
            this.tableDataList[3].children[1].selfBudget = newVal.projectFunds.ywfZlfZcZj;
            this.tableDataList[3].children[1].specialPaid = newVal.projectBalance.ywfZlfZxZjPaid;
            this.tableDataList[3].children[1].specialUnpaid = newVal.projectBalance.ywfZlfZxZjUnpaid;
            this.tableDataList[3].children[1].selfPaid = newVal.projectBalance.ywfZlfZcZjPaid;
            this.tableDataList[3].children[1].selfUnpaid = newVal.projectBalance.ywfZlfZcZjUnpaid;
            // this.tableDataList[3].children[1].totalPaid = newVal.projectBalance.;
            // this.tableDataList[3].children[1].totalUnpaid = newVal.projectBalance.;
            /* 业务费_数据/样本采集费 */
            this.tableDataList[3].children[2].specialBudget = newVal.projectFunds.ywfSjybcjfZxZj;
            this.tableDataList[3].children[2].selfBudget = newVal.projectFunds.ywfSjybcjfZcZj;
            this.tableDataList[3].children[2].specialPaid = newVal.projectBalance.ywfSjybcjfZxZjPaid;
            this.tableDataList[3].children[2].specialUnpaid = newVal.projectBalance.ywfSjybcjfZxZjUnpaid;
            this.tableDataList[3].children[2].selfPaid = newVal.projectBalance.ywfSjybcjfZcZjPaid;
            this.tableDataList[3].children[2].selfUnpaid = newVal.projectBalance.ywfSjybcjfZcZjUnpaid;
            // this.tableDataList[3].children[2].totalPaid = newVal.projectBalance.;
            // this.tableDataList[3].children[2].totalUnpaid = newVal.projectBalance.;
            /* 业务费_测试化验加工费 */
            this.tableDataList[3].children[3].specialBudget = newVal.projectFunds.ywfCshyjgfZxZj;
            this.tableDataList[3].children[3].selfBudget = newVal.projectFunds.ywfCshyjgfZcZj;
            this.tableDataList[3].children[3].specialPaid = newVal.projectBalance.ywfCshyjgfZxZjPaid;
            this.tableDataList[3].children[3].specialUnpaid = newVal.projectBalance.ywfCshyjgfZxZjUnpaid;
            this.tableDataList[3].children[3].selfPaid = newVal.projectBalance.ywfCshyjgfZcZjPaid;
            this.tableDataList[3].children[3].selfUnpaid = newVal.projectBalance.ywfCshyjgfZcZjUnpaid;
            // this.tableDataList[3].children[3].totalPaid = newVal.projectBalance.;
            // this.tableDataList[3].children[3].totalUnpaid = newVal.projectBalance.;
            /* 业务费_燃料动力费 */
            this.tableDataList[3].children[4].specialBudget = newVal.projectFunds.ywfRldlfZxZj;
            this.tableDataList[3].children[4].selfBudget = newVal.projectFunds.ywfRldlfZcZj;
            this.tableDataList[3].children[4].specialPaid = newVal.projectBalance.ywfRldlfZxZjPaid;
            this.tableDataList[3].children[4].specialUnpaid = newVal.projectBalance.ywfRldlfZxZjUnpaid;
            this.tableDataList[3].children[4].selfPaid = newVal.projectBalance.ywfRldlfZcZjPaid;
            this.tableDataList[3].children[4].selfUnpaid = newVal.projectBalance.ywfRldlfZcZjUnpaid;
            // this.tableDataList[3].children[4].totalPaid = newVal.projectBalance.;
            // this.tableDataList[3].children[4].totalUnpaid = newVal.projectBalance.;
            /* 业务费_办公费 */
            this.tableDataList[3].children[5].specialBudget = newVal.projectFunds.ywfBgfZxZj;
            this.tableDataList[3].children[5].selfBudget = newVal.projectFunds.ywfBgfZcZj;
            this.tableDataList[3].children[5].specialPaid = newVal.projectBalance.ywfBgfZxZjPaid;
            this.tableDataList[3].children[5].specialUnpaid = newVal.projectBalance.ywfBgfZxZjUnpaid;
            this.tableDataList[3].children[5].selfPaid = newVal.projectBalance.ywfBgfZcZjPaid;
            this.tableDataList[3].children[5].selfUnpaid = newVal.projectBalance.ywfBgfZcZjUnpaid;
            // this.tableDataList[3].children[5].totalPaid = newVal.projectBalance.;
            // this.tableDataList[3].children[5].totalUnpaid = newVal.projectBalance.;
            /* 业务费_印刷/出版费 */
            this.tableDataList[3].children[6].specialBudget = newVal.projectFunds.ywfYscbfZxZj;
            this.tableDataList[3].children[6].selfBudget = newVal.projectFunds.ywfYscbfZcZj;
            this.tableDataList[3].children[6].specialPaid = newVal.projectBalance.ywfYscbfZxZjPaid;
            this.tableDataList[3].children[6].specialUnpaid = newVal.projectBalance.ywfYscbfZxZjUnpaid;
            this.tableDataList[3].children[6].selfPaid = newVal.projectBalance.ywfYscbfZcZjPaid;
            this.tableDataList[3].children[6].selfUnpaid = newVal.projectBalance.ywfYscbfZcZjUnpaid;
            // this.tableDataList[3].children[6].totalPaid = newVal.projectBalance.;
            // this.tableDataList[3].children[6].totalUnpaid = newVal.projectBalance.;
            /* 业务费_知识产权事务费 */
            this.tableDataList[3].children[7].specialBudget = newVal.projectFunds.ywfZscqswfZxZj;
            this.tableDataList[3].children[7].selfBudget = newVal.projectFunds.ywfZscqswfZcZj;
            this.tableDataList[3].children[7].specialPaid = newVal.projectBalance.ywfZscqswfZxZjPaid;
            this.tableDataList[3].children[7].specialUnpaid = newVal.projectBalance.ywfZscqswfZxZjUnpaid;
            this.tableDataList[3].children[7].selfPaid = newVal.projectBalance.ywfZscqswfZcZjPaid;
            this.tableDataList[3].children[7].selfUnpaid = newVal.projectBalance.ywfZscqswfZcZjUnpaid;
            // this.tableDataList[3].children[7].totalPaid = newVal.projectBalance.;
            // this.tableDataList[3].children[7].totalUnpaid = newVal.projectBalance.;
            /* 业务费_车辆使用费 */
            this.tableDataList[3].children[8].specialBudget = newVal.projectFunds.ywfClsyfZxZj;
            this.tableDataList[3].children[8].selfBudget = newVal.projectFunds.ywfClsyfZcZj;
            this.tableDataList[3].children[8].specialPaid = newVal.projectBalance.ywfClsyfZxZjPaid;
            this.tableDataList[3].children[8].specialUnpaid = newVal.projectBalance.ywfClsyfZxZjUnpaid;
            this.tableDataList[3].children[8].selfPaid = newVal.projectBalance.ywfClsyfZcZjPaid;
            this.tableDataList[3].children[8].selfUnpaid = newVal.projectBalance.ywfClsyfZcZjUnpaid;
            // this.tableDataList[3].children[8].totalPaid = newVal.projectBalance.;
            // this.tableDataList[3].children[8].totalUnpaid = newVal.projectBalance.;
            /* 业务费_出版/文献费 */
            this.tableDataList[3].children[9].specialBudget = newVal.projectFunds.ywfCbwxxxcbzscqswfZxZj;
            this.tableDataList[3].children[9].selfBudget = newVal.projectFunds.ywfCbwxxxcbzscqswfZcZj;
            this.tableDataList[3].children[9].specialPaid = newVal.projectBalance.ywfCbwxxxcbzscqswfZxZjPaid;
            this.tableDataList[3].children[9].specialUnpaid = newVal.projectBalance.ywfCbwxxxcbzscqswfZxZjUnpaid;
            this.tableDataList[3].children[9].selfPaid = newVal.projectBalance.ywfCbwxxxcbzscqswfZcZjPaid;
            this.tableDataList[3].children[9].selfUnpaid = newVal.projectBalance.ywfCbwxxxcbzscqswfZcZjUnpaid;
            // this.tableDataList[3].children[9].totalPaid = newVal.projectBalance.;
            // this.tableDataList[3].children[9].totalUnpaid = newVal.projectBalance.;
            /* 业务费_差旅费 */
            this.tableDataList[3].children[10].specialBudget = newVal.projectFunds.ywfChlfZxZj;
            this.tableDataList[3].children[10].selfBudget = newVal.projectFunds.ywfChlfZcZj;
            this.tableDataList[3].children[10].specialPaid = newVal.projectBalance.ywfChlfZxZjPaid;
            this.tableDataList[3].children[10].specialUnpaid = newVal.projectBalance.ywfChlfZxZjUnpaid;
            this.tableDataList[3].children[10].selfPaid = newVal.projectBalance.ywfChlfZcZjPaid;
            this.tableDataList[3].children[10].selfUnpaid = newVal.projectBalance.ywfChlfZcZjUnpaid;
            // this.tableDataList[3].children[10].totalPaid = newVal.projectBalance.;
            // this.tableDataList[3].children[10].totalUnpaid = newVal.projectBalance.;
            /* 业务费_会议会务费费 */
            this.tableDataList[3].children[11].specialBudget = newVal.projectFunds.ywfHyhwfZxZj;
            this.tableDataList[3].children[11].selfBudget = newVal.projectFunds.ywfHyhwfZcZj;
            this.tableDataList[3].children[11].specialPaid = newVal.projectBalance.ywfHyhwfZxZjPaid;
            this.tableDataList[3].children[11].specialUnpaid = newVal.projectBalance.ywfHyhwfZxZjUnpaid;
            this.tableDataList[3].children[11].selfPaid = newVal.projectBalance.ywfHyhwfZcZjPaid;
            this.tableDataList[3].children[11].selfUnpaid = newVal.projectBalance.ywfHyhwfZcZjUnpaid;
            // this.tableDataList[3].children[11].totalPaid = newVal.projectBalance.;
            // this.tableDataList[3].children[11].totalUnpaid = newVal.projectBalance.;
            /* 业务费_国内协作费 */
            this.tableDataList[3].children[12].specialBudget = newVal.projectFunds.ywfGnxzfZxZj;
            this.tableDataList[3].children[12].selfBudget = newVal.projectFunds.ywfGnxzfZcZj;
            this.tableDataList[3].children[12].specialPaid = newVal.projectBalance.ywfGnxzfZxZjPaid;
            this.tableDataList[3].children[12].specialUnpaid = newVal.projectBalance.ywfGnxzfZxZjUnpaid;
            this.tableDataList[3].children[12].selfPaid = newVal.projectBalance.ywfGnxzfZcZjPaid;
            this.tableDataList[3].children[12].selfUnpaid = newVal.projectBalance.ywfGnxzfZcZjUnpaid;
            // this.tableDataList[3].children[12].totalPaid = newVal.projectBalance.;
            // this.tableDataList[3].children[12].totalUnpaid = newVal.projectBalance.;
            /* 业务费_国际合作交流费 */
            this.tableDataList[3].children[13].specialBudget = newVal.projectFunds.ywfGjhzjlfZxZj;
            this.tableDataList[3].children[13].selfBudget = newVal.projectFunds.ywfGjhzjlfZcZj;
            this.tableDataList[3].children[13].specialPaid = newVal.projectBalance.ywfGjhzjlfZxZjPaid;
            this.tableDataList[3].children[13].specialUnpaid = newVal.projectBalance.ywfGjhzjlfZxZjUnpaid;
            this.tableDataList[3].children[13].selfPaid = newVal.projectBalance.ywfGjhzjlfZcZjPaid;
            this.tableDataList[3].children[13].selfUnpaid = newVal.projectBalance.ywfGjhzjlfZcZjUnpaid;
            // this.tableDataList[3].children[13].totalPaid = newVal.projectBalance.;
            // this.tableDataList[3].children[13].totalUnpaid = newVal.projectBalance.;
            /* 业务费_会议/差旅/国际合作与交流费 */
            this.tableDataList[3].children[14].specialBudget = newVal.projectFunds.ywfHyclgjhzyjlfZxZj;
            this.tableDataList[3].children[14].selfBudget = newVal.projectFunds.ywfHyclgjhzyjlfZcZj;
            this.tableDataList[3].children[14].specialPaid = newVal.projectBalance.ywfHyclgjhzyjlfZxZjPaid;
            this.tableDataList[3].children[14].specialUnpaid = newVal.projectBalance.ywfHyclgjhzyjlfZxZjUnpaid;
            this.tableDataList[3].children[14].selfPaid = newVal.projectBalance.ywfHyclgjhzyjlfZcZjPaid;
            this.tableDataList[3].children[14].selfUnpaid = newVal.projectBalance.ywfHyclgjhzyjlfZcZjUnpaid;
            // this.tableDataList[3].children[14].totalPaid = newVal.projectBalance.;
            // this.tableDataList[3].children[14].totalUnpaid = newVal.projectBalance.;

            /* 劳务费 */
            this.tableDataList[4].budget = 10;
            this.tableDataList[4].specialBudget = newVal.projectFunds.lwfZxZj;
            this.tableDataList[4].selfBudget = newVal.projectFunds.lwfZcZj;
            this.tableDataList[4].specialPaid = newVal.projectBalance.lwfZxZjPaid;
            this.tableDataList[4].specialUnpaid = newVal.projectBalance.lwfZxZjUnpaid;
            this.tableDataList[4].selfPaid = newVal.projectBalance.lwfZcZjPaid;
            this.tableDataList[4].selfUnpaid = newVal.projectBalance.lwfZcZjUnpaid;
            // this.tableDataList[4].totalPaid = newVal.projectBalance.;
            // this.tableDataList[4].totalUnpaid = newVal.projectBalance.;
            /* 劳务费_专家咨询费 */
            this.tableDataList[4].children[0].specialBudget = newVal.projectFunds.lwfZjzxfZxZj;
            this.tableDataList[4].children[0].selfBudget = newVal.projectFunds.lwfZjzxfZcZj;
            this.tableDataList[4].children[0].specialPaid = newVal.projectBalance.lwfZjzxfZxZjPaid;
            this.tableDataList[4].children[0].specialUnpaid = newVal.projectBalance.lwfZjzxfZxZjUnpaid;
            this.tableDataList[4].children[0].selfPaid = newVal.projectBalance.lwfZjzxfZcZjPaid;
            this.tableDataList[4].children[0].selfUnpaid = newVal.projectBalance.lwfZjzxfZcZjUnpaid;
            // this.tableDataList[4].children[0].totalPaid = newVal.projectBalance.;
            // this.tableDataList[4].children[0].totalUnpaid = newVal.projectBalance.;
            /* 劳务费_人员劳务费 */
            this.tableDataList[4].children[1].specialBudget = newVal.projectFunds.lwfRylwfZxZj;
            this.tableDataList[4].children[1].selfBudget = newVal.projectFunds.lwfRylwfZcZj;
            this.tableDataList[4].children[1].specialPaid = newVal.projectBalance.lwfRylwfZxZjPaid;
            this.tableDataList[4].children[1].specialUnpaid = newVal.projectBalance.lwfRylwfZxZjUnpaid;
            this.tableDataList[4].children[1].selfPaid = newVal.projectBalance.lwfRylwfZcZjPaid;
            this.tableDataList[4].children[1].selfUnpaid = newVal.projectBalance.lwfRylwfZcZjUnpaid;
            // this.tableDataList[4].children[1].totalPaid = newVal.projectBalance.;
            // this.tableDataList[4].children[1].totalUnpaid = newVal.projectBalance.;

            /* 材料费 */
            this.tableDataList[5].budget = 10;
            this.tableDataList[5].specialBudget = newVal.projectFunds.clfZxZj;
            this.tableDataList[5].selfBudget = newVal.projectFunds.clfZcZj;
            this.tableDataList[5].specialPaid = newVal.projectBalance.clfZxZjPaid;
            this.tableDataList[5].specialUnpaid = newVal.projectBalance.clfZxZjUnpaid;
            this.tableDataList[5].selfPaid = newVal.projectBalance.clfZcZjPaid;
            this.tableDataList[5].selfUnpaid = newVal.projectBalance.clfZcZjUnpaid;
            // this.tableDataList[5].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[5].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 材料费_材料费 */
            this.tableDataList[5].children[0].specialBudget = newVal.projectFunds.clfClfZxZj;
            this.tableDataList[5].children[0].selfBudget = newVal.projectFunds.clfClfZcZj;
            this.tableDataList[5].children[0].specialPaid = newVal.projectBalance.clfClfZxZjPaid;
            this.tableDataList[5].children[0].specialUnpaid = newVal.projectBalance.clfClfZxZjUnpaid;
            this.tableDataList[5].children[0].selfPaid = newVal.projectBalance.clfClfZcZjPaid;
            this.tableDataList[5].children[0].selfUnpaid = newVal.projectBalance.clfClfZcZjUnpaid;
            // this.tableDataList[5].children[0].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[5].children[0].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;

            /* 科研活动费 */
            this.tableDataList[6].budget = 10;
            this.tableDataList[6].specialBudget = newVal.projectFunds.kyhdfZcZj;
            this.tableDataList[6].selfBudget = newVal.projectFunds.kyhdfZlZxZj;
            this.tableDataList[6].specialPaid = newVal.projectBalance.kyhdfZxZjPaid;
            this.tableDataList[6].specialUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            this.tableDataList[6].selfPaid = newVal.projectBalance.kyhdfZcZjPaid;
            this.tableDataList[6].selfUnpaid = newVal.projectBalance.kyhdfZcZjUnpaid;
            this.tableDataList[6].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            this.tableDataList[6].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 科研活动费_资料费 */
            this.tableDataList[6].children[0].specialBudget = newVal.projectFunds.kyhdfZlZxJj;
            this.tableDataList[6].children[0].selfBudget = newVal.projectFunds.kyhdfZlZcJj;
            this.tableDataList[6].children[0].specialPaid = newVal.projectBalance.kyhdfZlZxZjPaid;
            this.tableDataList[6].children[0].specialUnpaid = newVal.projectBalance.kyhdfZlZxZjUnpaid;
            this.tableDataList[6].children[0].selfPaid = newVal.projectBalance.kyhdfZlZcZjPaid;
            this.tableDataList[6].children[0].selfUnpaid = newVal.projectBalance.kyhdfZlZcZjUnpaid;
            // this.tableDataList[6].children[0].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[6].children[0].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 科研活动费_数据/样本采集费 */
            this.tableDataList[6].children[1].specialBudget = newVal.projectFunds.kyhdfSjybcjZxZj;
            this.tableDataList[6].children[1].selfBudget = newVal.projectFunds.kyhdfSjybcjZcZj;
            this.tableDataList[6].children[1].specialPaid = newVal.projectBalance.kyhdfSjybcjZxZjPaid;
            this.tableDataList[6].children[1].specialUnpaid = newVal.projectBalance.kyhdfSjybcjZxZjUnpaid;
            this.tableDataList[6].children[1].selfPaid = newVal.projectBalance.kyhdfSjybcjZcZjPaid;
            this.tableDataList[6].children[1].selfUnpaid = newVal.projectBalance.kyhdfSjybcjZcZjUnpaid;
            // this.tableDataList[6].children[1].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[6].children[1].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 科研活动费_测试化验加工费 */
            this.tableDataList[6].children[2].specialBudget = newVal.projectFunds.kyhdfSjybcjZxZj;
            this.tableDataList[6].children[2].selfBudget = newVal.projectFunds.kyhdfSjybcjZcZj;
            this.tableDataList[6].children[2].specialPaid = newVal.projectBalance.kyhdfCshyjgZxZjPaid;
            this.tableDataList[6].children[2].specialUnpaid = newVal.projectBalance.kyhdfCshyjgZxZjUnpaid;
            this.tableDataList[6].children[2].selfPaid = newVal.projectBalance.kyhdfCshyjgZcZjPaid;
            this.tableDataList[6].children[2].selfUnpaid = newVal.projectBalance.kyhdfCshyjgZcZjUnpaid;
            // this.tableDataList[6].children[2].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[6].children[2].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 科研活动费_燃料动力费 */
            this.tableDataList[6].children[3].specialBudget = newVal.projectFunds.kyhdfRldlZxZj;
            this.tableDataList[6].children[3].selfBudget = newVal.projectFunds.kyhdfRldlZcZj;
            this.tableDataList[6].children[3].specialPaid = newVal.projectBalance.kyhdfRldlZxZjPaid;
            this.tableDataList[6].children[3].specialUnpaid = newVal.projectBalance.kyhdfRldlZxZjUnpaid;
            this.tableDataList[6].children[3].selfPaid = newVal.projectBalance.kyhdfRldlZcZjPaid;
            this.tableDataList[6].children[3].selfUnpaid = newVal.projectBalance.kyhdfRldlZcZjUnpaid;
            // this.tableDataList[6].children[3].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[6].children[3].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 科研活动费_办公费 */
            this.tableDataList[6].children[4].specialBudget = newVal.projectFunds.kyhdfBgZxZj;
            this.tableDataList[6].children[4].selfBudget = newVal.projectFunds.kyhdfBgZcZj;
            this.tableDataList[6].children[4].specialPaid = newVal.projectBalance.kyhdfBgZxZjPaid;
            this.tableDataList[6].children[4].specialUnpaid = newVal.projectBalance.kyhdfBgZxZjUnpaid;
            this.tableDataList[6].children[4].selfPaid = newVal.projectBalance.kyhdfBgZcZjUnpaid;
            this.tableDataList[6].children[4].selfUnpaid = newVal.projectBalance.kyhdfBgZcZjUnpaid;
            // this.tableDataList[6].children[4].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[6].children[4].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 科研活动费_印刷/出版费 */
            this.tableDataList[6].children[5].specialBudget = newVal.projectFunds.kyhdfYscbZxZj;
            this.tableDataList[6].children[5].selfBudget = newVal.projectFunds.kyhdfYscbZcZj;
            this.tableDataList[6].children[5].specialPaid = newVal.projectBalance.kyhdfYscbZxZjPaid;
            this.tableDataList[6].children[5].specialUnpaid = newVal.projectBalance.kyhdfYscbZxZjUnpaid;
            this.tableDataList[6].children[5].selfPaid = newVal.projectBalance.kyhdfYscbZcZjPaid;
            this.tableDataList[6].children[5].selfUnpaid = newVal.projectBalance.kyhdfYscbZcZjUnpaid;
            // this.tableDataList[6].children[5].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[6].children[5].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 科研活动费_知识产权事务费 */
            this.tableDataList[6].children[6].specialBudget = newVal.projectFunds.kyhdfZscqswZxZj;
            this.tableDataList[6].children[6].selfBudget = newVal.projectFunds.kyhdfZscqswZcZj;
            this.tableDataList[6].children[6].specialPaid = newVal.projectBalance.kyhdfZscqswZxZjPaid;
            this.tableDataList[6].children[6].specialUnpaid = newVal.projectBalance.kyhdfZscqswZxZjUnpaid;
            this.tableDataList[6].children[6].selfPaid = newVal.projectBalance.kyhdfZscqswZcZjPaid;
            this.tableDataList[6].children[6].selfUnpaid = newVal.projectBalance.kyhdfZscqswZcZjUnpaid;
            // this.tableDataList[6].children[6].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[6].children[6].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 科研活动费_车辆使用费 */
            this.tableDataList[6].children[7].specialBudget = newVal.projectFunds.kyhdfClsyZxZj;
            this.tableDataList[6].children[7].selfBudget = newVal.projectFunds.kyhdfClsyZcZj;
            this.tableDataList[6].children[7].specialPaid = newVal.projectBalance.kyhdfClsyZxZjPaid;
            this.tableDataList[6].children[7].specialUnpaid = newVal.projectBalance.kyhdfClsyZxZjUnpaid;
            this.tableDataList[6].children[7].selfPaid = newVal.projectBalance.kyhdfClsyZcZjPaid;
            this.tableDataList[6].children[7].selfUnpaid = newVal.projectBalance.kyhdfClsyZcZjUnpaid;
            // this.tableDataList[6].children[7].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[6].children[7].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 科研服务费 */
            this.tableDataList[7].budget = 10;
            this.tableDataList[7].specialBudget = newVal.projectFunds.kyfwfZxZj;
            this.tableDataList[7].selfBudget = newVal.projectFunds.kyfwfZjzxZcZj;
            this.tableDataList[7].specialPaid = newVal.projectBalance.kyfwfZxZjPaid;
            this.tableDataList[7].specialUnpaid = newVal.projectBalance.kyfwfZxZjUnpaid;
            this.tableDataList[7].selfPaid = newVal.projectBalance.kyfwfZcZjPaid;
            this.tableDataList[7].selfUnpaid = newVal.projectBalance.kyfwfZcZjUnpaid;
            // this.tableDataList[7].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[7].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 科研服务费_会议/会务费 */
            this.tableDataList[7].children[0].specialBudget = newVal.projectFunds.kyfwfHyhwZxZj;
            this.tableDataList[7].children[0].selfBudget = newVal.projectFunds.kyfwfHyhwZcZj;
            this.tableDataList[7].children[0].specialPaid = newVal.projectBalance.kyfwfHyhwZxZjPaid;
            this.tableDataList[7].children[0].specialUnpaid = newVal.projectBalance.kyfwfHyhwZxZjUnpaid;
            this.tableDataList[7].children[0].selfPaid = newVal.projectBalance.kyfwfHyhwZcZjPaid;
            this.tableDataList[7].children[0].selfUnpaid = newVal.projectBalance.kyfwfHyhwZcZjUnpaid;
            // this.tableDataList[7].children[0].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[7].children[0].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 科研服务费_差旅费*/
            this.tableDataList[7].children[1].specialBudget = newVal.projectFunds.kyfwfClZxZj;
            this.tableDataList[7].children[1].selfBudget = newVal.projectFunds.kyfwfClZcZj;
            this.tableDataList[7].children[1].specialPaid = newVal.projectBalance.kyfwfClZxZjPaid;
            this.tableDataList[7].children[1].specialUnpaid = newVal.projectBalance.kyfwfClZxZjUnpaid;
            this.tableDataList[7].children[1].selfPaid = newVal.projectBalance.kyfwfClZcZjPaid;
            this.tableDataList[7].children[1].selfUnpaid = newVal.projectBalance.kyfwfClZcZjUnpaid;
            // this.tableDataList[7].children[1].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[7].children[1].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 科研服务费_国内协作费*/
            this.tableDataList[7].children[2].specialBudget = newVal.projectFunds.kyfwfGnxzZxZj;
            this.tableDataList[7].children[2].selfBudget = newVal.projectFunds.kyfwfGnxzZcZj;
            this.tableDataList[7].children[2].specialPaid = newVal.projectBalance.kyfwfGnxzZxZjPaid;
            this.tableDataList[7].children[2].specialUnpaid = newVal.projectBalance.kyfwfGnxzZxZjUnpaid;
            this.tableDataList[7].children[2].selfPaid = newVal.projectBalance.kyfwfGnxzZcZjPaid;
            this.tableDataList[7].children[2].selfUnpaid = newVal.projectBalance.kyfwfGnxzZcZjUnpaid;
            // this.tableDataList[7].children[2].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[7].children[2].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 科研服务费_国际合作交流*/
            this.tableDataList[7].children[3].specialBudget = newVal.projectFunds.kyfwfGjhzjlZxZj;
            this.tableDataList[7].children[3].selfBudget = newVal.projectFunds.kyfwfGjhzjlZcZj;
            this.tableDataList[7].children[3].specialPaid = newVal.projectBalance.kyfwfGjhzjlZxZjPaid;
            this.tableDataList[7].children[3].specialUnpaid = newVal.projectBalance.kyfwfGjhzjlZxZjUnpaid;
            this.tableDataList[7].children[3].selfPaid = newVal.projectBalance.kyfwfGjhzjlZcZjPaid;
            this.tableDataList[7].children[3].selfUnpaid = newVal.projectBalance.kyfwfGjhzjlZcZjUnpaid;
            // this.tableDataList[7].children[3].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[7].children[3].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 科研服务费_专家咨询费*/
            this.tableDataList[7].children[4].specialBudget = newVal.projectFunds.kyfwfZjzxZxZj;
            this.tableDataList[7].children[4].selfBudget = newVal.projectFunds.kyfwfClZxZj;
            this.tableDataList[7].children[4].specialPaid = newVal.projectBalance.kyfwfZjzxZxZjPaid;
            this.tableDataList[7].children[4].specialUnpaid = newVal.projectBalance.kyfwfZjzxZxZjUnpaid;
            this.tableDataList[7].children[4].selfPaid = newVal.projectBalance.kyfwfZjzxZcZjPaid;
            this.tableDataList[7].children[4].selfUnpaid = newVal.projectBalance.kyfwfZjzxZcZjUnpaid;
            // this.tableDataList[7].children[4].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[7].children[4].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 人员和劳务补助费 */
            this.tableDataList[8].budget = 10;
            this.tableDataList[8].specialBudget = newVal.projectFunds.ryhlwbzfZxZj;
            this.tableDataList[8].selfBudget = newVal.projectFunds.ryhlwbzfZcZj;
            this.tableDataList[8].specialPaid = newVal.projectBalance.ryhlwbzfZxZjPaid;
            this.tableDataList[8].specialUnpaid = newVal.projectBalance.ryhlwbzfZxZjUnpaid;
            this.tableDataList[8].selfPaid = newVal.projectBalance.ryhlwbzfZcZjPaid;
            this.tableDataList[8].selfUnpaid = newVal.projectBalance.ryhlwbzfZcZjUnpaid;
            // this.tableDataList[8].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[8].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            /* 人员和劳务补助费_人员劳务费 */
            this.tableDataList[8].children[0].specialBudget = newVal.projectFunds.ryhlwbzfRylwZxZj;
            this.tableDataList[8].children[0].selfBudget = newVal.projectFunds.ryhlwbzfRylwZcZj;
            this.tableDataList[8].children[0].specialPaid = newVal.projectBalance.ryhlwbzfRylwZxZjPaid;
            this.tableDataList[8].children[0].specialUnpaid = newVal.projectBalance.ryhlwbzfRylwZxZjUnpaid;
            this.tableDataList[8].children[0].selfPaid = newVal.projectBalance.ryhlwbzfRylwZcZjPaid;
            this.tableDataList[8].children[0].selfUnpaid = newVal.projectBalance.ryhlwbzfRylwZcZjUnpaid;
            // this.tableDataList[8].children[0].totalPaid = newVal.projectBalance.kyhdfZxZjUnpaid;
            // this.tableDataList[8].children[0].totalUnpaid = newVal.projectBalance.kyhdfZxZjUnpaid;
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
