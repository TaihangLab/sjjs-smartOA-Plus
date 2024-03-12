package com.ruoyi.web.controller.project;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.bo.ProjectInfoBO;
import com.ruoyi.project.domain.bo.ProjectMilestoneBo;
import com.ruoyi.project.domain.vo.ProjectBaseInfoVO;
import com.ruoyi.project.service.ProjectBaseInfoService;
import com.ruoyi.project.service.ProjectMilestoneService;
import com.ruoyi.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


/**
 * 我的项目
 *
 * @author bailingnan
 * @date 2024/02/06
 */
@Slf4j
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
    @SaCheckPermission("project:my:getMyList")
    @PostMapping("/getMyList")
    public TableDataInfo<ProjectBaseInfoVO> getMyProjectList(@RequestBody @Validated(QueryGroup.class) ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery) {
        return projectBaseInfoService.queryPageMyList(projectBaseInfoBO, pageQuery);
    }


    /**
     * 添加项目
     *
     * @param projectInfoBO 项目信息
     * @return 结果
     */
    @Log(title = "新增项目信息", businessType = BusinessType.INSERT)
    @SaCheckPermission("project:my:add")
    @PostMapping("/add")
    public R<Void> addProject(@RequestBody @Validated(AddGroup.class) ProjectInfoBO projectInfoBO) {
        projectService.addProject(projectInfoBO);
        return R.ok();
    }

    /**
     * 修改项目
     *
     * @param projectInfoBO 项目信息
     * @return 编辑结果
     */
    @Log(title = "编辑项目信息", businessType = BusinessType.UPDATE)
    @SaCheckPermission("project:my:edit")
    @PostMapping("/edit")
    public R<Void> editProject(@RequestBody @Validated(EditGroup.class) ProjectInfoBO projectInfoBO) {
        projectService.updateProject(projectInfoBO);
        return R.ok();
    }

    /**
     * 删除项目
     *
     * @param projectId 项目ID
     * @return 删除结果
     */
    @Log(title = "删除项目信息", businessType = BusinessType.DELETE)
    @SaCheckPermission("project:my:delete")
    @GetMapping("/delete")
    public R<Void> deleteProject(@RequestParam @NotNull Long projectId) {
        projectService.deleteProject(projectId);
        return R.ok();
    }


    /**
     * 新增项目大事纪
     *
     * @param projectMilestoneBo
     * @return {@link R}<{@link Void}>
     */
    @Log(title = "新增项目大事纪", businessType = BusinessType.INSERT)
    @SaCheckPermission("project:my:milestoneadd")
    @PostMapping(value = "/milestoneadd")
    public R<Void> add(@Validated @RequestBody ProjectMilestoneBo projectMilestoneBo) {
        return toAjax(projectMilestoneService.insertProjectMilestone(projectMilestoneBo));
    }

    /**
     * 删除项目大事纪
     *
     * @param milestoneId
     * @return {@link R}<{@link Void}>
     */
    @Log(title = "删除单条项目大事纪", businessType = BusinessType.DELETE)
    @SaCheckPermission("project:my:milestonedelete")
    @DeleteMapping(value = "/milestonedelete")
    public R<Void> delete(@Validated @RequestParam Long milestoneId) {
        return toAjax(projectMilestoneService.deleteProjectMilestone(milestoneId));
    }

    /**
     * 删除某个项目对应的大事纪
     *
     * @param projectId
     * @return {@link R}<{@link Void}>
     */
    @Log(title = "删除某个项目对应的大事纪", businessType = BusinessType.DELETE)
    @SaCheckPermission("project:my:milestonedeletebypro")
    @DeleteMapping(value = "/milestonedeletebypro")
    public R<Void> deleteByPro(@Validated @RequestParam Long projectId) {
        return toAjax(projectMilestoneService.deleteMilestoneByProjectId(projectId));
    }

    /**
     * 修改大事纪
     *
     * @param projectMilestoneBo
     * @return {@link R}<{@link Void}>
     */
    @Log(title = "修改项目大事纪", businessType = BusinessType.UPDATE)
    @SaCheckPermission("project:my:milestoneedit")
    @PutMapping("/milestoneedit")
    public R<Void> edit(@Validated @RequestBody ProjectMilestoneBo projectMilestoneBo) {
        return toAjax(projectMilestoneService.updateMilestone(projectMilestoneBo));
    }

}
