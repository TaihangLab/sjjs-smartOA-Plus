package com.ruoyi.project.mapper;

import com.ruoyi.common.core.mapper.BaseMapperPlus;
import com.ruoyi.project.domain.ProjectFunds;
import com.ruoyi.project.domain.vo.ProjectFundsVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author bailingnan
 * @description 针对表【project_funds(项目经费表（单位：万元）)】的数据库操作Mapper
 * @createDate 2024-03-18 17:31:40
 * @Entity com.ruoyi.project.domain.ProjectFunds
 */
@Mapper
public interface ProjectFundsMapper extends BaseMapperPlus<ProjectFundsMapper, ProjectFunds, ProjectFundsVO> {

}




