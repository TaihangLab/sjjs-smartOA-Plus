package com.ruoyi.ip.service.Impl;

import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.ip.domin.IntellectualProperty;
import com.ruoyi.ip.domin.bo.IntellectualPropertyBO;
import com.ruoyi.ip.service.IntellectualPropertyService;
import com.ruoyi.ip.service.IpOssService;
import com.ruoyi.ip.service.IpUserService;
import com.ruoyi.project.mapper.IntellectualPropertyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bailingnan
 * @date 2024/1/2
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class IntellectualPropertyServiceImpl implements IntellectualPropertyService {
    private final IntellectualPropertyMapper intellectualPropertyMapper;
    private final IpOssService ipOssService;
    private final IpUserService ipUserService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addIntellectualProperty(IntellectualPropertyBO intellectualPropertyBO) {
        if (intellectualPropertyBO == null) {
            throw new IllegalArgumentException("intellectualPropertyBO can not be null");
        }
        IntellectualProperty intellectualProperty = new IntellectualProperty();
        BeanCopyUtils.copy(intellectualPropertyBO, intellectualProperty);
        int cnt = intellectualPropertyMapper.insert(intellectualProperty);
        if (cnt != 1) {
            log.error("新增知识产权失败 intellectualPropertyBO:{}", intellectualPropertyBO);
            throw new RuntimeException("新增知识产权失败");
        }
        Long ipId = intellectualProperty.getIpId();
        if (ipId == null) {
            throw new IllegalStateException("获取知识产权Id失败");
        }
        ipOssService.addIpOssList(ipId, intellectualPropertyBO.getOssIdList());
        ipUserService.addIpUserList(ipId, intellectualPropertyBO.getUserIdList());
    }
}
