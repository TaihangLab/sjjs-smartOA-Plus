<template>
  <el-card header="项目信息" shadow="hover">
    <el-form :model="form" ref="form" label-position="left">

      <el-divider content-position="left">
        经费总额：
        <el-tag effect="plain" type="warning">{{ jfze }}</el-tag>
        万元
      </el-divider>

      <el-divider content-position="left">
        专项直接X：
        <el-tag effect="plain" type="warning">{{ zxXY[0] }}</el-tag>
        万元
        专项间接Y：
        <el-tag effect="plain" type="warning">{{ zxXY[1] }}</el-tag>
        万元
      </el-divider>

      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label-width="100px" label="专项经费总额">
            <el-input v-model.number="$props.form.zxjfze" type="number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label-width="100px" label="专项设备费">
            <el-input v-model.number="$props.form.zxsbf" type="number"></el-input>
          </el-form-item>
        </el-col>
      </el-row>


      <el-row :gutter="20">
        <el-col :span="12">
          <el-form-item label-width="100px" label="自筹经费总额">
            <el-input v-model.number="$props.form.zcjfze" type="number"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label-width="100px" label="自筹设备费">
            <el-input v-model.number="$props.form.zcsbf" type="number"></el-input>
          </el-form-item>
        </el-col>
      </el-row>


    </el-form>
  </el-card>

</template>


<script>
export default {
  props: ['form'],
  data() {
    return {}
  },
  created() {
    this.$props.form.jfze = 0

  },
  methods: {
    computeXY(ze, sbf) {
      let res = [0, 0];
      if (ze - sbf <= 500) {
        res[0] = (ze + sbf * 0.3) / 1.3;
        res[1] = (res[0] - sbf) * 0.3;
      } else if (ze - sbf <= 1000) {
        res[0] = (ze - 500 * 0.3 + 500 * 0.25 + 0.25 * sbf) / 1.25;
        res[1] = 500 * .3 + (res[0] - sbf - 500) * .25;
      } else {
        res[0] = (ze - 500 * 0.3 - 500 * 0.25 + 0.2 * sbf + 0.2 * 1000) / 1.2;
        res[1] = 500 * .3 + 500 * 0.25 + (res[0] - sbf - 1000) * .20;
      }
      return res;
    },

  },

  computed: {
    jfze: {
      get() {
        if (!this.form.zcjfze || !this.form.zxjfze)
          return 0
        return this.form.zcjfze + this.form.zxjfze;
      },
    },
    zxXY: {
      get() {
        if (!this.form.zxjfze || !this.form.zxsbf)
          return [0, 0]
        return this.computeXY(this.form.zxjfze, this.form.zxsbf);
      },

    },

    zcXY() {
      if (!this.form.zcjfze || !this.form.zcsbf)
        return [0, 0]
      return this.computeXY(this.form.zcjfze, this.form.zcsbf);
    },


  },
  watch: {
    jfze: {
      handler(newv, oldv) {
        this.$props.form.jfze = newv;
        console.log("prop.jfze", this.form.jfze);
      },
      deep: true,
    },
  }

}
</script>
