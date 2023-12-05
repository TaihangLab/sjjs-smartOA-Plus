package com.ruoyi.project.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.xss.Xss;
import com.ruoyi.project.domain.ProjectMilestoneOss;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ProjectMilestoneVo {
    /**
     * 大事纪ID
     */
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

    /**
     *大事记对应的ossid
     */
    private ProjectMilestoneOss projectMilestoneOss;
}
