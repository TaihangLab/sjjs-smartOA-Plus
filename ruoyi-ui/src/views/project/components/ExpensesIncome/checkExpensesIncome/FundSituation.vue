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
            this.tableDataList[0].budget = 10;
            this.tableDataList[0].specialBudget = 11;
            this.tableDataList[0].selfBudget = 12;
            this.tableDataList[0].specialPaid = 13;
            this.tableDataList[0].specialUnpaid = 14;
            this.tableDataList[0].selfPaid = 15;
            this.tableDataList[0].selfUnpaid = 16;
            this.tableDataList[0].totalPaid = 17;
            this.tableDataList[0].totalUnpaid = 18;
            this.tableDataList[2].children[0].totalUnpaid = 19;
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
