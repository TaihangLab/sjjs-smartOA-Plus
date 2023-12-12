<template>
    <div>
        <div style="margin-top: 10px;"></div>
        <!-- 你的专项经费详细信息 -->
        <el-descriptions class="margin-top" :column="4"  border>
            <el-descriptions-item labelStyle="font-weight: 550; text-align: center;" :span="4">
                <template slot="label">
                    项目经费总额
                </template>
            </el-descriptions-item>
            <el-descriptions-item labelStyle="text-align: center; " :contentStyle="{width: '10%'}">
                <template slot="label">
                    专项经费
                </template>
            </el-descriptions-item>
            <el-descriptions-item labelStyle="text-align: center; " :contentStyle="{width: '10%'}">
                <template slot="label">
                    专项设备费
                </template>
            </el-descriptions-item>
            <el-descriptions-item labelStyle="text-align: center; " :contentStyle="{width: '10%'}">
                <template slot="label">
                    自筹经费
                </template>
            </el-descriptions-item>
            <el-descriptions-item labelStyle="text-align: center; " :contentStyle="{width: '10%'}">
                <template slot="label">
                    自筹设备费
                </template>
            </el-descriptions-item>
        </el-descriptions>
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
            labelStyle: {'color': '#000','width': '30%',},
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
    },
};
</script>
<style>
.el-descriptions .el-descriptions__label {
    width: 300px; /* 替换为你希望的宽度值 */
}
.header-row {
    font-size: 15px;
    font-weight: bold;
}
</style>
