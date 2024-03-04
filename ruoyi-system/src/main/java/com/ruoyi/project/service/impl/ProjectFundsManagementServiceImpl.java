package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.project.domain.ProjectBalance;
import com.ruoyi.project.domain.ProjectFunds;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.vo.ProjectFundsManagementVO;
import com.ruoyi.project.service.ProjectBalanceService;
import com.ruoyi.project.service.ProjectBaseInfoService;
import com.ruoyi.project.service.ProjectFundsManagementService;
import com.ruoyi.project.service.ProjectFundsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 项目经费管理Service
 *
 * @author bailingnan
 * @date 2024/03/04
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectFundsManagementServiceImpl implements ProjectFundsManagementService {
    private final ProjectBaseInfoService projectBaseInfoService;

    private final ProjectBalanceService projectBalanceService;

    private final ProjectFundsService projectFundsService;

    @Override
    public TableDataInfo<ProjectFundsManagementVO> queryPageList(ProjectBaseInfoBO projectBaseInfoBO,
        PageQuery pageQuery) {
        Page<ProjectFundsManagementVO> page =
            projectBaseInfoService.queryPageAllList(projectBaseInfoBO, pageQuery, ProjectFundsManagementVO.class);
        buildRecords(page.getRecords());
        return TableDataInfo.build(page);
    }

    private void buildRecords(List<ProjectFundsManagementVO> projectFundsManagementVOList) {
        if (projectFundsManagementVOList == null || projectFundsManagementVOList.isEmpty()) {
            return;
        }
        List<Long> projectIdList = projectFundsManagementVOList.stream().map(ProjectFundsManagementVO::getProjectId)
            .collect(Collectors.toList());
        //获取经费对应信息
        Map<Long, ProjectFunds> projectFundsMap = projectFundsService.getProjectFundsMapByProjectIdList(projectIdList);
        //获取余额对应信息
        Map<Long, ProjectBalance> projectBalanceMap =
            projectBalanceService.getProjectBalanceMapByPorjectIdList(projectIdList);

        projectFundsManagementVOList.forEach(projectFundsManagementVO -> {
            Long projectId = projectFundsManagementVO.getProjectId();
            //处理经费
            ProjectFunds projectFunds = projectFundsMap.get(projectId);
            setFunds(projectFundsManagementVO, projectFunds);
            ProjectBalance projectBalance = projectBalanceMap.get(projectId);
            setBalance(projectFundsManagementVO, projectBalance);
        });
    }

    private void setFunds(ProjectFundsManagementVO projectFundsManagementVO, ProjectFunds projectFunds) {
        if (projectFunds != null) {
            projectFundsManagementVO.setTotalFundsAll(projectFunds.getTotalFundsAll());
            projectFundsManagementVO.setTotalFundsZx(projectFunds.getTotalFundsZx());
            projectFundsManagementVO.setTotalFundsZc(projectFunds.getTotalFundsZc());
        }
    }

    private void setBalance(ProjectFundsManagementVO projectFundsManagementVO, ProjectBalance projectBalance) {
        if (projectBalance != null) {
            projectFundsManagementVO.setTotalFundsAllPaid(projectBalance.getTotalFundsAllPaid());
            projectFundsManagementVO.setTotalFundsZxPaid(projectBalance.getTotalFundsZxPaid());
            projectFundsManagementVO.setTotalFundsZcPaid(projectBalance.getTotalFundsZcPaid());
            projectFundsManagementVO.setTotalFundsAllUnpaid(projectBalance.getTotalFundsAllUnpaid());
            projectFundsManagementVO.setTotalFundsZxUnpaid(projectBalance.getTotalFundsZxUnpaid());
            projectFundsManagementVO.setTotalFundsZcUnpaid(projectBalance.getTotalFundsZcUnpaid());
        }
    }
}
