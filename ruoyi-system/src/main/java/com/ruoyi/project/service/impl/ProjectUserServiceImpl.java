package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ProjectLevel;
import com.ruoyi.common.enums.ProjectUserRole;
import com.ruoyi.common.helper.LoginHelper;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.project.domain.ProjectBaseInfo;
import com.ruoyi.project.domain.ProjectUser;
import com.ruoyi.project.domain.bo.ProjectUserBo;
import com.ruoyi.project.domain.vo.ProjectUserDetailVo;
import com.ruoyi.project.domain.vo.ProjectUserVo;
import com.ruoyi.project.mapper.ProjectBaseInfoMapper;
import com.ruoyi.project.mapper.ProjectUserMapper;
import com.ruoyi.project.service.ProjectUserService;
import com.ruoyi.system.mapper.SysDeptMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProjectUserServiceImpl implements ProjectUserService {

    private final ProjectUserMapper projectUserMapper;

    private final SysUserMapper sysUserMapper;

    private final SysDeptMapper sysDeptMapper;

    private final ProjectBaseInfoMapper projectBaseInfoMapper;

    /**
     * 添加项目成员
     *
     * @param projectUserBoList
     * @return
     */
    @Override
    public void insertProjectUsers(List<ProjectUserBo> projectUserBoList, Long projectId) {
        if (projectUserBoList == null || projectUserBoList.isEmpty()) {
            return;
        }
        List<ProjectUser> projectUserList = projectUserBOListToProjectUserList(projectUserBoList, projectId);
        projectUserMapper.insertBatch(projectUserList);
    }

    /**
     * @param projectUserList
     */
    @Override
    public void insertProjectUsers(List<ProjectUser> projectUserList) {
        if (projectUserList == null || projectUserList.isEmpty()) {
            return;
        }
        projectUserMapper.insertBatch(projectUserList);

    }

    /**
     * @param projectUserBoList
     * @param projectId
     */
    @Override
    public void insertProjectUsersOnCreate(List<ProjectUserBo> projectUserBoList, Long projectId) {
        if (projectUserBoList == null) {
            projectUserBoList = new ArrayList<>();
        }
        ProjectUserBo projectLoginUserBo = new ProjectUserBo();
        projectLoginUserBo.setUserId(LoginHelper.getUserId());
        projectLoginUserBo.setProjectUserRoleList(Collections.singletonList(ProjectUserRole.PROJECT_ENTRY_OPERATOR));
        projectUserBoList.add(projectLoginUserBo);
        insertProjectUsers(projectUserBoList, projectId);
    }

    /**
     * @param projectUserBOList
     * @param projectId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProjectUsers(List<ProjectUserBo> projectUserBOList, Long projectId) {
        List<ProjectUser> oldProjectUserList = projectUserMapper.selectList(new LambdaQueryWrapper<ProjectUser>().eq(ProjectUser::getProjectId, projectId));
        if (projectUserBOList == null || projectUserBOList.isEmpty()) {
            if (oldProjectUserList.isEmpty()) {
                return;
            } else {
                deleteProjectUsersByProID(projectId);
                return;
            }
        } else {
            if (oldProjectUserList.isEmpty()) {
                insertProjectUsers(projectUserBOList, projectId);
                return;
            }
        }
        List<ProjectUser> newProjectUserList = projectUserBOListToProjectUserList(projectUserBOList, projectId);
        Set<ProjectUser> oldProjectUserSet = new HashSet<>(oldProjectUserList);
        Set<ProjectUser> newProjectUserSet = new HashSet<>(newProjectUserList);
        List<ProjectUser> addProjectUserList = newProjectUserList.stream().filter(projectUser -> !oldProjectUserSet.contains(projectUser)).collect(Collectors.toList());
        List<ProjectUser> delProjectUserList = oldProjectUserList.stream().filter(projectUser -> !newProjectUserSet.contains(projectUser)).collect(Collectors.toList());
        if (!addProjectUserList.isEmpty()) {
            insertProjectUsers(addProjectUserList);
        }
        if (!delProjectUserList.isEmpty()) {
            deleteProjectUserList(delProjectUserList);
        }
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
     * 根据项目ID获取成员详细信息
     *
     * @param projectId
     * @return
     */
    @Override
    public List<ProjectUserVo> getUserInfoByProjectId(Long projectId) {
        // 获取项目相关的用户ID列表
        Set<Long> userIds = getUserIdsByProjectId(projectId);

        //根据用户ID获取用户在项目中角色的映射
        Map<Long, List<ProjectUserRole>> projectRolesMap = getProjectRolesByMemberIds(projectId, userIds);

        // 根据用户ID列表获取用户信息
        Map<Long, SysUser> userIdToUserMap = getUsersMapByUserIds(userIds);

        // 获取用户的部门ID列表
        Set<Long> uniqueDeptIds = userIdToUserMap.values().stream().map(SysUser::getDeptId).collect(Collectors.toSet());

        // 根据部门ID列表获取部门名称映射
        Map<Long, String> deptIdToNameMap = getDeptNameMapByDeptIds(new ArrayList<>(uniqueDeptIds));

        // 构建 ProjectUserVo 列表
        return buildProjectUserVoList(userIds, userIdToUserMap, deptIdToNameMap, projectRolesMap);
    }

    /**
     * 根据项目ID获取相关用户的ID列表
     *
     * @param projectId 项目ID
     * @return 用户ID列表
     */
    private Set<Long> getUserIdsByProjectId(Long projectId) {
        LambdaQueryWrapper<ProjectUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProjectUser::getProjectId, projectId);
        List<ProjectUser> projectUsers = projectUserMapper.selectList(queryWrapper);

        // 获取与项目相关的 SysUser 对象
        List<SysUser> sysUsers = projectUsers.stream()
            .map(ProjectUser::getUserId) // 获取用户 ID 列表
            .map(userId -> sysUserMapper.selectById(userId)) // 获取对应的 SysUser 对象
            .filter(sysUser -> sysUser != null && "0".equals(sysUser.getDelFlag())) // 仅保留 delflag = 0 的对象
            .collect(Collectors.toList());

        return sysUsers.stream().map(SysUser::getUserId).collect(Collectors.toSet());
    }

    /**
     * 根据项目成员ID集合获取项目成员角色映射
     *
     * @param memberIds 项目成员ID集合
     * @return 映射，其中键是用户ID，值是用户在项目中的角色列表
     */
    private Map<Long, List<ProjectUserRole>> getProjectRolesByMemberIds(Long projectId, Set<Long> memberIds) {
        if (memberIds == null || memberIds.isEmpty()) {
            return Collections.emptyMap();
        }

        LambdaQueryWrapper<ProjectUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(ProjectUser::getUserId, memberIds).eq(ProjectUser::getProjectId, projectId);
        List<ProjectUser> projectUsers = projectUserMapper.selectList(queryWrapper);

        Map<Long, List<ProjectUserRole>> userIdToProjectUserRolesMap = new HashMap<>();
        for (ProjectUser projectUser : projectUsers) {
            userIdToProjectUserRolesMap.computeIfAbsent(projectUser.getUserId(), k -> new ArrayList<>())
                .add(projectUser.getProjectUserRole());
        }

        return userIdToProjectUserRolesMap;
    }

    /**
     * 根据用户ID列表获取用户信息
     *
     * @param userIds 用户ID列表
     * @return 用户信息映射（ID -> 用户信息）
     */
    private Map<Long, SysUser> getUsersMapByUserIds(Set<Long> userIds) {
        LambdaQueryWrapper<SysUser> userQueryWrapper = new LambdaQueryWrapper<>();
        if (userIds.isEmpty()) {
            return Collections.emptyMap();
        }
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
        if (deptIds.isEmpty()) {
            return Collections.emptyMap();
        }
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
    private List<ProjectUserVo> buildProjectUserVoList(Set<Long> userIds, Map<Long, SysUser> userIdToUserMap, Map<Long, String> deptIdToNameMap, Map<Long, List<ProjectUserRole>> userIdToProjectUserRolesMap) {
        List<ProjectUserVo> projectUserVos = new ArrayList<>();
        for (Long userId : userIds) {
            SysUser user = userIdToUserMap.get(userId);
            String deptName = deptIdToNameMap.getOrDefault(user.getDeptId(), "Unknown Dept");
            List<ProjectUserRole> projectUserRoles = userIdToProjectUserRolesMap.getOrDefault(userId, Collections.singletonList(ProjectUserRole.UNKNOWN))
                .stream().filter(projectUserRole -> !projectUserRole.equals(ProjectUserRole.PROJECT_ENTRY_OPERATOR)).collect(Collectors.toList());
            if (projectUserRoles.isEmpty()) {
                continue;
            }

            ProjectUserVo projectUserVo = new ProjectUserVo();
            projectUserVo.setDeptName(deptName);
            projectUserVo.setProjectUserRoles(projectUserRoles); // 设置项目成员角色
            BeanCopyUtils.copy(user, projectUserVo);

            projectUserVos.add(projectUserVo);
        }
        return projectUserVos;
    }

    /**
     * 根据项目ID查找项目负责人姓名
     *
     * @param projectId
     * @return
     */
    @Override
    public String findProLeaderNameById(Long projectId) {
        List<ProjectUserVo> projectUserVos = getUserInfoByProjectId(projectId);
        for (ProjectUserVo projectUserVo : projectUserVos) {
            List<ProjectUserRole> roles = projectUserVo.getProjectUserRoles();
            if (roles.stream().anyMatch(role -> ProjectUserRole.PROJECT_LEADER.getValue().equals(role))) {
                return projectUserVo.getNickName();
            }

        }
        return "";
    }

//    public TableDataInfo<ProjectUserVo> queryPageAllList(ProjectUserBo projectUserBo, PageQuery pageQuery) {
//        projectUserBo = Optional.ofNullable(projectUserBo).orElseGet(ProjectUserBo::new);
//        List<SysUser> userList = getUserListByQuery(projectUserBo, pageQuery);
//        List<ProjectUserVo> projectUserVoList = userList.stream()
//            .map(this::createProjectUserVo)
//            .collect(Collectors.toList());
//        return TableDataInfo.build(projectUserVoList);
//    }

    //获取当页显示的用户列表
//    private List<SysUser> getUserListByQuery(ProjectUserBo projectUserBo, PageQuery pageQuery) {
//        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//
//        if (projectUserBo != null) {
//            if (projectUserBo.getUserId() != null) {
//                lambdaQueryWrapper.eq(SysUser::getUserId, projectUserBo.getUserId());
//            }
//            if (projectUserBo.getProjectId() != null) {
//                Set<Long> userIds = getUserIdsByProjectId(projectUserBo.getProjectId());
//                lambdaQueryWrapper.in(SysUser::getUserId, userIds);
//            }
//        }
//
//        Page<SysUser> result = sysUserMapper.selectPage(pageQuery.build(), lambdaQueryWrapper);
//        return result.getRecords();
//    }

    /**
     * 分页查询项目成员Vo
     *
     * @param projectUserBo
     * @param pageQuery
     * @return
     */
    @Override
    public TableDataInfo<ProjectUserVo> queryPageAllList(ProjectUserBo projectUserBo, PageQuery pageQuery) {
        projectUserBo = Optional.ofNullable(projectUserBo).orElseGet(ProjectUserBo::new);
        Page<SysUser> userPage = getUserListByQuery(projectUserBo, pageQuery);
        List<ProjectUserVo> projectUserVoList = userPage.getRecords().stream()
            .map(this::createProjectUserVo)
            .collect(Collectors.toList());

        // 使用 userPage.getTotal() 获取总记录数
        return new TableDataInfo<>(projectUserVoList, userPage.getTotal());
    }

    private Page<SysUser> getUserListByQuery(ProjectUserBo projectUserBo, PageQuery pageQuery) {
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        if (projectUserBo != null) {
            if (projectUserBo.getUserId() != null) {
                lambdaQueryWrapper.eq(SysUser::getUserId, projectUserBo.getUserId());
            }
            if (projectUserBo.getProjectId() != null) {
                Set<Long> userIds = getUserIdsByProjectId(projectUserBo.getProjectId());
                if (userIds.isEmpty()){
                    return new Page<>();
                }
                lambdaQueryWrapper.in(SysUser::getUserId, userIds);
            }
        }

        return sysUserMapper.selectPage(pageQuery.build(), lambdaQueryWrapper);
    }

    // 创建 ProjectUserVo 对象
    private ProjectUserVo createProjectUserVo(SysUser user) {
        ProjectUserVo projectUserVo = new ProjectUserVo();
        BeanCopyUtils.copy(user, projectUserVo);
        setProjectLevelCount(projectUserVo, user.getUserId(), false);
        setProjectLevelCount(projectUserVo, user.getUserId(), true);
        return projectUserVo;
    }

    // 设置项目级别计数
    private void setProjectLevelCount(ProjectUserVo projectUserVo, Long userId, boolean isCurrent) {
        List<Map<String, Object>> mapList = isCurrent ? getNowProjectLevelCountByUserId(userId)
            : getProjectLevelCountByUserId(userId);
        Map<ProjectLevel, Integer> projectLevelCountMap = processProjectLevelCount(mapList);
        setProjectLevelDataToVo(projectUserVo, projectLevelCountMap, isCurrent);
    }

    // 获取用户对应的项目级别计数数据
    private List<Map<String, Object>> getProjectLevelCountByUserId(Long userId) {
        return projectUserMapper.getProjectLevelCountByUserId(userId);
    }

    //获取用户对应的当前项目级别计数数据
    private List<Map<String, Object>> getNowProjectLevelCountByUserId(Long userId) {
        return projectUserMapper.getNowProjectLevelCountByUserId(userId);
    }

    // 处理项目级别计数数据
    private Map<ProjectLevel, Integer> processProjectLevelCount(List<Map<String, Object>> mapList) {
        Map<ProjectLevel, Integer> projectLevelCountMap = new HashMap<>();
        for (Map<String, Object> map : mapList) {
            Integer projectLevelValue = (Integer) map.get("project_level");
            Long countLong = (Long) map.get("count");
            Integer count = countLong != null ? countLong.intValue() : null;

            ProjectLevel level = Arrays.stream(ProjectLevel.values())
                .filter(e -> e.getValue().equals(projectLevelValue))
                .findFirst()
                .orElse(null);

            if (level != null) {
                projectLevelCountMap.put(level, count);
            }
        }
        return projectLevelCountMap;
    }

    // 将项目级别计数数据设置到 ProjectUserVo 对象中
    private void setProjectLevelDataToVo(ProjectUserVo projectUserVo,
                                         Map<ProjectLevel, Integer> projectLevelCountMap,
                                         boolean isCurrent) {
        if (isCurrent) {
            projectUserVo.setUserNationNumNow(projectLevelCountMap.getOrDefault(ProjectLevel.NATIONAL, 0));
            projectUserVo.setUserProvincialNumNow(projectLevelCountMap.getOrDefault(ProjectLevel.PROVINCIAL, 0));
            projectUserVo.setUserEnterpriseNumNow(projectLevelCountMap.getOrDefault(ProjectLevel.ENTERPRISE, 0));
            projectUserVo.setUserProjectNumNow(projectLevelCountMap.values().stream().mapToInt(Integer::intValue).sum());
        } else {
            projectUserVo.setUserNationNum(projectLevelCountMap.getOrDefault(ProjectLevel.NATIONAL, 0));
            projectUserVo.setUserProvincialNum(projectLevelCountMap.getOrDefault(ProjectLevel.PROVINCIAL, 0));
            projectUserVo.setUserEnterpriseNum(projectLevelCountMap.getOrDefault(ProjectLevel.ENTERPRISE, 0));
            projectUserVo.setUserProjectNum(projectLevelCountMap.values().stream().mapToInt(Integer::intValue).sum());
        }
    }

    /**
     * 根据userId查询对应的各类型项目详情
     *
     * @param userId
     * @return
     */
    @Override
    public ProjectUserDetailVo getProjectUserDetailById(Long userId) {
        Set<Long> projectIds = projectUserMapper.selectList(new LambdaQueryWrapper<ProjectUser>()
                .eq(ProjectUser::getUserId, userId))
            .stream()
            .filter(projectUser -> !projectUser.getProjectUserRole().equals(ProjectUserRole.PROJECT_ENTRY_OPERATOR))
            .map(ProjectUser::getProjectId)
            .collect(Collectors.toSet());

        if (projectIds.isEmpty()) {
            return new ProjectUserDetailVo();
        }

        List<ProjectBaseInfo> projectBaseInfos = projectBaseInfoMapper.selectList(new LambdaQueryWrapper<ProjectBaseInfo>()
            .in(ProjectBaseInfo::getProjectId, projectIds)
            .le(ProjectBaseInfo::getProjectEstablishTime, LocalDate.now())
            .ge(ProjectBaseInfo::getProjectScheduledCompletionTime, LocalDate.now()));

        Map<ProjectLevel, List<ProjectBaseInfo>> classifiedProjects = projectBaseInfos.stream()
            .collect(Collectors.groupingBy(ProjectBaseInfo::getProjectLevel));

        ProjectUserDetailVo projectUserDetailVo = new ProjectUserDetailVo();
        projectUserDetailVo.setNationProjectBaseInfos(classifiedProjects.getOrDefault(ProjectLevel.NATIONAL, Collections.emptyList()));
        projectUserDetailVo.setProvincialProjectBaseInfos(classifiedProjects.getOrDefault(ProjectLevel.PROVINCIAL, Collections.emptyList()));
        projectUserDetailVo.setEnterpriseProjectBaseInfos(classifiedProjects.getOrDefault(ProjectLevel.ENTERPRISE, Collections.emptyList()));

        return projectUserDetailVo;

    }

    /**
     * @param projectUserList
     */
    @Override
    public void deleteProjectUserList(List<ProjectUser> projectUserList) {
        if (projectUserList == null || projectUserList.isEmpty()) {
            return;
        }
        projectUserList.stream().map(projectUser -> projectUserMapper.delete(new LambdaQueryWrapper<ProjectUser>()
            .eq(ProjectUser::getProjectId, projectUser.getProjectId())
            .eq(ProjectUser::getUserId, projectUser.getUserId())
            .eq(ProjectUser::getProjectUserRole, projectUser.getProjectUserRole())
        )).collect(Collectors.toList());
    }

    private List<ProjectUser> projectUserBOListToProjectUserList(List<ProjectUserBo> projectUserBOList, Long projectId) {
        if (projectUserBOList == null || projectUserBOList.isEmpty()) {
            return Collections.emptyList();
        }
        return projectUserBOList.stream()
            .flatMap(projectUserBo -> {
                List<ProjectUserRole> roles = projectUserBo.getProjectUserRoleList();
                if (roles == null || roles.isEmpty()) {
                    return Stream.empty();
                }
                return roles.stream()
                    .map(projectUserRole -> {
                        ProjectUser projectUser = new ProjectUser();
                        projectUser.setProjectId(projectId);
                        projectUser.setUserId(projectUserBo.getUserId());
                        projectUser.setProjectUserRole(projectUserRole);
                        return projectUser;
                    });
            })
            .collect(Collectors.toList());
    }
}
