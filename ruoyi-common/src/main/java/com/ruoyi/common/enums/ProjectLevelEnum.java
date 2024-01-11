package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 项目类别
 * @author bailingnan
 * @date 2023/12/12
 */
@Getter
public enum ProjectLevelEnum implements IEnum<Integer> {
    //国家级
    NATIONAL(0, "国家级"),
    //省部级
    PROVINCIAL(1, "省级"),
    //自建
    ENTERPRISE(2, "企业级");

    @EnumValue
    @JsonValue
    //值
    private final Integer value;
    //描述
    private final String description;

    ProjectLevelEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString(){
        return String.valueOf(this.value);
    }
}
