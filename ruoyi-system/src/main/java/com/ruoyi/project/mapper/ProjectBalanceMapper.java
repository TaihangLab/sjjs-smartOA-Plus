package com.ruoyi.project.mapper;

import com.ruoyi.common.core.mapper.BaseMapperPlus;
import com.ruoyi.project.domain.ProjectBalance;
import org.apache.ibatis.annotations.Mapper;

/**
* @author bailingnan
* @description 针对表【project_balance(项目余额表（单位：万元）)】的数据库操作Mapper
 * @createDate 2024-03-21 09:22:46
* @Entity com.ruoyi.project.domain.ProjectBalance
*/
@Mapper
public interface ProjectBalanceMapper extends BaseMapperPlus<ProjectBalanceMapper, ProjectBalance, ProjectBalance> {

}




