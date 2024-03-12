package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.enums.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 项目支出表
 * @TableName project_expenditure
 */
@TableName(value = "project_expenditure")
@Data
public class ProjectExpenditure extends BaseEntity implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 支出id
     */
    @TableId(type = IdType.AUTO)
    private Long expenditureId;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 支出日期
     */

    private LocalDate expenditureDate;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 凭证号
     */
    private String voucherNo;

    /**
     * 摘要
     */
    private String expenditureAbstract;

    /**
     * 专项/自筹,0专项,1自筹
     */
    private ZxZcEnum zxzc;
    /**
     * 直接/间接
     */
    private ZjJjEnum zjjj;

    /**
     * 一级科目
     */
    private FirstLevelSubjectEnum firstLevelSubject;

    /**
     * 二级科目
     */
    private SecondLevelSubjectEnum secondLevelSubject;

    /**
     * 三级科目
     */
    private ThirdLevelSubjectEnum thirdLevelSubject;

    /**
     * 支出金额,单位:元
     */
    private BigDecimal amount;
    /**
     * 是否删除，2删除，0未删除
     */
    @TableLogic
    @TableField(select = false)
    private Integer deleted;
}
