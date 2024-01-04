package com.ruoyi.ip.mapper;

import com.ruoyi.common.core.mapper.BaseMapperPlus;
import com.ruoyi.ip.domin.IntellectualProperty;
import com.ruoyi.ip.domin.vo.IntellectualPropertyVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author bailingnan
 * @description 针对表【intellectual_property(知识产权表)】的数据库操作Mapper
 * @createDate 2023-12-29 17:30:26
 * @Entity com.ruoyi.ip.domin.IntellectualProperty
 */
@Mapper
public interface IntellectualPropertyMapper extends BaseMapperPlus<IntellectualPropertyMapper, IntellectualProperty, IntellectualPropertyVO> {

}




