<template>
    <el-card header="专项经费详情" shadow="hover">
        <el-form :model="form" ref="form" label-position="left">

            <el-divider><i class="el-icon-caret-right"></i>直接经费<i class="el-icon-caret-left"></i></el-divider>
            <el-collapse v-model="activeNames">
                <el-collapse-item name="1">
                    <template #title><i :class="activeClass">设备费</i></template>
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

                <el-collapse-item name="2">
                    <template #title><i :class="activeClass">材料费</i></template>
                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="材料费">
                                <el-input v-model="$props.form.a" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-collapse-item>

                <el-collapse-item name="3">
                    <template #title><i :class="activeClass">科研活动费</i></template>
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
                </el-collapse-item>

                <el-collapse-item name="4">
                    <template #title><i :class="activeClass">科研服务费</i></template>
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
                </el-collapse-item>

                <el-collapse-item name="5">
                    <template #title><i :class="activeClass">人员和劳务补助费</i></template>
                    <el-row>
                        <el-col :span="8">
                            <el-form-item label-width="130px" label="人员和劳务补助费">
                                <el-input v-model="$props.form.a" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-collapse-item>
            </el-collapse>


            <el-divider><i class="el-icon-caret-right"></i>间接费用<i class="el-icon-caret-left"></i></el-divider>
            <el-collapse v-model="activeNames2">
                <el-collapse-item name="1">
                    <template #title><i :class="activeClass">设备费</i></template>
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

                <el-collapse-item name="2">
                    <template #title><i :class="activeClass">材料费</i></template>
                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="材料费">
                                <el-input v-model="$props.form.a" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-collapse-item>

                <el-collapse-item name="3">
                    <template #title><i :class="activeClass">科研活动费</i></template>
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
                </el-collapse-item>

                <el-collapse-item name="4">
                    <template #title><i :class="activeClass">科研服务费</i></template>
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
                </el-collapse-item>

                <el-collapse-item name="5">
                    <template #title><i :class="activeClass">人员和劳务补助费</i></template>
                    <el-row>
                        <el-col :span="8">
                            <el-form-item label-width="130px" label="人员和劳务补助费">
                                <el-input v-model="$props.form.a" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-collapse-item>

                <el-collapse-item name="6">
                    <template #title><i :class="activeClass">绩效支出</i></template>
                    <el-row>
                        <el-col :span="8">
                            <el-form-item label-width="130px" label="绩效支出">
                                <el-input v-model="$props.form.a" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-collapse-item>
            </el-collapse>

            <el-cascader
                v-model="value"
                :options="options"
                :props="{ expandTrigger: 'hover' }"
                @change="handleChange"></el-cascader>
        </el-form>
    </el-card>

</template>


<script>
export default {
    props: ['form'],
    data() {
        return {
            activeNames: [],
            activeNames2: [],
            activeClass: "el-icon-edit-outline",
            options:[
                {value:'',label:'设备费',children:[
                        {value:'1', label: '购置设备费'},
                        {value:'2', label: '试制设备费'},
                        {value:'3', label: '设备改造与租赁费'},
                    ]},
                {value:'',label:'材料费',children:[
                        {value:'4', label: '资料费'},
                        {value:'5', label: '测试化验加工费'},
                        {value:'6', label: '数据样本采集费'},
                        {value:'7', label: '印刷出版费'},
                        {value:'8', label: '知识产权事务费'},
                        {value:'9', label: '办公费'},
                        {value:'3211', label: '燃料动力费'},
                        {value:'321', label: '车辆使用费'},
                    ]},
                {value:'',label:'科研活动费'},
                {value:'',label:'科研服务费'},
                {value:'',label:'人员和劳务补助费'},
                {value:'',label:'绩效支出'},
            ]
        }
    },
    mounted() {
    },
    watch: {}

}
</script>

<style scoped>

.el-divider__text {
    color: #ff6200;
    font-size: 0.9rem;
}

:deep(.el-collapse-item__header) {
    color: #409EFF;
    font-size: 0.95em;
    border-radius: 1%;
    margin-bottom: 10px;
}
</style>
