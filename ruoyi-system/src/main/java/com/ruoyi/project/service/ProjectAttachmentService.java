package com.ruoyi.project.service;

import com.ruoyi.system.domain.vo.SysOssVo;

import java.util.List;

public interface ProjectAttachmentService {

    boolean insertProjectMainAttachment(Long projectId, List<Long> ossId);

    boolean insertProjectOtherAttachment(Long projectId, List<Long> ossId);

    void deleteAllProjectAttachmentByProID(Long projectId);

    int deleteProjectAttachmentById(Long projectAttachmentId);

    List<SysOssVo> selectProjectAttachmentByProId(Long projectId);


}
