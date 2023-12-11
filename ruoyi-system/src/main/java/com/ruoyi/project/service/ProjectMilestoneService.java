package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectMilestone;
import com.ruoyi.project.domain.ProjectTarget;
import com.ruoyi.project.domain.bo.ProjectMilestoneBo;
import com.ruoyi.project.domain.vo.ProjectMilestoneVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProjectMilestoneService {
    int insertProjectMilestone(ProjectMilestoneBo projectMilestoneBo);

    boolean insertProjectMilestoneList(List<ProjectMilestone> projectMilestones);

    int deleteMilestoneByProjectId(Long projectId);

    int deleteProjectMilestone(Long milestoneId);

    int updateMilestone(ProjectMilestoneBo projectMilestoneBo);

    List<ProjectMilestoneVo> selectMilestoneInfoByProjectId(Long projectId);

}
