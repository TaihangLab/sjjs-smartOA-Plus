package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectFunds;
import com.ruoyi.project.domain.ProjectIndirectFunds;
import com.ruoyi.project.domain.vo.ProjectFundsVO;

/**
 * @author bailingnan
 * @date 2023/12/7
 */
public interface ProjectFundsService {

    ProjectFundsVO selectProjectFunds(Long projectId);
    int insertProjectFunds(ProjectFunds projectFunds);

    int insertProjectIndirectFunds(ProjectIndirectFunds projectIndirectFunds);

    int updateProjectFunds(ProjectFunds projectFunds);

    int updateProjectIndirectFunds(ProjectIndirectFunds projectIndirectFunds);

    void deleteProjectFundsById(Long projectId);
}
