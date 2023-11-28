package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("project_funds")
public class ProjectFunds {

    /**
     * 经费id
     */
    @TableId(value = "funds_id")
    private Long fundsId;

    /**
     * 项目ID
     */
    private Long projectId;
}
