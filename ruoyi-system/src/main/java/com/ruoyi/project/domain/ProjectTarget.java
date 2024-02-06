package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * 项目和指标关联表 project_target
 *
 * @author bailingnan
 * @date 2024/02/06
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@TableName("project_target")
public class ProjectTarget {

    /**
     * 指标ID
     */
    @TableId(type = IdType.AUTO)
    private Long targetId;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 指标名称
     */
    private String targetName;

    /**
     * 中期指标值/状态
     */
    private String midtermTarget;

    /**
     * 完成时指标值/状态
     */
    private String endTarget;

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(projectId).append(targetName).append(midtermTarget).append(endTarget).toHashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectTarget that = (ProjectTarget) o;
        return new EqualsBuilder().append(projectId, that.projectId).append(targetName, that.targetName).append(midtermTarget, that.midtermTarget).append(endTarget, that.endTarget).isEquals();
    }

}
