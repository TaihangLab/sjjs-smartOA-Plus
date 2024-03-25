package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum ProjectMilestoneTypeEnum implements IEnum<Integer> {

    DECLARATION(1,"申报书"),

    ASSIGNMENT(2,"任务书"),

    RESEARCH_COLLABORATION(3,"科研协作合同"),

    SPECIAL_FUNDS(4,"专项经费文件"),

    FUND_MANAGEMENT(5,"经费管理表"),

    MID_TERM_DOCUMENT(6,"中期文件"),

    ACCEPTANCE_DOCUMENTS(7,"验收文件"),

    CONCLUSION_DOCUMENT(8,"结题文件"),

    INTELLECTUAL_PROPERTY(9,"知识产权"),

    PAPER(10,"论文"),

    PATENT(11,"专利"),

    SOFTNESS(12,"软著"),

    STANDARD(13,"标准"),

    DEMONSTRATION_APPLICATION(14,"示范应用"),

    AWARDS(15,"获奖"),

    REPORT(16,"报告"),

    EXPERT_CONSULTATION(17,"专家咨询"),

    CHANGES_IN_FUNDING(18,"经费变更"),

    PERSONNEL_CHANGES(19,"人员变更"),

    APPROVAL_DOCUMENTS(20,"批复文件"),

    NOTICE(21,"通知"),

    CONTRACT(22,"合同"),

    OTHER(0,"其它");

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String description;

}
