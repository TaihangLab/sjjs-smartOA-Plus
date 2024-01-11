<template>
    <div class="home">
        <div id="curtain">
            <h1 data-heading="数">数据技术</h1>
        </div>
        <!-- 通知公告 -->
        <el-row style="margin-top: 20px;">
            <el-col :span="12">
                <el-card style="margin-right: 20px;">
                    <h3 slot="header">通知公告</h3>
                    <el-table :data="noticeList" style="width: 100%;height: 290px; line-height: 1 !important;">
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
                        <el-col :span="12" style="margin-left: -5px;">
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
                    <h3 slot="header">项目列表</h3>
                    <div style="height: 300px;" ref="projectChart"></div>
                </el-card>
            </el-col>
            <!-- 知识产权 -->
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
            <div v-html="selectedNotice.content" class="notice-content">

            </div>
        </el-dialog>
    </div>
</template>

<script>
import { listNotice, getNotice,} from "@/api/system/notice";
import request from '@/utils/request';

export default {
    dicts: ['sys_notice_status', 'sys_notice_type'],
    data() {
        return {
            noticeList: [],
            projectListData: {},
            educationData: {},
            jobtitleData: {},
            typeData: {},
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
        this.getProjectListData();
        this.getDiplomaData();
        this.getJobtitleData();
        this.getTypeData();
    },
    mounted() {
        import('echarts').then((echarts) => {
            this.$nextTick(() => {
                this.getProjectListData(() => {
                    this.initProjectChart(echarts);
                });
                this.getDiplomaData(() => {
                    this.initEducationChart(echarts);
                });
                this.getJobtitleData(() => {
                    this.initTitleChart(echarts);
                });
                this.getTypeData(() => {
                    this.initChart(echarts);
                });
            });
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
        getList() {
            this.loading = true;
            listNotice(this.queryParams).then(response => {
                response.rows.sort((a, b) => new Date(b.createTime) - new Date(a.createTime));
                this.noticeList = response.rows.slice(0, 5);
                this.total = response.total;
                this.loading = false;
            });
        },
        getProjectListData(callback) {
            request({
                url: '/statistic/project/level',
                method: 'get',
                data: {},
            }).then((resp) => {
                this.projectListData = resp;
                if (callback && typeof callback === 'function') {
                    callback();
                }
            }).catch(error => {
                console.error('Failed to fetch project list data:', error);
            });
        },
        getDiplomaData(callback) {
            request({
                url: '/statistic/user/diploma',
                method: 'get',
                data: {},
            }).then((resp) => {
                this.educationData = {
                    categories: Object.keys(resp),
                    data: Object.values(resp),
                };
                if (callback && typeof callback === 'function') {
                    callback();
                }
            }).catch(error => {
                console.error('Failed to fetch project list data:', error);
            });
        },
        getJobtitleData(callback) {
            request({
                url: '/statistic/user/jobtitle',
                method: 'get',
                data: {},
            }).then((resp) => {
                this.jobtitleData = {
                    categories: Object.keys(resp),
                    data: Object.values(resp),
                };
                if (callback && typeof callback === 'function') {
                    callback();
                }
            }).catch(error => {
                console.error('Failed to fetch project list data:', error);
            });
        },
        getTypeData(callback) {
            request({
                url: '/statistic/ip/type',
                method: 'get',
                data: {},
            }).then((resp) => {
                this.typeData = {
                    categories: Object.keys(resp),
                    data: Object.values(resp),
                };
                if (callback && typeof callback === 'function') {
                    callback();
                }
            }).catch(error => {
                console.error('Failed to fetch project list data:', error);
            });
        },
        initEducationChart(echarts) {
            // 获取学历图表容器
            const educationChart = echarts.init(this.$refs.educationChart);
            // 将数据转换为 ECharts 饼图所需的格式
            const pieData = this.educationData.data.map((count, index) => ({
                value: count,
                name: this.educationData.categories[index],
            }));
            // 配置饼图选项
            const option = {
                title: {
                    text: '学历',
                    left: 'center',
                    textStyle: {
                        color: '#333',
                        fontSize: 16,
                    },
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b}: {c} 人 ({d}%)', // 添加百分比显示
                },
                series: [{
                    name: '学历数量',
                    type: 'pie',
                    radius: ['40%', '60%'],
                    center: ['50%', '50%'],
                    avoidLabelOverlap: false,
                    label: {
                        show: true,
                        position: 'outside',
                        formatter: '{b}: {c} 人',
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
                    data: pieData,
                }],
            };
            // 设置饼图的选项
            educationChart.setOption(option);
        },
        initTitleChart(echarts) {
            // 获取职称图表容器
            const titleChart = echarts.init(this.$refs.titleChart);

            // 将数据转换为 ECharts 实心饼图所需的格式
            const pieData = this.jobtitleData.data.map((count, index) => ({
                value: count,
                name: this.jobtitleData.categories[index],
            }));

            // 配置实心饼图选项
            const option = {
                title: {
                    text: '职称', // 设置标题文本
                    left: 'center', // 标题居中显示
                    textStyle: {
                        color: '#333', // 标题颜色
                        fontSize: 16, // 标题字体大小
                    },
                },
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b}: {c} 人 ({d}%)', // 添加百分比显示
                },
                series: [{
                    name: '职称数量',
                    type: 'pie',
                    radius: '60%', // 将两个值设置为相同的百分比，变成实心饼图
                    center: ['50%', '50%'],
                    avoidLabelOverlap: false,
                    label: {
                        show: true,
                        position: 'outside',
                        formatter: '{b}: {c} 人',
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
                    data: pieData,
                }],
            };

            // 设置实心饼图的选项
            titleChart.setOption(option);
        },

        initProjectChart(echarts) {
            // 获取项目列表图表容器
            const projectChart = echarts.init(this.$refs.projectChart);
            // 将数据转换为 ECharts 柱状图所需的格式
            const barData = Object.entries(this.projectListData).map(([category, count]) => ({
                value: count,
                name: category,
            }));
            const option = {
                title: {
                    text: '项目数量', // 设置标题文本
                    left: 'center', // 标题居中显示
                    textStyle: {
                        color: '#333', // 标题颜色
                        fontSize: 16, // 标题字体大小
                    },
                },
                xAxis: {
                    type: 'category',
                    data: Object.keys(this.projectListData), // 使用项目类别作为横坐标数据
                    axisLabel: {
                        interval: 0,
                        rotate: -45, // 将横坐标文字逆时针旋转45度，适应柱状图显示
                    },
                },
                yAxis: {
                    type: 'value',
                },
                tooltip: {
                    trigger: 'axis',
                    formatter: '{b}: {c} 个',
                },
                series: [{
                    type: 'bar',
                    data: barData,
                    itemStyle: {
                        color: getRandomColor(), // 可以使用 getRandomColor 方法为每个柱设置不同的颜色
                    },
                }],
            };
            projectChart.setOption(option);
        },
        initChart(echarts) {
            // 获取知识产权图表容器
            const resultChart = echarts.init(this.$refs.resultChart);
            // 将数据转换为 ECharts 柱状图所需的格式
            const barData = this.typeData.data.map((count, index) => ({
                value: count,
                name: this.typeData.categories[index],
            }));
            // 配置柱状图选项
            const option = {
                title: {
                    text: '知识产权', // 设置标题文本
                    left: 'center', // 标题居中显示
                    textStyle: {
                        color: '#333', // 标题颜色
                        fontSize: 16, // 标题字体大小
                    },
                },
                xAxis: {
                    type: 'category',
                    data: this.typeData.categories, // 使用知识产权类别作为横坐标数据
                    axisLabel: {
                        interval: 0,
                        rotate: -45, // 将横坐标文字逆时针旋转45度，适应柱状图显示
                    },
                },
                yAxis: {
                    type: 'value',
                },
                tooltip: {
                    trigger: 'axis',
                    formatter: '{b}: {c} 个',
                },
                series: [{
                    type: 'bar',
                    data: barData,
                    itemStyle: {
                        color: getRandomColor(), // 可以使用 getRandomColor 方法为每个柱设置不同的颜色
                    },
                }],
            };
            // 设置柱状图的选项
            resultChart.setOption(option);
        },

    },
};
function getRandomColor() {
    const letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}
</script>

<style scoped lang="scss">
.notice-content::v-deep img {
    max-width: 100%;
    height: auto;
    display: block;
    margin: 0 auto;
}

.home {
    padding: 20px;
}

.el-card {
    border-radius: 10px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

$h1: rgba(45, 45, 45, 1);
$blue: #98b5cc;
$yellow: #ffcc00;
$outline: rgba(#fff, .4);
$shadow: rgba($yellow, .5);

#curtain {
    background: linear-gradient(45deg, rgb(182, 182, 182) 9%, rgb(56, 56, 56) 100%);
    width: 100%;
    height: 60px;
    border-radius: 30px;
}

h1 {
    font-family: '阿里妈妈东方大楷 Regular', sans-serif;
    font-size: 50px;
    text-align: center;
    line-height: 1;
    margin: 0;
    top: 5.3%;
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

    0%,
    19.999%,
    22%,
    62.999%,
    64%,
    64.999%,
    70%,
    100% {
        opacity: .99;
        text-shadow: -1px -1px 0 $outline, 1px -1px 0 $outline,
            -1px 1px 0 $outline, 1px 1px 0 $outline,
            0 -2px 8px, 0 0 2px, 0 0 5px #ff7e00,
            0 0 5px #ff4444, 0 0 2px #ff7e00, 0 2px 3px #000;
    }

    20%,
    21.999%,
    63%,
    63.999%,
    65%,
    69.999% {
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

