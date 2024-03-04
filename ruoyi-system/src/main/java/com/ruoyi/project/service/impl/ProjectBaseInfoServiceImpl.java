package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ProjectLevelEnum;
import com.ruoyi.common.enums.ProjectUserRoleEnum;
import com.ruoyi.common.helper.LoginHelper;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.project.domain.ProjectBaseInfo;
import com.ruoyi.project.domain.ProjectFunds;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.vo.ProjectBaseInfoVO;
import com.ruoyi.project.domain.vo.ProjectInfoVO;
import com.ruoyi.project.mapper.ProjectBaseInfoMapper;
import com.ruoyi.project.service.ProjectBaseInfoService;
import com.ruoyi.project.service.ProjectFundsService;
import com.ruoyi.project.service.ProjectUserService;
import liquibase.pro.packaged.C;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.ruoyi.ip.constant.IpConstants.UNASSOCIATED_PROJECT_CODE;
import static com.ruoyi.ip.constant.IpConstants.UNASSOCIATED_PROJECT_IDENTIFIER;

/**
 * 项目基本信息
 *
 * @author bailingnan
 * @date 2023/12/7
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ProjectBaseInfoServiceImpl implements ProjectBaseInfoService {

    private final ProjectBaseInfoMapper projectBaseInfoMapper;

    private final ProjectUserService projectUserService;

    private final ProjectFundsService projectFundsService;

    /**
     * @param projectId
     * @return
     */
    @Override
    public ProjectInfoVO selectProjectInfoVOById(Long projectId) {
        ProjectInfoVO projectInfoVO = new ProjectInfoVO();
        ProjectBaseInfo projectBaseInfo = projectBaseInfoMapper.selectById(projectId);
        if (projectBaseInfo == null) {
            throw new NoSuchElementException("项目基本信息不存在,projectId为:" + projectId);
        }
        //调用projectUserService单独返回项目负责人名称
        projectInfoVO.setProjectLeader(projectUserService.findProjectLeaderNameByProjectId(projectId));

        BeanCopyUtils.copy(projectBaseInfo, projectInfoVO);
        return projectInfoVO;
    }

    /**
     * @param projectId
     * @return
     */
    @Override
    public ProjectBaseInfo selectProjectBaseInfoById(Long projectId) {
        return projectBaseInfoMapper.selectById(projectId);
    }

    /**
     * 新增项目基本信息
     *
     * @param projectBaseInfoBO
     * @return
     */
    @Override
    public Long insertProjectBaseInfo(ProjectBaseInfoBO projectBaseInfoBO) {
        if (projectBaseInfoBO == null) {
            throw new IllegalArgumentException("projectBaseInfoBO cannot be null");
        }
        ProjectBaseInfo projectBaseInfo = new ProjectBaseInfo();
        BeanCopyUtils.copy(projectBaseInfoBO, projectBaseInfo);
        int cnt = projectBaseInfoMapper.insert(projectBaseInfo);
        if (cnt != 1) {
            log.error("新增失败的projectBaseInfo为:{}", projectBaseInfo);
            throw new RuntimeException("新增项目失败");
        }
        Long projectId = projectBaseInfo.getProjectId();
        if (projectId == null) {
            throw new IllegalStateException("项目ID获取失败");
        }
        return projectId;
    }

    /**
     * 更新项目基本信息
     *
     * @return
     */
    @Override
    public void updateProjectBaseInfoById(ProjectBaseInfoBO projectBaseInfoBO) {
        if (projectBaseInfoBO == null) {
            throw new IllegalArgumentException("projectBaseInfoBO cannot be null");
        }
        if (projectBaseInfoBO.getProjectId() == null) {
            throw new IllegalArgumentException("projectId cannot be null");
        }
        ProjectBaseInfo projectBaseInfo = new ProjectBaseInfo();
        BeanCopyUtils.copy(projectBaseInfoBO, projectBaseInfo);
        if (projectBaseInfoMapper.updateById(projectBaseInfo) != 1) {
            log.error("更新失败的projectBaseInfo为:{}", projectBaseInfo);
            throw new RuntimeException("更新项目基本信息失败");
        }
    }

    /**
     * 删除项目基本信息
     *
     * @param projectId
     */
    @Override
    public void deleteProjectBaseInfoById(Long projectId) {
        int cnt = projectBaseInfoMapper.deleteById(projectId);
        if (cnt != 1) {
            log.error("删除失败的projectId为:{}", projectId);
            throw new NoSuchElementException("删除项目基本信息失败,projectId为:" + projectId);
        }
    }

    /**
     * @param projectBaseInfoBO
     * @param pageQuery
     *
     * @return
     */
    @Override
    public TableDataInfo<ProjectBaseInfoVO> queryPageAllList(ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery) {
        LambdaQueryWrapper<ProjectBaseInfo> lqw = buildAllListQueryWrapper(projectBaseInfoBO);
        Page<ProjectBaseInfoVO> result = projectBaseInfoMapper.selectVoPage(pageQuery.build(), lqw);
	    buildRecords(result.getRecords());
        return TableDataInfo.build(result);
    }



    /**
     * @param projectBaseInfoBO
     * @param pageQuery
     *
     * @return
     */
    @Override
    public TableDataInfo<ProjectBaseInfoVO> queryPageMyList(ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery) {
        LambdaQueryWrapper<ProjectBaseInfo> lqw = buildMyListQueryWrapper(projectBaseInfoBO);
        Page<ProjectBaseInfoVO> result = projectBaseInfoMapper.selectVoPage(pageQuery.build(), lqw);
	    buildRecords(result.getRecords());
        return TableDataInfo.build(result);
    }

    @Override
    public  <C> Page<C> queryPageMyList(ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery,Class<C> voClass) {
        LambdaQueryWrapper<ProjectBaseInfo> lqw = buildMyListQueryWrapper(projectBaseInfoBO);
        return projectBaseInfoMapper.selectVoPage(pageQuery.build(), lqw,voClass);
    }

    private LambdaQueryWrapper<ProjectBaseInfo> buildMyListQueryWrapper(ProjectBaseInfoBO projectBaseInfoBO) {
        if (projectBaseInfoBO == null) {
            return Wrappers.lambdaQuery();
        }
        LambdaQueryWrapper<ProjectBaseInfo> lqw = buildCommonQueryWrapper(projectBaseInfoBO);
        List<Long> loginProjectIdList = Optional.ofNullable(LoginHelper.getUserId())
            .map(projectUserService::getProjectIdListByUserId)
            .orElse(Collections.emptyList());
        if (loginProjectIdList.isEmpty()) {
            lqw.apply("0=1");
            return lqw;
        }
        if (projectBaseInfoBO.getUserId() == null) {
            lqw.in(ProjectBaseInfo::getProjectId, loginProjectIdList);
            return lqw;
        }
        List<Long> userProjectIdList = projectUserService.getProjectIdListByUserId(projectBaseInfoBO.getUserId());
        if (userProjectIdList.isEmpty()) {
            lqw.apply("0=1");
            return lqw;
        }
        List<Long> projectIdList = getIntersection(loginProjectIdList, userProjectIdList);
        if (projectIdList.isEmpty()) {
            lqw.apply("0=1");
        } else {
            lqw.in(ProjectBaseInfo::getProjectId, projectIdList);
        }
        return lqw;
    }

    private List<Long> getIntersection(List<Long> list1, List<Long> list2) {
        return list1.stream()
            .filter(list2::contains)
            .collect(Collectors.toList());
    }

    /**
     * @return
     */
    @Override
    public List<Map<String, Object>> getProjectIdAndNameMapping() {
        List<Map<String, Object>> projectTree = getProjectTreeMapping();
        Map<String, Object> map = new HashMap<>();
        map.put("label", UNASSOCIATED_PROJECT_IDENTIFIER);
        map.put("value", UNASSOCIATED_PROJECT_CODE);
        projectTree.add(map);
        return projectTree;
    }

    /**
     * 获取项目树形结构
     */
    @Override
    public List<Map<String, Object>> getProjectTreeMapping() {
        List<Map<String, Object>> projectTree = new ArrayList<>();
        Set<ProjectLevelEnum> projectLevels = getAllProjectLevels();
        for (ProjectLevelEnum projectLevel : projectLevels) {
            Map<String, Object> levelMap = new HashMap<>();
            levelMap.put("label", projectLevel.getDescription());
            levelMap.put("value", projectLevel.getValue());
            // 获取每种类型下的所有项目
            List<ProjectBaseInfo> projects = getProjectsByLevel(projectLevel);
            List<Map<String, Object>> children = new ArrayList<>();
            for (ProjectBaseInfo projectBaseInfo : projects) {
                Map<String, Object> projectMap = new HashMap<>();
                projectMap.put("label", projectBaseInfo.getAssignedSubjectName());
                projectMap.put("value", projectBaseInfo.getProjectId());
                children.add(projectMap);
            }
            levelMap.put("children", children);
            projectTree.add(levelMap);
        }
        return projectTree;
    }

    /**
     * @param projectIdSet
     *
     * @return
     */
    @Override
    public Map<Long, String> getProjectIdAndNameMappingByProjectIdSet(Set<Long> projectIdSet) {
        Map<Long, String> projectIdAndNameMapping = projectBaseInfoMapper.selectBatchIds(projectIdSet).stream()
            .collect(Collectors.toMap(ProjectBaseInfo::getProjectId, ProjectBaseInfo::getAssignedSubjectName));
        projectIdAndNameMapping.put(UNASSOCIATED_PROJECT_CODE, UNASSOCIATED_PROJECT_IDENTIFIER);
        return projectIdAndNameMapping;
    }

    /**
     * 查询每种项目类型及其对应的项目数量
     *
     * @return
     */
    @Override
    public Map<String, Integer> getProjectLevelStatistics() {
        Set<ProjectLevelEnum> allProjectLevels = getAllProjectLevels();
        Map<String, Integer> statistics = new HashMap<>();
        for (ProjectLevelEnum projectLevel : allProjectLevels) {
            List<ProjectBaseInfo> projectsByLevel = getProjectsByLevel(projectLevel);
            statistics.put(projectLevel.getDescription(), projectsByLevel.size());
        }
        return statistics;
    }

    /**
     * 根据项目ID获取项目路径。
     *
     * @param projectId 项目的ID
     * @return 代表项目路径的Long列表，如果未找到项目或ID为空，则为空列表
     */
    @Override
    public List<Long> getProjectPathById(Long projectId) {
        if (projectId == null || projectId.equals(UNASSOCIATED_PROJECT_CODE)) {
            return projectId == null ? Collections.emptyList() : Collections.singletonList(UNASSOCIATED_PROJECT_CODE);
        }

        ProjectBaseInfo projectBaseInfo = projectBaseInfoMapper.selectById(projectId);
        if (projectBaseInfo == null) {
            return Collections.emptyList();
        }

        ProjectLevelEnum projectLevel = projectBaseInfo.getProjectLevel();
        if (projectLevel == null) {
            throw new IllegalArgumentException("项目ID [" + projectId + "] 对应的项目信息有误，项目类型不能为空");
        }

        return Arrays.asList(projectLevel.getValue().longValue(), projectId);
    }

    // 获取所有项目类型的方法
    private Set<ProjectLevelEnum> getAllProjectLevels() {
        return projectBaseInfoMapper.selectList()
            .stream()
            .map(ProjectBaseInfo::getProjectLevel)
            .filter(Objects::nonNull)
            .collect(Collectors.toSet());
    }

    // 根据项目类型获取项目的方法
    private List<ProjectBaseInfo> getProjectsByLevel(ProjectLevelEnum projectLevel) {
        return projectBaseInfoMapper.selectList(
            new LambdaQueryWrapper<ProjectBaseInfo>()
                .eq(ProjectBaseInfo::getProjectLevel, projectLevel));
    }

    private LambdaQueryWrapper<ProjectBaseInfo> buildAllListQueryWrapper(ProjectBaseInfoBO projectBaseInfoBO) {
        if (projectBaseInfoBO == null) {
            return Wrappers.lambdaQuery();
        }
        LambdaQueryWrapper<ProjectBaseInfo> lqw = buildCommonQueryWrapper(projectBaseInfoBO);
        if (projectBaseInfoBO.getUserId() == null) {
            return lqw;
        }
        List<Long> projectIdList = projectUserService.getProjectIdListByUserId(projectBaseInfoBO.getUserId());
        if (projectIdList.isEmpty()) {
            lqw.apply("0=1");
        } else {
            lqw.in(ProjectBaseInfo::getProjectId, projectIdList);
        }
        return lqw;
    }

    private void buildRecords(List<ProjectBaseInfoVO> projectBaseInfoVOList) {
        if (projectBaseInfoVOList == null || projectBaseInfoVOList.isEmpty()) {
            return;
        }
        List<Long> projectIdList = projectBaseInfoVOList.stream().map(ProjectBaseInfoVO::getProjectId).collect(Collectors.toList());
        //获取经费对应信息
        Map<Long, ProjectFunds> projectFundsMap = projectFundsService.getProjectFundsMapByProjectIdList(projectIdList);

        projectBaseInfoVOList.forEach(projectBaseInfoVO -> {
            Long projectId = projectBaseInfoVO.getProjectId();
            //处理经费
            ProjectFunds projectFunds = projectFundsMap.get(projectId);
	        setFunds(projectBaseInfoVO, projectFunds);
	        setUsers(projectBaseInfoVO, projectId);
        });
    }

    private LambdaQueryWrapper<ProjectBaseInfo> buildCommonQueryWrapper(ProjectBaseInfoBO projectBaseInfoBO) {
        LambdaQueryWrapper<ProjectBaseInfo> lqw = Wrappers.lambdaQuery();
//        log.info("ProjectBaseInfoBO为:{}", projectBaseInfoBO);
        lqw.like(StringUtils.isNotBlank(projectBaseInfoBO.getAssignedSubjectName()), ProjectBaseInfo::getAssignedSubjectName, projectBaseInfoBO.getAssignedSubjectName());
        lqw.like(StringUtils.isNotBlank(projectBaseInfoBO.getAssignedSubjectSection()), ProjectBaseInfo::getAssignedSubjectSection, projectBaseInfoBO.getAssignedSubjectSection());
        //log.info("projectBaseInfoBO.getHasCooperativeUnit()为:{}",projectBaseInfoBO.getHasCooperativeUnit().getValue());
        lqw.eq(projectBaseInfoBO.getHasCooperativeUnit() != null, ProjectBaseInfo::getHasCooperativeUnit, projectBaseInfoBO.getHasCooperativeUnit());
        lqw.eq(projectBaseInfoBO.getProjectLevel() != null, ProjectBaseInfo::getProjectLevel, projectBaseInfoBO.getProjectLevel());
        lqw.ge(projectBaseInfoBO.getProjectEstablishTimeSta() != null, ProjectBaseInfo::getProjectEstablishTime, projectBaseInfoBO.getProjectEstablishTimeSta());
        lqw.le(projectBaseInfoBO.getProjectEstablishTimeEnd() != null, ProjectBaseInfo::getProjectEstablishTime, projectBaseInfoBO.getProjectEstablishTimeEnd());
        lqw.ge(projectBaseInfoBO.getProjectScheduledCompletionTimeSta() != null, ProjectBaseInfo::getProjectScheduledCompletionTime, projectBaseInfoBO.getProjectScheduledCompletionTimeSta());
        lqw.le(projectBaseInfoBO.getProjectScheduledCompletionTimeEnd() != null, ProjectBaseInfo::getProjectScheduledCompletionTime, projectBaseInfoBO.getProjectScheduledCompletionTimeEnd());
        lqw.orderByDesc(ProjectBaseInfo::getUpdateTime);
        return lqw;
    }

    private void setFunds(ProjectBaseInfoVO projectBaseInfoVO, ProjectFunds projectFunds) {
        if (projectFunds != null) {
            projectBaseInfoVO.setTotalFundsAll(projectFunds.getTotalFundsAll());
            projectBaseInfoVO.setTotalFundsZx(projectFunds.getTotalFundsZx());
            projectBaseInfoVO.setTotalFundsZc(projectFunds.getTotalFundsZc());
            projectBaseInfoVO.setTotalFundsZxDk(projectFunds.getTotalFundsZxDk());
            projectBaseInfoVO.setZctzDone(projectFunds.getZctzDone());
            projectBaseInfoVO.setZxtzDone(projectFunds.getZxtzDone());
            projectBaseInfoVO.setZcGspt(projectFunds.getZcGspt());
            projectBaseInfoVO.setZxGslc(projectFunds.getZxGslc());
        }
    }

    private void setUsers(ProjectBaseInfoVO projectBaseInfoVO, Long projectId) {
        Map<String, String> titleAndNameMapping = projectUserService.getTitleAndNameMapping(projectId);
        projectBaseInfoVO.setProjectLeader(titleAndNameMapping.getOrDefault(ProjectUserRoleEnum.PROJECT_LEADER.getTitle(), ""));
        projectBaseInfoVO.setCompanyLeader(titleAndNameMapping.getOrDefault(ProjectUserRoleEnum.COMPANY_LEADER.getTitle(), ""));
        projectBaseInfoVO.setDepartmentLeader(titleAndNameMapping.getOrDefault(ProjectUserRoleEnum.DEPARTMENT_LEADER.getTitle(), ""));
        projectBaseInfoVO.setResearchManager(titleAndNameMapping.getOrDefault(ProjectUserRoleEnum.RESEARCH_MANAGER.getTitle(), ""));
    }
}
