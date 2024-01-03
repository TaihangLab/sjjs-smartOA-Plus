package com.ruoyi.ip.service.Impl;

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
    public void addIpOssList(Long ipId, List<Long> ossIdList) {
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
}
