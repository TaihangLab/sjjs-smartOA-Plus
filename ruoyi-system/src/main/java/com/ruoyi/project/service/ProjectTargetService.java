package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectTarget;
import com.ruoyi.project.domain.bo.ProjectTargetBO;
import com.ruoyi.project.domain.vo.ProjectTargetVO;

import java.util.List;

public interface ProjectTargetService {

    boolean insertProjectTargetList(List<ProjectTarget> projectTargets);

    void insertProjectTargetList(List<ProjectTargetBO> projectTargetBoList, Long projectId);

    List<ProjectTargetVO> selectTargetListByProjectId(Long projectId);

    int deleteTargetByProjectId(Long projectId);

    void deleteProjectTargetByTargetIdList(List<Long> targetIdList);

    int deleteProjectTarget(Long targetId);

    void updateProjectTargetList(List<ProjectTargetBO> projectTargetBoList, Long projectId);

}
