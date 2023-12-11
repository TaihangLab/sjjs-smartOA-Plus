package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectFunds;
import com.ruoyi.project.domain.ProjectIndirectFunds;

/**
 * @author bailingnan
 * @date 2023/12/7
 */
public interface ProjectFundsService {
    int insertProjectFunds(ProjectFunds projectFunds);

    int insertProjectIndirectFunds(ProjectIndirectFunds projectIndirectFunds);

    int updateProjectFunds(ProjectFunds projectFunds);

    int updateProjectIndirectFunds(ProjectIndirectFunds projectIndirectFunds);
}
