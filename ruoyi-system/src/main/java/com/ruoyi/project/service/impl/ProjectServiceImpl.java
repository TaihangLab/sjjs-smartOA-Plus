package com.ruoyi.project.service.impl;

import com.ruoyi.project.domain.vo.ProjectDetailsVO;
import com.ruoyi.project.service.*;
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
     * @param projectId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProjectDetailsVO getProjectDetails(Long projectId) {
        ProjectDetailsVO projectDetailsVO = new ProjectDetailsVO();
        //项目信息
        projectDetailsVO.setProjectInfoVO(projectBaseInfoService.selectProjectInfoVOById(projectId));
        //成员信息
        projectDetailsVO.setProjectUserVoList(projectUserService.getUserInfoByProjectId(projectId));
        //经费信息
        projectDetailsVO.setProjectFundsVO(projectFundsService.selectProjectFundsVOById(projectId));
        //指标信息
        projectDetailsVO.setProjectTargetVOList(projectTargetService.selectTargetListByProjectId(projectId));
        //附件信息
        projectDetailsVO.setProjectAttachmentVOList(projectAttachmentService.selectSysOssVOListByProId(projectId));
        return projectDetailsVO;
    }
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
