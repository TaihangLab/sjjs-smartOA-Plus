package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectAttachment;

import java.util.List;

public interface ProjectAttachmentService {

    boolean insertProjectMainAttachment(Long projectId, List<Long> ossId);

    boolean insertProjectOtherAttachment(Long projectId, List<Long> ossId);

    void deleteAllProjectAttachmentByProID(Long projectId);

    int deleteProjectAttachmentById(Long projectAttachmentId);

    List<ProjectAttachment> selectProjectAttachmentByProId(Long projectId);


}
