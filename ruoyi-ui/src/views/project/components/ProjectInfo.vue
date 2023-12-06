<template>
  <el-card header="项目信息" shadow="hover">
    <el-form :model="form" ref="form" label-position="left">
      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label-width="100px" label="项目名称" prop="name">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
        </el-col>
      <el-col :span="12">
        <el-form-item label-width="100px" label="项目负责人" prop="name">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
      </el-col>

      </el-row>

      <el-form-item label-width="100px" label="立项时间" prop="time">
        <el-date-picker
            v-model="form.time"
            type="date"
            value-format="yyyy-MM-dd">
        </el-date-picker>
      </el-form-item>
      <el-form-item label-width="100px" label="项目周期" prop="time">
        <el-date-picker
            v-model="form.time"
            type="daterange"
            value-format="yyyy-MM-dd"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期">
        </el-date-picker>
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
