package com.ruoyi.project.mapper;

import com.ruoyi.common.core.mapper.BaseMapperPlus;
import com.ruoyi.project.domain.ProjectUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目成员表 数据层
 *
 * @author fanjiaxing
 */
@Mapper
public interface ProjectUserMapper extends BaseMapperPlus<ProjectUserMapper, ProjectUser,ProjectUser> {

}
