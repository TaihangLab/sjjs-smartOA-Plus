package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectTarget;

import java.util.List;

public interface ProjectTargetService {


    int insertProjectTarget(ProjectTarget projectTarget);

    boolean insertProjectTargetList(List<ProjectTarget> projectTargets);

    List<ProjectTarget> selectTargetListByProjectId(Long projectId);

    int deleteTargetByProjectId(Long projectId);

    int deleteProjectTarget(Long targetId);

    int updateProjectTarget(ProjectTarget projectTarget);


}
