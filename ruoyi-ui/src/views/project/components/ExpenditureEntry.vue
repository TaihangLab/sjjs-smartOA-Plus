<template>
    <div>
        <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
                <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                    v-hasPermi="['system:user:add']">新增</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="info" plain icon="el-icon-upload2" size="mini" @click="handleImport"
                    v-hasPermi="['system:user:import']">导入</el-button>
            </el-col>
        </el-row>
        <el-table ref="multipleTable" :data="da" border style="width: 100%" :row-style="{ height: '50px' }"
            :cell-style="{ padding: '0px' }">
            <el-table-column label="日期" :resizable="false" align="center">
                <!-- 使用 slot-scope 定制显示日期 -->
                <template slot-scope="scope">
                    {{ formatDate(scope.row.expenditureDate) }}
                </template>
            </el-table-column>
            <el-table-column label="项目名称" :resizable="false" align="center" prop="projectName" width="250px">
            </el-table-column>
            <el-table-column label="凭证号" :resizable="false" align="center" prop="voucherNo" width="100px">
            </el-table-column>
            <el-table-column label="摘要" :resizable="false" align="center" prop="expenditureAbstract" min-width="400px">
            </el-table-column>
            <el-table-column label="专项/自筹" :resizable="false" align="center" prop="zxzc" :formatter="zxzcFormatter">
            </el-table-column>
            <el-table-column label="科目粗分" :resizable="false" align="center" prop="firstLevelSubject"
                :formatter="firstLevelSubjectFormatter">
            </el-table-column>
            <el-table-column label="科目细分" :resizable="false" align="center" prop="secondLevelSubject"
                :formatter="secondLevelSubjectFormatter">
            </el-table-column>
            <el-table-column label="金额" :resizable="false" align="center" prop="amount" width="150px">
            </el-table-column>
        </el-table>
        <!--新增支出录入-->
        <el-dialog title="信息录入" :visible.sync="ExpenditureAdd" width="700px" max-hight="400px" append-to-body>
            <ExpenditureAdd @close-dialog="closeExpenditureDialog"></ExpenditureAdd>
        </el-dialog>
        <!--导入支出录入表-->
        <el-dialog title="信息导入" :visible.sync="ExpenditureImport" width="400px" append-to-body>
            <el-upload class="upload-demo" action="" :on-change="handleChange" :on-remove="handleRemove"
                :on-exceed="handleExceed"
                accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel"
                :auto-upload="false">
                <!-- 只 能 上 传 xlsx / xls 文 件 -->
                <el-button size="small" type="primary">点击上传</el-button>
            </el-upload>
        </el-dialog>
    </div>
</template>

<script>
import request from "@/utils/request";
import ExpenditureAdd from "@/views/project/components/ExpenditureAdd.vue";

export default {
    components: { ExpenditureAdd },
    props: {
        ipId: {
            type: [Number, String],
            required: true,
        },
    },
    data() {
        return {
            contentStyle: {
                'text-align': 'center',
                'width': '60%',
            },
            params: {
                ipId: null,
            },
            // 遮罩层
            loading: true,
            ExpenditureAdd: false,
            ExpenditureImport: false,
            expenditureLook: [],
            importedData: [],
            da: [],
        };
    },
    watch: {
        ipId: {
            handler(newVal) {
                this.params.ipId = newVal;
                // this.checkExpenditure();
            },
            immediate: true, // 立即执行一次
        },
    },
    methods: {
        /** 下载按钮操作 */
        truncatedName(originalName) {
            const lastDotIndex = originalName.lastIndexOf('.');
            return lastDotIndex !== -1 ? originalName.substring(0, lastDotIndex) : originalName;
        },
         // 格式化日期方法
         formatDate(date) {
            // 假设日期格式为 "YYYY-MM-DD"
            const parts = date.split('-');
            if (parts.length === 3) {
                const year = parts[0];
                const month = parts[1];
                const day = parts[2];
                return `${year}-${month}-${day}`;
            }
            // 如果日期格式不正确，直接返回原始日期
            return date;
        },
        // 科目粗分
        firstLevelSubjectFormatter(row) {
            const firstLevelSubject = {
                0: '设备费',
                1: '业务费',
                2: '劳务费',
                3: '材料费',
                4: '科研活动费',
                5: '科研服务费',
                6: '人员和劳务补助费',
                7: '绩效支出',
            };
            return firstLevelSubject[row.firstLevelSubject];
        },
        // 科目细分
        secondLevelSubjectFormatter(row) {
            const secondLevelSubject = {
                0: '购置设备费',
                1: '试制设备费',
                2: '设备升级改造费',
                3: '设备租赁费',
                4: '材料费',
                5: '资料费',
                6: '数据样本采集费',
                7: '测试化验加工费',
                8: '燃料动力费',
                9: '办公费',
                10: '印刷/出版费',
                11: '知识产权事务费',
                12: '车辆使用费',
                13: '出版/文献/信息传播/知识产权事务费',
                14: '差旅费',
                15: '会议/会务费',
                16: '国内协作费',
                17: '国际合作交流费',
                18: '专家咨询费',
                19: '人员劳务费',
            };
            return secondLevelSubject[row.secondLevelSubject];
        },
        // 专项自筹
        zxzcFormatter(row) {
            const zxzc = {
                0: '专项',
                1: '自筹',
            };
            return zxzc[row.zxzc];
        },
        /** 新增按钮操作 */
        handleAdd() {
            this.ExpenditureAdd = true;
        },
        /** 导入按钮操作 */
        handleImport() {
            this.ExpenditureImport = true;
        },
        closeExpenditureDialog() {
            this.ExpenditureAdd = false;
            this.ExpenditureImport = false;

        },
        limitUpload() {

        },
        //超出最大上传文件数量时的处理方法
        handleExceed() {
            this.$message({
                type: 'warning',
                message: '超出最大上传文件数量的限制！'
            })
            return;
        },
        //移除文件的操作方法
        handleRemove(file, fileList) {
            this.fileTemp = null
        },
        handleChange(file, fileList) {
            this.fileTemp = file.raw;
            if (this.fileTemp) {
                if ((this.fileTemp.type == 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet')
                    || (this.fileTemp.type == 'application/vnd.ms-excel')) {
                    // 调用后端接口，上传数据
                    const formData = new FormData();
                    formData.append('file', file.raw);
                    request.post('/project/funds/importData', formData)
                        .then(response => {
                            // 处理后端响应，将解析后的数据设置到列表中
                            console.log('数据传入', response);
                            this.da = response.data;
                            this.$message({
                                type: 'success',
                                message: '文件上传成功！'
                            });
                        })
                        .catch(error => {
                            // 处理上传失败的情况
                            console.error('文件上传失败：', error);
                            this.$message.error('文件上传失败，请稍后重试！');
                        });
                } else {
                    this.ExpenditureImport = false; // 文件格式错误时关闭导入对话框
                    this.$message({
                        type: 'warning',
                        message: '文件格式错误，请删除后重新上传！'
                    });
                }
            } else {
                this.$message({
                    type: 'warning',
                    message: '请上传文件！'
                });
            }
        },
    },
};
</script>
