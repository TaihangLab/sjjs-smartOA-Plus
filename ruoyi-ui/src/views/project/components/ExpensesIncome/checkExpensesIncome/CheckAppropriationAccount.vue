<template>
    <div>
        <div style="margin-top: 10px;"></div>
        <el-table v-loading="loading" :data="this.$props.appropriationAccount" style=" margin: 0; padding: 0;">
            <el-table-column align="center" prop="amountReceived" :show-overflow-tooltip="true" >
                <template slot="header" slot-scope="scope">
                    <div style="text-align: center;">
                        <span>拨款金额</span>
                        <span style="font-size: 12px; color: #F56C6C;">（万元）</span>
                    </div>
                </template>
            </el-table-column>
            <el-table-column label="到账类型" align="center" prop="receivedType" :formatter="paymentType" :show-overflow-tooltip="true" />
            <el-table-column label="来款单位" align="center" prop="receivedFrom" :show-overflow-tooltip="true" />
            <el-table-column label="到账时间" align="center" prop="receivedDate" :show-overflow-tooltip="true" />
            <el-table-column label="附件" align="center" :show-overflow-tooltip="true" >
                <template slot-scope="scope" >
                    <div v-for="file in scope.row.sysOsses" :key="file.ossId">
                        <el-button size="mini" type="text" href="#" @click="downloadFile(file)">{{ file.originalName }}</el-button>
                    </div>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
import request from "@/utils/request";

export default {
    name: "CheckAppropriationAccount",
    props: {
        appropriationAccount: {
            type: Array,
            required: true,
        },
    },
    data() {
        return{
            paymentTypes: {
                0: '发票',
                1: '收据',
            },
            // 遮罩层
            loading: false,
        }
    },
    watch: {
        appropriationAccount: {
            handler(newVal) {
            },
            immediate: true, // 立即执行一次
        },
    },
    methods: {
        downloadFile(file) {
            // 实现下载功能
            this.$download.oss(file.ossId)
        },
        paymentType(row, column, cellValue) {
            // 使用映射关系来获取对应的文字描述
            return this.paymentTypes[cellValue] || cellValue;
        },
    }
}
</script>
