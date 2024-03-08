package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ruoyi.common.utils.EnumCacheUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 直接/间接枚举类
 *
 * @author bailingnan
 * @date 2024/03/07
 */
@Getter
@AllArgsConstructor
@ToString
public enum ZjJjEnum implements IEnum<Integer> {
    /**
     * 直接
     */
    DIRECT_EXPENSE(0, "直接"),
    /**
     * 间接
     */
    INDIRECT_EXPENSE(1, "间接");

    static {
        // 通过名称构建缓存,通过EnumCache.findByName(StatusEnum.class,"SUCCESS",null);调用能获取枚举
        EnumCacheUtils.registerByName(ZjJjEnum.class, ZjJjEnum.values());
        // 通过code构建缓存,通过EnumCache.findByValue(StatusEnum.class,"S",null);调用能获取枚举
        EnumCacheUtils.registerByValue(ZjJjEnum.class, ZjJjEnum.values(), ZjJjEnum::getDescription);
    }

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String description;
}
