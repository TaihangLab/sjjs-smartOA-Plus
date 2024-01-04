package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * @author bailingnan
 * @date 2023/12/29
 */
@Getter
public enum IntellectualPropertyType implements IEnum<Integer> {
    /**
     * 国内发明专利
     */
    DOMESTIC_INVENTION_PATENT(0, "国内发明专利"),
    /**
     * 软件著作权
     */
    SOFTWARE_COPYRIGHT(1, "软件著作权"),
    /**
     * 论文
     */
    PAPER(2, "论文"),
    /**
     * 标准
     */
    STANDARD(3, "标准");

    @EnumValue
    private final Integer value;
    private final String description;

    IntellectualPropertyType(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
