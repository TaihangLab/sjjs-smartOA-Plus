<template>
    <el-card header="项目信息" shadow="hover">
        <el-form :model="form" ref="form" label-position="left">
            <el-row :gutter="20" type="flex" justify="left">
                <el-col :span="8">
                    <el-form-item label-width="120px" label="项目牵头单位" prop="leadingUnit"
                                  :rules="[{ required: true, message: '请输入 项目牵头单位', trigger: 'blur' }]">
                        <el-input v-model="form.leadingUnit"></el-input>
                    </el-form-item>
                </el-col>

                <el-col :span="8">
                    <el-form-item label-width="120px" label="项目名称" prop="name"
                                  :rules="[{ required: true, message: '请输入 项目名称', trigger: 'blur' }]">
                        <el-input v-model="form.name"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="120px" label="项目负责人" prop="principal"
                                  :rules="[{ required: true, message: '请输入 项目负责人', trigger: 'blur' }]">
                        <el-input v-model="form.principal"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>


            <el-row :gutter="20" type="flex" justify="left">

                <el-col :span="8">
                    <el-form-item label-width="120px" label="立项时间" prop="startTime"
                                  :rules="[{ required: true, message: '请输入 立项时间', trigger: 'blur' }]">
                        <el-date-picker
                            placeholder="立项时间"
                            v-model="form.startTime"
                            type="date"
                            value-format="yyyy-MM-dd">
                        </el-date-picker>
                    </el-form-item>
                </el-col>

                <el-col :span="8">
                    <el-form-item label-width="120px" label="验收时间" prop="endTime"
                                  :rules="[{ required: true, message: '请选择 验收时间', trigger: 'blur' }]">
                        <el-date-picker
                            placeholder="验收时间"
                            v-model="form.endTime"
                            type="date"
                            value-format="yyyy-MM-dd">
                        </el-date-picker>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="120px" label="项目级别" prop="level"
                                  :rules="[{ required: true, message: '请输 入项目级别', trigger: 'change' }]">
                        <el-select v-model="form.level" clearable placeholder="请选择">
                            <el-option
                                v-for="(item, index) in projectLevels"
                                :key="index"
                                :label="item.name"
                                :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row :gutter="20" type="flex" justify="left">
                <el-col :span="8">
                    <el-form-item label-width="120px" label="任务书编号" prop="taskNumber"
                                  :rules="[{ required: true, message: '请输入 任务书编号', trigger: 'blur' }]">
                        <el-input v-model="form.taskNumber"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="120px" label="负责课题" prop="subjectName"
                                  :rules="[{ required: true, message: '请输入 负责课题名称', trigger: 'blur' }]">
                        <el-input v-model="form.subjectName"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="120px" label="推进情况" prop="process"
                                  :rules="[{ required: true, message: '请输入 推进情况', trigger: 'blur' }]">
                        <el-input v-model="form.process"></el-input>
                    </el-form-item>
                </el-col>

            </el-row>

            <el-row :gutter="20" type="flex" justify="left">
                <el-col :span="8">
                    <el-form-item label-width="120px" label="合作单位" prop="hasCoopUnit"
                                  :rules="[{ required: true, message: '请选择 合作单位', trigger: 'change' }]">
                        <el-radio-group v-model="form.hasCoopUnit">
                            <el-radio :label="1">有</el-radio>
                            <el-radio :label="0">无</el-radio>
                        </el-radio-group>
                    </el-form-item>
                </el-col>

            </el-row>


        </el-form>
    </el-card>

</template>


<script>
//bcdgirno
export default {
    props: ['form'],
    data() {
        return {
            projectLevels: [{name: '国家', value: 0}, {name: '省部', value: 1}, {name: '企业', value: 2}],
        }
    },


}
</script>
