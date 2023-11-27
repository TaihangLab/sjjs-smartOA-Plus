<script>
export default {
  name: "ProjectMember",
  props: ['form'],
}
</script>

<template>
  <el-card header="项目成员" shadow="hover">
    <el-form-item label-width="125px" label="项目成员">
      <el-input v-model="form.name"></el-input>
    </el-form-item>
  </el-card>
</template>

<style scoped lang="scss">

</style>
