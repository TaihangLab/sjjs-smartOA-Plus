<template>
  <el-card header="正文附件" shadow="hover">
<!--    <el-form :model="form" ref="form" label-position="left">-->
<!--      <el-form-item label-width="125px" label="正文附件" prop="funds">-->
<!--        <el-input v-model="form.funds"></el-input>-->
<!--      </el-form-item>-->

          <div class="flex">
          <el-card v-for="(title, index) in titles" :header="title" :key="index" style="width: 45vw;margin-bottom: 10px;" shadow="hover">

            <el-link style="margin-bottom: 10px;" icon='el-icon-download' type="primary" href="https://element.eleme.io" target="_blank">{{ title }}</el-link>
            <FileUpload :title="title" :idList="idList" :limit="1"></FileUpload>
          </el-card>
          </div>
<!--    </el-form>-->
  </el-card>

</template>


<script>
import FileUpload from "@/components/FileUpload/index.vue";
export default {
  props: ['form'],
  created() {
    this.$props.form.uploadList = [];
  },
  components:{
    FileUpload,
  },
  data() {
    return {
      titles: ["项目申报.docx", "项目预算.docx"],
      idList: [],
    }
  },
  watch: {
    idList(newList, oldList) {
      this.$props.form.uploadList = newList
    },
  }

}
</script>

<style scoped>
  .flex {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-between;
  }
</style>
