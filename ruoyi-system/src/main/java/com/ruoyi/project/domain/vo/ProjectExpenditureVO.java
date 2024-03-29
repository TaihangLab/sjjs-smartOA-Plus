package com.ruoyi.project.domain.vo;

import com.ruoyi.common.enums.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * ProjectExpenditureVO
 *
 * @author bailingnan
 * @date 2024/03/29
 */
@Data
public class ProjectExpenditureVO {
    /**
     * 支出id
     */
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
}
