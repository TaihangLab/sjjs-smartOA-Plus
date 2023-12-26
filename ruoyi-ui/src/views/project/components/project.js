import request from "@/utils/request";
import {filterList} from "@/views/project/components/utils";

export function addProject(projectInfoForm, projectMemberForm, projectFundsForm, zxFundsDetailForm, zcFundsDetailForm, fundsSourceForm, projectIndicatorForm, projectPlanForm, otherAttachmentForm) {
    const members = filterList(projectMemberForm.items).map(value => {
        return {userId: value.id, projectUserRole: value.role}
    });
    const indicators = filterList(projectIndicatorForm.items).map(value => {
        return {targetName: value.title, midtermTarget: value.midterm, endTarget: value.finish}
    });
    const plans = filterList(projectPlanForm.items, "date").map(value => {
        return {stageStartDate: value.date[0], stageEndDate: value.date[1], stageTask: value.task}
    })
    console.log(otherAttachmentForm.uploadList);
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
                "awardDetails"                  : projectInfoForm.awardStatus,
                "publicationDetails"            : projectInfoForm.paperStatus,
                "patentDetails"                 : projectInfoForm.patentStatus,
                "softwareCopyrightDetails"      : projectInfoForm.rzStatus,
                "standardDetails"               : projectInfoForm.standardStatus,
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

            },
            "projectUserBoList"  : members,
            "projectTargetBOList": indicators,
            "projectPlanBOList"  : plans,
            "ossIdList"          : otherAttachmentForm.uploadList,
        }
    })
}
