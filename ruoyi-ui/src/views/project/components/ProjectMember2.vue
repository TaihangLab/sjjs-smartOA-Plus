<template>
    <el-card header="项目成员" shadow="hover">
        <el-form :model="form" ref="form" label-position="left">
            <el-row
                @mouseover.native="$set(isButtonShowList, index, true)"
                @mouseleave.native="$set(isButtonShowList, index, false)"
                v-for="(item, index) in form.items"
                :key="index"
                justify="center"
                type="flex">

                <el-col :span="1"  class="text-center">
                    <el-button icon="el-icon-circle-plus" circle type="success" plain @click="add"
                               v-show="index===form.items.length-1 && isButtonShowList[index]"></el-button>
                </el-col>

                <el-col :span="10">
                    <el-form-item label-width="80px" label="项目成员" prop="id">
                        <el-cascader
                            v-model="item.id"
                            :options="cascaderOptions"
                            clearable
                            :props="{ expandTrigger: 'hover', emitPath: false }"
                            placeholder="请选择项目成员"
                            style="width: 25vw"


                        ></el-cascader>
                    </el-form-item>
                </el-col>

                <el-col :span="8">
                    <el-form-item label-width="80px" label="成员角色" prop="role">
                        <el-select v-model="item.role" multiple placeholder="请选择" @change="$forceUpdate()"
                        style="width: 23vw;"
                        >
                            <el-option
                                v-for="item in roleOptions"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value">
                            </el-option>
                        </el-select>
                    </el-form-item>

                </el-col>
                <el-col :span="1" style="text-align: center;">
                    <el-button icon="el-icon-remove" circle type="danger" plain @click="remove(index)" v-show="form.items.length!==1&&isButtonShowList[index]"></el-button>
                </el-col>
            </el-row>
        </el-form>



    </el-card>
</template>

<script setup>

import {getCurrentInstance, onMounted, reactive, ref} from "vue";
import {listUser, deptTreeSelect} from "@/api/system/user";

const { proxy } = getCurrentInstance();
const props = defineProps(["form"]);
defineExpose({
    reset,
})


const roleOptions = [{label:"项目负责人", value:'0'},{label:"公司负责人", value:'1'},{label:"部门负责人", value:'2'},{label:"科研管理负责人", value:'3'},{label:"普通成员", value:'4'},]


onMounted(()=>{
    proxy.$set(props.form, "items", [{id: '', role: ''}]);
})

const isButtonShowList = ref([false]);
const id = ref(1);
const list = ref([]);

// 新增一条
function add() {
    props.form.items.push({
        id: '', role: ''
    });
    isButtonShowList.value.push(false);
    // $forceUpdate();
}
// 删除一条
function remove(index) {
    props.form.items.splice(index, 1);
    isButtonShowList.value.splice(index, 1);
}

// 重置表单
function reset() {
    proxy.$set(props.form, "items", [{id: undefined, role: []}])
    // props.form.items = [{id: undefined, role: []}];
    proxy.$forceUpdate();
}



// 用户级联下拉框
const member = ref("");
let cascaderOptions = ref([]);
let deptData = ref({});
let userList = ref([]);

async function getDeptAndUserList() {
    // 等待部门数据加载完成
    const deptResp = await deptTreeSelect();
    let deptData = deptResp.data;

    //  等待用户数据加载完成
    const userResp = await listUser();
    userList.value = userResp.rows;

    cascaderOptions.value = adaptData(deptData);
}
getDeptAndUserList();
function adaptData(data) {
    return data.map(item => {
        const newItem = {
            value: item.id,
            label: item.label,
            children: []
        };
        if (item.children && item.children.length > 0) {
            newItem.children = adaptData(item.children);
        } else {
            const usersInDept = userList.value.filter(user => user.deptId === item.id);
            newItem.children = adaptUserData(usersInDept);
        }
        return newItem;
    });
}
function adaptUserData(data) {
    return data.map(item => {
        return {
            value: item.userId,
            label: item.nickName,
        };
    });
}


</script>
<style scoped>
.el-button {
    border: none;
    padding: 0;
    font-size: 2rem;
}


:deep(i) {

}
</style>
