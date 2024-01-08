package com.ruoyi.project.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.constant.DateConstants;
import com.ruoyi.common.enums.ExistenceStateEnum;
import com.ruoyi.common.enums.ProjectLevelEnum;
import com.ruoyi.common.enums.ProjectStatusEnum;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author bailingnan
 * @date 2023/12/12
 */
@Data
public class ProjectBaseInfoVO {

    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 项目牵头单位
     */
    private String leadingUnit;

    /**
     * 承担课题名称
     */
    private String assignedSubjectName;

    /**
     * 项目联系人
     */
    private String projectContact;

    /**
     * 项目任务书编号
     */
    private String projectAssignmentSerialNo;

    /**
     * 项目级别，0国家级，1省级，2企业级
     */
    private ProjectLevelEnum projectLevel;

    /**
     * 负责课题
     */
    private String assignedSubjectSection;

    /**
     * 项目推进情况
     */
    private ProjectStatusEnum projectProgressStatus;

    /**
     * 立项日期
     */
    @JsonFormat(pattern = DateConstants.YYYY_MM_DD)
    private LocalDate projectEstablishTime;

    /**
     * 项目计划验收时间
     */
    private LocalDate projectScheduledCompletionTime;

    /**
     * 有无合作单位，1有，0无
     */
    private ExistenceStateEnum hasCooperativeUnit;
}
