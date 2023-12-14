package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.project.domain.ProjectUser;
import com.ruoyi.project.domain.bo.ProjectUserBo;
import com.ruoyi.project.domain.vo.ProjectUserVo;
import com.ruoyi.project.mapper.ProjectUserMapper;
import com.ruoyi.project.service.ProjectUserService;
import com.ruoyi.system.mapper.SysDeptMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProjectUserServiceImpl implements ProjectUserService {

    private final ProjectUserMapper projectUserMapper;

    private final SysUserMapper sysUserMapper;

    private final SysDeptMapper sysDeptMapper;

    /**
     * 添加项目成员
     *
     * @param projectId
     * @param projectUserBos
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertProjectUsers(Long projectId, List<ProjectUserBo> projectUserBos) {
        List<ProjectUser> projectUsers = new ArrayList<>();
        for (ProjectUserBo projectUserBo : projectUserBos) {
            ProjectUser projectUser = new ProjectUser();
            projectUser.setProjectId(projectId);
            projectUser.setUserId(projectUserBo.getUserId());
            projectUser.setProjectUserRole(projectUserBo.getProjectUserRole());
        }
        return projectUserMapper.insertBatch(projectUsers);
    }

    /**
     * 根据项目ID删除对应成员
     *
     * @param projectId
     * @return
     */
    @Override
    public int deleteProjectUsersByProID(Long projectId) {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("project_id", projectId);
        return projectUserMapper.deleteByMap(columnMap);
    }

    /**
     * 修改项目成员
     *
     * @param projectId
     * @param projectUserBos
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateProjectUsers(Long projectId, List<ProjectUserBo> projectUserBos) {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("project_id", projectId);
        projectUserMapper.deleteByMap(columnMap);

        // 插入新的用户ID
        List<ProjectUser> projectUsers = new ArrayList<>();
        for (ProjectUserBo projectUserBo : projectUserBos) {
            ProjectUser projectUser = new ProjectUser();
            projectUser.setProjectId(projectId);
            projectUser.setUserId(projectUserBo.getUserId());
            projectUser.setProjectUserRole(projectUserBo.getProjectUserRole());
        }

        return projectUserMapper.insertBatch(projectUsers) ? projectUsers.size() : 0;
    }

    /**
     * 根据项目ID获取成员详细信息
     *
     * @param projectId
     * @return
     */
    @Override
    public List<ProjectUserVo> getUserInfoByProjectId(Long projectId) {
        // 获取项目相关的用户ID列表
        List<Long> userIds = getUserIdsByProjectId(projectId);

        // 根据用户ID列表获取用户信息
        Map<Long, SysUser> userIdToUserMap = getUsersMapByUserIds(userIds);

        // 获取用户的部门ID列表
        Set<Long> uniqueDeptIds = userIdToUserMap.values().stream().map(SysUser::getDeptId).collect(Collectors.toSet());

        // 根据部门ID列表获取部门名称映射
        Map<Long, String> deptIdToNameMap = getDeptNameMapByDeptIds(new ArrayList<>(uniqueDeptIds));

        // 构建 ProjectUserVo 列表
        return buildProjectUserVoList(userIds, userIdToUserMap, deptIdToNameMap);
    }

    /**
     * 根据项目ID获取相关用户的ID列表
     *
     * @param projectId 项目ID
     * @return 用户ID列表
     */
    private List<Long> getUserIdsByProjectId(Long projectId) {
        LambdaQueryWrapper<ProjectUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProjectUser::getProjectId, projectId);
        List<ProjectUser> projectUsers = projectUserMapper.selectList(queryWrapper);

        // 获取与项目相关的 SysUser 对象
        List<SysUser> sysUsers = projectUsers.stream()
            .map(ProjectUser::getUserId) // 获取用户 ID 列表
            .map(userId -> sysUserMapper.selectById(userId)) // 获取对应的 SysUser 对象
            .filter(sysUser -> sysUser != null && "0".equals(sysUser.getDelFlag())) // 仅保留 delflag = 0 的对象
            .collect(Collectors.toList());
        return sysUsers.stream().map(SysUser::getUserId).collect(Collectors.toList());
    }

    /**
     * 根据用户ID列表获取用户信息
     *
     * @param userIds 用户ID列表
     * @return 用户信息映射（ID -> 用户信息）
     */
    private Map<Long, SysUser> getUsersMapByUserIds(List<Long> userIds) {
        LambdaQueryWrapper<SysUser> userQueryWrapper = new LambdaQueryWrapper<>();
        userQueryWrapper.in(SysUser::getUserId, userIds);
        List<SysUser> sysUsers = sysUserMapper.selectList(userQueryWrapper);
        return sysUsers.stream().collect(Collectors.toMap(SysUser::getUserId, user -> user));
    }

    /**
     * 根据部门ID列表获取部门名称映射
     *
     * @param deptIds 部门ID列表
     * @return 部门名称映射（ID -> 部门名称）
     */
    private Map<Long, String> getDeptNameMapByDeptIds(List<Long> deptIds) {
        LambdaQueryWrapper<SysDept> deptQueryWrapper = new LambdaQueryWrapper<>();
        deptQueryWrapper.in(SysDept::getDeptId, deptIds);
        List<SysDept> departments = sysDeptMapper.selectList(deptQueryWrapper);
        return departments.stream().collect(Collectors.toMap(SysDept::getDeptId, SysDept::getDeptName));
    }

    /**
     * 根据用户信息和部门信息构建 ProjectUserVo 列表
     *
     * @param userIds         用户ID列表
     * @param userIdToUserMap 用户信息映射（ID -> 用户信息）
     * @param deptIdToNameMap 部门名称映射（ID -> 部门名称）
     * @return ProjectUserVo 列表
     */
    private List<ProjectUserVo> buildProjectUserVoList(List<Long> userIds, Map<Long, SysUser> userIdToUserMap, Map<Long, String> deptIdToNameMap) {
        List<ProjectUserVo> projectUserVos = new ArrayList<>();
        for (Long userId : userIds) {
            SysUser user = userIdToUserMap.get(userId);
            String deptName = deptIdToNameMap.getOrDefault(user.getDeptId(), "Unknown Dept");

            ProjectUserVo projectUserVo = new ProjectUserVo();
            projectUserVo.setNickName(user.getNickName());
            projectUserVo.setEmail(user.getEmail());
            projectUserVo.setPhonenumber(user.getPhonenumber());
            projectUserVo.setDeptName(deptName);

            projectUserVos.add(projectUserVo);
        }
        return projectUserVos;
    }
}
