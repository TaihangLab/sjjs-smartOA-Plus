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
 * 项目附件表
 *
 * @author bailingnan
 * @date 2024/02/06
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@TableName("project_attachments")
public class ProjectAttachment {

    /**
     * 主键id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 文件oss_id
     */
    private Long ossId;

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(projectId).append(ossId).toHashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectAttachment that = (ProjectAttachment) o;
        return new EqualsBuilder().append(projectId, that.projectId).append(ossId, that.ossId).isEquals();
    }
}
