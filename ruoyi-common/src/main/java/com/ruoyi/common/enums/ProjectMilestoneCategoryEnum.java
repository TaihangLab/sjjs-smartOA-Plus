package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProjectMilestoneCategoryEnum implements IEnum<Integer> {
    /**
     * 第一类别
     * **/
    one(1,"第一类"),

    /**
     * 第二类
     * */
    two(2,"第二类"),

    /**
     * 第三类
     * */
    three(3,"第三类")
    ;

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String description;

}
