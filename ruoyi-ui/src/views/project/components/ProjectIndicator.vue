<template>
  <el-card header="项目指标" shadow="hover">

    <el-form :model="form" ref="form" label-position="left">
      <el-row
          @mouseover.native="$set(isButtonShowList, index, true)"
          @mouseleave.native="$set(isButtonShowList, index, false)"
          v-for="(item, index) in form.items"
          :key="index"
          justify="center"
          :gutter="10"
          type="flex">

        <el-col :span="1" style="text-align: center;" >
          <el-button icon="el-icon-circle-plus" circle type="success" plain @click="add"
                     v-show="index===form.items.length-1 && isButtonShowList[index]"></el-button>
        </el-col>

        <el-col :span="6">
          <el-form-item label-width="80px" label="指标名称">
            <el-input v-model="item.title" @input="input"></el-input>
          </el-form-item>
        </el-col>

        <el-col :span="8">
          <el-form-item label-width="120px" label="中期指标值/状态">
            <el-input
                @input="input"
                type="textarea"
                :autosize="{ minRows: 1, maxRows: 4}"
                maxlength="500"
                show-word-limit
                v-model="item.midterm">
            </el-input>
          </el-form-item>
        </el-col>

          <el-col :span="8">
              <el-form-item label-width="120px" label="完成指标值/状态">
                  <el-input
                      @input="input"
                      type="textarea"
                      :autosize="{ minRows: 1, maxRows: 4}"
                      maxlength="500"
                      show-word-limit
                      v-model="item.finish">
                  </el-input>
              </el-form-item>
          </el-col>



        <el-col :span="1" style="text-align: center;">
          <el-button icon="el-icon-remove" circle type="danger" plain @click="remove(index)" v-show="form.items.length!==1&&isButtonShowList[index]"></el-button>

        </el-col>
      </el-row>

    </el-form>

  </el-card>
</template>


<script>
import Vue from "vue";

export default {
  props: ['form'],
  data() {
    return {
      isButtonShowList: [false],
      id: 1,
      list: [],

    }
  },
  mounted() {
    Vue.set(this.$props.form, "items", [{title: undefined, midterm: '', finish:''}]);
  },
  methods: {
    add() {
      this.$props.form.items.push({
        title: '', midterm: '', finish:''
      });
      this.isButtonShowList.push(false);
      this.$forceUpdate();
    },
    remove(index) {
      this.$props.form.items.splice(index, 1);
      this.isButtonShowList.splice(index, 1);
      this.$forceUpdate();
    },
    input() {
      this.$forceUpdate();
    }
  },


}
</script>

<style scoped>
.el-button {
  border: none;
  padding: 0;
  font-size: 2rem;
}

:deep(.el-icon-circle-plus) {

}
</style>
