package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ProjectLevelEnum;
import com.ruoyi.common.enums.ProjectUserRoleEnum;
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

/**
 * 项目成员
 *
 * @author bailingnan
 * @date 2024/02/06
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ProjectUserServiceImpl implements ProjectUserService {

    private final ProjectUserMapper projectUserMapper;

    private final SysUserMapper sysUserMapper;

    private final SysDeptMapper sysDeptMapper;

    private final ProjectBaseInfoMapper projectBaseInfoMapper;

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
        Map<ProjectLevelEnum, Integer> projectLevelCountMap = processProjectLevelCount(mapList);
	    setProjectLevelDataToVo(projectUserVo, projectLevelCountMap, isCurrent);
    }

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
    @Transactional(rollbackFor = Exception.class)
    public void insertProjectUsersOnCreate(List<ProjectUserBo> projectUserBoList, Long projectId) {
	    insertLoginUserToBO(projectUserBoList);
	    insertProjectUsers(projectUserBoList, projectId);
    }

    /**
     * @param projectUserBOList
     * @param projectId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProjectUsers(List<ProjectUserBo> projectUserBOList, Long projectId) {
	    insertLoginUserToBO(projectUserBOList);
        List<ProjectUser> oldProjectUserList = projectUserMapper.selectList(new LambdaQueryWrapper<ProjectUser>().eq(ProjectUser::getProjectId, projectId));
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
    public int deleteProjectUsersByProjectId(Long projectId) {
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
        Map<Long, List<ProjectUserRoleEnum>> projectRolesMap = getProjectRolesByMemberIds(projectId, userIds);

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
     * 根据项目ID获取相关用户的ID集合
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
            .map(sysUserMapper::selectById) // 获取对应的 SysUser 对象
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
    private Map<Long, List<ProjectUserRoleEnum>> getProjectRolesByMemberIds(Long projectId, Set<Long> memberIds) {
        if (memberIds == null || memberIds.isEmpty()) {
            return Collections.emptyMap();
        }

        LambdaQueryWrapper<ProjectUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(ProjectUser::getUserId, memberIds).eq(ProjectUser::getProjectId, projectId);
        List<ProjectUser> projectUsers = projectUserMapper.selectList(queryWrapper);

        Map<Long, List<ProjectUserRoleEnum>> userIdToProjectUserRolesMap = new HashMap<>();
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
    private List<ProjectUserVo> buildProjectUserVoList(Set<Long> userIds, Map<Long, SysUser> userIdToUserMap, Map<Long, String> deptIdToNameMap, Map<Long, List<ProjectUserRoleEnum>> userIdToProjectUserRolesMap) {
        List<ProjectUserVo> projectUserVos = new ArrayList<>();
        for (Long userId : userIds) {
            SysUser user = userIdToUserMap.get(userId);
            String deptName = deptIdToNameMap.getOrDefault(user.getDeptId(), "Unknown Dept");
            List<ProjectUserRoleEnum> projectUserRoleEnums = userIdToProjectUserRolesMap.getOrDefault(userId, Collections.singletonList(ProjectUserRoleEnum.UNKNOWN))
                .stream().filter(projectUserRoleEnum -> !projectUserRoleEnum.equals(ProjectUserRoleEnum.PROJECT_ENTRY_OPERATOR)).collect(Collectors.toList());
            if (projectUserRoleEnums.isEmpty()) {
                continue;
            }

            ProjectUserVo projectUserVo = new ProjectUserVo();
            projectUserVo.setDeptName(deptName);
            projectUserVo.setProjectUserRoles(projectUserRoleEnums); // 设置项目成员角色
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
    public String findProjectLeaderNameByProjectId(Long projectId) {
        return getTitleAndNameMapping(projectId).get(ProjectUserRoleEnum.PROJECT_LEADER.getTitle());
    }
//    @Override
//    public String findProjectLeaderNameByProjectId(Long projectId) {
//        List<ProjectUserVo> projectUserVos = getUserInfoByProjectId(projectId);
//        return projectUserVos.stream()
//            .filter(projectUserVo -> projectUserVo.getProjectUserRoles().stream()
//                .anyMatch(ProjectUserRoleEnum.PROJECT_LEADER::equals))
//            .map(ProjectUserVo::getNickName)
//            .collect(Collectors.joining(","));
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
                if (userIds.isEmpty()) {
                    return new Page<>();
                }
                lambdaQueryWrapper.in(SysUser::getUserId, userIds);
            }
        }

        return sysUserMapper.selectPage(pageQuery.build(), lambdaQueryWrapper);
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
    private Map<ProjectLevelEnum, Integer> processProjectLevelCount(List<Map<String, Object>> mapList) {
        Map<ProjectLevelEnum, Integer> projectLevelCountMap = new HashMap<>();
        for (Map<String, Object> map : mapList) {
            Integer projectLevelValue = (Integer) map.get("project_level");
            Long countLong = (Long) map.get("count");
            Integer count = countLong != null ? countLong.intValue() : null;

            ProjectLevelEnum level = Arrays.stream(ProjectLevelEnum.values())
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
                                         Map<ProjectLevelEnum, Integer> projectLevelCountMap,
                                         boolean isCurrent) {
        if (isCurrent) {
            projectUserVo.setUserNationNumNow(projectLevelCountMap.getOrDefault(ProjectLevelEnum.NATIONAL, 0));
            projectUserVo.setUserProvincialNumNow(projectLevelCountMap.getOrDefault(ProjectLevelEnum.PROVINCIAL, 0));
            projectUserVo.setUserEnterpriseNumNow(projectLevelCountMap.getOrDefault(ProjectLevelEnum.ENTERPRISE, 0));
            projectUserVo.setUserProjectNumNow(projectLevelCountMap.values().stream().mapToInt(Integer::intValue).sum());
        } else {
            projectUserVo.setUserNationNum(projectLevelCountMap.getOrDefault(ProjectLevelEnum.NATIONAL, 0));
            projectUserVo.setUserProvincialNum(projectLevelCountMap.getOrDefault(ProjectLevelEnum.PROVINCIAL, 0));
            projectUserVo.setUserEnterpriseNum(projectLevelCountMap.getOrDefault(ProjectLevelEnum.ENTERPRISE, 0));
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
            .filter(projectUser -> !projectUser.getProjectUserRole().equals(ProjectUserRoleEnum.PROJECT_ENTRY_OPERATOR))
            .map(ProjectUser::getProjectId)
            .collect(Collectors.toSet());

        if (projectIds.isEmpty()) {
            return new ProjectUserDetailVo();
        }

        List<ProjectBaseInfo> projectBaseInfos = projectBaseInfoMapper.selectList(new LambdaQueryWrapper<ProjectBaseInfo>()
            .in(ProjectBaseInfo::getProjectId, projectIds)
            .le(ProjectBaseInfo::getProjectEstablishTime, LocalDate.now())
            .ge(ProjectBaseInfo::getProjectScheduledCompletionTime, LocalDate.now()));

        Map<ProjectLevelEnum, List<ProjectBaseInfo>> classifiedProjects = projectBaseInfos.stream()
            .collect(Collectors.groupingBy(ProjectBaseInfo::getProjectLevel));

        ProjectUserDetailVo projectUserDetailVo = new ProjectUserDetailVo();
        projectUserDetailVo.setNationProjectBaseInfos(classifiedProjects.getOrDefault(ProjectLevelEnum.NATIONAL, Collections.emptyList()));
        projectUserDetailVo.setProvincialProjectBaseInfos(classifiedProjects.getOrDefault(ProjectLevelEnum.PROVINCIAL, Collections.emptyList()));
        projectUserDetailVo.setEnterpriseProjectBaseInfos(classifiedProjects.getOrDefault(ProjectLevelEnum.ENTERPRISE, Collections.emptyList()));

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
        projectUserList.forEach(projectUser -> projectUserMapper.delete(new LambdaQueryWrapper<ProjectUser>()
            .eq(ProjectUser::getProjectId, projectUser.getProjectId())
            .eq(ProjectUser::getUserId, projectUser.getUserId())
            .eq(ProjectUser::getProjectUserRole, projectUser.getProjectUserRole())));
    }

    /**
     * @param userId
     *
     * @return
     */
    @Override
    public List<Long> getProjectIdListByUserId(Long userId) {
        return projectUserMapper.selectList(new LambdaQueryWrapper<ProjectUser>().eq(ProjectUser::getUserId, userId))
            .stream()
            .map(ProjectUser::getProjectId)
            .collect(Collectors.toList());
    }

    /**
     * @param projectId
     *
     * @return
     */
    @Override
    public Map<String, String> getTitleAndNameMapping(Long projectId) {
        // 获取项目相关的用户ID集合
        Set<Long> userIdSet = getUserIdsByProjectId(projectId);
        if (userIdSet.isEmpty()) {
            return Collections.emptyMap();
        }

        // 根据用户ID列表获取用户信息
        Map<Long, SysUser> userIdToUserMap = getUsersMapByUserIds(userIdSet);

        // 获取项目用户列表
        List<ProjectUser> projectUserList = projectUserMapper.selectList(new LambdaQueryWrapper<ProjectUser>()
            .eq(ProjectUser::getProjectId, projectId)
            .in(ProjectUser::getUserId, userIdSet));

        // 使用Stream API生成映射，其中键是标题，值是用户昵称串（逗号分隔）
        return projectUserList.stream()
            .collect(Collectors.groupingBy(
                projectUser -> projectUser.getProjectUserRole().getTitle(),
                Collectors.mapping(
                    projectUser -> userIdToUserMap.get(projectUser.getUserId()).getNickName(),
                    Collectors.joining(",")
                )
            ));
    }

    private List<ProjectUser> projectUserBOListToProjectUserList(List<ProjectUserBo> projectUserBOList, Long projectId) {
        if (projectUserBOList == null || projectUserBOList.isEmpty()) {
            return Collections.emptyList();
        }
        return projectUserBOList.stream()
            .flatMap(projectUserBo -> {
                List<ProjectUserRoleEnum> roles = projectUserBo.getProjectUserRoleList();
                if (roles == null || roles.isEmpty()) {
                    return Stream.empty();
                }
                return roles.stream()
                    .map(projectUserRoleEnum -> {
                        ProjectUser projectUser = new ProjectUser();
                        projectUser.setProjectId(projectId);
                        projectUser.setUserId(projectUserBo.getUserId());
                        projectUser.setProjectUserRole(projectUserRoleEnum);
                        return projectUser;
                    });
            })
            .collect(Collectors.toList());
    }

    private void insertLoginUserToBO(List<ProjectUserBo> projectUserBoList) {
        if (projectUserBoList == null) {
            projectUserBoList = new ArrayList<>();
        }
        ProjectUserBo projectLoginUserBo = new ProjectUserBo();
        projectLoginUserBo.setUserId(LoginHelper.getUserId());
        projectLoginUserBo.setProjectUserRoleList(Collections.singletonList(ProjectUserRoleEnum.PROJECT_ENTRY_OPERATOR));
        projectUserBoList.add(projectLoginUserBo);
    }
}
