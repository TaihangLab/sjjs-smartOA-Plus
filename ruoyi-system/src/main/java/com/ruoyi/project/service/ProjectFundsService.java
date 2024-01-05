package com.ruoyi.project.service;

import com.ruoyi.project.domain.bo.ProjectFundsBO;
import com.ruoyi.project.domain.vo.ProjectFundsVO;

/**
 * @author bailingnan
 * @date 2023/12/7
 */
public interface ProjectFundsService {

    ProjectFundsVO selectProjectFundsVOById(Long projectId);

    void insertProjectFunds(ProjectFundsBO projectFundsBO, Long projectId);

    void deleteProjectFundsById(Long projectId);

    void updateProjectFunds(ProjectFundsBO projectFundsBO, Long projectId);
}
