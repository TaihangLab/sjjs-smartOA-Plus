package com.ruoyi.ip.service;

import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.ip.domin.bo.IntellectualPropertyBO;
import com.ruoyi.ip.domin.vo.IntellectualPropertyDetailVO;
import com.ruoyi.ip.domin.vo.IntellectualPropertyVO;

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
