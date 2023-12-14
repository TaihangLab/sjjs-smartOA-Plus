package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectFunds;
import com.ruoyi.project.domain.vo.ProjectFundsVO;

/**
 * @author bailingnan
 * @date 2023/12/7
 */
public interface ProjectFundsService {

    ProjectFundsVO selectProjectFundsVOById(Long projectId);
    int insertProjectFunds(ProjectFunds projectFunds);


    int updateProjectFunds(ProjectFunds projectFunds);


    void deleteProjectFundsById(Long projectId);
}
