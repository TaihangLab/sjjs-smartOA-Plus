package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectAttachment;
import com.ruoyi.system.domain.vo.SysOssVo;

import java.util.List;

public interface ProjectAttachmentService {

    boolean insertProjectAttachmentList(Long projectId, List<Long> ossId);

    boolean insertProjectAttachmentList(List<ProjectAttachment> projectAttachmentList);

    void deleteAllProjectAttachmentByProID(Long projectId);

    int deleteProjectAttachmentById(Long projectAttachmentId);

    List<SysOssVo> selectSysOssVOListByProId(Long projectId);


}
