package com.ruoyi.ip.service;

import com.ruoyi.system.domain.vo.SysOssVo;

import java.util.List;

/**
 * @author bailingnan
 * @date 2024/1/2
 */
public interface IpOssService {
    void insertIpOssList(Long ipId, List<Long> ossIdList);

    void deleteIpOssByIpId(Long ipId);

    void updateIpOssByIpId(Long ipId, List<Long> ossIdList);

    List<SysOssVo> getSysOssVoListByIpId(Long ipId);
}
