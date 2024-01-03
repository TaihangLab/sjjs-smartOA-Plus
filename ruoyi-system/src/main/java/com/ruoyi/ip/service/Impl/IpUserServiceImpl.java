package com.ruoyi.ip.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.ip.domin.IpUser;
import com.ruoyi.ip.service.IpUserService;
import com.ruoyi.project.mapper.IpUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bailingnan
 * @date 2024/1/2
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class IpUserServiceImpl implements IpUserService {
    private final IpUserMapper ipUserMapper;

    /**
     * @param ipId
     * @param userIdList
     */
    @Override
    public void insertIpUserList(Long ipId, List<Long> userIdList) {
        if (ipId == null) {
            throw new IllegalArgumentException("ipId can not be null");
        }
        if (userIdList == null || userIdList.isEmpty()) {
            return;
        }
        List<IpUser> ipUserList = userIdList.stream().map(userId -> {
            IpUser ipUser = new IpUser();
            ipUser.setIpId(ipId);
            ipUser.setUserId(userId);
            return ipUser;
        }).collect(java.util.stream.Collectors.toList());
        ipUserMapper.insertBatch(ipUserList);
    }

    /**
     * @param ipId
     */
    @Override
    public void deleteIpUserByIpId(Long ipId) {
        ipUserMapper.delete(new LambdaQueryWrapper<IpUser>().eq(IpUser::getIpId, ipId));
    }
}
