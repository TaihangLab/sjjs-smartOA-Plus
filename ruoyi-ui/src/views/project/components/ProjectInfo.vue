<template>
  <el-card header="项目信息" shadow="hover">
    {{form}}
    <el-form-item label-width="125px" label="项目名称">
      <el-input v-model="$props.form.name"></el-input>
    </el-form-item>
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
