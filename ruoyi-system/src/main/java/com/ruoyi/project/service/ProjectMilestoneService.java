package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectMilestone;
import com.ruoyi.project.domain.ProjectTarget;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProjectMilestoneService {
    int insertProjectMilestone(ProjectMilestone projectMilestone, MultipartFile multipartFile);

    public boolean insertProjectMilestoneList(List<ProjectMilestone> projectMilestones);

    int deleteMilestoneByProjectId(Long projectId);

    int deleteProjectMilestone(Long milestoneId);

    int updateMilestone(ProjectMilestone projectMilestone);

    List<ProjectMilestone> selectMilestoneListByProjectId(Long projectId);

}
