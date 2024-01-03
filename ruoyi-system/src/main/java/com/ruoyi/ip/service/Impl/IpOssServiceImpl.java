package com.ruoyi.ip.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.ip.domin.IpOss;
import com.ruoyi.ip.service.IpOssService;
import com.ruoyi.project.mapper.IpOssMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
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
        List<Long> oldOssIdList = ipOssMapper.selectList(new LambdaQueryWrapper<IpOss>().eq(IpOss::getIpId, ipId)).stream().map(IpOss::getOssId).collect(Collectors.toList());
        if (ossIdList == null || ossIdList.isEmpty()) {
            if (oldOssIdList.isEmpty()) {
                return;
            } else {
                ipOssMapper.delete(new LambdaQueryWrapper<IpOss>().eq(IpOss::getIpId, ipId));
                return;
            }
        } else {
            if (oldOssIdList.isEmpty()) {
                ipOssMapper.insertBatch(ossIdList.stream().map(ossId -> {
                    IpOss ipOss = new IpOss();
                    ipOss.setIpId(ipId);
                    ipOss.setOssId(ossId);
                    return ipOss;
                }).collect(Collectors.toList()));
                return;
            }
        }
        List<Long> addOssIdList = ossIdList.stream().filter(ossId -> !oldOssIdList.contains(ossId)).collect(Collectors.toList());
        List<Long> delOssIdList = oldOssIdList.stream().filter(ossId -> !ossIdList.contains(ossId)).collect(Collectors.toList());
        if (!addOssIdList.isEmpty()) {
            ipOssMapper.insertBatch(addOssIdList.stream().map(ossId -> {
                IpOss ipOss = new IpOss();
                ipOss.setIpId(ipId);
                ipOss.setOssId(ossId);
                return ipOss;
            }).collect(Collectors.toList()));
        }
        if (!delOssIdList.isEmpty()) {
            ipOssMapper.delete(new LambdaQueryWrapper<IpOss>().eq(IpOss::getIpId, ipId).in(IpOss::getOssId, delOssIdList));
        }
    }
}
