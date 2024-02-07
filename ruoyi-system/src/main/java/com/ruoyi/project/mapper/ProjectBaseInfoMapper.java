package com.ruoyi.project.mapper;

import com.ruoyi.common.core.mapper.BaseMapperPlus;
import com.ruoyi.project.domain.ProjectBaseInfo;
import com.ruoyi.project.domain.vo.ProjectBaseInfoVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 针对表【project_base_info(项目表)】的数据库操作Mapper
 *
 * @author bailingnan
 * @createDate 2023-12-13 23:08:39
 * @Entity com.ruoyi.project.domain.ProjectBaseInfo
 * @date 2024/02/06
 */
@Mapper
public interface ProjectBaseInfoMapper extends BaseMapperPlus<ProjectBaseInfoMapper,ProjectBaseInfo, ProjectBaseInfoVO> {

}




