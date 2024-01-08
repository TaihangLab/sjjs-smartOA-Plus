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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectAttachment that = (ProjectAttachment) o;
        return Objects.equals(this.projectId, that.projectId) && Objects.equals(this.ossId, that.ossId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.projectId, this.ossId);
    }
}
