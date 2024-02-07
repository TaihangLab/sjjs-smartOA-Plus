package com.ruoyi.project.domain.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.constant.DateConstants;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.enums.ConfirmationStatusEnum;
import com.ruoyi.common.enums.ExistenceStateEnum;
import com.ruoyi.common.enums.ProjectLevelEnum;
import com.ruoyi.common.enums.ProjectStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * 项目基本信息BO
 *
 * @author bailingnan
 * @date 2023/12/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectBaseInfoBO extends BaseEntity {

    private static final long serialVersionUID = -3554569707071107490L;
    /**
     * 项目id
     */
    @TableId(type = IdType.AUTO)
    @NotNull(message = "项目id不能为空", groups = {EditGroup.class})
    private Long projectId;

    /**
     * 项目牵头单位
     */
    @Size(max = 100, message = "项目牵头单位长度不能超过200个字符")
    private String leadingUnit;

    /**
     * 承担课题名称
     */
    @NotBlank(message = "承担课题名称不能为空", groups = {AddGroup.class, EditGroup.class})
    @Size(max = 200, message = "承担课题名称长度不能超过200个字符")
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
    @NotNull(message = "项目级别不能为空", groups = {AddGroup.class,EditGroup.class})
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
    @JsonFormat(pattern = DateConstants.YYYY_MM_DD)
    private LocalDate projectEstablishTime;

    /**
     * 项目计划验收时间
     */
    @JsonFormat(pattern = DateConstants.YYYY_MM_DD)
    private LocalDate projectScheduledCompletionTime;

    /**
     * 项目执行时间（年）
     */
    private String projectDuration;

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
    private ProjectStatusEnum projectProgressStatus;

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
     * 有无合作单位，1有，0无
     */
    private ExistenceStateEnum hasCooperativeUnit;

    /**
     * 涉及专家、团队
     */
    private String expertTeam;

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
     * 项目参与者
     */
    private Long userId;
    /**
     * 立项日期开始查询时间
     */
    @JsonFormat(pattern = DateConstants.YYYY_MM_DD)
    private LocalDate projectEstablishTimeSta;

    /**
     * 立项日期结束查询时间
     */
    @JsonFormat(pattern = DateConstants.YYYY_MM_DD)
    private LocalDate projectEstablishTimeEnd;

    /**
     * 项目计划验收时间开始时间
     */
    @JsonFormat(pattern = DateConstants.YYYY_MM_DD)
    private LocalDate projectScheduledCompletionTimeSta;

    /**
     * 项目计划验收时间结束时间
     */
    @JsonFormat(pattern = DateConstants.YYYY_MM_DD)
    private LocalDate projectScheduledCompletionTimeEnd;

}
