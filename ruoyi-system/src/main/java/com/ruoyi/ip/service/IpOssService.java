package com.ruoyi.ip.service;

import com.ruoyi.ip.domain.IpOss;
import com.ruoyi.system.domain.vo.SysOssVo;

import java.util.List;

/**
 * 知识产权附件
 *
 * @author bailingnan
 * @date 2024/1/2
 */
public interface IpOssService {
    /**
     * 通过ossId新增知识产权附件
     *
     * @param ipId
     * @param ossIdList
     */
    void insertIpOssList(Long ipId, List<Long> ossIdList);

    /**
     * 新增知识产权附件
     *
     * @param ipOssList
     */
    void insertIpOssList(List<IpOss> ipOssList);

    /**
     * 删除知识产权
     *
     * @param ipId
     */
    void deleteIpOssByIpId(Long ipId);

    /**
     * 更新知识产权
     *
     * @param ipId
     * @param ossIdList
     */
    void updateIpOssByIpId(Long ipId, List<Long> ossIdList);

    /**
     * 通过ipId获取知识产权附件
     *
     * @param ipId
     *
     * @return {@link List}<{@link SysOssVo}>
     */
    List<SysOssVo> getSysOssVoListByIpId(Long ipId);

    /**
     * 删除知识产权附件
     *
     * @param ossIdList
     */
    void deleteIpOssByOssIdList(List<Long> ossIdList);
}
