package com.ruoyi.project.service.impl;

import com.ruoyi.project.domain.ProjectAttachment;
import com.ruoyi.project.service.ProjectAttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ProjectAttachmentServiceImpl implements ProjectAttachmentService {
    @Override
    public int insertProjectMainAttachment(Long projectId) {
        return 0;
    }

    @Override
    public int insertProjectOtherAttachment(Long projectId) {
        return 0;
    }

    @Override
    public int deleteAllProjrctAttachmentByProID(Long projectId) {
        return 0;
    }

    @Override
    public int deleteProjectAttachmentById(Long projectAttachmentId) {
        return 0;
    }

    @Override
    public List<ProjectAttachment> selectProjectAttachmentByProId(Long projectId) {
        return null;
    }
}
