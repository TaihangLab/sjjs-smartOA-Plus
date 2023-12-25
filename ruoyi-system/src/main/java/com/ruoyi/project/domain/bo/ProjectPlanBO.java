package com.ruoyi.project.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.constant.DateConstants;
import lombok.Data;

import java.time.YearMonth;

/**
 * @author bailingnan
 * @date 2023/12/21
 */
@Data
public class ProjectPlanBO {
    /**
     * 项目Id
     */
    private Long projectId;

    /**
     * 阶段开始日期
     */
    @JsonFormat(pattern = DateConstants.YYYY_MM)
    private YearMonth stageStartDate;

    /**
     * 阶段结束日期
     */
    @JsonFormat(pattern = DateConstants.YYYY_MM)
    private YearMonth stageEndDate;

    /**
     * 阶段任务
     */
    private String stageTask;
}
