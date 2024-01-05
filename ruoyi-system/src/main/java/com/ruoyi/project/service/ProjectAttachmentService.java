package com.ruoyi.project.service;

import com.ruoyi.system.domain.vo.SysOssVo;

import java.util.List;

public interface ProjectAttachmentService {

    boolean insertProjectAttachmentList(List<Long> ossIds, Long projectId);

    void deleteAllProjectAttachmentByProID(Long projectId);

    List<SysOssVo> selectSysOssVOListByProId(Long projectId);

    void updateProjectAttachmentList(List<Long> ossIds, Long projectId);
}
