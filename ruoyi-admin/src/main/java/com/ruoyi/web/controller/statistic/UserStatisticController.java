package com.ruoyi.web.controller.statistic;

import com.ruoyi.system.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 人员统计数据图表 控制层
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/statistic/user")
public class UserStatisticController {

    private final ISysUserService iSysUserService;

    /**
     * 人员职称及对应数量
     *
     * @return
     */
    @GetMapping("/jobtitle")
    public Map<String, Integer> getUserJobTitleStatistics(){
        return iSysUserService.getUserJobTitleStatistics();
    }

    /**
     * 人员学历及对应数量
     *
     * @return
     */
    @GetMapping("/diploma")
    public Map<String, Integer> getUserDiplomaStatistics(){
        return iSysUserService.getUserDiplomaStatistics();
    }

}
