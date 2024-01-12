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
 * 项目类别
 * @author bailingnan
 * @date 2023/12/12
 */
@Getter
@AllArgsConstructor
@ToString
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
}
