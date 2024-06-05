<template>
    <div>
        <el-card shadow="hover">
            <template slot="header" >
                <div class="card-header-content">
                    <i class="el-icon-caret-right"></i> 直接经费（万元） <i class="el-icon-caret-left"></i>
                </div>
            </template>
            <el-card v-for="(card1, index1) in this.$props.cards1" :key="index1" shadow="hover"
                     @mouseover.native="$set(isButtonShowList1, index1, true)"
                     @mouseleave.native="$set(isButtonShowList1, index1, false)" class="custom-card">
                <template slot="header" >
                    <div class="header-container" >
                        <el-button class="remove3-button" icon="el-icon-circle-plus" circle type="success" plain @click="addCard(cards1, cards2)"
                                   v-show="isButtonShowList1[index1]"
                        ></el-button>
                        <el-select class="select-container" v-model="card1.value" placeholder="请选择一级目录" size="medium">
                            <el-option v-for="option in categoryOptions1" :key="option.value" :label="option.label" :value="option.value"></el-option>
                        </el-select>
                        <el-input class="custom-input" v-model="card1.content" type="number" size="medium"></el-input>
                        <el-button  icon="el-icon-remove" circle type="danger" plain @click="removeCard(index1, cards1, cards2)"
                                    v-show="isButtonShowList1[index1]"
                        ></el-button>
                        <el-button icon="el-icon-circle-plus" circle type="success" plain @click="addCard2(index1, cards2)"
                                   v-show="isButtonShowList1[index1]"
                        ></el-button>
                    </div>
                </template>
                <div class="card-container" v-if="card1.value && filteredSecondOptions(index1)">
                    <el-card v-for="(card2, index2) in cards2[index1]" :key="index2" shadow="hover" style="width: 25%;"
                             @mouseover.native="$set(isButtonShowList2, index2, true)"
                             @mouseleave.native="$set(isButtonShowList2, index2, false)">
                        <template slot="header">
                            <div class="header-container content-container">
                                <el-button class="remove-button" icon="el-icon-remove" circle type="danger" plain @click="removeCard2(index1, index2, cards2)"
                                           v-show="isButtonShowList2[index2]"
                                ></el-button>
                                <el-select class="select-container" v-model="card2.value" placeholder="请选择二级目录" size="small">
                                    <el-option v-for="option in filteredSecondOptions(index1)" :key="option.value" :label="option.label" :value="option.value"></el-option>
                                </el-select>
                                <el-input class="custom-input" v-model="card2.content" type="number" size="small"></el-input>
                                <el-button icon="el-icon-circle-plus" circle type="success" plain @click="addRow(index1, index2)"
                                           v-show="isButtonShowList2[index2]"
                                ></el-button>
                            </div>
                        </template>
                        <el-table :data="tableData[index1] && tableData[index1][index2]" v-if="isTableDataNotEmpty(index1, index2) || isTableVisible[index1][index2]" style="width: 100%" >
                            <el-table-column label="三级标签" align="center" :width="150">
                                <template slot-scope="scope">
                                    <el-select v-model="scope.row.value" placeholder="请选择三级级目录" size="mini">
                                        <el-option v-for="category in filteredThirdOptions(index1,index2)" :key="category.value" :label="category.label" :value="category.value"></el-option>
                                    </el-select>
                                </template>
                            </el-table-column>
                            <el-table-column label="涉及金额" align="center" :width="140">
                                <template slot-scope="scope">
                                    <el-input v-model="scope.row.content" type="number" size="mini" style="width: 100%;"></el-input>
                                </template>
                            </el-table-column>
                            <el-table-column label="操作" align="center">
                                <template slot-scope="scope" size="mini">
                                    <el-button type="danger" icon="el-icon-remove" circle plain @click="removeRow(index1, index2, scope.$index)"></el-button>
                                </template>
                            </el-table-column>
                        </el-table>
                    </el-card>
                </div>
            </el-card>
        </el-card>
        <el-card style="margin-top: 4px;" shadow="hover">
            <template slot="header" >
                <div class="card-header-content">
                    <i class="el-icon-caret-right"></i> 间接经费（万元） <i class="el-icon-caret-left"></i>
                </div>
            </template>
            <div class="card-container">
                <el-card shadow="hover" style="width: 25%; height: 50px;" v-for="(card, index) in cards3" :key="index"
                         @mouseover.native="$set(isButtonShowList3, index, true)"
                         @mouseleave.native="$set(isButtonShowList3, index, false)">
                    <div class="header-container content-container" style="margin-top: -8px;">
                        <el-button class="remove1-button" icon="el-icon-remove" circle type="danger" plain @click="removeIndirectCost(index)"
                                   v-show="isButtonShowList3[index]"
                        ></el-button>
                        <el-select class="select-container" v-model="card.value" placeholder="请选择经费条目" size="small">
                            <el-option v-for="option in categoryOptions4" :key="option.value" :label="option.label" :value="option.value"></el-option>
                        </el-select>
                        <el-input class="custom-input" v-model="card.content" placeholder="请输入金额" type="number" size="small"></el-input>
                        <el-button class="remove2-button" icon="el-icon-circle-plus" circle type="success" plain @click="addIndirectCost"
                                   v-show="isButtonShowList3[index]"
                        ></el-button>
                    </div>
                </el-card>
            </div>
        </el-card>
    </div>
