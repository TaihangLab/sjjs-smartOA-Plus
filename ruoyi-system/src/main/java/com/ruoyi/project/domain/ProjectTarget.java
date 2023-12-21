package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@TableName("project_target")
public class ProjectTarget extends BaseEntity {

    /**
     * 指标ID
     */
    @TableId(value = "target_id")
    private Long targetId;

    /**
     * 项目ID
     */
    private Long projectId;

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
