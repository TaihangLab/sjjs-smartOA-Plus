package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.domain.ProjectPlan;
import com.ruoyi.project.domain.bo.ProjectPlanBO;
import com.ruoyi.project.domain.vo.ProjectPlanVO;
import com.ruoyi.project.mapper.ProjectPlanMapper;
import com.ruoyi.project.service.projectPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
     * @param projectPlanBOList
     */
    @Override
    public void insertProjectPlanList(List<ProjectPlanBO> projectPlanBOList, Long projectId) {
        if (projectPlanBOList == null || projectPlanBOList.isEmpty()) {
            return;
        }
        List<ProjectPlan> projectPlanList = projectPlanBOList.stream()
            .map(bo -> projectPlanConverter(bo, projectId))
            .collect(Collectors.toList());
        projectPlanMapper.insertBatch(projectPlanList);
    }

    /**
     * @param projectPlanList
     */
    @Override
    public void insertProjectPlanList(List<ProjectPlan> projectPlanList) {
        if (projectPlanList == null || projectPlanList.isEmpty()) {
            return;
        }
        projectPlanMapper.insertBatch(projectPlanList);

    }

    private ProjectPlan projectPlanConverter(ProjectPlanBO bo, Long projectId) {
        ProjectPlan projectPlan = new ProjectPlan();
        BeanCopyUtils.copy(bo, projectPlan);
        projectPlan.setProjectId(projectId);
        Optional.ofNullable(bo.getStageStartDate())
            .ifPresent(date -> projectPlan.setStageStartDate(DateUtils.yearMonthToLocalDate(date)));
        Optional.ofNullable(bo.getStageEndDate())
            .ifPresent(endDate -> projectPlan.setStageEndDate(DateUtils.yearMonthToLocalDate(endDate)));
        return projectPlan;
    }

    /**
     * @param projectId
     */
    @Override
    public void deleteProjectPlanByProjectId(Long projectId) {
        projectPlanMapper.delete(new LambdaQueryWrapper<ProjectPlan>().eq(ProjectPlan::getProjectId, projectId));
    }

    /**
     * @param stageIdList
     */
    @Override
    public void deleteProjectPlanByStageIdList(List<Long> stageIdList) {
        projectPlanMapper.delete(new LambdaQueryWrapper<ProjectPlan>().in(ProjectPlan::getStageId, stageIdList));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProjectPlanList(List<ProjectPlanBO> projectPlanBOList, Long projectId) {
        List<ProjectPlan> oldProjectPlanList = projectPlanMapper.selectList(new LambdaQueryWrapper<ProjectPlan>().eq(ProjectPlan::getProjectId, projectId));
        if (projectPlanBOList == null || projectPlanBOList.isEmpty()) {
            if (oldProjectPlanList.isEmpty()) {
                return;
            } else {
                deleteProjectPlanByProjectId(projectId);
                return;
            }
        } else {
            if (oldProjectPlanList.isEmpty()) {
                insertProjectPlanList(projectPlanBOList, projectId);
                return;
            }
        }
        List<ProjectPlan> newProjectPlanList = projectPlanBOList.stream()
            .map(bo -> projectPlanConverter(bo, projectId))
            .collect(Collectors.toList());
        // 转换为 HashSet 提高查找效率
        Set<ProjectPlan> oldProjectPlanSet = new HashSet<>(oldProjectPlanList);
        Set<ProjectPlan> newProjectPlanSet = new HashSet<>(newProjectPlanList);
        // 使用 Stream API 计算差集
        List<ProjectPlan> addProjectPlanList = newProjectPlanList.stream()
            .filter(projectPlan -> !oldProjectPlanSet.contains(projectPlan))
            .collect(Collectors.toList());
        List<ProjectPlan> delProjectPlanList = oldProjectPlanList.stream()
            .filter(projectPlan -> !newProjectPlanSet.contains(projectPlan))
            .collect(Collectors.toList());
        if (!addProjectPlanList.isEmpty()) {
            insertProjectPlanList(addProjectPlanList);
        }
        if (!delProjectPlanList.isEmpty()) {
            deleteProjectPlanByStageIdList(delProjectPlanList.stream().map(ProjectPlan::getStageId).collect(Collectors.toList()));
        }
    }
}
