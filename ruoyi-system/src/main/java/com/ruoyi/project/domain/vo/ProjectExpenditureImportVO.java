package com.ruoyi.project.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.ruoyi.common.annotation.ExcelEnumFormat;
import com.ruoyi.common.convert.ExcelEnumConvert;
import com.ruoyi.common.enums.FirstLevelSubjectEnum;
import com.ruoyi.common.enums.SecondLevelSubjectEnum;
import com.ruoyi.common.enums.ZxZcEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 项目支出导入VO
 *
 * @author bailingnan
 * @date 2024/2/23
 */
@Data
@NoArgsConstructor
public class ProjectExpenditureImportVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 支出日期
     */
    @ExcelProperty(value = "日期")
    @DateTimeFormat("yyyy/MM/dd")
    private LocalDate expenditureDate;
    /**
     * 项目名称
     */
    @ExcelProperty(value = "项目名称")
    private String projectName;
    /**
     * 凭证号
     */
    @ExcelProperty(value = "凭证号")
    private String voucherNo;
    /**
     * 摘要
     */
    @ExcelProperty(value = "摘要")
    private String expenditureAbstract;
    /**
     * 专项/自筹,0专项,1自筹
     */
    @ExcelProperty(value = "专项/自筹", converter = ExcelEnumConvert.class)
    @ExcelEnumFormat(enumClass = ZxZcEnum.class, textField = "description")
    private ZxZcEnum zxzc;
    /**
     * 一级科目
     */
    @ExcelProperty(value = "科目粗分", converter = ExcelEnumConvert.class)
    @ExcelEnumFormat(enumClass = FirstLevelSubjectEnum.class, textField = "description")
    private FirstLevelSubjectEnum firstLevelSubject;
    /**
     * 二级科目
     */
    @ExcelProperty(value = "科目细分", converter = ExcelEnumConvert.class)
    @ExcelEnumFormat(enumClass = SecondLevelSubjectEnum.class, textField = "description")
    private SecondLevelSubjectEnum secondLevelSubject;
    /**
     * 支出金额
     */
    @ExcelProperty(value = "金额")
    private BigDecimal amount;
}
