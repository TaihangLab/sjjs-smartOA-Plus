package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.project.domain.ProjectFunds;
import com.ruoyi.project.domain.ProjectIndirectFunds;
import com.ruoyi.project.domain.vo.ProjectFundsVO;
import com.ruoyi.project.mapper.ProjectFundsMapper;
import com.ruoyi.project.mapper.ProjectIndirectFundsMapper;
import com.ruoyi.project.service.ProjectFundsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author bailingnan
 * @date 2023/12/7
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ProjectFundsServiceImpl implements ProjectFundsService {

    private final ProjectFundsMapper projectFundsMapper;

    private final ProjectIndirectFundsMapper projectIndirectFundsMapper;


    /**
     * 根据项目ID查询所有经费
     *
     * @param projectId
     * @return
     */
    @Override
    public ProjectFundsVO selectProjectFunds(Long projectId) {
        ProjectFundsVO projectFundsVO = new ProjectFundsVO();
        projectFundsMapper.selectList(new LambdaQueryWrapper<ProjectFunds>().eq(ProjectFunds::getProjectId, projectId))
            .stream()
            .findFirst()
            .ifPresent(projectFunds -> BeanCopyUtils.copy(projectFunds, projectFundsVO));
        List<ProjectIndirectFunds> projectIndirectFundsList = projectIndirectFundsMapper.selectList(new LambdaQueryWrapper<ProjectIndirectFunds>().eq(ProjectIndirectFunds::getProjectId, projectId));
        projectFundsVO.setProjectIndirectFundsList(projectIndirectFundsList);
        return projectFundsVO;
    }

    /**
     * 新增项目经费
     * @param projectFunds
     * @return
     */
    @Override
    public int insertProjectFunds(ProjectFunds projectFunds) {
        if(projectFunds == null){
            return 0;
        }
        return projectFundsMapper.insert(projectFunds);
    }

    /**
     * 新增项目间接经费
     * @param projectIndirectFunds
     * @return
     */
    @Override
    public int insertProjectIndirectFunds(ProjectIndirectFunds projectIndirectFunds) {
        if(projectIndirectFunds == null){
            return 0;
        }
        return projectIndirectFundsMapper.insert(projectIndirectFunds);
    }

    /**
     * 更新项目经费
     * @param projectFunds
     * @return
     */
    @Override
    public int updateProjectFunds(ProjectFunds projectFunds) {
        if(projectFunds==null){
            return 0;
        }
        return projectFundsMapper.update(projectFunds, new LambdaQueryWrapper<ProjectFunds>().eq(ProjectFunds::getProjectId, projectFunds.getProjectId()));
    }

    /**
     * 更新项目间接经费
     * @param projectIndirectFunds
     * @return
     */
    @Override
    public int updateProjectIndirectFunds(ProjectIndirectFunds projectIndirectFunds) {
        if(projectIndirectFunds==null){
            return 0;
        }
        return projectIndirectFundsMapper.update(projectIndirectFunds, new LambdaQueryWrapper<ProjectIndirectFunds>().eq(ProjectIndirectFunds::getProjectId, projectIndirectFunds.getProjectId()));
    }

    /**
     * @param projectId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteProjectFundsById(Long projectId) {
        projectFundsMapper.delete(new LambdaQueryWrapper<ProjectFunds>().eq(ProjectFunds::getProjectId, projectId));
        projectIndirectFundsMapper.delete(new LambdaQueryWrapper<ProjectIndirectFunds>().eq(ProjectIndirectFunds::getProjectId, projectId));
    }
}
