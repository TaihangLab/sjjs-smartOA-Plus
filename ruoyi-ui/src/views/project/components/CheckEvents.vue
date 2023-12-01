<template>
    <div class="block">
      <el-timeline>
        <el-timeline-item
          v-for="(item, index) in timelineItems"
          :key="index"
          :timestamp="item.timestamp"
          placement="top"
          :icon="item.icon"
          :style="{ '--icon-color': '#0bbd87'}"
        >
          <el-card>
            <h4>{{ item.title }}</h4>
            <p>{{ item.author }} 提交于 {{ item.timestamp }}</p>
            <el-button
              type="success"
              icon="el-icon-edit"
              size="mini"
              circle
              v-hasPermi="['system:role:edit']"
              ></el-button>
            <el-button 
              type="danger"
              icon="el-icon-delete" 
              size="mini" 
              circle
              v-hasPermi="['system:role:remove']"
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
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        timelineItems: [
          { timestamp: "2023/11/12", title: "更新", author: "王小虎", attachment: "/path/to/attachment1.pdf" },
          { timestamp: "2023/11/3", title: "更新", author: "王小虎", attachment: "/path/to/attachment2.zip" },
          { timestamp: "2023/11/2", title: "更新", author: "王小虎", attachment: "/path/to/attachment1.pdf" },
        ],
      };
    },
  };
  </script>
