<template>
  <el-card header="其他附件" shadow="hover">
    <el-form :model="form" ref="form" label-position="left">
      <el-form-item label-width="125px" label="其他附件" prop="funds">
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
