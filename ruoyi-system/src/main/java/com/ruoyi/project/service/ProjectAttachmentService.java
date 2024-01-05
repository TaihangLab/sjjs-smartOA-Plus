package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectAttachment;
import com.ruoyi.system.domain.vo.SysOssVo;

import java.util.List;

public interface ProjectAttachmentService {

    boolean insertProjectAttachmentList(List<Long> ossIds, Long projectId);

    boolean insertProjectAttachmentList(List<ProjectAttachment> projectAttachmentList);

    void deleteAllProjectAttachmentByProID(Long projectId);

    void deleteProjectAttachmentByIdList(List<Long> idList);

    List<SysOssVo> selectSysOssVOListByProId(Long projectId);

    void updateProjectAttachmentList(List<Long> ossIds, Long projectId);
}
