package com.ruoyi.project.service;

import com.ruoyi.project.domain.bo.ProjectPlanBO;
import com.ruoyi.project.domain.vo.ProjectPlanVO;

import java.util.List;

/**
 * @author bailingnan
 * @date 2023/12/21
 */
public interface projectPlanService {
    List<ProjectPlanVO> selectProjectPlanVOListByProjectId(Long projectId);

    void insertProjectPlanList(List<ProjectPlanBO> projectPlanBOList, Long projectId);

    void deleteProjectPlanByProjectId(Long projectId);

    void updateProjectPlanList(List<ProjectPlanBO> projectPlanBOList, Long projectId);
}
