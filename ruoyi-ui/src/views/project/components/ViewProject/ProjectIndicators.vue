<template>
    <div v-if="$props.projectTarget && $props.projectTarget.length > 0">
        <div style="margin-top: 10px;"></div>
        <div v-for="(plan, index) in $props.projectTarget" :key="index">
            <el-descriptions class="margin-top" :column="2" border>
                <el-descriptions-item labelStyle="width: 20%; text-align: center; width: auto;" contentStyle="width: 80%" :span="3">
                    <template slot="label">项目指标</template>
                    {{ plan.targetName }}
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 20%; text-align: center; width: auto;" contentStyle="width: 80%" :span="3">
                    <template slot="label">中期指标值/状态</template>
                    {{ plan.midtermTarget }}
                </el-descriptions-item>
                <el-descriptions-item labelStyle="width: 20%; text-align: center; width: auto;" contentStyle="width: 80%" :span="3">
                    <template slot="label">完成时指标值/状态</template>
                    {{ plan.endTarget }}
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
        projectTarget: {
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
