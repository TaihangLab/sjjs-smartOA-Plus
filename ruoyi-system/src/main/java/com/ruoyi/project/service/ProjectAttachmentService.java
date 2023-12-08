package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectAttachment;

import java.util.List;

public interface ProjectAttachmentService {

    int insertProjectMainAttachment(Long projectId);

    int insertProjectOtherAttachment(Long projectId);

    int deleteAllProjrctAttachmentByProID(Long projectId);

    int deleteProjectAttachmentById(Long projectAttachmentId);

    List<ProjectAttachment> selectProjectAttachmentByProId(Long projectId);


}
