package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectPlan;
import com.ruoyi.project.domain.bo.ProjectPlanBO;
import com.ruoyi.project.domain.vo.ProjectPlanVO;

import java.util.List;

/**
 * 项目计划Service接口
 *
 * @author bailingnan
 * @date 2023/12/21
 */
public interface projectPlanService {
    /**
     * 通过projectId获取项目计划
     *
     * @param projectId
     *
     * @return {@link List}<{@link ProjectPlanVO}>
     */
    List<ProjectPlanVO> selectProjectPlanVOListByProjectId(Long projectId);

    /**
     * 新增项目计划
     *
     * @param projectPlanBOList
     * @param projectId
     */
    void insertProjectPlanList(List<ProjectPlanBO> projectPlanBOList, Long projectId);

    /**
     * 新增项目计划
     *
     * @param projectPlanList
     */
    void insertProjectPlanList(List<ProjectPlan> projectPlanList);

    /**
     * 通过项目ID删除项目计划
     *
     * @param projectId
     */
    void deleteProjectPlanByProjectId(Long projectId);

    /**
     * 删除项目计划
     *
     * @param stageIdList
     */
    void deleteProjectPlanByStageIdList(List<Long> stageIdList);

    /**
     * 更新项目计划
     *
     * @param projectPlanBOList
     * @param projectId
     */
    void updateProjectPlanList(List<ProjectPlanBO> projectPlanBOList, Long projectId);
}
