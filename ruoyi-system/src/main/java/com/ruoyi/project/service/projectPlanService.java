package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectPlan;
import com.ruoyi.project.domain.vo.ProjectPlanVO;

import java.util.List;

/**
 * @author bailingnan
 * @date 2023/12/21
 */
public interface projectPlanService {
    List<ProjectPlanVO> selectProjectPlanVOListByProjectId(Long projectId);

    void insertProjectPlanList(List<ProjectPlan> projectPlanList);

    void deleteProjectPlanByProjectId(Long projectId);

}
