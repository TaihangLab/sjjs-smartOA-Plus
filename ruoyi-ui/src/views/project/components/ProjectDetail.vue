<template>
    <div>
        <div class="sticky-container">
            <el-tabs v-model="activeName">
                <el-tab-pane label="基本信息" name="first">
                    <div style="margin-top: 10px;"></div>
                    <el-descriptions class="margin-top" title="" :column="1" :size="size" :labelStyle="{ width: '18%' }"
                        :contentStyle="{ width: '82%' }" border>
                        <el-descriptions-item label="项目牵头单位">
                            {{ formLook.leadingUnit }}
                        </el-descriptions-item>
                    </el-descriptions>
                    <el-descriptions class="margin-top" title="" :column="2" :size="size" :labelStyle="{ width: '18%' }"
                        :contentStyle="{ width: '35%' }" border>
                        <el-descriptions-item label="承担课题名称">
                            {{ formLook.assignedSubjectSection }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目任务书编号">
                            {{ formLook.projectAssignmentSerialNo }}
                        </el-descriptions-item>
                        <el-descriptions-item label="级别（国家级、省级、企业项目）">
                            {{ formLook.projectLevel }}
                        </el-descriptions-item>
                        <el-descriptions-item label="负责课题">
                            {{ formLook.assignedSubjectSection }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目推进情况">
                            {{ formLook.projectProgressStatus }}
                        </el-descriptions-item>
                        <el-descriptions-item label="合作单位">
                            {{ formLook.hasCooperativeUnit }}
                        </el-descriptions-item>
                        <el-descriptions-item label="立项时间">
                            {{ formLook.projectEstablishTime }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目计划验收时间">
                            {{ formLook.projectScheduledCompletionTime }}
                        </el-descriptions-item>
                        <el-descriptions-item>
                            <template slot="label">
                                <i class="el-icon-office-building"></i>
                                结项日期
                            </template>

                        </el-descriptions-item>
                        <el-descriptions-item>
                            <template slot="label">
                                <i class="el-icon-office-building"></i>
                                批准经费
                            </template>

                        </el-descriptions-item>
                        <el-descriptions-item>
                            <template slot="label">
                                <i class="el-icon-office-building"></i>
                                成果形式
                            </template>

                        </el-descriptions-item>
                        <el-descriptions-item>
                            <template slot="label">
                                <i class="el-icon-office-building"></i>
                                备注
                            </template>

                        </el-descriptions-item>
                    </el-descriptions>
                    <el-radio-group v-model="size">
                    </el-radio-group>
                    <el-descriptions class="margin-top" name="first" :column="2" :size="size" :border="border">
                        <template slot="title">
                            <span style="font-size: 15px; font-weight: 450;">详细信息</span>
                        </template>
                        <template slot="extra">
                            <el-switch v-model="toggleDetails" active-color="#13ce66" inactive-color="#ff4949" />
                        </template>
                        <!-- 其他详细信息项，使用 v-if 控制显示/隐藏 -->
                        <el-descriptions-item v-if="toggleDetails" label="统计归属">kooriookami</el-descriptions-item>
                        <el-descriptions-item v-if="toggleDetails" label="统计年度">18100000000</el-descriptions-item>
                        <el-descriptions-item v-if="toggleDetails" label="一级学科">苏州市</el-descriptions-item>
                        <el-descriptions-item v-if="toggleDetails" label="社会经济目标">学校</el-descriptions-item>
                        <el-descriptions-item v-if="toggleDetails" label="项目来源">江苏省苏州市吴中区吴中大道 1188 号</el-descriptions-item>
                        <el-descriptions-item v-if="toggleDetails" label="研究类别">江苏省苏州市吴中区吴中大道 1188 号</el-descriptions-item>
                        <el-descriptions-item v-if="toggleDetails" label="合作形式">江苏省苏州市吴中区吴中大道 1188 号</el-descriptions-item>
                        <el-descriptions-item v-if="toggleDetails" label="国民经济行业">江苏省苏州市吴中区吴中大道 1188
                            号</el-descriptions-item>
                    </el-descriptions>
                </el-tab-pane>
                <el-tab-pane label="项目计划" name="second">
                    
                </el-tab-pane>
                <el-tab-pane label="项目指标" name="third">
                    
                </el-tab-pane>
                <el-tab-pane label="项目成员" name="fourth">
                    <Member :projectid="formLook.projectId"/>
                </el-tab-pane>
                <el-tab-pane label="项目经费" name="fifth">
                    <FundsDetail></FundsDetail>
                </el-tab-pane>
                <!-- <el-tab-pane label="项目来源" name="fifth">
                    <MoneySource></MoneySource>
                </el-tab-pane> -->
            </el-tabs>
        </div>
    </div>
</template>

<script>
import FundsDetail from "./ViewProject/Funds.vue";
import MoneySource from "./ViewProject/MoneySource.vue";
import Member from "./ViewProject/Member.vue";

export default {
    name: "ProjectDetail",
    components: {
        Member,
        FundsDetail,
        MoneySource,
    },
    props: {
        formLook: {
            type: Object,
            required: true,
        },
    },
    data() {
        return {
            rowCenter: {
                "text-align": "center"
            },
            size: '',
            border: true,
            toggleDetails: false, // 控制详细信息项的显示/隐藏
            pageIndex: 1,
            pageSize: 10,
            totalPage: 0,
            begin: 0,
            end: this.pageSize - 1,
            dialogFormVisible: false, //默认关闭新建用户界面
            dialogFormVisibleChange: false, //默认关闭编辑用户界面
            dialogFormVisibleLook: false,
            dataListFrom: "getDataList",//当前数据来源于搜索还是全局
            activeName: 'first',
        };
    },
    methods: {
        //改变数组大小 
        sizeChangeHandle(val) {
            this.pageSize = val;
            this.SizeOrCurrentChangeAfter();
        },
        //改变当前页号
        CurrentChangeHandle(val) {
            this.pageIndex = val;
            this.SizeOrCurrentChangeAfter();
        },
        //在更改数组大小或者页号前，判断数据来源
        SizeOrCurrentChangeAfter() {
            if (this.dataListFrom === "getDataList")
                this.getDataList();
            else this.getDataListByName();
        },
    },
    mounted() {
        console.log('formLook:', this.formLook);
        this.getDataList();
    },
};
</script>

<style>
.sticky-container {
  position: sticky;
  top: 0;
  z-index: 1000; /* 使容器在最上层 */
  background-color: #fff; /* 设置容器背景颜色 */
}
</style>