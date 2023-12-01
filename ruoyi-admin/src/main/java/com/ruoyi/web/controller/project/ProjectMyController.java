package com.ruoyi.web.controller.project;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.project.domain.ProjectMilestone;
import com.ruoyi.project.service.ProjectMilestoneService;
import com.ruoyi.system.domain.SysNotice;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/project/my")
public class ProjectMyController extends BaseController {

    private final ProjectMilestoneService projectMilestoneService;

    //@SaCheckPermission("project:my:add")
    @Log(title = "项目大事纪", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@Validated @RequestBody ProjectMilestone projectMilestone) {
        return toAjax(projectMilestoneService.insertProjectMilestone(projectMilestone));
    }

}
