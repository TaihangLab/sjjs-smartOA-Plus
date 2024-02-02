import request from "@/utils/request";
import {filterList} from "@/views/project/components/utils";
import Vue from "vue";
import {Loading} from "element-ui";

/**
 * 获取项目列表
 * @param projectInfoForm
 * @param projectMemberForm
 * @param projectFundsForm
 * @param zxFundsDetailForm
 * @param zcFundsDetailForm
 * @param fundsSourceForm
 * @param projectIndicatorForm
 * @param projectPlanForm
 * @param otherAttachmentForm
 * @param projectProgressForm
 * @returns {AxiosPromise}
 */
export function addProject(projectInfoForm,
                           projectMemberForm,
                           projectFundsForm,
                           zxFundsDetailForm,
                           zcFundsDetailForm,
                           fundsSourceForm,
                           projectIndicatorForm,
                           projectPlanForm,
                           otherAttachmentForm,
                           projectProgressForm) {
    /**
     *  项目成员
     */
    const members    = filterList(projectMemberForm.items).map(value => {
        return {userId: value.id, projectUserRoleList: value.role}
    });
    /**
     *  项目指标
     */
    const indicators = filterList(projectIndicatorForm.items, 'title').map(value => {
        return {targetName: value.title, midtermTarget: value.midterm, endTarget: value.finish}
    });
    /**
     *  项目计划
     */
    const plans      = filterList(projectPlanForm.items, "date").map(value => {
        return {stageStartDate: value.date[0], stageEndDate: value.date[1], stageTask: value.task}
    })

    return request({
        url: '/project/my/add', method: 'post', data: {
            "projectBaseInfoBO": {
                /**
                 *  牵头单位
                 */
                "leadingUnit": projectInfoForm.leadingUnit,
                /**
                 *  项目名称
                 */
                "assignedSubjectName": projectInfoForm.name,
                /**
                 *  联系人
                 */
                "projectContact": projectInfoForm.contact,
                /**
                 *  项目编号
                 */
                "projectAssignmentSerialNo": projectInfoForm.projectNumber,
                /**
                 *  项目来源
                 */
                "projectSource": projectInfoForm.source,
                /**
                 *  项目级别
                 */
                "projectLevel": projectInfoForm.level,
                /**
                 *  是否牵头单位
                 */
                "hasLeadingRole": projectInfoForm.isLeadingUnit,
                /**
                 *  课题名称
                 */
                "assignedSubjectSection": projectInfoForm.subjectName,
                /**
                 *  课题编号
                 */
                "subjectAssignmentSerialNo": projectInfoForm.subjectNumber,
                /**
                 *  立项时间
                 */
                "projectEstablishTime": projectInfoForm.startTime,
                /**
                 *  结束时间
                 */
                "projectScheduledCompletionTime": projectInfoForm.endTime,
                /**
                 *  项目周期
                 */
                "projectDuration": projectInfoForm.duration,
                /**
                 *  项目意义和必要性
                 */
                "significanceAndNecessity": projectInfoForm.meaning,
                /**
                 *  项目进展情况
                 */
                "projectProgressStatus": projectProgressForm.projectProgressStatus,
                /**
                 *  项目完成进度
                 */
                "completionProgress": projectProgressForm.completionProgress,
                /**
                 *  合作单位
                 */
                "collaboratingUnit": projectInfoForm.coopUnit,
                /**
                 *  专家团队
                 */
                "expertTeam": projectInfoForm.expertTeam,
                /**
                 *  有无合作单位
                 */
                "hasCooperativeUnit": projectInfoForm.coopUnit ? 1 : 0,
                /**
                 *  项目描述
                 */
                "projectDescription": projectInfoForm.description,
                /**
                 *  获奖情况（项）
                 */
                "awardDetails": projectProgressForm.awardDetails,
                /**
                 *  论文情况（项）
                 */
                "publicationDetails": projectProgressForm.publicationDetails,
                /**
                 *  专利情况
                 */
                "patentDetails": projectProgressForm.patentDetails,
                /**
                 *  软著情况
                 */
                "softwareCopyrightDetails": projectProgressForm.softwareCopyrightDetails,
                /**
                 *  标准情况
                 */
                "standardDetails": projectProgressForm.standardDetails,
            },
            "projectFundsBO"   : {
                /**
                 *  总经费
                 */
                "totalFundsAll": projectFundsForm.jfze,
                /**
                 *  专项到款总额
                 */
                "totalFundsZxDk": projectProgressForm.totalFundsZxDk,
                /**
                 *  已完成自筹投资
                 */
                "zctzDone": projectProgressForm.zctzDone,
                /**
                 *  已完成专项投资
                 */
                "zxtzDone": projectProgressForm.zxtzDone,
                /**
                 *  自筹经费公司配套
                 */
                "zcGspt": projectProgressForm.zcGspt,
                /**
                 *  专项经费公司留存（计划）
                 */
                "zxGslc": projectProgressForm.zxGslc,
                /**
                 *  专项经费总额
                 */
                "totalFundsZx": projectFundsForm.zxjfze,
                /**
                 *  专项经费设备费
                 */
                "sbfZx": projectFundsForm.zxsbf,
                /**
                 *  专项经费直接费
                 */
                "totalFundsZxZj": projectFundsForm.zxzjx,
                /**
                 *  专项经费间接费
                 */
                "totalFundsZxJj": projectFundsForm.zxjjy,
                /**
                 *  自筹经费总额
                 */
                "totalFundsZc": projectFundsForm.zcjfze,
                /**
                 *  自筹经费设备费
                 */
                "sbfZc": projectFundsForm.zcsbf,
                /**
                 *  自筹经费直接费
                 */
                "totalFundsZcZj": projectFundsForm.zczjx,
                /**
                 *  自筹经费间接费
                 */
                "totalFundsZcJj": projectFundsForm.zcjjy,

                /**
                 *  直接专项经费设备费
                 */
                "sbfZxZj": zxFundsDetailForm.sbf_zj,
                /**
                 *  直接自筹经费设备费
                 */
                "sbfZcZj": zcFundsDetailForm.sbf_zj,
                /**
                 *  直接专项经费设备费-购置设备费
                 */
                "sbfGzsbZxZj": zxFundsDetailForm.gzsbf_zj,
                /**
                 *  直接自筹经费设备费-购置设备费
                 */
                "sbfGzsbZcZj": zcFundsDetailForm.gzsbf_zj,
                /**
                 *  直接专项经费设备费-试制设备费
                 */
                "sbfSzsbZxZj": zxFundsDetailForm.szsbf_zj,
                /**
                 *  直接自筹经费设备费-试制设备费
                 */
                "sbfSzsbZcZj": zcFundsDetailForm.szsbf_zj,
                /**
                 *  直接专项经费设备费-设备购置与租赁费
                 */
                "sbfSbgzyzlZxZj": zxFundsDetailForm.sbgzyzlf_zj,
                /**
                 *  直接自筹经费设备费-设备购置与租赁费
                 */
                "sbfSbgzyzlZcZj": zcFundsDetailForm.sbgzyzlf_zj,
                /**
                 *  直接专项经费材料费-材料费
                 */
                "clfZxZj": zxFundsDetailForm.clf_zj,
                /**
                 *  直接自筹经费材料费-材料费
                 */
                "clfZcZj": zcFundsDetailForm.clf_zj,
                /**
                 *  直接专项经费科研活动费-科研活动费
                 */
                "kyhdfZxZj": zxFundsDetailForm.kyhdf_zj,
                /**
                 *  直接自筹经费科研活动费-科研活动费
                 */
                "kyhdfZcZj": zcFundsDetailForm.kyhdf_zj,
                /**
                 *  直接专项经费科研活动费-专利费
                 */
                "kyhdfZlZxZj": zxFundsDetailForm.zlf_zj,
                /**
                 *  直接自筹经费科研活动费-专利费
                 */
                "kyhdfZlZcZj": zcFundsDetailForm.zlf_zj,
                /**
                 *  直接专项经费科研活动费-测试化验加工费
                 */
                "kyhdfCshyjgZxZj": zxFundsDetailForm.cshyjgf_zj,
                /**
                 *  直接自筹经费科研活动费-测试化验加工费
                 */
                "kyhdfCshyjgZcZj": zcFundsDetailForm.cshyjgf_zj,
                /**
                 *  直接专项经费科研活动费-办公费
                 */
                "kyhdfBgZxZj": zxFundsDetailForm.bgf_zj,
                /**
                 *  直接自筹经费科研活动费-办公费
                 */
                "kyhdfBgZcZj": zcFundsDetailForm.bgf_zj,
                /**
                 *  直接专项经费科研活动费-数据样本采集费
                 */
                "kyhdfSjybcjZxZj": zxFundsDetailForm.sjybcjf_zj,
                /**
                 *  直接自筹经费科研活动费-数据样本采集费
                 */
                "kyhdfSjybcjZcZj": zcFundsDetailForm.sjybcjf_zj,
                /**
                 *  直接专项经费科研活动费-印刷出版费
                 */
                "kyhdfYscbZxZj": zxFundsDetailForm.yscbf_zj,
                /**
                 *  直接自筹经费科研活动费-印刷出版费
                 */
                "kyhdfYscbZcZj": zcFundsDetailForm.yscbf_zj,
                /**
                 *  直接专项经费科研活动费-知识产权事务费
                 */
                "kyhdfZscqswZxZj": zxFundsDetailForm.zscqswf_zj,
                /**
                 *  直接自筹经费科研活动费-知识产权事务费
                 */
                "kyhdfZscqswZcZj": zcFundsDetailForm.zscqswf_zj,
                /**
                 *  直接专项经费科研活动费-燃料动力费
                 */
                "kyhdfRldlZxZj": zxFundsDetailForm.rldlf_zj,
                /**
                 *  直接自筹经费科研活动费-燃料动力费
                 */
                "kyhdfRldlZcZj": zcFundsDetailForm.rldlf_zj,
                /**
                 *  直接专项经费科研活动费-车辆使用费
                 */
                "kyhdfClsyZxZj": zxFundsDetailForm.clsyf_zj,
                /**
                 *  直接自筹经费科研活动费-车辆使用费
                 */
                "kyhdfClsyZcZj": zcFundsDetailForm.clsyf_zj,
                /**
                 *  直接专项经费科服务动费-会议会务费
                 */
                "kyfwfZxZj": zxFundsDetailForm.kyfwf_zj,
                /**
                 *  直接自筹经费科服务动费-会议会务费
                 */
                "kyfwfZcZj": zcFundsDetailForm.kyfwf_zj,
                /**
                 *  直接专项经费科服务动费-专家咨询费
                 */
                "kyfwfZjzxZxZj": zxFundsDetailForm.zjzxf_zj,
                /**
                 *  直接自筹经费科服务动费-专家咨询费
                 */
                "kyfwfZjzxZcZj": zcFundsDetailForm.zjzxf_zj,
                /**
                 *  直接专项经费科服务动费-差旅费
                 */
                "kyfwfClZxZj": zxFundsDetailForm.chlf_zj,
                /**
                 *  直接自筹经费科服务动费-差旅费
                 */
                "kyfwfClZcZj": zcFundsDetailForm.chlf_zj,
                /**
                 *  直接专项经费科服务动费-会议会务费
                 */
                "kyfwfHyhwZxZj": zxFundsDetailForm.hyhwf_zj,
                /**
                 *  直接自筹经费科服务动费-会议会务费
                 */
                "kyfwfHyhwZcZj": zcFundsDetailForm.hyhwf_zj,
                /**
                 *  直接专项经费科服务动费-国际合作交流费
                 */
                "kyfwfGjhzjlZxZj": zxFundsDetailForm.gjhzjlf_zj,
                /**
                 *  直接自筹经费科服务动费-国际合作交流费
                 */
                "kyfwfGjhzjlZcZj": zcFundsDetailForm.gjhzjlf_zj,
                /**
                 *  直接专项经费科服务动费-国内协作费
                 */
                "kyfwfGnxzZxZj": zxFundsDetailForm.gnxzf_zj,
                /**
                 *  直接自筹经费科服务动费-国内协作费
                 */
                "kyfwfGnxzZcZj": zcFundsDetailForm.gnxzf_zj,
                /**
                 *  直接专项经费人员活动费-人员劳务费
                 */
                "ryhlwbzfZxZj": zxFundsDetailForm.rylwbzf_zj,
                /**
                 *  直接自筹经费人员活动费-人员劳务费
                 */
                "ryhlwbzfZcZj": zcFundsDetailForm.rylwbzf_zj,


                /**
                 *  专项间接绩效支出
                 */
                "jxzcZx": zxFundsDetailForm.jxzc_jj,
                /**
                 *  自筹间接绩效支出
                 */
                "jxzcZc": zcFundsDetailForm.jxzc_jj,

                /**
                 *  经费来源-专项经费自筹
                 */
                "jflyZx": fundsSourceForm.zxjfzz,
                /**
                 *  经费来源-自筹经费
                 */
                "jflyZc": fundsSourceForm.zcjf,
                /**
                 *  经费来源-其他财政拨款
                 */
                "jflyQtczbkZc": fundsSourceForm.qtczbk,
                /**
                 *  经费来源-自有货币基金
                 */
                "jflyDwzyhbzjZc": fundsSourceForm.zyhbzj,
                /**
                 *  经费来源-其他资金
                 */
                "jflyQtzjZc": fundsSourceForm.qtzj,

                /**
                 *  间接专项设备费
                 */
                "sbfZxJj": zxFundsDetailForm.sbf_jj,
                /**
                 *  间接自筹设备费
                 */
                "sbfZcJj": zcFundsDetailForm.sbf_jj,
                /**
                 *  间接专项设备费-购置设备费
                 */
                "sbfGzsbZxJj": zxFundsDetailForm.gzsbf_jj,
                /**
                 *  间接自筹设备费-购置设备费
                 */
                "sbfGzsbZcJj": zcFundsDetailForm.gzsbf_jj,
                /**
                 *  间接专项设备费-试制设备费
                 */
                "sbfSzsbZxJj": zxFundsDetailForm.szsbf_jj,
                /**
                 *  间接自筹设备费-试制设备费
                 */
                "sbfSzsbZcJj": zcFundsDetailForm.szsbf_jj,
                /**
                 *  间接专项设备费-设备购置与租赁费
                 */
                "sbfSbgzyzlZxJj": zxFundsDetailForm.sbgzyzlf_jj,
                /**
                 *  间接自筹设备费-设备购置与租赁费
                 */
                "sbfSbgzyzlZcJj": zcFundsDetailForm.sbgzyzlf_jj,
                /**
                 *  间接专项设备费-材料费
                 */
                "clfZxJj": zxFundsDetailForm.clf_jj,
                /**
                 *  间接自筹设备费-材料费
                 */
                "clfZcJj": zcFundsDetailForm.clf_jj,
                /**
                 *  间接专项经费科研活动费-科研活动费
                 */
                "kyhdfZxJj": zxFundsDetailForm.kyhdf_jj,
                /**
                 *  间接自筹经费科研活动费-科研活动费
                 */
                "kyhdfZcJj": zcFundsDetailForm.kyhdf_jj,
                /**
                 *  间接专项经费科研活动费-专利费
                 */
                "kyhdfZlZxJj": zxFundsDetailForm.zlf_jj,
                /**
                 *  间接自筹经费科研活动费-专利费
                 */
                "kyhdfZlZcJj": zcFundsDetailForm.zlf_jj,
                /**
                 *  间接专项经费科研活动费-测试化验加工费
                 */
                "kyhdfCshyjgZxJj": zxFundsDetailForm.cshyjgf_jj,
                /**
                 *  间接自筹经费科研活动费-测试化验加工费
                 */
                "kyhdfCshyjgZcJj": zcFundsDetailForm.cshyjgf_jj,
                /**
                 *  间接专项经费科研活动费-办公费
                 */
                "kyhdfBgZxJj": zxFundsDetailForm.bgf_jj,
                /**
                 *  间接自筹经费科研活动费-办公费
                 */
                "kyhdfBgZcJj": zcFundsDetailForm.bgf_jj,
                /**
                 *  间接专项经费科研活动费-数据样本采集费
                 */
                "kyhdfSjybcjZxJj": zxFundsDetailForm.sjybcjf_jj,
                /**
                 *  间接自筹经费科研活动费-数据样本采集费
                 */
                "kyhdfSjybcjZcJj": zcFundsDetailForm.sjybcjf_jj,
                /**
                 *  间接专项经费科研活动费-印刷出版费
                 */
                "kyhdfYscbZxJj": zxFundsDetailForm.yscbf_jj,
                /**
                 *  间接自筹经费科研活动费-印刷出版费
                 */
                "kyhdfYscbZcJj": zcFundsDetailForm.yscbf_jj,
                /**
                 *  间接专项经费科研活动费-知识产权事务费
                 */
                "kyhdfZscqswZxJj": zxFundsDetailForm.zscqswf_jj,
                /**
                 *  间接自筹经费科研活动费-知识产权事务费
                 */
                "kyhdfZscqswZcJj": zcFundsDetailForm.zscqswf_jj,
                /**
                 *  间接专项经费科研活动费-燃料动力费
                 */
                "kyhdfRldlZxJj": zxFundsDetailForm.rldlf_jj,
                /**
                 *  间接自筹经费科研活动费-燃料动力费
                 */
                "kyhdfRldlZcJj": zcFundsDetailForm.rldlf_jj,
                /**
                 *  间接专项经费科研活动费-车辆使用费
                 */
                "kyhdfClsyZxJj": zxFundsDetailForm.clsyf_jj,
                /**
                 *  间接自筹经费科研活动费-车辆使用费
                 */
                "kyhdfClsyZcJj": zcFundsDetailForm.clsyf_jj,
                /**
                 *  间接专项经费科服务动费-科研服务费
                 */
                "kyfwfZxJj": zxFundsDetailForm.kyfwf_jj,
                /**
                 *  间接自筹经费科服务动费-科研服务费
                 */
                "kyfwfZcJj": zcFundsDetailForm.kyfwf_jj,
                /**
                 *  间接专项经费科服务动费-专家咨询费
                 */
                "kyfwfZjzxZxJj": zxFundsDetailForm.zjzxf_jj,
                /**
                 *  间接自筹经费科服务动费-专家咨询费
                 */
                "kyfwfZjzxZcJj": zcFundsDetailForm.zjzxf_jj,
                /**
                 *  间接专项经费科服务动费-差旅费
                 */
                "kyfwfClZxJj": zxFundsDetailForm.chlf_jj,
                /**
                 *  间接自筹经费科服务动费-差旅费
                 */
                "kyfwfClZcJj": zcFundsDetailForm.chlf_jj,
                /**
                 *  间接专项经费科服务动费-会议会务费
                 */
                "kyfwfHyhwZxJj": zxFundsDetailForm.hyhwf_jj,
                /**
                 *  间接自筹经费科服务动费-会议会务费
                 */
                "kyfwfHyhwZcJj": zcFundsDetailForm.hyhwf_jj,
                /**
                 *  间接专项经费科服务动费-国际合作交流费
                 */
                "kyfwfGjhzjlZxJj": zxFundsDetailForm.gjhzjlf_jj,
                /**
                 *  间接自筹经费科服务动费-国际合作交流费
                 */
                "kyfwfGjhzjlZcJj": zcFundsDetailForm.gjhzjlf_jj,
                /**
                 *  间接专项经费科服务动费-国内协作费
                 */
                "kyfwfGnxzZxJj": zxFundsDetailForm.gnxzf_jj,
                /**
                 *  间接自筹经费科服务动费-国内协作费
                 */
                "kyfwfGnxzZcJj": zcFundsDetailForm.gnxzf_jj,
                /**
                 *  间接专项经费人员劳务补助费
                 */
                "ryhlwbzfZxJj": zxFundsDetailForm.rylwbzf_jj,
                /**
                 *  间接自筹经费人员劳务补助费
                 */
                "ryhlwbzfZcJj": zcFundsDetailForm.rylwbzf_jj,
            },
            /**
             *  经费来源
             */
            "projectUserBoList": members,
            /**
             *  项目指标
             */
            "projectTargetBOList": indicators,
            /**
             *  项目计划
             */
            "projectPlanBOList": plans,
            /**
             *  附件列表
             */
            "ossIdList": otherAttachmentForm.uploadList,
        }
    })
}

