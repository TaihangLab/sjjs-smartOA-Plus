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
            this.tableDataList[2][0].totalUnpaid = 18;
        }
    },
};
</script>
<style scoped>
::v-deep .el-table__body tr.current-row>td {
    background-color: rgb(57, 133, 57) !important;
    color: #eef1f6
}
</style>
