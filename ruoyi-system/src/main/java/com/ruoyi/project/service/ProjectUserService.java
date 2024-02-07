package com.ruoyi.project.service;

import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.project.domain.ProjectUser;
import com.ruoyi.project.domain.bo.ProjectUserBo;
import com.ruoyi.project.domain.vo.ProjectUserDetailVo;
import com.ruoyi.project.domain.vo.ProjectUserVo;

import java.util.List;
import java.util.Map;

/**
 * 项目成员Service接口
 *
 * @author bailingnan
 * @date 2024/02/05
 */
public interface ProjectUserService {

    /**
     * 批量新增项目成员
     *
     * @param projectUserBOList
     * @param projectId
     */
    void insertProjectUsers(List<ProjectUserBo> projectUserBOList, Long projectId);

    /**
     * 批量新增项目成员
     *
     * @param projectUserList
     */
    void insertProjectUsers(List<ProjectUser> projectUserList);

    /**
     * 创建时批量新增项目成员
     *
     * @param projectUserBOList
     * @param projectId
     */
    void insertProjectUsersOnCreate(List<ProjectUserBo> projectUserBOList, Long projectId);

    /**
     * 批量更新项目成员
     *
     * @param projectUserBOList
     * @param projectId
     */
    void updateProjectUsers(List<ProjectUserBo> projectUserBOList, Long projectId);

    /**
     * 根据项目id删除项目成员
     *
     * @param projectId
     *
     * @return int
     */
    int deleteProjectUsersByProjectId(Long projectId);

    /**
     * 根据项目id获取项目成员信息
     *
     * @param projectId
     *
     * @return {@link List}<{@link ProjectUserVo}>
     */
    List<ProjectUserVo> getUserInfoByProjectId(Long projectId);

    /**
     * 根据项目id获取项目负责人姓名
     *
     * @param projectId
     *
     * @return {@link String}
     */
    String findProjectLeaderNameByProjectId(Long projectId);

    /**
     * 分页查询人员信息
     *
     * @param projectUserBo
     * @param pageQuery
     *
     * @return {@link TableDataInfo}<{@link ProjectUserVo}>
     */
    TableDataInfo<ProjectUserVo> queryPageAllList(ProjectUserBo projectUserBo, PageQuery pageQuery);

    /**
     * 根据用户id获取项目成员详细信息
     *
     * @param userId
     *
     * @return {@link ProjectUserDetailVo}
     */
    ProjectUserDetailVo getProjectUserDetailById(Long userId);

    /**
     * 批量删除项目成员
     *
     * @param projectUserList
     */
    void deleteProjectUserList(List<ProjectUser> projectUserList);

    /**
     * 通过用户id获取项目id列表
     *
     * @param userId
     *
     * @return {@link List}<{@link Long}>
     */
    List<Long> getProjectIdsByUserId(Long userId);

    /**
     * 获取当前项目下项目成员角色和姓名的对应关系
     *
     * @param projectId
     *
     * @return {@link Map}<{@link String}, {@link String}>
     */
    Map<String, String> getTitleAndNameMapping(Long projectId);
}
