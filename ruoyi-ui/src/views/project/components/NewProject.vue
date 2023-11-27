<template>
  <el-container>
    <el-header>
      <el-card shadow="hover">
        <el-steps :active="stepID" finish-status="success" simple>
          <el-step title="项目信息"></el-step>
          <el-step title="项目成员"></el-step>
          <el-step title="项目经费"></el-step>
          <el-step title="经费详情"></el-step>
          <el-step title="经费来源"></el-step>
          <el-step title="项目指标"></el-step>
        </el-steps>
      </el-card>
    </el-header>

    <el-main style="margin-top: 20px;">
      <el-form :model="newProjectForm" label-position="left">

        <el-collapse-transition>
          <ProjectInfo v-show="stepID===0" :form="newProjectForm.projectInfo"></ProjectInfo>
        </el-collapse-transition>

        <el-collapse-transition>
        <ProjectMember v-show="stepID===1" :form="newProjectForm.projectMember"></ProjectMember>
        </el-collapse-transition>

        <el-collapse-transition>
          <el-card v-show="stepID===2" header="项目经费" shadow="hover">
            <el-form-item label-width="125px" label="项目经费">
              <el-input v-model="newProjectForm.name"></el-input>
            </el-form-item>
          </el-card>
        </el-collapse-transition>

        <el-collapse-transition>
          <ZXFundsDetail v-show="stepID===3" :form="newProjectForm.zxFundsDetail"></ZXFundsDetail>
        </el-collapse-transition>

        <el-collapse-transition>
          <el-card v-show="stepID===4" header="经费来源" shadow="hover">
            <el-form-item label-width="125px" label="经费来源">
              <el-input v-model="newProjectForm.name"></el-input>
            </el-form-item>
          </el-card>
        </el-collapse-transition>

        <el-collapse-transition>
          <el-card v-show="stepID===5" header="项目指标" shadow="hover">
            <el-form-item label-width="125px" label="项目指标">
              <el-input v-model="newProjectForm.name"></el-input>
            </el-form-item>
          </el-card>
        </el-collapse-transition>

      </el-form>
    </el-main>

    <el-footer>
      <el-button style="margin-top: 12px;" @click="next">下一步</el-button>
    </el-footer>
  </el-container>

</template>


<script>
import ZXFundsDetail from "./ZXFundsDetail.vue";
import ProjectInfo from "./ProjectInfo.vue";
import ProjectMember from "@/views/project/components/ProjectMember.vue";
const TOTAL_STEPS = 6;
export default {
  name: "NewProject",
  props:['visible'],
  components: {
    ProjectInfo,
    ZXFundsDetail,
    ProjectMember,
  },
  data() {
    return {
      stepID: 0,
      newProjectForm: {
        projectInfo:{},
        zxFundsDetail: {},
        projectMember: {},

      },
    };
  },

  methods: {
    next() {
      // todo
      if (this.stepID++ > TOTAL_STEPS - 1)
      {
        this.$emit("update:visible", false);
        this.stepID = 0;
      }
      console.log(this.newProjectForm.projectInfo.time);
    }
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

:deep(.el-form-item__label){
  font-weight: normal;
}


</style>
