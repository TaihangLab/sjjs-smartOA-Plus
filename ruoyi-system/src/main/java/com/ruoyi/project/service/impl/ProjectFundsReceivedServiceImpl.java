package com.ruoyi.project.service.impl;

import com.ruoyi.project.domain.ProjectFundsReceived;
import com.ruoyi.project.domain.bo.ProjectMilestoneBo;
import com.ruoyi.project.mapper.ProjectFundsReceivedMapper;
import com.ruoyi.project.mapper.ProjectMilestoneMapper;
import com.ruoyi.project.service.ProjectFundsReceivedService;
import com.ruoyi.project.service.ProjectMilestoneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flowable.cmmn.model.Milestone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addFundsReceived(ProjectFundsReceived fundsReceived) {
        // 检查参数是否为null
        if (fundsReceived == null) {
            throw new RuntimeException("fundsReceived cannot be null");
        }

        // 插入专项经费到账信息到数据库
        int rows = projectFundsReceivedMapper.insert(fundsReceived);

        // 获取到账金额、来款单位和到账日期
        BigDecimal amountReceived = fundsReceived.getAmountReceived();
        String receivedFrom = fundsReceived.getReceivedFrom();
        LocalDate receivedDate = fundsReceived.getReceivedDate();
        ProjectMilestoneBo milestoneBo = new ProjectMilestoneBo();

        // 如果插入成功，则创建一个项目大事记记录
        if (rows > 0) {
            // 设置大事记标题为“专项经费到账”
            milestoneBo.setMilestoneTitle("专项经费到账");
            // 设置大事记备注，包括到账日期、到账金额和来款单位信息
            milestoneBo.setMilestoneRemark("专项经费到账日期：" + receivedDate.toString() + ",到账金额：" + amountReceived.toString() + ",到账日期：" + receivedFrom);
            // 如果存在ossId，则创建一个ossIds列表，并将ossId加入列表，再设置给大事记对象
            if (fundsReceived.getOssId() != null) {
                List<Long> ossIds = new ArrayList<>();
                ossIds.add(fundsReceived.getOssId());
                milestoneBo.setOssIds(ossIds);
            }
            milestoneBo.setProjectId(fundsReceived.getProjectId());
            // 设置大事记日期为到账日期
            milestoneBo.setMilestoneDate(receivedDate);
        }
        // 调用项目大事记服务的方法插入项目大事记记录，并返回结果
        return projectMilestoneService.insertProjectMilestone(milestoneBo);
    }


    @Override
    public boolean updateFundsReceived(ProjectFundsReceived fundsReceived) {
        return false;
    }

    @Override
    public boolean deleteFundsReceivedById(Long receivedId) {
        return false;
    }

    @Override
    public ProjectFundsReceived getFundsReceivedById(Long receivedId) {
        return null;
    }

    @Override
    public List<ProjectFundsReceived> getAllFundsReceived() {
        return null;
    }

    @Override
    public List<ProjectFundsReceived> getFundsReceivedByCondition() {
        return null;
    }
}
