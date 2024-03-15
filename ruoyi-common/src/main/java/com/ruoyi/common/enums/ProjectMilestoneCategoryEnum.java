package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProjectMilestoneCategoryEnum implements IEnum<Integer> {

    申报书(1,"申报书"),

    任务书(2,"任务书"),

    科研协作合同(3,"科研协作合同"),

    专项经费相关文件(4,"专项经费相关文件"),

    经费管理表(5,"经费管理表"),

    中期文件(6,"中期文件"),

    验收文件(7,"验收文件"),

    结题文件(8,"结题文件"),

    知识产权(9,"知识产权"),

    论文(10,"论文"),

    专利(11,"专利"),

    软著(12,"软著"),

    标准(13,"标准"),

    示范应用(14,"示范应用"),

    获奖(15,"获奖"),

    报告(16,"报告"),

    专家咨询(17,"专家咨询"),

    经费变更(18,"经费变更"),

    人员变更(19,"人员变更"),

    批复文件(20,"批复文件"),

    通知(21,"通知"),

    合同(22,"合同"),

    其它(0,"其它")

    ;

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String description;

}
