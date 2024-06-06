package com.ruoyi.project.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.constant.DateConstants;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.common.enums.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 经费支出BO
 *
 * @author bailingnan
 * @date 2024/03/05
 */
@Data
public class ProjectExpenditureBO {
    /**
     * 支出id
     */
    @NotNull(message = "支出id不能为空", groups = {EditGroup.class})
    private Long expenditureId;
    /**
     * 项目id
     */
    @NotNull(message = "项目id不能为空", groups = {QueryGroup.class})
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
     * 支出金额
     */
    private BigDecimal amount;
    /**
     * 支出日期开始查询时间
     */
    @JsonFormat(pattern = DateConstants.YYYY_MM_DD)
    private LocalDate expenditureDateSta;

    /**
     * 支出日期结束查询时间
     */
    @JsonFormat(pattern = DateConstants.YYYY_MM_DD)
    private LocalDate expenditureDateEnd;
}
