package com.ruoyi.project.service;

import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.vo.ProjectFundsManagementVO;

/**
 * 项目经费管理Service
 *
 * @author bailingnan
 * @date 2024/03/04
 */
public interface ProjectFundsManagementService {
    TableDataInfo<ProjectFundsManagementVO> queryPageList(ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery);
}
