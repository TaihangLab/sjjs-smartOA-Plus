package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

/**
 * @author bailingnan
 * @date 2023/12/29
 */
@Getter
@AllArgsConstructor
@ToString
public enum IntellectualPropertyTypeEnum implements IEnum<Integer> {
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
    @JsonValue
    private final Integer value;
    private final String description;
}
