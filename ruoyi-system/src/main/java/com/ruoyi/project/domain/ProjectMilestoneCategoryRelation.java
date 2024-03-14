package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;

/**
 * 大事记与分类关系表
 */

@TableName("project_milestone_category_relation")
@Data
public class ProjectMilestoneCategoryRelation {

    /**
     * 大事记id
     */
    @TableId
    private Long milestoneId;

    /**
     * 大事记分类id
     */
    private Long milestoneCategoryId;

}
