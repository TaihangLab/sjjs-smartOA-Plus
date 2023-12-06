package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectUser;
import org.apache.catalina.User;

import java.util.List;

public interface ProjectUserService {
    boolean insertProjectUsers(Long projectId, List<Long> userIds);

    int deleteProjectUsersByProID(Long projectId);

    int updateProjectUsers(Long projectId, List<Long> userIds);

    List<Long> selectProjectUserByProId(Long projectId);

}
