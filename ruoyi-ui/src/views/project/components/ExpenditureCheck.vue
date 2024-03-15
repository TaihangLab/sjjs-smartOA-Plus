<template>
    <div>
        <el-table ref="multipleTable" :data="expenditureEntry" border
            style="width: 100%; max-height: 500px; overflow-y: auto;" :row-style="{ height: '50px' }"
            :cell-style="{ padding: '0px' }">
            <el-table-column label="日期" :resizable="false" align="center" width="100px">
                <!-- 使用 slot-scope 定制显示日期 -->
                <template slot-scope="scope">
                    {{ formatDate(scope.row.expenditureDate) }}
                </template>
            </el-table-column>
            <el-table-column label="项目名称" :resizable="false" align="center" prop="projectName" width="250px">
            </el-table-column>
            <el-table-column label="凭证号" :resizable="false" align="center" prop="voucherNo" width="80px">
            </el-table-column>
            <el-table-column label="摘要" :resizable="false" align="center" prop="expenditureAbstract" min-width="400px">
            </el-table-column>
            <el-table-column label="专项/自筹" :resizable="false" align="center" prop="zxzc" :formatter="zxzcFormatter">
            </el-table-column>
            <el-table-column label="一级科目" :resizable="false" align="center" prop="firstLevelSubject"
                :formatter="firstLevelSubjectFormatter">
            </el-table-column>
            <el-table-column label="二级科目" :resizable="false" align="center" prop="secondLevelSubject"
                :formatter="secondLevelSubjectFormatter">
            </el-table-column>
            <el-table-column label="三级科目" :resizable="false" align="center" prop="secondLevelSubject"
                :formatter="secondLevelSubjectFormatter">
            </el-table-column>
            <el-table-column  :resizable="false" align="center" prop="amount" width="100px">
                <template slot="header" slot-scope="scope">
                    <div style="text-align: center;">
                        <span>金额</span>
                        <span style="font-size: 12px; color: #F56C6C;">（万元）</span>
                    </div>
                </template>
            </el-table-column>
            <el-table-column label="导入时间" :resizable="false" align="center" prop="createTime" width="160px">
            </el-table-column>
            <el-table-column :label="'操作'" :resizable="false" align="center" min-width="80px">
                <template slot-scope="scope">
                    <el-button size="mini" type="text" icon="el-icon-refresh-left" fixed="right"
                        @click="handleDelete(scope.row.receivedId)">撤销
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
import request from '@/utils/request';

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
            // 遮罩层
            loading: true,
            expenditureEntry: undefined,
        }
    },
    watch: {
        projectId: {
            handler(newVal) {
                this.checkExpenditureEntryDetail();
            },
            immediate: true, // 立即执行一次
        },
    },
    methods: {
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
                18: '会议/差旅/国际合作与交流费',
                19: '专家咨询费',
                21: '人员劳务费',
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

        // 查看支出信息
        checkExpenditureEntryDetail() {
            request({
                url: '/project/funds/getProjectExpenditure',
                method: 'get',
                params: {
                    projectId: this.$props.projectId,
                },
            })
                .then((resp) => {
                    this.expenditureEntry = resp.data;
                    loading.close();
                })
                .catch((error) => {
                    console.error('获取用户数据时出错：', error);
                    loading.close();
                });
        },
    },
}
</script>
