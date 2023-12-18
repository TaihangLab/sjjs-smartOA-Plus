package com.ruoyi.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.project.domain.*;
import com.ruoyi.project.domain.bo.*;
import com.ruoyi.project.domain.vo.ProjectDetailsVO;
import com.ruoyi.project.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
     * @param projectInfoBO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addProject(ProjectInfoBO projectInfoBO) {
        if (projectInfoBO == null) {
            throw new IllegalArgumentException("projectInfoBO cannot be null");
        }

        ProjectBaseInfo projectBaseInfo = copyAndInsertProjectBaseInfo(projectInfoBO.getProjectBaseInfoBO());
        Long projectId = projectBaseInfo.getProjectId();

        insertProjectUsers(projectInfoBO.getProjectUserBoList(), projectId);
        insertProjectFunds(projectInfoBO.getProjectFundsBO(), projectId);
        insertProjectTargets(projectInfoBO.getProjectTargetBOList(), projectId);
        insertProjectAttachments(projectInfoBO.getProjectAttachmentBOList(), projectId);
    }

    private ProjectBaseInfo copyAndInsertProjectBaseInfo(ProjectBaseInfoBO projectBaseInfoBO) {
        if (projectBaseInfoBO == null) {
            throw new IllegalArgumentException("projectBaseInfoBO cannot be null");
        }

        ProjectBaseInfo projectBaseInfo = new ProjectBaseInfo();
        BeanCopyUtils.copy(projectBaseInfoBO, projectBaseInfo);
        projectBaseInfoService.insertProjectBaseInfo(projectBaseInfo);
        return projectBaseInfo;
    }


    private void insertProjectUsers(List<ProjectUserBo> projectUserBOList, Long projectId) {
        if (projectUserBOList != null && !projectUserBOList.isEmpty()) {
            List<ProjectUser> projectUserList = projectUserBOList.stream()
                .map(bo -> setProjectIdAndCopy(bo, projectId, ProjectUser.class))
                .collect(Collectors.toList());
            projectUserService.insertProjectUsers(projectUserList);
        }
    }

    private void insertProjectFunds(ProjectFundsBO projectFundsBO, Long projectId) {
        if (projectFundsBO != null) {
            ProjectFunds projectFunds = setProjectIdAndCopy(projectFundsBO, projectId, ProjectFunds.class);
            projectFundsService.insertProjectFunds(projectFunds);
        }
    }

    private void insertProjectTargets(List<ProjectTargetBO> projectTargetBOList, Long projectId) {
        if (projectTargetBOList != null && !projectTargetBOList.isEmpty()) {
            List<ProjectTarget> projectTargetList = projectTargetBOList.stream()
                .map(bo -> setProjectIdAndCopy(bo, projectId, ProjectTarget.class))
                .collect(Collectors.toList());
            projectTargetService.insertProjectTargetList(projectTargetList);
        }
    }

    private void insertProjectAttachments(List<ProjectAttachmentBO> projectAttachmentBOList, Long projectId) {
        if (projectAttachmentBOList != null && !projectAttachmentBOList.isEmpty()) {
            List<ProjectAttachment> projectAttachmentList = projectAttachmentBOList.stream()
                .map(bo -> setProjectIdAndCopy(bo, projectId, ProjectAttachment.class))
                .collect(Collectors.toList());
            projectAttachmentService.insertProjectAttachmentList(projectAttachmentList);
        }
    }

    private <T, R> R setProjectIdAndCopy(T bo, Long projectId, Class<R> clazz) {
        BeanUtil.setProperty(bo, "projectId", projectId);
        return BeanCopyUtils.copy(bo, clazz);
    }

    /**
     * @param projectInfoBO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProject(ProjectInfoBO projectInfoBO) {
        if (projectInfoBO == null) {
            throw new IllegalArgumentException("projectInfoBO cannot be null");
        }
        copyAndUpdateProjectBaseInfo(projectInfoBO.getProjectBaseInfoBO());
        Long projectId = projectInfoBO.getProjectBaseInfoBO().getProjectId();
        updateProjectUsers(projectInfoBO.getProjectUserBoList(), projectId);
        updateProjectFunds(projectInfoBO.getProjectFundsBO(), projectId);
        updateProjectTargets(projectInfoBO.getProjectTargetBOList(), projectId);
        updateProjectAttachments(projectInfoBO.getProjectAttachmentBOList(), projectId);
    }

    private void copyAndUpdateProjectBaseInfo(ProjectBaseInfoBO projectBaseInfoBO) {
        ProjectBaseInfo projectBaseInfo = new ProjectBaseInfo();
        BeanCopyUtils.copy(projectBaseInfoBO, projectBaseInfo);
        projectBaseInfoService.updateProjectBaseInfoById(projectBaseInfo);
    }

    private void updateProjectUsers(List<ProjectUserBo> projectUserBOList, Long projectId) {
        projectUserService.deleteProjectUsersByProID(projectId);
        if (projectUserBOList != null && !projectUserBOList.isEmpty()) {
            List<ProjectUser> projectUserList = projectUserBOList.stream()
                .map(bo -> setProjectIdAndCopy(bo, projectId, ProjectUser.class))
                .collect(Collectors.toList());
            projectUserService.insertProjectUsers(projectUserList);
        }
    }

    private void updateProjectFunds(ProjectFundsBO projectFundsBO, Long projectId) {
        if (projectFundsBO != null) {
            ProjectFunds projectFunds = setProjectIdAndCopy(projectFundsBO, projectId, ProjectFunds.class);
            projectFundsService.saveOrUpdateProjectFunds(projectFunds, projectId);
        } else {
            projectFundsService.deleteProjectFundsById(projectId);
        }
    }

    private void updateProjectTargets(List<ProjectTargetBO> projectTargetBOList, Long projectId) {
        projectTargetService.deleteTargetByProjectId(projectId);
        if (projectTargetBOList != null && !projectTargetBOList.isEmpty()) {
            List<ProjectTarget> projectTargetList = projectTargetBOList.stream()
                .map(bo -> setProjectIdAndCopy(bo, projectId, ProjectTarget.class))
                .collect(Collectors.toList());
            projectTargetService.insertProjectTargetList(projectTargetList);
        }
    }

    private void updateProjectAttachments(List<ProjectAttachmentBO> projectAttachmentBOList, Long projectId) {
        projectAttachmentService.deleteAllProjectAttachmentByProID(projectId);
        if (projectAttachmentBOList != null && !projectAttachmentBOList.isEmpty()) {
            List<ProjectAttachment> projectAttachmentList = projectAttachmentBOList.stream()
                .map(bo -> setProjectIdAndCopy(bo, projectId, ProjectAttachment.class))
                .collect(Collectors.toList());
            projectAttachmentService.insertProjectAttachmentList(projectAttachmentList);
        }
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
