package com.ruoyi.web.controller.project;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.project.domain.ProjectMilestone;
import com.ruoyi.project.domain.ProjectTarget;
import com.ruoyi.project.domain.vo.ProjectMilestoneVo;
import com.ruoyi.project.service.ProjectMilestoneService;
import com.ruoyi.project.service.ProjectTargetService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/project/list")
public class ProjectListController extends BaseController {

    private final ProjectTargetService projectTargetService;

    private final ProjectMilestoneService projectMilestoneService;

    /**
     * 根据项目id新增项目指标
     */
//    @SaCheckPermission("project:list:addtargetlist")
    @Log(title = "新增项目指标列表",businessType = BusinessType.INSERT)
    @PostMapping("/targetadd")
    public R<Void> addTargetList(@RequestBody List<ProjectTarget> projectTargets){
        return toAjax(projectTargetService.insertProjectTargetList(projectTargets));
    }

    /**
     * 根据项目id删除项目指标
     */
//    @SaCheckPermission("project:list:deletetargetlist")
    @Log(title = "删除项目指标列表",businessType = BusinessType.DELETE)
    @DeleteMapping("/targetdelete")
    public R<Void> deleteTargetList(@RequestParam Long projectId){
        return toAjax(projectTargetService.deleteTargetByProjectId(projectId));
    }

    /**
     * 根据项目id查询项目大事纪
     */
    //@SaCheckPermission("project:list:queryMilestone")
    @GetMapping("/milestonelist")
    public R<List<ProjectMilestoneVo>> getMilestone(@RequestParam Long projectId){
        return R.ok(projectMilestoneService.selectMilestoneInfoByProjectId(projectId));
    }

}
