<template>
    <div>
        <el-card header="项目推进情况" shadow="hover">
            <el-form :model="form" ref="form" label-position="left">
                <el-row :gutter="20" type="flex" justify="left">
                    <el-col :span="8">
                        <el-form-item label-width="125px" label="推进情况" prop="progressStatus">
                            <el-select v-model="form.projectProgressStatus" clearable placeholder="请选择">
                                <el-option
                                    v-for="(item, index) in progressStatus"
                                    :key="index"
                                    :label="item.name"
                                    :value="item.value">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="16">
                        <el-form-item label-width="125px" label="完成进度" prop="completionProgress">
                            <el-input
                                type="textarea"
                                :autosize="{ minRows: 1, maxRows: 4}"
                                maxlength="1000"
                                show-word-limit
                                v-model="form.completionProgress">
                            </el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
        </el-card>

        <el-card header="项目经费情况" shadow="hover">
            <el-form :model="form" ref="form" label-position="left">
                <el-row :gutter="10">
                    <el-col :span="8">
                        <el-form-item label-width="125px" label="专项到款总额">
                            <el-input v-model.number="form.totalFundsZxDk" type="number"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label-width="125px" label="已完成自筹投资">
                            <el-input v-model.number="form.zctzDone" type="number"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label-width="125px" label="已完成专项投资">
                            <el-input v-model.number="form.zxtzDone" type="number"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="10">
                    <el-col :span="8">
                        <el-form-item label-width="125px" label="自筹经费公司配套">
                            <el-input v-model.number="form.zcGspt" type="number"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label-width="200px" label="专项经费公司留存（计划）">
                            <el-input v-model.number="form.zxGslc" type="number"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
        </el-card>

        <el-card header="项目成果情况" shadow="hover">
            <el-form :model="form" ref="form" label-position="left">
                <el-row :gutter="10">
                    <el-col :span="8">
                        <el-form-item label-width="125px" label="获奖情况（项）">
                            <el-input
                                type="textarea"
                                :autosize="{ minRows: 1, maxRows: 4}"
                                maxlength="500"
                                show-word-limit
                                v-model="form.awardDetails">
                            </el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label-width="125px" label="论文情况（项）">
                            <el-input
                                type="textarea"
                                :autosize="{ minRows: 1, maxRows: 4}"
                                maxlength="500"
                                show-word-limit
                                v-model="form.publicationDetails">
                            </el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label-width="125px" label="专利情况">
                            <el-input
                                type="textarea"
                                :autosize="{ minRows: 1, maxRows: 4}"
                                maxlength="500"
                                show-word-limit
                                v-model="form.patentDetails">
                            </el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="10">
                    <el-col :span="8">
                        <el-form-item label-width="125px" label="软著情况">
                            <el-input
                                type="textarea"
                                :autosize="{ minRows: 1, maxRows: 4}"
                                maxlength="500"
                                show-word-limit
                                v-model="form.softwareCopyrightDetails">
                            </el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label-width="125px" label="标准情况">
                            <el-input
                                type="textarea"
                                :autosize="{ minRows: 1, maxRows: 4}"
                                maxlength="500"
                                show-word-limit
                                v-model="form.standardDetails">
                            </el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
        </el-card>
    </div>
</template>
<script>

export default {
    props: ['form'],
    data() {
        return {
            progressStatus:[{name:'正在需求申报', value: 0},{name:'已完成需求申报', value: 1},{name:'正在项目申报', value: 2},
                {name:'已完成项目申报', value: 3},{name:'已签订任务书并推进中', value: 4},{name:'已完成中期评审', value: 5},
                {name:'已完成验收', value: 6},{name:'未通过评审', value: 7}]
        }
    },


}
</script>
