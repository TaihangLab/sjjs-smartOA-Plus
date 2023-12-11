package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.project.domain.ProjectAttachment;
import com.ruoyi.project.mapper.ProjectAttachmentMapper;
import com.ruoyi.project.service.ProjectAttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectAttachmentServiceImpl implements ProjectAttachmentService {

    private final ProjectAttachmentMapper projectAttachmentMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertProjectMainAttachment(Long projectId, List<Long> ossIds) {
        if (ossIds.isEmpty()){
            return true;
        }
        List<ProjectAttachment> attachments = new ArrayList<>();
        for (Long ossId : ossIds) {
            ProjectAttachment projectAttachment = new ProjectAttachment();
            projectAttachment.setAttachmentType("main");
            projectAttachment.setProjectId(projectId);
            projectAttachment.setTemplate(false);
            projectAttachment.setOssId(ossId);
        }

        return projectAttachmentMapper.insertBatch(attachments);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertProjectOtherAttachment(Long projectId, List<Long> ossIds) {
        if (ossIds.isEmpty()){
            return true;
        }
        List<ProjectAttachment> attachments = new ArrayList<>();
        for (Long ossId : ossIds) {
            ProjectAttachment projectAttachment = new ProjectAttachment();
            projectAttachment.setAttachmentType("other");
            projectAttachment.setProjectId(projectId);
            projectAttachment.setTemplate(false);
            projectAttachment.setOssId(ossId);
        }

        return projectAttachmentMapper.insertBatch(attachments);
    }

    @Override
    public int deleteAllProjrctAttachmentByProID(Long projectId) {
        return projectAttachmentMapper.delete((new LambdaQueryWrapper<ProjectAttachment>()).
            eq(ProjectAttachment::getProjectId,projectId));
    }

    @Override
    public int deleteProjectAttachmentById(Long projectAttachmentId) {
        return projectAttachmentMapper.delete((new LambdaQueryWrapper<ProjectAttachment>()).
            eq(ProjectAttachment::getId,projectAttachmentId));
    }

    @Override
    public List<ProjectAttachment> selectProjectAttachmentByProId(Long projectId) {
        return projectAttachmentMapper.selectList((new LambdaQueryWrapper<ProjectAttachment>()).
            eq(ProjectAttachment::getProjectId,projectId));
    }
}
