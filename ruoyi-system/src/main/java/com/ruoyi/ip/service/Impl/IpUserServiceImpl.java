package com.ruoyi.ip.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.service.DeptService;
import com.ruoyi.common.core.service.UserService;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.ip.domain.IpUser;
import com.ruoyi.ip.domain.vo.IpUserVO;
import com.ruoyi.ip.mapper.IpUserMapper;
import com.ruoyi.ip.service.IpUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
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
     * @param ipUserList
     */
    @Override
    public void insertIpUserList(List<IpUser> ipUserList) {
        if (ipUserList == null || ipUserList.isEmpty()) {
            return;
        }
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
        List<IpUser> oldIpUserList = ipUserMapper.selectList(new LambdaQueryWrapper<IpUser>().eq(IpUser::getIpId, ipId)).stream().collect(Collectors.toList());
        if (userIdList == null || userIdList.isEmpty()) {
            if (oldIpUserList.isEmpty()) {
                return;
            } else {
                deleteIpUserByIpId(ipId);
                return;
            }
        } else {
            if (oldIpUserList.isEmpty()) {
                insertIpUserList(ipId, userIdList);
                return;
            }
        }
        List<IpUser> ipUserList = userIdList.stream().map(userId -> {
            IpUser ipUser = new IpUser();
            ipUser.setIpId(ipId);
            ipUser.setUserId(userId);
            return ipUser;
        }).collect(Collectors.toList());
        Set<IpUser> oldIpUserSet = new HashSet<>(oldIpUserList);
        Set<IpUser> ipUserSet = new HashSet<>(ipUserList);
        List<IpUser> addIpUserList = ipUserList.stream().filter(ipUser -> !oldIpUserSet.contains(ipUser)).collect(Collectors.toList());
        List<IpUser> delIpUserList = oldIpUserList.stream().filter(ipUser -> !ipUserSet.contains(ipUser)).collect(Collectors.toList());
        if (!addIpUserList.isEmpty()) {
            insertIpUserList(addIpUserList);
        }
        if (!delIpUserList.isEmpty()) {
            deleteIpUserByUserIdList(delIpUserList.stream().map(IpUser::getUserId).collect(Collectors.toList()));
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
        //获取知识产权相关有效成员集合
        List<SysUser> sysUserList = getActiveUserIdList(ipId);
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

    /**
     * @param ipId
     * @return
     */
    @Override
    public List<List<Long>> getUserPathListByIpId(Long ipId) {
        if(ipId==null){
            throw new IllegalArgumentException("ipId can not be null");
        }
        List<SysUser> sysUserList = getActiveUserIdList(ipId);
        if (sysUserList.isEmpty()) {
            return Collections.emptyList();
        }
        return sysUserList.stream().map(this::getUserPathListByUser).collect(Collectors.toList());
    }


    /**
     * @param userIdList
     */
    @Override
    public void deleteIpUserByUserIdList(List<Long> userIdList) {
        ipUserMapper.delete(new LambdaQueryWrapper<IpUser>().in(IpUser::getUserId, userIdList));
    }

    private List<SysUser> getActiveUserIdList(Long ipId){
        List<Long> userIdList = ipUserMapper.selectList(new LambdaQueryWrapper<IpUser>().eq(IpUser::getIpId, ipId)).stream().map(IpUser::getUserId).collect(Collectors.toList());
        if (userIdList.isEmpty()) {
            return Collections.emptyList();
        }
        //获取知识产权相关有效成员集合
        return userService.filterActiveUserIdList(userIdList);
    }

    private List<Long> getUserPathListByUser(SysUser user) {
        List<Long> userPathList = deptService.getAncestorsById(user.getDeptId());
        userPathList.add(user.getDeptId());
        userPathList.add(user.getUserId());
        return userPathList;
    }

}
