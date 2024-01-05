package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.enums.ProjectUserRole;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

/**
 * 项目和用户关联 project_user
 *
 * @author JiaXing Fan
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@TableName("project_user")
public class ProjectUser {

    /**
     * 项目ID
     */
    @TableId(type = IdType.INPUT)
    private Long projectId;

    /**
     * 人员id
     */
    private Long userId;

    /**
     * 项目成员角色（0：项目负责人；1：公司负责人；2：部门负责人；3：科研管理负责人；4：普通成员）
     */
    private ProjectUserRole projectUserRole;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectUser that = (ProjectUser) o;
        return Objects.equals(this.projectId, that.projectId) && Objects.equals(this.userId, that.userId) && Objects.equals(this.projectUserRole, that.projectUserRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.projectId, this.userId, this.projectUserRole);
    }
}
