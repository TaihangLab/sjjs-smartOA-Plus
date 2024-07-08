package com.ruoyi.project.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.ruoyi.common.annotation.ExcelEnumFormat;
import com.ruoyi.common.convert.ExcelEnumConvert;
import com.ruoyi.common.enums.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Author 范佳兴
 * @date 2024/7/4 16:55
 */
@Data
@NoArgsConstructor
public class ProjectExpenditureExportVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 支出日期
     */
    @ColumnWidth(value = 15)
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
    @ExcelEnumFormat(enumClass = ZxZcEnum.class, codeField = "value", textField = "description")
    private ZxZcEnum zxzc;

    /**
     * 直接/间接,0直接,1间接
     */
    @ExcelProperty(value = "直接/间接", converter = ExcelEnumConvert.class)
    @ExcelEnumFormat(enumClass = ZjJjEnum.class, codeField = "value", textField = "description")
    private ZjJjEnum zjjj;

    /**
     * 一级科目
     */
    @ExcelProperty(value = "一级科目", converter = ExcelEnumConvert.class)
    @ExcelEnumFormat(enumClass = FirstLevelSubjectEnum.class, codeField = "value", textField = "description")
    private FirstLevelSubjectEnum firstLevelSubject;

    /**
     * 二级科目
     */
    @ExcelProperty(value = "二级科目", converter = ExcelEnumConvert.class)
    @ExcelEnumFormat(enumClass = SecondLevelSubjectEnum.class, codeField = "value", textField = "description")
    private SecondLevelSubjectEnum secondLevelSubject;

    /**
     * 三级科目
     */
    @ExcelProperty(value = "三级科目", converter = ExcelEnumConvert.class)
    @ExcelEnumFormat(enumClass = ThirdLevelSubjectEnum.class, codeField = "value", textField = "description")
    private ThirdLevelSubjectEnum thirdLevelSubject;

    /**
     * 支出金额
     */
    @ExcelProperty(value = "金额")
    private BigDecimal amount;
}
