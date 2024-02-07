package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectAttachment;
import com.ruoyi.system.domain.vo.SysOssVo;

import java.util.List;

/**
 * 项目附件Service接口
 *
 * @author bailingnan
 * @date 2024/02/06
 */
public interface ProjectAttachmentService {

    /**
     * 新增项目附件
     *
     * @param ossIds
     * @param projectId
     *
     * @return boolean
     */
    boolean insertProjectAttachmentList(List<Long> ossIds, Long projectId);

    /**
     * 新增项目附件
     *
     * @param projectAttachmentList
     *
     * @return boolean
     */
    boolean insertProjectAttachmentList(List<ProjectAttachment> projectAttachmentList);

    /**
     * 通过项目id删除项目附件
     *
     * @param projectId
     */
    void deleteAllProjectAttachmentByProID(Long projectId);

    /**
     * 通过id列表删除项目附件
     *
     * @param idList
     */
    void deleteProjectAttachmentByIdList(List<Long> idList);

    /**
     * 通过项目id获取项目附件
     *
     * @param projectId
     *
     * @return {@link List}<{@link SysOssVo}>
     */
    List<SysOssVo> selectSysOssVOListByProId(Long projectId);

    /**
     * 更新项目附件
     *
     * @param ossIds
     * @param projectId
     */
    void updateProjectAttachmentList(List<Long> ossIds, Long projectId);
}
