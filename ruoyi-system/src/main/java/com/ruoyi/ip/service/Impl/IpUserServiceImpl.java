package com.ruoyi.ip.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.service.DeptService;
import com.ruoyi.common.core.service.UserService;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.ip.domin.IpUser;
import com.ruoyi.ip.domin.vo.IpUserVO;
import com.ruoyi.ip.mapper.IpUserMapper;
import com.ruoyi.ip.service.IpUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author bailingnan
 * @date 2024/1/2
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class IpUserServiceImpl implements IpUserService {
    private final IpUserMapper ipUserMapper;
    private final UserService userService;
    private final DeptService deptService;

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

    /**
     * @param ipId
     * @param userIdList
     */
    @Override
    public void updateIpUserByIpId(Long ipId, List<Long> userIdList) {
        if (ipId == null) {
            throw new IllegalArgumentException("ipId can not be null");
        }
        List<Long> oldUserIdList = ipUserMapper.selectList(new LambdaQueryWrapper<IpUser>().eq(IpUser::getIpId, ipId)).stream().map(IpUser::getUserId).collect(Collectors.toList());
        if (userIdList == null || userIdList.isEmpty()) {
            if (oldUserIdList.isEmpty()) {
                return;
            } else {
                ipUserMapper.delete(new LambdaQueryWrapper<IpUser>().eq(IpUser::getIpId, ipId));
                return;
            }
        } else {
            if (oldUserIdList.isEmpty()) {
                ipUserMapper.insertBatch(userIdList.stream().map(userId -> {
                    IpUser ipUser = new IpUser();
                    ipUser.setIpId(ipId);
                    ipUser.setUserId(userId);
                    return ipUser;
                }).collect(Collectors.toList()));
                return;
            }
        }
        List<Long> addUserIdList = userIdList.stream().filter(userId -> !oldUserIdList.contains(userId)).collect(Collectors.toList());
        List<Long> delUserIdList = oldUserIdList.stream().filter(userId -> !userIdList.contains(userId)).collect(Collectors.toList());
        if (!addUserIdList.isEmpty()) {
            List<IpUser> ipUserList = addUserIdList.stream().map(userId -> {
                IpUser ipUser = new IpUser();
                ipUser.setIpId(ipId);
                ipUser.setUserId(userId);
                return ipUser;
            }).collect(Collectors.toList());
            ipUserMapper.insertBatch(ipUserList);
        }
        if (!delUserIdList.isEmpty()) {
            ipUserMapper.delete(new LambdaQueryWrapper<IpUser>().eq(IpUser::getIpId, ipId).in(IpUser::getUserId, delUserIdList));
        }
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public List<IpUser> getIpUserListByUserId(Long userId) {
        return ipUserMapper.selectList(new LambdaQueryWrapper<IpUser>().eq(IpUser::getUserId, userId));
    }

    /**
     * @param ipId
     * @return
     */
    @Override
    public List<IpUserVO> getIpUserVOListByIpId(Long ipId) {
        List<Long> userIdList = ipUserMapper.selectList(new LambdaQueryWrapper<IpUser>().eq(IpUser::getIpId, ipId)).stream().map(IpUser::getUserId).collect(Collectors.toList());
        if (userIdList.isEmpty()) {
            return Collections.emptyList();
        }
        //获取知识产权相关有效成员集合
        List<SysUser> sysUserList = userService.filterActiveUserIdList(userIdList);
        if (sysUserList.isEmpty()) {
            return Collections.emptyList();
        }
        //获取用户部门Id和部门名称映射
        Map<Long, String> deptIdNameMap = deptService.getDeptIdAndNameMapping(sysUserList.stream().map(SysUser::getDeptId).collect(Collectors.toList()));
        return sysUserList.stream().map(sysUser -> {
            IpUserVO ipUserVO = new IpUserVO();
            BeanCopyUtils.copy(sysUser, ipUserVO);
            ipUserVO.setDeptName(deptIdNameMap.get(sysUser.getDeptId()));
            return ipUserVO;
        }).collect(Collectors.toList());
    }

}
