package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.domain.ProjectPlan;
import com.ruoyi.project.domain.vo.ProjectPlanVO;
import com.ruoyi.project.mapper.ProjectPlanMapper;
import com.ruoyi.project.service.projectPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bailingnan
 * @date 2023/12/21
 */
@Service
@RequiredArgsConstructor
public class peojectPlanServiceImpl implements projectPlanService {
    private final ProjectPlanMapper projectPlanMapper;


    /**
     * @param projectId
     * @return
     */
    @Override
    public List<ProjectPlanVO> selectProjectPlanVOListByProjectId(Long projectId) {
        List<ProjectPlan> projectPlanList = projectPlanMapper.selectList(new LambdaQueryWrapper<ProjectPlan>().eq(ProjectPlan::getProjectId, projectId).orderByAsc(ProjectPlan::getStageStartDate).orderByAsc(ProjectPlan::getStageEndDate));
        return projectPlanList.stream().map(projectPlan -> {
            ProjectPlanVO projectPlanVO = new ProjectPlanVO();
            projectPlanVO.setStageStartDate(DateUtils.localDateToYearMonth(projectPlan.getStageStartDate()));
            projectPlanVO.setStageEndDate(DateUtils.localDateToYearMonth(projectPlan.getStageEndDate()));
            projectPlanVO.setStageTask(projectPlan.getStageTask());
            return projectPlanVO;
        }).collect(Collectors.toList());
    }

    /**
     * @param projectPlanList
     */
    @Override
    public void insertProjectPlanList(List<ProjectPlan> projectPlanList) {
        projectPlanMapper.insertBatch(projectPlanList);
    }

    /**
     * @param projectId
     */
    @Override
    public void deleteProjectPlanByProjectId(Long projectId) {
        projectPlanMapper.delete(new LambdaQueryWrapper<ProjectPlan>().eq(ProjectPlan::getProjectId, projectId));
    }

}
