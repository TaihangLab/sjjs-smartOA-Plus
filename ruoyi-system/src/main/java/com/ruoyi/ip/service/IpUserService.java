package com.ruoyi.ip.service;


import com.ruoyi.ip.domain.IpUser;
import com.ruoyi.ip.domain.vo.IpUserVO;

import java.util.List;

/**
 * 知识产权成员
 *
 * @author bailingnan
 * @date 2024/1/2
 */
public interface IpUserService {
    /**
     * 通过userId新增知识产权成员
     *
     * @param ipId
     * @param userIdList
     */
    void insertIpUserList(Long ipId, List<Long> userIdList);

    /**
     * 新增知识产权成员
     *
     * @param ipUserList
     */
    void insertIpUserList(List<IpUser> ipUserList);

    /**
     * 删除某项知识产权成员
     *
     * @param ipId
     */
    void deleteIpUserByIpId(Long ipId);

    /**
     * 更新知识产权
     *
     * @param ipId
     * @param userIdList
     */
    void updateIpUserByIpId(Long ipId, List<Long> userIdList);

    /**
     * 通过ipId获取知识产权成员
     *
     * @param userId
     *
     * @return {@link List}<{@link IpUser}>
     */
    List<IpUser> getIpUserListByUserId(Long userId);

    /**
     * 通过知识产权ID获取成员
     *
     * @param ipId
     *
     * @return {@link List}<{@link IpUserVO}>
     */
    List<IpUserVO> getIpUserVOListByIpId(Long ipId);

    /**
     * 获取用户路径
     *
     * @param ipId
     *
     * @return {@link List}<{@link List}<{@link Long}>>
     */
    List<List<Long>> getUserPathListByIpId(Long ipId);

    /**
     * 批量删除知识产权成员
     *
     * @param userIdList
     */
    void deleteIpUserByUserIdList(List<Long> userIdList);

}
