<template>
    <div class="home">
        <!-- 通知公告 -->
        <el-row>
            <el-col :span="24">
                <el-card>
                    <h3 slot="header">通知公告</h3>
                    <el-table :data="noticeData" style="width: 100%" :border="false" class="custom-table">
                        <el-table-column label="内容" prop="content">
                            <template slot-scope="scope">
                                {{ scope.row.content }}
                            </template>
                        </el-table-column>
                        <el-table-column label="类型" prop="type" width="150">
                            <template slot-scope="scope">
                                {{ scope.row.type }}
                            </template>
                        </el-table-column>
                        <el-table-column label="时间" prop="timestamp" width="180">
                            <template slot-scope="scope">
                                {{ scope.row.timestamp }}
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
    </div>
</template>
  
<script>
import echarts from 'echarts';

export default {
    data() {
        return {
            noticeData: [
                { id: 1, timestamp: '2022-01-10 09:00:00', type: '紧急', content: '重要通知：项目启动会将于下周举行。' },
                { id: 2, timestamp: '2022-01-12 14:30:00', type: '提醒', content: '请大家注意：本周五例行维护，系统将暂时不可用。' },
                { id: 3, timestamp: '2022-01-15 11:45:00', type: '进展', content: '项目进展：项目A已完成第一阶段任务，进入第二阶段。' },
                // 添加更多通知公告数据...
            ],
        };
    },
    mounted() {
        import('echarts').then((echarts) => {
            this.initChart(echarts);
        });
    },
    methods: {
        initChart(echarts) {
            // 假设这是更多的成果统计数据
            const resultData = [
                { value: 335, name: '完成任务A' },
                { value: 310, name: '未完成任务B' },
                { value: 234, name: '已完成任务C' },
                { value: 135, name: '进行中任务D' },
                { value: 1548, name: '待处理任务E' },
                // 添加更多数据项...
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
                        radius: ['0%', '70%'], // 设置为内切圆，呈现实心效果
                        center: ['50%', '50%'], // 居中显示
                        avoidLabelOverlap: false,
                        label: {
                            show: true,
                            position: 'outside', // 将标签显示在饼图外部
                            formatter: '{b}: {c} ({d}%)', // 显示任务名称和百分比
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
    /* 去掉表格的下边框线 */
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