package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * @author bailingnan
 * @date 2023/12/21
 */
@Getter
public enum ProjectStatus implements IEnum<Integer> {
    //正在需求申报
    REQUIREMENT_DECLARATION_IN_PROGRESS(0, "正在需求申报"),
    //已完成需求申报
    REQUIREMENT_DECLARATION_COMPLETED(1, "已完成需求申报"),
    //正在项目申报
    PROJECT_APPLICATION_IN_PROGRESS(2, "正在项目申报"),
    //已完成项目申报
    PROJECT_APPLICATION_COMPLETED(3, "已完成项目申报"),
    //已签订任务书并推进中
    TASK_BOOK_SIGNED_AND_PROGRESSING(4, "已签订任务书并推进中"),
    //已完成中期评审
    MID_TERM_REVIEW_COMPLETED(5, "已完成中期评审"),
    //已完成项目验收
    PROJECT_ACCEPTANCE_COMPLETED(6, "已完成项目验收"),
    //未通过评审
    REVIEW_FAILED(7, "未通过评审");

    @EnumValue
    private final Integer value;
    private final String description;

    ProjectStatus(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
