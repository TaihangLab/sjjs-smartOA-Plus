<template>
    <div>
        <el-form
            ref="dataForm"
            :inline="true"
            :model="filters"
            class="demo-form-inline"
            style="margin-left: 30px; margin-top: 20px;"
        >
            <el-form-item label="一级科目">
                <el-select v-model="filters.firstLevelSubject" placeholder="请选择一级科目" clearable>
                    <el-option
                        v-for="item in subjectData.firstLevelSubjects"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value"
                    ></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="二级科目">
                <el-select v-model="filters.secondLevelSubject" placeholder="请选择二级科目" clearable>
                    <el-option
                        v-for="item in subjectData.secondLevelSubjects"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value"
                    ></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="三级科目">
                <el-select v-model="filters.thirdLevelSubject" placeholder="请选择三级科目" clearable>
                    <el-option
                        v-for="item in subjectData.thirdLevelSubjects"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value"
                    ></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="起始时间">
                <el-date-picker v-model="filters.startDate" type="date" placeholder="请选择起始时间" value-format="yyyy-MM-dd"></el-date-picker>
            </el-form-item>
            <el-form-item label="结束时间">
                <el-date-picker v-model="filters.endDate" type="date" placeholder="请选择结束时间" value-format="yyyy-MM-dd"></el-date-picker>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>
        </el-form>
        <el-table ref="multipleTable" :data="expenditureEntry" border
                  style="width: 100%; max-height: 800px; overflow-y: auto;" :row-style="{ height: '50px' }"
                  :cell-style="{ padding: '0px' }">
            <el-table-column label="日期" :resizable="false" align="center" width="100px">
                <template slot-scope="scope">
                    {{ formatDate(scope.row.expenditureDate) }}
                </template>
            </el-table-column>
            <el-table-column label="项目名称" :resizable="false" align="center" prop="projectName" width="250px">
            </el-table-column>
            <el-table-column label="凭证号" :resizable="false" align="center" prop="voucherNo" width="100px">
            </el-table-column>
            <el-table-column label="摘要" :resizable="false" align="center" prop="expenditureAbstract" min-width="200px">
            </el-table-column>
            <el-table-column label="专项/自筹" :resizable="false" align="center" prop="zxzc" :formatter="zxzcFormatter">
            </el-table-column>
            <el-table-column label="直接/间接" :resizable="false" align="center" prop="zjjj" :formatter="zjjjFormatter">
            </el-table-column>
            <el-table-column label="一级科目" :resizable="false" align="center" prop="firstLevelSubject" width="150px" :formatter="subjectFormatter('firstLevelSubjects')">
            </el-table-column>
            <el-table-column label="二级科目" :resizable="false" align="center" prop="secondLevelSubject" width="150px" :formatter="subjectFormatter('secondLevelSubjects')">
            </el-table-column>
            <el-table-column label="三级科目" :resizable="false" align="center" prop="thirdLevelSubject" width="150px" :formatter="subjectFormatter('thirdLevelSubjects')">
            </el-table-column>
            <el-table-column :resizable="false" align="center" prop="amount" width="150px">
                <template slot="header">
                    <div style="text-align: center;">
                        <span>金额</span>
                        <span style="font-size: 12px; color: #F56C6C;">（元）</span>
                    </div>
                </template>
            </el-table-column>
            <el-table-column label="导入时间" :resizable="false" align="center" prop="createTime" width="160px">
            </el-table-column>
            <el-table-column label="操作" :resizable="false" align="center" min-width="80px" fixed="right">
                <template slot-scope="scope">
                    <el-button size="mini" type="text" icon="el-icon-refresh-left"
                               @click="confirmDeleteExpenditure(scope.row.expenditureId)"
                               v-hasPermi="['project:expense:cancel']">撤销
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination :current-page="queryParam.pageNum" :page-size="queryParam.pageSize"
                       :page-sizes="[5, 10, 20, 50, 100]" :total="total"
                       layout="total, sizes, prev, pager, next, jumper"
                       style="margin-top: 30px" @size-change="sizeChangeHandle" @current-change="CurrentChangeHandle">
        </el-pagination>
    </div>
</template>

<script>
import request from '@/utils/request';
import { MessageBox, Message } from 'element-ui';
import { getExpenditure } from "@/api/project/expenditure";

