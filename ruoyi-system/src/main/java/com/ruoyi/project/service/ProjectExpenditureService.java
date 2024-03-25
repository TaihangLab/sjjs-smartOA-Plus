package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectExpenditure;
import com.ruoyi.project.domain.bo.ProjectExpenditureBO;

import java.util.List;

/**
 * 项目支出Service
 *
 * @author bailingnan
 * @date 2024/03/01
 */
public interface ProjectExpenditureService {
    /**
     * 批量插入项目支出信息
     *
     * @param projectExpenditureBOList
     */
    void addProjectExpenditureList(List<ProjectExpenditureBO> projectExpenditureBOList);

    void deleteProjectExpenditureByProjectId(Long projectId);

    /**
     * 查询项目支出明细
     * @param projectId
     * @return
     */
    List<ProjectExpenditure> getProjectExpenditureByProId(Long projectId);
}
