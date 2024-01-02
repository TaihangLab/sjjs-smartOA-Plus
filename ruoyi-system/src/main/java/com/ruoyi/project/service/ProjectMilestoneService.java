package com.ruoyi.project.service;

import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.project.domain.ProjectMilestone;
import com.ruoyi.project.domain.ProjectTarget;
import com.ruoyi.project.domain.bo.ProjectMilestoneBo;
import com.ruoyi.project.domain.bo.ProjectUserBo;
import com.ruoyi.project.domain.vo.ProjectMilestoneVo;
import com.ruoyi.project.domain.vo.ProjectUserVo;
import com.ruoyi.system.domain.vo.SysOssVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProjectMilestoneService {
    int insertProjectMilestone(ProjectMilestoneBo projectMilestoneBo);

    boolean insertProjectMilestoneList(List<ProjectMilestone> projectMilestones);

    int deleteMilestoneByProjectId(Long projectId);

    int deleteProjectMilestone(Long milestoneId);

    int updateMilestone(ProjectMilestoneBo projectMilestoneBo);

    List<ProjectMilestoneVo> queryMilestoneList(ProjectMilestoneBo projectMilestoneBo);

    TableDataInfo<SysOssVo> queryPageAllList(ProjectMilestoneBo projectMilestoneBo, PageQuery pageQuery);

}
