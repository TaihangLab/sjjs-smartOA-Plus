package com.ruoyi.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.ruoyi.common.enums.ProjectUserRole;
import com.ruoyi.common.helper.LoginHelper;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.domain.*;
import com.ruoyi.project.domain.bo.*;
import com.ruoyi.project.domain.vo.ProjectDetailsVO;
import com.ruoyi.project.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private final projectPlanService projectPlanService;


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
        //计划信息
        projectDetailsVO.setProjectPlanVOList(projectPlanService.selectProjectPlanVOListByProjectId(projectId));
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
        insertProjectAttachments(projectInfoBO.getOssIdList(), projectId);
        insertProjectPlanList(projectInfoBO.getProjectPlanBOList(), projectId);
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
        if (projectUserBOList == null) {
            projectUserBOList = new ArrayList<>();
        }
        ProjectUserBo projectLoginUserBo = new ProjectUserBo();
        projectLoginUserBo.setUserId(LoginHelper.getUserId());
        projectLoginUserBo.setProjectUserRoleList(Collections.singletonList(ProjectUserRole.PROJECT_ENTRY_OPERATOR));
        projectUserBOList.add(projectLoginUserBo);
        List<ProjectUser> projectUserList = projectUserListConverter(projectUserBOList, projectId);
        projectUserService.insertProjectUsers(projectUserList);
    }

    private List<ProjectUser> projectUserListConverter(List<ProjectUserBo> projectUserBOList, Long projectId) {
        return projectUserBOList.stream()
            .flatMap(projectUserBo -> {
                List<ProjectUserRole> roles = projectUserBo.getProjectUserRoleList();
                if (roles == null || roles.isEmpty()) {
                    return Stream.empty();
                }
                return roles.stream()
                    .map(projectUserRole -> {
                        ProjectUser projectUser = new ProjectUser();
                        projectUser.setProjectId(projectId);
                        projectUser.setUserId(projectUserBo.getUserId());
                        projectUser.setProjectUserRole(projectUserRole);
                        return projectUser;
                    });
            })
            .collect(Collectors.toList());
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

    private void insertProjectAttachments(List<Long> ossIdList, Long projectId) {
        if (ossIdList != null && !ossIdList.isEmpty()) {
            List<ProjectAttachment> projectAttachmentList = ossIdList.stream()
                .map(ossId -> {
                    ProjectAttachment projectAttachment = new ProjectAttachment();
                    projectAttachment.setProjectId(projectId);
                    projectAttachment.setOssId(ossId);
                    return projectAttachment;
                })
                .collect(Collectors.toList());
            projectAttachmentService.insertProjectAttachmentList(projectAttachmentList);
        }
        //if (projectAttachmentBOList != null && !projectAttachmentBOList.isEmpty()) {
        //    List<ProjectAttachment> projectAttachmentList = projectAttachmentBOList.stream()
        //        .map(bo -> setProjectIdAndCopy(bo, projectId, ProjectAttachment.class))
        //        .collect(Collectors.toList());
        //    projectAttachmentService.insertProjectAttachmentList(projectAttachmentList);
        //}
    }

    private void insertProjectPlanList(List<ProjectPlanBO> projectPlanBOList, Long projectId) {
        if (projectPlanBOList != null && !projectPlanBOList.isEmpty()) {
            List<ProjectPlan> projectPlanList = projectPlanBOList.stream()
                .map(bo -> projectPlanDateConverter(bo, projectId))
                .collect(Collectors.toList());
            projectPlanService.insertProjectPlanList(projectPlanList);
        }
    }

    private <T, R> R setProjectIdAndCopy(T bo, Long projectId, Class<R> clazz) {
        BeanUtil.setProperty(bo, "projectId", projectId);
        return BeanCopyUtils.copy(bo, clazz);
    }

    private ProjectPlan projectPlanDateConverter(ProjectPlanBO bo, Long projectId) {
        ProjectPlan projectPlan = setProjectIdAndCopy(bo, projectId, ProjectPlan.class);
        Optional.ofNullable(bo.getStageStartDate())
            .ifPresent(date -> projectPlan.setStageStartDate(DateUtils.yearMonthToLocalDate(date)));
        Optional.ofNullable(bo.getStageEndDate())
            .ifPresent(endDate -> projectPlan.setStageEndDate(DateUtils.yearMonthToLocalDate(endDate)));
        return projectPlan;
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
        updateProjectAttachments(projectInfoBO.getOssIdList(), projectId);
        updateProjectPlanList(projectInfoBO.getProjectPlanBOList(), projectId);
    }

    private void copyAndUpdateProjectBaseInfo(ProjectBaseInfoBO projectBaseInfoBO) {
        ProjectBaseInfo projectBaseInfo = new ProjectBaseInfo();
        BeanCopyUtils.copy(projectBaseInfoBO, projectBaseInfo);
        projectBaseInfoService.updateProjectBaseInfoById(projectBaseInfo);
    }

    private void updateProjectUsers(List<ProjectUserBo> projectUserBOList, Long projectId) {
        projectUserService.deleteProjectUsersByProID(projectId);
        if (projectUserBOList != null && !projectUserBOList.isEmpty()) {
            List<ProjectUser> projectUserList = projectUserListConverter(projectUserBOList, projectId);
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

    private void updateProjectAttachments(List<Long> ossIdList, Long projectId) {
        projectAttachmentService.deleteAllProjectAttachmentByProID(projectId);
        if (ossIdList != null && !ossIdList.isEmpty()) {
            List<ProjectAttachment> projectAttachmentList = ossIdList.stream()
                .map(ossId -> {
                    ProjectAttachment projectAttachment = new ProjectAttachment();
                    projectAttachment.setProjectId(projectId);
                    projectAttachment.setOssId(ossId);
                    return projectAttachment;
                })
                .collect(Collectors.toList());
            projectAttachmentService.insertProjectAttachmentList(projectAttachmentList);
        }
    }

    private void updateProjectPlanList(List<ProjectPlanBO> projectPlanBOList, Long projectId) {
        projectPlanService.deleteProjectPlanByProjectId(projectId);
        if (projectPlanBOList != null && !projectPlanBOList.isEmpty()) {
            List<ProjectPlan> projectPlanList = projectPlanBOList.stream()
                .map(bo -> projectPlanDateConverter(bo, projectId))
                .collect(Collectors.toList());
            projectPlanService.insertProjectPlanList(projectPlanList);
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
        //删除计划
        projectPlanService.deleteProjectPlanByProjectId(projectId);
    }
}
