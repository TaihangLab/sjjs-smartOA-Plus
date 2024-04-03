package com.ruoyi.project.mapper;

import com.ruoyi.common.core.mapper.BaseMapperPlus;
import com.ruoyi.project.domain.ProjectBalancePaid;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author bailingnan
 * @description 针对表【project_balance_paid(项目余额表（单位：万元）)】的数据库操作Mapper
 * @createDate 2024-04-01 16:11:09
 * @Entity com.ruoyi.project.domain.ProjectBalancePaid
 */
@Mapper
public interface ProjectBalancePaidMapper
    extends BaseMapperPlus<ProjectBalancePaidMapper, ProjectBalancePaid, ProjectBalancePaid> {

}




