package com.ruoyi.project.mapper;

import com.ruoyi.common.core.mapper.BaseMapperPlus;
import com.ruoyi.project.domain.ProjectMilestoneCategory;
import com.ruoyi.project.domain.ProjectMilestoneCategoryRelation;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目大事记分类关系表 数据层
 * */

@Mapper
public interface ProjectMilestoneCategoryRelationMapper extends BaseMapperPlus<ProjectMilestoneCategoryRelationMapper, ProjectMilestoneCategoryRelation, ProjectMilestoneCategoryRelation> {

}
