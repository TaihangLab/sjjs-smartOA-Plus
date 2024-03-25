package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.enums.ProjectMilestoneTypeEnum;
import lombok.Data;

/**
 * @Author 范佳兴
 * @date 2024/3/25 14:31
 */
@TableName("project_milestone_type")
@Data
public class ProjectMilestoneType {

    /**
     *主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long Id;

    /**
     * 大事记ID
     */
    private Long milestoneId;

    /**
     * 大事记分类
     */
    private ProjectMilestoneTypeEnum milestoneType;
}
