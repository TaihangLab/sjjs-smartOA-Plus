package com.ruoyi.web.controller.project;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.bo.ProjectMilestoneBo;
import com.ruoyi.project.domain.vo.ProjectBaseInfoVO;
import com.ruoyi.project.service.ProjectBaseInfoService;
import com.ruoyi.project.service.ProjectMilestoneService;
import com.ruoyi.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/project/my")
public class ProjectMyController extends BaseController {

    private final ProjectMilestoneService projectMilestoneService;
    private final ProjectBaseInfoService projectBaseInfoService;
    private final ProjectService projectService;

    /**
     * 获取我的项目列表
     *
     * @param projectBaseInfoBO 项目基本信息
     * @param pageQuery         分页查询条件
     * @return 我的项目列表
     */
    //@SaCheckPermission("project:my:getMyList")
    @PostMapping("/getMyList")
    public TableDataInfo<ProjectBaseInfoVO> getMyProjectList(@RequestBody @Validated(QueryGroup.class) ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery) {
        return projectBaseInfoService.queryPageMyList(projectBaseInfoBO, pageQuery);
    }

    //@SaCheckPermission("project:my:milestoneadd")
    @Log(title = "新增项目大事纪", businessType = BusinessType.INSERT)
    @PostMapping(value = "/milestoneadd")
    public R<Void> add(@Validated @RequestBody ProjectMilestoneBo projectMilestoneBo) {
        return toAjax(projectMilestoneService.insertProjectMilestone(projectMilestoneBo));
    }

    //@SaCheckPermission("project:my:milestonedelete")
    @Log(title = "删除单条项目大事纪", businessType = BusinessType.DELETE)
    @DeleteMapping(value = "/milestonedelete")
    public R<Void> delete(@Validated @RequestParam Long milestoneId) {
        return toAjax(projectMilestoneService.deleteProjectMilestone(milestoneId));
    }

    //@SaCheckPermission("project:my:milestonedeletebypro")
    @Log(title = "删除某个项目对应的大事纪", businessType = BusinessType.DELETE)
    @DeleteMapping(value = "/milestonedeletebypro")
    public R<Void> deleteByPro(@Validated @RequestParam Long projectId) {
        return toAjax(projectMilestoneService.deleteMilestoneByProjectId(projectId));
    }

    //    @SaCheckPermission("project:my:milestoneedit")
    @Log(title = "修改项目大事纪", businessType = BusinessType.UPDATE)
    @PutMapping("/milestoneedit")
    public R<Void> edit(@Validated @RequestBody ProjectMilestoneBo projectMilestoneBo) {
        return toAjax(projectMilestoneService.updateMilestone(projectMilestoneBo));
    }

    /**
     * 删除项目
     *
     * @param projectId 项目ID
     * @return 删除结果
     */
    //@SaCheckPermission("project:list:projectDelete")
    @GetMapping("/delete")
    public R<Void> deleteProject(@RequestParam @NotNull Long projectId) {
        projectService.deleteProject(projectId);
        return R.ok();
    }
}
