package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * 项目成员角色
 */
@Getter
public enum ProjectUserRole implements IEnum<String> {

    PROJECT_LEADER("0", "项目负责人"),
    COMPANY_LEADER("1", "公司负责人"),
    DEPARTMENT_LEADER("2", "部门负责人"),
    RESEARCH_MANAGER("3", "科研管理负责人"),
    ORDINARY_MEMBER("4", "普通成员"),
    UNKNOWN("5", "未知角色"),
    PROJECT_ENTRY_OPERATOR("6", "项目录入者");


    @EnumValue
    private final String value;
    private final String description;

    ProjectUserRole(String value, String description) {
        this.value = value;
        this.description = description;
    }
    @Override
    public String toString(){
        return this.description;
    }
}
