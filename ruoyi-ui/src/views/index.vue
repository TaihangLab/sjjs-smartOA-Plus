<template>
    <div class="home">
        <!-- 通知公告 -->
        <el-row>
            <el-col :span="12">
                <el-card style="margin-right: 20px;">
                    <h3 slot="header">通知公告</h3>
                    <el-table :data="noticeList" style="width: 100%; line-height: 1 !important;">
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
            <el-col :span="12">
                <el-card>
                    <h3 slot="header">成员信息</h3>

                    <el-row>
                        <!-- 学历分布柱状图 -->
                        <el-col :span="12">
                            <div style="height: 290px; width: 100%;" ref="educationChart"></div>
                        </el-col>

                        <!-- 职称分布柱状图 -->
                        <el-col :span="12">
                            <div style="height: 290px; width: 100%;" ref="titleChart"></div>
                        </el-col>
                    </el-row>
                </el-card>
            </el-col>
        </el-row>
        <!-- 项目统计和知识产权 -->
        <el-row style="margin-top: 20px;">
            <!-- 项目统计 -->
            <el-col :span="12">
                <el-card style="margin-right: 20px;">
                    <h3 slot="header">项目统计</h3>
                    <!-- 在这里添加项目统计的内容 -->
                    <div style="height: 300px;" ref="projectChart"></div>
                </el-card>
            </el-col>

            <el-col :span="12">
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
            this.initProjectChart(echarts);
            this.initChart(echarts);
            this.initEducationChart(echarts);
            this.initTitleChart(echarts);
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
        initEducationChart(echarts) {
            const educationData = {
                categories: ['博士', '硕士', '本科'],
                data: [80, 50, 20],
            };

            const educationChart = echarts.init(this.$refs.educationChart);
            const option = {
                title: {
                    text: '学历', // 设置标题文本
                    left: 'center', // 标题居中显示
                    textStyle: {
                        color: '#333', // 标题颜色
                        fontSize: 16, // 标题字体大小
                    },
                },
                xAxis: {
                    type: 'category',
                    data: educationData.categories,
                },
                yAxis: {
                    type: 'value',
                },
                tooltip: {
                    trigger: 'axis',
                    formatter: '{b}: {c} 人',
                },
                series: [{
                    type: 'bar',
                    data: educationData.data,
                    itemStyle: {
                        color: 'green',
                    },
                }],
            };
            educationChart.setOption(option);
        },

        initTitleChart(echarts) {
            const titleData = {
                categories: ['专家', '初级工程师', '高级工程师'],
                data: [40, 30, 10],
            };

            const titleChart = echarts.init(this.$refs.titleChart);
            const option = {
                title: {
                    text: '职称', // 设置标题文本
                    left: 'center', // 标题居中显示
                    textStyle: {
                        color: '#333', // 标题颜色
                        fontSize: 16, // 标题字体大小
                    },
                },
                xAxis: {
                    type: 'category',
                    data: titleData.categories,
                },
                yAxis: {
                    type: 'value',
                },
                tooltip: {
                    trigger: 'axis',
                    formatter: '{b}: {c} 人',
                },
                series: [{
                    type: 'bar',
                    data: titleData.data,
                }],
            };
            titleChart.setOption(option);
        },

        initProjectChart(echarts) {
            const projectData = {
                // 模拟数据
                xAxis: ['1月', '2月', '3月', '4月', '5月', '6月'],
                series: [
                    {
                        name: '任务完成数量',
                        type: 'line',
                        data: [30, 40, 20, 50, 10, 60], // 请替换为你的实际数据
                    },
                ],
            };

            const projectChart = echarts.init(this.$refs.projectChart);
            const option = {
                xAxis: {
                    type: 'category',
                    data: projectData.xAxis,
                },
                yAxis: {
                    type: 'value',
                },
                series: projectData.series,
            };
            projectChart.setOption(option);
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

.el-card {
    border-radius: 10px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}
</style>
  