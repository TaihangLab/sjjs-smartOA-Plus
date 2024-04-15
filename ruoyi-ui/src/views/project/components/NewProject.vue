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
            </el-collapse-transition>

            <el-collapse-transition>
                <ProjectFunds v-show="stepID===2" :form="projectFundsForm" ref="projectFunds"></ProjectFunds>
            </el-collapse-transition>

            <el-collapse-transition>
                <ProjectSpecialFund v-show="stepID===3" :cards1="cards1Form" :cards2="cards2Form" :table-data="tableDataForm"
                                    :cards3="cards3Form" ref="projectSpecialFund"></ProjectSpecialFund>
            </el-collapse-transition>

            <el-collapse-transition>
                <ProjectSelfFund v-show="stepID===4" :cards1="zcCards1Form" :cards2="zcCards2Form" :table-data="zcTableDataForm"
                                 :cards3="zcCards3Form" ref="projectSelfFund"></ProjectSelfFund>
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

            <!--            <el-collapse-transition>-->
            <!--                <MainAttachment v-show="stepID===8" :form="mainAttachmentForm" ref="mainAttachment"></MainAttachment>-->
            <!--            </el-collapse-transition>-->

            <el-collapse-transition>
                <OtherAttachment v-show="stepID===8" :form="otherAttachmentForm"
                                 ref="otherAttachment"></OtherAttachment>
            </el-collapse-transition>
            <el-collapse-transition>
                <ProjectProgress v-show="stepID===9" :form="projectProgressForm"
                                 ref="projectProgress"></ProjectProgress>
            </el-collapse-transition>
        </el-main>

        <el-footer>
            <el-button v-show="stepID > 0" style="margin-top: 12px;" @click="previous">上一步</el-button>
            <el-button style="margin-top: 12px;" @click="next" type="primary">{{ nextButtonText }}</el-button>
            <el-button v-show="stepID < 10" style="margin-top: 12px;" @click="submit" type="success">现在提交</el-button>
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
import {Loading, Message} from "element-ui";
import {addProject, getProject, updateProject} from "@/views/project/components/project";
import {resetObject} from "@/views/project/components/utils";
import ProjectProgress from "@/views/project/components/ProjectProgress.vue";
import ProjectSpecialFund from "@/views/project/components/ProjectSpecialFund.vue";
import categoryOptions1, {categoryOptions2, categoryOptions4, categoryOptions5, reorganizeData, reorganizeJJData} from "@/views/project/components/fundkeys";
import item from "@/layout/components/Sidebar/Item.vue";
import ProjectSelfFund from "@/views/project/components/ProjectSelfFund.vue";

const TOTAL_STEPS = 9;

