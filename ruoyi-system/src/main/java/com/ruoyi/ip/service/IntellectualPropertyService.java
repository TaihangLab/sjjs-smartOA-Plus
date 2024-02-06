package com.ruoyi.ip.service;

import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.ip.domain.bo.IntellectualPropertyBO;
import com.ruoyi.ip.domain.vo.IntellectualPropertyDetailVO;
import com.ruoyi.ip.domain.vo.IntellectualPropertyVO;

import java.util.Map;

/**
 * 知识产权
 *
 * @author bailingnan
 * @date 2023/12/29
 */
public interface IntellectualPropertyService {
    /**
     * 新增知识产权
     *
     * @param intellectualPropertyBO
     */
    void insertIntellectualProperty(IntellectualPropertyBO intellectualPropertyBO);

    /**
     * 删除知识产权
     *
     * @param ipId
     */
    void deleteIntellectualProperty(Long ipId);

    /**
     * 更新知识产权
     *
     * @param intellectualPropertyBO
     */
    void updateIntellectualProperty(IntellectualPropertyBO intellectualPropertyBO);

    /**
     * 获取知识产权详情
     *
     * @param ipId
     *
     * @return {@link IntellectualPropertyDetailVO}
     */
    IntellectualPropertyDetailVO getIntellectualPropertyDetail(Long ipId);

    /**
     * 获取知识产权列表
     *
     * @param intellectualPropertyBO
     * @param pageQuery
     *
     * @return {@link TableDataInfo}<{@link IntellectualPropertyVO}>
     */
    TableDataInfo<IntellectualPropertyVO> queryIntellectualPropertVOList(IntellectualPropertyBO intellectualPropertyBO, PageQuery pageQuery);

    /**
     * 获取知识产权统计数据
     *
     * @return {@link Map}<{@link String}, {@link Integer}>
     */
    Map<String, Integer> getIpTypeStatistics();
}
