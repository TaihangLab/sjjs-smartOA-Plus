package com.ruoyi.ip.mapper;

import com.ruoyi.common.core.mapper.BaseMapperPlus;
import com.ruoyi.ip.domain.IpUser;
import com.ruoyi.ip.domain.vo.IpUserVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 针对表【ip_user(知识产权和用户关联表)】的数据库操作Mapper
 *
 * @author bailingnan
 * @createDate 2024-01-05 17:04:23
 * @Entity com.ruoyi.ip.domain.IpUser
 * @date 2024/02/06
 */
@Mapper
public interface IpUserMapper extends BaseMapperPlus<IpUserMapper, IpUser, IpUserVO> {

}




