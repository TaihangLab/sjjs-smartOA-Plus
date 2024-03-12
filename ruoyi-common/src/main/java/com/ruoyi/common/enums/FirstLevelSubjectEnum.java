package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ruoyi.common.utils.EnumCacheUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 一级科目
 *
 * @author bailingnan
 * @date 2024/2/23
 */
@Getter
@AllArgsConstructor
@ToString
public enum FirstLevelSubjectEnum implements IEnum<Integer> {
    /**
     * 设备费
     */
    EQUIPMENT_FEE(0, "设备费"),
    /**
     * 业务费
     */
    BUSINESS_FEE(1, "业务费"),
    /**
     * 劳务费
     */
    LABOR_FEE(2, "劳务费"),
    /**
     * 材料费
     */
    MATERIAL_FEE(3, "材料费"),
    /**
     * 科研活动费
     */
    RESEARCH_ACTIVITY_FEE(4, "科研活动费"),
    /**
     * 科研服务费
     */
    RESEARCH_SERVICE_FEE(5, "科研服务费"),
    /**
     * 人员和劳务补助费
     */
    PERSONNEL_AND_SERVICE_SUBSIDY_FEE(6, "人员和劳务补助费"),
    /**
     * 绩效支出
     */
    PERFORMANCE_FEE(7, "绩效支出");

    static {
        // 通过名称构建缓存,通过EnumCache.findByName(StatusEnum.class,"SUCCESS",null);调用能获取枚举
        EnumCacheUtils.registerByName(FirstLevelSubjectEnum.class, FirstLevelSubjectEnum.values());
        // 通过code构建缓存,通过EnumCache.findByValue(StatusEnum.class,"S",null);调用能获取枚举
        EnumCacheUtils.registerByValue(FirstLevelSubjectEnum.class, FirstLevelSubjectEnum.values(),
            FirstLevelSubjectEnum::getDescription);
    }

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String description;

}
