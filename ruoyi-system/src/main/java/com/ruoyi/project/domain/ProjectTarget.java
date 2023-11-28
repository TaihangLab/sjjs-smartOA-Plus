package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("project_target")
public class ProjectTarget {

    /**
     * 指标ID
     */
    @TableId(value = "target_id")
    private Long milestoneId;

    /**
     * 项目ID
     */
    private Long projectId;




}
