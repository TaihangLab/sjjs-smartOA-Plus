package com.ruoyi.project.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.project.domain.ProjectBaseInfo;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.vo.ProjectBaseInfoVO;
import com.ruoyi.project.domain.vo.ProjectInfoVO;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 项目基本信息Service接口
 *
 * @author bailingnan
 * @date 2023/12/7
 */
public interface ProjectBaseInfoService {
    /**
     * 根据项目id获取项目VO信息
     *
     * @param projectId
     *
     * @return {@link ProjectInfoVO}
     */
    ProjectInfoVO selectProjectInfoVOById(Long projectId);


    /**
     * 根据项目id获取项目基本信息
     *
     * @param projectId
     *
     * @return {@link ProjectBaseInfo}
     */
    ProjectBaseInfo selectProjectBaseInfoById(Long projectId);

    /**
     * 新增项目基本信息
     *
     * @param projectBaseInfoBO
     *
     * @return {@link Long}
     */
    Long insertProjectBaseInfo(ProjectBaseInfoBO projectBaseInfoBO);

    /**
     * 更新项目基本信息
     *
     * @param projectBaseInfoBO
     */
    void updateProjectBaseInfoById(ProjectBaseInfoBO projectBaseInfoBO);

    /**
     * 根据项目id删除项目基本信息
     *
     * @param projectId
     */
    void deleteProjectBaseInfoById(Long projectId);

    /**
     * 获取所有项目列表
     *
     * @param projectBaseInfoBO
     * @param pageQuery
     *
     * @return {@link TableDataInfo}<{@link ProjectBaseInfoVO}>
     */
    TableDataInfo<ProjectBaseInfoVO> queryPageAllList(ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery);

    /**
     * @param projectBaseInfoBO
     * @param pageQuery
     * @param voClass
     *
     * @return {@link TableDataInfo }<{@link ProjectBaseInfoVO }>
     */
    <C> Page<C> queryPageAllList(ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery, Class<C> voClass);


    /**
     * 获取我的项目列表
     *
     * @param projectBaseInfoBO
     * @param pageQuery
     *
     * @return {@link TableDataInfo}<{@link ProjectBaseInfoVO}>
     */
    TableDataInfo<ProjectBaseInfoVO> queryPageMyList(ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery);

    /**
     *获取我的项目列表
     *
     * @param projectBaseInfoBO
     * @param pageQuery
     * @param voClass
     *
     * @return {@link Page}<{@link C}>
     */
    <C> Page<C> queryPageMyList(ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery, Class<C> voClass);

    /**
     * 获取项目id和名称的映射
     *
     * @return {@link List}<{@link Map}<{@link String}, {@link Object}>>
     */
    List<Map<String, Object>> getProjectIdAndNameMapping();

    /**
     * 获取项目树映射
     *
     * @return {@link List}<{@link Map}<{@link String}, {@link Object}>>
     */
    List<Map<String, Object>> getProjectTreeMapping();

    /**
     * 根据项目id集合获取项目id和名称的映射
     *
     * @param projectIdSet
     *
     * @return {@link Map}<{@link Long}, {@link String}>
     */
    Map<Long, String> getProjectIdAndNameMappingByProjectIdSet(Set<Long> projectIdSet);

    /**
     * 获取项目级别统计
     *
     * @return {@link Map}<{@link String},{@link Integer}>
     */
    Map<String,Integer> getProjectLevelStatistics();

    /**
     * 获取项目路径
     *
     * @param projectId
     *
     * @return {@link List}<{@link Long}>
     */
    List<Long> getProjectPathById(Long projectId);
}
