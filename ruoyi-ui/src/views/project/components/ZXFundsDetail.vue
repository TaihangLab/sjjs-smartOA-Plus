<template>
    <el-card header="经费详情" shadow="hover">
        <el-form :model="form" ref="form" label-position="left">
            <el-collapse v-model="activeNames">
            <el-collapse-item name="1">
                <template #title>设备费</template>
                <el-row :gutter="10">
                    <el-col :span="8">
                        <el-form-item label-width="125px" label="购置设备费">
                            <el-input v-model="$props.form.a" type="number" :value="0"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label-width="125px" label="试制设备费">
                            <el-input v-model="$props.form.b" type="number"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label-width="125px" label="设备改造与租赁费">
                            <el-input v-model="$props.form.c" type="number"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-collapse-item>
            <br>


            <el-divider content-position="left">
                材料费：
                <el-tag effect="plain">12,123</el-tag>
                元
            </el-divider>
            <el-form-item label-width="125px" label="材料费">
                <el-input v-model="$props.form.a" type="number"></el-input>
            </el-form-item>
            <br>

            <el-divider content-position="left">
                科研活动费：
                <el-tag effect="plain">12,123</el-tag>
                元
            </el-divider>
            <el-row :gutter="10">
                <el-col :span="8">
                    <el-form-item label-width="125px" label="资料费">
                        <el-input v-model="$props.form.a" type="number"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="125px" label="测试化验加工费">
                        <el-input v-model="$props.form.b" type="number"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="125px" label="数据样本采集费">
                        <el-input v-model="$props.form.c" type="number"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row :gutter="10">
                <el-col :span="8">
                    <el-form-item label-width="125px" label="印刷出版费">
                        <el-input v-model="$props.form.a" type="number"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="125px" label="知识产权事务费">
                        <el-input v-model="$props.form.b" type="number"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="125px" label="办公费">
                        <el-input v-model="$props.form.c" type="number"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row :gutter="10">
                <el-col :span="8">
                    <el-form-item label-width="125px" label="燃料动力费">
                        <el-input v-model="$props.form.a" type="number"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="125px" label="车辆使用费">
                        <el-input v-model="$props.form.b"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <br>

            <el-divider content-position="left">
                科研服务费：
                <el-tag effect="plain">12,123</el-tag>
                元
            </el-divider>
            <el-row :gutter="10">
                <el-col :span="8">
                    <el-form-item label-width="125px" label="专家咨询费">
                        <el-input v-model="$props.form.a" type="number"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="125px" label="差旅费">
                        <el-input v-model="$props.form.b" type="number"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="125px" label="会议会务费">
                        <el-input v-model="$props.form.c" type="number"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row :gutter="10">
                <el-col :span="8">
                    <el-form-item label-width="125px" label="国际合作交流费">
                        <el-input v-model="$props.form.a" type="number"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="125px" label="国内协作费">
                        <el-input v-model="$props.form.b" type="number"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <br>

            <el-divider content-position="left">
                人员和劳务补助费：
                <el-tag effect="plain">12,123</el-tag>
                元
            </el-divider>
            <el-row>
                <el-col :span="8">
                    <el-form-item label-width="130px" label="人员和劳务补助费">
                        <el-input v-model="$props.form.a" type="number"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            <br>

            <el-divider content-position="left">
                间接费用：
                <el-tag effect="plain">12,123</el-tag>
                元
            </el-divider>
            <el-row :gutter="10">
                <el-col :span="8">
                    <el-form-item label-width="125px" label="间接经费">
                        <el-input v-model="$props.form.a" type="number"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="125px" label="绩效支出">
                        <el-input v-model="$props.form.b" type="number"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>
            </el-collapse>
        </el-form>
    </el-card>

</template>


<script>
export default {
    props: ['form'],
    data() {
        return {
            activeNames:["1",]
        }
    },
    mounted() {
    }

}
</script>

<style scoped>
:deep(.el-collapse-item__header) {
    color: #409EFF;
    font-size: 1.15em;
}
</style>
