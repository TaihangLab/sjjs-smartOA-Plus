package com.ruoyi.ip.mapper;

import com.ruoyi.common.core.mapper.BaseMapperPlus;
import com.ruoyi.ip.domin.IpUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author bailingnan
 * @description 针对表【ip_user(知识产权和用户关联表)】的数据库操作Mapper
 * @createDate 2023-12-29 17:37:22
 * @Entity com.ruoyi.ip.domin.IpUser
 */
@Mapper
public interface IpUserMapper extends BaseMapperPlus<IpUserMapper, IpUser, IpUser> {
}




