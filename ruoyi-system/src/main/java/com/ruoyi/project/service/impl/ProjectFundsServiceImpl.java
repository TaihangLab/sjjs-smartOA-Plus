package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.project.domain.ProjectFunds;
import com.ruoyi.project.domain.bo.ProjectFundsBO;
import com.ruoyi.project.domain.vo.ProjectFundsVO;
import com.ruoyi.project.mapper.ProjectFundsMapper;
import com.ruoyi.project.service.ProjectFundsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 项目经费
 *
 * @author bailingnan
 * @date 2023/12/7
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectFundsServiceImpl implements ProjectFundsService {

    private final ProjectFundsMapper projectFundsMapper;




    /**
     * 根据项目ID查询所有经费
     *
     * @param projectId
     * @return
     */
    @Override
    public ProjectFundsVO selectProjectFundsVOById(Long projectId) {
        return projectFundsMapper.selectVoOne(new LambdaQueryWrapper<ProjectFunds>().eq(ProjectFunds::getProjectId, projectId));
    }

    /**
     * 新增项目经费
     *
     * @param
     * @return
     */
    @Override
    public void insertProjectFunds(ProjectFundsBO projectFundsBO, Long projectId) {
        if (projectFundsBO == null) {
            return;
        }
        ProjectFunds projectFunds = new ProjectFunds();
        BeanCopyUtils.copy(projectFundsBO, projectFunds);
        projectFunds.setProjectId(projectId);
        if (projectFundsMapper.insert(projectFunds) != 1) {
            throw new RuntimeException("新增项目经费失败");
        }
    }


    /**
     * @param projectId
     */
    @Override
    public void deleteProjectFundsById(Long projectId) {
	    projectFundsMapper.delete(new LambdaQueryWrapper<ProjectFunds>().eq(ProjectFunds::getProjectId, projectId));
    }

    /**
     * @param projectFundsBO
     * @param projectId
     */
    @Override
    public void updateProjectFunds(ProjectFundsBO projectFundsBO, Long projectId) {
        if (projectFundsBO == null) {
	        deleteProjectFundsById(projectId);
            return;
        }
        ProjectFunds projectFunds = new ProjectFunds();
        BeanCopyUtils.copy(projectFundsBO, projectFunds);
	    saveOrUpdateProjectFunds(projectFunds, projectId);
    }

    /**
     * 根据项目id获取项目经费信息Map
     *
     * @param projectIdList
     *
     * @return {@link Map}<{@link Long}, {@link ProjectFunds}>
     */
    @Override
    public Map<Long, ProjectFunds> getProjectFundsMapByProjectIdList(List<Long> projectIdList) {
        return projectFundsMapper.selectList(new LambdaQueryWrapper<ProjectFunds>().in(ProjectFunds::getProjectId, projectIdList))
            .stream().collect(Collectors.toMap(ProjectFunds::getProjectId, projectFunds -> projectFunds));
    }


    private void saveOrUpdateProjectFunds(ProjectFunds projectFunds, Long projectId) {
        // 更新或插入操作
        boolean isUpdated = projectFundsMapper.update(projectFunds, new LambdaUpdateWrapper<ProjectFunds>().eq(ProjectFunds::getProjectId, projectId)) > 0;
        if (!isUpdated) {
	        projectFundsMapper.insert(projectFunds);
        }
    }
}
