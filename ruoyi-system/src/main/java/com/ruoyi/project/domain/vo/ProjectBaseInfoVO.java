package com.ruoyi.project.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.constant.DateConstants;
import com.ruoyi.common.enums.ConfirmationStatusEnum;
import com.ruoyi.common.enums.ExistenceStateEnum;
import com.ruoyi.common.enums.ProjectLevelEnum;
import com.ruoyi.common.enums.ProjectStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * 项目基本信息VO
 *
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
     * 科研项目管理人
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

    /**
     * 项目来源
     */
    private String projectSource;

    /**
     * 项目负责人
     */
    private String projectLeader;

    /**
     * 是否是牵头单位，1是，0否
     */
    private ConfirmationStatusEnum hasLeadingRole;

    /**
     * 合作单位
     */
    private String collaboratingUnit;

    /**
     * 公司负责人
     */
    private String companyLeader;

    /**
     * 部门负责人
     */
    private String departmentLeader;

    /**
     * 科研管理负责人
     */
    private String researchManager;

    /**
     * 项目执行时间（年）
     */
    private String projectDuration;

    /**
     * 完成进度
     */
    private String completionProgress;

    /**
     * 项目经费总额
     */
    private BigDecimal totalFundsAll;

    /**
     * 专项经费总额
     */
    private BigDecimal totalFundsZx;
    /**
     * 专项到款总额
     */
    private BigDecimal totalFundsZxDk;
    /**
     * 已完成自筹投资
     */
    private BigDecimal zctzDone;
    /**
     * 已完成专项投资
     */
    private BigDecimal zxtzDone;
    /**
     * 自筹经费公司配套
     */
    private BigDecimal zcGspt;
    /**
     * 专项经费公司留存（计划）
     */
    private BigDecimal zxGslc;

    /**
     * 更新时间
     */
    private Date updateTime;
}
