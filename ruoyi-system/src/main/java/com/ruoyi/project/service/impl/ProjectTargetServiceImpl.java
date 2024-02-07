package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.project.domain.ProjectTarget;
import com.ruoyi.project.domain.bo.ProjectTargetBO;
import com.ruoyi.project.domain.vo.ProjectTargetVO;
import com.ruoyi.project.mapper.ProjectTargetMapper;
import com.ruoyi.project.service.ProjectTargetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 项目指标
 *
 * @author bailingnan
 * @date 2024/02/06
 */
@RequiredArgsConstructor
@Service
public class ProjectTargetServiceImpl implements ProjectTargetService {

    private final ProjectTargetMapper projectTargetMapper;

    /**
     * 新增多个项目指标
     *
     * @param projectTargets 项目指标信息列表
     * @return 结果
     */
    @Override
    public boolean insertProjectTargetList(List<ProjectTarget> projectTargets) {
        if (projectTargets.isEmpty()) {
            return false;
        }
        return projectTargetMapper.insertBatch(projectTargets);
    }

    /**
     * @param projectTargetBOList
     * @param projectId
     */
    @Override
    public void insertProjectTargetList(List<ProjectTargetBO> projectTargetBOList, Long projectId) {
        if (projectTargetBOList == null || projectTargetBOList.isEmpty()) {
            return;
        }
        List<ProjectTarget> projectTargetList = projectTargetBOList.stream()
            .map(bo -> {
                ProjectTarget projectTarget = new ProjectTarget();
                BeanCopyUtils.copy(bo, projectTarget);
                projectTarget.setProjectId(projectId);
                return projectTarget;
            })
            .collect(Collectors.toList());
	    insertProjectTargetList(projectTargetList);
    }


    /**
     * 查询某一项目对应的项目指标
     *
     * @param projectId 项目ID
     * @return 结果
     */
    @Override
    public List<ProjectTargetVO> selectTargetListByProjectId(Long projectId) {
        return projectTargetMapper.selectVoList(new LambdaQueryWrapper<ProjectTarget>()
            .eq(ProjectTarget::getProjectId, projectId));
    }

    /**
     * 删除某一项目对应的全部项目指标
     *
     * @param projectId 项目ID
     * @return 结果
     */
    @Override
    public int deleteTargetByProjectId(Long projectId) {
        return projectTargetMapper.delete(new LambdaQueryWrapper<ProjectTarget>().
            eq(ProjectTarget::getProjectId, projectId));
    }

    /**
     * @param targetIdList
     */
    @Override
    public void deleteProjectTargetByTargetIdList(List<Long> targetIdList) {
        if (targetIdList == null || targetIdList.isEmpty()) {
            return;
        }
	    projectTargetMapper.delete(new LambdaQueryWrapper<ProjectTarget>().in(ProjectTarget::getTargetId, targetIdList));

    }

    /**
     * 删除单条目指标
     *
     * @param targetId 项目指标ID
     * @return 结果
     */
    @Override
    public int deleteProjectTarget(Long targetId) {
        return projectTargetMapper.delete(new LambdaQueryWrapper<ProjectTarget>().
            eq(ProjectTarget::getTargetId, targetId));
    }

    /**
     * @param projectTargetBoList
     * @param projectId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProjectTargetList(List<ProjectTargetBO> projectTargetBoList, Long projectId) {
        List<ProjectTarget> oldProjectTargetList = projectTargetMapper.selectList(new LambdaQueryWrapper<ProjectTarget>().eq(ProjectTarget::getProjectId, projectId));
        if (projectTargetBoList == null || projectTargetBoList.isEmpty()) {
            if (oldProjectTargetList.isEmpty()) {
                return;
            } else {
	            deleteTargetByProjectId(projectId);
                return;
            }
        } else {
            if (oldProjectTargetList.isEmpty()) {
	            insertProjectTargetList(projectTargetBoList, projectId);
                return;
            }
        }
        List<ProjectTarget> newProjectTargetList = projectTargetBoList.stream()
            .map(bo -> {
                ProjectTarget projectTarget = new ProjectTarget();
                BeanCopyUtils.copy(bo, projectTarget);
                projectTarget.setProjectId(projectId);
                return projectTarget;
            })
            .collect(Collectors.toList());
        Set<ProjectTarget> oldProjectTargetSet = new HashSet<>(oldProjectTargetList);
        Set<ProjectTarget> newProjectTargetSet = new HashSet<>(newProjectTargetList);
        List<ProjectTarget> addProjectTargetList = newProjectTargetSet.stream()
            .filter(projectTarget -> !oldProjectTargetSet.contains(projectTarget))
            .collect(Collectors.toList());
        List<ProjectTarget> delProjectTargetList = oldProjectTargetSet.stream()
            .filter(projectTarget -> !newProjectTargetSet.contains(projectTarget))
            .collect(Collectors.toList());
        if (!addProjectTargetList.isEmpty()) {
	        insertProjectTargetList(addProjectTargetList);
        }
        if (!delProjectTargetList.isEmpty()) {
	        deleteProjectTargetByTargetIdList(delProjectTargetList.stream().map(ProjectTarget::getTargetId).collect(Collectors.toList()));
        }
    }

}
