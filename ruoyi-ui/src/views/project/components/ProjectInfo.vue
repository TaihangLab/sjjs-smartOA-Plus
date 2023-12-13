<template>
    <el-card header="项目信息" shadow="hover">
        <el-form :model="form" ref="form" label-position="left">
            <el-row :gutter="20">
                <el-col :span="12">
                    <el-form-item label-width="100px" label="项目名称" prop="name" :rules="[{ required: true, message: '请输入项目名称', trigger: 'blur' }]" >
                        <el-input v-model="form.name"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label-width="100px" label="项目负责人" prop="principal"  :rules="[{ required: true, message: '请输入项目负责人', trigger: 'blur' }]">
                        <el-input v-model="form.principal"></el-input>
                    </el-form-item>
                </el-col>

            </el-row>

            <el-form-item label-width="100px" label="立项时间" prop="startTime"  :rules="[{ required: true, message: '请输入立项时间', trigger: 'blur' }]">
                <el-date-picker
                    placeholder="立项时间"
                    v-model="form.startTime"
                    type="date"
                    value-format="yyyy-MM-dd">
                </el-date-picker>
            </el-form-item>

            <el-form-item label-width="100px" label="项目周期" prop="time"  :rules="[{ required: true, message: '请输入项目周期', trigger: 'blur' }]">
                <el-date-picker
                    v-model="form.time"
                    type="daterange"
                    value-format="yyyy-MM-dd"
                    range-separator="至"
                    start-placeholder="开始日期"
                    end-placeholder="结束日期">
                </el-date-picker>
            </el-form-item>

            <el-form-item label-width="100px" label="项目类型" prop="type"  :rules="[{ required: true, message: '请输入项目类型', trigger: 'change' }]">
                <el-select v-model="form.type" clearable placeholder="请选择">
                    <el-option
                        v-for="(item, index) in projectTypes"
                        :key="index"
                        :label="item.name"
                        :value="item.value">
                    </el-option>
                </el-select>
            </el-form-item>

        </el-form>
    </el-card>

</template>


<script>
export default {
    props: ['form'],
    data() {
        return {
            projectTypes: [{name:'国家', value:0}, {name:'省部', value: 1}, {name:'自主', value: 2}],
        }
    },


}
</script>
