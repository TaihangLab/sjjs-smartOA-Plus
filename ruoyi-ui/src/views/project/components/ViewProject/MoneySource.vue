<template>
    <div>
        <div style="margin-top: 10px;"></div>
        <!-- 你的专项经费详细信息 -->
            <!-- 这里放置专项经费的详细信息 -->
        <el-descriptions class="margin-top" :column="3"  border>
            <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                <template slot="label">
                    {{"\xa0\xa0"}}(一) {{"\xa0\xa0"}} 申请从专项经费获得的资助
                </template>
            </el-descriptions-item>
            <el-descriptions-item labelStyle="font-weight: 550;" :span="3">
                <template slot="label">
                    {{"\xa0\xa0"}}(二) {{"\xa0\xa0"}} 自筹经费来源
                </template>
            </el-descriptions-item>
            <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                <template slot="label">
                    其他财政拨款
                </template>
            </el-descriptions-item>
            <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                <template slot="label">
                    单位自有货币资金
                </template>
            </el-descriptions-item>
            <el-descriptions-item labelStyle="width: 15%; text-align: center; width: auto;" contentStyle="width: 15%">
                <template slot="label">
                    其他资金
                </template>
            </el-descriptions-item>
        </el-descriptions>
    </div>
</template>
<script>
</script>
