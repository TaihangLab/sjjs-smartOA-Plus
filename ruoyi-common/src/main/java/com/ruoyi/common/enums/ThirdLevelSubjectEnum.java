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
    NONE(0, "无"), INTELLECTUAL_PROPERTY_AFFAIRS_FEE(1, "知识产权事务费"),
    PRINTING_AND_PRODUCTION_FEE(2, "印刷打印制作费"), LITERATURE_DATABASE_FEE(3, "文献数据库费"),
    INFORMATION_DISSEMINATION_FEE(4, "信息传播费"), CONFERENCE_FEE(5, "会议费"), TRAVEL_FEE(6, "差旅费"),
    INTERNATIONAL_COOPERATION_FEE(7, "国际合作费");

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
