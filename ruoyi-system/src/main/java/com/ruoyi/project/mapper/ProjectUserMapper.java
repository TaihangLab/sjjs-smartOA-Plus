package com.ruoyi.project.mapper;

import com.ruoyi.common.core.mapper.BaseMapperPlus;
import com.ruoyi.common.enums.ProjectLevel;
import com.ruoyi.project.domain.ProjectUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 项目成员表 数据层
 *
 * @author fanjiaxing
 */
@Mapper
public interface ProjectUserMapper extends BaseMapperPlus<ProjectUserMapper, ProjectUser,ProjectUser> {
    List<Map<String, Object>> getProjectLevelCountByUserId(Long userId);

    List<Map<String, Object>> getNowProjectLevelCountByUserId(Long userId);
}
