package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import java.util.Arrays;

/**
 * 学历
 *
 * @author bailingnan
 * @date 2023/12/27
 */
@Getter
@AllArgsConstructor
@ToString
public enum DiplomaTypeEnum implements IEnum<Integer> {
    /**
     * 博士研究生
     */
    UNDERGRADUATEDOCTOR(0, "博士研究生"),
    /**
     * 硕士研究生
     */
    MASTER(1, "硕士研究生"),
    /**
     * 本科
     */
    UNDERGRADUATE(2, "本科"),
    /**
     * 专科
     */
    COLLEGE(3, "专科");

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String description;

}
