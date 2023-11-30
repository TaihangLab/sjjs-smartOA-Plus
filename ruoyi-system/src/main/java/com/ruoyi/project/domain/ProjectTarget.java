package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@TableName("project_target")
public class ProjectTarget {

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
    @NotBlank(message = "指标描述不能为空")
    @Size(min = 0, max = 10, message = "指标描述不能超过{max}个字符")
    private String targetName;

    /**
     * 指标描述
     */
    @NotBlank(message = "指标描述不能为空")
    @Size(min = 0, max = 50, message = "指标描述不能超过{max}个字符")
    private String targetRemark;

}
