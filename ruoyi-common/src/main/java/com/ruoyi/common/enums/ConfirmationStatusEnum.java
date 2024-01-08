package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * 项目类别
 *
 * @author bailingnan
 * @date 2023/12/12
 */
@Getter
public enum ConfirmationStatusEnum implements IEnum<Integer> {
    //无
    EXIST(0, "无"),
    //有
    NOT_EXIST(1, "有");

    @EnumValue
    //值
    private final Integer value;
    //描述
    private final String description;

    ConfirmationStatusEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
