package com.ruoyi.project.domain.vo;

import com.ruoyi.common.enums.ProjectMilestoneCategoryEnum;
import com.ruoyi.system.domain.SysOss;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * 大事记VO
 *
 * @author bailingnan
 * @date 2024/02/06
 */


@Data
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
     * 项目大事纪对应的oss对象
     */
    private List<SysOss> sysOsses;

    /**
     * 项目大事记分类列表
     */
    private Set<ProjectMilestoneCategoryEnum> categoryTypeSet;
}
