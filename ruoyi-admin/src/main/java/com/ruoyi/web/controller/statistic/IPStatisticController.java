package com.ruoyi.web.controller.statistic;

import com.ruoyi.ip.service.IntellectualPropertyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 知识产权统计图表
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/statistic/ip")
public class IPStatisticController {
    private final IntellectualPropertyService intellectualPropertyService;
    /**
     * 知识产权类型及对应数量
     * @return
     */
    //@SaCheckPermission("statistic:ip:type")
    @GetMapping("/type")
    public Map<String, Integer> getIpTypeStatistics() {
        return intellectualPropertyService.getIpTypeStatistics();
    }
}
