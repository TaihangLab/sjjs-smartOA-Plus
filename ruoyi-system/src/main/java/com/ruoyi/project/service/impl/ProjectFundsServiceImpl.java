package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.project.domain.ProjectBalance;
import com.ruoyi.project.domain.ProjectFunds;
import com.ruoyi.project.domain.bo.ProjectFundsBO;
import com.ruoyi.project.domain.vo.ProjectFundsVO;
import com.ruoyi.project.mapper.ProjectFundsMapper;
import com.ruoyi.project.service.ProjectBalanceService;
import com.ruoyi.project.service.ProjectFundsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * 项目经费
 *
 * @author bailingnan
 * @date 2023/12/7
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectFundsServiceImpl implements ProjectFundsService {

    private final ProjectBalanceService projectBalanceService;

    private final ProjectFundsMapper projectFundsMapper;

    private final ConcurrentMap<String, String> fundsMapping;

    private final ConcurrentMap<String, String> fundsReverseMapping;

    private final ConcurrentMap<String, String> paidMapping;

    private final ConcurrentMap<String, String> paidReverseMapping;

    private final ConcurrentMap<String, String> unpaidMapping;

    private final ConcurrentMap<String, String> unpaidReverseMapping;

    /**
     * 根据项目ID查询所有经费
     *
     * @param projectId
     * @return
     */
    @Override
    public ProjectFundsVO selectProjectFundsVOById(Long projectId) {
        return projectFundsMapper.selectVoOne(new LambdaQueryWrapper<ProjectFunds>().eq(ProjectFunds::getProjectId, projectId));
    }

    /**
     * 新增项目经费
     *
     * @param
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertProjectFunds(ProjectFundsBO projectFundsBO, Long projectId) {
        ProjectFunds projectFunds = new ProjectFunds();
        BeanCopyUtils.copy(projectFundsBO, projectFunds);
        projectFunds.setProjectId(projectId);
        if (projectFundsMapper.insert(projectFunds) != 1) {
            throw new RuntimeException("新增项目经费失败");
        }
        synchronizeFundsToBalance(projectFunds);
    }

    /**
     * 预算同步到余额
     *
     * @param projectFunds
     */
    private void synchronizeFundsToBalance(ProjectFunds projectFunds) {
        Map<String, Object> fundsMap = BeanCopyUtils.copyToMap(projectFunds);
        if (fundsMap == null || fundsMap.isEmpty()) {
            return;
        }
        ProjectBalance projectBalance = new ProjectBalance();
        projectBalance.setFundsId(projectFunds.getFundsId());
        projectBalance.setProjectId(projectFunds.getProjectId());
        fundsMap.forEach((key, value) -> {
            if (fundsMapping.containsKey(key)) {
                BigDecimal amount = (BigDecimal)value;
                String balanceFieldName = unpaidReverseMapping.get(fundsMapping.get(key));
                if (balanceFieldName != null) {
                    try {
                        FieldUtils.writeField(projectBalance, balanceFieldName, amount, true);
                    } catch (IllegalAccessException e) {
                        // 日志记录或者其他异常处理
                        log.error("Error writing to field: {}", e.getMessage());
                    }
                }
            }
        });
        projectBalanceService.insertProjectBalance(projectBalance);
    }


    /**
     * @param projectId
     */
    @Override
    public void deleteProjectFundsById(Long projectId) {
	    projectFundsMapper.delete(new LambdaQueryWrapper<ProjectFunds>().eq(ProjectFunds::getProjectId, projectId));
    }

    /**
     * @param projectFundsBO
     * @param projectId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProjectFunds(ProjectFundsBO projectFundsBO, Long projectId) {
        ProjectFunds projectFunds = new ProjectFunds();
        BeanCopyUtils.copy(projectFundsBO, projectFunds);
        ProjectFunds projectFundsOld = projectFundsMapper.selectOne(
            new LambdaQueryWrapper<ProjectFunds>().eq(ProjectFunds::getProjectId, projectId));
        ProjectBalance projectBalance = projectBalanceService.getProjectBalanceByProjectId(projectId);
        updateBalance(projectFunds, projectFundsOld, projectBalance);
        projectFundsMapper.update(projectFunds,
            new LambdaUpdateWrapper<ProjectFunds>().eq(ProjectFunds::getProjectId, projectId));
    }

    private void updateBalance(ProjectFunds projectFunds, ProjectFunds projectFundsOld, ProjectBalance projectBalance) {
        Map<String, Object> fundsMap = BeanCopyUtils.copyToMap(projectFunds);
        Map<String, Object> fundsOldMap = BeanCopyUtils.copyToMap(projectFundsOld);
        fundsMap.forEach((key, value) -> {
            if (fundsMapping.containsKey(key)) {
                BigDecimal amount = (BigDecimal)value;
                BigDecimal amountOld = (BigDecimal)fundsOldMap.get(key);
                String unPaidBalanceFieldName = unpaidReverseMapping.get(fundsMapping.get(key));
                String paidBalanceFieldName = paidReverseMapping.get(fundsMapping.get(key));
                if (amount.compareTo(amountOld) > 0) {
                    try {
                        BigDecimal unPaidAmount =
                            (BigDecimal)FieldUtils.readField(projectBalance, unPaidBalanceFieldName, true);
                        unPaidAmount = unPaidAmount.add(amount.subtract(amountOld));
                        FieldUtils.writeField(projectBalance, unPaidBalanceFieldName, unPaidAmount, true);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                } else if (amount.compareTo(amountOld) < 0) {
                    try {
                        BigDecimal paidAmount =
                            (BigDecimal)FieldUtils.readField(projectBalance, paidBalanceFieldName, true);
                        //如果已支付余额大于修改后预算，抛出异常
                        if (paidAmount.compareTo(amount) > 0) {
                            throw new ServiceException("已支付金额大于修改后的预算");
                        }
                        BigDecimal unPaidAmount =
                            (BigDecimal)FieldUtils.readField(projectBalance, unPaidBalanceFieldName, true);
                        unPaidAmount = unPaidAmount.subtract(amountOld.subtract(amount));
                        FieldUtils.writeField(projectBalance, unPaidBalanceFieldName, unPaidAmount, true);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        //插入修改后的余额记录
        projectBalanceService.updateProjectBalance(projectBalance);
    }

    /**
     * 根据项目id获取项目经费信息Map
     *
     * @param projectIdList
     *
     * @return {@link Map}<{@link Long}, {@link ProjectFunds}>
     */
    @Override
    public Map<Long, ProjectFunds> getProjectFundsMapByProjectIdList(List<Long> projectIdList) {
        return projectFundsMapper.selectList(new LambdaQueryWrapper<ProjectFunds>().in(ProjectFunds::getProjectId, projectIdList))
            .stream().collect(Collectors.toMap(ProjectFunds::getProjectId, projectFunds -> projectFunds));
    }



    /**
     * 根据项目ID获取项目经费
     *
     * @param projectId
     *
     * @return {@link ProjectFunds}
     */
    public ProjectFunds getProjectFundsMapByProjectId(Long projectId) {
        return projectFundsMapper.selectOne(new LambdaQueryWrapper<ProjectFunds>()
            .eq(ProjectFunds::getProjectId,projectId));
    }
}
