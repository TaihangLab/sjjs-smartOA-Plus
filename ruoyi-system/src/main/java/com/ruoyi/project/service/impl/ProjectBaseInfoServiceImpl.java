package com.ruoyi.project.service.impl;

import com.ruoyi.project.domain.ProjectBaseInfo;
import com.ruoyi.project.mapper.ProjectBaseInfoMapper;
import com.ruoyi.project.service.ProjectBaseInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * @author bailingnan
 * @date 2023/12/7
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ProjectBaseInfoServiceImpl implements ProjectBaseInfoService {
    private final ProjectBaseInfoMapper projectBaseInfoMapper;

    /**
     * 新增项目基本信息
     *
     * @param projectBaseInfo
     * @return
     */
    @Override
    public Long insertProjectBaseInfo(ProjectBaseInfo projectBaseInfo) {
        if (projectBaseInfo == null) {
            throw new IllegalArgumentException("projectBaseInfo cannot be null");
        }
        int cnt = projectBaseInfoMapper.insert(projectBaseInfo);
        if (cnt == 0) {
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
    public Long updateProjectBaseInfoById(ProjectBaseInfo projectBaseInfo) {
        if (projectBaseInfo == null) {
            throw new IllegalArgumentException("projectBaseInfo cannot be null");
        }
        int cnt = projectBaseInfoMapper.updateById(projectBaseInfo);
        if (cnt == 0) {
            log.error("更新失败的projectBaseInfo为:{}", projectBaseInfo);
            throw new RuntimeException("更新项目失败");
        }
        return projectBaseInfo.getProjectId();
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
}
