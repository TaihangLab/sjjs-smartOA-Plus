<template>
    <div style="max-height: 700px;">
        <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
                <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                    v-hasPermi="['system:user:add']">新增</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="info" plain icon="el-icon-upload2" size="mini" @click="handleImport"
                    v-hasPermi="['system:user:import']">导入</el-button>
            </el-col>
            <div style="display: flex; justify-content: flex-end;margin-right: 5px;">
                <el-button type="primary" size="mini" @click="addFunds">提交<i
                        class="el-icon-upload el-icon--right"></i></el-button>
            </div>
        </el-row>
        <el-table ref="multipleTable" :data="da" border style="width: 100%; max-height: 500px; overflow-y: auto;"
            :row-style="{ height: '50px' }" :cell-style="{ padding: '0px' }">
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
            <el-table-column label="直接/间接" :resizable="false" align="center" prop="zjjj" :formatter="zjjjFormatter">
            </el-table-column>
            <el-table-column label="一级科目" :resizable="false" align="center" prop="firstLevelSubject"
                :formatter="firstLevelSubjectFormatter">
            </el-table-column>
            <el-table-column label="二级科目" :resizable="false" align="center" prop="secondLevelSubject"
                :formatter="secondLevelSubjectFormatter">
            </el-table-column>
            <el-table-column label="三级科目" :resizable="false" align="center" prop="thirdLevelSubject">
            </el-table-column>
            <el-table-column label="金额" :resizable="false" align="center" prop="amount" width="150px">
            </el-table-column>
        </el-table>
        <!--新增支出录入-->
        <el-dialog title="信息录入" :visible.sync="ExpenditureAdd" width="700px" max-height="400px" append-to-body>
            <ExpenditureAdd @new-data="handleNewData" @close-dialog="closeExpenditureDialog"></ExpenditureAdd>
        </el-dialog>
        <!--导入支出录入表-->
        <el-dialog title="信息导入" :visible.sync="ExpenditureImport" width="400px" append-to-body>
            <div style="padding: 20px;">
                <!-- 显示已选择的文件 -->
                <div v-if="fileTemp" class="selected-file">
                    已选择文件：{{ fileTemp.name }}
                </div>
                <el-upload ref="upload" class="upload-demo" action="" :on-change="handleChange"
                    :on-remove="handleRemove" :on-exceed="handleExceed" :limit="1" list-type="text"
                    accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel"
                    :auto-upload="false">
                    <!-- 使用自定义按钮 -->
                    <span class="custom-upload-btn">
                        <div class="upload-text">文件上传</div>
                    </span>
                    <div slot="tip" class="el-upload__tip">仅允许导入xls、xlsx格式文件。</div>
                </el-upload>
                <div style="margin-top: 5px;">
                    <el-button size="small" @click="handleCancel">取消</el-button>
                    <el-button size="small" type="primary" @click="confirmUpload" :disabled="!fileTemp">确认</el-button>
                </div>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import request from "@/utils/request";
import ExpenditureAdd from "@/views/project/components/ExpenditureAdd.vue";

