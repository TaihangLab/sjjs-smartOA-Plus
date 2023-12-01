<template>
  <el-card header="项目信息" shadow="hover">
    <el-form :model="form" ref="form" label-position="left">
      <el-form-item label-width="125px" label="项目经费" prop="funds">
        <el-input v-model="form.funds"></el-input>
      </el-form-item>

    </el-form>
  </el-card>

</template>


<script>
export default {
  props: ['form'],
  data() {
    return {

    }
  },

}
</script>
