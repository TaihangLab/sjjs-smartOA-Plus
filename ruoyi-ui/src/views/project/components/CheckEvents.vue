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
              v-hasPermi="['system:milestone:edit']"
          ></el-button>
          <el-button
              type="danger"
              icon="el-icon-delete"
              size="mini"
              circle
              @click="deleteMilestone(item)"
              v-hasPermi="['system:milestone:remove']"
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
      <AddEvents
          :visible.sync="eventsDialogVisibleAdd"
          :item="item"
      ></AddEvents>
    </el-dialog>
  </div>
</template>

<script>
import request from '@/utils/request';
import AddEvents from "@/views/project/components/AddEvents.vue";
import {editMilestone, getMilestone, deleteMilestone} from "@/api/system/milestone";

export default {
  props: {
    item: {
      type: Object,
      required: true,
    },
  },
  components: {AddEvents},
  data() {
    return {
      eventsDialogVisibleAdd: false,
      localItem: this.item,
      timelineItems: [],
      formData: {}, // 初始化 form 对象
      title: "" // 初始化 title
    };
  },
  created() {
    // 获取数据
    request({url: '/project/list/0', method: 'get'})
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
            this.formData = response.data;
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
        status: "0"
      };
      this.resetForm("formData");
    },
  },
}
</script>
