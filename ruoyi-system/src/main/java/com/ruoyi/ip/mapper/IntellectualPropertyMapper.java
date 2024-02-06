package com.ruoyi.ip.mapper;

import com.ruoyi.common.core.mapper.BaseMapperPlus;
import com.ruoyi.ip.domain.IntellectualProperty;
import com.ruoyi.ip.domain.vo.IntellectualPropertyVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 针对表【intellectual_property(知识产权表)】的数据库操作Mapper
 *
 * @author bailingnan
 * @createDate 2023-12-29 17:30:26
 * @Entity com.ruoyi.ip.domin.IntellectualProperty
 * @date 2024/02/06
 */
@Mapper
public interface IntellectualPropertyMapper extends BaseMapperPlus<IntellectualPropertyMapper, IntellectualProperty, IntellectualPropertyVO> {

}




