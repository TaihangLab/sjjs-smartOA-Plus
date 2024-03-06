package com.ruoyi.project.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.system.domain.SysOss;
import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @Author 范佳兴
 * @date 2024/3/1 16:28
 */
@Data
public class ProjectFundsReceivedVo {
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
     * Oss对象
     */
    private List<SysOss> sysOsses;

    /**
     * 到账日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate receivedDate;
}
