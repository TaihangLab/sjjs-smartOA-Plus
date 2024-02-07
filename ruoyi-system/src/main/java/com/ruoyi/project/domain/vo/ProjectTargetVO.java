package com.ruoyi.project.domain.vo;

import lombok.Data;

/**
 * 项目指标VO
 *
 * @author bailingnan
 * @date 2023/12/14
 */
@Data
public class ProjectTargetVO {
    /**
     * 指标名称
     */
    private String targetName;

    /**
     * 中期指标值/状态
     */
    private String midtermTarget;

    /**
     * 完成时指标值/状态
     */
    private String endTarget;

}
