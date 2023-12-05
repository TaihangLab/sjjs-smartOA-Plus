<template>
  <div class="block">
    <el-timeline>
      <el-timeline-item
        v-for="(item, index) in timelineItems"
        :key="index"
        :timestamp="item.milestoneDate"
        placement="top"
        :icon="item.icon"
        :style="{ '--icon-color': '#0bbd87'}"
      >
        <el-card>
          <h4>{{ item.milestoneTitle }}</h4>
          <p>{{ item.milestoneRemark }} 提交于 {{ item.milestoneDate }}</p>
          <el-button
            type="success"
            icon="el-icon-edit"
            size="mini"
            circle
            @click="editMilestone(item)"
          ></el-button>
          <el-button
            type="danger"
            icon="el-icon-delete"
            size="mini"
            circle
            @click="deletMilestone(localItem)"
          ></el-button>
          <el-link
            v-if="item.attachment"
            :href="item.attachment"
            target="_blank"
            type="primary"
            icon="el-icon-share"
            :underline="false"
            style="margin-left: 10px;"
          >
            附件
          </el-link>
        </el-card>
      </el-timeline-item>
    </el-timeline>
    <!-- 修改页面弹出框 -->
    <el-dialog
    title="大事记"
    :visible.sync="eventsDialogVisibleAdd"
    :lock-scroll="false"
    :append-to-body="true"
    width="50%"
    >
    <div id="app">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="名称">
          <el-input v-model="form.milestoneTitle"></el-input>
        </el-form-item>
        <el-form-item label="时间">
          <el-col :span="11">
            <el-date-picker
             type="date"
             placeholder="选择日期"
             v-model="form.milestoneDate"
             style="width: 100%;"
             value-format="yyyy-MM-dd"
             ></el-date-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="详请">
          <el-input type="textarea" v-model="form.milestoneRemark"></el-input>
        </el-form-item>
        <el-form-item label="附件">
          <fujian :idList="form.ossidList"/>
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
  </el-dialog>
  </div>
</template>

<script>
import request from '@/utils/request';
import fujian from "./../../../components/FileUpload/index.vue";
import { editMilestone, getMilestone } from "@/api/system/milestone";

export default {
  components: {
    fujian,
  },
  data() {
    return {
      fileList: [
        { name: 'food.jpeg', url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100' }
      ],
      eventsDialogVisibleAdd: false,
      localItem: this.item,
      timelineItems: [],
      title: "" ,// 初始化 title
      form: {
        projectId: '0',
        milestoneTitle: '',
        milestoneRemark: '',
        milestoneDate: '',
        ossidList:[],
      },// 初始化 form 对象
      localItem: {},
    };
  },
  created() {
  // 获取数据
    request({ url: '/project/list/targetlist/0', method: 'get' })
      .then((resp) => {
        // 根据 milestoneDate 对 timelineItems 进行排序
        this.timelineItems = resp.data.sort((a, b) => {
          return new Date(a.milestoneDate) - new Date(b.milestoneDate);
        });
      })
      .catch((error) => {
        console.error('获取数据时出错：', error);
      })
    },
  methods: {
    editMilestone(item) {
      const milestoneId = item.milestoneId;
      // 调用后端接口获取指定 milestoneId 的详细信息
      getMilestone(milestoneId)
      .then((response) => {
        console.log('后端返回的数据：', response.data);
        this.form = response.data;
        this.eventsDialogVisibleAdd = true;
        this.title = "编辑大事记";
      })
      .catch((error) => {
        console.error("获取大事记详情时出错：", error);
      });
    },
    deleteMilestone(item) {
      // 删除逻辑，可以弹出确认框等
      console.log('删除项目', item);
    },
    reset() {
      this.item = {
        milestoneId: undefined,
        milestoneTitle: undefined,
        milestoneRemark: undefined,
        milestoneDate: undefined,
      };
      this.resetForm("form");
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
