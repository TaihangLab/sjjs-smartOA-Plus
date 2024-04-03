package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectBalancePaid;
import com.ruoyi.project.domain.ProjectBalanceUnpaid;
import com.ruoyi.project.domain.vo.ProjectFundsAndBalanceVO;

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
     * 通过项目ID列表获取项目已支付余额Map
     *
     * @param projectIdList
     *
     * @return {@link Map}<{@link Long}, {@link ProjectBalancePaid}>
     */

    Map<Long, ProjectBalancePaid> getProjectBalancePaidMapByPorjectIdList(List<Long> projectIdList);

    /**
     * 通过项目ID列表获取项目未支付余额Map
     *
     * @param projectIdList
     *
     * @return {@link Map}<{@link Long}, {@link ProjectBalanceUnpaid}>
     */
    Map<Long, ProjectBalanceUnpaid> getProjectBalanceUnpaidMapByPorjectIdList(List<Long> projectIdList);

    /**
     * 根据项目ID查询项目经费预算和支出明细及汇总
     *
     * @param projectId
     * @return
     */
    ProjectFundsAndBalanceVO getFundsAndBalanceByProjectId(Long projectId);

    /**
     * 添加已支付余额记录
     *
     * @param projectBalancePaid
     */
    void insertProjectBalancePaid(ProjectBalancePaid projectBalancePaid);

    /**
     * 添加未支付余额记录
     *
     * @param projectBalanceUnpaid
     */
    void insertProjectBalanceUnpaid(ProjectBalanceUnpaid projectBalanceUnpaid);

    ProjectBalancePaid getProjectBalancePaidByProjectId(Long projectId);

    ProjectBalanceUnpaid getProjectBalanceUnpaidByProjectId(Long projectId);

    void updateProjectBalancePaid(ProjectBalancePaid projectBalancePaid);

    void updateProjectBanlanceUnpaid(ProjectBalanceUnpaid projectBalanceUnpaid);

    void batchUpdateProjectBalancePaid(List<ProjectBalancePaid> projectBalancePaidList);

    void batchUpdateProjectBalanceUnpaid(List<ProjectBalanceUnpaid> projectBalanceUnpaidList);

}
