package com.ruoyi.project.service;

import com.ruoyi.project.domain.bo.ProjectInfoBO;
import com.ruoyi.project.domain.vo.ProjectDetailsVO;

/**
 * 项目Service接口
 *
 * @author bailingnan
 * @date 2023/12/11
 */
public interface ProjectService {
    /**
     * 删除项目
     *
     * @param projectId
     */
    void deleteProject(Long projectId);

    /**
     * 获取项目详情
     *
     * @param projectId
     *
     * @return {@link ProjectDetailsVO}
     */
    ProjectDetailsVO getProjectDetails(Long projectId);

    /**
     * 新增项目
     *
     * @param projectInfoBO
     */
    void addProject(ProjectInfoBO projectInfoBO);

    /**
     * 更新项目
     *
     * @param projectInfoBO
     */
    void updateProject(ProjectInfoBO projectInfoBO);
}
