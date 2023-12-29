package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ruoyi.project.domain.ProjectTarget;
import com.ruoyi.project.domain.vo.ProjectTargetVO;
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

}
