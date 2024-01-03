package com.ruoyi.ip.service;

import java.util.List;

/**
 * @author bailingnan
 * @date 2024/1/2
 */
public interface IpOssService {
    void addIpOssList(Long ipId, List<Long> ossIdList);
}
