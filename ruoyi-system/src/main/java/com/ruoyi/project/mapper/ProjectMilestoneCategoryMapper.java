package com.ruoyi.project.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.core.mapper.BaseMapperPlus;
import com.ruoyi.common.enums.ProjectMilestoneCategoryEnum;
import com.ruoyi.project.domain.ProjectMilestone;
import com.ruoyi.project.domain.ProjectMilestoneCategory;
import com.ruoyi.project.domain.vo.ProjectMilestoneVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/***
 *项目大事记分类表 数据层
 * */

@Mapper
public interface ProjectMilestoneCategoryMapper extends BaseMapperPlus<ProjectMilestoneCategoryMapper, ProjectMilestoneCategory, ProjectMilestoneCategory>{
}
