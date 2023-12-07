package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.project.domain.ProjectUser;
import com.ruoyi.project.mapper.ProjectUserMapper;
import com.ruoyi.project.service.ProjectUserService;
import com.ruoyi.system.mapper.SysUserMapper;
import lombok.RequiredArgsConstructor;
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

    private final SysUserMapper sysUserMapper;

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
    public List<String> selectProjectUserByProId(Long projectId) {
        // 创建一个查询条件包装器，用于查询特定项目ID相关的ProjectUser记录
        LambdaQueryWrapper<ProjectUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProjectUser::getProjectId, projectId);
        List<ProjectUser> projectUsers = projectUserMapper.selectList(queryWrapper);

        // 从ProjectUser记录中提取用户ID列表
        List<Long> userIds = projectUsers.stream().map(ProjectUser::getUserId).collect(Collectors.toList());

        // 创建一个查询条件包装器，用于查询特定用户ID相关的User记录
        LambdaQueryWrapper<SysUser> userQueryWrapper = new LambdaQueryWrapper<>();
        userQueryWrapper.in(SysUser::getUserId, userIds);
        List<SysUser> sysUsers = sysUserMapper.selectList(userQueryWrapper);

        // 将查询到的用户记录列表转换为用户ID到用户名的映射关系
        Map<Long, String> userIdToNicknameMap = sysUsers.stream()
            .collect(Collectors.toMap(SysUser::getUserId, SysUser::getNickName));

        // 根据用户ID到用户名的映射关系，从ProjectUser记录中获取用户名列表
        List<String> nicknames = userIds.stream()
            .map(userId -> userIdToNicknameMap.getOrDefault(userId, "")) // 如果没有对应的nickname，设为默认值
            .collect(Collectors.toList());

        return nicknames;
    }
}
