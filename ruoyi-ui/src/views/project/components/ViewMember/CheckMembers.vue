<template>
    <div>
        <div style="margin-top: 10px;"></div>
        <el-collapse  v-model="activeNames">
            <el-collapse-item name="1">
                <template slot="title">
                    <span>当前参与的国家级项目详情</span>
                </template>
                <el-table ref="multipleTable" :data="this.projectListLook.nationProjectBaseInfos" border style="width: 100%" :row-style="{ height: '50px' }"
                          :cell-style="{ padding: '0px' }">
                    <el-table-column label="项目任务书编号" :resizable="false" align="center" prop="projectAssignmentSerialNo">
                    </el-table-column>
                    <el-table-column label="项目名称" :resizable="false" align="center" prop="assignedSubjectName">
                    </el-table-column>
                    <el-table-column label="负责课题" :resizable="false" align="center" prop="assignedSubjectSection">
                    </el-table-column>
                    <el-table-column label="项目牵头单位" :resizable="false" align="center" prop="leadingUnit">
                    </el-table-column>
                    <el-table-column label="立项时间" :resizable="false" align="center" prop="projectEstablishTime">
                    </el-table-column>
                    <el-table-column label="项目计划验收时间" :resizable="false" align="center" prop="projectScheduledCompletionTime">
                    </el-table-column>
                </el-table>
            </el-collapse-item>
            <el-collapse-item name="2">
                <template slot="title">
                    <span>当前参与的省部级项目详情</span>
                </template>
                <el-table ref="multipleTable" :data="this.projectListLook.provincialProjectBaseInfos" border style="width: 100%" :row-style="{ height: '50px' }"
                          :cell-style="{ padding: '0px' }">
                    <el-table-column label="项目任务书编号" :resizable="false" align="center" prop="projectAssignmentSerialNo">
                    </el-table-column>
                    <el-table-column label="项目名称" :resizable="false" align="center" prop="assignedSubjectName">
                    </el-table-column>
                    <el-table-column label="负责课题" :resizable="false" align="center" prop="assignedSubjectSection">
                    </el-table-column>
                    <el-table-column label="项目牵头单位" :resizable="false" align="center" prop="leadingUnit">
                    </el-table-column>
                    <el-table-column label="立项时间" :resizable="false" align="center" prop="projectEstablishTime">
                    </el-table-column>
                    <el-table-column label="项目计划验收时间" :resizable="false" align="center" prop="projectScheduledCompletionTime">
                    </el-table-column>
                </el-table>
            </el-collapse-item>
            <el-collapse-item name="3">
                <template slot="title">
                    <span>当前参与的自研项目详情</span>
                </template>
                <el-table ref="multipleTable" :data="this.projectListLook.enterpriseProjectBaseInfos" border style="width: 100%" :row-style="{ height: '50px' }"
                          :cell-style="{ padding: '0px' }">
                    <el-table-column label="项目任务书编号" :resizable="false" align="center" prop="projectAssignmentSerialNo">
                    </el-table-column>
                    <el-table-column label="项目名称" :resizable="false" align="center" prop="assignedSubjectName" >
                    </el-table-column>
                    <el-table-column label="负责课题" :resizable="false" align="center" prop="assignedSubjectSection" >
                    </el-table-column>
                    <el-table-column label="项目牵头单位" :resizable="false" align="center" prop="leadingUnit" >
                    </el-table-column>
                    <el-table-column label="立项时间" :resizable="false" align="center" prop="projectEstablishTime" >
                    </el-table-column>
                    <el-table-column label="项目计划验收时间" :resizable="false" align="center" prop="projectScheduledCompletionTime" >
                    </el-table-column>
                </el-table>
            </el-collapse-item>
        </el-collapse>
    </div>
</template>

<script>
import request from "@/utils/request";

export default {
    props: ['memberid'],
    data() {
        return {
            contentStyle: {
                'text-align': 'center',
                'width': '60%',
            },
            //label样式
            activeNames: ['1','2','3'],
            labelStyle: { 'color': '#000', 'width': '30%', },
            params:{
                userId: undefined,
            },
            projectListLook: [],
        };
    },
    created() {
        this.checkProject();
    },
    watch: {
        memberid: {
            handler(newVal) {
                // 监听到memberid变化时，重新获取项目详情数据
                this.params.userId = newVal;
                this.checkProject();
            },
            immediate: true, // 立即执行一次
        },
    },
    methods: {
        checkProject() {
            this.params.userId = this.$props.memberid;
            request({
                url: '/project/user/getDetails',
                method: 'get',
                params: this.params,
            })
                .then((resp) => {
                    this.projectListLook = resp.data;
                })
                .catch((error) => {
                    console.error('获取数据时出错：', error);
                });
        },
    },
};
</script>

