package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.helper.LoginHelper;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.project.domain.ProjectBaseInfo;
import com.ruoyi.project.domain.ProjectUser;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.vo.ProjectBaseInfoVO;
import com.ruoyi.project.domain.vo.ProjectInfoVO;
import com.ruoyi.project.mapper.ProjectBaseInfoMapper;
import com.ruoyi.project.mapper.ProjectUserMapper;
import com.ruoyi.project.service.ProjectBaseInfoService;
import com.ruoyi.project.service.ProjectUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author bailingnan
 * @date 2023/12/7
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ProjectBaseInfoServiceImpl implements ProjectBaseInfoService {
    private final ProjectBaseInfoMapper projectBaseInfoMapper;

    private final ProjectUserMapper projectUserMapper;

    private final ProjectUserService projectUserService;

    /**
     * @param projectBaseInfoBO
     * @param pageQuery
     * @return
     */
    @Override
    public TableDataInfo<ProjectBaseInfoVO> queryPageAllList(ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery) {
        LambdaQueryWrapper<ProjectBaseInfo> lqw = buildAllListQueryWrapper(projectBaseInfoBO);
        Page<ProjectBaseInfoVO> result = projectBaseInfoMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * @param projectBaseInfoBO
     * @param pageQuery
     * @return
     */
    @Override
    public TableDataInfo<ProjectBaseInfoVO> queryPageMyList(ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery) {
        LambdaQueryWrapper<ProjectBaseInfo> lqw = buildMyListQueryWrapper(projectBaseInfoBO);
        Page<ProjectBaseInfoVO> result = projectBaseInfoMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    private LambdaQueryWrapper<ProjectBaseInfo> buildAllListQueryWrapper(ProjectBaseInfoBO projectBaseInfoBO) {
        LambdaQueryWrapper<ProjectBaseInfo> lqw = buildCommonQueryWrapper(projectBaseInfoBO);
        if (projectBaseInfoBO.getUserId() == null) {
            return lqw;
        }
        List<Long> projectIdList = getProjectIdsByUserId(projectBaseInfoBO.getUserId());
        if (projectIdList.isEmpty()) {
            lqw.apply("0=1");
        } else {
            lqw.in(ProjectBaseInfo::getProjectId, projectIdList);
        }
        return lqw;
    }

    private LambdaQueryWrapper<ProjectBaseInfo> buildMyListQueryWrapper(ProjectBaseInfoBO projectBaseInfoBO) {
        LambdaQueryWrapper<ProjectBaseInfo> lqw = buildCommonQueryWrapper(projectBaseInfoBO);
        List<Long> loginProjectIds = Optional.ofNullable(LoginHelper.getUserId())
            .map(this::getProjectIdsByUserId)
            .orElse(Collections.emptyList());
        if (loginProjectIds.isEmpty()) {
            lqw.apply("0=1");
            return lqw;
        }
        if (projectBaseInfoBO.getUserId() == null) {
            lqw.in(ProjectBaseInfo::getProjectId, loginProjectIds);
            return lqw;
        }
        List<Long> userProjectIds = getProjectIdsByUserId(projectBaseInfoBO.getUserId());
        if (userProjectIds.isEmpty()) {
            lqw.apply("0=1");
            return lqw;
        }
        List<Long> projectIds = getIntersection(loginProjectIds, userProjectIds);
        if (projectIds.isEmpty()) {
            lqw.apply("0=1");
        } else {
            lqw.in(ProjectBaseInfo::getProjectId, projectIds);
        }
        return lqw;
    }

    private LambdaQueryWrapper<ProjectBaseInfo> buildCommonQueryWrapper(ProjectBaseInfoBO projectBaseInfoBO) {
        LambdaQueryWrapper<ProjectBaseInfo> lqw = Wrappers.lambdaQuery();
        log.info("ProjectBaseInfoBO为:{}", projectBaseInfoBO);
        lqw.like(StringUtils.isNotBlank(projectBaseInfoBO.getAssignedSubjectName()), ProjectBaseInfo::getAssignedSubjectName, projectBaseInfoBO.getAssignedSubjectName());
        lqw.like(StringUtils.isNotBlank(projectBaseInfoBO.getAssignedSubjectSection()), ProjectBaseInfo::getAssignedSubjectSection, projectBaseInfoBO.getAssignedSubjectSection());
        //log.info("projectBaseInfoBO.getHasCooperativeUnit()为:{}",projectBaseInfoBO.getHasCooperativeUnit().getValue());
        lqw.eq(projectBaseInfoBO.getHasCooperativeUnit() != null, ProjectBaseInfo::getHasCooperativeUnit, projectBaseInfoBO.getHasCooperativeUnit());
        lqw.eq(projectBaseInfoBO.getProjectLevel() != null, ProjectBaseInfo::getProjectLevel, projectBaseInfoBO.getProjectLevel());
        lqw.ge(projectBaseInfoBO.getProjectEstablishTimeSta() != null, ProjectBaseInfo::getProjectEstablishTime, projectBaseInfoBO.getProjectEstablishTimeSta());
        lqw.le(projectBaseInfoBO.getProjectEstablishTimeEnd() != null, ProjectBaseInfo::getProjectEstablishTime, projectBaseInfoBO.getProjectEstablishTimeEnd());
        lqw.ge(projectBaseInfoBO.getProjectScheduledCompletionTimeSta() != null, ProjectBaseInfo::getProjectScheduledCompletionTime, projectBaseInfoBO.getProjectScheduledCompletionTimeSta());
        lqw.le(projectBaseInfoBO.getProjectScheduledCompletionTimeEnd() != null, ProjectBaseInfo::getProjectScheduledCompletionTime, projectBaseInfoBO.getProjectScheduledCompletionTimeEnd());
        lqw.orderByDesc(ProjectBaseInfo::getCreateTime);
        return lqw;
    }

    private List<Long> getProjectIdsByUserId(Long userId) {
        return projectUserMapper.selectList(new LambdaQueryWrapper<ProjectUser>().eq(ProjectUser::getUserId, userId))
            .stream()
            .map(ProjectUser::getProjectId)
            .collect(Collectors.toList());
    }

    private List<Long> getIntersection(List<Long> list1, List<Long> list2) {
        return list1.stream()
            .filter(list2::contains)
            .collect(Collectors.toList());
    }


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
        projectInfoVO.setProjectLeader(projectUserService.findProLeaderNameById(projectId));

        BeanCopyUtils.copy(projectBaseInfo, projectInfoVO);
        return projectInfoVO;
    }

    /**
     * 新增项目基本信息
     *
     * @param projectBaseInfo
     * @return
     */
    @Override
    public Long addProjectBaseInfo(ProjectBaseInfo projectBaseInfo) {
        if (projectBaseInfo == null) {
            throw new IllegalArgumentException("projectBaseInfo cannot be null");
        }
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
     * @param projectBaseInfo
     * @return
     */
    @Override
    public void updateProjectBaseInfoById(ProjectBaseInfo projectBaseInfo) {
        if (projectBaseInfo == null) {
            throw new IllegalArgumentException("projectBaseInfo cannot be null");
        }
        int cnt = projectBaseInfoMapper.updateById(projectBaseInfo);
        if (cnt != 1) {
            log.error("更新失败的projectBaseInfo为:{}", projectBaseInfo);
            throw new RuntimeException("更新项目失败");
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
        if (cnt == 0) {
            log.error("删除失败的projectId为:{}", projectId);
            throw new NoSuchElementException("删除项目基本信息失败,projectId为:" + projectId);
        }
    }

    /**
     * @return
     */
    @Override
    public List<Map<String, Object>> getProjectIdAndNameMapping() {
        LambdaQueryWrapper<ProjectBaseInfo> lqw = Wrappers.lambdaQuery();
        lqw.select(ProjectBaseInfo::getProjectId, ProjectBaseInfo::getAssignedSubjectName);
        List<ProjectBaseInfo> projectBaseInfoList = projectBaseInfoMapper.selectList(lqw);
        List<Map<String, Object>> projectIdAndNameMapping = projectBaseInfoList.stream()
            .map(projectBaseInfo -> {
                Map<String, Object> map = new HashMap<>();
                map.put("label", projectBaseInfo.getAssignedSubjectName());
                map.put("value", projectBaseInfo.getProjectId());
                return map;
            })
            .collect(Collectors.toList());
        HashMap<String, Object> map = new HashMap<>();
        map.put("label", "无关联项目");
        map.put("value", -1);
        projectIdAndNameMapping.add(map);
        return projectIdAndNameMapping;
    }
}
