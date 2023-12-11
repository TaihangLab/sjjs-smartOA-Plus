package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectBaseInfo;

/**
 * @author bailingnan
 * @date 2023/12/7
 */
public interface ProjectBaseInfoService {
    Long insertProjectBaseInfo(ProjectBaseInfo projectBaseInfo);

    Long updateProjectBaseInfoById(ProjectBaseInfo projectBaseInfo);

    void deleteProjectBaseInfoById(Long projectId);
}
