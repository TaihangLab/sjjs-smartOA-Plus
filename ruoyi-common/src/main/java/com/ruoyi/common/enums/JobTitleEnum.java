package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ruoyi.common.utils.EnumCacheUtils;
import lombok.Getter;

/**
 * 职称类型
 *
 * @author bailingnan
 * @date 2023/12/26
 */
@Getter
public enum JobTitleEnum implements IEnum<Integer> {

    /**
     * 正高级工程师
     */
    SENIOR_ENGINEER(0, "正高级工程师"),
    /**
     * 副高级工程师
     */
    ASSOCIATE_SENIOR_ENGINEER(1, "副高级工程师"),
    /**
     * 中级工程师
     */
    MIDDLE_ENGINEER(2, "中级工程师"),
    /**
     * 初级工程师
     */
    JUNIOR_ENGINEER(3, "初级工程师"),
    /**
     * 研究员
     */
    RESEARCHER(4, "研究员"),
    /**
     * 副研究员
     */
    ASSOCIATE_RESEARCHER(5, "副研究员"),
    /**
     * 助理研究员
     */
    ASSISTANT_RESEARCHER(6, "助理研究员"),
    /**
     * 研究实习员
     */
    RESEARCH_INTERN(7, "研究实习员");

    static {
        // 通过名称构建缓存,通过EnumCache.findByName(StatusEnum.class,"SUCCESS",null);调用能获取枚举
        EnumCacheUtils.registerByName(JobTitleEnum.class, JobTitleEnum.values());
        // 通过code构建缓存,通过EnumCache.findByValue(StatusEnum.class,"S",null);调用能获取枚举
        EnumCacheUtils.registerByValue(JobTitleEnum.class, JobTitleEnum.values(), JobTitleEnum::getDescription);
    }

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String description;

    JobTitleEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
