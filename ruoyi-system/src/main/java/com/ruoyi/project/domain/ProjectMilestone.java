package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.enums.ProjectmilestoneCategoryEnum;
import lombok.Data;

import java.time.LocalDate;

/**
 * 大事记表
 *
 * @author bailingnan
 * @date 2024/02/06
 */
@Data
@TableName("project_milestone")
public class ProjectMilestone {

    /**
     * 大事纪ID
     */
    @TableId(value = "milestone_id",type = IdType.AUTO)
    private Long milestoneId;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 大事记名称
     */
    private String milestoneTitle;

    /**
     * 大事记描述
     */
    private String milestoneRemark;

    /**
     * 大事记时间
     */
    private LocalDate milestoneDate;


}
