package com.ruoyi.ip.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.ip.domain.IpOss;
import com.ruoyi.ip.mapper.IpOssMapper;
import com.ruoyi.ip.service.IpOssService;
import com.ruoyi.system.domain.vo.SysOssVo;
import com.ruoyi.system.service.ISysOssService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author bailingnan
 * @date 2024/1/2
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class IpOssServiceImpl implements IpOssService {
    private final IpOssMapper ipOssMapper;
    private final ISysOssService sysOssService;

    /**
     * @param ipId
     * @param ossIdList
     */
    @Override
    public void insertIpOssList(Long ipId, List<Long> ossIdList) {
        if (ipId == null) {
            throw new IllegalArgumentException("ipId can not be null");
        }
        if (ossIdList == null || ossIdList.isEmpty()) {
            return;
        }
        List<IpOss> ipOssList = ossIdList.stream().map(ossId -> {
            IpOss ipOss = new IpOss();
            ipOss.setIpId(ipId);
            ipOss.setOssId(ossId);
            return ipOss;
        }).collect(Collectors.toList());
        ipOssMapper.insertBatch(ipOssList);
    }

    /**
     * @param ipOssList
     */
    @Override
    public void insertIpOssList(List<IpOss> ipOssList) {
        if (ipOssList == null || ipOssList.isEmpty()) {
            return;
        }
        ipOssMapper.insertBatch(ipOssList);

    }

    /**
     * @param ipId
     */
    @Override
    public void deleteIpOssByIpId(Long ipId) {
        ipOssMapper.delete(new LambdaQueryWrapper<IpOss>().eq(IpOss::getIpId, ipId));
    }

    /**
     * @param ipId
     * @param ossIdList
     */
    @Override
    public void updateIpOssByIpId(Long ipId, List<Long> ossIdList) {
        if (ipId == null) {
            throw new IllegalArgumentException("ipId can not be null");
        }
        List<IpOss> oldIpOssList = ipOssMapper.selectList(new LambdaQueryWrapper<IpOss>().eq(IpOss::getIpId, ipId)).stream().collect(Collectors.toList());
        if (ossIdList == null || ossIdList.isEmpty()) {
            if (oldIpOssList.isEmpty()) {
                return;
            } else {
                deleteIpOssByIpId(ipId);
                return;
            }
        } else {
            if (oldIpOssList.isEmpty()) {
                insertIpOssList(ipId, ossIdList);
                return;
            }
        }
        List<IpOss> ipOssList = ossIdList.stream().map(ossId -> {
            IpOss ipOss = new IpOss();
            ipOss.setIpId(ipId);
            ipOss.setOssId(ossId);
            return ipOss;
        }).collect(Collectors.toList());
        //转换为 HashSet 提高查找效率
        Set<IpOss> oldIpOssSet = new HashSet<>(oldIpOssList);
        Set<IpOss> ipOssSet = new HashSet<>(ipOssList);
        // 使用 Stream API 计算差集
        List<IpOss> addIpOssList = ipOssList.stream().filter(ipOss -> !oldIpOssSet.contains(ipOss)).collect(Collectors.toList());
        List<Long> delIpOssList = oldIpOssList.stream().filter(ipOss -> !ipOssSet.contains(ipOss)).map(IpOss::getOssId).collect(Collectors.toList());
        if (!addIpOssList.isEmpty()) {
            insertIpOssList(addIpOssList);
        }
        if (!delIpOssList.isEmpty()) {
            deleteIpOssByOssIdList(delIpOssList);
        }
    }

    /**
     * @param ipId
     * @return
     */
    @Override
    public List<SysOssVo> getSysOssVoListByIpId(Long ipId) {
        List<Long> ossIds = ipOssMapper.selectList(new LambdaQueryWrapper<IpOss>().eq(IpOss::getIpId, ipId)).stream().map(IpOss::getOssId).collect(Collectors.toList());
        if (ossIds.isEmpty()) {
            return Collections.emptyList();
        }
        return sysOssService.listByIds(ossIds);
    }

    /**
     * @param ossIdList
     */
    @Override
    public void deleteIpOssByOssIdList(List<Long> ossIdList) {
        if (ossIdList == null || ossIdList.isEmpty()) {
            return;
        }
        ipOssMapper.delete(new LambdaQueryWrapper<IpOss>().in(IpOss::getOssId, ossIdList));

    }
}
