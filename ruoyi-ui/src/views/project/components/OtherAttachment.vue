<template>
  <el-card header="其他附件" shadow="hover">
    <el-form :model="form" ref="form" label-position="left">
      <el-form-item label-width="125px" label="其他附件" prop="funds">
        <el-input v-model="form.funds"></el-input>
      </el-form-item>

      <FileUpload :value="['a','b']"></FileUpload>

    </el-form>
  </el-card>

</template>


<script>
import FileUpload from "@/components/FileUpload/index.vue";
export default {
  props: ['form'],
  components:{
    FileUpload
  },
  data() {
    return {

    }
  },

}
</script>
