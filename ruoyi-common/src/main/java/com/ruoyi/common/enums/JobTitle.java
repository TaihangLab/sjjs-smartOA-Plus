package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * 职称类型
 *
 * @author bailingnan
 * @date 2023/12/26
 */
@Getter
public enum JobTitle implements IEnum<Integer> {
    //正高级
    SENIOR(0, "正高级"),
    //副高级
    DEPUTY(1, "副高级"),
    //中级
    MIDDLE(2, "中级"),
    //初级
    PRIMARY(3, "初级"),
    //无
    NONE(4, "无");

    @EnumValue
    private final Integer value;
    private final String description;

    JobTitle(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
