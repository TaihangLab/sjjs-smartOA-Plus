<template>
  <div id="app">
    <el-form ref="form" :rules="rules" :model="form" label-width="80px">
      <el-form-item label="名称" prop="name">
        <el-input v-model="form.milestoneTitle"></el-input>
      </el-form-item>
      <el-form-item label="时间" prop="date">
        <el-col :span="11">
          <el-date-picker type="date" placeholder="选择日期" v-model="form.milestoneDate" style="width: 100%;" value-format="yyyy-MM-dd"></el-date-picker>
        </el-col>
      </el-form-item>
      <el-form-item label="详请" prop="desc">
        <el-input type="textarea" v-model="form.milestoneRemark"></el-input>
      </el-form-item>
      <el-form-item label="附件">
        <fujian ref="fujian" :idList="ossids"/>
      </el-form-item>
      <el-form-item>
        <el-button
          type="primary"
          size="small"
          @click="addMilestone"
        >
          确定
        </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import fujian from "./../../../components/FileUpload/index.vue";
import request from '@/utils/request';

export default {
  props: {
        projectId: {
            type: String,
            default: "",
        },
    },
  components: {
    fujian,
  },
  data() {
    return {
      fileList: [
        { name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100' }
      ],
      form: {
          projectId: this.projectId,
          milestoneTitle: '',
          milestoneRemark: '',
          milestoneDate: '',
          ossIds:[],
        },
        ossids:[],
        rules: {
          name: [
            { required: true, message: '请输入名称', trigger: 'blur' },
          ],
          date: [
            { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
          ],
          desc: [
            { required: true, message: '请填写详情', trigger: 'blur' }
          ]
        }
      };
  },

  methods: {
    addMilestone() {
      this.form.ossIds = this.ossids.map(item=>item.ossId);
      request({ 
        url: '/project/my/milestoneadd',
        method: 'post',
        data:this.form
      })
      .then((resp) => {
        console.log(resp);
        this.$modal.msgSuccess("新增成功");
        this.$emit('close-dialog'); // 触发一个事件通知父组件关闭弹窗
        });
      console.log(this.form);
      this.reset();
    },
     // 表单重置
     reset() {
      this.form={
        projectId: this.projectId,
        milestoneTitle: '',
        milestoneRemark: '',
        milestoneDate: '',
        ossIds:[],
      },
      this.$refs.fujian.reset();
    },
    submitUpload() {
      this.$refs.upload.submit();
    },
    onSubmit() {
      console.log('submit!');
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePreview(file) {
      console.log(file);
    },
    handleExceed(files, fileList) {
      Message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
    },
    beforeRemove(file, fileList) {
      return MessageBox.confirm(`确定移除 ${file.name}？`);
    },
  },
};
</script>
