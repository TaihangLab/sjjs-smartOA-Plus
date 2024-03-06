package com.ruoyi.project.domain.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Author 范佳兴
 * @date 2024/3/1 15:03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectFundsReceivedBo extends BaseEntity {
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

    /**
     * 到账开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate receivedDateStar;

    /**
     * 到账结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate receivedDateEnd;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
