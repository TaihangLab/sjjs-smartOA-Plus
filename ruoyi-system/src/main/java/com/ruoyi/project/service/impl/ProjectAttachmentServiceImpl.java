package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.project.domain.ProjectAttachment;
import com.ruoyi.project.mapper.ProjectAttachmentMapper;
import com.ruoyi.project.service.ProjectAttachmentService;
import com.ruoyi.system.domain.SysOss;
import com.ruoyi.system.domain.vo.SysOssVo;
import com.ruoyi.system.mapper.SysOssMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 项目附件
 *
 * @author bailingnan
 * @date 2024/02/06
 */
@Slf4j
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
    public boolean insertProjectAttachmentList(List<Long> ossIds, Long projectId) {
        if (ossIds.isEmpty()) {
            return true;
        }
        List<ProjectAttachment> attachments = ossIds.stream().map(ossId -> {
            ProjectAttachment projectAttachment = new ProjectAttachment();
            projectAttachment.setProjectId(projectId);
            projectAttachment.setOssId(ossId);
            return projectAttachment;
        }).collect(Collectors.toList());
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
     * @param idList
     */
    @Override
    public void deleteProjectAttachmentByIdList(List<Long> idList) {
	    projectAttachmentMapper.deleteBatchIds(idList);
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

    /**
     * @param ossIds
     * @param projectId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProjectAttachmentList(List<Long> ossIds, Long projectId) {
        List<ProjectAttachment> oldProjectAttachments = projectAttachmentMapper.selectList(new LambdaQueryWrapper<ProjectAttachment>().eq(ProjectAttachment::getProjectId, projectId));
        if (ossIds == null || ossIds.isEmpty()) {
            if (oldProjectAttachments.isEmpty()) {
                return;
            } else {
	            deleteAllProjectAttachmentByProID(projectId);
                return;
            }
        } else {
            if (oldProjectAttachments.isEmpty()) {
	            insertProjectAttachmentList(ossIds, projectId);
                return;
            }
        }
        List<ProjectAttachment> newProjectAttachments = ossIds.stream().map(ossId -> {
            ProjectAttachment projectAttachment = new ProjectAttachment();
            projectAttachment.setProjectId(projectId);
            projectAttachment.setOssId(ossId);
            return projectAttachment;
        }).collect(Collectors.toList());
        Set<ProjectAttachment> oldProjectAttachmentSet = new HashSet<>(oldProjectAttachments);
        Set<ProjectAttachment> newProjectAttachmentSet = new HashSet<>(newProjectAttachments);
        List<ProjectAttachment> addProjectAttachmentList = newProjectAttachments.stream().filter(projectAttachment -> !oldProjectAttachmentSet.contains(projectAttachment)).collect(Collectors.toList());
        List<ProjectAttachment> delProjectAttachmentList = oldProjectAttachments.stream().filter(projectAttachment -> !newProjectAttachmentSet.contains(projectAttachment)).collect(Collectors.toList());
        if (!addProjectAttachmentList.isEmpty()) {
	        insertProjectAttachmentList(addProjectAttachmentList);
        }
        if (!delProjectAttachmentList.isEmpty()) {
	        deleteProjectAttachmentByIdList(delProjectAttachmentList.stream().map(ProjectAttachment::getId).collect(Collectors.toList()));
        }
    }

}
