package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.enums.ProjectUserRole;
import lombok.Data;

import java.io.Serializable;

/**
 * 项目和用户关联 project_user
 *
 * @author JiaXing Fan
 */
@Data
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
     * 项目成员角色，0：项目负责人；1：公司负责人；2：部门负责人；3：科研管理负责人；4：普通成员
     */
    private ProjectUserRole projectUserRole;

}
