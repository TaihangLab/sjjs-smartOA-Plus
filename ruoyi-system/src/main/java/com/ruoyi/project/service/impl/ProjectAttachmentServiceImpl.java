package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.project.domain.ProjectAttachment;
import com.ruoyi.project.mapper.ProjectAttachmentMapper;
import com.ruoyi.project.service.ProjectAttachmentService;
import com.ruoyi.system.domain.SysOss;
import com.ruoyi.system.domain.vo.SysOssVo;
import com.ruoyi.system.mapper.SysOssMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectAttachmentServiceImpl implements ProjectAttachmentService {

    private final ProjectAttachmentMapper projectAttachmentMapper;

    private final SysOssMapper sysOssMapper;

    /**
     * @param projectId 项目ID
     * @param ossIds    文件对象ossId列表
     * @return 返回值
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertProjectAttachmentList(Long projectId, List<Long> ossIds) {
        if (ossIds.isEmpty()) {
            return true;
        }
        List<ProjectAttachment> attachments = new ArrayList<>();
        for (Long ossId : ossIds) {
            ProjectAttachment projectAttachment = new ProjectAttachment();
            projectAttachment.setProjectId(projectId);
            projectAttachment.setOssId(ossId);
        }

        return projectAttachmentMapper.insertBatch(attachments);
    }

    /**
     * @param projectAttachmentList
     * @return
     */
    @Override
    public boolean insertProjectAttachmentList(List<ProjectAttachment> projectAttachmentList) {
        return projectAttachmentMapper.insertBatch(projectAttachmentList);
    }

    /**
     * @param projectId 项目ID
     */
    @Override
    public void deleteAllProjectAttachmentByProID(Long projectId) {
        projectAttachmentMapper.delete((new LambdaQueryWrapper<ProjectAttachment>()).
            eq(ProjectAttachment::getProjectId, projectId));
    }


    /**
     * @param projectAttachmentId 项目文件表ID
     * @return 删除行数
     */
    @Override
    public int deleteProjectAttachmentById(Long projectAttachmentId) {
        return projectAttachmentMapper.delete((new LambdaQueryWrapper<ProjectAttachment>()).
            eq(ProjectAttachment::getId, projectAttachmentId));
    }

    /**
     * @param projectId 项目ID
     * @return 返回查询列表
     */
    @Override
    public List<SysOssVo> selectSysOssVOListByProId(Long projectId) {
        List<Long> ossIds = projectAttachmentMapper.selectList((new LambdaQueryWrapper<ProjectAttachment>())
            .eq(ProjectAttachment::getProjectId, projectId)).stream().map(ProjectAttachment::getOssId).collect(Collectors.toList());
        if (ossIds.isEmpty()) {
            return Collections.emptyList();
        }
        return sysOssMapper.selectVoList(new LambdaQueryWrapper<SysOss>().in(SysOss::getOssId, ossIds));
    }
}
