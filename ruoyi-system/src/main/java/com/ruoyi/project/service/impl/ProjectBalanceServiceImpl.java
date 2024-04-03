package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.project.domain.ProjectBalance;
import com.ruoyi.project.domain.ProjectBalancePaid;
import com.ruoyi.project.domain.ProjectBalanceUnpaid;
import com.ruoyi.project.domain.ProjectFunds;
import com.ruoyi.project.domain.vo.ProjectBalanceVO;
import com.ruoyi.project.domain.vo.ProjectFundsAndBalanceVO;
import com.ruoyi.project.domain.vo.ProjectFundsVO;
import com.ruoyi.project.mapper.ProjectBalanceMapper;
import com.ruoyi.project.mapper.ProjectBalancePaidMapper;
import com.ruoyi.project.mapper.ProjectBalanceUnpaidMapper;
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

    private final ProjectBalancePaidMapper projectBalancePaidMapper;
    private final ProjectBalanceUnpaidMapper projectBalanceUnpaidMapper;

    @Override
    public Map<Long, ProjectBalancePaid> getProjectBalancePaidMapByPorjectIdList(List<Long> projectIdList) {
        return projectBalancePaidMapper.selectList(
                new LambdaQueryWrapper<ProjectBalancePaid>().in(ProjectBalancePaid::getProjectId, projectIdList)).stream()
            .collect(Collectors.toMap(ProjectBalancePaid::getProjectId, projectBalancePaid -> projectBalancePaid));
    }

    @Override
    public Map<Long, ProjectBalanceUnpaid> getProjectBalanceUnpaidMapByPorjectIdList(List<Long> projectIdList) {
        return projectBalanceUnpaidMapper.selectList(
                new LambdaQueryWrapper<ProjectBalanceUnpaid>().in(ProjectBalanceUnpaid::getProjectId, projectIdList))
            .stream().collect(
                Collectors.toMap(ProjectBalanceUnpaid::getProjectId, projectBalanceUnpaid -> projectBalanceUnpaid));
    }

    /**
     * 根据项目ID查询项目经费预算和支出明细及汇总
     *
     * @param projectId
     * @return
     */
    @Override
    public ProjectFundsAndBalanceVO getFundsAndBalanceByProjectId(Long projectId) {
        ProjectFundsAndBalanceVO projectFundsAndBalanceVO = new ProjectFundsAndBalanceVO();
        ProjectFunds projectFunds = projectFundsMapper.selectOne(new LambdaQueryWrapper<ProjectFunds>()
            .eq(ProjectFunds::getProjectId, projectId));

        ProjectBalance projectBalance = projectBalanceMapper.selectOne(new LambdaQueryWrapper<ProjectBalance>()
            .eq(ProjectBalance::getProjectId, projectId));

        projectFundsAndBalanceVO.setProjectBalance(BeanCopyUtils.copy(projectBalance, ProjectBalanceVO.class));
        projectFundsAndBalanceVO.setProjectFunds(BeanCopyUtils.copy(projectFunds, ProjectFundsVO.class));
        return projectFundsAndBalanceVO;
    }

    @Override
    public void insertProjectBalancePaid(ProjectBalancePaid projectBalancePaid) {
        projectBalancePaidMapper.insert(projectBalancePaid);
    }

    @Override
    public void insertProjectBalanceUnpaid(ProjectBalanceUnpaid projectBalanceUnpaid) {
        projectBalanceUnpaidMapper.insert(projectBalanceUnpaid);
    }

    @Override
    public ProjectBalancePaid getProjectBalancePaidByProjectId(Long projectId) {
        return projectBalancePaidMapper.selectOne(
            new LambdaQueryWrapper<ProjectBalancePaid>().eq(ProjectBalancePaid::getProjectId, projectId));
    }

    @Override
    public ProjectBalanceUnpaid getProjectBalanceUnpaidByProjectId(Long projectId) {
        return projectBalanceUnpaidMapper.selectOne(
            new LambdaQueryWrapper<ProjectBalanceUnpaid>().eq(ProjectBalanceUnpaid::getProjectId, projectId));
    }

    @Override
    public void updateProjectBalancePaid(ProjectBalancePaid projectBalancePaid) {
        projectBalancePaidMapper.updateById(projectBalancePaid);
    }

    @Override
    public void updateProjectBanlanceUnpaid(ProjectBalanceUnpaid projectBalanceUnpaid) {
        projectBalanceUnpaidMapper.updateById(projectBalanceUnpaid);
    }

    @Override
    public void batchUpdateProjectBalancePaid(List<ProjectBalancePaid> projectBalancePaidList) {
        projectBalancePaidList.forEach(projectBalancePaidMapper::updateById);
    }

    @Override
    public void batchUpdateProjectBalanceUnpaid(List<ProjectBalanceUnpaid> projectBalanceUnpaidList) {
        projectBalanceUnpaidList.forEach(projectBalanceUnpaidMapper::updateById);
    }
}
