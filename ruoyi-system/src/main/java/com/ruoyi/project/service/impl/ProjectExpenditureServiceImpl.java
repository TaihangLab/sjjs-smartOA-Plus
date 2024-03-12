package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.project.domain.ProjectExpenditure;
import com.ruoyi.project.domain.bo.ProjectExpenditureBO;
import com.ruoyi.project.mapper.ProjectExpenditureMapper;
import com.ruoyi.project.service.ProjectExpenditureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 项目支出Service
 *
 * @author bailingnan
 * @date 2024/03/01
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectExpenditureServiceImpl implements ProjectExpenditureService{
    private final ProjectExpenditureMapper projectExpenditureMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addProjectExpenditureList(List<ProjectExpenditureBO> projectExpenditureBOList) {
        if (projectExpenditureBOList == null || projectExpenditureBOList.isEmpty()) {
            return;
        }
        //TODO:每一条需要判断是否超出预算，暂时先批量插入
        List<ProjectExpenditure> projectExpenditureList =
            BeanCopyUtils.copyList(projectExpenditureBOList, ProjectExpenditure.class);
        projectExpenditureMapper.insertBatch(projectExpenditureList);
    }

    /**
     * 查询项目支出明细
     * @param projectId
     * @return
     */
    public List<ProjectExpenditure> getProjectExpenditureByProId(Long projectId){
        return projectExpenditureMapper.selectList(new LambdaQueryWrapper<ProjectExpenditure>()
            .eq(ProjectExpenditure::getProjectId,projectId));
    }
}
