package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 项目间接费用表
 * @TableName project_indirect_funds
 * @Author bailingnan
 */
@TableName(value ="project_indirect_funds")
@Data
public class ProjectIndirectFunds implements Serializable {
    /**
     * 间接费用id
     */
    @TableId(type = IdType.AUTO)
    private Long fundsId;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 间接费用名称
     */
    private String fundsName;

    /**
     * 间接费用金额
     */
    private BigDecimal fundsAmount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
