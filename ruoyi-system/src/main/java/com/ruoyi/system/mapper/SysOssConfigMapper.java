package com.ruoyi.system.mapper;

import com.ruoyi.common.core.mapper.BaseMapperPlus;
import com.ruoyi.system.domain.SysOssConfig;
import com.ruoyi.system.domain.vo.SysOssConfigVo;
import org.apache.ibatis.annotations.Param;

/**
 * 对象存储配置Mapper接口
 *
 * @author Lion Li
 * @author 孤舟烟雨
 * @date 2021-08-13
 */
public interface SysOssConfigMapper extends BaseMapperPlus<SysOssConfigMapper, SysOssConfig, SysOssConfigVo> {
        int updateEndPoint(@Param("oldEndPoint")String oldEndPoint, @Param("newEndPoint")String newEndPoint);
}
