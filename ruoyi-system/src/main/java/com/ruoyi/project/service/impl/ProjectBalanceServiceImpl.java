package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.project.domain.ProjectBalance;
import com.ruoyi.project.domain.ProjectFunds;
import com.ruoyi.project.domain.vo.ProjectBalanceVO;
import com.ruoyi.project.mapper.ProjectBalanceMapper;
import com.ruoyi.project.mapper.ProjectFundsMapper;
import com.ruoyi.project.service.ProjectBalanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 项目余额Service
 *
 * @author bailingnan
 * @date 2024/03/01
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectBalanceServiceImpl implements ProjectBalanceService {

    private final ProjectFundsMapper projectFundsMapper;

    private final ProjectBalanceMapper projectBalanceMapper;

    @Override
    public Map<Long, ProjectBalance> getProjectBalanceMapByPorjectIdList(List<Long> projectIdList) {
        return projectBalanceMapper.selectList(
                new LambdaQueryWrapper<ProjectBalance>().in(ProjectBalance::getProjectId, projectIdList)).stream()
            .collect(Collectors.toMap(ProjectBalance::getProjectId, projectBalance -> projectBalance));
    }

    /**
     * 根据项目ID查询项目经费预算和支出明细及汇总
     *
     * @param projectId
     * @return
     */
    @Override
    public ProjectBalanceVO getFundsAndBalanceByProjectId(Long projectId) {
        ProjectBalanceVO projectBalanceVO = new ProjectBalanceVO();
        ProjectFunds projectFunds = projectFundsMapper.selectOne(new LambdaQueryWrapper<ProjectFunds>()
            .eq(ProjectFunds::getProjectId, projectId));

        ProjectBalance projectBalance = projectBalanceMapper.selectOne(new LambdaQueryWrapper<ProjectBalance>()
            .eq(ProjectBalance::getProjectId, projectId));

        projectBalanceVO.setProjectBalance(projectBalance);
        projectBalanceVO.setProjectFunds(projectFunds);
        return projectBalanceVO;
    }

    @Override
    public void insertProjectBalance(ProjectBalance projectBalance) {
        projectBalanceMapper.insert(projectBalance);
    }

    @Override
    public ProjectBalance getProjectBalanceByProjectId(Long projectId) {
        return projectBalanceMapper.selectOne(
            new LambdaQueryWrapper<ProjectBalance>().eq(ProjectBalance::getProjectId, projectId));
    }

    @Override
    public void updateProjectBalance(ProjectBalance projectBalance) {
        projectBalanceMapper.updateById(projectBalance);
    }

    @Override
    public void batchUpdateProjectBalance(List<ProjectBalance> projectBalanceList) {
        projectBalanceList.forEach(projectBalanceMapper::updateById);
    }
}
