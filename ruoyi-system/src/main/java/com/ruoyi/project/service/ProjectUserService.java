package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectUser;
import com.ruoyi.project.domain.bo.ProjectUserBo;
import com.ruoyi.project.domain.vo.ProjectUserVo;
import org.apache.catalina.User;

import java.util.List;

public interface ProjectUserService {
    boolean insertProjectUsers(Long projectId, List<ProjectUserBo> projectUserBos);

    boolean insertProjectUsers(List<ProjectUser> projectUserList);

    int deleteProjectUsersByProID(Long projectId);

    int updateProjectUsers(Long projectId, List<ProjectUserBo> projectUserBos);

    List<ProjectUserVo> getUserInfoByProjectId(Long projectId);

    String findProLeaderNameById(Long projectId);

}
