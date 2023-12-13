package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.project.domain.ProjectBaseInfo;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.vo.ProjectBaseInfoVO;
import com.ruoyi.project.mapper.ProjectBaseInfoMapper;
import com.ruoyi.project.service.*;
import com.ruoyi.system.domain.SysOssConfig;
import com.ruoyi.system.domain.vo.SysOssConfigVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bailingnan
 * @date 2023/12/11
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    private final ProjectBaseInfoService projectBaseInfoService;

    private final ProjectFundsService projectFundsService;

    private final ProjectMilestoneService projectMilestoneService;

    private final ProjectAttachmentService projectAttachmentService;

    private final ProjectTargetService projectTargetService;

    private final ProjectUserService projectUserService;


    /**
     * 删除项目
     *
     * @param projectId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteProject(Long projectId) {
        //删除基本信息
        projectBaseInfoService.deleteProjectBaseInfoById(projectId);
        //删除大事记
        projectMilestoneService.deleteMilestoneByProjectId(projectId);
        //删除经费
        projectFundsService.deleteProjectFundsById(projectId);
        //删除指标
        projectTargetService.deleteTargetByProjectId(projectId);
        //删除附件
        projectAttachmentService.deleteAllProjectAttachmentByProID(projectId);
        //删除成员
        projectUserService.deleteProjectUsersByProID(projectId);
    }
}
