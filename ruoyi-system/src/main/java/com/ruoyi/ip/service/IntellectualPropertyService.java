package com.ruoyi.ip.service;

import com.ruoyi.ip.domin.bo.IntellectualPropertyBO;

/**
 * @author bailingnan
 * @date 2023/12/29
 */
public interface IntellectualPropertyService {
    void insertIntellectualProperty(IntellectualPropertyBO intellectualPropertyBO);

    void deleteIntellectualProperty(Long ipId);

    void updateIntellectualProperty(IntellectualPropertyBO intellectualPropertyBO);

}
