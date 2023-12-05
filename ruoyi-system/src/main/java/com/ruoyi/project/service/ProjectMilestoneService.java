package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectMilestone;
import com.ruoyi.project.domain.ProjectTarget;
import com.ruoyi.project.domain.bo.ProjectMilestoneBo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProjectMilestoneService {
    int insertProjectMilestone(ProjectMilestoneBo projectMilestoneBo);

    public boolean insertProjectMilestoneList(List<ProjectMilestone> projectMilestones);

    int deleteMilestoneByProjectId(Long projectId);

    int deleteProjectMilestone(Long milestoneId);

    int updateMilestone(ProjectMilestone projectMilestone);

    List<ProjectMilestone> selectMilestoneListByProjectId(Long projectId);

}
