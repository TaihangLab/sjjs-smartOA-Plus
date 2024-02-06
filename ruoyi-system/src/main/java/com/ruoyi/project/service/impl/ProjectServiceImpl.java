package com.ruoyi.project.service.impl;

import com.ruoyi.project.domain.bo.ProjectInfoBO;
import com.ruoyi.project.domain.vo.ProjectDetailsVO;
import com.ruoyi.project.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 项目
 *
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

    private final projectPlanService projectPlanService;

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
	    projectUserService.deleteProjectUsersByProjectId(projectId);
        //删除计划
	    projectPlanService.deleteProjectPlanByProjectId(projectId);
    }

    /**
     * 获取项目详细信息
     *
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
        //计划信息
        projectDetailsVO.setProjectPlanVOList(projectPlanService.selectProjectPlanVOListByProjectId(projectId));
        return projectDetailsVO;
    }

    /**
     * 新增项目
     *
     * @param projectInfoBO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addProject(ProjectInfoBO projectInfoBO) {
        if (projectInfoBO == null) {
            throw new IllegalArgumentException("projectInfoBO cannot be null");
        }

        //新增基础信息
        Long projectId = projectBaseInfoService.insertProjectBaseInfo(projectInfoBO.getProjectBaseInfoBO());

        //成员信息
	    projectUserService.insertProjectUsersOnCreate(projectInfoBO.getProjectUserBoList(), projectId);
        //经费信息
	    projectFundsService.insertProjectFunds(projectInfoBO.getProjectFundsBO(), projectId);
        //指标信息
	    projectTargetService.insertProjectTargetList(projectInfoBO.getProjectTargetBOList(), projectId);
        //附件信息
	    projectAttachmentService.insertProjectAttachmentList(projectInfoBO.getOssIdList(), projectId);
        //计划信息
	    projectPlanService.insertProjectPlanList(projectInfoBO.getProjectPlanBOList(), projectId);
    }

    /**
     * 更新项目
     *
     * @param projectInfoBO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProject(ProjectInfoBO projectInfoBO) {
        if (projectInfoBO == null) {
            throw new IllegalArgumentException("projectInfoBO cannot be null");
        }
        //更新基本信息
	    projectBaseInfoService.updateProjectBaseInfoById(projectInfoBO.getProjectBaseInfoBO());
        Long projectId = projectInfoBO.getProjectBaseInfoBO().getProjectId();
        //更新成员信息
	    projectUserService.updateProjectUsers(projectInfoBO.getProjectUserBoList(), projectId);
        //更新经费信息
	    projectFundsService.updateProjectFunds(projectInfoBO.getProjectFundsBO(), projectId);
        //更新指标信息
	    projectTargetService.updateProjectTargetList(projectInfoBO.getProjectTargetBOList(), projectId);
        //更新附件信息
	    projectAttachmentService.updateProjectAttachmentList(projectInfoBO.getOssIdList(), projectId);
        //更新计划信息
	    projectPlanService.updateProjectPlanList(projectInfoBO.getProjectPlanBOList(), projectId);
    }
}
