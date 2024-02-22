<template>
    <el-card header="专项经费详情" shadow="hover">
        <el-divider><i class="el-icon-caret-right"></i>直接经费<i class="el-icon-caret-left"></i></el-divider>
        <el-card v-for="(card1, index1) in this.$props.cards1" :key="index1" shadow="hover"
                 @mouseover.native="$set(isButtonShowList1, index1, true)"
                 @mouseleave.native="$set(isButtonShowList1, index1, false)">
            <template slot="header">
                <div class="header-container">
                    <el-button class="add-button" icon="el-icon-circle-plus" circle type="success" plain @click="addCard(cards1, cards2)"
                               v-show="isButtonShowList1[index1]"
                    ></el-button>
                    <el-button class="remove-button" icon="el-icon-remove" circle type="danger" plain @click="removeCard(index1, cards1, cards2)"
                               v-show="isButtonShowList1[index1]"
                    ></el-button>
                    <el-select class="select-container" v-model="card1.header" placeholder="选择一级目录" size="medium">
                        <el-option v-for="option in categoryOptions1" :key="option.value" :label="option.label" :value="option.value"></el-option>
                    </el-select>
                    <el-input class="custom-input" v-model="card1.content" type="number" size="medium"></el-input>
                    <el-button class="add-button" icon="el-icon-circle-plus" circle type="success" plain @click="addCard2(index1, cards2)"
                               v-show="isButtonShowList1[index1]"
                    ></el-button>
                </div>
            </template>
            <div class="card-container" v-if="filteredSecondOptions(index1)">
                <el-card v-for="(card2, index2) in cards2[index1]" :key="index2" shadow="hover" style="width: 25%;"
                         @mouseover.native="$set(isButtonShowList2, index2, true)"
                         @mouseleave.native="$set(isButtonShowList2, index2, false)">
                    <template slot="header">
                        <div class="header-container">
                            <el-button class="remove-button" icon="el-icon-remove" circle type="danger" plain @click="removeCard2(index1, index2, cards2)"
                                       v-show="isButtonShowList2[index2]"
                            ></el-button>
                            <el-select class="select-container" v-model="card2.header" placeholder="选择二级目录" size="small">
                                <el-option v-for="option in filteredSecondOptions(index1)" :key="option.value" :label="option.label" :value="option.value"></el-option>
                            </el-select>
                            <el-input class="custom-input" v-model="card2.content" type="number" size="small"></el-input>
                            <el-button icon="el-icon-circle-plus" circle type="success" plain @click="addRow(index1, index2)"
                                       v-show="isButtonShowList2[index2]"
                            ></el-button>
                        </div>
                    </template>
                    <el-table :data="tableData[index1][index2]" v-if="isTableVisible[index1][index2]" style="width: 100%" >
                        <el-table-column label="三级标签" align="center" :width="150">
                            <template slot-scope="scope">
                                <el-select v-model="scope.row.header" placeholder="Select category" size="mini">
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
        <div>
            zz
        </div>
    </el-card>
</template>

