package com.ruoyi.ip.service;


import com.ruoyi.ip.domain.IpUser;
import com.ruoyi.ip.domain.vo.IpUserVO;

import java.util.List;

/**
 * @author bailingnan
 * @date 2024/1/2
 */
public interface IpUserService {
    void insertIpUserList(Long ipId, List<Long> userIdList);

    void insertIpUserList(List<IpUser> ipUserList);

    void deleteIpUserByIpId(Long ipId);

    void updateIpUserByIpId(Long ipId, List<Long> userIdList);

    List<IpUser> getIpUserListByUserId(Long userId);

    List<IpUserVO> getIpUserVOListByIpId(Long ipId);

    void deleteIpUserByUserIdList(List<Long> userIdList);
}
