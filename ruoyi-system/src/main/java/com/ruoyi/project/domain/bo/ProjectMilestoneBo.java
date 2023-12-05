package com.ruoyi.project.domain.bo;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProjectMilestoneBo extends BaseEntity {

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
     * 大事记对应ossID列表
     */
    private List<Long> ossIds;
}
