package com.ruoyi.project.mapper;

import com.ruoyi.common.core.mapper.BaseMapperPlus;
import com.ruoyi.project.domain.ProjectPlan;
import com.ruoyi.project.domain.vo.ProjectPlanVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author bailingnan
 * @description 针对表【project_plan(项目计划表)】的数据库操作Mapper
 * @createDate 2023-12-21 14:26:02
 * @Entity com.ruoyi.project.domain.ProjectPlan
 */
@Mapper
public interface ProjectPlanMapper extends BaseMapperPlus<ProjectPlanMapper, ProjectPlan, ProjectPlanVO> {

}




