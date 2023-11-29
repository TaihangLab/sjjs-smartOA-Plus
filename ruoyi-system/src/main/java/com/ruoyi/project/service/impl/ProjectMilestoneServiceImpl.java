package com.ruoyi.project.service.impl;

import com.ruoyi.project.domain.ProjectMilestone;
import com.ruoyi.project.domain.ProjectTarget;
import com.ruoyi.project.service.ProjectMilestoneService;

import java.util.List;

public class ProjectMilestoneServiceImpl implements ProjectMilestoneService {
    @Override
    public int insertProjectMilestone(ProjectMilestone projectMilestone) {
        return 0;
    }

    @Override
    public boolean insertProjectMilestoneList(List<ProjectMilestone> projectMilestones) {
        return false;
    }

    @Override
    public int deleteMilestoneByProjectId(Long projectId) {
        return 0;
    }

    @Override
    public int deleteProjectMilestone(Long milestoneId) {
        return 0;
    }

    @Override
    public int updateMilestoneByProjectId(ProjectMilestone projectMilestone, Long milestoneId) {
        return 0;
    }

    @Override
    public List<ProjectTarget> selectMilestoneListByProjectId(Long projectId) {
        return null;
    }
}