/**
 *
 * @param {*} projectId
 * @param {*} projectInfoForm
 * @param {*} projectFundsForm
 * @param {*} projectMemberForm
 * @param {*} zxFundsDetailForm
 * @param {*} zcFundsDetailForm
 * @param {*} fundsSourceForm
 * @param {*} projectIndicatorForm
 * @param {*} projectPlanForm
 * @param {*} otherAttachmentForm
 * @param {*} projectProgressForm
 */
export function getProject(projectId,
                           projectInfoForm,
                           projectMemberForm,
                           projectFundsForm,
                           zxFundsDetailForm,
                           zcFundsDetailForm,
                           fundsSourceForm,
                           projectIndicatorForm,
                           projectPlanForm,
                           otherAttachmentForm,
                           projectProgressForm,) {
    const loading = Loading.service({fullscreen: true, lock: true, text: '努力加载中'});
    request({
        url: "/project/list/getDetails", method: "get", params: {projectId}
    }).then(resp => {
        const {
                  projectInfoVO,
                  projectUserVoList,
                  projectFundsVO,
                  projectTargetVOList,
                  projectAttachmentVOList,
                  projectPlanVOList
              } = resp.data;

        // console.log("项目", projectInfoVO);
        // console.log("指标", projectTargetVOList);
        // console.log("计划", projectPlanVOList);
        // console.log("附件", projectAttachmentVOList);

        /**
         *  项目成员
         */
        const members = projectUserVoList.map(value => {
            return {id: value.userId, role: value.projectUserRoles}
        });
        if (members.length > 0)
            Vue.set(projectMemberForm, "items", members);
        /**
         *  项目指标
         */
        const indicators = projectTargetVOList.map(value => {
            return {title: value.targetName, midterm: value.midtermTarget, finish: value.endTarget}
        });
        if (indicators.length > 0)
            Vue.set(projectIndicatorForm, "items", indicators);

        /**
         *  项目计划
         */
        const plans = projectPlanVOList.map(value => {
            return {date: [value.stageStartDate, value.stageEndDate], task: value.stageTask}
        });
        if (plans.length > 0)
            Vue.set(projectPlanForm, "items", plans);
        /**
         *  项目推进情况
         *  推进情况
         */
        Vue.set(projectProgressForm, "projectProgressStatus", projectInfoVO.projectProgressStatus);
        /**
         *  完成进度
         */
        Vue.set(projectProgressForm, "completionProgress", projectInfoVO.completionProgress);
        /**
         *  专项到款总额
         */
        Vue.set(projectProgressForm, "totalFundsZxDk", projectFundsVO.totalFundsZxDk);
        /**
         *  已完成自筹投资
         */
        Vue.set(projectProgressForm, "zctzDone", projectFundsVO.zctzDone);
        /**
         *  已完成专项投资
         */
        Vue.set(projectProgressForm, "zxtzDone", projectFundsVO.zxtzDone);
        /**
         *  自筹经费公司配套
         */
        Vue.set(projectProgressForm, "zcGspt", projectFundsVO.zcGspt);
        /**
         *  专项经费公司留存
         */
        Vue.set(projectProgressForm, "zxGslc", projectFundsVO.zxGslc);
        /**
         *  获奖情况
         */
        Vue.set(projectProgressForm, "awardDetails", projectInfoVO.awardDetails);
        /**
         *  论文情况
         */
        Vue.set(projectProgressForm, "publicationDetails", projectInfoVO.publicationDetails);
        /**
         *  专利情况
         */
        Vue.set(projectProgressForm, "patentDetails", projectInfoVO.patentDetails);
        /**
         *  软著情况
         */
        Vue.set(projectProgressForm, "softwareCopyrightDetails", projectInfoVO.softwareCopyrightDetails);
        /**
         *  标准情况
         */
        Vue.set(projectProgressForm, "standardDetails", projectInfoVO.standardDetails);
        /**
         *  项目附件
         */
        Vue.set(otherAttachmentForm, "value", projectAttachmentVOList);

        /**
         *  牵头单位
         */
        Vue.set(projectInfoForm, "leadingUnit", projectInfoVO.leadingUnit);
        /**
         *  项目名称
         */
        Vue.set(projectInfoForm, "name", projectInfoVO.assignedSubjectName);
        /**
         *  联系人
         */
        Vue.set(projectInfoForm, "contact", projectInfoVO.projectContact);
        /**
         *  项目编号
         */
        Vue.set(projectInfoForm, "projectNumber", projectInfoVO.projectAssignmentSerialNo);
        /**
         *  项目来源
         */
        Vue.set(projectInfoForm, "source", projectInfoVO.projectSource);
        /**
         *  项目级别
         */
        Vue.set(projectInfoForm, "level", projectInfoVO.projectLevel);
        /**
         *  是否牵头单位
         */
        Vue.set(projectInfoForm, "isLeadingUnit", projectInfoVO.hasLeadingRole);
        /**
         *  课题名称
         */
        Vue.set(projectInfoForm, "subjectName", projectInfoVO.assignedSubjectSection);
        /**
         *  课题编号
         */
        Vue.set(projectInfoForm, "subjectNumber", projectInfoVO.subjectAssignmentSerialNo);
        /**
         *  立项时间
         */
        Vue.set(projectInfoForm, "startTime", projectInfoVO.projectEstablishTime);
        /**
         *  结束时间
         */
        Vue.set(projectInfoForm, "endTime", projectInfoVO.projectScheduledCompletionTime);
        /**
         *  项目周期
         */
        Vue.set(projectInfoForm, "duration", projectInfoVO.projectDuration);
        /**
         *  项目意义和必要性
         */
        Vue.set(projectInfoForm, "meaning", projectInfoVO.significanceAndNecessity);
        /**
         *  项目进展情况
         */
        Vue.set(projectInfoForm, "progressStatus", projectInfoVO.projectProgressStatus);
        /**
         *  项目完成进度
         */
        Vue.set(projectInfoForm, "completionProgress", projectInfoVO.completionProgress);
        /**
         *  合作单位
         */
        Vue.set(projectInfoForm, "coopUnit", projectInfoVO.collaboratingUnit);
        /**
         *  专家团队
         */
        Vue.set(projectInfoForm, "expertTeam", projectInfoVO.expertTeam);
        /**
         *  项目简介
         */
        Vue.set(projectInfoForm, "description", projectInfoVO.projectDescription);
        /**
         *  Vue.set(projectInfoForm, "awardStatus", projectInfoVO.awardDetails);
         */
        /**
         *  Vue.set(projectInfoForm, "paperStatus", projectInfoVO.publicationDetails);
         */
        /**
         *  Vue.set(projectInfoForm, "patentStatus", projectInfoVO.patentDetails);
         */
        /**
         *  Vue.set(projectInfoForm, "rzStatus", projectInfoVO.softwareCopyright);
         */
        /**
         *  Vue.set(projectInfoForm, "standardStatus", projectInfoVO.standardDetails);
         */

        /**
         *  经费总额
         */
        Vue.set(projectFundsForm, "jfze", projectFundsVO.totalFundsAll);
        /**
         *  专项经费总额
         */
        Vue.set(projectFundsForm, "zxjfze", projectFundsVO.totalFundsZx);
        /**
         *  专项经费设备费
         */
        Vue.set(projectFundsForm, "zxsbf", projectFundsVO.sbfZx);
        /**
         *  专项经费直接费
         */
        Vue.set(projectFundsForm, "zxzjx", projectFundsVO.totalFundsZxZj);
        /**
         *  专项经费间接费
         */
        Vue.set(projectFundsForm, "zxjjy", projectFundsVO.totalFundsZxJj);
        /**
         *  自筹经费总额
         */
        Vue.set(projectFundsForm, "zcjfze", projectFundsVO.totalFundsZc);
        /**
         *  自筹经费设备费
         */
        Vue.set(projectFundsForm, "zcsbf", projectFundsVO.sbfZc);
        /**
         *  自筹经费直接费
         */
        Vue.set(projectFundsForm, "zczjx", projectFundsVO.totalFundsZcZj);
        /**
         *  自筹经费间接费
         */
        Vue.set(projectFundsForm, "zcjjy", projectFundsVO.totalFundsZcJj);

        /**
         *  直接专项经费设备费
         */
        Vue.set(zxFundsDetailForm, "sbf_zj", projectFundsVO.sbfZxZj);
        /**
         *  直接自筹经费设备费
         */
        Vue.set(zcFundsDetailForm, "sbf_zj", projectFundsVO.sbfZcZj);
        /**
         *  直接专项经费设备费-购置设备费
         */
        Vue.set(zxFundsDetailForm, "gzsbf_zj", projectFundsVO.sbfGzsbZxZj);
        /**
         *  直接自筹经费设备费-购置设备费
         */
        Vue.set(zcFundsDetailForm, "gzsbf_zj", projectFundsVO.sbfGzsbZcZj);
        /**
         *  直接专项经费设备费-试制设备费
         */
        Vue.set(zxFundsDetailForm, "szsbf_zj", projectFundsVO.sbfSzsbZxZj);
        /**
         *  直接自筹经费设备费-试制设备费
         */
        Vue.set(zcFundsDetailForm, "szsbf_zj", projectFundsVO.sbfSzsbZcZj);
        /**
         *  直接专项经费设备费-设备购置与租赁费
         */
        Vue.set(zxFundsDetailForm, "sbgzyzlf_zj", projectFundsVO.sbfSbgzyzlZxZj);
        /**
         *  直接自筹经费设备费-设备购置与租赁费
         */
        Vue.set(zcFundsDetailForm, "sbgzyzlf_zj", projectFundsVO.sbfSbgzyzlZcZj);
        /**
         *  直接专项经费材料费
         */
        Vue.set(zxFundsDetailForm, "clf_zj", projectFundsVO.clfZxZj);
        /**
         *  直接自筹经费材料费
         */
        Vue.set(zcFundsDetailForm, "clf_zj", projectFundsVO.clfZcZj);
        /**
         *  直接专项经费科研活动费
         */
        Vue.set(zxFundsDetailForm, "kyhdf_zj", projectFundsVO.kyhdfZxZj);
        /**
         *  直接自筹经费科研活动费
         */
        Vue.set(zcFundsDetailForm, "kyhdf_zj", projectFundsVO.kyhdfZcZj);
        /**
         *  直接专项经费科研活动费-专利费
         */
        Vue.set(zxFundsDetailForm, "zlf_zj", projectFundsVO.kyhdfZlZxZj);
        /**
         *  直接自筹经费科研活动费-专利费
         */
        Vue.set(zcFundsDetailForm, "zlf_zj", projectFundsVO.kyhdfZlZcZj);
        /**
         *  直接专项经费科研活动费-测试化验加工费
         */
        Vue.set(zxFundsDetailForm, "cshyjgf_zj", projectFundsVO.kyhdfCshyjgZxZj);
        /**
         *  直接自筹经费科研活动费-测试化验加工费
         */
        Vue.set(zcFundsDetailForm, "cshyjgf_zj", projectFundsVO.kyhdfCshyjgZcZj);
        /**
         *  直接专项经费科研活动费-办公费
         */
        Vue.set(zxFundsDetailForm, "bgf_zj", projectFundsVO.kyhdfBgZxZj);
        /**
         *  直接自筹经费科研活动费-办公费
         */
        Vue.set(zcFundsDetailForm, "bgf_zj", projectFundsVO.kyhdfBgZcZj);
        /**
         *  直接专项经费科研活动费-数据样本采集费
         */
        Vue.set(zxFundsDetailForm, "sjybcjf_zj", projectFundsVO.kyhdfSjybcjZxZj);
        /**
         *  直接自筹经费科研活动费-数据样本采集费
         */
        Vue.set(zcFundsDetailForm, "sjybcjf_zj", projectFundsVO.kyhdfSjybcjZcZj);
        /**
         *  直接专项经费科研活动费-印刷出版费
         */
        Vue.set(zxFundsDetailForm, "yscbf_zj", projectFundsVO.kyhdfYscbZxZj);
        /**
         *  直接自筹经费科研活动费-印刷出版费
         */
        Vue.set(zcFundsDetailForm, "yscbf_zj", projectFundsVO.kyhdfYscbZcZj);
        /**
         *  直接专项经费科研活动费-知识产权事务费
         */
        Vue.set(zxFundsDetailForm, "zscqswf_zj", projectFundsVO.kyhdfZscqswZxZj);
        /**
         *  直接自筹经费科研活动费-知识产权事务费
         */
        Vue.set(zcFundsDetailForm, "zscqswf_zj", projectFundsVO.kyhdfZscqswZcZj);
        /**
         *  直接专项经费科研活动费-燃料动力费
         */
        Vue.set(zxFundsDetailForm, "rldlf_zj", projectFundsVO.kyhdfRldlZxZj);
        /**
         *  直接自筹经费科研活动费-燃料动力费
         */
        Vue.set(zcFundsDetailForm, "rldlf_zj", projectFundsVO.kyhdfRldlZcZj);
        /**
         *  直接专项经费科研活动费-车辆使用费
         */
        Vue.set(zxFundsDetailForm, "clsyf_zj", projectFundsVO.kyhdfClsyZxZj);
        /**
         *  直接自筹经费科研活动费-车辆使用费
         */
        Vue.set(zcFundsDetailForm, "clsyf_zj", projectFundsVO.kyhdfClsyZcZj);
        /**
         *  直接专项经费科服务动费
         */
        Vue.set(zxFundsDetailForm, "kyfwf_zj", projectFundsVO.kyfwfZxZj);
        /**
         *  直接自筹经费科服务动费
         */
        Vue.set(zcFundsDetailForm, "kyfwf_zj", projectFundsVO.kyfwfZcZj);
        /**
         *  直接专项经费科服务动费-专家咨询费
         */
        Vue.set(zxFundsDetailForm, "zjzxf_zj", projectFundsVO.kyfwfZjzxZxZj);
        /**
         *  直接自筹经费科服务动费-专家咨询费
         */
        Vue.set(zcFundsDetailForm, "zjzxf_zj", projectFundsVO.kyfwfZjzxZcZj);
        /**
         *  直接专项经费科服务动费-差旅费
         */
        Vue.set(zxFundsDetailForm, "chlf_zj", projectFundsVO.kyfwfClZxZj);
        /**
         *  直接自筹经费科服务动费-差旅费
         */
        Vue.set(zcFundsDetailForm, "chlf_zj", projectFundsVO.kyfwfClZcZj);
        /**
         *  直接专项经费科服务动费-会议会务费
         */
        Vue.set(zxFundsDetailForm, "hyhwf_zj", projectFundsVO.kyfwfHyhwZxZj);
        /**
         *  直接自筹经费科服务动费-会议会务费
         */
        Vue.set(zcFundsDetailForm, "hyhwf_zj", projectFundsVO.kyfwfHyhwZcZj);
        /**
         *  直接专项经费科服务动费-国际合作交流费
         */
        Vue.set(zxFundsDetailForm, "gjhzjlf_zj", projectFundsVO.kyfwfGjhzjlZxZj);
        /**
         *  直接自筹经费科服务动费-国际合作交流费
         */
        Vue.set(zcFundsDetailForm, "gjhzjlf_zj", projectFundsVO.kyfwfGjhzjlZcZj);
        /**
         *  直接专项经费科服务动费-国内协作费
         */
        Vue.set(zxFundsDetailForm, "gnxzf_zj", projectFundsVO.kyfwfGnxzZxZj);
        /**
         *  直接自筹经费科服务动费-国内协作费
         */
        Vue.set(zcFundsDetailForm, "gnxzf_zj", projectFundsVO.kyfwfGnxzZcZj);
        /**
         *  直接专项经费人员劳务补助费
         */
        Vue.set(zxFundsDetailForm, "rylwbzf_zj", projectFundsVO.ryhlwbzfZxZj);
        /**
         *  直接自筹经费人员劳务补助费
         */
        Vue.set(zcFundsDetailForm, "rylwbzf_zj", projectFundsVO.ryhlwbzfZcZj);
        /**
         *  直接专项经费间接绩效支出
         */
        Vue.set(zxFundsDetailForm, "jxzc_jj", projectFundsVO.jxzcZx);
        /**
         *  直接自筹经费间接绩效支出
         */
        Vue.set(zcFundsDetailForm, "jxzc_jj", projectFundsVO.jxzcZc);

        /**
         *   经费来源-专项经费资助
         */
        Vue.set(fundsSourceForm, "zxjfzz", projectFundsVO.jflyZx);
        /**
         *  经费来源-自筹经费
         */
        Vue.set(fundsSourceForm, "zcjf", projectFundsVO.jflyZc);
        /**
         *  经费来源-其他财政拨款
         */
        Vue.set(fundsSourceForm, "qtczbk", projectFundsVO.jflyQtczbkZc);
        /**
         *  经费来源-自有货币基金
         */
        Vue.set(fundsSourceForm, "zyhbzj", projectFundsVO.jflyDwzyhbzjZc);
        /**
         *  经费来源-其他资金
         */
        Vue.set(fundsSourceForm, "qtzj", projectFundsVO.jflyQtzjZc);

        /**
         *  间接专项经费设备费
         */
        Vue.set(zxFundsDetailForm, "sbf_jj", projectFundsVO.sbfZxJj);
        /**
         *  间接自筹经费设备费
         */
        Vue.set(zcFundsDetailForm, "sbf_jj", projectFundsVO.sbfZcJj);
        /**
         *  间接专项经费设备费-购置设备费
         */
        Vue.set(zxFundsDetailForm, "gzsbf_jj", projectFundsVO.sbfGzsbZxJj);
        /**
         *  间接自筹经费设备费-购置设备费
         */
        Vue.set(zcFundsDetailForm, "gzsbf_jj", projectFundsVO.sbfGzsbZcJj);
        /**
         *  间接专项经费设备费-试制设备费
         */
        Vue.set(zxFundsDetailForm, "szsbf_jj", projectFundsVO.sbfSzsbZxJj);
        /**
         *  间接自筹经费设备费-试制设备费
         */
        Vue.set(zcFundsDetailForm, "szsbf_jj", projectFundsVO.sbfSzsbZcJj);
        /**
         *  间接专项经费设备费-设备购置与租赁费
         */
        Vue.set(zxFundsDetailForm, "sbgzyzlf_jj", projectFundsVO.sbfSbgzyzlZxJj);
        /**
         *  间接自筹经费设备费-设备购置与租赁费
         */
        Vue.set(zcFundsDetailForm, "sbgzyzlf_jj", projectFundsVO.sbfSbgzyzlZcJj);
        /**
         *  间接专项经费材料费
         */
        Vue.set(zxFundsDetailForm, "clf_jj", projectFundsVO.clfZxJj);
        /**
         *  间接自筹经费材料费
         */
        Vue.set(zcFundsDetailForm, "clf_jj", projectFundsVO.clfZcJj);
        /**
         *  间接专项经费科研活动费
         */
        Vue.set(zxFundsDetailForm, "kyhdf_jj", projectFundsVO.kyhdfZxJj);
        /**
         *  间接自筹经费科研活动费
         */
        Vue.set(zcFundsDetailForm, "kyhdf_jj", projectFundsVO.kyhdfZcJj);
        /**
         *  间接专项经费科研活动费-专利费
         */
        Vue.set(zxFundsDetailForm, "zlf_jj", projectFundsVO.kyhdfZlZxJj);
        /**
         *  间接自筹经费科研活动费-专利费
         */
        Vue.set(zcFundsDetailForm, "zlf_jj", projectFundsVO.kyhdfZlZcJj);
        /**
         *  间接专项经费科研活动费-测试化验加工费
         */
        Vue.set(zxFundsDetailForm, "cshyjgf_jj", projectFundsVO.kyhdfCshyjgZxJj);
        /**
         *  间接自筹经费科研活动费-测试化验加工费
         */
        Vue.set(zcFundsDetailForm, "cshyjgf_jj", projectFundsVO.kyhdfCshyjgZcJj);
        /**
         *  间接专项经费科研活动费-办公费
         */
        Vue.set(zxFundsDetailForm, "bgf_jj", projectFundsVO.kyhdfBgZxJj);
        /**
         *  间接自筹经费科研活动费-办公费
         */
        Vue.set(zcFundsDetailForm, "bgf_jj", projectFundsVO.kyhdfBgZcJj);
        /**
         *  间接专项经费科研活动费-数据样本采集费
         */
        Vue.set(zxFundsDetailForm, "sjybcjf_jj", projectFundsVO.kyhdfSjybcjZxJj);
        /**
         *  间接自筹经费科研活动费-数据样本采集费
         */
        Vue.set(zcFundsDetailForm, "sjybcjf_jj", projectFundsVO.kyhdfSjybcjZcJj);
        /**
         *  间接专项经费科研活动费-印刷出版费
         */
        Vue.set(zxFundsDetailForm, "yscbf_jj", projectFundsVO.kyhdfYscbZxJj);
        /**
         *  间接自筹经费科研活动费-印刷出版费
         */
        Vue.set(zcFundsDetailForm, "yscbf_jj", projectFundsVO.kyhdfYscbZcJj);
        /**
         *  间接专项经费科研活动费-知识产权事务费
         */
        Vue.set(zxFundsDetailForm, "zscqswf_jj", projectFundsVO.kyhdfZscqswZxJj);
        /**
         *  间接自筹经费科研活动费-知识产权事务费
         */
        Vue.set(zcFundsDetailForm, "zscqswf_jj", projectFundsVO.kyhdfZscqswZcJj);
        /**
         *  间接专项经费科研活动费-燃料动力费
         */
        Vue.set(zxFundsDetailForm, "rldlf_jj", projectFundsVO.kyhdfRldlZxJj);
        /**
         *  间接自筹经费科研活动费-燃料动力费
         */
        Vue.set(zcFundsDetailForm, "rldlf_jj", projectFundsVO.kyhdfRldlZcJj);
        /**
         *  间接专项经费科研活动费-车辆使用费
         */
        Vue.set(zxFundsDetailForm, "clsyf_jj", projectFundsVO.kyhdfClsyZxJj);
        /**
         *  间接自筹经费科研活动费-车辆使用费
         */
        Vue.set(zcFundsDetailForm, "clsyf_jj", projectFundsVO.kyhdfClsyZcJj);
        /**
         *  间接专项经费科服务动费
         */
        Vue.set(zxFundsDetailForm, "kyfwf_jj", projectFundsVO.kyfwfZxJj);
        /**
         *  间接自筹经费科服务动费
         */
        Vue.set(zcFundsDetailForm, "kyfwf_jj", projectFundsVO.kyfwfZcJj);
        /**
         *  间接专项经费科服务动费-专家咨询费
         */
        Vue.set(zxFundsDetailForm, "zjzxf_jj", projectFundsVO.kyfwfZjzxZxJj);
        /**
         *  间接自筹经费科服务动费-专家咨询费
         */
        Vue.set(zcFundsDetailForm, "zjzxf_jj", projectFundsVO.kyfwfZjzxZcJj);
        /**
         *  间接专项经费科服务动费-差旅费
         */
        Vue.set(zxFundsDetailForm, "chlf_jj", projectFundsVO.kyfwfClZxJj);
        /**
         *  间接自筹经费科服务动费-差旅费
         */
        Vue.set(zcFundsDetailForm, "chlf_jj", projectFundsVO.kyfwfClZcJj);
        /**
         *  间接专项经费科服务动费-会议会务费
         */
        Vue.set(zxFundsDetailForm, "hyhwf_jj", projectFundsVO.kyfwfHyhwZxJj);
        /**
         *  间接自筹经费科服务动费-会议会务费
         */
        Vue.set(zcFundsDetailForm, "hyhwf_jj", projectFundsVO.kyfwfHyhwZcJj);
        /**
         *  间接专项经费科服务动费-国际合作交流费
         */
        Vue.set(zxFundsDetailForm, "gjhzjlf_jj", projectFundsVO.kyfwfGjhzjlZxJj);
        /**
         *  间接自筹经费科服务动费-国际合作交流费
         */
        Vue.set(zcFundsDetailForm, "gjhzjlf_jj", projectFundsVO.kyfwfGjhzjlZcJj);
        /**
         *  间接专项经费科服务动费-国内协作费
         */
        Vue.set(zxFundsDetailForm, "gnxzf_jj", projectFundsVO.kyfwfGnxzZxJj);
        /**
         *  间接自筹经费科服务动费-国内协作费
         */
        Vue.set(zcFundsDetailForm, "gnxzf_jj", projectFundsVO.kyfwfGnxzZcJj);
        /**
         *  间接专项经费人员劳务补助费
         */
        Vue.set(zxFundsDetailForm, "rylwbzf_jj", projectFundsVO.ryhlwbzfZxJj);
        /**
         *  间接自筹经费人员劳务补助费
         */
        Vue.set(zcFundsDetailForm, "rylwbzf_jj", projectFundsVO.ryhlwbzfZcJj);

        /**
         *  关闭加载
         */
        loading.close();
    }).catch(() => {
        /**
         *  关闭加载
         */
        loading.close();
        /**
         *  服务器错误显示
         */
        this.$message.error('错了哦，服务器返回了一条错误信息\n' + error);
    })
}

