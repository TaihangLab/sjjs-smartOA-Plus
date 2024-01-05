package com.ruoyi.ip.service;

import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.ip.domain.bo.IntellectualPropertyBO;
import com.ruoyi.ip.domain.vo.IntellectualPropertyDetailVO;
import com.ruoyi.ip.domain.vo.IntellectualPropertyVO;

/**
 * @author bailingnan
 * @date 2023/12/29
 */
public interface IntellectualPropertyService {
    void insertIntellectualProperty(IntellectualPropertyBO intellectualPropertyBO);

    void deleteIntellectualProperty(Long ipId);

    void updateIntellectualProperty(IntellectualPropertyBO intellectualPropertyBO);

    IntellectualPropertyDetailVO getIntellectualPropertyDetail(Long ipId);

    TableDataInfo<IntellectualPropertyVO> queryIntellectualPropertVOList(IntellectualPropertyBO intellectualPropertyBO, PageQuery pageQuery);
}
