package com.ruoyi.project.service;

import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.project.domain.ProjectBaseInfo;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.vo.ProjectBaseInfoVO;
import com.ruoyi.project.domain.vo.ProjectInfoVO;

/**
 * @author bailingnan
 * @date 2023/12/7
 */
public interface ProjectBaseInfoService {
    ProjectInfoVO selectProjectInfoVOById(Long projectId);
    Long insertProjectBaseInfo(ProjectBaseInfo projectBaseInfo);

    Long updateProjectBaseInfoById(ProjectBaseInfo projectBaseInfo);

    void deleteProjectBaseInfoById(Long projectId);

    TableDataInfo<ProjectBaseInfoVO> queryPageAllList(ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery);
    TableDataInfo<ProjectBaseInfoVO> queryPageMyList(ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery);
}