export default {
    name      : "NewProject",
    props     : ['visible', "updateId"],
    components: {
        ProjectSelfFund,
        ProjectSpecialFund,
        ProjectProgress,
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
    mounted: async function () {
        /**
         * 如果是修改项目，需要获取项目的信息  this.zxFundsDetailForm, this.zcFundsDetailForm,弃用
         */
        if (this.$props.updateId) {
            await getProject(this.updateId, this.projectInfoForm, this.projectMemberForm,
                this.projectFundsForm, this.zxFundsDetailForm, this.zcFundsDetailForm,
                this.fundsSourceForm, this.projectIndicatorForm, this.projectPlanForm,
                this.otherAttachmentForm, this.projectProgressForm, this.projectAllFundsForm).then(() => {
                this.categoryOption1 = categoryOptions1;
                this.categoryOption2 = categoryOptions2;
                this.categoryOption4 = categoryOptions4;
                this.categoryOption5 = categoryOptions5;
                reorganizeData(this.categoryOption1, this.projectAllFundsForm, this.cards1Form, this.cards2Form, this.tableDataForm);
                reorganizeData(this.categoryOption2, this.projectAllFundsForm, this.zcCards1Form, this.zcCards2Form, this.zcTableDataForm);
                reorganizeJJData(this.categoryOption4, this.projectAllFundsForm, this.cards3Form);
                reorganizeJJData(this.categoryOption5, this.projectAllFundsForm, this.zcCards3Form);
            });
        }
    },
    data() {
        return {
            stepID        : 0,
            isStepHover   : false,
            titles        : ["项目信息", "项目成员", "项目经费", "专项经费", "自筹经费", "经费来源", "项目指标", "项目计划", "项目申报附件", "项目推进情况"],
            nextButtonText: '下一步',

            projectInfoForm     : {},
            projectMemberForm   : {members: [], items: []},
            projectFundsForm    : {},
            zxFundsDetailForm   : {}, //弃用
            zcFundsDetailForm   : {}, //弃用
            projectIndicatorForm: {},
            projectPlanForm     : {},
            fundsSourceForm     : {},
            mainAttachmentForm  : {},
            otherAttachmentForm : {},
            projectProgressForm : {},
            cards1Form: [],
            cards2Form: [],
            cards3Form: [],
            tableDataForm: [],
            zcCards1Form: [],
            zcCards2Form: [],
            zcCards3Form: [],
            zcTableDataForm: [],
            projectAllFundsForm: [],
            categoryOption1: [],
            categoryOption2: [],
            categoryOption4: [],
            categoryOption5: [],
        };
    },

    methods: {

        /**
         * 下一步按钮
         */
        next() {
            if (this.stepID++ > TOTAL_STEPS - 1) {
                this.submit();
                // this.$emit('update:visible', false);
                // this.reset();
            }

        },
        /**
         * 上一步按钮
         */
        previous() {
            if (this.stepID > 0) {
                this.stepID--;
            }
        },
        /**
         * 打印表单信息
         */
        info() {
            // console.log('projectInfoForm', this.projectInfoForm);
            // console.log('projectMemberForm', this.projectMemberForm);
            // console.log('projectFundsForm', this.projectFundsForm);
            // console.log('zxFundsDetailForm', this.zxFundsDetailForm);
            // console.log('zcFundsDetailForm', this.zcFundsDetailForm);
            // console.log('fundsSourceForm', this.fundsSourceForm);
            // console.log('projectIndicatorForm', this.projectIndicatorForm);
            // console.log('projectPlanForm', this.projectPlanForm);
            // console.log('mainAttachmentForm', this.mainAttachmentForm);
            // console.log('otherAttachmentForm', this.otherAttachmentForm);
        },
        /**
         * 重置表单
         */
        reset() {
            resetObject(this.projectInfoForm)
            this.$refs.projectMember.reset();
            resetObject(this.projectFundsForm);
            resetObject(this.zxFundsDetailForm); //弃用
            resetObject(this.zcFundsDetailForm); //弃用
            resetObject(this.fundsSourceForm);
            this.$refs.projectPlanForm.reset();
            this.$refs.projectIndicator.reset();
            this.$refs.otherAttachment.$refs.fileUpload.reset();
            resetObject(this.projectProgressForm);
            // this.$refs.projectProgress.reset();
            this.$refs.projectSpecialFund.reset();
            this.$refs.projectSelfFund.reset();
            this.stepID = 0;
        },
        /**
         * 提交表单
         * @returns {Promise<void>}
         */
        async submit() {
            // 验证表单
            try {
                await this.$refs.projectInfo.$refs.form.validate();
            } catch (e) {
                Message({
                    showClose: true,
                    message  : '错误哦，必选信息需要被填写',
                    type     : 'error',
                });
                return;
            }
            const loading = Loading.service({fullscreen: true, lock: true, text: '努力加载中'});
            if (this.$props.updateId) {
                const projectUpdateFundForm = {};
                this.projectFundForm(this.cards1Form, this.cards2Form, this.tableDataForm, projectUpdateFundForm);
                this.projectFundForm(this.zcCards1Form, this.zcCards2Form, this.zcTableDataForm, projectUpdateFundForm);
                this.jProjectFundForm(this.cards3Form, projectUpdateFundForm);
                this.jProjectFundForm(this.zcCards3Form, projectUpdateFundForm);
                updateProject(this.$props.updateId,
                    this.projectInfoForm,
                    this.projectMemberForm,
                    this.projectFundsForm,
                    this.zxFundsDetailForm, //弃用
                    this.zcFundsDetailForm, //弃用
                    this.fundsSourceForm,
                    this.projectIndicatorForm,
                    this.projectPlanForm,
                    this.otherAttachmentForm,
                    this.projectProgressForm,
                    projectUpdateFundForm,
                )
                    .then(resp => {
                        this.$message({
                            message: '恭喜你，项目修改成功',
                            type   : 'success'
                        });
                        loading.close();
                    }, error => {
                        this.$message.error('错了哦，服务器返回了一条错误信息\n' + error);
                        loading.close();
                    })
                this.$emit('update:visible', false);
                // this.$emit("refresh");
                setTimeout(() => location.reload(), 900);
                return;
            }

            /**
             * 新增项目
             * @param projectInfoForm
             * @param projectMemberForm
             * @param projectFundsForm
             * @param zxFundsDetailForm //弃用
             * @param zcFundsDetailForm //弃用
             * @param fundsSourceForm
             * @param projectIndicatorForm
             * @param projectPlanForm
             * @param otherAttachmentForm
             * @param projectProgressForm
             * @returns {Promise}
             */
            const projectAddFundForm = {};
            this.projectFundForm(this.cards1Form, this.cards2Form, this.tableDataForm, projectAddFundForm);
            this.projectFundForm(this.zcCards1Form, this.zcCards2Form, this.zcTableDataForm, projectAddFundForm);
            this.jProjectFundForm(this.cards3Form, projectAddFundForm);
            this.jProjectFundForm(this.zcCards3Form, projectAddFundForm);

            addProject(this.projectInfoForm,
                this.projectMemberForm,
                this.projectFundsForm,
                this.zxFundsDetailForm, //弃用
                this.zcFundsDetailForm, //弃用
                this.fundsSourceForm,
                this.projectIndicatorForm,
                this.projectPlanForm,
                this.otherAttachmentForm,
                this.projectProgressForm,
                projectAddFundForm,
            )
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
            // this.$emit("refresh");
            setTimeout(() => location.reload(), 900);
        },
        projectFundForm(cards1Form, cards2Form, tableDataForm, result) {
            // 转换一级选择器的数据
            cards1Form.forEach(item => {
                result[item.value] = item.content; // 使用value作为键，content作为值
            });
            cards2Form.forEach(item =>{
                item.forEach(item1 =>{
                    result[item1.value] = item1.content;
                })
            })
            // 转换三级选择器的数据
            // 遍历一级数组
            tableDataForm.forEach(level1 => {
                // 遍历二级数组
                level1.forEach(level2 => {
                    // 遍历二级数组中的对象
                    level2.forEach(item => {
                        result[item.value] = item.content; // 使用value作为键，content作为值
                    });
                });
            });
        },
        jProjectFundForm(cards3Form, result) {
            // 转换一级选择器的数据
            cards3Form.forEach(item => {
                if(item.content && item.content!==0) {
                    result[item.value] = item.content; // 使用value作为键，content作为值
                }

            });
        },
    },

    watch: {
        /**
         * 监听步骤ID的变化
         * @param newid
         * @param oldid
         */
        stepID(newid, oldid) {
            if (newid > TOTAL_STEPS - 1) {
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
