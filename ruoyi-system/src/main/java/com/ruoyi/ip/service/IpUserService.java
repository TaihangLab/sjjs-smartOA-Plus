package com.ruoyi.ip.service;

import com.ruoyi.ip.domin.IpUser;
import com.ruoyi.ip.domin.vo.IpUserVO;

import java.util.List;

/**
 * @author bailingnan
 * @date 2024/1/2
 */
public interface IpUserService {
    void insertIpUserList(Long ipId, List<Long> userIdList);

    void deleteIpUserByIpId(Long ipId);

    void updateIpUserByIpId(Long ipId, List<Long> userIdList);

    List<IpUser> getIpUserListByUserId(Long userId);

    List<IpUserVO> getIpUserVOListByIpId(Long ipId);
}
