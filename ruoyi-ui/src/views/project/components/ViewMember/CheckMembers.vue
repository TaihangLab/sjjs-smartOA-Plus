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
                    <el-table-column label="项目任务书编号" :resizable="false" align="center" prop="projectAssignmentSerialNo"
                                     width="130">
                    </el-table-column>
                    <el-table-column label="项目名称" :resizable="false" align="center" prop="assignedSubjectName" width="150">
                    </el-table-column>
                    <el-table-column label="负责课题" :resizable="false" align="center" prop="assignedSubjectSection" width="150">
                    </el-table-column>
                    <el-table-column label="项目牵头单位" :resizable="false" align="center" prop="leadingUnit" width="180">
                    </el-table-column>
                    <el-table-column label="项目级别" :resizable="false" align="center" prop="projectLevel" width="110">
                    </el-table-column>
                    <el-table-column label="项目推进情况" :resizable="false" align="center" prop="projectProgressStatus" width="150">
                    </el-table-column>
                    <el-table-column label="立项时间" :resizable="false" align="center" prop="projectEstablishTime" width="170">
                    </el-table-column>
                    <el-table-column label="项目计划验收时间" :resizable="false" align="center" prop="projectScheduledCompletionTime" width="170">
                    </el-table-column>
                </el-table>
            </el-collapse-item>
            <el-collapse-item name="2">
                <template slot="title">
                    <span>当前参与的省部级项目详情</span>
                </template>
                <el-table ref="multipleTable" :data="this.projectListLook.provincialProjectBaseInfos" border style="width: 100%" :row-style="{ height: '50px' }"
                          :cell-style="{ padding: '0px' }">
                    <el-table-column label="项目任务书编号" :resizable="false" align="center" prop="projectAssignmentSerialNo"
                                     width="130">
                    </el-table-column>
                    <el-table-column label="项目名称" :resizable="false" align="center" prop="assignedSubjectName" width="150">
                    </el-table-column>
                    <el-table-column label="负责课题" :resizable="false" align="center" prop="assignedSubjectSection" width="150">
                    </el-table-column>
                    <el-table-column label="项目牵头单位" :resizable="false" align="center" prop="leadingUnit" width="180">
                    </el-table-column>
                    <el-table-column label="项目级别" :resizable="false" align="center" prop="projectLevel" width="110">
                    </el-table-column>
                    <el-table-column label="项目推进情况" :resizable="false" align="center" prop="projectProgressStatus" width="150">
                    </el-table-column>
                    <el-table-column label="立项时间" :resizable="false" align="center" prop="projectEstablishTime" width="170">
                    </el-table-column>
                    <el-table-column label="项目计划验收时间" :resizable="false" align="center" prop="projectScheduledCompletionTime" width="170">
                    </el-table-column>
                </el-table>
            </el-collapse-item>
            <el-collapse-item name="3">
                <template slot="title">
                    <span>当前参与的自研项目详情</span>
                </template>
                <el-table ref="multipleTable" :data="this.projectListLook.enterpriseProjectBaseInfos" border style="width: 100%" :row-style="{ height: '50px' }"
                          :cell-style="{ padding: '0px' }">
                    <el-table-column label="项目任务书编号" :resizable="false" align="center" prop="projectAssignmentSerialNo"
                                     width="130">
                    </el-table-column>
                    <el-table-column label="项目名称" :resizable="false" align="center" prop="assignedSubjectName" width="150">
                    </el-table-column>
                    <el-table-column label="负责课题" :resizable="false" align="center" prop="assignedSubjectSection" width="150">
                    </el-table-column>
                    <el-table-column label="项目牵头单位" :resizable="false" align="center" prop="leadingUnit" width="180">
                    </el-table-column>
                    <el-table-column label="项目级别" :resizable="false" align="center" prop="projectLevel" width="110">
                    </el-table-column>
                    <el-table-column label="项目推进情况" :resizable="false" align="center" prop="projectProgressStatus" width="150">
                    </el-table-column>
                    <el-table-column label="立项时间" :resizable="false" align="center" prop="projectEstablishTime" width="170">
                    </el-table-column>
                    <el-table-column label="项目计划验收时间" :resizable="false" align="center" prop="projectScheduledCompletionTime" width="170">
                    </el-table-column>
                </el-table>
            </el-collapse-item>
        </el-collapse>
    </div>
</template>

<script>
import request from "@/utils/request";

export default {
    props: {
        memberid: {
            type: Number,
            required: true,
        },
    },
    data() {
        return {
            contentStyle: {
                'text-align': 'center',
                'width': '60%',
            },
            //label样式
            activeNames: ['0'],
            labelStyle: { 'color': '#000', 'width': '30%', },
            params:{
                userId: undefined,
            },
            projectListLook: undefined,
        };
    },
    created() {
        this.cheakproject();
    },
    watch: {
        memberid: {
            handler(newVal) {
                // 监听到memberid变化时，重新获取项目详情数据
                this.params.userId = newVal;
                this.activeNames = ['0'];
                this.cheakproject();
            },
            immediate: true, // 立即执行一次
        },
    },
    methods: {
        cheakproject() {
            this.params.userId = this.$props.memberid;
            request({
                url: '/project/user/getDetails',
                method: 'get',
                params: this.params,
            })
                .then((resp) => {
                    this.projectListLook = resp.data;
                    console.log('项目', this.projectListLook);
                })
                .catch((error) => {
                    console.error('获取数据时出错：', error);
                });
        },
    },
};
</script>
<style>
.el-descriptions .el-descriptions__label {
    width: 300px;
    /* 替换为你希望的宽度值 */
}
</style>
