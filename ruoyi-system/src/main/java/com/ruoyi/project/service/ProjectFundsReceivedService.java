package com.ruoyi.project.service;

import com.ruoyi.project.domain.ProjectFundsReceived;
import com.ruoyi.project.domain.vo.ProjectFundsReceivedVo;

import java.util.List;

/**
 * @Author 范佳兴
 * @date 2024/2/29 11:06
 */
public interface ProjectFundsReceivedService {

    /**
     * 添加专项经费到账信息
     *
     * @param fundsReceived 专项经费到账对象
     * @return 添加成功返回 true，否则返回 false
     */
    int addFundsReceived(ProjectFundsReceived fundsReceived);

    /**
     * 更新专项经费到账信息
     *
     * @param fundsReceived 专项经费到账对象
     * @return 更新成功返回 true，否则返回 false
     */
    int updateFundsReceived(ProjectFundsReceived fundsReceived);

    /**
     * 根据ID删除专项经费到账信息
     *
     * @param receivedId 到账ID
     * @return 删除成功返回 true，否则返回 false
     */
    int deleteFundsReceivedById(Long receivedId);

    /**
     * 根据项目ID查询专项经费到账信息
     *
     * @param projectId 项目ID
     * @return 查询到的专项经费到账对象，若不存在则返回 null
     */
    List<ProjectFundsReceivedVo> getFundsReceivedByProId(Long projectId);

}

