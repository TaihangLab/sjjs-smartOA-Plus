package com.ruoyi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ruoyi.project.domain.ProjectBalance;
import com.ruoyi.project.mapper.ProjectBalanceMapper;
import com.ruoyi.project.service.ProjectBalanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 项目余额Service
 *
 * @author bailingnan
 * @date 2024/03/01
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectBalanceServiceImpl implements ProjectBalanceService {
    private final ProjectBalanceMapper projectBalanceMapper;

    @Override
    public Map<Long, ProjectBalance> getProjectBalanceMapByPorjectIdList(List<Long> projectIdList) {
        return projectBalanceMapper.selectList(
                new LambdaQueryWrapper<ProjectBalance>().in(ProjectBalance::getProjectId, projectIdList)).stream()
            .collect(Collectors.toMap(ProjectBalance::getProjectId, projectBalance -> projectBalance));
    }
}
