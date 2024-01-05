package com.ruoyi.ip.service;

import com.ruoyi.ip.domain.IpOss;
import com.ruoyi.system.domain.vo.SysOssVo;

import java.util.List;

/**
 * @author bailingnan
 * @date 2024/1/2
 */
public interface IpOssService {
    void insertIpOssList(Long ipId, List<Long> ossIdList);

    void insertIpOssList(List<IpOss> ipOssList);

    void deleteIpOssByIpId(Long ipId);

    void updateIpOssByIpId(Long ipId, List<Long> ossIdList);

    List<SysOssVo> getSysOssVoListByIpId(Long ipId);

    void deleteIpOssByOssIdList(List<Long> ossIdList);
}
