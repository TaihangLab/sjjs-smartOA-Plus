package com.ruoyi.project.domain.bo;

import com.ruoyi.common.enums.ProjectUserRole;
import lombok.Data;

import java.util.List;

@Data
public class ProjectUserBo {
    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 项目成员角色（0：项目负责人；1：公司负责人；2：部门负责人；3：科研管理负责人；4：普通成员）
     */
    private List<ProjectUserRole> projectUserRoleList;
}
