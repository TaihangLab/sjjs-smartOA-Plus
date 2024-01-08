package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.enums.ProjectUserRoleEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
    private ProjectUserRoleEnum projectUserRole;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectUser that = (ProjectUser) o;
        return new EqualsBuilder().append(this.projectId, that.projectId).append(this.userId, that.userId).append(this.projectUserRole, that.projectUserRole).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.projectId).append(this.userId).append(this.projectUserRole).toHashCode();
    }
}
