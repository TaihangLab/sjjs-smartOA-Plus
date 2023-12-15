package com.ruoyi.project.domain.vo;

import lombok.Data;

/**
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
     * 指标描述
     */
    private String targetRemark;

    /**
     * 指标分类
     */
    private String targetType;
}