export default {
    name: "ExpenditureCheck",
    props: {
        projectId: {
            type: [Number, String],
            required: true,
        },
    },
    data() {
        return {
            loading: true,
            expenditureEntry: undefined,
            total: 0, // 总条数
            queryParam: {
                pageNum: 1,
                pageSize: 10,
            },
            filters: {
                firstLevelSubject: '',
                secondLevelSubject: '',
                thirdLevelSubject: '',
                startDate: '',
                endDate: '',
            },
            subjectData: {
                firstLevelSubjects: [
                    { value: '0', label: '设备费' },
                    { value: '1', label: '业务费' },
                    { value: '2', label: '劳务费' },
                    { value: '3', label: '材料费' },
                    { value: '4', label: '科研活动费' },
                    { value: '5', label: '科研服务费' },
                    { value: '6', label: '人员和劳务补助费' },
                    { value: '7', label: '绩效支出' },
                    { value: '8', label: '管理费' },
                    { value: '9', label: '房屋租赁费' },
                    { value: '10', label: '日常水电暖费' },
                    { value: '11', label: '资料费' },
                    { value: '12', label: '数据样本采集费' },
                    { value: '13', label: '测试化验加工费' },
                    { value: '14', label: '燃料动力费' },
                    { value: '15', label: '办公费' },
                    { value: '16', label: '印刷/出版费' },
                    { value: '17', label: '知识产权事务费' },
                    { value: '18', label: '车辆使用费' },
                    { value: '19', label: '差旅费' },
                    { value: '20', label: '会议/会务费' },
                    { value: '21', label: '专家咨询费' },
                    { value: '22', label: '其他费用' },
                ],
                secondLevelSubjects: [
                    { value: '0', label: '购置设备费' },
                    { value: '1', label: '试制设备费' },
                    { value: '2', label: '设备升级改造费' },
                    { value: '3', label: '设备租赁费' },
                    { value: '4', label: '材料费' },
                    { value: '5', label: '资料费' },
                    { value: '6', label: '数据样本采集费' },
                    { value: '7', label: '测试化验加工费' },
                    { value: '8', label: '燃料动力费' },
                    { value: '9', label: '办公费' },
                    { value: '10', label: '印刷/出版费' },
                    { value: '11', label: '知识产权事务费' },
                    { value: '12', label: '车辆使用费' },
                    { value: '13', label: '出版/文献/信息传播/知识产权事务费' },
                    { value: '14', label: '差旅费' },
                    { value: '15', label: '会议/会务费' },
                    { value: '16', label: '国内协作费' },
                    { value: '17', label: '国际合作交流费' },
                    { value: '18', label: '专家咨询费' },
                    { value: '19', label: '人员劳务费' },
                    { value: '20', label: '会议/差旅/国际合作与交流费' },
                    { value: '21', label: '无' },
                ],
                thirdLevelSubjects: [
                    { value: '0', label: '无' },
                    { value: '1', label: '知识产权事务费' },
                    { value: '2', label: '印刷打印制作费' },
                    { value: '3', label: '文献数据库费' },
                    { value: '4', label: '信息传播费' },
                    { value: '5', label: '会议费' },
                    { value: '6', label: '差旅费' },
                    { value: '7', label: '国际合作费' },
                ],
            },
        };
    },
    watch: {
        projectId: {
            handler(newVal) {
                this.checkExpenditureEntryDetail();
            },
            immediate: true,
        },
    },
    methods: {
        formatDate(date) {
            const parts = date.split('-');
            if (parts.length === 3) {
                const year = parts[0];
                const month = parts[1];
                const day = parts[2];
                return `${year}-${month}-${day}`;
            }
            return date;
        },
        subjectFormatter(level) {
            return (row, column, value) => {
                const subject = this.subjectData[level].find(item => item.value === value.toString());
                return subject ? subject.label : '';
            };
        },
        zxzcFormatter(row) {
            const zxzc = {
                0: '专项',
                1: '自筹',
            };
            return zxzc[row.zxzc];
        },
        zjjjFormatter (row) {
            const zjjj = {
                0: '直接',
                1: '间接',
            };
            return zjjj[row.zjjj];
        },
        handleQuery() {
            const bodyData = {
                projectId: this.$props.projectId,
                firstLevelSubject: this.filters.firstLevelSubject,
                secondLevelSubject: this.filters.secondLevelSubject,
                thirdLevelSubject: this.filters.thirdLevelSubject,
                expenditureDateSta: this.filters.startDate,
                expenditureDateEnd: this.filters.endDate,
            };
            getExpenditure(bodyData,this.queryParam)
                .then((resp) => {
                this.expenditureEntry = resp.rows;
                this.total = resp.total;
                this.loading = false;
            })
                .catch(() => {
                    this.loading = false;
                });
        },
        checkExpenditureEntryDetail() {
            const bodyData = {
                projectId: this.$props.projectId,
            };
            getExpenditure(bodyData, this.queryParam)
                .then((resp) => {
                    this.expenditureEntry = resp.rows;
                    this.total = resp.total;
                    this.loading = false;
                })
                .catch(() => {
                    this.loading = false;
                });
        },
        confirmDeleteExpenditure(expenditureId) {
            MessageBox.confirm('确定撤销该录入信息吗？', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning',
            }).then(() => {
                this.deleteExpenditure(expenditureId);
            });
        },
        deleteExpenditure(expenditureId) {
            request({
                url: `/project/funds/rollback`,
                method: 'get',
                params: {
                    expenditureId: expenditureId,
                },
            })
                .then(() => {
                    this.checkExpenditureEntryDetail();
                })
                .catch(error => {
                    Message.error('删除支出信息失败，请稍后重试！');
                });
        },
        sizeChangeHandle(size) {
            this.queryParam.pageSize = size;
            this.checkExpenditureEntryDetail();
        },
        CurrentChangeHandle(page) {
            this.queryParam.pageNum = page;
            this.checkExpenditureEntryDetail();
        },
    },
};
</script>
