package com.ruoyi.project.domain.bo;

import lombok.Data;

/**
 * @author bailingnan
 * @date 2023/12/15
 */
@Data
public class ProjectTargetBO {
    /**
     * 项目ID
     */
    private Long projectId;
    /**
     * 指标名称
     */
    private String targetName;

    /**
     * 指标描述
     */
    private String targetRemark;

    /**
     * 指标分类
     */
    private String targetType;
}
