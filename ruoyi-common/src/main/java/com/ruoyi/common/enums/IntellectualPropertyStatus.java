package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * @author bailingnan
 * @date 2023/12/29
 */
@Getter
public enum IntellectualPropertyStatus implements IEnum<Integer> {
    /**
     * 专利受理
     */
    PATENT_ACCEPTED(0, "专利受理"),
    /**
     * 专利授权
     */
    PATENT_GRANTED(1, "专利授权"),
    /**
     * 软著已获取
     */
    SOFTWARE_COPYRIGHT_OBTAINED(2, "软著已获取"),
    /**
     * 标准正在申报
     */
    STANDARD_APPLYING(3, "标准正在申报"),
    /**
     * 标准已通过
     */
    STANDARD_APPROVED(4, "标准已通过"),
    /**
     * 论文已发表
     */
    PAPER_PUBLISHED(5, "论文已发表");

    @EnumValue
    private final Integer value;
    private final String description;

    IntellectualPropertyStatus(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }

}
