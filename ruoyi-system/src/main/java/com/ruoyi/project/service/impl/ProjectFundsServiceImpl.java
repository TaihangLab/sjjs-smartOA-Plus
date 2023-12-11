package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ruoyi.project.domain.ProjectFunds;
import com.ruoyi.project.domain.ProjectIndirectFunds;
import com.ruoyi.project.mapper.ProjectFundsMapper;
import com.ruoyi.project.mapper.ProjectIndirectFundsMapper;
import com.ruoyi.project.service.ProjectFundsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
        LambdaUpdateWrapper<ProjectFunds> lambdaUpdateWrapper=new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(ProjectFunds::getProjectId,projectFunds.getProjectId());
        return projectFundsMapper.update(projectFunds,lambdaUpdateWrapper);
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
        LambdaUpdateWrapper<ProjectIndirectFunds> lambdaUpdateWrapper=new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(ProjectIndirectFunds::getProjectId,projectIndirectFunds.getProjectId());
        return projectIndirectFundsMapper.update(projectIndirectFunds,lambdaUpdateWrapper);
    }

}
