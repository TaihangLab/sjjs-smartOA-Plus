<template>
    <div class="app-container home">
        <div id="curtain">
            <h1 data-heading="数">数据技术</h1>
        </div>

        <div id="main">

        </div>


    </div>
</template>

<script setup>
import * as echarts from 'echarts';
import {onMounted, onUnmounted} from "vue";

console.log()
let chartIns;
onMounted(()=>{
    chartIns = initChart();
})

onUnmounted(()=>{
    chartIns.dispose();
})

function initChart() {
    let myChart = echarts.init(document.getElementById('main'), null, {width:600, height:400});
    let option;

    option = {
        title: {
            text: 'Stacked Area Chart'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                label: {
                    backgroundColor: '#6a7985'
                }
            }
        },
        legend: {
            data: ['Email', 'Union Ads', 'Video Ads', 'Direct', 'Search Engine'],
            top: "6%",

        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: 'Email',
                type: 'line',
                stack: 'Total',
                areaStyle: {},
                emphasis: {
                    focus: 'series'
                },
                data: [120, 132, 101, 134, 90, 230, 210]
            },
            {
                name: 'Union Ads',
                type: 'line',
                stack: 'Total',
                areaStyle: {},
                emphasis: {
                    focus: 'series'
                },
                data: [220, 182, 191, 234, 290, 330, 310]
            },
            {
                name: 'Video Ads',
                type: 'line',
                stack: 'Total',
                areaStyle: {},
                emphasis: {
                    focus: 'series'
                },
                data: [150, 232, 201, 154, 190, 330, 410]
            },
            {
                name: 'Direct',
                type: 'line',
                stack: 'Total',
                areaStyle: {},
                emphasis: {
                    focus: 'series'
                },
                data: [320, 332, 301, 334, 390, 330, 320]
            },
            {
                name: 'Search Engine',
                type: 'line',
                stack: 'Total',
                label: {
                    show: true,
                    position: 'top'
                },
                areaStyle: {},
                emphasis: {
                    focus: 'series'
                },
                data: [820, 932, 901, 934, 1290, 1330, 1320]
            }
        ]
    };
    option && myChart.setOption(option);
    return myChart;
}

</script>

<style scoped lang="scss">

$h1:  rgba(45,45,45,1);
$blue: #98b5cc;
$yellow: #ffcc00;
$outline: rgba(#fff, .4);
$shadow: rgba($yellow, .5);
#curtain {
    background: linear-gradient(45deg, rgb(182, 182, 182) 9%, rgb(56, 56, 56) 100%);
    width: 100%;
    height: 15vh;
    border-radius: 30px;
}

h1 {
    font-family: '阿里妈妈东方大楷 Regular', sans-serif;
    font-size: 5vw;
    text-align: center;
    line-height: 1;
    margin: 0;
    top: 12%;
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
        left: 0%;
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

