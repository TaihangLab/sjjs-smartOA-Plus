<template>
  <el-container>
    <el-header>
      <el-card shadow="hover">
        <el-steps :active="stepID" finish-status="success" simple>
          <el-step title="项目信息"></el-step>
          <el-step title="项目成员"></el-step>
          <el-step title="项目经费"></el-step>
          <el-step title="专项经费"></el-step>
          <el-step title="自筹经费"></el-step>
          <el-step title="经费来源"></el-step>
          <el-step title="项目指标"></el-step>
          <el-step title="正文附件"></el-step>
          <el-step title="其他附件"></el-step>
        </el-steps>
      </el-card>
    </el-header>

    <el-main style="margin-top: 20px;">

      <el-collapse-transition>
        <ProjectInfo v-show="stepID===0" :form="projectInfo" ref="projectInfo"></ProjectInfo>
      </el-collapse-transition>

      <el-collapse-transition>
        <ProjectMember v-show="stepID===1" :form="projectMember"></ProjectMember>
      </el-collapse-transition>

      <el-collapse-transition>
        <ProjectFunds v-show="stepID===2" :form="projectFunds"></ProjectFunds>
      </el-collapse-transition>

      <el-collapse-transition>
        <ZXFundsDetail v-show="stepID===3" :form="zxFundsDetail"></ZXFundsDetail>
      </el-collapse-transition>

      <el-collapse-transition>
        <ZCFundsDetail v-show="stepID===4" :form="zcFundsDetail"></ZCFundsDetail>
      </el-collapse-transition>

      <el-collapse-transition>
        <FundsSource v-show="stepID===5" :form="fundsSource"></FundsSource>
      </el-collapse-transition>


      <el-collapse-transition>
        <ProjectIndicator v-show="stepID===6" :form="projectIndicator"></ProjectIndicator>
      </el-collapse-transition>

      <el-collapse-transition>
        <MainAttachment v-show="stepID===7" :form="mainAttachment"></MainAttachment>
      </el-collapse-transition>

      <el-collapse-transition>
        <OtherAttachment v-show="stepID===8" :form="otherAttachment"></OtherAttachment>
      </el-collapse-transition>

    </el-main>

    <el-footer>
      <el-button v-show="stepID > 0" style="margin-top: 12px;" @click="previous">上一步</el-button>
      <el-button style="margin-top: 12px;" @click="next">下一步</el-button>
      <el-button @click="reset('newProjectForm')">重置</el-button>
    </el-footer>
  </el-container>

</template>


<script>
import ZCFundsDetail from "@/views/project/components/ZCFundsDetail.vue";
import ZXFundsDetail from "./ZXFundsDetail.vue";
import ProjectInfo from "./ProjectInfo.vue";
import ProjectMember from "@/views/project/components/ProjectMember.vue";
import ProjectIndicator from "@/views/project/components/ProjectIndicator.vue";
import ProjectFunds from "@/views/project/components/ProjectFunds.vue";
import FundsSource from "@/views/project/components/FundsSource.vue";
import MainAttachment from "@/views/project/components/MainAttachment.vue";
import OtherAttachment from "@/views/project/components/OtherAttachment.vue";

const TOTAL_STEPS = 9;
export default {
  name: "NewProject",
  props: ['visible'],
  components: {
    OtherAttachment,
    MainAttachment,
    FundsSource,
    ProjectIndicator,
    ProjectInfo,
    ZXFundsDetail,
    ProjectMember,
    ZCFundsDetail,
    ProjectFunds
  },
  data() {
    return {
      stepID: 0,
      newProjectForm: {},
      projectInfo: {},
      zxFundsDetail: {},
      projectMember: {},
      zcFundsDetail: {},
      projectIndicator: {},
      projectFunds: {},
      fundsSource: {},
      otherAttachment: {},
      mainAttachment: {},
    };
  },

  methods: {
    next() {
      console.log(this.stepID);
      // todo
      if (this.stepID++ >= TOTAL_STEPS - 1) {
        this.stepID = 0;
      }

    },
    previous() {
      if (this.stepID > 0) {
        this.stepID--;
      }
    },

    reset() {
      // for (let sub in this.newProjectForm) {
      //   for (let item in this.newProjectForm[sub]) {
      //     this.newProjectForm[sub][item] = "";
      //   }
      // }
      console.log(this.projectFunds);
      // this.$refs.projectInfo.$refs.form111.resetFields()

    },
  },

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


</style>
