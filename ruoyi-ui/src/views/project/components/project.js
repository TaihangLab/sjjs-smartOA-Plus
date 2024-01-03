import request from "@/utils/request";
import {filterList} from "@/views/project/components/utils";
import Vue from "vue";

export function addProject(projectInfoForm, projectMemberForm, projectFundsForm, zxFundsDetailForm, zcFundsDetailForm,
                           fundsSourceForm, projectIndicatorForm, projectPlanForm, otherAttachmentForm) {
    const members    = filterList(projectMemberForm.items).map(value => {
        return {userId: value.id, projectUserRoleList: value.role}
    });
    const indicators = filterList(projectIndicatorForm.items, 'title').map(value => {
        return {targetName: value.title, midtermTarget: value.midterm, endTarget: value.finish}
    });
    const plans      = filterList(projectPlanForm.items, "date").map(value => {
        return {stageStartDate: value.date[0], stageEndDate: value.date[1], stageTask: value.task}
    })
    console.log(plans);
    return request({
        url: '/project/my/add', method: 'post', data: {
            "projectBaseInfoBO"  : {
                "leadingUnit"                   : projectInfoForm.leadingUnit,
                "assignedSubjectName"           : projectInfoForm.name,
                "projectContact"                : projectInfoForm.contact,
                "projectAssignmentSerialNo"     : projectInfoForm.projectNumber,
                "projectSource"                 : projectInfoForm.source,
                "projectLevel"                  : projectInfoForm.level,
                "hasLeadingRole"                : projectInfoForm.isLeadingUnit,
                "assignedSubjectSection"        : projectInfoForm.subjectName,
                "subjectAssignmentSerialNo"     : projectInfoForm.subjectNumber,
                "projectEstablishTime"          : projectInfoForm.startTime,
                "projectScheduledCompletionTime": projectInfoForm.endTime,
                "projectDuration"               : projectInfoForm.duration,
                "significanceAndNecessity"      : projectInfoForm.meaning,
                "projectProgressStatus"         : projectInfoForm.progressStatus,
                "completionProgress"            : projectInfoForm.completionProgress,
                "collaboratingUnit"             : projectInfoForm.coopUnit,
                "expertTeam"                    : projectInfoForm.expertTeam,
                // "awardDetails"                  : projectInfoForm.awardStatus,
                // "publicationDetails"            : projectInfoForm.paperStatus,
                // "patentDetails"                 : projectInfoForm.patentStatus,
                // "softwareCopyrightDetails"      : projectInfoForm.rzStatus,
                // "standardDetails"               : projectInfoForm.standardStatus,
            },
            "projectFundsBO"     : {
                "totalFundsAll"  : projectFundsForm.jfze,
                "totalFundsZx"   : projectFundsForm.zxjfze,
                "sbfZx"          : projectFundsForm.zxsbf,
                "totalFundsZxZj" : projectFundsForm.zxzjx,
                "totalFundsZxJj" : projectFundsForm.zxjjy,
                "totalFundsZc"   : projectFundsForm.zcjfze,
                "sbfZc"          : projectFundsForm.zcsbf,
                "totalFundsZcZj" : projectFundsForm.zczjx,
                "totalFundsZcJj" : projectFundsForm.zcjjy,

                "sbfZxZj"        : zxFundsDetailForm.sbf_zj,
                "sbfZcZj"        : zcFundsDetailForm.sbf_zj,
                "sbfGzsbZxZj"    : zxFundsDetailForm.gzsbf_zj,
                "sbfGzsbZcZj"    : zcFundsDetailForm.gzsbf_zj,
                "sbfSzsbZxZj"    : zxFundsDetailForm.szsbf_zj,
                "sbfSzsbZcZj"    : zcFundsDetailForm.szsbf_zj,
                "sbfSbgzyzlZxZj" : zxFundsDetailForm.sbgzyzlf_zj,
                "sbfSbgzyzlZcZj" : zcFundsDetailForm.sbgzyzlf_zj,
                "clfZxZj"        : zxFundsDetailForm.clf_zj,
                "clfZcZj"        : zcFundsDetailForm.clf_zj,
                "kyhdfZxZj"      : zxFundsDetailForm.kyhdf_zj,
                "kyhdfZcZj"      : zcFundsDetailForm.kyhdf_zj,
                "kyhdfZlZxZj"    : zxFundsDetailForm.zlf_zj,
                "kyhdfZlZcZj"    : zcFundsDetailForm.zlf_zj,
                "kyhdfCshyjgZxZj": zxFundsDetailForm.cshyjgf_zj,
                "kyhdfCshyjgZcZj": zcFundsDetailForm.cshyjgf_zj,
                "kyhdfBgZxZj"    : zxFundsDetailForm.bgf_zj,
                "kyhdfBgZcZj"    : zcFundsDetailForm.bgf_zj,
                "kyhdfSjybcjZxZj": zxFundsDetailForm.sjybcjf_zj,
                "kyhdfSjybcjZcZj": zcFundsDetailForm.sjybcjf_zj,
                "kyhdfYscbZxZj"  : zxFundsDetailForm.yscbf_zj,
                "kyhdfYscbZcZj"  : zcFundsDetailForm.yscbf_zj,
                "kyhdfZscqswZxZj": zxFundsDetailForm.zscqswf_zj,
                "kyhdfZscqswZcZj": zcFundsDetailForm.zscqswf_zj,
                "kyhdfRldlZxZj"  : zxFundsDetailForm.rldlf_zj,
                "kyhdfRldlZcZj"  : zcFundsDetailForm.rldlf_zj,
                "kyhdfClsyZxZj"  : zxFundsDetailForm.clsyf_zj,
                "kyhdfClsyZcZj"  : zcFundsDetailForm.clsyf_zj,
                "kyfwfZxZj"      : zxFundsDetailForm.kyfwf_zj,
                "kyfwfZcZj"      : zcFundsDetailForm.kyfwf_zj,
                "kyfwfZjzxZxZj"  : zxFundsDetailForm.zjzxf_zj,
                "kyfwfZjzxZcZj"  : zcFundsDetailForm.zjzxf_zj,
                "kyfwfClZxZj"    : zxFundsDetailForm.chlf_zj,
                "kyfwfClZcZj"    : zcFundsDetailForm.chlf_zj,
                "kyfwfHyhwZxZj"  : zxFundsDetailForm.hyhwf_zj,
                "kyfwfHyhwZcZj"  : zcFundsDetailForm.hyhwf_zj,
                "kyfwfGjhzjlZxZj": zxFundsDetailForm.gjhzjlf_zj,
                "kyfwfGjhzjlZcZj": zcFundsDetailForm.gjhzjlf_zj,
                "kyfwfGnxzZxZj"  : zxFundsDetailForm.gnxzf_zj,
                "kyfwfGnxzZcZj"  : zxFundsDetailForm.gnxzf_zj,
                "ryhlwbzfZxZj"   : zxFundsDetailForm.rylwbzf_zj,
                "ryhlwbzfZcZj"   : zcFundsDetailForm.rylwbzf_zj,
                "jxzcZx"         : zxFundsDetailForm.jxzc_jj,
                "jxzcZc"         : zcFundsDetailForm.jxzc_jj,

                "jflyZx"         : fundsSourceForm.zxjfzz,
                "jflyZc"         : fundsSourceForm.zcjf,
                "jflyQtczbkZc"   : fundsSourceForm.qtczbk,
                "jflyDwzyhbzjZc" : fundsSourceForm.zyhbzj,
                "jflyQtzjZc"     : fundsSourceForm.qtzj,

                "sbfZxJj"        : zxFundsDetailForm.sbf_jj,
                "sbfZcJj"        : zcFundsDetailForm.sbf_jj,
                "sbfGzsbZxJj"    : zxFundsDetailForm.gzsbf_jj,
                "sbfGzsbZcJj"    : zcFundsDetailForm.gzsbf_jj,
                "sbfSzsbZxJj"    : zxFundsDetailForm.szsbf_jj,
                "sbfSzsbZcJj"    : zcFundsDetailForm.szsbf_jj,
                "sbfSbgzyzlZxJj" : zxFundsDetailForm.sbgzyzlf_jj,
                "sbfSbgzyzlZcJj" : zcFundsDetailForm.sbgzyzlf_jj,
                "clfZxJj"        : zxFundsDetailForm.clf_jj,
                "clfZcJj"        : zcFundsDetailForm.clf_jj,
                "kyhdfZxJj"      : zxFundsDetailForm.kyhdf_jj,
                "kyhdfZcJj"      : zcFundsDetailForm.kyhdf_jj,
                "kyhdfZlZxJj"    : zxFundsDetailForm.zlf_jj,
                "kyhdfZlZcJj"    : zcFundsDetailForm.zlf_jj,
                "kyhdfCshyjgZxJj": zxFundsDetailForm.cshyjgf_jj,
                "kyhdfCshyjgZcJj": zcFundsDetailForm.cshyjgf_jj,
                "kyhdfBgZxJj"    : zxFundsDetailForm.bgf_jj,
                "kyhdfBgZcJj"    : zcFundsDetailForm.bgf_jj,
                "kyhdfSjybcjZxJj": zxFundsDetailForm.sjybcjf_jj,
                "kyhdfSjybcjZcJj": zcFundsDetailForm.sjybcjf_jj,
                "kyhdfYscbZxJj"  : zxFundsDetailForm.yscbf_jj,
                "kyhdfYscbZcJj"  : zcFundsDetailForm.yscbf_jj,
                "kyhdfZscqswZxJj": zxFundsDetailForm.zscqswf_jj,
                "kyhdfZscqswZcJj": zcFundsDetailForm.zscqswf_jj,
                "kyhdfRldlZxJj"  : zxFundsDetailForm.rldlf_jj,
                "kyhdfRldlZcJj"  : zcFundsDetailForm.rldlf_jj,
                "kyhdfClsyZxJj"  : zxFundsDetailForm.clsyf_jj,
                "kyhdfClsyZcJj"  : zcFundsDetailForm.clsyf_jj,
                "kyfwfZxJj"      : zxFundsDetailForm.kyfwf_jj,
                "kyfwfZcJj"      : zcFundsDetailForm.kyfwf_jj,
                "kyfwfZjzxZxJj"  : zxFundsDetailForm.zjzxf_jj,
                "kyfwfZjzxZcJj"  : zcFundsDetailForm.zjzxf_jj,
                "kyfwfClZxJj"    : zxFundsDetailForm.chlf_jj,
                "kyfwfClZcJj"    : zcFundsDetailForm.chlf_jj,
                "kyfwfHyhwZxJj"  : zxFundsDetailForm.hyhwf_jj,
                "kyfwfHyhwZcJj"  : zcFundsDetailForm.hyhwf_jj,
                "kyfwfGjhzjlZxJj": zxFundsDetailForm.gjhzjlf_jj,
                "kyfwfGjhzjlZcJj": zcFundsDetailForm.gjhzjlf_jj,
                "kyfwfGnxzZxJj"  : zxFundsDetailForm.gnxzf_jj,
                "kyfwfGnxzZcJj"  : zxFundsDetailForm.gnxzf_jj,
                "ryhlwbzfZxJj"   : zxFundsDetailForm.rylwbzf_jj,
                "ryhlwbzfZcJj"   : zcFundsDetailForm.rylwbzf_jj,
            },
            "projectUserBoList"  : members,
            "projectTargetBOList": indicators,
            "projectPlanBOList"  : plans,
            "ossIdList"          : otherAttachmentForm.uploadList,
        }
    })
}

