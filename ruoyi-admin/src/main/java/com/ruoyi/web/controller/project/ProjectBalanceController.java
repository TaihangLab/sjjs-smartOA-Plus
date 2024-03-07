package com.ruoyi.web.controller.project;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.project.domain.vo.ProjectBalanceVO;
import com.ruoyi.project.service.ProjectBalanceService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目余额
 *
 * @Author 范佳兴
 * @date 2024/3/6 10:06
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/project/balance")
public class ProjectBalanceController {

    private final ProjectBalanceService projectBalanceService;

    /**
     * 根据项目ID查询项目经费预算和支出明细及汇总
     *
     * @param projectId 项目ID
     * @return
     */
    @GetMapping(value = "/fundsAndBalance")
    public R<ProjectBalanceVO> getFundsAndBalanceByProjectId(@RequestParam @NonNull Long projectId){
        ProjectBalanceVO fundsAndBalance = projectBalanceService.getFundsAndBalanceByProjectId(projectId);
        return R.ok(fundsAndBalance);
    }
}
