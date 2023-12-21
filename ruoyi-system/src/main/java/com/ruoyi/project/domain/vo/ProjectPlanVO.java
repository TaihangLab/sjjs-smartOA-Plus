package com.ruoyi.project.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.YearMonth;

/**
 * @author bailingnan
 * @date 2023/12/21
 */
@Data
public class ProjectPlanVO {
    /**
     * 阶段开始日期
     */
    @JsonFormat(pattern = "yyyy-MM")
    private YearMonth stageStartDate;

    /**
     * 阶段结束日期
     */
    @JsonFormat(pattern = "yyyy-MM")
    private YearMonth stageEndDate;

    /**
     * 阶段任务
     */
    private String stageTask;
}
