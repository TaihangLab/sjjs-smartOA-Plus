package com.ruoyi.project.service.impl;

import com.ruoyi.project.mapper.ProjectExpenditureMapper;
import com.ruoyi.project.service.ProjectExpenditureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 项目支出Service
 *
 * @author bailingnan
 * @date 2024/03/01
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectExpenditureServiceImpl implements ProjectExpenditureService{
    private final ProjectExpenditureMapper projectExpenditureMapper;
}
