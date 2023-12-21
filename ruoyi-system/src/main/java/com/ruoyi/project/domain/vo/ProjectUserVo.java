package com.ruoyi.project.domain.vo;

import lombok.Data;

@Data
public class ProjectUserVo {

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
    private String projectUserRole;
}
