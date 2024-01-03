package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * 学历
 *
 * @author bailingnan
 * @date 2023/12/27
 */
@Getter
public enum DiplomaType implements IEnum<Integer> {
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
    UNDERGRADUATE(3, "本科"),
    /**
     * 专科
     */
    COLLEGE(4, "专科");

    @EnumValue
    private final Integer value;
    private final String description;

    DiplomaType(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
