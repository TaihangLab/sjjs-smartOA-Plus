package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ruoyi.project.domain.ProjectTarget;
import com.ruoyi.project.mapper.ProjectTargetMapper;
import com.ruoyi.project.service.ProjectTargetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectTargetServiceImpl implements ProjectTargetService {

    private final ProjectTargetMapper projectTargetMapper;

    /**
     * 新增项目指标
     *
     * @param projectTarget 项目指标信息
     * @return 结果
     */
    @Override
    public int insertProjectTarget(ProjectTarget projectTarget) {
        if (projectTarget == null) {
            return 0;
        }
        return projectTargetMapper.insert(projectTarget);
    }

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
     * 查询某一项目对应的项目指标
     *
     * @param projectId 项目ID
     * @return 结果
     */
    @Override
    public List<ProjectTarget> selectTargetListByProjectId(Long projectId) {
        return projectTargetMapper.selectList(new LambdaQueryWrapper<ProjectTarget>()
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
     * 删除单条目指标
     *
     * @param targetId 项目指标ID
     * @return 结果
     */
    public int deleteProjectTarget(Long targetId) {
        return projectTargetMapper.delete(new LambdaQueryWrapper<ProjectTarget>().
            eq(ProjectTarget::getTargetId, targetId));
    }

    /**
     * 修改项目指标
     *
     * @param projectTarget 项目指标信息
     * @return 结果
     */
    public int updateProjectTarget(ProjectTarget projectTarget) {
        LambdaUpdateWrapper<ProjectTarget> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(ProjectTarget::getTargetId, projectTarget.getTargetId());
        lambdaUpdateWrapper.set(ProjectTarget::getTargetRemark, projectTarget.getTargetRemark())
            .set(ProjectTarget::getTargetName, projectTarget.getTargetName());
        return projectTargetMapper.update(projectTarget, lambdaUpdateWrapper);
    }

}
