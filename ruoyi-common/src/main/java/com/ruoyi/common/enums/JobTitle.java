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
    //正高级工程师
    SENIOR_ENGINEER(0, "正高级工程师"),
    //副高级工程师
    ASSOCIATE_SENIOR_ENGINEER(1, "副高级工程师"),
    //中级工程师
    MIDDLE_ENGINEER(2, "中级工程师"),
    //初级工程师
    JUNIOR_ENGINEER(3, "初级工程师"),
    //研究员
    RESEARCHER(4, "研究员"),
    //副研究员
    ASSOCIATE_RESEARCHER(5, "副研究员"),
    //助理研究员
    ASSISTANT_RESEARCHER(6, "助理研究员"),
    //研究实习员
    RESEARCH_INTERN(7, "研究实习员");

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
