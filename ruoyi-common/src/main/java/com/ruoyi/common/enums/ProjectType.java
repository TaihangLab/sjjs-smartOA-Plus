package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * 项目类别
 * @author bailingnan
 * @date 2023/12/12
 */
@Getter
public enum ProjectType implements IEnum<String>{
    NATIONAL("0", "国家级"),//国家级
    PROVINCIAL("1", "省部级"),//省部级
    SELF_BUILT("2", "自有");//自建

    @EnumValue
    private final String value;//值
    private final String description;//描述

    ProjectType(String value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString(){
        return this.description;
    }
}
