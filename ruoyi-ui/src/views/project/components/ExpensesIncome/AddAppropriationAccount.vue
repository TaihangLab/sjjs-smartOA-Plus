<template>
    <div>
        <el-form ref="form" :rules="rules" :model="form" label-width="120px">
            <el-row>
                <el-col :span="12">
                    <el-form-item label="拨款金额" prop="amountReceived">
                        <el-input v-model="form.amountReceived" style="width: 192px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="到账类型" prop="receivedType">
                        <el-select v-model="form.receivedType" placeholder="请选择类型">
                            <el-option v-for="item in paymentTypes" :key="item.typeId" :label="item.typeName"
                                       :value="item.typeId" :disabled="item.status === 1"></el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="12">
                    <el-form-item label="来款单位" prop="receivedFrom">
                        <el-input v-model="form.receivedFrom" style="width: 192px"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="到账日期" prop="receivedDate">
                        <el-col :span="11">
                            <el-date-picker type="date" placeholder="选择日期" v-model="form.receivedDate" style="width: 192px"
                                            value-format="yyyy-MM-dd"></el-date-picker>
                        </el-col>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-form-item label="附件">
                <fujian ref="fujian" :idList="form.ossIds" />
            </el-form-item>
            <el-form-item style="text-align: center;margin-left: -100px;">
                <el-button type="primary" @click="onSubmit">确定</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import request from '@/utils/request';
import fujian from "@/components/FileUpload/index.vue";
export default {
    components: {
        fujian,
    },
    props: ['projectId'],
    data() {
        return {
            paymentTypes: [
                {
                    typeId: 0,
                    typeName: '发票'
                },
                {
                    typeId: 1,
                    typeName: '收据'
                },
            ],
            form: {
                projectId: undefined,
                amountReceived: '',
                receivedType: '',
                receivedFrom: '',
                receivedDate: '',
                ossIds: [],
            },
            rules: {
                amountReceived: [
                    { required: true, message: '请输入金额数', trigger: 'blur' }
                ],
            },
        };
    },
    created() {
    },
    methods: {
        // 确认新增操作
        onSubmit() {
            this.form.projectId = this.$props.projectId;
            request({
                url: '/project/funds/addFundsReceived',
                method: 'post',
                data: this.form
            }).then((resp) => {

                this.$modal.msgSuccess("新增成功");
                this.$refs.fujian.reset();
                this.$emit('close-dialog'); // 触发一个事件通知父组件关闭弹窗
            }).catch(error => {
                console.error("新增失败", error);
                // 处理错误情况，例如显示错误提示
            });
            this.reset();
        },
        // 表单重置
        reset() {
            this.form = {
                projectId: undefined,
                amountReceived: '',
                receivedType: '',
                receivedFrom: '',
                receivedDate: '',
                ossIds: [],
            };
        },
    },
};
</script>
