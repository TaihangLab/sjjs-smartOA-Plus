package com.ruoyi.project.service;

import com.ruoyi.project.domain.bo.ProjectInfoBO;
import com.ruoyi.project.domain.vo.ProjectDetailsVO;

/**
 * @author bailingnan
 * @date 2023/12/11
 */
public interface ProjectService {
    void deleteProject(Long projectId);

    ProjectDetailsVO getProjectDetails(Long projectId);

    void addProject(ProjectInfoBO projectInfoBO);
}
