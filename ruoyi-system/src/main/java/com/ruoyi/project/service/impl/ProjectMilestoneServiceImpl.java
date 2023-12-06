package com.ruoyi.project.service.impl;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ruoyi.common.core.service.OssService;
import com.ruoyi.project.domain.ProjectMilestone;
import com.ruoyi.project.domain.ProjectMilestoneOss;
import com.ruoyi.project.domain.bo.ProjectMilestoneBo;
import com.ruoyi.project.domain.vo.ProjectMilestoneVo;
import com.ruoyi.project.mapper.ProjectMilestoneMapper;
import com.ruoyi.project.mapper.ProjectMilestoneOssMapper;
import com.ruoyi.project.service.ProjectMilestoneService;
import com.ruoyi.system.domain.SysOss;
import com.ruoyi.system.mapper.SysOssMapper;
import com.ruoyi.system.service.ISysOssService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectMilestoneServiceImpl implements ProjectMilestoneService {

    private final ProjectMilestoneMapper projectMilestoneMapper;

    private final ProjectMilestoneOssMapper projectMilestoneOssMapper;

    private final SysOssMapper sysOssMapper;

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
    @Transactional
    public int deleteMilestoneByProjectId(Long projectId) {
        // 1. 根据项目 ID 获取该项目下所有的大事记 ID
        List<ProjectMilestone> projectMilestones = projectMilestoneMapper.selectList(
            new LambdaQueryWrapper<ProjectMilestone>()
                .eq(ProjectMilestone::getProjectId, projectId));

        // 如果该项目下没有大事记，则直接返回
        if (projectMilestones.isEmpty()) {
            return 0;
        }

        // 提取大事记 ID 列表
        List<Long> milestoneIds = projectMilestones.stream()
            .map(ProjectMilestone::getMilestoneId)
            .collect(Collectors.toList());

        // 2. 使用大事记 ID 删除每个大事记对应的 OSS 对象
        if (!milestoneIds.isEmpty()) {
            projectMilestoneOssMapper.delete(new LambdaQueryWrapper<ProjectMilestoneOss>()
                .in(ProjectMilestoneOss::getMilestoneId, milestoneIds));
        }

        // 3. 删除该项目下的所有大事记
        return projectMilestoneMapper.delete(new LambdaQueryWrapper<ProjectMilestone>()
            .eq(ProjectMilestone::getProjectId, projectId));
    }

    /**
     * 删除单条目大事记
     *
     * @param milestoneId 项目大事记ID
     * @return 结果
     */
    @Override
    @Transactional
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
     * 查询某一项目对应的所有项目大事记
     *
     * @param projectId 项目ID
     * @return 结果Vo
     */
    @Override
    public List<ProjectMilestoneVo> selectMilestoneInfoByProjectId(Long projectId) {
        // 从 ProjectMilestone 表中查找 projectId 和 milestoneId 的对应关系
        List<ProjectMilestone> milestones = projectMilestoneMapper.selectList(
            new LambdaQueryWrapper<ProjectMilestone>().eq(ProjectMilestone::getProjectId, projectId));

        List<ProjectMilestoneVo> milestoneVos = new ArrayList<>();

        for (ProjectMilestone milestone : milestones) {
            // 创建 ProjectMilestoneVo 对象用于存储结果
            ProjectMilestoneVo milestoneVo = new ProjectMilestoneVo();
            // 将大事记的基本信息赋值给 milestoneVo
            milestoneVo.setMilestoneId(milestone.getMilestoneId());
            milestoneVo.setProjectId(milestone.getProjectId());
            milestoneVo.setMilestoneTitle(milestone.getMilestoneTitle());
            milestoneVo.setMilestoneRemark(milestone.getMilestoneRemark());
            milestoneVo.setMilestoneDate(milestone.getMilestoneDate());

            // 从 ProjectMilestoneOss 表中查找大事记 ID 和 OSS ID 的对应关系
            List<Long> ossIds = projectMilestoneOssMapper.selectList(
                    new LambdaQueryWrapper<ProjectMilestoneOss>().eq(ProjectMilestoneOss::getMilestoneId, milestone.getMilestoneId()))
                .stream()
                .map(ProjectMilestoneOss::getOssId)
                .collect(Collectors.toList());

            // 根据 OSS ID 在 SysOss 表中查询 OSS 对象的全部信息
            List<SysOss> sysOsses = sysOssMapper.selectBatchIds(ossIds);

            milestoneVo.setSysOsses(sysOsses);

            milestoneVos.add(milestoneVo);
        }

        return milestoneVos;
    }


}
