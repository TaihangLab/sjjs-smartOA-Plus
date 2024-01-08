<template>
    <el-card header="专项经费详情" shadow="hover">
        <el-form :model="form" ref="form" label-position="left">

            <el-divider><i class="el-icon-caret-right"></i>直接经费<i class="el-icon-caret-left"></i></el-divider>
            <el-collapse v-model="activeNames">

                <el-collapse-item name="1">
                    <template #title><i :class="activeClass">设备费</i>
<!--                        <el-form-item @click.native.stop="" label-width="125px" label="设备费">-->
<!--                            <el-input @click.native.stop="" v-model.number="$props.form.sbf_zj" type="number"></el-input>-->
<!--                        </el-form-item>-->
                    </template>
                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="设备费">
                                <el-input v-model.number="$props.form.sbf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="购置设备费">
                                <el-input v-model.number="$props.form.gzsbf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="试制设备费">
                                <el-input v-model.number="$props.form.szsbf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="设备改造与租赁费">
                                <el-input v-model.number="$props.form.sbgzyzlf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-collapse-item>

                <el-collapse-item name="2">
                    <template #title><i :class="activeClass">材料费</i></template>
                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="材料费">
                                <el-input v-model.number="$props.form.clf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-collapse-item>

                <el-collapse-item name="3">
                    <template #title><i :class="activeClass">科研活动费</i></template>

                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="科研活动费">
                                <el-input v-model.number="$props.form.kyhdf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>

                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="资料费">
                                <el-input v-model.number="$props.form.zlf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="测试化验加工费">
                                <el-input v-model.number="$props.form.cshyjgf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="数据样本采集费">
                                <el-input v-model.number="$props.form.sjybcjf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="印刷出版费">
                                <el-input v-model.number="$props.form.yscbf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="知识产权事务费">
                                <el-input v-model.number="$props.form.zscqswf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="办公费">
                                <el-input v-model.number="$props.form.bgf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="燃料动力费">
                                <el-input v-model.number="$props.form.rldlf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="车辆使用费">
                                <el-input v-model.number="$props.form.clsyf_zj"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-collapse-item>

                <el-collapse-item name="4">
                    <template #title><i :class="activeClass">科研服务费</i></template>
                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="科研服务费">
                                <el-input v-model.number="$props.form.kyfwf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>

                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="专家咨询费">
                                <el-input v-model.number="$props.form.zjzxf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="差旅费">
                                <el-input v-model.number="$props.form.chlf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="会议会务费">
                                <el-input v-model.number="$props.form.hyhwf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="国际合作交流费">
                                <el-input v-model.number="$props.form.gjhzjlf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="国内协作费">
                                <el-input v-model.number="$props.form.gnxzf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-collapse-item>

                <el-collapse-item name="5">
                    <template #title><i :class="activeClass">人员劳务补助费</i></template>
                    <el-row>
                        <el-col :span="8">
                            <el-form-item label-width="130px" label="人员劳务补助费">
                                <el-input v-model.number="$props.form.rylwbzf_zj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-collapse-item>
            </el-collapse>


            <el-divider><i class="el-icon-caret-right"></i>间接经费<i class="el-icon-caret-left"></i></el-divider>
            <el-collapse v-model="activeNames2">
                <el-collapse-item name="1">
                    <template #title><i :class="activeClass">设备费</i>
                    </template>
                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="设备费">
                                <el-input v-model.number="$props.form.sbf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="购置设备费">
                                <el-input v-model.number="$props.form.gzsbf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="试制设备费">
                                <el-input v-model.number="$props.form.szsbf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="设备改造与租赁费">
                                <el-input v-model.number="$props.form.sbgzyzlf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-collapse-item>

                <el-collapse-item name="2">
                    <template #title><i :class="activeClass">材料费</i></template>
                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="材料费">
                                <el-input v-model.number="$props.form.clf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-collapse-item>

                <el-collapse-item name="3">
                    <template #title><i :class="activeClass">科研活动费</i></template>

                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="科研活动费">
                                <el-input v-model.number="$props.form.kyhdf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>

                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="资料费">
                                <el-input v-model.number="$props.form.zlf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="测试化验加工费">
                                <el-input v-model.number="$props.form.cshyjgf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="数据样本采集费">
                                <el-input v-model.number="$props.form.sjybcjf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="印刷出版费">
                                <el-input v-model.number="$props.form.yscbf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="知识产权事务费">
                                <el-input v-model.number="$props.form.zscqswf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="办公费">
                                <el-input v-model.number="$props.form.bgf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="燃料动力费">
                                <el-input v-model.number="$props.form.rldlf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="车辆使用费">
                                <el-input v-model.number="$props.form.clsyf_jj"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-collapse-item>

                <el-collapse-item name="4">
                    <template #title><i :class="activeClass">科研服务费</i></template>
                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="科研服务费">
                                <el-input v-model.number="$props.form.kyfwf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>

                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="专家咨询费">
                                <el-input v-model.number="$props.form.zjzxf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="差旅费">
                                <el-input v-model.number="$props.form.chlf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="会议会务费">
                                <el-input v-model.number="$props.form.hyhwf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="10">
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="国际合作交流费">
                                <el-input v-model.number="$props.form.gjhzjlf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label-width="125px" label="国内协作费">
                                <el-input v-model.number="$props.form.gnxzf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-collapse-item>

                <el-collapse-item name="5">
                    <template #title><i :class="activeClass">人员劳务补助费</i></template>
                    <el-row>
                        <el-col :span="8">
                            <el-form-item label-width="130px" label="人员劳务补助费">
                                <el-input v-model.number="$props.form.rylwbzf_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-collapse-item>

                <el-collapse-item name="6">
                    <template #title><i :class="activeClass">绩效支出</i></template>
                    <el-row>
                        <el-col :span="8">
                            <el-form-item label-width="130px" label="绩效支出">
                                <el-input v-model.number="$props.form.jxzc_jj" type="number"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-collapse-item>
            </el-collapse>

        </el-form>
    </el-card>

</template>


<script setup>
import {addFunds} from "@/views/project/components/utils";
import {getCurrentInstance, ref, watchEffect} from "vue";
import {Message} from "element-ui";

const { proxy } = getCurrentInstance();
const props = defineProps({
    form: Object,
});
defineExpose({reset});


// 折叠面板的初始化激活项
const activeNames = ref([]);
const activeNames2 = ref([]);
const activeClass= "el-icon-edit-outline";

const showError = ()=>Message({
    showClose: true,
    message: '错了哦，请检查',
    type: 'error',
});

watchEffect(()=>{
    if (addFunds(props.form.gzsbf_zj + props.form.szsbf_zj + props.form.sbgzyzlf_zj) > props.form.sbf_zj) {
        showError();
    }
});

function reset() {
    for (let key in props.form) {
        props.form[key] = undefined;
    }

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
