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
                    <el-form-item label-width="120px" label="项目任务书编号" prop="projectNumber"
                                  :rules="[{ required: true, message: '请输入 项目任务书编号', trigger: 'blur' }]">
                        <el-input v-model="form.projectNumber"></el-input>
                    </el-form-item>
                </el-col>

            </el-row>

            <el-row :gutter="20" type="flex" justify="left">
                <el-col :span="8">
                    <el-form-item label-width="120px" label="项目来源" prop="source"
                                  :rules="[{ required: true, message: '请输入 项目来源', trigger: 'blur' }]">
                        <el-input v-model="form.source"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="120px" label="负责课题" prop="subjectName"
                                  :rules="[{ required: true, message: '请输入 负责课题名称', trigger: 'blur' }]">
                        <el-input v-model="form.subjectName"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="120px" label="课题任务书编号" prop="subjectNumber"
                                  :rules="[{ required: true, message: '请输入 课题任务书编号', trigger: 'blur' }]">
                        <el-input v-model="form.subjectNumber"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row :gutter="20" type="flex" justify="left">
                <el-col :span="8">
                    <el-form-item label-width="120px" label="项目专员" prop="contact"
                                  :rules="[{ required: true, message: '请输入 项目专员', trigger: 'blur' }]">
                        <el-input v-model="form.contact"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="120px" label="推进情况" prop="progressStatus"
                                  :rules="[{ required: true, message: '请输入 推进情况', trigger: 'change' }]">
                        <el-select v-model="form.progressStatus" clearable placeholder="请选择">
                            <el-option
                                v-for="(item, index) in progressStatus"
                                :key="index"
                                :label="item.name"
                                :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label-width="120px" label="执行时间" prop="duration"
                                  :rules="[{ required: true, message: '请输入 执行时间', trigger: 'blur' }]">
                        <el-input v-model="form.duration"></el-input>
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
                                  :rules="[{ required: true, message: '请选择 验收时间', trigger: 'change' }]">
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
                    <el-form-item label-width="120px" label="是否为牵头单位" prop="isLeadingUnit"
                                  :rules="[{ required: true, message: '请选择 是否为牵头单位', trigger: 'change' }]">
                        <el-radio-group v-model="form.isLeadingUnit">
                            <el-radio :label="1">是</el-radio>
                            <el-radio :label="0">否</el-radio>
                        </el-radio-group>
                    </el-form-item>
                </el-col>
            </el-row>

            <!--            <el-row :gutter="20" type="flex" justify="left">-->
            <!--                <el-col :span="8">-->
            <!--                    <el-form-item label-width="120px" label="获奖情况" prop="awardStatus">-->
            <!--                        <el-input v-model="form.awardStatus"></el-input>-->
            <!--                    </el-form-item>-->
            <!--                </el-col>-->
            <!--                <el-col :span="8">-->
            <!--                    <el-form-item label-width="120px" label="论文情况" prop="paperStatus">-->
            <!--                        <el-input v-model="form.paperStatus"></el-input>-->
            <!--                    </el-form-item>-->
            <!--                </el-col>-->
            <!--                <el-col :span="8">-->
            <!--                    <el-form-item label-width="120px" label="专利情况" prop="patentStatus">-->
            <!--                        <el-input v-model="form.patentStatus"></el-input>-->
            <!--                    </el-form-item>-->
            <!--                </el-col>-->
            <!--            </el-row>-->

            <!--            <el-row :gutter="20" type="flex" justify="left">-->
            <!--                <el-col :span="8">-->
            <!--                    <el-form-item label-width="120px" label="软著情况" prop="rzStatus">-->
            <!--                        <el-input v-model="form.rzStatus"></el-input>-->
            <!--                    </el-form-item>-->
            <!--                </el-col>-->
            <!--                <el-col :span="8">-->
            <!--                    <el-form-item label-width="120px" label="标准情况" prop="standardStatus">-->
            <!--                        <el-input v-model="form.standardStatus"></el-input>-->
            <!--                    </el-form-item>-->
            <!--                </el-col>-->
            <!--            </el-row>-->

            <el-row :gutter="20" type="flex" justify="left">
                <el-col :span="12">
                    <el-form-item label-width="120px" label="合作单位" prop="coopUnit">
                        <el-input v-model="form.coopUnit"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label-width="120px" label="涉及专家团队" prop="expertTeam">
                        <el-input v-model="form.expertTeam"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

<!--            <el-row :gutter="20" type="flex" justify="left">-->
<!--                <el-col :span="12">-->
<!--                    <el-form-item label-width="120px" label="意义及必要性" prop="meaning">-->
<!--                        <el-input type="textarea" v-model="form.meaning"></el-input>-->
<!--                    </el-form-item>-->
<!--                </el-col>-->

<!--                <el-col :span="12">-->
<!--                    <el-form-item label-width="120px" label="完成进度" prop="completionProgress">-->
<!--                        <el-input type="textarea" v-model="form.completionProgress"></el-input>-->
<!--                    </el-form-item>-->
<!--                </el-col>-->
<!--            </el-row>-->

            <el-row :gutter="20" type="flex" justify="left">
                <el-col :span="24">
                    <el-form-item label-width="120px" label="项目简介" prop="description">
                        <el-input type="textarea" v-model="form.description"></el-input>
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
            progressStatus:[{name:'正在需求申报', value: 0},{name:'已完成需求申报', value: 1},{name:'正在项目申报', value: 2},
                {name:'已完成项目申报', value: 3},{name:'已签订任务书并推进中', value: 4},{name:'已完成中期评审', value: 5},
                {name:'已完成验收', value: 6},{name:'未通过评审', value: 7}]
        }
    },


}
</script>
<style scoped>

</style>
