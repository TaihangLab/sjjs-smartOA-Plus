package com.ruoyi.project.service.impl;

import com.ruoyi.project.mapper.ProjectBalanceMapper;
import com.ruoyi.project.service.ProjectBalanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
