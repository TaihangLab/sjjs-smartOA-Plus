<template>
    <div class="home">
        <div id="curtain">
            <h1 data-heading="数">数据技术</h1>
        </div>
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
                data: [2, 19, 25],
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
                categories: ['正高级工程师', '副高级工程师', '中级工程师 ', '初级工程师', '研究员', '副研究员', '研究实习员'],
                data: [4, 6, 11, 20, 10, 25, 10],
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
                    axisLabel: {
                        interval: 0,
                        rotate: -90, // 将横坐标文字逆时针旋转90度
                        verticalAlign: 'middle', // 文字垂直对齐方式
                    },
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

<style scoped lang="scss">
.home {
    padding: 20px;
}

.el-card {
    border-radius: 10px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

$h1:  rgba(45,45,45,1);
$blue: #98b5cc;
$yellow: #ffcc00;
$outline: rgba(#fff, .4);
$shadow: rgba($yellow, .5);
#curtain {
    background: linear-gradient(45deg, rgb(182, 182, 182) 9%, rgb(56, 56, 56) 100%);
    width: 100%;
    height: 10vh;
    border-radius: 30px;
}

h1 {
    font-family: '阿里妈妈东方大楷 Regular', sans-serif;
    font-size: 4vw;
    text-align: center;
    line-height: 1;
    margin: 0;
    top: 6%;
    left: 50%;
    transform: translate(-50%, -50%);
    position: absolute;
    color: $h1;
    letter-spacing: 1rem;

    &:before {
        content: attr(data-heading);
        position: absolute;
        overflow: hidden;
        color: $yellow;
        width: 100%;
        z-index: 5;
        text-shadow: none;
        left: 0;
        text-align: left;
        animation: flicker 3s linear infinite;
    }
}

@keyframes flicker {
    0%, 19.999%, 22%, 62.999%, 64%, 64.999%, 70%, 100% {
        opacity: .99;
        text-shadow: -1px -1px 0 $outline, 1px -1px 0 $outline,
        -1px 1px 0 $outline, 1px 1px 0 $outline,
        0 -2px 8px, 0 0 2px, 0 0 5px #ff7e00,
        0 0 5px #ff4444, 0 0 2px #ff7e00, 0 2px 3px #000;
    }
    20%, 21.999%, 63%, 63.999%, 65%, 69.999% {
        opacity: 0.4;
        text-shadow: none;
    }
}

@font-face {
    font-family: "阿里妈妈东方大楷 Regular";
    font-weight: 400;
    src: url("../assets/fonts/AlimamaDongFangDaKai-Regular.woff2") format("woff2"),
    url("../assets/fonts/AlimamaDongFangDaKai-Regular.woff") format("woff");
    font-display: swap;
}


</style>

