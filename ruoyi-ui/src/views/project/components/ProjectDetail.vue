<template>
    <div>
        <div class="sticky-container" v-if="projectdetails">
            <el-tabs v-model="activeName">
                <el-tab-pane label="基本信息" name="first">
                    <div style="margin-top: 10px;"></div>
                    <el-descriptions-item label="基本信息" :span="2"></el-descriptions-item>
                    <el-descriptions class="margin-top" title="" :column="2" :size="size" :labelStyle="{ width: '19%' }"
                        :contentStyle="{ width: '32%' }" border>
                        <el-descriptions-item label="项目名称">{{
                            this.projectdetails.projectInfoVO.assignedSubjectName
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目任务书编号">{{
                            this.projectdetails.projectInfoVO.projectAssignmentSerialNo
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="负责课题">{{
                            this.projectdetails.projectInfoVO.assignedSubjectSection
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="课题任务书编号">{{
                            this.projectdetails.projectInfoVO.subjectAssignmentSerialNo
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目牵头单位">{{
                            this.projectdetails.projectInfoVO.leadingUnit
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="是否牵头单位">{{
                            this.hasLeading[this.projectdetails.projectInfoVO.hasLeadingRole]
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目负责人" v-if="this.projectLeaders">{{
                            this.projectdetails.projectInfoVO.projectLeader
                            }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目专员/联系人">{{
                            this.projectdetails.projectInfoVO.projectContact
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目级别">{{
                            this.projectLevel[this.projectdetails.projectInfoVO.projectLevel]
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目来源">{{
                            this.projectdetails.projectInfoVO.projectSource
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="立项时间">{{
                            this.projectdetails.projectInfoVO.projectEstablishTime
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目计划验收时间">{{
                            this.projectdetails.projectInfoVO.projectScheduledCompletionTime
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目执行时间（年）">{{
                            this.projectdetails.projectInfoVO.projectDuration
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目推进情况">{{
                            this.projectProgressStatus[this.projectdetails.projectInfoVO.projectProgressStatus]
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="合作单位">{{
                            this.projectdetails.projectInfoVO.collaboratingUnit
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="涉及专家、团队">{{
                            this.projectdetails.projectInfoVO.expertTeam
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="项目经费总额">{{
                            this.projectdetails.projectFundsVO.totalFundsAll
                        }}
                        </el-descriptions-item>
<!--                        <el-descriptions-item>{{ }}</el-descriptions-item>-->
                        <el-descriptions-item label="专项经费">{{
                            this.projectdetails.projectFundsVO.totalFundsZx
                        }}
                        </el-descriptions-item>
                        <el-descriptions-item label="自筹经费">{{
                            this.projectdetails.projectFundsVO.totalFundsZc
                        }}
                        </el-descriptions-item>
                    </el-descriptions>
                    <el-collapse v-model="activeNames">
                        <el-collapse-item style="font-size: 20px;" name="2">
                            <template slot="title">
                                <span style="font-size: 14px;">项目简介</span>
                            </template>
                            <div class="unselectable-textbox" style="font-size: 14px; color: #606266;">
                                {{ projectdescription }}
                            </div>
                        </el-collapse-item>
                    </el-collapse>
                </el-tab-pane>
                <el-tab-pane label="项目计划" name="second">
                    <ProjectPlan :projectplan="this.projectdetails.projectPlanVOList"></ProjectPlan>
                </el-tab-pane>
                <el-tab-pane label="项目指标" name="third">
                    <ProjectIndicators :projectTarget="this.projectdetails.projectTargetVOList"></ProjectIndicators>
                </el-tab-pane>
                <el-tab-pane label="项目成员" name="fourth">
                    <Member :projectid="formLook.projectId.toString()" />
                </el-tab-pane>
                <el-tab-pane label="项目经费" name="fifth">
                    <FundsDetail :projectfund="this.projectdetails.projectFundsVO"></FundsDetail>
                </el-tab-pane>
                <el-tab-pane label="项目申报附件" name="sixth">
                    <Projectfile :projectfile="this.projectdetails.projectAttachmentVOList"></Projectfile>
                </el-tab-pane>
                <el-tab-pane label="项目推进情况" name="seventh">
                    <ProjectProgress :projectDetails="this.projectdetails"></ProjectProgress>
                </el-tab-pane>
            </el-tabs>
        </div>
    </div>
</template>

<script>
import FundsDetail from "./ViewProject/Funds.vue";
import Member from "./ViewProject/Member.vue";
import ProjectPlan from "./ViewProject/ProjectPlan.vue";
import ProjectIndicators from "./ViewProject/ProjectIndicators.vue";
import request from '@/utils/request';
import Projectfile from "./ViewProject/Projectfile.vue";
import ProjectProgress from "@/views/project/components/ViewProject/ProjectProgress.vue";

export default {
    name: "ProjectDetail",
    components: {
        ProjectProgress,
        Projectfile,
        Member,
        FundsDetail,
        ProjectPlan,
        ProjectIndicators
    },
    props: {
        formLook: {
            type: Object,
            required: true,
        },
    },
    data() {
        return {
            hasLeading: {
                0: '否',
                1: '是',
            },
            projectLevel: {
                0: '国家级',
                1: '省部级',
                2: '企业级',
            },
            projectProgressStatus: {
                0: '正在需求申报',
                1: '已完成需求申报',
                2: '正在项目申报',
                3: '已完成项目申报',
                4: '已签订任务书并推进中',
                5: '已完成中期评审',
                6: '已完成验收',
                7: '未通过评审',
            },
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
            activeNames: [],
            projectdetails: undefined,
            projectdescription: undefined,
            projectLeaders: undefined,
        };
    },
    watch: {
        'formLook.projectId': {
            handler(newProjectId, oldProjectId) {
                this.activeName = 'first';
                this.projectdetail(); // 确保在属性变化时调用获取详情的方法
            },
            deep: true,
            immediate: true
        },
    },
    methods: {
        projectdetail() {
            this.activeNames = [];
            const loading = this.$loading({
                lock: true,
                text: '努力加载中',
                spinner: 'el-icon-loading',
                fullscreen: true,
                background: 'rgba(200, 200, 200, 1)'
            });
            // 使用正确的用户列表接口，假设接口为 /user/list
            request({
                url: '/project/list/getDetails',
                method: 'get',
                params: {
                    projectId: this.$props.formLook.projectId,
                },
            })
                .then((resp) => {
                    // 处理获取的用户数据
                    this.projectdetails = resp.data;
                    this.projectdescription = this.projectdetails.projectInfoVO.projectDescription;
                    this.projectLeaders = this.projectdetails.projectUserVoList.find(member => member.projectUserRoles.includes("0"));
                    loading.close();
                })
                .catch((error) => {
                    console.error('获取用户数据时出错：', error);
                    loading.close();
                });
        },
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
    },
};
</script>

<style>
.sticky-container {
    position: sticky;
    top: 0;
    z-index: 1000;
    /* 使容器在最上层 */
    background-color: #fff;
    /* 设置容器背景颜色 */
}

.unselectable-textbox {
    -webkit-user-select: none;
    /* Safari 3.1+ */
    -moz-user-select: none;
    /* Firefox 2+ */
    -ms-user-select: none;
    /* IE 10+ */
    user-select: none;
    /* Standard syntax */
    /* 添加其他样式以模拟文本框的外观 */
    border: 1.5px solid #dcdfe6;
    padding: 20px;
    color: #606266;
    line-height: 1.5;
    border-radius: 4px;
}
</style>

