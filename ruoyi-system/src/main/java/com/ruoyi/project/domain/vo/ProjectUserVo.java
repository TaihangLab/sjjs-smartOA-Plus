package com.ruoyi.project.domain.vo;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.enums.ProjectUserRole;
import lombok.Data;

@Data
public class ProjectUserVo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 用户姓名
     */
    private String nickName;


    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phonenumber;


    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 项目成员角色
     */
    private ProjectUserRole projectUserRole;
}
