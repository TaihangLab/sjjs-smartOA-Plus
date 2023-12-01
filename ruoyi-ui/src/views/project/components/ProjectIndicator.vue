<template>
  <el-card header="项目指标" shadow="hover">

    <el-form :model="form" ref="form" label-position="left">
    <el-form-item label-width="125px" label="指标名称">
      <el-input v-model="$props.form.name"></el-input>
    </el-form-item>
    <el-form-item label-width="125px" label="指标内容">
    </el-form-item>
    </el-form>

  </el-card>
</template>


<script>
export default {
  props: ['form'],
  data() {
    return{}
  },

}
</script>
