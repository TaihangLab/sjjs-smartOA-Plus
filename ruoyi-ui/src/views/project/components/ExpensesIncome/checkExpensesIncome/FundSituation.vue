<template>
    <div>
        <div style="margin-top: 10px;"></div>
        <el-table :data="tableDataList" border :cell-style="columnStyle" height="550px" v-loading="loading" @expand-change="handleExpandChange">
            <!-- 展开行功能 -->
            <el-table-column type="expand" label="操作" cell-class-name="custom-cell-bg">
                <template slot-scope="props">
                    <el-table :data="props.row.children" :show-header="false" style="width: 100%">
                        <!-- 子节点的具体信息展示，这里以名称为例，根据需要添加更多信息 -->
                        <el-table-column type="index" label="序号" align="center" cell-class-name="custom-cell-bg">
                        </el-table-column>
                        <el-table-column align="center" label="预算科目名称" prop="categoryName"
                            cell-class-name="custom-cell-bg">
                        </el-table-column>
                        <el-table-column align="center" label="预算">
                            <el-table-column align="center" label="合计" prop="budget">
                            </el-table-column>
                            <el-table-column align="center" label="专项经费" prop="specialBudget">
                            </el-table-column>
                            <el-table-column align="center" label="自筹经费" prop="selfBudget">
                            </el-table-column>
                        </el-table-column>
                        <el-table-column align="center" label="专项已支付" prop="specialPaid"></el-table-column>
                        <el-table-column align="center" label="专项未支付" prop="specialUnpaid"></el-table-column>
                        <el-table-column align="center" label="自筹已支付" prop="selfPaid"></el-table-column>
                        <el-table-column align="center" label="自筹未支付" prop="selfUnpaid"></el-table-column>
                        <el-table-column align="center" label="已支付" prop="totalPaid"></el-table-column>
                        <el-table-column align="center" label="未支付" prop="totalUnpaid"></el-table-column>
                    </el-table>
                </template>
            </el-table-column>
            <!-- 原始列定义 -->
            <el-table-column align="center" label="预算科目名称" prop="categoryName" cell-class-name="custom-cell-bg">
            </el-table-column>
            <el-table-column align="center" label="预算">
                <el-table-column align="center" label="合计" prop="budget">
                </el-table-column>
                <el-table-column align="center" label="专项经费" prop="specialBudget">
                </el-table-column>
                <el-table-column align="center" label="自筹经费" prop="selfBudget">
                </el-table-column>
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
import categoryOptions1 from "@/views/project/components/fundkeys";

export default {
    data() {
        return {
            tableDataList: [],
            loading: false, // Assuming you have a loading state
        };
    },
    methods: {
        columnStyle({ row, column, rowIndex, columnIndex }) {
	          if (columnIndex == 0 || columnIndex == 1) {
		        //第二三第四列的背景色就改变了2和3都是列数的下标
		        if (columnIndex == 3 || columnIndex == 4) {
		          //字体颜色
		          return "background:#f0f9ff;color:blue;cursor: pointer";
		        }
		        return "background:#f0f9ff";
		      }

	   	 },
        handleExpandChange(row, expandedRows) {
            this.$nextTick(() => {
                // 检查是否有展开的行，根据实际情况调整
                if (expandedRows.length > 0) {
                    // 如果有展开的行，找到展开内容并调整样式
                    const expandedCells = document.querySelectorAll('.el-table__expanded-cell');
                    expandedCells.forEach(cell => {
                        cell.style.padding = '0'; // 移除内边距
                        // 对 cell 内的其他可能影响布局的元素进行样式调整
                    });
                }
            });
        },
        convertCategoryData(categoryOptions) {
            const processCategory = (category) => {
                const row = {
                    categoryName: category.label,
                    // Assuming these properties are calculated or retrieved somehow
                    budget: Math.random() * 1000, // Placeholder for budget
                    specialBudget: Math.random() * 500, // Placeholder for special budget
                    selfBudget: Math.random() * 500, // Placeholder for self budget
                    specialPaid: Math.random() * 300, // Placeholder for special paid
                    specialUnpaid: Math.random() * 200, // Placeholder for special unpaid
                    selfPaid: Math.random() * 300, // Placeholder for self paid
                    selfUnpaid: Math.random() * 200, // Placeholder for self unpaid
                    totalPaid: Math.random() * 600, // Placeholder for total paid
                    totalUnpaid: Math.random() * 400, // Placeholder for total unpaid
                    children: [],
                };

                if (category.children && category.children.length > 0) {
                    row.children = category.children.map(child => processCategory(child));
                }

                return row;
            };

            return categoryOptions.map(category => processCategory(category));
        },
    },
    mounted() {
        this.tableDataList = this.convertCategoryData(categoryOptions1);
    },
};
</script>
<style scoped>
.custom-bg-color {
    background-color: #f0f9ff;
    /* 您希望的表头背景色 */
}
</style>
