package com.ruoyi.ip.service.Impl;

import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.ip.domin.IntellectualProperty;
import com.ruoyi.ip.domin.bo.IntellectualPropertyBO;
import com.ruoyi.ip.domin.vo.IntellectualPropertyDetailVO;
import com.ruoyi.ip.service.IntellectualPropertyService;
import com.ruoyi.ip.service.IpOssService;
import com.ruoyi.ip.service.IpUserService;
import com.ruoyi.project.mapper.IntellectualPropertyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

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
    public void insertIntellectualProperty(IntellectualPropertyBO intellectualPropertyBO) {
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
        ipOssService.insertIpOssList(ipId, intellectualPropertyBO.getOssIdList());
        ipUserService.insertIpUserList(ipId, intellectualPropertyBO.getUserIdList());
    }

    /**
     * @param ipId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteIntellectualProperty(Long ipId) {
        int cnt = intellectualPropertyMapper.deleteById(ipId);
        if (cnt != 1) {
            log.error("删除知识产权失败 ipId:{}", ipId);
            throw new NoSuchElementException("删除知识产权失败,ipId为:" + ipId);
        }
        ipUserService.deleteIpUserByIpId(ipId);
        ipOssService.deleteIpOssByIpId(ipId);
    }

    /**
     * @param intellectualPropertyBO
     */
    @Override
    public void updateIntellectualProperty(IntellectualPropertyBO intellectualPropertyBO) {
        if (intellectualPropertyBO == null) {
            throw new IllegalArgumentException("intellectualPropertyBO can not be null");
        }
        IntellectualProperty intellectualProperty = new IntellectualProperty();
        BeanCopyUtils.copy(intellectualPropertyBO, intellectualProperty);
        int cnt = intellectualPropertyMapper.updateById(intellectualProperty);
        if (cnt != 1) {
            log.error("更新知识产权失败 intellectualPropertyBO:{}", intellectualPropertyBO);
            throw new RuntimeException("更新知识产权失败");
        }
        Long ipId = intellectualProperty.getIpId();
        ipUserService.updateIpUserByIpId(ipId, intellectualPropertyBO.getUserIdList());
        ipOssService.updateIpOssByIpId(ipId, intellectualPropertyBO.getOssIdList());
    }

    /**
     * @param ipId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public IntellectualPropertyDetailVO getIntellectualPropertyDetail(Long ipId) {
        IntellectualPropertyDetailVO intellectualPropertyDetailVO = new IntellectualPropertyDetailVO();
        IntellectualProperty intellectualProperty = intellectualPropertyMapper.selectById(ipId);
        if (intellectualProperty == null) {
            throw new NoSuchElementException("ipId为:" + ipId + "的知识产权不存在");
        }
        BeanCopyUtils.copy(intellectualProperty, intellectualPropertyDetailVO);
        intellectualPropertyDetailVO.setSysOssVoList(ipOssService.getSysOssVoListByIpId(ipId));
        intellectualPropertyDetailVO.setIpUserVOList(ipUserService.getIpUserVOListByIpId(ipId));
        return intellectualPropertyDetailVO;
    }
}
