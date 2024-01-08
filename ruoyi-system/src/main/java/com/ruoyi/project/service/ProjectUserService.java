package com.ruoyi.project.service;

import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.project.domain.ProjectUser;
import com.ruoyi.project.domain.bo.ProjectUserBo;
import com.ruoyi.project.domain.vo.ProjectUserDetailVo;
import com.ruoyi.project.domain.vo.ProjectUserVo;

import java.util.List;

public interface ProjectUserService {

    void insertProjectUsers(List<ProjectUserBo> projectUserBOList, Long projectId);

    void insertProjectUsers(List<ProjectUser> projectUserList);

    void insertProjectUsersOnCreate(List<ProjectUserBo> projectUserBOList, Long projectId);

    void updateProjectUsers(List<ProjectUserBo> projectUserBOList, Long projectId);

    int deleteProjectUsersByProID(Long projectId);

    List<ProjectUserVo> getUserInfoByProjectId(Long projectId);

    String findProLeaderNameById(Long projectId);

    TableDataInfo<ProjectUserVo> queryPageAllList(ProjectUserBo projectUserBo, PageQuery pageQuery);

    ProjectUserDetailVo getProjectUserDetailById(Long userId);

    void deleteProjectUserList(List<ProjectUser> projectUserList);
}
