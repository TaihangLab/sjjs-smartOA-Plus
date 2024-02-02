<template>
    <div>
        <div style="margin-top: 10px;"></div>
        <el-collapse>
            <el-collapse-item name="1">
                <template slot="title">
                    <span>项目推进情况</span>
                </template>
                <div style="margin-top: 10px;"></div>
                <el-descriptions class="margin-top" title="" :column="2" :labelStyle="{ width: '20%' }"
                                 :contentStyle="{ width: '30%' }" border>
                    <el-descriptions-item label="推进情况" :span="1">{{ this.projectProgressStatus[this.$props.projectDetails.projectInfoVO.projectProgressStatus] }}
                    </el-descriptions-item>
                    <el-descriptions-item label="" :span="1">{{ }}
                    </el-descriptions-item>
                    <el-descriptions-item label="完成进度" :span="2">{{ this.$props.projectDetails.projectInfoVO.completionProgress }}
                    </el-descriptions-item>
                </el-descriptions>
            </el-collapse-item>

            <el-collapse-item name="2">
                <template slot="title">
                    <span>项目经费情况</span>
                    <span style="font-size: 12px; color: #F56C6C;">（单位：万元）</span>
                </template>
                <div style="margin-top: 10px;"></div>
                <el-descriptions class="margin-top" title="" :column="2" :labelStyle="{ width: '20%' }"
                                 :contentStyle="{ width: '30%' }" border>
                    <el-descriptions-item label="经费总额" :span="2">{{ this.$props.projectDetails.projectFundsVO.totalFundsAll }}
                    </el-descriptions-item>
                    <el-descriptions-item label="专项到款总额" :span="1">{{ this.$props.projectDetails.projectFundsVO.totalFundsZxDk }}
                    </el-descriptions-item>
                    <el-descriptions-item label="专项经费总额" :span="1">{{ this.$props.projectDetails.projectFundsVO.totalFundsZx }}
                    </el-descriptions-item>
                    <el-descriptions-item label="已完成自筹投资" :span="1">{{ this.$props.projectDetails.projectFundsVO.zctzDone }}
                    </el-descriptions-item>
                    <el-descriptions-item label="已完成专项投资" :span="1">{{ this.$props.projectDetails.projectFundsVO.zxtzDone }}
                    </el-descriptions-item>
                    <el-descriptions-item label="自筹经费公司配套" :span="1">{{ this.$props.projectDetails.projectFundsVO.zcGspt }}
                    </el-descriptions-item>
                    <el-descriptions-item label="专项经费公司留存(计划)" :span="1">{{ this.$props.projectDetails.projectFundsVO.zxGslc }}
                    </el-descriptions-item>
                </el-descriptions>
            </el-collapse-item>

            <el-collapse-item name="3">
                <template slot="title">
                    <span>项目成果情况</span>
                </template>
                <div style="margin-top: 10px;"></div>
                <el-descriptions class="margin-top" title="" :column="2" :labelStyle="{ width: '20%' }"
                                 :contentStyle="{ width: '30%' }" border>
                    <el-descriptions-item label="获奖情况（项）" :span="1">{{ this.$props.projectDetails.projectInfoVO.awardDetails }}
                    </el-descriptions-item>
                    <el-descriptions-item label="论文情况（项）" :span="1">{{ this.$props.projectDetails.projectInfoVO.publicationDetails }}
                    </el-descriptions-item>
                    <el-descriptions-item label="专利情况" :span="1">{{ this.$props.projectDetails.projectInfoVO.patentDetails }}
                    </el-descriptions-item>
                    <el-descriptions-item label="软著情况" :span="1">{{ this.$props.projectDetails.projectInfoVO.softwareCopyrightDetails }}
                    </el-descriptions-item>
                    <el-descriptions-item label="标准情况" :span="1">{{ this.$props.projectDetails.projectInfoVO.standardDetails }}
                    </el-descriptions-item>
                </el-descriptions>
            </el-collapse-item>
        </el-collapse>
    </div>
</template>
<script>
export default {
    props: {
        projectDetails: {
            type: Object,
            required: true,
        },
    },
    data(){
        return{
            projectProgressStatus: {
                0: '正在需求申报',
                1: '已完成需求申报',
                2: '正在项目申报',
                3: '已完成项目申报',
                4: '已签订任务书并推进中',
                5: '已完成中期评审',
                6: '已完成验收',
                7: '未通过评审',
            },
        }
    }
}
</script>
