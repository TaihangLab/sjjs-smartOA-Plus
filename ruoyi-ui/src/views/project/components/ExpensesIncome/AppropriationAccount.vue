<template>
    <div >
        <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
                <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd" v-hasPermi="['project:expense:receivedAdd']">新增</el-button>
            </el-col>
            <!-- <el-col :span="1.5">
                <el-button type="success" :disabled="single" plain icon="el-icon-edit" size="mini" @click="handleEdit">修改</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="danger" :disabled="multiple" plain icon="el-icon-delete" size="mini" @click="handleDelete">删除</el-button>
            </el-col> -->
        </el-row>
        <div style="margin-top: 10px;"></div>
        <el-table v-loading="loading" :data="this.appropriationAccount" @selection-change="handleSelectionChange"
                  style="width: 100%; max-height: 500px; overflow-y: auto;" border>
            <el-table-column type="selection" width="50" align="center" />
            <el-table-column align="center" prop="amountReceived" :show-overflow-tooltip="true" width="130">
                <template slot="header" slot-scope="scope">
                    <div style="text-align: center;">
                        <span>拨款金额</span>
                        <span style="font-size: 12px; color: #F56C6C;">（万元）</span>
                    </div>
                </template>
            </el-table-column>
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
                    <el-button size="mini" type="text" icon="el-icon-edit" @click="handleEdit(scope.row)" v-hasPermi="['project:expense:receivedEdit']">修改
                    </el-button>
                    <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row.receivedId)" v-hasPermi="['project:expense:receivedDelete']">删除
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
            // 非多个禁用
            multiple: true,
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
        // 查询实时的数据
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
            if (this.rowsData.length > 0) {
                this.formData = {...this.rowsData[0]};
            } else {
                this.formData = {...rowData}; // 使用对象扩展运算符深拷贝数据
            }
            this.appropriationAccountDialogVisibleEdit = true;
        },
        // 删除receivedId对应的数据
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
        // 删除一条或者多条数据
        handleDelete(row) {
            this.resetQuery();
            if (this.rowsData.length > 0) {
                // 使用Promise.all等待所有删除操作完成
                Promise.all(this.rowsData.map(item => this.deleteReceivedId(item.receivedId)))
                    .then(() => {
                        // 所有删除操作成功完成后执行的代码
                        this.resetQuery(); // 可能需要更新列表显示等
                        this.$message.success("删除成功");
                    })
                    .catch(error => {
                        // 如果任何一个删除操作失败
                        console.error('删除失败', error);
                        // 根据实际需要处理错误，例如提示用户
                        this.$message.error("部分或全部删除失败");
                    });
            } else {
                this.$confirm('确认删除该数据项？').then(() => {
                    return this.deleteReceivedId(row);  // 调用deleteIp方法
                }).then(() => {
                    this.resetQuery();
                    this.$message.success("删除成功");
                }).catch(() => {
                    console.error('删除失败');
                });
            }
        },
        // 处理按钮点击事件重置
        resetQuery(){
            this.formData = {};
            this.checkDetail(this.$props.projectId);
        },
    }
}
</script>
