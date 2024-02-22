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
        <el-table ref="multipleTable" :data="this.intellectualLook.ipUserVOList" border style="width: 100%"
            :row-style="{ height: '50px' }" :cell-style="{ padding: '0px' }">
            <el-table-column label="年" :resizable="false" align="center" prop="" width="50px">
            </el-table-column>
            <el-table-column label="月" :resizable="false" align="center" prop="" width="50px">
            </el-table-column>
            <el-table-column label="日" :resizable="false" align="center" prop="" width="50px">
            </el-table-column>
            <el-table-column label="日期" :resizable="false" align="center" prop="" width="100px">
            </el-table-column>
            <el-table-column label="项目名称" :resizable="false" align="center" prop="jobTitle" :formatter="jobTitles"
                width="250px">
            </el-table-column>
            <el-table-column label="凭证号" :resizable="false" align="center" prop="email" width="100px">
            </el-table-column>
            <el-table-column label="摘要" :resizable="false" align="center" prop="phonenumber" min-width="400px">
            </el-table-column>
            <el-table-column label="专项/自筹" :resizable="false" align="center" prop="diploma" :formatter="diplomas">
            </el-table-column>
            <el-table-column label="科目粗分" :resizable="false" align="center" prop="deptName">
            </el-table-column>
            <el-table-column label="科目细分" :resizable="false" align="center" prop="deptName">
            </el-table-column>
            <el-table-column label="金额" :resizable="false" align="center" prop="phonenumber" width="150px">
            </el-table-column>
        </el-table>
        <!--新增支出录入-->
        <el-dialog title="信息录入" :visible.sync="ExpenditureAdd" width="700px" append-to-body>
            <ExpenditureAdd @close-dialog="closeExpenditureDialog"></ExpenditureAdd>
        </el-dialog>
        <!--导入支出录入表-->
        <el-dialog title="信息导入" :visible.sync="ExpenditureImport" width="400px" append-to-body>
            <ExpenditureImport @close-dialog="closeExpenditureDialog"></ExpenditureImport>
        </el-dialog>
    </div>
</template>

<script>
import request from "@/utils/request";
import ExpenditureAdd from "@/views/project/components/ExpenditureAdd.vue";
import ExpenditureImport from "@/views/project/components/ExpenditureImport.vue";

export default {
    components: { ExpenditureAdd, ExpenditureImport },
    props: {
        ipId: {
            type: [Number, String],
            required: true,
        },
    },
    data() {
        return {
            jobTitle: {
                0: '正高级工程师',
                1: '副高级工程师',
                2: '中级工程师',
                3: '初级工程师',
                4: '研究员',
                5: '副研究员',
                6: '助理研究员',
                7: '研究实习员',
            },
            diploma: {
                0: '专项',
                1: '自筹',
            },
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
            intellectualLook: {}, 
        };
    },
    watch: {
        ipId: {
            handler(newVal) {
                this.params.ipId = newVal;
                this.checkIntellectual();
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
        jobTitles(row, column, cellValue) {
            // 使用映射关系来获取对应的文字描述
            return this.jobTitle[cellValue] || cellValue;
        },
        diplomas(row, column, cellValue) {
            // 使用映射关系来获取对应的文字描述
            return this.diploma[cellValue] || cellValue;
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
        checkIntellectual() {
            this.params.ipId = this.$props.ipId;
            request({
                url: '/ip/getDetails',
                method: 'get',
                params: this.params,
            })
                .then((resp) => {
                    this.intellectualLook = resp.data;
                    this.loading = false; // 数据加载完成后隐藏遮罩层
                })
                .catch((error) => {
                    console.error('获取数据时出错：', error);
                    this.loading = false; // 在出错情况下也隐藏遮罩层
                });
        },
    },
};
</script>

