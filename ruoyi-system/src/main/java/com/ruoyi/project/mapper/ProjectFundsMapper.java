package com.ruoyi.project.mapper;

import com.ruoyi.common.core.mapper.BaseMapperPlus;
import com.ruoyi.project.domain.ProjectFunds;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author bailingnan
* @description 针对表【project_funds(项目经费表)】的数据库操作Mapper
* @createDate 2023-12-05 15:47:00
* @Entity com.ruoyi.project.domain.ProjectFunds
*/
@Mapper
public interface ProjectFundsMapper extends BaseMapperPlus<ProjectFundsMapper,ProjectFunds,ProjectFunds> {

}




