package com.ruoyi.project.service;

import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.ProjectLevel;
import com.ruoyi.project.domain.ProjectUser;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.bo.ProjectUserBo;
import com.ruoyi.project.domain.vo.ProjectBaseInfoVO;
import com.ruoyi.project.domain.vo.ProjectUserVo;
import org.apache.catalina.User;

import java.util.List;
import java.util.Map;

public interface ProjectUserService {

    boolean insertProjectUsers(List<ProjectUser> projectUserList);

    int deleteProjectUsersByProID(Long projectId);

    List<ProjectUserVo> getUserInfoByProjectId(Long projectId);

    String findProLeaderNameById(Long projectId);

    TableDataInfo<ProjectUserVo> queryPageAllList(ProjectUserBo projectUserBo, PageQuery pageQuery);

}