<script>
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
    },
    data() {
        return {
            isTableVisible: [[]],
            // cards1: [],
            // cards2: [],
            categoryOptions1: [
                {
                    label: '设备费',
                    value: 'sbfZxZj',
                    children: [
                        {
                            label: '购置设备费',
                            value: 'sbfGzsbZxZj',
                        },
                        {
                            label: '试制设备费',
                            value: 'sbfSzsbZxZj',
                        },
                        {
                            label: '设备升级改造费',
                            value: 'sbfSbsjgzZxZj',
                        },
                        {
                            label: '设备租赁费',
                            value: 'sbfSbzlZxZj',
                        },
                    ]
                },
                {
                    label: '业务费',
                    value: 'ywfZxZj',
                    children: [
                        {
                            label: '材料费',
                            value: 'ywfClfZxZj',
                        },
                        {
                            label: '资料费',
                            value: 'ywfZlfZxZj',
                        },
                        {
                            label: '数据/样本采集费',
                            value: 'ywfSjybcjfZxZj',
                        },
                        {
                            label: '测试化验加工费',
                            value: 'ywfCshyjgfZxZj',
                        },
                        {
                            label: '燃料动力费',
                            value: 'ywfRldlfZxZj',
                        },
                        {
                            label: '办公费',
                            value: 'ywfBgfZxZj',
                        },
                        {
                            label: '印刷/出版费',
                            value: 'ywfYscbfZxZj',
                        },
                        {
                            label: '知识产权事务费',
                            value: 'ywfZscqswfZxZj',
                        },
                        {
                            label: '车辆使用费',
                            value: 'ywfClsyfZxZj',
                        },
                        {
                            label: '出版/文献/信息传播/知识产权事务费',
                            value: 'ywfCbwxxxcbzscqswfZxZj',
                            children: [
                                {
                                    label: '知识产权事务费',
                                    value: 'ywfCbwxxxcbzscqswfZscqswfZxZj',
                                },
                                {
                                    label: '印刷打印制作费',
                                    value: 'ywfCbwxxxcbzscqswfYsdyzzfZxZj',
                                },
                                {
                                    label: '文献数据库费',
                                    value: 'ywfCbwxxxcbzscqswfWxsjkfZxZj',
                                },
                                {
                                    label: '信息传播费',
                                    value: 'ywfCbwxxxcbzscqswfXxcbfZxZj',
                                },
                            ]
                        },
                        {
                            label: '差旅费',
                            value: 'ywfChlfZxZj',
                        },
                        {
                            label: '会议/会务费',
                            value: 'ywfHyhwfZxZj',
                        },
                        {
                            label: '国内协作费',
                            value: 'ywfGnxzfZxZj',
                        },
                        {
                            label: '国际合作交流费',
                            value: 'ywfGjhzjlfZxZj',
                        },
                        {
                            label: '会议/差旅/国际合作与交流费',
                            value: 'ywfHyclgjhzyjlfZxZj',
                            children: [
                                {
                                    label: '会议费',
                                    value: 'ywfHyclgjhzyjlfHyfZxZj',
                                },
                                {
                                    label: '差旅费',
                                    value: 'ywfHyclgjhzyjlfClfZxZj',
                                },
                                {
                                    label: '国际合作费',
                                    value: 'ywfHyclgjhzyjlfGjhzfZxZj',
                                },
                            ]
                        },
                    ]
                },
                {
                    label: '劳务费',
                    value: 'lwfZxZj',
                    children: [
                        {
                            label: '专家咨询费',
                            value: 'lwfZjzxfZxZj',
                        },
                        {
                            label: '人员劳务费',
                            value: 'lwfRylwfZxZj',
                        },
                    ]
                },
                {
                    label: '材料费',
                    value: 'clfZxZj',
                    children: [
                        {
                            label: '材料费',
                            value: 'clfClfZxZj',
                        },
                    ]
                },
                {
                    label: '科研活动费',
                    value: 'kyhdfZxZj',
                    children: [
                        {
                            label: '资料费',
                            value: 'kyhdfZlZxZj',
                        },
                        {
                            label: '数据/样本采集费',
                            value: 'kyhdfSjybcjZxZj',
                        },
                        {
                            label: '测试化验加工费',
                            value: 'kyhdfCshyjgZxZj',
                        },
                        {
                            label: '燃料动力费',
                            value: 'kyhdfRldlZxZj',
                        },
                        {
                            label: '办公费',
                            value: 'kyhdfBgZxZj',
                        },
                        {
                            label: '印刷/出版费',
                            value: 'kyhdfYscbZxZj',
                        },
                        {
                            label: '知识产权事务费',
                            value: 'kyhdfZscqswZxZj',
                        },
                        {
                            label: '车辆使用费',
                            value: 'kyhdfClsyZxZj',
                        },
                    ]
                },
                {
                    label: '科研服务费',
                    value: 'kyfwfZxZj',
                    children: [
                        {
                            label: '会议/会务费',
                            value: 'kyfwfHyhwZxZj',
                        },
                        {
                            label: '差旅费',
                            value: 'kyfwfClZxZj',
                        },
                        {
                            label: '国内协作费',
                            value: 'kyfwfGnxzZxZj',
                        },
                        {
                            label: '国际合作交流费',
                            value: 'kyfwfGjhzjlZxZj',
                        },
                        {
                            label: '专家咨询费',
                            value: 'kyfwfZjzxZxZj',
                        },
                    ]
                },
                {
                    label: '人员和劳务补助费',
                    value: 'ryhlwbzfZxZj',
                    children: [
                        {
                            label: '人员劳务费',
                            value: 'ryhlwbzfRylwZxZ',
                        },
                    ]
                },
                {
                    label: '绩效支出',
                    value: 'jxzcZxZj',
                },
            ],
            // tableData: [],
            isButtonShowList1: [],
            isButtonShowList2: [],
        };
    },
    computed: {
        // 计算属性，根据当前选中的一级目录值动态过滤出对应的二级目录选项
        filteredSecondOptions() {
            return index1 => {
                const selectedFirstValue = this.$props.cards1[index1].header;
                const firstOption = this.categoryOptions1.find(option => option.value === selectedFirstValue);
                return firstOption ? firstOption.children || [] : [];
            };
        },
        // 计算属性，根据当前选中的一级和二级目录值动态过滤出对应的三级目录选项
        filteredThirdOptions() {
            return (index1, index2) => {
                const selectedFirstValue = this.$props.cards1[index1].header;
                const firstOption = this.categoryOptions1.find(option => option.value === selectedFirstValue);
                if (firstOption) {
                    const selectedSecondValue = this.$props.cards2[index1][index2].header;
                    const secondOption = firstOption.children.find(option => option.value === selectedSecondValue);
                    return secondOption ? secondOption.children || [] : [];
                }
                return [];
            };
        }
    },
    methods: {
        // 新增一级目录
        addCard() {
            const newCard1 = { header: '', content: '' };
            const newCard2 = [];
            this.$props.cards1.push(newCard1);
            this.$props.cards2.push(newCard2);
            this.$props.tableData.push([]);
            this.isTableVisible.push([]);
        },
        // 新增二级目录
        addCard2(index1) {
            this.isTableVisible[index1].push(false);
            this.$props.cards2[index1].push({ header: '', content: '' });
            this.$props.tableData[index1].push([]);
            console.log('index1', index1);
        },
        // 删除当前一级目录
        removeCard(index1) {
            this.$props.cards1.splice(index1, 1);
            this.$props.cards2.splice(index1, 1);
            this.$props.tableData.splice(index1, 1);
            this.isTableVisible.splice(index1, 1);
        },
        // 删除当前二级目录
        removeCard2(index1, index2) {
            this.$props.cards2[index1].splice(index2, 1);
            this.$props.tableData[index1].splice(index2, 1);
            this.isTableVisible[index1].splice(index2, 1);
        },
        // 新增三级表
        addRow(index1, index2) {
            this.$set(this.$props.tableData[index1][index2], this.$props.tableData[index1][index2].length, { header: '', });
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
