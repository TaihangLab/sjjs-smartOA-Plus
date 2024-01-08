package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectTarget that = (ProjectTarget) o;
        return Objects.equals(this.projectId, that.projectId) && Objects.equals(this.targetName, that.targetName) && Objects.equals(this.midtermTarget, that.midtermTarget) && Objects.equals(this.endTarget, that.endTarget);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.projectId, this.targetName, this.midtermTarget, this.endTarget);
    }

}
