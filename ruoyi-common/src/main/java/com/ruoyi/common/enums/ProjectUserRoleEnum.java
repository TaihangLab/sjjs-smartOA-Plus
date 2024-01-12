package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

/**
 * 项目成员角色
 * @author bailingnan
 */
@Getter
@AllArgsConstructor
@ToString
public enum ProjectUserRoleEnum implements IEnum<String> {

    //项目负责人
    PROJECT_LEADER("0", "项目负责人"),
    //公司负责人
    COMPANY_LEADER("1", "公司负责人"),
    //部门负责人
    DEPARTMENT_LEADER("2", "部门负责人"),
    //科研管理负责人
    RESEARCH_MANAGER("3", "科研管理负责人"),
    //普通成员
    ORDINARY_MEMBER("4", "普通成员"),
    //未知角色
    UNKNOWN("5", "未知角色"),
    //项目录入者
    PROJECT_ENTRY_OPERATOR("6", "项目录入者");


    @EnumValue
    @JsonValue
    private final String value;
    private final String description;
}
