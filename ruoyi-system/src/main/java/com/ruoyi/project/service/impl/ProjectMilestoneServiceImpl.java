package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ruoyi.project.domain.ProjectMilestone;
import com.ruoyi.project.domain.ProjectTarget;
import com.ruoyi.project.mapper.ProjectMilestoneMapper;
import com.ruoyi.project.mapper.ProjectTargetMapper;
import com.ruoyi.project.service.ProjectMilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectMilestoneServiceImpl implements ProjectMilestoneService {

    private final ProjectMilestoneMapper baseMapper;

    /**
     * 新增单个项目大事记
     *
     * @param projectMilestone 项目指标信息
     * @return 结果
     */
    @Override
    public int insertProjectMilestone(ProjectMilestone projectMilestone) {
        if (projectMilestone == null) {
            return 0;
        }
        return baseMapper.insert(projectMilestone);
    }

    /**
     * 新增多个项目大事记
     *
     * @param projectMilestones 项目指标信息
     * @return 结果
     */
    @Override
    public boolean insertProjectMilestoneList(List<ProjectMilestone> projectMilestones) {
        if (projectMilestones.isEmpty()) {
            return false;
        }
        return baseMapper.insertBatch(projectMilestones);
    }

    /**
     * 删除某一项目对应的全部项目大事记
     *
     * @param projectId 项目ID
     * @return 结果
     */
    @Override
    public int deleteMilestoneByProjectId(Long projectId) {
        return baseMapper.delete(new LambdaQueryWrapper<ProjectMilestone>().
            eq(ProjectMilestone::getMilestoneId, projectId));
    }

    /**
     * 删除单条目大事记
     *
     * @param milestoneId 项目大事记ID
     * @return 结果
     */
    @Override
    public int deleteProjectMilestone(Long milestoneId) {
        return baseMapper.delete(new LambdaQueryWrapper<ProjectMilestone>().
            eq(ProjectMilestone::getMilestoneId, milestoneId));
    }

    /**
     * 修改项目大事记
     *
     * @param projectMilestone 项目大事记信息
     * @return 结果
     */
    @Override
    public int updateMilestoneByProjectId(ProjectMilestone projectMilestone, Long milestoneId) {
        LambdaUpdateWrapper<ProjectMilestone> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(ProjectMilestone::getMilestoneId, milestoneId);
        lambdaUpdateWrapper.set(ProjectMilestone::getMilestoneRemark, projectMilestone.getMilestoneRemark())
            .set(ProjectMilestone::getMilestoneTitle, projectMilestone.getMilestoneTitle())
            .set(ProjectMilestone::getMilestoneDate,projectMilestone.getMilestoneDate());
        return baseMapper.update(projectMilestone, lambdaUpdateWrapper);
    }

    @Override
    public List<ProjectMilestone> selectMilestoneListByProjectId(Long projectId) {
        return baseMapper.selectList(new LambdaQueryWrapper<ProjectMilestone>()
            .eq(ProjectMilestone::getProjectId, projectId));
    }
}
