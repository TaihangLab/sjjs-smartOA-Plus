package com.ruoyi.project.service.impl;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ruoyi.common.core.service.OssService;
import com.ruoyi.project.domain.ProjectMilestone;
import com.ruoyi.project.domain.ProjectMilestoneOss;
import com.ruoyi.project.domain.bo.ProjectMilestoneBo;
import com.ruoyi.project.mapper.ProjectMilestoneMapper;
import com.ruoyi.project.mapper.ProjectMilestoneOssMapper;
import com.ruoyi.project.service.ProjectMilestoneService;
import com.ruoyi.system.service.ISysOssService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectMilestoneServiceImpl implements ProjectMilestoneService {

    private final ProjectMilestoneMapper projectMilestoneMapper;

    private final ProjectMilestoneOssMapper projectMilestoneOssMapper;

    /**
     * 新增单个项目大事记
     *
     * @param projectMilestoneBo 项目指标信息Bo
     * @return 结果
     */
    @Override
    @Transactional
    public int insertProjectMilestone(ProjectMilestoneBo projectMilestoneBo) {
        if (projectMilestoneBo == null) {
            return 0;
        }
        ProjectMilestone projectMilestone = new ProjectMilestone();
        projectMilestone.setProjectId(projectMilestoneBo.getProjectId());
        projectMilestone.setMilestoneTitle(projectMilestoneBo.getMilestoneTitle());
        projectMilestone.setMilestoneRemark(projectMilestoneBo.getMilestoneRemark());
        projectMilestone.setMilestoneDate(projectMilestoneBo.getMilestoneDate());

        // 插入 projectMilestone
        int insertedRows = projectMilestoneMapper.insert(projectMilestone);

        if (insertedRows > 0) {
            Long milestoneId = projectMilestone.getMilestoneId(); // 获取生成的 milestoneId
            if (!projectMilestoneBo.getOssIds().isEmpty()) {
                for (Long ossid : projectMilestoneBo.getOssIds()) {
                    ProjectMilestoneOss projectMilestoneOss = new ProjectMilestoneOss();
                    projectMilestoneOss.setMilestoneId(milestoneId);
                    projectMilestoneOss.setOssId(ossid);
                    projectMilestoneOssMapper.insert(projectMilestoneOss);
                }
            }
        }
        return insertedRows;
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
        return projectMilestoneMapper.insertBatch(projectMilestones);
    }

    /**
     * 删除某一项目对应的全部项目大事记
     *
     * @param projectId 项目ID
     * @return 结果
     */
    @Override
    public int deleteMilestoneByProjectId(Long projectId) {

        return projectMilestoneMapper.delete(new LambdaQueryWrapper<ProjectMilestone>().
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
        // 先检查是否存在与 milestoneId 相关的 ProjectMilestoneOss 记录
        long count = projectMilestoneOssMapper.selectCount(new LambdaQueryWrapper<ProjectMilestoneOss>()
            .eq(ProjectMilestoneOss::getMilestoneId, milestoneId));

        // 如果存在相关记录，则执行删除操作；否则直接返回
        if (count > 0) {
            projectMilestoneOssMapper.delete(new LambdaQueryWrapper<ProjectMilestoneOss>()
                .eq(ProjectMilestoneOss::getMilestoneId, milestoneId));
        }

        // 删除 ProjectMilestone 表中的指定 milestoneId 的记录
        return projectMilestoneMapper.delete(new LambdaQueryWrapper<ProjectMilestone>()
            .eq(ProjectMilestone::getMilestoneId, milestoneId));
    }

    /**
     * 修改项目大事记
     *
     * @param projectMilestoneBo 项目大事记信息Bo
     * @return 结果
     */
    @Override
    public int updateMilestone(ProjectMilestoneBo projectMilestoneBo) {
        LambdaUpdateWrapper<ProjectMilestone> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(ProjectMilestone::getMilestoneId, projectMilestoneBo.getMilestoneId());
        lambdaUpdateWrapper.set(ProjectMilestone::getMilestoneRemark, projectMilestoneBo.getMilestoneRemark())
            .set(ProjectMilestone::getMilestoneTitle, projectMilestoneBo.getMilestoneTitle())
            .set(ProjectMilestone::getMilestoneDate, projectMilestoneBo.getMilestoneDate());
        int updatedRows = projectMilestoneMapper.update(new ProjectMilestone(), lambdaUpdateWrapper);
        if (updatedRows > 0) {
            // 删除旧的关联关系
            Long milestoneId = projectMilestoneBo.getMilestoneId();
            projectMilestoneOssMapper.delete(new LambdaQueryWrapper<ProjectMilestoneOss>()
                .eq(ProjectMilestoneOss::getMilestoneId, milestoneId));

            // 插入新的关联关系
            List<Long> ossIds = projectMilestoneBo.getOssIds();
            if (!ossIds.isEmpty()) {
                for (Long ossId : ossIds) {
                    ProjectMilestoneOss projectMilestoneOss = new ProjectMilestoneOss();
                    projectMilestoneOss.setMilestoneId(milestoneId);
                    projectMilestoneOss.setOssId(ossId);
                    projectMilestoneOssMapper.insert(projectMilestoneOss);
                }
            }
        }
        return updatedRows;
    }

    /**
     * 修改项目大事记
     *
     * @param projectId 项目ID
     * @return 结果
     */
    @Override
    public List<ProjectMilestone> selectMilestoneListByProjectId(Long projectId) {
        return projectMilestoneMapper.selectList(new LambdaQueryWrapper<ProjectMilestone>()
            .eq(ProjectMilestone::getProjectId, projectId));
    }


}