</template>

<script>

import {categoryOptions2, categoryOptions5} from "@/views/project/components/fundkeys";
export default {
    props: {
        cards1: {
            type: Array,
            required: true,
        },
        cards2: {
            type: Array,
            required: true,
        },
        tableData: {
            type: Array,
            required: true,
        },
        cards3: {
            type: Array,
            required: true,
        },
    },
    data() {
        return {
            isTableVisible: [[]],
            categoryOptions1: categoryOptions2,
            categoryOptions4: categoryOptions5,
            isButtonShowList1: [],
            isButtonShowList2: [],
            isButtonShowList3: [],
        };
    },
    watch: {
        'cards2': {
            immediate: true,
            handler(cards2) {
                this.isTableVisible = cards2.map(card2List =>
                    card2List.map(() => false) // 默认设置为不可见，或者根据需要设置为true
                );
            }
        }
    },
    computed: {
        // 计算属性，根据当前选中的一级目录值动态过滤出对应的二级目录选项
        filteredSecondOptions() {
            return index1 => {
                const selectedFirstValue = this.$props.cards1[index1].value;
                const firstOption = this.categoryOptions1.find(option => option.value === selectedFirstValue);
                return firstOption ? firstOption.children || [] : [];
            };
        },
        // 计算属性，根据当前选中的一级和二级目录值动态过滤出对应的三级目录选项.......
        filteredThirdOptions() {
            return (index1, index2) => {
                const selectedFirstValue = this.$props.cards1[index1].value;
                const firstOption = this.categoryOptions1.find(option => option.value === selectedFirstValue);
                if (firstOption) {
                    const selectedSecondValue = this.$props.cards2[index1][index2].value;
                    const secondOption = firstOption.children.find(option => option.value === selectedSecondValue);
                    return secondOption ? secondOption.children || [] : [];
                }

                return [];
            };
        }
    },
    mounted() {
        this.initializeStates();
    },
    methods: {
        initializeStates() {
            // 根据cards1初始化isButtonShowList1
            this.isButtonShowList1 = this.cards1 ? new Array(this.cards1.length).fill(false) : [];
            // 根据cards2初始化isButtonShowList2和isTableVisible
            if (this.cards2) {
                this.isButtonShowList2 = this.cards2.map(card2List => new Array(card2List.length).fill(false));
                this.isTableVisible = this.cards2.map(card2List =>
                    card2List.map(() => false)
                );
            } else {
                this.isButtonShowList2 = [];
                this.isTableVisible = [[]];
            }
            this.isButtonShowList3 = this.cards3 ? new Array(this.cards3.length).fill(false) : [];
        },
        // 判断数据复现时空的三级数据不显示
        isTableDataNotEmpty(index1, index2) {
            return this.tableData[index1] && this.tableData[index1][index2] && this.tableData[index1][index2].length > 0;
        },
        // 新增一级目录
        addCard() {
            const newCard1 = { value: '', content: '' };
            const newCard2 = [];
            this.$props.cards1.push(newCard1);
            this.$props.cards2.push(newCard2);
            this.$props.tableData.push([]);
            this.isTableVisible.push([]);
        },
        // 新增二级目录
        addCard2(index1) {
            this.isTableVisible[index1].push(false);
            this.$props.cards2[index1].push({ value: '', content: '' });
            this.$props.tableData[index1].push([]);
            console.log('index1', index1);
        },
        // 删除当前一级目录
        removeCard(index1) {
            if (this.$props.cards1.length > 1) {
                this.$props.cards1.splice(index1, 1);
                this.$props.cards2.splice(index1, 1);
                this.$props.tableData.splice(index1, 1);
                this.isTableVisible.splice(index1, 1);
            } else {
                console.warn('Cannot delete the last item in cards1');
            }
        },
        // 删除当前二级目录
        removeCard2(index1, index2) {
            this.$props.cards2[index1].splice(index2, 1);
            this.$props.tableData[index1].splice(index2, 1);
            this.isTableVisible[index1].splice(index2, 1);
        },
        // 新增三级表
        addRow(index1, index2) {
            // if (!this.$props.tableData[index1] || !this.isTableVisible[index1]) {
            //
            // }
            this.$set(this.$props.tableData[index1][index2], this.$props.tableData[index1][index2].length, { value: '', });
            // 不管之前的状态如何，都更新可见性标志
            this.$set(this.isTableVisible[index1], index2, true); // 确保可见性为true
            console.log('index2', index2);
            console.log('this.tableData[index1][index2]', this.$props.tableData[index1][index2]);
        },
        // 删除当前三级表
        removeRow(index1, index2, rowIndex) {
            this.$props.tableData[index1][index2].splice(rowIndex, 1);
            //this.isTableVisible[index1][index2] = false;
            if (this.$props.tableData[index1][index2].length === 0) {
                this.isTableVisible[index1][index2] = false;
            }
            console.log("this.cards1", this.$props.cards1);
            console.log("this.cards2", this.$props.cards2);
            console.log("this.tableData", this.$props.tableData);
        },
        /*增加和删除间接经费*/
        addIndirectCost() {
            this.$props.cards3.push({ content: '', value: '' });
        },
        removeIndirectCost(index) {
            if (this.$props.cards3.length > 1) {
                this.$props.cards3.splice(index, 1);
            } else {
                console.warn('Cannot delete the last item in cards3');
            }
        },
        // 重置表单
        reset() {
            this.$props.cards1 = [];
            this.$props.cards2 = [];
            this.$props.tableData = [];
            this.$props.cards3 = [];
            this.addCard();
            this.addIndirectCost();
        }
    },
    created() {
        if (this.$props.cards1.length === 0) {
            this.addCard();
            this.addIndirectCost();
        }
    }
};
</script>

<style scoped>

.remove-button {
    margin-right: 10px;
}
.remove1-button {
    margin-left: -10px;
    margin-right: 10px;
}
.remove2-button {
    margin-right: -10px;
}
.remove3-button {
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
    margin-right: 10px;
}
.custom-divider {
    background-color: #c9c9c9; /* 设置线条颜色为红色 */
}
.custom-card {
    border-color: #c9c9c9;
    margin-top: 2px;
}
.header-container {
    display: flex;
    align-items: center;
}
.content-container {
    justify-content: center; /* 将内容水平居中对齐 */
}
.card-container {
    display: flex;
    flex-wrap: wrap;
}
.card-header-content {
    text-align: center; /* 文本居中 */
    color: #fb6113; /* 字体颜色为蓝色 */
    font-size: 15px; /* 增大字体大小 */
}
</style>
