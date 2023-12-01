<template>
  <el-card header="项目指标" shadow="hover">

    <el-form :model="form" ref="form" label-position="left">
      <el-row
          @mouseover.native="$set(isButtonShowList, index, true)"
          @mouseleave.native="$set(isButtonShowList, index, false)"
          v-for="(item, index) in form.items"
          :key="index"
          justify="center"
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

        <el-col :span="15" :offset="1">
          <el-form-item label-width="80px" label="指标描述">
            <el-input
                @input="input"
                type="textarea"
                :autosize="{ minRows: 1, maxRows: 4}"
                maxlength="200"
                show-word-limit
                v-model="item.description">
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
export default {
  props: ['form'],
  data() {
    return {
      isButtonShowList: [false],
      id: 1,
      list: [],

    }
  },
  created() {
    this.$props.form.items = [{title: '', description: ''}]
  },
  methods: {
    add() {
      this.$props.form.items.push({
        title: '', description: ''
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
