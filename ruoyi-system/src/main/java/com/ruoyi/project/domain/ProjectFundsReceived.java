package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

/**
 * 专项经费到账
 * @TableName project_funds_received
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="project_funds_received")
@Data
public class ProjectFundsReceived extends BaseEntity implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long receivedId;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 大事记ID
     */
    private Long milestoneId;

    /**
     * ossids
     */
    @TableField(exist = false)
    private List<Long> ossIds;

    /**
     * 到账金额
     */
    @DecimalMax(value = "999999.999999", message = "专项到款金额不能超过{value}万元")
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal amountReceived;

    /**
     * 到账类型，0发票，1收据
     */
    private Integer receivedType;

    /**
     * 来款单位
     */
    private String receivedFrom;

    /**
     * 到账日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate receivedDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
