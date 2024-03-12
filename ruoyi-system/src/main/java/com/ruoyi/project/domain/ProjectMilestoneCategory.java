package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.enums.ProjectmilestoneCategoryEnum;
import lombok.Data;

/**
 * 大事记分类表
 * */

@Data
@TableName("project_milestone_category")
public class ProjectMilestoneCategory {

    /**
     * 分类id
     * @TableId:设置主键
     */
    @TableId(value = "milestone_category_id",type = IdType.AUTO)
    private Long milestoneCategoryId;

    /**
     * 分类名称
     */
    private  ProjectmilestoneCategoryEnum  milestoneCategoryType;

}
