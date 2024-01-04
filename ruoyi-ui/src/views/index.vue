<template>
    <div class="home">
        <!-- 通知公告 -->
        <el-row>
            <el-col :span="24">
                <el-card>
                    <h3 slot="header">通知公告</h3>
                    <el-table :data="noticeList" style="width: 100%" :border="false" class="custom-table">
                        <el-table-column label="公告标题" align="center" prop="noticeTitle" :show-overflow-tooltip="true">
                            <template slot-scope="scope">
                                <span @click="showNoticeContent(scope.row)">{{ scope.row.noticeTitle }}</span>
                            </template>
                        </el-table-column>
                        <el-table-column label="类型" align="center" prop="noticeType" width="100">
                            <template slot-scope="scope">
                                <dict-tag :options="dict.type.sys_notice_type" :value="scope.row.noticeType" />
                            </template>
                        </el-table-column>
                        <el-table-column label="时间" align="center" prop="createTime" width="180">
                            <template slot-scope="scope">
                                <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-card>
            </el-col>
        </el-row>
        <!-- 项目统计和知识产权 -->
        <el-row style="margin-top: 20px;">
            <!-- 项目统计 -->
            <el-col :span="24">
                <el-card>
                    <h3 slot="header">项目统计</h3>
                    <!-- 在这里添加项目统计的内容 -->
                    <p>项目统计的详细信息在这里...</p>
                </el-card>
            </el-col>
        </el-row>
        <!-- 知识产权 -->
        <el-row style="margin-top: 20px;">
            <el-col :span="24">
                <el-card>
                    <h3 slot="header">知识产权</h3>
                    <div style="height: 300px;" ref="resultChart"></div>
                </el-card>
            </el-col>
        </el-row>
        <!-- 弹出的公告内容卡片 -->
        <el-dialog :title="selectedNotice.title" :visible.sync="showNoticeDialog" width="780px" append-to-body>
            <div slot="title" style="text-align: center;">{{ selectedNotice.title }}</div>
            <div v-html="selectedNotice.content"></div>
        </el-dialog>
    </div>
</template>
  
<script>
import { listNotice, getNotice, updateNotice } from "@/api/system/notice";

export default {
    dicts: ['sys_notice_status', 'sys_notice_type'],
    data() {
        return {
            noticeList: [],
            showNoticeDialog: false,
            selectedNotice: {
                title: '',
                content: ''
            },
            loading: true,
            queryParams: {
                pageNum: 1,
                pageSize: 10,
                noticeTitle: undefined,
                createBy: undefined,
                status: undefined
            },
        };
    },
    created() {
        this.getList();
    },
    mounted() {
        import('echarts').then((echarts) => {
            this.initChart(echarts);
        });
    },
    methods: {
        showNoticeContent(row) {
            this.loading = true;
            getNotice(row.noticeId).then((response) => {
                this.selectedNotice.title = response.data.noticeTitle;
                this.selectedNotice.content = response.data.noticeContent;
                this.showNoticeDialog = true;
                this.loading = false;
            });
        },
        handleCloseNoticeDialog() {
            // 关闭弹窗时清空数据
            this.selectedNotice.title = '';
            this.selectedNotice.content = '';
            this.showNoticeDialog = false;
        },
        getList() {
            this.loading = true;
            listNotice(this.queryParams).then(response => {
                response.rows.sort((a, b) => new Date(b.createTime) - new Date(a.createTime));
                this.noticeList = response.rows.slice(0, 5);
                this.total = response.total;
                this.loading = false;
            });
        },
        initChart(echarts) {
            const resultData = [
                { value: 335, name: '完成任务A' },
                { value: 310, name: '未完成任务B' },
                { value: 234, name: '已完成任务C' },
                { value: 135, name: '进行中任务D' },
                { value: 1548, name: '待处理任务E' },
            ];

            const chart = echarts.init(this.$refs.resultChart);
            const option = {
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b}: {c} ({d}%)',
                },
                series: [
                    {
                        name: '知识产权',
                        type: 'pie',
                        radius: ['0%', '70%'],
                        center: ['50%', '50%'],
                        avoidLabelOverlap: false,
                        label: {
                            show: true,
                            position: 'outside',
                            formatter: '{b}: {c} ({d}%)',
                        },
                        emphasis: {
                            label: {
                                show: true,
                                fontSize: '14',
                                fontWeight: 'bold',
                            },
                        },
                        labelLine: {
                            show: true,
                            length2: 10,
                        },
                        data: resultData,
                    },
                ],
            };
            chart.setOption(option);
        },
    },
};
</script>
  
<style scoped>
.home {
    padding: 20px;
}

.custom-table .el-table .el-table__body-wrapper {
    border-bottom: none;
}

.el-card {
    border-radius: 10px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

.el-table__header th,
.el-table__body tr {
    background-color: #f5f5f5;
}

.el-table__body tr:hover {
    background-color: #e0e0e0;
}
</style>
  