package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.constant.DateConstants;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 项目计划表
 *
 * @TableName project_plan
 */
@TableName(value = "project_plan")
@Data
public class ProjectPlan implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 阶段id
     */
    @TableId(type = IdType.AUTO)
    private Long stageId;
    /**
     * 项目Id
     */
    private Long projectId;
    /**
     * 阶段开始日期
     */
    @JsonFormat(pattern = DateConstants.YYYY_MM)
    private LocalDate stageStartDate;
    /**
     * 阶段结束日期
     */
    @JsonFormat(pattern = DateConstants.YYYY_MM)
    private LocalDate stageEndDate;
    /**
     * 阶段任务
     */
    private String stageTask;
}
