package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectBalance;
import com.ruoyi.project.domain.vo.ProjectBalanceVO;

import java.util.List;
import java.util.Map;

/**
 * 项目余额Service
 *
 * @author bailingnan
 * @date 2024/03/01
 */
public interface ProjectBalanceService {
    /**
     * 通过项目ID列表获取项目余额Map
     *
     * @param projectIdList
     *
     * @return {@link Map}<{@link Long},{@link ProjectBalance}>
     */
    Map<Long, ProjectBalance> getProjectBalanceMapByPorjectIdList(List<Long> projectIdList);

    /**
     * 根据项目ID查询项目经费预算和支出明细及汇总
     *
     * @param projectId
     * @return
     */
    ProjectBalanceVO getFundsAndBalanceByProjectId(Long projectId);

    /**
     * 添加余额记录
     *
     * @param projectBalance
     */
    void insertProjectBalance(ProjectBalance projectBalance);
}
