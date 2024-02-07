<template>
    <el-card header="专项经费详情" shadow="hover">
        <el-divider><i class="el-icon-caret-right"></i>直接经费<i class="el-icon-caret-left"></i></el-divider>
        <el-card v-for="(card1, index1) in cards1" :key="index1" shadow="hover">
            <template slot="header">
                <div class="header-container">
                    <el-button class="add-button" icon="el-icon-circle-plus" circle type="success" plain @click="addCard(cards1, cards2)"></el-button>
                    <el-button class="remove-button" icon="el-icon-remove" circle type="danger" plain @click="removeCard(index1, cards1, cards2)"></el-button>
                    <el-select class="select-container" v-model="card1.header" placeholder="选择一级目录" size="medium">
                        <el-option v-for="option in categoryOptions1" :key="option.value" :label="option.label" :value="option.value"></el-option>
                    </el-select>
                    <el-input class="custom-input" v-model="card1.content" type="number" size="medium"></el-input>
                    <el-button class="add-button" icon="el-icon-circle-plus" circle type="success" plain @click="addCard2(index1, cards2)"></el-button>
                </div>
            </template>
            <div class="card-container">
                <el-card v-for="(card2, index2) in cards2[index1]" :key="index2" shadow="hover" style="width: 25%;">
                    <template slot="header">
                        <div class="header-container">
                            <el-button class="remove-button" icon="el-icon-remove" circle type="danger" plain @click="removeCard2(index1, index2, cards2)"></el-button>
                            <el-select class="select-container" v-model="card2.header" placeholder="选择二级目录" size="small">
                                <el-option v-for="option in categoryOptions2" :key="option.value" :label="option.label" :value="option.value"></el-option>
                            </el-select>
                            <el-input class="custom-input" v-model="card2.content" type="number" size="small"></el-input>
                            <el-button icon="el-icon-circle-plus" circle type="success" plain @click="addRow(index1, index2)" ></el-button>
                        </div>
                    </template>
                    <el-table :data="tableData[index1][index2]" v-if="isTableVisible[index1][index2]" style="width: 100%" >
                        <el-table-column label="三级标签" align="center" :width="130">
                            <template slot-scope="scope">
                                <el-select v-model="scope.row.category" placeholder="Select category" size="mini">
                                    <el-option v-for="category in categoryOptions" :key="category.value" :label="category.label" :value="category.value"></el-option>
                                </el-select>
                            </template>
                        </el-table-column>
                        <el-table-column label="涉及金额" align="center" :width="130">
                            <template slot-scope="scope">
                                <el-input v-model="scope.row.amount" type="number" size="mini" style="width: 100%;"></el-input>
                            </template>
                        </el-table-column>
                        <el-table-column label="操作" align="center" :width="60">
                            <template slot-scope="scope" size="mini">
                                <el-button type="danger" icon="el-icon-remove" circle plain @click="removeRow(index1, index2, scope.$index)"></el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-card>
            </div>
        </el-card>
    </el-card>
</template>

<script>
export default {
    data() {
        return {
            isTableVisible: [[]],
            cards1: [],
            cards2: [],
            categoryOptions1: [
                { label: '设备费', value: '设备费' },
                { label: '材料费', value: '材料费' },
                { label: '科研服务费', value: '科研服务费' },
            ],
            categoryOptions2: [
                { label: '1.1', value: '1.1' },
                { label: '1.2', value: '1.2' },
                { label: '1.3', value: '1.3' },
            ],
            tableData: [],
            categoryOptions: [
                { label: 'Category A', value: 'A' },
                { label: 'Category B', value: 'B' },
                { label: 'Category C', value: 'C' },
                // Add more options as needed
            ],
        };
    },
    methods: {
        // 新增一级目录
        addCard() {
            const newCard1 = { header: '', content: '' };
            const newCard2 = [];
            this.cards1.push(newCard1);
            this.cards2.push(newCard2);
            this.tableData.push([]);
            this.isTableVisible.push([]);
        },
        // 新增二级目录
        addCard2(index1) {
            this.isTableVisible[index1].push(false);
            this.cards2[index1].push({ header: '', content: '' });
            this.tableData[index1].push([]);
            console.log('index1', index1);
        },
        // 删除当前一级目录
        removeCard(index1) {
            this.cards1.splice(index1, 1);
            this.cards2.splice(index1, 1);
            this.tableData.splice(index1, 1);
            this.isTableVisible.splice(index1, 1);
        },
        // 删除当前二级目录
        removeCard2(index1, index2) {
            this.cards2[index1].splice(index2, 1);
            this.tableData[index1].splice(index2, 1);
            this.isTableVisible[index1].splice(index2, 1);
        },
        // 新增三级表
        // addRow(index1, index2) {
        //     this.$set(this.tableData[index1][index2], this.tableData[index1][index2].length, { name: `Item ${this.tableData[index1][index2].length + 1}`, category: '', amount: null });
        //     this.isTableVisible[index1][index2] = true;
        //     console.log('index2', index2);
        //     console.log('this.tableData[index1][index2]', this.tableData[index1][index2]);
        // },
        addRow(index1, index2) {
            this.$set(this.tableData[index1][index2], this.tableData[index1][index2].length, { name: `Item ${this.tableData[index1][index2].length + 1}`, category: '', amount: null });
            // 不管之前的状态如何，都更新可见性标志
            this.$set(this.isTableVisible[index1], index2, true); // 确保可见性为true
            console.log('index2', index2);
            console.log('this.tableData[index1][index2]', this.tableData[index1][index2]);
        },
        // 删除当前三级表
        removeRow(index1, index2, rowIndex) {
            this.tableData[index1][index2].splice(rowIndex, 1);
            //this.isTableVisible[index1][index2] = false;
            if (this.tableData[index1][index2].length === 0) {
                this.isTableVisible[index1][index2] = false;
            }
        },
    },
    created() {
        this.addCard();
    },
};
</script>

<style scoped>

.remove-button {
    margin-right: 10px;
}
.el-button {
    border: none;
    padding: 0;
    font-size: 2rem;
}
.select-container{
    margin-right: 10px;
    width: 180px;
}
.custom-input {
    width: 120px; /* 设置合适的宽度值 */
}
.header-container {
    display: flex;
    align-items: center;
}
.card-container {
    display: flex;
    flex-wrap: wrap;
}
</style>