export function getProject(projectId, projectInfoForm, projectMemberForm, projectFundsForm, zxFundsDetailForm,
                           zcFundsDetailForm, fundsSourceForm, projectIndicatorForm, projectPlanForm,
                           otherAttachmentForm) {
    console.log("projectFundsForm", projectFundsForm);
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

        console.log("指标", projectTargetVOList);
        console.log("计划", projectPlanVOList);
        console.log("附件", projectAttachmentVOList);

        const members = projectUserVoList.map(value => {
            return {id: value.userId, role: value.projectUserRoles}
        });
        if (members.length > 0)
            Vue.set(projectMemberForm, "items", members);

        const indicators = projectTargetVOList.map(value => {
            return {title: value.targetName, midterm: value.midtermTarget, finish: value.endTarget}
        });
        if (indicators.length > 0)
            Vue.set(projectIndicatorForm, "items", indicators);

        const plans = projectPlanVOList.map(value => {
            return {date: [value.stageStartDate, value.stageEndDate], task: value.stageTask}
        });
        if (plans.length > 0)
            Vue.set(projectPlanForm, "items", plans);

        Vue.set(otherAttachmentForm, "value", projectAttachmentVOList);

        Vue.set(projectInfoForm, "leadingUnit", projectInfoVO.leadingUnit);
        Vue.set(projectInfoForm, "name", projectInfoVO.assignedSubjectName);
        Vue.set(projectInfoForm, "contact", projectInfoVO.projectContact);
        Vue.set(projectInfoForm, "projectNumber", projectInfoVO.projectAssignmentSerialNo);
        Vue.set(projectInfoForm, "source", projectInfoVO.projectSource);
        Vue.set(projectInfoForm, "level", projectInfoVO.projectLevel);
        Vue.set(projectInfoForm, "isLeadingUnit", projectInfoVO.hasLeadingRole);
        Vue.set(projectInfoForm, "subjectName", projectInfoVO.assignedSubjectSection);
        Vue.set(projectInfoForm, "subjectNumber", projectInfoVO.subjectAssignmentSerialNo);
        Vue.set(projectInfoForm, "startTime", projectInfoVO.projectEstablishTime);
        Vue.set(projectInfoForm, "endTime", projectInfoVO.projectScheduledCompletionTime);
        Vue.set(projectInfoForm, "duration", projectInfoVO.projectDuration);
        Vue.set(projectInfoForm, "meaning", projectInfoVO.significanceAndNecessity);
        Vue.set(projectInfoForm, "progressStatus", projectInfoVO.projectProgressStatus);
        Vue.set(projectInfoForm, "completionProgress", projectInfoVO.completionProgress);
        Vue.set(projectInfoForm, "coopUnit", projectInfoVO.collaboratingUnit);
        Vue.set(projectInfoForm, "expertTeam", projectInfoVO.expertTeam);
        // Vue.set(projectInfoForm, "awardStatus", projectInfoVO.awardDetails);
        // Vue.set(projectInfoForm, "paperStatus", projectInfoVO.publicationDetails);
        // Vue.set(projectInfoForm, "patentStatus", projectInfoVO.patentDetails);
        // Vue.set(projectInfoForm, "rzStatus", projectInfoVO.softwareCopyright);
        // Vue.set(projectInfoForm, "standardStatus", projectInfoVO.standardDetails);

        Vue.set(projectFundsForm, "jfze", projectFundsVO.totalFundsAll);
        Vue.set(projectFundsForm, "zxjfze", projectFundsVO.totalFundsZx);
        Vue.set(projectFundsForm, "zxsbf", projectFundsVO.sbfZx);
        Vue.set(projectFundsForm, "zxzjx", projectFundsVO.totalFundsZxZj);
        Vue.set(projectFundsForm, "zxjjy", projectFundsVO.totalFundsZxJj);
        Vue.set(projectFundsForm, "zcjfze", projectFundsVO.totalFundsZc);
        Vue.set(projectFundsForm, "zcsbf", projectFundsVO.sbfZc);
        Vue.set(projectFundsForm, "zczjx", projectFundsVO.totalFundsZcZj);
        Vue.set(projectFundsForm, "zcjjy", projectFundsVO.totalFundsZcJj);

        Vue.set(zxFundsDetailForm, "sbf_zj", projectFundsVO.sbfZxZj);
        Vue.set(zcFundsDetailForm, "sbf_zj", projectFundsVO.sbfZcZj);
        Vue.set(zxFundsDetailForm, "gzsbf_zj", projectFundsVO.sbfGzsbZxZj);
        Vue.set(zcFundsDetailForm, "gzsbf_zj", projectFundsVO.sbfGzsbZcZj);
        Vue.set(zxFundsDetailForm, "szsbf_zj", projectFundsVO.sbfSzsbZxZj);
        Vue.set(zcFundsDetailForm, "szsbf_zj", projectFundsVO.sbfSzsbZcZj);
        Vue.set(zxFundsDetailForm, "sbgzyzlf_zj", projectFundsVO.sbfSbgzyzlZxZj);
        Vue.set(zcFundsDetailForm, "sbgzyzlf_zj", projectFundsVO.sbfSbgzyzlZcZj);
        Vue.set(zxFundsDetailForm, "clf_zj", projectFundsVO.clfZxZj);
        Vue.set(zcFundsDetailForm, "clf_zj", projectFundsVO.clfZcZj);
        Vue.set(zxFundsDetailForm, "kyhdf_zj", projectFundsVO.kyhdfZxZj);
        Vue.set(zcFundsDetailForm, "kyhdf_zj", projectFundsVO.kyhdfZcZj);
        Vue.set(zxFundsDetailForm, "zlf_zj", projectFundsVO.kyhdfZlZxZj);
        Vue.set(zcFundsDetailForm, "zlf_zj", projectFundsVO.kyhdfZlZcZj);
        Vue.set(zxFundsDetailForm, "cshyjgf_zj", projectFundsVO.kyhdfCshyjgZxZj);
        Vue.set(zcFundsDetailForm, "cshyjgf_zj", projectFundsVO.kyhdfCshyjgZcZj);
        Vue.set(zxFundsDetailForm, "bgf_zj", projectFundsVO.kyhdfBgZxZj);
        Vue.set(zcFundsDetailForm, "bgf_zj", projectFundsVO.kyhdfBgZcZj);
        Vue.set(zxFundsDetailForm, "sjybcjf_zj", projectFundsVO.kyhdfSjybcjZxZj);
        Vue.set(zcFundsDetailForm, "sjybcjf_zj", projectFundsVO.kyhdfSjybcjZcZj);
        Vue.set(zxFundsDetailForm, "yscbf_zj", projectFundsVO.kyhdfYscbZxZj);
        Vue.set(zcFundsDetailForm, "yscbf_zj", projectFundsVO.kyhdfYscbZcZj);
        Vue.set(zxFundsDetailForm, "zscqswf_zj", projectFundsVO.kyhdfZscqswZxZj);
        Vue.set(zcFundsDetailForm, "zscqswf_zj", projectFundsVO.kyhdfZscqswZcZj);
        Vue.set(zxFundsDetailForm, "rldlf_zj", projectFundsVO.kyhdfRldlZxZj);
        Vue.set(zcFundsDetailForm, "rldlf_zj", projectFundsVO.kyhdfRldlZcZj);
        Vue.set(zxFundsDetailForm, "clsyf_zj", projectFundsVO.kyhdfClsyZxZj);
        Vue.set(zcFundsDetailForm, "clsyf_zj", projectFundsVO.kyhdfClsyZcZj);
        Vue.set(zxFundsDetailForm, "kyfwf_zj", projectFundsVO.kyfwfZxZj);
        Vue.set(zcFundsDetailForm, "kyfwf_zj", projectFundsVO.kyfwfZcZj);
        Vue.set(zxFundsDetailForm, "zjzxf_zj", projectFundsVO.kyfwfZjzxZxZj);
        Vue.set(zcFundsDetailForm, "zjzxf_zj", projectFundsVO.kyfwfZjzxZcZj);
        Vue.set(zxFundsDetailForm, "chlf_zj", projectFundsVO.kyfwfClZxZj);
        Vue.set(zcFundsDetailForm, "chlf_zj", projectFundsVO.kyfwfClZcZj);
        Vue.set(zxFundsDetailForm, "hyhwf_zj", projectFundsVO.kyfwfHyhwZxZj);
        Vue.set(zcFundsDetailForm, "hyhwf_zj", projectFundsVO.kyfwfHyhwZcZj);
        Vue.set(zxFundsDetailForm, "gjhzjlf_zj", projectFundsVO.kyfwfGjhzjlZxZj);
        Vue.set(zcFundsDetailForm, "gjhzjlf_zj", projectFundsVO.kyfwfGjhzjlZcZj);
        Vue.set(zxFundsDetailForm, "gnxzf_zj", projectFundsVO.kyfwfGnxzZxZj);
        Vue.set(zcFundsDetailForm, "gnxzf_zj", projectFundsVO.kyfwfGnxzZcZj);
        Vue.set(zxFundsDetailForm, "rylwbzf_zj", projectFundsVO.ryhlwbzfZxZj);
        Vue.set(zcFundsDetailForm, "rylwbzf_zj", projectFundsVO.ryhlwbzfZcZj);
        Vue.set(zxFundsDetailForm, "jxzc_jj", projectFundsVO.jxzcZx);
        Vue.set(zcFundsDetailForm, "jxzc_jj", projectFundsVO.jxzcZc);


    })
}
