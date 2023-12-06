<template>
  <el-card header="其他附件" shadow="hover">
    <el-form :model="form" ref="form" label-position="left">
      <el-form-item label-width="125px" label="其他附件" prop="funds">
        <el-input v-model="form.funds"></el-input>
      </el-form-item>

      <FileUpload :idList="form.uploadList"></FileUpload>

      <el-divider></el-divider>
<!--      <FileUpload :value="['1731940901164343297', '1731884746010451970']"></FileUpload>-->
      <FileUpload value="1731940901164343297"></FileUpload>

    </el-form>
  </el-card>

</template>


<script>
import FileUpload from "@/components/FileUpload/index.vue";

export default {
  props: ['form'],
  components: {
    FileUpload
  },
  data() {
    return {}
  },
  created() {
    this.$props.form.uploadList = [];
  }
}
</script>
