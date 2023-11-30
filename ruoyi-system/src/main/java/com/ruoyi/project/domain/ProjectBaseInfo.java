package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("project_Info")
public class ProjectBaseInfo {
    /**
     * 项目ID
     */
    @TableId(value = "project_id")
    private Long projectId;
}
