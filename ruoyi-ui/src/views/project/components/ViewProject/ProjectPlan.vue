<template>
    <div v-if="$props.projectplan && $props.projectplan.length > 0">
        <div style="margin-top: 10px;"></div>
        <div v-for="(plan, index) in $props.projectplan" :key="index">
            <el-descriptions class="margin-top" :column="2" border>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 30%">
                    <template slot="label">开始时间</template>
                    {{ plan.stageStartDate }}
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 30%">
                    <template slot="label">结束时间</template>
                    {{ plan.stageEndDate }}
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" :span="3">
                    <template slot="label">任务详情</template>
                    {{ plan.stageTask }}
                </el-descriptions-item>
            </el-descriptions>
            <div style="margin-bottom: 20px;">
                <hr style="margin: 20px 0; border: 1px solid #E4E7ED;">
            </div>
        </div>
    </div>
    <div v-else class="no-data-message" style="color: #909399; font-size: 14px; text-align: center;">
        暂无数据
    </div>
</template>

<script>
export default {
    props: {
        projectplan: {
            type: Array,
            required: true,
        },
    },
    data() {
        return {
            form: {
                name: '',
            },
            contentStyle: {
                'text-align': 'center',
                'width': '60%',
            },
        };
    },
}
</script>
