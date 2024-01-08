<template>
    <el-container>
        <el-header>
            <el-card shadow="hover">
                <el-steps :active="stepID" finish-status="success" simple>
                    <el-step
                        v-for="(t, index) in titles" :key="index" :title="t"
                        @click.native="stepID=index"
                    ></el-step>
                </el-steps>
            </el-card>
        </el-header>

        <el-main style="margin-top: 20px;">

            <el-collapse-transition>
                <ProjectInfo v-show="stepID===0" :form="projectInfoForm" ref="projectInfo"></ProjectInfo>
            </el-collapse-transition>

            <el-collapse-transition>
                <ProjectMember2 v-show="stepID===1" :form="projectMemberForm" ref="projectMember"
                ></ProjectMember2>
                <!--                :selectedIdList="['1726485523286900737', '1729072278007623681']"-->
            </el-collapse-transition>

            <el-collapse-transition>
                <ProjectFunds v-show="stepID===2" :form="projectFundsForm" ref="projectFunds"></ProjectFunds>
            </el-collapse-transition>

            <el-collapse-transition>
                <ZXFundsDetail v-show="stepID===3" :form="zxFundsDetailForm" ref="zxFundsDetail"></ZXFundsDetail>
            </el-collapse-transition>

            <el-collapse-transition>
                <ZCFundsDetail v-show="stepID===4" :form="zcFundsDetailForm" ref="zcFundsDetail"></ZCFundsDetail>
            </el-collapse-transition>

            <el-collapse-transition>
                <FundsSource v-show="stepID===5" :form="fundsSourceForm" ref="fundsSource"></FundsSource>
            </el-collapse-transition>


            <el-collapse-transition>
                <ProjectIndicator v-show="stepID===6" :form="projectIndicatorForm"
                                  ref="projectIndicator"></ProjectIndicator>
            </el-collapse-transition>

            <el-collapse-transition>
                <ProjectPlan v-show="stepID===7" :form="projectPlanForm" ref="projectPlanForm"></ProjectPlan>
            </el-collapse-transition>

            <el-collapse-transition>
                <MainAttachment v-show="stepID===8" :form="mainAttachmentForm" ref="mainAttachment"></MainAttachment>
            </el-collapse-transition>

            <el-collapse-transition>
                <OtherAttachment v-show="stepID===9" :form="otherAttachmentForm"
                                 ref="otherAttachment"></OtherAttachment>
            </el-collapse-transition>

        </el-main>

        <el-footer>
            <el-button v-show="stepID > 0" style="margin-top: 12px;" @click="previous">上一步</el-button>
            <el-button style="margin-top: 12px;" @click="next" type="primary">{{ nextButtonText }}</el-button>
            <el-button v-show="stepID < 8" style="margin-top: 12px;" @click="submit" type="success">现在提交</el-button>
<!--            重置要求确认-->
            <el-popconfirm
                title="确定要重置吗?"
                @confirm="reset"
                style="margin-left: 10px;"
            >
                <template #reference>
                    <el-button @click.stop="" type="warning">重置</el-button>
                </template>
            </el-popconfirm>
<!--            <el-button @click="reset" type="warning">重置</el-button>-->
            <el-button @click="info">log</el-button>
        </el-footer>
    </el-container>

</template>


<script>
import ZCFundsDetail from "@/views/project/components/ZCFundsDetail.vue";
import ZXFundsDetail from "./ZXFundsDetail.vue";
import ProjectInfo from "./ProjectInfo.vue";
import ProjectMember from "@/views/project/components/ProjectMember.vue";
import ProjectMember2 from "@/views/project/components/ProjectMember2.vue";
import ProjectIndicator from "@/views/project/components/ProjectIndicator.vue";
import ProjectFunds from "@/views/project/components/ProjectFunds.vue";
import FundsSource from "@/views/project/components/FundsSource.vue";
import MainAttachment from "@/views/project/components/MainAttachment.vue";
import OtherAttachment from "@/views/project/components/OtherAttachment.vue";
import ProjectPlan from "@/views/project/components/ProjectPlan.vue";

import {Loading} from "element-ui";
import request from "@/utils/request";
import {addProject, getProject} from "@/views/project/components/project";
import Vue from "vue";
import {resetObject} from "@/views/project/components/utils";

const TOTAL_STEPS = 10;

