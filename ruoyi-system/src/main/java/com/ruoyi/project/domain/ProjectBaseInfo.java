package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.enums.ConfirmationStatus;
import com.ruoyi.common.enums.ExistenceState;
import com.ruoyi.common.enums.ProjectLevel;
import com.ruoyi.common.enums.ProjectStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * 项目表
 * @TableName project_base_info
 */
@TableName(value ="project_base_info")
@Data
public class ProjectBaseInfo extends BaseEntity {
    /**
     * 项目id
     */
    @TableId(type = IdType.AUTO)
    private Long projectId;

    /**
     * 项目牵头单位
     */
    @Size(max = 100, message = "项目牵头单位长度不能超过200个字符")
    private String leadingUnit;

    /**
     * 承担课题名称
     */
    @NotBlank(message = "承担课题名称不能为空")
    @Size(max = 200, message = "承担课题名称长度不能超过200个字符")
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
     * 项目来源
     */
    private String projectSource;

    /**
     * 项目级别，0国家级，1省级，2企业级
     */
    private ProjectLevel projectLevel;

    /**
     * 是否是牵头单位，1是，0否
     */
    private ConfirmationStatus hasLeadingRole;

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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate projectEstablishTime;

    /**
     * 项目计划验收时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate projectScheduledCompletionTime;

    /**
     * 项目执行时间（年）
     */
    private Integer projectDuration;

    /**
     * 项目简介
     */
    @Size(max = 1000, message = "项目简介长度不能超过1000个字符")
    private String projectDescription;

    /**
     * 意义及必要性
     */
    @Size(max = 2000, message = "意义及必要性长度不能超过2000个字符")
    private String significanceAndNecessity;

    /**
     * 项目推进情况
     */
    private ProjectStatus projectProgressStatus;

    /**
     * 完成进度
     */
    @Size(max = 2000, message = "完成进度长度不能超过2000个字符")
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
    private ExistenceState hasCooperativeUnit;

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
