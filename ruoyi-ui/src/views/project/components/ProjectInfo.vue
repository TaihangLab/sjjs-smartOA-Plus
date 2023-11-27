<template>
  <el-card header="项目信息" shadow="hover">
    <el-form-item label-width="125px" label="项目名称">
      <el-input v-model="$props.form.name"></el-input>
    </el-form-item>
    <el-form-item label-width="125px" label="项目时间">
      <el-date-picker
          v-model="$props.form.time"
          type="daterange"
          value-format="yyyy-MM-dd"
          range-separator="至"
          start-placeholder="开始日期"
          end-placeholder="结束日期">
      </el-date-picker>
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
