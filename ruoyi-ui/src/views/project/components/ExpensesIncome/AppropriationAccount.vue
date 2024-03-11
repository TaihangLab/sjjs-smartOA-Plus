<template>
    <div >
        <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
                <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd">新增</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="success" :disabled="single" plain icon="el-icon-edit" size="mini" @click="handleEdit">修改</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="danger" plain icon="el-icon-delete" size="mini" @click="handleDelete">删除</el-button>
            </el-col>
        </el-row>
        <div style="margin-top: 10px;"></div>
        <el-table v-loading="loading" :data="this.appropriationAccount" @selection-change="handleSelectionChange"
                  style="width: 100%; max-height: 500px; overflow-y: auto;" border>
            <el-table-column type="selection" width="50" align="center" />
            <el-table-column label="拨款金额" align="center" prop="amountReceived" :show-overflow-tooltip="true" width="130"/>
            <el-table-column label="到账类型" align="center" prop="receivedType" :formatter="paymentType" :show-overflow-tooltip="true" width="100"/>
            <el-table-column label="来款单位" align="center" prop="receivedFrom" :show-overflow-tooltip="true" width="150"/>
            <el-table-column label="到账时间" align="center" prop="receivedDate" :show-overflow-tooltip="true" width="130"/>
            <el-table-column label="附件" align="center" :show-overflow-tooltip="true" width="280">
                <template slot-scope="scope" >
                    <div v-for="file in scope.row.sysOsses" :key="file.ossId">
                        <el-button size="mini" type="text" href="#" @click="downloadFile(file)">{{ file.originalName }}</el-button>
                    </div>
                </template>
            </el-table-column>
            <el-table-column :label="'操作'" :resizable="false" align="center" min-width="100px" fixed="right">
                <template slot-scope="scope">
                    <el-button size="mini" type="text" icon="el-icon-edit" @click="handleEdit(scope.row)">修改
                    </el-button>
                    <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row.receivedId)">删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-dialog title="新增经费到账" :visible.sync="appropriationAccountDialogVisibleAdd" width="700px" append-to-body>
            <AddAppropriationAccount @close-dialog="closeAppropriationAccountDialog" :projectId="Number(this.$props.projectId)"></AddAppropriationAccount>
        </el-dialog>
        <el-dialog title="修改经费到账" :visible.sync="appropriationAccountDialogVisibleEdit" width="700px" append-to-body>
            <EditAppropriationAccount @close-dialog="closeAppropriationAccountDialog" :formData="this.formData"></EditAppropriationAccount>
        </el-dialog>
    </div>
</template>

<script>
import request from "@/utils/request";
import AddAppropriationAccount from "@/views/project/components/ExpensesIncome/AddAppropriationAccount.vue";
import EditAppropriationAccount from "@/views/project/components/ExpensesIncome/EditAppropriationAccount.vue";

export default {
    name: "AddEditAppropriationAccount",
    components: {EditAppropriationAccount, AddAppropriationAccount},
    props: {
        projectId: {
            type: [Number, String],
            required: true,
        },
    },
    data() {
        return{
            // 选中数组
            rowsData: [],
            // 非单个禁用
            single: true,
            formData: {},
            paymentTypes: {
                0: '发票',
                1: '收据',
            },
            // 遮罩层
            loading: false,
            appropriationAccount: undefined,
            appropriationAccountDialogVisibleAdd: false,
            appropriationAccountDialogVisibleEdit: false,
        }
    },
    watch: {
        projectId: {
            handler(newVal) {
                this.checkDetail(newVal);
            },
            immediate: true, // 立即执行一次
        },
    },
    methods: {
        // 多选框选中数据
        handleSelectionChange(selection) {
            this.rowsData = selection.map((item) => item);
            this.single = selection.length != 1;
            this.multiple = !selection.length;
        },
        downloadFile(file) {
            // 实现下载功能
            this.$download.oss(file.ossId)
        },
        paymentType(row, column, cellValue) {
            // 使用映射关系来获取对应的文字描述
            return this.paymentTypes[cellValue] || cellValue;
        },
        checkDetail(newVal) {
            const loading = this.$loading({
                lock: true,
                text: '努力加载中',
                spinner: 'el-icon-loading',
                fullscreen: true,
                background: 'rgba(200, 200, 200, 1)'
            });
            // 使用正确的用户列表接口，假设接口为 /user/list
            request({
                url: '/project/funds/getFundsReceived',
                method: 'get',
                params: {
                    projectId: newVal,
                },
            })
                .then((resp) => {
                    this.appropriationAccount = resp.data;
                    loading.close();
                })
                .catch((error) => {
                    console.error('获取用户数据时出错：', error);
                    loading.close();
                });
        },
        handleAdd() {
            this.appropriationAccountDialogVisibleAdd = true;
        },
        handleEdit(rowData) {
            this.resetQuery();
            console.log("this.rowsData", this.rowsData);
            if (this.rowsData.length > 0) {
                this.formData = {...this.rowsData[0]};
            } else {
                this.formData = {...rowData}; // 使用对象扩展运算符深拷贝数据
            }
            this.appropriationAccountDialogVisibleEdit = true;
        },
        deleteReceivedId(receivedId) {
            return request({
                url: '/project/funds/deleteFundsReceived',
                method: 'get',
                params: {
                    receivedId: receivedId,  // 传递参数
                },
            });
        },
        // 关闭弹窗的方法
        closeAppropriationAccountDialog() {
            this.appropriationAccountDialogVisibleAdd = false;
            this.appropriationAccountDialogVisibleEdit = false;
            this.resetQuery();
        },
        handleDelete(row) {
            this.$confirm('确认删除该数据项？').then(() => {
                return this.deleteReceivedId(row);  // 调用deleteIp方法
            }).then(() => {
                this.checkDetail(this.$props.projectId);  // 删除后刷新列表
                this.$message.success("删除成功");
            }).catch(() => {
                console.error('删除失败');
            });
        },
        // 处理按钮点击事件重置
        resetQuery(){
            this.formData = {};
            this.checkDetail(this.$props.projectId);
        },
    }
}
</script>
