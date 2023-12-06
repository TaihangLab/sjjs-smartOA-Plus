package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.project.domain.ProjectUser;
import com.ruoyi.project.mapper.ProjectUserMapper;
import com.ruoyi.project.service.ProjectUserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProjectUserServiceImpl implements ProjectUserService {

    private final ProjectUserMapper projectUserMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertProjectUsers(Long projectId, List<Long> userIds) {
        List<ProjectUser> projectUsers = new ArrayList<>();
        for (Long userId : userIds) {
            ProjectUser projectUser = new ProjectUser();
            projectUser.setProjectId(projectId);
            projectUser.setUserId(userId);
            projectUsers.add(projectUser);
        }
        return projectUserMapper.insertBatch(projectUsers);
    }

    @Override
    public int deleteProjectUsersByProID(Long projectId) {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("project_id", projectId);
        return projectUserMapper.deleteByMap(columnMap);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateProjectUsers(Long projectId, List<Long> userIds) {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("project_id", projectId);
        projectUserMapper.deleteByMap(columnMap);

        // 插入新的用户ID
        List<ProjectUser> projectUsers = new ArrayList<>();
        for (Long userId : userIds) {
            ProjectUser projectUser = new ProjectUser();
            projectUser.setProjectId(projectId);
            projectUser.setUserId(userId);
            projectUsers.add(projectUser);
        }

        return projectUserMapper.insertBatch(projectUsers) ? projectUsers.size() : 0;
    }

    @Override
    public List<Long> selectProjectUserByProId(Long projectId) {
        LambdaQueryWrapper<ProjectUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProjectUser::getProjectId, projectId);
        List<ProjectUser> projectUsers = projectUserMapper.selectList(queryWrapper);

        List<Long> userIds = projectUsers.stream().map(ProjectUser::getUserId).collect(Collectors.toList());
        return userIds;
    }
}
