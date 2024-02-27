package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.enums.ConfirmationStatusEnum;
import com.ruoyi.common.enums.ExistenceStateEnum;
import com.ruoyi.common.enums.ProjectLevelEnum;
import com.ruoyi.common.enums.ProjectStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 项目表
 *
 * @author bailingnan
 * @TableName project_base_info
 * @date 2024/02/06
 */
@EqualsAndHashCode(callSuper = false)
@TableName(value = "project_base_info")
@Data
public class ProjectBaseInfo extends BaseEntity {
    private static final long serialVersionUID = 8954237796352061001L;
    /**
     * 项目id
     */
    @TableId(type = IdType.AUTO)
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
     * 科研项目管理人
     */
    private String projectContact;

    /**
     * 项目任务书编号
     */
    private String projectAssignmentSerialNo;

    /**
     * 项目来源
     */
    private String projectSource;

    /**
     * 项目级别，0国家级，1省级，2企业级
     */
    private ProjectLevelEnum projectLevel;

    /**
     * 是否是牵头单位，1是，0否
     */
    private ConfirmationStatusEnum hasLeadingRole;

    /**
     * 负责课题
     */
    private String assignedSubjectSection;

    /**
     * 课题任务书编号
     */
    private String subjectAssignmentSerialNo;

    /**
     * 立项日期
     */
    private LocalDate projectEstablishTime;

    /**
     * 项目计划验收时间
     */
    private LocalDate projectScheduledCompletionTime;

    /**
     * 项目执行时间（年）
     */
    private String projectDuration;

    /**
     * 项目简介
     */
    private String projectDescription;

    /**
     * 意义及必要性
     */
    private String significanceAndNecessity;

    /**
     * 项目推进情况
     */
    private ProjectStatusEnum projectProgressStatus;

    /**
     * 完成进度
     */

    private String completionProgress;

    /**
     * 合作单位
     */
    private String collaboratingUnit;

    /**
     * 涉及专家、团队
     */
    private String expertTeam;

    /**
     * 有无合作单位，1有，0无
     */
    private ExistenceStateEnum hasCooperativeUnit;

    /**
     * 获奖情况（项）
     */
    private String awardDetails;

    /**
     * 论文情况（项）
     */
    private String publicationDetails;

    /**
     * 专利情况
     */
    private String patentDetails;

    /**
     * 软著情况
     */
    private String softwareCopyrightDetails;

    /**
     * 标准情况
     */
    private String standardDetails;

    /**
     * 是否删除，2删除，0未删除
     */
    @TableLogic
    @TableField(select = false)
    private Integer deleted;

}
