package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ruoyi.common.utils.EnumCacheUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

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

    static {
        // 通过名称构建缓存,通过EnumCache.findByName(StatusEnum.class,"SUCCESS",null);调用能获取枚举
        EnumCacheUtils.registerByName(DiplomaTypeEnum.class, DiplomaTypeEnum.values());
        // 通过code构建缓存,通过EnumCache.findByValue(StatusEnum.class,"S",null);调用能获取枚举
        EnumCacheUtils.registerByValue(DiplomaTypeEnum.class, DiplomaTypeEnum.values(),
            DiplomaTypeEnum::getDescription);
    }

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String description;

    @Override
    public String toString() {
        return description;
    }
}