export default {
    name      : "NewProject",
    props     : ['visible', "updateId"],
    components: {
        ProjectPlan,
        OtherAttachment,
        MainAttachment,
        FundsSource,
        ProjectIndicator,
        ProjectInfo,
        ZXFundsDetail,
        ProjectMember,
        ProjectMember2,
        ZCFundsDetail,
        ProjectFunds,

    },
    mounted() {
        if (this.$props.updateId) {
            console.log("获取到的ID为：", this.updateId);
            getProject(this.updateId, this.projectInfoForm, this.projectMemberForm,
                this.projectFundsForm, this.zxFundsDetailForm,
                this.zcFundsDetailForm, this.fundsSourceForm,
                this.projectIndicatorForm, this.projectPlanForm,
                this.otherAttachmentForm)
        }

    },
    data() {
        return {
            stepID        : 1,
            isStepHover   : false,
            titles        : ["项目信息", "项目成员", "项目经费", "专项经费", "自筹经费", "经费来源", "项目指标", "项目计划", "正文附件", "其他附件"],
            nextButtonText: '下一步',

            projectInfoForm     : {},
            projectMemberForm   : {members: [],items:[]},
            projectFundsForm    : {},
            zxFundsDetailForm   : {},
            zcFundsDetailForm   : {},
            projectIndicatorForm: {},
            projectPlanForm     : {},
            fundsSourceForm     : {},
            mainAttachmentForm  : {},
            otherAttachmentForm : {},
        };
    },

    methods: {
        next() {
            // todo
            if (this.stepID++ >= TOTAL_STEPS - 1) {
                this.submit();
                // this.$emit('update:visible', false);
                // this.reset();
            }

        },
        previous() {
            if (this.stepID > 0) {
                this.stepID--;
            }
        },
        info() {
            console.log('projectInfoForm', this.projectInfoForm);
            console.log('projectMemberForm', this.projectMemberForm);
            console.log('projectFundsForm', this.projectFundsForm);
            console.log('zxFundsDetailForm', this.zxFundsDetailForm);
            console.log('zcFundsDetailForm', this.zcFundsDetailForm);
            console.log('fundsSourceForm', this.fundsSourceForm);
            console.log('projectIndicatorForm', this.projectIndicatorForm);
            console.log('projectPlanForm', this.projectPlanForm);
            console.log('mainAttachmentForm', this.mainAttachmentForm);
            console.log('otherAttachmentForm', this.otherAttachmentForm);
        },

        reset() {
            console.log("重置开始")
            resetObject(this.projectInfoForm)
            this.$refs.projectMember.reset();
            resetObject(this.projectFundsForm);
            resetObject(this.zxFundsDetailForm);
            resetObject(this.zcFundsDetailForm);
            resetObject(this.fundsSourceForm);
            this.$refs.projectPlanForm.reset();
            this.$refs.projectIndicator.reset();
            // this.stepID = 0;
        },
        submit() {
            // console.log(this.$refs.projectInfo.$refs.form.validate());
            const loading = Loading.service({fullscreen: true, lock: true, text: '少女祈祷中'});
            addProject(this.projectInfoForm,
                this.projectMemberForm,
                this.projectFundsForm,
                this.zxFundsDetailForm,
                this.zcFundsDetailForm,
                this.fundsSourceForm,
                this.projectIndicatorForm,
                this.projectPlanForm,
                this.otherAttachmentForm)
                .then(resp => {
                    this.$message({
                        message: '恭喜你，项目新增成功',
                        type   : 'success'
                    });
                    loading.close();
                }, error => {
                    this.$message.error('错了哦，服务器返回了一条错误信息\n' + error);
                    loading.close();
                })
            this.$emit('update:visible', false);
            setTimeout(() => location.reload(), 900);
        },
    },
    watch  : {
        stepID(newid, oldid) {
            if (newid > TOTAL_STEPS - 2) {
                this.nextButtonText = '完成';
            } else {
                this.nextButtonText = '下一步';
            }
        },
    }

}
</script>


<style scoped>
.el-input {
    width: 150px;
}


:deep(input::-webkit-outer-spin-button),
:deep(input::-webkit-inner-spin-button) {
    -webkit-appearance: none !important;
}

:deep(input[type='number']) {
    -moz-appearance: textfield !important;
}

:deep(.is-process),
.el-divider__text {
    color: #ff6200;
    font-weight: bold;
}

:deep(.el-form-item__label) {
    font-weight: normal;
}

:deep(.el-step__title) {
    cursor: pointer;
}


</style>
