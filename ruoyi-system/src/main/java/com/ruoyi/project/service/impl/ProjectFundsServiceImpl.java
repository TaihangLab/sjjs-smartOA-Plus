package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
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
        if (projectFundsBO == null) {
            return;
        }
        ProjectFunds projectFunds = new ProjectFunds();
        BeanCopyUtils.copy(projectFundsBO, projectFunds);
        projectFunds.setProjectId(projectId);
        if (projectFundsMapper.insert(projectFunds) != 1) {
            throw new RuntimeException("新增项目经费失败");
        }
        //        synchronizeFundsToBalance(projectFunds);
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
            if (value != null && fundsMapping.containsKey(key)) {
                BigDecimal amount = (BigDecimal)value;
                String balanceFieldName = fundsReverseMapping.get(fundsMapping.get(key));
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
        //todo:保存余额

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
    public void updateProjectFunds(ProjectFundsBO projectFundsBO, Long projectId) {
        if (projectFundsBO == null) {
	        deleteProjectFundsById(projectId);
            return;
        }
        ProjectFunds projectFunds = new ProjectFunds();
        BeanCopyUtils.copy(projectFundsBO, projectFunds);
	    saveOrUpdateProjectFunds(projectFunds, projectId);
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


    private void saveOrUpdateProjectFunds(ProjectFunds projectFunds, Long projectId) {
        // 更新或插入操作
        boolean isUpdated = projectFundsMapper.update(projectFunds, new LambdaUpdateWrapper<ProjectFunds>().eq(ProjectFunds::getProjectId, projectId)) > 0;
        if (!isUpdated) {
	        projectFundsMapper.insert(projectFunds);
        }
    }

    /**
     * 根据项目ID获取项目经费
     *
     * @param projectId
     * @return
     */
    public ProjectFunds getProjectFundsMapByProjectId(Long projectId) {
        return projectFundsMapper.selectOne(new LambdaQueryWrapper<ProjectFunds>()
            .eq(ProjectFunds::getProjectId,projectId));
    }
}
