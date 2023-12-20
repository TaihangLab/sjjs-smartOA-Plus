<template>
    <div>
        <el-collapse v-model="activeNames" @change="handleChange">
        <el-collapse-item title="项目经费" name="1">
            <div style="margin-top: 10px;"></div>
            <el-descriptions class="margin-top" :column="4" border>
                <el-descriptions-item labelStyle="font-weight: 550; text-align: center;" :span="4">
                    <template slot="label">
                        项目经费总额
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="text-align: center; " :contentStyle="{ width: '10%' }">
                    <template slot="label">
                        专项经费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="text-align: center; " :contentStyle="{ width: '10%' }">
                    <template slot="label">
                        专项设备费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="text-align: center; " :contentStyle="{ width: '10%' }">
                    <template slot="label">
                        自筹经费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="text-align: center; " :contentStyle="{ width: '10%' }">
                    <template slot="label">
                        自筹设备费
                    </template>
                </el-descriptions-item>
            </el-descriptions>
        </el-collapse-item>
        <el-collapse-item title="专项经费" name="2">
            <div style="margin-top: 10px;"></div>
            <el-col :span="24">
                <el-row class="header-row" type="flex" justify="center" align="middle"
                    style="color: #909399; border: 1px solid #E4E7ED; padding: 10px;">
                    专项经费
                </el-row>
            </el-col>
            <el-descriptions class="margin-top" :column="3" border>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        (一) {{ "\xa0\xa0" }} 直接费用
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0\xa0" }}1.设备费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        购置设备费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        试制设备费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        设备改造与租赁费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0\xa0" }}2.材料费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0\xa0" }}3.科研活动费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        资料费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        测试化验加工费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        数据/样本采集费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        印刷/出版费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        知识产权事务费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        办公费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        燃料动力费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        车辆使用费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0\xa0" }}4.科研服务费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0" }} 5.人员和劳务补助费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        (二) {{ "\xa0\xa0" }} 间接费用
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0\xa0" }}1.设备费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        购置设备费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        试制设备费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        设备改造与租赁费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0\xa0" }}2.材料费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0\xa0" }}3.科研活动费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        资料费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        测试化验加工费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        数据/样本采集费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        印刷/出版费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        知识产权事务费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        办公费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        燃料动力费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        车辆使用费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0\xa0" }}4.科研服务费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0" }} 5.人员和劳务补助费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0" }} 6.绩效支出
                    </template>
                </el-descriptions-item>
            </el-descriptions>
        </el-collapse-item>
        <el-collapse-item title="自筹经费" name="3">
            <div style="margin-top: 10px;"></div>
            <el-col :span="24">
                <el-row class="header-row" type="flex" justify="center" align="middle"
                    style="color: #909399; border: 1px solid #E4E7ED; padding: 10px;">
                    自筹经费
                </el-row>
            </el-col>
            <el-descriptions class="margin-top" :column="3" border>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        (一) {{ "\xa0\xa0" }} 直接费用
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0\xa0" }}1.设备费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        购置设备费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        试制设备费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        设备改造与租赁费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0\xa0" }}2.材料费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0\xa0" }}3.科研活动费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        资料费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        测试化验加工费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        数据/样本采集费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        印刷/出版费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        知识产权事务费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        办公费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        燃料动力费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        车辆使用费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0\xa0" }}4.科研服务费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0" }} 5.人员和劳务补助费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        (二) {{ "\xa0\xa0" }} 间接费用
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0\xa0" }}1.设备费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        购置设备费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        试制设备费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        设备改造与租赁费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0\xa0" }}2.材料费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0\xa0" }}3.科研活动费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        资料费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        测试化验加工费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        数据/样本采集费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        印刷/出版费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        知识产权事务费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        办公费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        燃料动力费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                        车辆使用费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center;  width: auto;" contentStyle="width: 15%">
                    <template slot="label">
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0\xa0" }}4.科研服务费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0" }} 5.人员和劳务补助费
                    </template>
                </el-descriptions-item>
                <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                    <template slot="label">
                        {{ "\xa0\xa0" }} 6.绩效支出
                    </template>
                </el-descriptions-item>
            </el-descriptions>
        </el-collapse-item>
    </el-collapse>
    </div>
</template>

<script>
export default {
    data() {
        return {
            form: {
                name: '',
                // 其他属性...
            },
            contentStyle: {
                'text-align': 'center',
                'width': '60%',
            },
            //label样式
            activeNames: ['1'],
            labelStyle: { 'color': '#000', 'width': '30%', },
            detailsVisible: false, // 是否显示详细信息
            zcdetailsVisible: false, // 是否显示详细信息
        };
    },

    computed: {
        readOnly() {
            return this.detailsVisible;
        },
        readsOnly() {
            return this.zcdetailsVisible;
        },
    },
    methods: {
        toggleDetails() {
            this.detailsVisible = !this.detailsVisible;
        },
        toggleDetail() {
            this.zcdetailsVisible = !this.zcdetailsVisible;
        },
        handleChange(val) {
            console.log(val);
        },
    },
};
</script>
<style>
.el-descriptions .el-descriptions__label {
    width: 300px;
    /* 替换为你希望的宽度值 */
}

.header-row {
    font-size: 15px;
    font-weight: bold;
}
</style>