export default {
    components: { ExpenditureAdd },
    props: ['projectId'],
    data() {
        return {
            contentStyle: {
                'text-align': 'center',
                'width': '60%',
            },
            params: {
                projectId: null,
            },
            // 遮罩层
            loading: true,
            ExpenditureAdd: false,
            ExpenditureImport: false,
            expenditureLook: [],
            importedData: [],
            fileTemp: null, // 存储用户选择的文件
            da: [],
        };
    },
    watch: {
        projectId: {
            handler(newVal) {
                this.params.projectId = newVal;
                // this.checkExpenditure();
            },
            immediate: true, // 立即执行一次
        },
    },
    mounted() {
        console.log('projectId:', this.projectId);
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
        // 一级科目
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
        // 二级科目
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
                18: '会议/差旅/国际合作与交流费',
                19: '专家咨询费',
                21: '人员劳务费',
            };
            return secondLevelSubject[row.secondLevelSubject];
        },
        // 三级科目
        thirdLevelSubjectFormatter(row) {
            const thirdLevelSubject = {
                0: '设备费',
                1: '业务费',
                2: '劳务费',
                3: '材料费',
                4: '科研活动费',
                5: '科研服务费',
                6: '人员和劳务补助费',
                7: '绩效支出',
            };
            return thirdLevelSubject[row.thirdLevelSubject];
        },
        // 专项自筹
        zxzcFormatter(row) {
            const zxzc = {
                0: '专项',
                1: '自筹',
            };
            return zxzc[row.zxzc];
        },
        // 专项自筹
        zjjjFormatter(row) {
            const zjjj = {
                0: '直接',
                1: '间接',
            };
            return zjjj[row.zjjj];
        },
        /** 新增按钮操作 */
        handleAdd() {
            this.ExpenditureAdd = true;
        },
        /** 导入按钮操作 */
        handleImport() {
            this.ExpenditureImport = true;
        },
        /** 提交按钮操作 */
        addFunds() {
            if (this.da.length === 0) {
                this.$message({
                    type: 'warning',
                    message: '没有要上传的数据！'
                });
                return;
            }

            // 将 this.da 格式化为服务器期望的数组格式
            const expenditureData = this.da.map(item => ({
                // 假设以下属性适用于 ProjectExpenditureBO 对象，请根据实际情况调整
                expenditureDate: item.expenditureDate,
                projectName: item.projectName,
                voucherNo: item.voucherNo,
                expenditureAbstract: item.expenditureAbstract,
                zxzc: item.zxzc,
                zjjj: item.zjjj,
                firstLevelSubject: item.firstLevelSubject,
                secondLevelSubject: item.secondLevelSubject,
                thirdLevelSubject: item.thirdLevelSubject,
                amount: item.amount
            }));

            request({
                url: '/project/funds/add',
                method: 'post',
                data: {
                    projectId: this.params.projectId,
                    expenditureData: expenditureData // 修改这里为格式化后的数组
                }
            }).then((resp) => {
                console.log(resp);
                this.$message({
                    type: 'success',
                    message: '上传成功！'
                });
                // 清空数据列表
                this.da = [];
            }).catch(error => {
                console.error("上传失败", error);
                this.$message({
                    type: 'error',
                    message: '上传失败，请稍后重试！'
                });
            });
        },
        closeExpenditureDialog() {
            this.ExpenditureAdd = false;
            this.ExpenditureImport = false;

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
            this.fileTemp = null; // 清空文件名
            this.$refs.upload.clearFiles(); // 删除已上传的文件
        },
        handleChange(file, fileList) {
            this.fileTemp = file.raw; // 将选择的文件存储起来以供预览
        },
        handleCancel() {
            this.fileTemp = null; // 清空文件名
            this.$refs.upload.clearFiles(); // 删除已上传的文件
            this.ExpenditureImport = false; // 关闭导入对话框
        },
        confirmUpload() {
            if (this.fileTemp) {
                // 调用上传方法
                const formData = new FormData();
                formData.append('file', this.fileTemp);
                request.post('/project/funds/importData', formData)
                    .then(response => {
                        // 处理后端响应，例如更新数据列表等操作
                        console.log('文件上传成功！', response);
                        // 将新数据追加到已有数据列表中
                        this.da = this.da.concat(response.data);
                        this.$message({
                            type: 'success',
                            message: '文件导入成功！'
                        });
                        this.ExpenditureImport = false; // 关闭导入对话框
                        // 清空选择的文件
                        this.fileTemp = null;
                        // 删除已上传的文件
                        this.$refs.upload.clearFiles(); // 假设上传组件的 ref 属性为 upload
                    })
                    .catch(error => {
                        // 处理上传失败情况
                        console.error('文件上传失败：', error);
                        this.$message.error('文件上传失败，请稍后重试！');
                    });
            } else {
                // 如果没有选择文件，给出提示
                this.$message({
                    type: 'warning',
                    message: '请先选择要上传的文件！'
                });
            }
        },
        handleNewData(newData) {
            // 处理来自子组件的新数据
            this.da = this.da.concat(newData);
            // 关闭ExpenditureAdd窗口
            this.ExpenditureAdd = false;
        },
        clearDataOnPageClose() {
            // 当页面关闭时，清空数据列表
            this.da = [];
        }
    },
};
</script>

<style>
.custom-upload-btn {
    /* 添加虚线框 */
    border: 2px dashed #dddfe0;
    border-radius: 10px;
    padding: 40px;
    /* 增加内边距 */
    cursor: pointer;
    /* 鼠标样式改为手型 */
    display: flex;
    /* 设置为flex布局 */
    justify-content: center;
    /* 水平居中 */
    align-items: center;
    /* 垂直居中 */
    width: 300px;
    /* 设置框的宽度 */
    height: 200px;
    /* 设置框的高度 */
}

.custom-upload-btn:hover {
    /* 鼠标悬停时改变颜色 */
    border-color: #409eff;
}

.upload-text {
    font-size: 16px;
    color: #409eff;
}
</style>