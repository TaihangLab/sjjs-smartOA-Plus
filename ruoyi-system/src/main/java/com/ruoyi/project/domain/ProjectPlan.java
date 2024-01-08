package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.constant.DateConstants;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 项目计划表
 *
 * @TableName project_plan
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@TableName(value = "project_plan")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectPlan that = (ProjectPlan) o;
        return new EqualsBuilder().append(projectId, that.projectId).append(stageStartDate, that.stageStartDate).append(stageEndDate, that.stageEndDate).append(stageTask, that.stageTask).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(projectId).append(stageStartDate).append(stageEndDate).append(stageTask).toHashCode();
    }
}
