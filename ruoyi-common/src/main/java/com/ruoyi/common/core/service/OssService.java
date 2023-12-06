package com.ruoyi.common.core.service;

import org.springframework.stereotype.Service;

/**
 * 通用 OSS服务
 *
 * @author Lion Li
 */
public interface OssService {

    /**
     * 通过ossId查询对应的url
     *
     * @param ossIds ossId串逗号分隔
     * @return url串逗号分隔
     */
    String selectUrlByIds(String ossIds);

    void updateIP(String oldEndPoint, String newEndPoint);

}
