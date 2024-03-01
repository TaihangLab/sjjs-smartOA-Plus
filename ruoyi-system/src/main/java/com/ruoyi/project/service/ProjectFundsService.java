package com.ruoyi.project.service;

import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.project.domain.ProjectFunds;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.bo.ProjectFundsBO;
import com.ruoyi.project.domain.vo.ProjectFundsManagementVO;
import com.ruoyi.project.domain.vo.ProjectFundsVO;

import java.util.List;
import java.util.Map;

/**
 * 项目经费Service接口
 *
 * @author bailingnan
 * @date 2023/12/7
 */
public interface ProjectFundsService {
    TableDataInfo<ProjectFundsManagementVO> queryPageList(ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery);

    /**
     * 根据项目id获取项目经费信息
     *
     * @param projectId
     *
     * @return {@link ProjectFundsVO}
     */
    ProjectFundsVO selectProjectFundsVOById(Long projectId);

    /**
     * 新增项目经费信息
     *
     * @param projectFundsBO
     * @param projectId
     */
    void insertProjectFunds(ProjectFundsBO projectFundsBO, Long projectId);

    /**
     * 根据项目id删除项目经费信息
     *
     * @param projectId
     */
    void deleteProjectFundsById(Long projectId);

    /**
     * 更新项目经费信息
     *
     * @param projectFundsBO
     * @param projectId
     */
    void updateProjectFunds(ProjectFundsBO projectFundsBO, Long projectId);

    /**
     * 根据项目id获取项目经费信息Map
     *
     * @param projectIdList
     *
     * @return {@link Map}<{@link Long}, {@link ProjectFunds}>
     */
    Map<Long, ProjectFunds> getProjectFundsMapByProjectIdList(List<Long> projectIdList);
}
