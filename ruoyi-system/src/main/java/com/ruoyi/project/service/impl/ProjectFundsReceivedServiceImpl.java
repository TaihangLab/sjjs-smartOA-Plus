package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.project.domain.ProjectFunds;
import com.ruoyi.project.domain.ProjectFundsReceived;
import com.ruoyi.project.domain.ProjectMilestoneOss;
import com.ruoyi.project.domain.bo.ProjectFundsBO;
import com.ruoyi.project.domain.bo.ProjectMilestoneBo;
import com.ruoyi.project.domain.vo.ProjectFundsReceivedVo;
import com.ruoyi.project.domain.vo.ProjectMilestoneVo;
import com.ruoyi.project.mapper.ProjectFundsReceivedMapper;
import com.ruoyi.project.mapper.ProjectMilestoneMapper;
import com.ruoyi.project.mapper.ProjectMilestoneOssMapper;
import com.ruoyi.project.service.ProjectFundsReceivedService;
import com.ruoyi.project.service.ProjectFundsService;
import com.ruoyi.project.service.ProjectMilestoneService;
import com.ruoyi.system.domain.SysOss;
import com.ruoyi.system.mapper.SysOssMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flowable.cmmn.model.Milestone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 专项经费经费到账
 *
 * @Author 范佳兴
 * @date 2024/2/29 11:15
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ProjectFundsReceivedServiceImpl implements ProjectFundsReceivedService {

    private final ProjectFundsReceivedMapper projectFundsReceivedMapper;

    private final ProjectMilestoneService projectMilestoneService;

    private final ProjectFundsService projectFundsService;

    private final ProjectMilestoneOssMapper projectMilestoneOssMapper;

    private final SysOssMapper sysOssMapper;



    /**
     * 添加专项经费到账信息
     *
     * @param fundsReceived 专项经费到账对象
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public int addFundsReceived(ProjectFundsReceived fundsReceived) {
        if (fundsReceived == null) {
            throw new RuntimeException("fundsReceived cannot be null");
        }

        // 插入项目大事记记录并获取 milestoneId
        Long milestoneId = insertProjectMilestone(fundsReceived);

        // 设置专项经费到账信息的 milestoneId
        fundsReceived.setMilestoneId(milestoneId);

        // 插入专项经费到账信息到数据库
        int rows = projectFundsReceivedMapper.insert(fundsReceived);

        // 汇算总额
        calculateTotalReceivedAmountByProId(fundsReceived.getProjectId());

        return rows;
    }

    /**
     * 经费到账同步项目大事记记录并返回 milestoneId
     *
     * @param fundsReceived 专项经费到账对象
     * @return 插入记录的 milestoneId
     */
    private Long insertProjectMilestone(ProjectFundsReceived fundsReceived) {
        BigDecimal amountReceived = fundsReceived.getAmountReceived();
        String receivedFrom = fundsReceived.getReceivedFrom();
        LocalDate receivedDate = fundsReceived.getReceivedDate();
        ProjectMilestoneBo milestoneBo = new ProjectMilestoneBo();

        // 设置大事记标题为“专项经费到账”
        milestoneBo.setMilestoneTitle("专项经费到账");
        // 设置大事记备注，包括到账日期、到账金额和来款单位信息
        milestoneBo.setMilestoneRemark("专项经费到账日期：" + receivedDate.toString() + ", 到账金额：" + amountReceived.toString() + ", 到账类型：" + receivedFrom+" 。");
        // 如果存在ossId，则创建一个ossIds列表，并将ossId加入列表，再设置给大事记对象
        if (!fundsReceived.getOssIds().isEmpty()) {
            List<Long> ossIds = new ArrayList<>(fundsReceived.getOssIds());
            milestoneBo.setOssIds(ossIds);
        }
        milestoneBo.setProjectId(fundsReceived.getProjectId());
        // 设置大事记日期为到账日期
        milestoneBo.setMilestoneDate(receivedDate);

        // 调用项目大事记服务的方法插入项目大事记记录，并获取 milestoneId
        projectMilestoneService.insertProjectMilestone(milestoneBo);
        return milestoneBo.getMilestoneId();
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateFundsReceived(ProjectFundsReceived fundsReceived) {
        deleteFundsReceivedById(fundsReceived.getReceivedId());
        int result = addFundsReceived(fundsReceived);

        // 汇算总额
        calculateTotalReceivedAmountByProId(fundsReceived.getProjectId());
        return result;
    }

    /**
     * 根据ID删除专项经费到账信息
     * @param receivedId 到账ID
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteFundsReceivedById(Long receivedId) {
        ProjectFundsReceived projectFundsReceived = projectFundsReceivedMapper.selectById(receivedId);
        Long milestoneId = projectFundsReceived.getMilestoneId();
        projectMilestoneService.deleteProjectMilestone(milestoneId);
        int result = projectFundsReceivedMapper.deleteById(receivedId);
        // 汇算总额
        calculateTotalReceivedAmountByProId(projectFundsReceived.getProjectId());
        return result;
    }

    /**
     * 根据项目ID查询专项经费到账信息
     *
     * @param projectId 项目ID
     * @return 查询到的专项经费到账对象，若不存在则返回 null
     */
    @Override
    public List<ProjectFundsReceivedVo> getFundsReceivedByProId(Long projectId) {

        List<ProjectFundsReceived> projectFundsReceiveds = projectFundsReceivedMapper.selectList(
            new LambdaQueryWrapper<ProjectFundsReceived>()
                .eq(ProjectFundsReceived::getProjectId, projectId)
                .orderByDesc(ProjectFundsReceived::getReceivedDate));
        List<ProjectFundsReceivedVo> projectFundsReceivedVos = new ArrayList<>();

        for (ProjectFundsReceived projectFundsReceived : projectFundsReceiveds) {
            ProjectFundsReceivedVo projectFundsReceivedVo = new ProjectFundsReceivedVo();
            BeanCopyUtils.copy(projectFundsReceived, projectFundsReceivedVo);

            Long milestoneId = projectFundsReceived.getMilestoneId();

            List<Long> ossIds = projectMilestoneOssMapper.selectList(new LambdaQueryWrapper<ProjectMilestoneOss>()
                    .eq(ProjectMilestoneOss::getMilestoneId, milestoneId))
                .stream().map(ProjectMilestoneOss::getOssId).collect(Collectors.toList());

            if (!ossIds.isEmpty()) {
                List<SysOss> sysOsses = sysOssMapper.selectList(new LambdaQueryWrapper<SysOss>()
                    .in(SysOss::getOssId, ossIds));
                projectFundsReceivedVo.setSysOsses(sysOsses);
            }
            projectFundsReceivedVos.add(projectFundsReceivedVo);
        }
        return projectFundsReceivedVos;
    }

    /**
     * 计算专项经费到账总额，并写入project_funds表中
     */
    private void calculateTotalReceivedAmountByProId(Long projectId) {
        // 根据 projectId 查询到该项目的到账信息列表
        List<ProjectFundsReceived> fundsReceivedList = projectFundsReceivedMapper.selectList(
            new LambdaQueryWrapper<ProjectFundsReceived>()
                .eq(ProjectFundsReceived::getProjectId, projectId));

        BigDecimal totalAmount = BigDecimal.ZERO; // 初始总金额为0
        if (!fundsReceivedList.isEmpty()) {
            // 遍历项目的到账信息列表，累加每笔到账金额
            for (ProjectFundsReceived fundsReceived : fundsReceivedList) {
                totalAmount = totalAmount.add(fundsReceived.getAmountReceived());
            }
        }

        //更新project_funds中的totalFundsZxDk
        projectFundsService.updateTotalFundsZxDk(totalAmount,projectId);
    }

}
