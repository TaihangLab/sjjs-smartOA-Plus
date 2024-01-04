<template>
    <div class="home">
        <!-- 通知公告 -->
        <el-row>
            <el-col :span="24">
                <el-card>
                    <h3 slot="header">通知公告</h3>
                    <!-- 在这里添加通知公告的内容 -->
                    <p>最新的通知公告在这里...</p>
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
            name: '成果统计',
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
</style>
  