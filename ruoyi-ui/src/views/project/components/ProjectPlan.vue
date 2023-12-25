<template>
    <el-card header="项目计划" shadow="hover">
        <el-form :model="form" ref="form" label-position="left">
            <el-row
                @mouseover.native="$set(isButtonShowList, index, true)"
                @mouseleave.native="$set(isButtonShowList, index, false)"
                v-for="(item, index) in props.form.items"
                :key="index"
                justify="center"
                type="flex">

                <el-col :span="1" style="text-align: center;">
                    <el-button icon="el-icon-circle-plus" circle type="success" plain @click="add"
                               v-show="index===form.items.length-1 && isButtonShowList[index]"></el-button>
                </el-col>

                <el-col :span="11">
                    <el-form-item label-width="80px" label="时间范围" prop="id">
                        <el-date-picker
                            v-model="item.date"
                            type="monthrange"
                            align="right"
                            unlink-panels
                            range-separator="至"
                            start-placeholder="开始日期"
                            end-placeholder="结束日期"
                            value-format="yyyy-MM"
                            :picker-options="pickerOptions">
                        </el-date-picker>
                    </el-form-item>
                </el-col>

                <el-col :span="11" :offset="1">
                    <el-form-item label-width="80px" label="任务计划" prop="role">
                        <el-input
                            @input="input"
                            type="textarea"
                            :autosize="{ minRows: 1, maxRows: 4}"
                            maxlength="500"
                            show-word-limit
                            v-model="item.task">
                        </el-input>
                    </el-form-item>

                </el-col>
                <el-col :span="1" style="text-align: center;">
                    <el-button icon="el-icon-remove" circle type="danger" plain @click="remove(index)"
                               v-show="form.items.length!==1&&isButtonShowList[index]"></el-button>

                </el-col>
            </el-row>
        </el-form>


    </el-card>
</template>

<script setup>

import {getCurrentInstance, reactive, ref} from "vue";

const {proxy} = getCurrentInstance();
const props = defineProps(["form"]);
defineExpose({
    reset,
})


props.form.items = [{date: null, task: ''}];
const isButtonShowList = ref([false]);

function add() {
    props.form.items.push({
        date: undefined, task: undefined
    });
    isButtonShowList.value.push(false);
    // $forceUpdate();
}

function remove(index) {
    props.form.items.splice(index, 1);
    isButtonShowList.value.splice(index, 1);
}

function reset() {
    props.form.items = [{date: undefined, task: undefined}];
    proxy.$forceUpdate();
}

 function input() {
    proxy.$forceUpdate();
 }

// 日期选择快捷选项
const pickerOptions = {
    shortcuts: [{
        text: '本月',
        onClick(picker) {
            picker.$emit('pick', [new Date(), new Date()]);
        }
    }, {
        text: '今年至今',
        onClick(picker) {
            const end = new Date();
            const start = new Date(new Date().getFullYear(), 0);
            picker.$emit('pick', [start, end]);
        }
    }, {
        text: '最近六个月',
        onClick(picker) {
            const end = new Date();
            const start = new Date();
            start.setMonth(start.getMonth() - 6);
            picker.$emit('pick', [start, end]);
        }
    }]
}

</script>
<style scoped>
.el-button {
    border: none;
    padding: 0;
    font-size: 2rem;
}

:deep(.el-icon-circle-plus) {

}
</style>

