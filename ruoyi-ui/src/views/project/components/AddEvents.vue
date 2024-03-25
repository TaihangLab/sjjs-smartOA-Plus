<template>
  <div id="app">
    <el-form ref="form" :rules="rules" :model="form" label-width="80px">
      <el-form-item label="名称">
        <el-input v-model="form.milestoneTitle"></el-input>
      </el-form-item>
      <!-- 标签选择 -->
      <el-form-item label="标签" prop="tags" class="add_advice" id="adviceTag"
        style="display: flex; align-items: center;">
        <div class="tag-container">
          <div class="selected-tags">
            <el-tag v-for="(tag, index) in projectMilestoneTypes" :key="index" closable @close="handleClose(tag)"
              :type="getTagType(tag)" :style="{ color: getTextColor(tag) }">
              {{ tag }}
            </el-tag>
          </div>
          <el-select size="mini" v-model="selectedTag" placeholder="请选择标签" @change="addTag"
            style="flex: 1;width: 120px;">
            <el-option v-for="tag in tagOptions" :key="tag.value" :label="tag.label" :value="tag.label"></el-option>
          </el-select>
        </div>
      </el-form-item>
      <el-form-item label="时间">
        <el-col :span="11">
          <el-date-picker type="date" placeholder="选择日期" v-model="form.milestoneDate" style="width: 100%;"
            value-format="yyyy-MM-dd"></el-date-picker>
        </el-col>
      </el-form-item>
      <el-form-item label="详请">
        <el-input type="textarea" v-model="form.milestoneRemark"></el-input>
      </el-form-item>
      <el-form-item label="附件">
        <fujian ref="fujian" :idList="ossids" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" size="small" @click="addMilestone">
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
  props: ['projectId'],
  components: {
    fujian,
  },
  data() {
    return {
      form: {
        projectId: this.projectId,
        milestoneTitle: '',
        milestoneRemark: '',
        milestoneDate: '',
        ossIds: [],
        projectMilestoneTypes: [],
      },
      ossids: [],
      tagOptions: [], // 标签选项从 milestoneCategorySelectList 方法中获取
      selectedTag: '', // 用户选择的标签（中文文字）
      projectMilestoneTypes: [], // 用于存储用户选择的标签（中文文字）
      rules: {
        milestoneTitle: [
          { required: true, message: '请输入名称', trigger: 'blur' },
        ],
        milestoneDate: [
          { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
        ],
        milestoneRemark: [
          { required: true, message: '请填写详情', trigger: 'blur' }
        ]
      },
      labelMappings: {
        0: '其他',
        1: '申报书',
        2: '任务书',
        3: '科研协作合同',
        4: '专项经费文件',
        5: '经费管理表',
        6: '中期文件',
        7: '验收文件',
        8: '结题文件',
        9: '知识产权',
        10: '论文',
        11: '专利',
        12: '软著',
        13: '标准',
        14: '示范应用',
        15: '获奖',
        16: '报告',
        17: '专家咨询',
        18: '经费变更',
        19: '人员变更',
        20: '批复文件',
        21: '通知',
        22: '合同'
      },
    };
  },

  methods: {
    addMilestone() {
      // 验证关键字段是否为空
      if (!this.form.milestoneTitle || !this.form.milestoneDate || !this.form.milestoneRemark) {
        this.$message.error('请填写完整的信息');
        return;
      }

      // 将动态标签列表 dynamicTags 中的文字转换为对应的数字并放入 projectMilestoneTypes
      const categoryEnumList = this.projectMilestoneTypes.map(tag => {
        for (const typeId in this.labelMappings) {
          if (this.labelMappings[typeId] === tag) {
            return typeId;
          }
        }
        return null; // 如果找不到对应的数字，则返回null
      }).filter(tagId => tagId !== null); // 过滤掉找不到对应数字的标签

      this.form.projectMilestoneTypes = categoryEnumList; // 将转换后的标签数字列表赋值给表单数据

      this.form.ossIds = this.ossids;

      request({
        url: '/project/my/milestoneadd',
        method: 'post',
        data: this.form
      })
        .then((resp) => {
          this.$modal.msgSuccess("新增成功");
          this.$refs.fujian.reset();
          this.$emit('close-dialog'); // 触发一个事件通知父组件关闭弹窗
        })
        .catch(error => {
          console.error("添加里程碑时出错:", error);
        });

      this.reset();
    },
    addTag() {
      if (this.selectedTag && !this.projectMilestoneTypes.includes(this.selectedTag)) {
        this.projectMilestoneTypes.push(this.selectedTag); // 将选择的标签添加到 dynamicTags 数组中
      }
    },
    handleClose(tag) {
      this.projectMilestoneTypes.splice(this.projectMilestoneTypes.indexOf(tag), 1);
    },
    milestoneCategorySelectList() {
      request({
        url: '/project/list/milestoneCategorySelect',
        method: 'get',
        data: this.data,
      })
        .then((resp) => {
          // 将数字值转换为 labelMappings 中的文字描述
          this.tagOptions = resp.data.map(item => ({
            label: this.getLabel(item),
            value: item
          }));
        })
        .catch((error) => {
          console.error('获取数据时出错：', error);
        });
    },
    getLabel(typeId) {
      return this.labelMappings[typeId] || '未知'; // 如果找不到对应的文字，返回 '未知'
    },
    getTagType(tag) {
      // 根据标签名称返回不同的颜色类型
      switch (tag) {
        case '其他':
          return 'info'; // 其他 - 蓝色
        case '申报书':
          return 'danger'; // 申报书 - 红色
        case '任务书':
          return 'primary'; // 任务书 - 蓝色
        case '科研协作合同':
          return 'success'; // 科研协作合同 - 绿色
        case '专项经费文件':
          return 'warning'; // 专项经费文件 - 橙色
        case '经费管理表':
          return 'purple'; // 经费管理表 - 紫色
        case '中期文件':
          return 'deep-blue'; // 中期文件 - 深蓝色
        case '验收文件':
          return 'teal'; // 验收文件 - 青色
        case '结题文件':
          return 'amber'; // 结题文件 - 琥珀色
        case '知识产权':
          return 'cyan'; // 知识产权 - 青色
        case '论文':
          return 'flame'; // 论文 - 火焰色
        case '专利':
          return 'purple'; // 专利 - 紫色
        case '软著':
          return 'amber'; // 软著 - 琥珀色
        case '标准':
          return 'blue'; // 标准 - 蓝色
        case '示范应用':
          return 'success'; // 示范应用 - 绿色
        case '获奖':
          return 'danger'; // 获奖 - 红色
        case '报告':
          return 'purple'; // 报告 - 紫色
        case '专家咨询':
          return 'info'; // 专家咨询 - 蓝色
        case '经费变更':
          return 'cyan'; // 经费变更 - 青色
        case '人员变更':
          return 'deep-blue'; // 人员变更 - 深蓝色
        case '批复文件':
          return 'teal'; // 批复文件 - 青色
        case '通知':
          return 'flame'; // 通知 - 火焰色
        case '合同':
          return 'default'; // 合同 - 默认灰色
        default:
          return 'default'; // 默认为蓝色
      }
    },
    getTextColor(typeId) {
      // 根据标签类型返回不同的字体颜色
      switch (typeId) {
        case '其他':
          return '#999'; // 灰色
        case '申报书':
          return '#f50'; // 红色
        case '任务书':
          return '#2db7f5'; // 蓝色
        case '科研协作合同':
          return '#87d068'; // 绿色
        case '专项经费文件':
          return '#eb2f96'; // 紫红色
        case '经费管理表':
          return '#ff6600'; // 橙色
        case '中期文件':
          return '#722ed1'; // 紫色
        case '验收文件':
          return '#1890ff'; // 深蓝色
        case '结题文件':
          return '#52c41a'; // 青绿色
        case '知识产权':
          return '#fa8c16'; // 琥珀色
        case '论文':
          return '#13c2c2'; // 青色
        case '专利':
          return '#fa541c'; // 火焰色
        case '软著':
          return '#722ed1'; // 紫色
        case '标准':
          return '#fa8c16'; // 琥珀色
        case '示范应用':
          return '#2db7f5'; // 蓝色
        case '获奖':
          return '#87d068'; // 绿色
        case '报告':
          return '#f50'; // 红色
        case '专家咨询':
          return '#722ed1'; // 紫色
        case '经费变更':
          return '#eb2f96'; // 紫红色
        case '人员变更':
          return '#13c2c2'; // 青色
        case '批复文件':
          return '#1890ff'; // 深蓝色
        case '通知':
          return '#52c41a'; // 青绿色
        case '合同':
          return '#108ee9'; // 默认蓝色
        default:
          return '#999'; // 默认灰色
      }
    },
    // 表单重置
    reset() {
      this.form = {
        projectId: this.projectId,
        milestoneTitle: '',
        milestoneRemark: '',
        milestoneDate: '',
        ossIds: [],
      };
      this.ossids = [];
      this.fileList = [];
      this.selectedTag = ''; // 重置选择的标签
      this.projectMilestoneTypes = []; // 重置动态标签列表
    },
  },
  // 监听projectId的变化
  watch: {
    projectId() {
      this.reset(); // projectId变化时重置表单
    }
  },
  mounted() {
    this.milestoneCategorySelectList();
  }
};
</script>

<style>
.el-tag+.el-tag {
  margin-left: 10px;
  margin-right: 10px;
}

.button-new-tag {
  margin-left: 10px;
  height: 32px;
  line-height: 30px;
  padding-top: 0;
  padding-bottom: 0;
}

.tag-container {
  display: flex;
}

.selected-tags {
  margin-left: -80px;
  margin-top: -1px;
}
</style>
