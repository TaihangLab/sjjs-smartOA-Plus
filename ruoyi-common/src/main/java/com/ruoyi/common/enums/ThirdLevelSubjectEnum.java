package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ruoyi.common.utils.EnumCacheUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 三级科目
 *
 * @author bailingnan
 * @date 2024/03/06
 */
@Getter
@AllArgsConstructor
@ToString
public enum ThirdLevelSubjectEnum implements IEnum<Integer> {
    /**
     * 无
     */
    NONE(0, "无");

    static {
        // 通过名称构建缓存,通过EnumCache.findByName(StatusEnum.class,"SUCCESS",null);调用能获取枚举
        EnumCacheUtils.registerByName(ThirdLevelSubjectEnum.class, ThirdLevelSubjectEnum.values());
        // 通过code构建缓存,通过EnumCache.findByValue(StatusEnum.class,"S",null);调用能获取枚举
        EnumCacheUtils.registerByValue(ThirdLevelSubjectEnum.class, ThirdLevelSubjectEnum.values(),
            ThirdLevelSubjectEnum::getDescription);
    }

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String description;
}