export function updateProject(projectId,
                              projectInfoForm,
                              projectMemberForm,
                              projectFundsForm,
                              zxFundsDetailForm,
                              zcFundsDetailForm,
                              fundsSourceForm,
                              projectIndicatorForm,
                              projectPlanForm,
                              otherAttachmentForm,
                              projectProgressForm) {

    /**
     *  项目成员
     */
    const members    = filterList(projectMemberForm.items).map(value => {
        return {userId: value.id, projectUserRoleList: value.role}
    });
    /**
     *  项目指标
     */
    const indicators = filterList(projectIndicatorForm.items, 'title').map(value => {
        return {targetName: value.title, midtermTarget: value.midterm, endTarget: value.finish}
    });
    /**
     *  项目计划
     */
    const plans      = filterList(projectPlanForm.items, "date").map(value => {
        return {stageStartDate: value.date[0], stageEndDate: value.date[1], stageTask: value.task}
    })

    return request({
        url: '/project/my/edit', method: 'post', data: {
            "projectBaseInfoBO": {
                /**
                 *  项目id
                 */
                projectId,
                /**
                 *  牵头单位
                 */
                "leadingUnit": projectInfoForm.leadingUnit,
                /**
                 *  项目名称
                 */
                "assignedSubjectName": projectInfoForm.name,
                /**
                 *  联系人
                 */
                "projectContact": projectInfoForm.contact,
                /**
                 *  项目编号
                 */
                "projectAssignmentSerialNo": projectInfoForm.projectNumber,
                /**
                 *  项目来源
                 */
                "projectSource": projectInfoForm.source,
                /**
                 *  项目级别
                 */
                "projectLevel": projectInfoForm.level,
                /**
                 *  是否牵头单位
                 */
                "hasLeadingRole": projectInfoForm.isLeadingUnit,
                /**
                 *  课题名称
                 */
                "assignedSubjectSection": projectInfoForm.subjectName,
                /**
                 *  课题编号
                 */
                "subjectAssignmentSerialNo": projectInfoForm.subjectNumber,
                /**
                 *  立项时间
                 */
                "projectEstablishTime": projectInfoForm.startTime,
                /**
                 *  结束时间
                 */
                "projectScheduledCompletionTime": projectInfoForm.endTime,
                /**
                 *  项目周期
                 */
                "projectDuration": projectInfoForm.duration,
                /**
                 *  项目意义和必要性
                 */
                "significanceAndNecessity": projectInfoForm.meaning,
                /**
                 *  项目进展情况
                 */
                "projectProgressStatus": projectProgressForm.projectProgressStatus,
                /**
                 *  项目完成进度
                 */
                "completionProgress": projectProgressForm.completionProgress,
                /**
                 *  合作单位
                 */
                "collaboratingUnit": projectInfoForm.coopUnit,
                /**
                 *  专家团队
                 */
                "expertTeam": projectInfoForm.expertTeam,
                /**
                 *  有无合作单位
                 */
                "hasCooperativeUnit": projectInfoForm.coopUnit ? 1 : 0,
                /**
                 *  项目描述
                 */
                "projectDescription": projectInfoForm.description,
                /**
                 *  获奖情况
                 */
                "awardDetails": projectProgressForm.awardDetails,
                /**
                 *  论文情况
                 */
                "publicationDetails": projectProgressForm.publicationDetails,
                /**
                 *  专利情况
                 */
                "patentDetails": projectProgressForm.patentDetails,
                /**
                 *  软著情况
                 */
                "softwareCopyrightDetails": projectProgressForm.softwareCopyrightDetails,
                /**
                 *  标准情况
                 */
                "standardDetails": projectProgressForm.standardDetails,
            },
            "projectFundsBO"   : {
                /**
                 *  专项到款总额
                 */
                "totalFundsZxDk": projectProgressForm.totalFundsZxDk,
                /**
                 *  已完成自筹投资
                 */
                "zctzDone": projectProgressForm.zctzDone,
                /**
                 *  已完成专项投资
                 */
                "zxtzDone": projectProgressForm.zxtzDone,
                /**
                 *  自筹经费公司配套
                 */
                "zcGspt": projectProgressForm.zcGspt,
                /**
                 *  专项经费公司留存（计划）
                 */
                "zxGslc": projectProgressForm.zxGslc,
                /**
                 *  总经费
                 */
                "totalFundsAll": projectFundsForm.jfze,
                /**
                 *  专项经费总额
                 */
                "totalFundsZx": projectFundsForm.zxjfze,
                /**
                 *  专项经费设备费
                 */
                "sbfZx": projectFundsForm.zxsbf,
                /**
                 *  专项经费直接费
                 */
                "totalFundsZxZj": projectFundsForm.zxzjx,
                /**
                 *  专项经费间接费
                 */
                "totalFundsZxJj": projectFundsForm.zxjjy,
                /**
                 *  自筹经费总额
                 */
                "totalFundsZc": projectFundsForm.zcjfze,
                /**
                 *  自筹经费设备费
                 */
                "sbfZc": projectFundsForm.zcsbf,
                /**
                 *  自筹经费直接费
                 */
                "totalFundsZcZj": projectFundsForm.zczjx,
                /**
                 *  自筹经费间接费
                 */
                "totalFundsZcJj": projectFundsForm.zcjjy,

                /**
                 *  直接专项经费设备费-设备费
                 */
                "sbfZxZj": zxFundsDetailForm.sbf_zj,
                /**
                 *  直接自筹经费设备费-设备费
                 */
                "sbfZcZj": zcFundsDetailForm.sbf_zj,
                /**
                 *  直接专项经费设备费-购置设备费
                 */
                "sbfGzsbZxZj": zxFundsDetailForm.gzsbf_zj,
                /**
                 *  直接自筹经费设备费-购置设备费
                 */
                "sbfGzsbZcZj": zcFundsDetailForm.gzsbf_zj,
                /**
                 *  直接专项经费设备费-试制设备费
                 */
                "sbfSzsbZxZj": zxFundsDetailForm.szsbf_zj,
                /**
                 *  直接自筹经费设备费-试制设备费
                 */
                "sbfSzsbZcZj": zcFundsDetailForm.szsbf_zj,
                /**
                 *  直接专项经费设备费-设备购置与租赁费
                 */
                "sbfSbgzyzlZxZj": zxFundsDetailForm.sbgzyzlf_zj,
                /**
                 *  直接自筹经费设备费-设备购置与租赁费
                 */
                "sbfSbgzyzlZcZj": zcFundsDetailForm.sbgzyzlf_zj,
                /**
                 *  直接专项经费-材料费
                 */
                "clfZxZj": zxFundsDetailForm.clf_zj,
                /**
                 *  直接自筹经费费-材料费
                 */
                "clfZcZj": zcFundsDetailForm.clf_zj,
                /**
                 *  直接专项经费科研活动费-科研活动费
                 */
                "kyhdfZxZj": zxFundsDetailForm.kyhdf_zj,
                /**
                 *  直接自筹经费科研活动费-科研活动费
                 */
                "kyhdfZcZj": zcFundsDetailForm.kyhdf_zj,
                /**
                 *  直接专项经费科研活动费-专利费
                 */
                "kyhdfZlZxZj": zxFundsDetailForm.zlf_zj,
                /**
                 *  直接自筹经费科研活动费-专利费
                 */
                "kyhdfZlZcZj": zcFundsDetailForm.zlf_zj,
                /**
                 *  直接专项经费科研活动费-测试化验加工费
                 */
                "kyhdfCshyjgZxZj": zxFundsDetailForm.cshyjgf_zj,
                /**
                 *  直接自筹经费科研活动费-测试化验加工费
                 */
                "kyhdfCshyjgZcZj": zcFundsDetailForm.cshyjgf_zj,
                /**
                 *  直接专项经费科研活动费-办公费
                 */
                "kyhdfBgZxZj": zxFundsDetailForm.bgf_zj,
                /**
                 *  直接自筹经费科研活动费-办公费
                 */
                "kyhdfBgZcZj": zcFundsDetailForm.bgf_zj,
                /**
                 *  直接专项经费科研活动费-数据样本采集费
                 */
                "kyhdfSjybcjZxZj": zxFundsDetailForm.sjybcjf_zj,
                /**
                 *  直接自筹经费科研活动费-数据样本采集费
                 */
                "kyhdfSjybcjZcZj": zcFundsDetailForm.sjybcjf_zj,
                /**
                 *  直接专项经费科研活动费-印刷出版费
                 */
                "kyhdfYscbZxZj": zxFundsDetailForm.yscbf_zj,
                /**
                 *  直接自筹经费科研活动费-印刷出版费
                 */
                "kyhdfYscbZcZj": zcFundsDetailForm.yscbf_zj,
                /**
                 *  直接专项经费科研活动费-知识产权事务费
                 */
                "kyhdfZscqswZxZj": zxFundsDetailForm.zscqswf_zj,
                /**
                 *  直接自筹经费科研活动费-知识产权事务费
                 */
                "kyhdfZscqswZcZj": zcFundsDetailForm.zscqswf_zj,
                /**
                 *  直接专项经费科研活动费-燃料动力费
                 */
                "kyhdfRldlZxZj": zxFundsDetailForm.rldlf_zj,
                /**
                 *  直接自筹经费科研活动费-燃料动力费
                 */
                "kyhdfRldlZcZj": zcFundsDetailForm.rldlf_zj,
                /**
                 *  直接专项经费科研活动费-车辆使用费
                 */
                "kyhdfClsyZxZj": zxFundsDetailForm.clsyf_zj,
                /**
                 *  直接自筹经费科研活动费-车辆使用费
                 */
                "kyhdfClsyZcZj": zcFundsDetailForm.clsyf_zj,
                /**
                 *  直接专项经费科服务动费-会议会务费
                 */
                "kyfwfZxZj": zxFundsDetailForm.kyfwf_zj,
                /**
                 *  直接自筹经费科服务动费-会议会务费
                 */
                "kyfwfZcZj": zcFundsDetailForm.kyfwf_zj,
                /**
                 *  直接专项经费科服务动费-专家咨询费
                 */
                "kyfwfZjzxZxZj": zxFundsDetailForm.zjzxf_zj,
                /**
                 *  直接自筹经费科服务动费-专家咨询费
                 */
                "kyfwfZjzxZcZj": zcFundsDetailForm.zjzxf_zj,
                /**
                 *  直接专项经费科服务动费-差旅费
                 */
                "kyfwfClZxZj": zxFundsDetailForm.chlf_zj,
                /**
                 *  直接自筹经费科服务动费-差旅费
                 */
                "kyfwfClZcZj": zcFundsDetailForm.chlf_zj,
                /**
                 *  直接专项经费科服务动费-会议会务费
                 */
                "kyfwfHyhwZxZj": zxFundsDetailForm.hyhwf_zj,
                /**
                 *  直接自筹经费科服务动费-会议会务费
                 */
                "kyfwfHyhwZcZj": zcFundsDetailForm.hyhwf_zj,
                /**
                 *  直接专项经费科服务动费-国际合作交流费
                 */
                "kyfwfGjhzjlZxZj": zxFundsDetailForm.gjhzjlf_zj,
                /**
                 *  直接自筹经费科服务动费-国际合作交流费
                 */
                "kyfwfGjhzjlZcZj": zcFundsDetailForm.gjhzjlf_zj,
                /**
                 *  直接专项经费科服务动费-国内协作费
                 */
                "kyfwfGnxzZxZj": zxFundsDetailForm.gnxzf_zj,
                /**
                 *  直接自筹经费科服务动费-国内协作费
                 */
                "kyfwfGnxzZcZj": zcFundsDetailForm.gnxzf_zj,
                /**
                 *  直接专项经费人员劳务补助费
                 */
                "ryhlwbzfZxZj": zxFundsDetailForm.rylwbzf_zj,
                /**
                 *  直接自筹经费人员劳务补助费
                 */
                "ryhlwbzfZcZj": zcFundsDetailForm.rylwbzf_zj,


                /**
                 *  专项间接绩效支出
                 */
                "jxzcZx": zxFundsDetailForm.jxzc_jj,
                /**
                 *  自筹间接绩效支出
                 */
                "jxzcZc": zcFundsDetailForm.jxzc_jj,

                /**
                 *  经费来源-专项经费自筹
                 */
                "jflyZx": fundsSourceForm.zxjfzz,
                /**
                 *  经费来源-自筹经费
                 */
                "jflyZc": fundsSourceForm.zcjf,
                /**
                 *  经费来源-其他财政拨款
                 */
                "jflyQtczbkZc": fundsSourceForm.qtczbk,
                /**
                 *  经费来源-自有货币基金
                 */
                "jflyDwzyhbzjZc": fundsSourceForm.zyhbzj,
                /**
                 *  经费来源-其他资金
                 */
                "jflyQtzjZc": fundsSourceForm.qtzj,

                /**
                 *  间接专项设备费
                 */
                "sbfZxJj": zxFundsDetailForm.sbf_jj,
                /**
                 *  间接自筹设备费
                 */
                "sbfZcJj": zcFundsDetailForm.sbf_jj,
                /**
                 *  间接专项设备费-购置设备费
                 */
                "sbfGzsbZxJj": zxFundsDetailForm.gzsbf_jj,
                /**
                 *  间接自筹设备费-购置设备费
                 */
                "sbfGzsbZcJj": zcFundsDetailForm.gzsbf_jj,
                /**
                 *  间接专项设备费-试制设备费
                 */
                "sbfSzsbZxJj": zxFundsDetailForm.szsbf_jj,
                /**
                 *  间接自筹设备费-试制设备费
                 */
                "sbfSzsbZcJj": zcFundsDetailForm.szsbf_jj,
                /**
                 *  间接专项设备费-设备购置与租赁费
                 */
                "sbfSbgzyzlZxJj": zxFundsDetailForm.sbgzyzlf_jj,
                /**
                 *  间接自筹设备费-设备购置与租赁费
                 */
                "sbfSbgzyzlZcJj": zcFundsDetailForm.sbgzyzlf_jj,
                /**
                 *  间接专项设备费-材料费
                 */
                "clfZxJj": zxFundsDetailForm.clf_jj,
                /**
                 *  间接自筹设备费-材料费
                 */
                "clfZcJj": zcFundsDetailForm.clf_jj,
                /**
                 *  间接专项经费科研活动费-科研活动费
                 */
                "kyhdfZxJj": zxFundsDetailForm.kyhdf_jj,
                /**
                 *  间接自筹经费科研活动费-科研活动费
                 */
                "kyhdfZcJj": zcFundsDetailForm.kyhdf_jj,
                /**
                 *  间接专项经费科研活动费-专利费
                 */
                "kyhdfZlZxJj": zxFundsDetailForm.zlf_jj,
                /**
                 *  间接自筹经费科研活动费-专利费
                 */
                "kyhdfZlZcJj": zcFundsDetailForm.zlf_jj,
                /**
                 *  间接专项经费科研活动费-测试化验加工费
                 */
                "kyhdfCshyjgZxJj": zxFundsDetailForm.cshyjgf_jj,
                /**
                 *  间接自筹经费科研活动费-测试化验加工费
                 */
                "kyhdfCshyjgZcJj": zcFundsDetailForm.cshyjgf_jj,
                /**
                 *  间接专项经费科研活动费-办公费
                 */
                "kyhdfBgZxJj": zxFundsDetailForm.bgf_jj,
                /**
                 *  间接自筹经费科研活动费-办公费
                 */
                "kyhdfBgZcJj": zcFundsDetailForm.bgf_jj,
                /**
                 *  间接专项经费科研活动费-数据样本采集费
                 */
                "kyhdfSjybcjZxJj": zxFundsDetailForm.sjybcjf_jj,
                /**
                 *  间接自筹经费科研活动费-数据样本采集费
                 */
                "kyhdfSjybcjZcJj": zcFundsDetailForm.sjybcjf_jj,
                /**
                 *  间接专项经费科研活动费-印刷出版费
                 */
                "kyhdfYscbZxJj": zxFundsDetailForm.yscbf_jj,
                /**
                 *  间接自筹经费科研活动费-印刷出版费
                 */
                "kyhdfYscbZcJj": zcFundsDetailForm.yscbf_jj,
                /**
                 *  间接专项经费科研活动费-知识产权事务费
                 */
                "kyhdfZscqswZxJj": zxFundsDetailForm.zscqswf_jj,
                /**
                 *  间接自筹经费科研活动费-知识产权事务费
                 */
                "kyhdfZscqswZcJj": zcFundsDetailForm.zscqswf_jj,
                /**
                 *  间接专项经费科研活动费-燃料动力费
                 */
                "kyhdfRldlZxJj": zxFundsDetailForm.rldlf_jj,
                /**
                 *  间接自筹经费科研活动费-燃料动力费
                 */
                "kyhdfRldlZcJj": zcFundsDetailForm.rldlf_jj,
                /**
                 *  间接专项经费科研活动费-车辆使用费
                 */
                "kyhdfClsyZxJj": zxFundsDetailForm.clsyf_jj,
                /**
                 *  间接自筹经费科研活动费-车辆使用费
                 */
                "kyhdfClsyZcJj": zcFundsDetailForm.clsyf_jj,
                /**
                 *  间接专项经费科服务动费-科研服务费
                 */
                "kyfwfZxJj": zxFundsDetailForm.kyfwf_jj,
                /**
                 *  间接自筹经费科服务动费-科研服务费
                 */
                "kyfwfZcJj": zcFundsDetailForm.kyfwf_jj,
                /**
                 *  间接专项经费科服务动费-专家咨询费
                 */
                "kyfwfZjzxZxJj": zxFundsDetailForm.zjzxf_jj,
                /**
                 *  间接自筹经费科服务动费-专家咨询费
                 */
                "kyfwfZjzxZcJj": zcFundsDetailForm.zjzxf_jj,
                /**
                 *  间接专项经费科服务动费-差旅费
                 */
                "kyfwfClZxJj": zxFundsDetailForm.chlf_jj,
                /**
                 *  间接自筹经费科服务动费-差旅费
                 */
                "kyfwfClZcJj": zcFundsDetailForm.chlf_jj,
                /**
                 *  间接专项经费科服务动费-会议会务费
                 */
                "kyfwfHyhwZxJj": zxFundsDetailForm.hyhwf_jj,
                /**
                 *  间接自筹经费科服务动费-会议会务费
                 */
                "kyfwfHyhwZcJj": zcFundsDetailForm.hyhwf_jj,
                /**
                 *  间接专项经费科服务动费-国际合作交流费
                 */
                "kyfwfGjhzjlZxJj": zxFundsDetailForm.gjhzjlf_jj,
                /**
                 *  间接自筹经费科服务动费-国际合作交流费
                 */
                "kyfwfGjhzjlZcJj": zcFundsDetailForm.gjhzjlf_jj,
                /**
                 *  间接专项经费科服务动费-国内协作费
                 */
                "kyfwfGnxzZxJj": zxFundsDetailForm.gnxzf_jj,
                /**
                 *  间接自筹经费科服务动费-国内协作费
                 */
                "kyfwfGnxzZcJj": zcFundsDetailForm.gnxzf_jj,
                /**
                 *  间接专项经费人员劳务补助费
                 */
                "ryhlwbzfZxJj": zxFundsDetailForm.rylwbzf_jj,
                /**
                 *  间接自筹经费人员劳务补助费
                 */
                "ryhlwbzfZcJj": zcFundsDetailForm.rylwbzf_jj,
            },
            /**
             *  经费来源
             */
            "projectUserBoList": members,
            /**
             *  项目指标
             */
            "projectTargetBOList": indicators,
            /**
             *  项目计划
             */
            "projectPlanBOList": plans,
            /**
             *  附件列表
             */
            "ossIdList": otherAttachmentForm.uploadList,
        }
    })
}
