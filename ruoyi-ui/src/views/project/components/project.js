import request from "@/utils/request";

export function addProject(projectInfoForm,) {
    return request({
        url: '/project/my/add',
        method: 'post',
        data:{
            "projectBaseInfoBO": {
                "leadingUnit": projectInfoForm.leadingUnit,
                "assignedSubjectName": projectInfoForm.name,
                "projectContact": projectInfoForm.contact,
                "projectAssignmentSerialNo": projectInfoForm.projectNumber,
                "projectSource": projectInfoForm.source,
                "projectLevel": projectInfoForm.level,
                "hasLeadingRole": projectInfoForm.isLeadingUnit,
                "assignedSubjectSection": projectInfoForm.subjectName,
                "subjectAssignmentSerialNo": projectInfoForm.subjectNumber,
                "projectEstablishTime": projectInfoForm.startTime,
                "projectScheduledCompletionTime": projectInfoForm.endTime,
                "projectDuration": projectInfoForm.duration,
                "significanceAndNecessity": projectInfoForm.meaning,
                "projectProgressStatus": projectInfoForm.progressStatus,
                "completionProgress": projectInfoForm.completionProgress,
                "collaboratingUnit": projectInfoForm.coopUnit,
                "expertTeam": projectInfoForm.expertTeam,
                "awardDetails": projectInfoForm.awardStatus,
                "publicationDetails": projectInfoForm.paperStatus,
                "patentDetails": projectInfoForm.patentStatus,
                "softwareCopyrightDetails": projectInfoForm.rzStatus,
                "standardDetails": projectInfoForm.standardStatus,
            }
        }
    })
}
