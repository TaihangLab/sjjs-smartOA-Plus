package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author 范佳兴
 * @date 2024/2/29 14:22
 * 到账类型枚举
 */
@Getter
@AllArgsConstructor
@ToString
public enum FundsReceivedTypeEnum implements IEnum<Integer> {

    /**
     * 发票
     */
    INVOICE(0, "发票"),
    /**
     * 收据
     */
    RECEIPT(1, "收据");

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String description;
}
