package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectUser;
import com.ruoyi.project.domain.vo.ProjectUserVo;
import org.apache.catalina.User;

import java.util.List;

public interface ProjectUserService {
    boolean insertProjectUsers(Long projectId, List<Long> userIds);

    int deleteProjectUsersByProID(Long projectId);

    int updateProjectUsers(Long projectId, List<Long> userIds);

    List<ProjectUserVo> getUserInfoByProjectId(Long projectId);

}
