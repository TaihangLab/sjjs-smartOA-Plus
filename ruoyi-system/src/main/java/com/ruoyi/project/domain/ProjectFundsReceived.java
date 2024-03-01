package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import net.bytebuddy.asm.Advice;

/**
 * 专项经费到账
 * @TableName project_funds_received
 */
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
     * ossid
     */
    @TableField(exist = false)
    private Long ossId;

    /**
     * 到账金额
     */
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
