package com.ruoyi.web.controller.project;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.project.domain.ProjectTarget;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.vo.ProjectBaseInfoVO;
import com.ruoyi.project.domain.vo.ProjectFundsVO;
import com.ruoyi.project.domain.vo.ProjectMilestoneVo;
import com.ruoyi.project.domain.vo.ProjectUserVo;
import com.ruoyi.project.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * The type Project list controller.
 *
 * @author bailingnan
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/project/list")
public class ProjectListController extends BaseController {

    private final ProjectTargetService projectTargetService;

    private final ProjectMilestoneService projectMilestoneService;

    private final ProjectUserService projectUserService;

    private final ProjectFundsService projectFundsService;

    private final ProjectService projectService;

    private final ProjectBaseInfoService projectBaseInfoService;

    /**
     * 获取所有项目列表
     *
     * @param projectBaseInfoBO 项目基本信息
     * @param pageQuery         分页查询条件
     * @return 所有项目列表
     */
    //@SaCheckPermission("project:list:getAllList")
    @PostMapping("/getAllList")
    public TableDataInfo<ProjectBaseInfoVO> getAllProjectList(@RequestBody@Validated(QueryGroup.class)ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery){
        return projectBaseInfoService.queryPageAllList(projectBaseInfoBO, pageQuery);
    }


    /**
     * 根据项目id新增项目指标
     *
     * @param projectTargets the project targets
     * @return the r
     */
//    @SaCheckPermission("project:list:addtargetlist")
    @Log(title = "新增项目指标列表",businessType = BusinessType.INSERT)
    @PostMapping("/targetadd")
    public R<Void> addTargetList(@RequestBody List<ProjectTarget> projectTargets){
        return toAjax(projectTargetService.insertProjectTargetList(projectTargets));
    }

    /**
     * 根据项目id删除项目指标
     *
     * @param projectId the project id
     * @return the r
     */
//    @SaCheckPermission("project:list:deletetargetlist")
    @Log(title = "删除项目指标列表",businessType = BusinessType.DELETE)
    @DeleteMapping("/targetdelete")
    public R<Void> deleteTargetList(@RequestParam Long projectId){
        return toAjax(projectTargetService.deleteTargetByProjectId(projectId));
    }

    /**
     * 根据项目id查询项目大事纪
     *
     * @param projectId the project id
     * @return the r
     */
//@SaCheckPermission("project:list:queryMilestone")
    @GetMapping("/milestonelist")
    public R<List<ProjectMilestoneVo>> getMilestone(@RequestParam Long projectId){
        return R.ok(projectMilestoneService.selectMilestoneInfoByProjectId(projectId));
    }

    /**
     * 根据项目id查询项目成员详细信息
     *
     * @param projectId the project id
     * @return the r
     */
    @GetMapping("/projectmembers")
    public R<List<ProjectUserVo>> getProjectMembers(@RequestParam Long projectId){
        return R.ok(projectUserService.getUserInfoByProjectId(projectId));
    }

    /**
     * 获取项目资金信息
     *
     * @param projectId 项目ID
     * @return 项目资金信息
     */
    //@SaCheckPermission("project:list:projectfundsSelect")
    @GetMapping("/projectfundsSelect")
    public R<ProjectFundsVO> getProjectFunds(@RequestParam @NotNull Long projectId) {
        return R.ok(projectFundsService.selectProjectFunds(projectId));
    }
}
