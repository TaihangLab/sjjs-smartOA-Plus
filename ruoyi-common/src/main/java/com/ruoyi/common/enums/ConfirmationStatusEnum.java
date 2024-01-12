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
 *
 * @author bailingnan
 * @date 2023/12/12
 */
@Getter
@AllArgsConstructor
@ToString
public enum ConfirmationStatusEnum implements IEnum<Integer> {
    //无
    EXIST(0, "无"),
    //有
    NOT_EXIST(1, "有");

    @EnumValue
    @JsonValue
    //值
    private final Integer value;
    //描述
    private final String description;
}
