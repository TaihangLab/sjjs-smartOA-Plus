package com.ruoyi.web.controller.project;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.project.domain.ProjectMilestone;
import com.ruoyi.project.domain.bo.ProjectMilestoneBo;
import com.ruoyi.project.service.ProjectMilestoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/project/my")
public class ProjectMyController extends BaseController {

    private final ProjectMilestoneService projectMilestoneService;

    //@SaCheckPermission("project:my:targetadd")
    @Log(title = "新增项目大事纪", businessType = BusinessType.INSERT)
    @PostMapping(value = "/targetadd")
    public R<Void> add(@Validated @RequestBody ProjectMilestoneBo projectMilestoneBo) {
        return toAjax(projectMilestoneService.insertProjectMilestone(projectMilestoneBo));
    }

    //@SaCheckPermission("project:my:targetdelete")
    @Log(title = "删除单条项目大事纪", businessType = BusinessType.DELETE)
    @DeleteMapping (value = "/targetdelete")
    public R<Void> delete(@Validated @RequestBody Long milestoneId) {
        return toAjax(projectMilestoneService.deleteProjectMilestone(milestoneId));
    }

    //@SaCheckPermission("project:my:targetdeletebypro")
    @Log(title = "删除某个项目对应的大事纪", businessType = BusinessType.DELETE)
    @DeleteMapping (value = "/targetdeletebypro")
    public R<Void> deleteByPro(@Validated @RequestBody Long projectId) {
        return toAjax(projectMilestoneService.deleteMilestoneByProjectId(projectId));
    }

//    @SaCheckPermission("project:my:targetedit")
    @Log(title = "修改项目大事纪", businessType = BusinessType.UPDATE)
    @PutMapping("/targetedit")
    public R<Void> edit(@Validated @RequestBody ProjectMilestoneBo projectMilestoneBo) {
        return toAjax(projectMilestoneService.updateMilestone(projectMilestoneBo));
    }

}
