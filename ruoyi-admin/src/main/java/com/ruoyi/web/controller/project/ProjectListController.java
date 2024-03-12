package com.ruoyi.web.controller.project;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.common.enums.ProjectmilestoneCategoryEnum;
import com.ruoyi.project.domain.ProjectMilestoneCategory;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.bo.ProjectMilestoneBo;
import com.ruoyi.project.domain.vo.ProjectBaseInfoVO;
import com.ruoyi.project.domain.vo.ProjectDetailsVO;
import com.ruoyi.project.domain.vo.ProjectMilestoneVo;
import com.ruoyi.project.service.ProjectBaseInfoService;
import com.ruoyi.project.service.ProjectMilestoneService;
import com.ruoyi.project.service.ProjectService;
import com.ruoyi.system.domain.SysPost;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;


/**
 * 项目管理
 * @author bailingnan
 * @date 2024/02/06
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/project/list")
public class ProjectListController extends BaseController {


    private final ProjectMilestoneService projectMilestoneService;

    private final ProjectService projectService;

    private final ProjectBaseInfoService projectBaseInfoService;


    /**
     * 获取所有项目列表
     *
     * @param projectBaseInfoBO 项目基本信息
     * @param pageQuery         分页查询条件
     *
     * @return 所有项目列表
     */
    //    @SaCheckPermission("project:list:getAllList")
    @PostMapping("/getAllList")
    public TableDataInfo<ProjectBaseInfoVO> getAllProjectList(@RequestBody@Validated(QueryGroup.class)ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery){
        return projectBaseInfoService.queryPageAllList(projectBaseInfoBO, pageQuery);
    }

    /**
     * 获取项目详情
     *
     * @param projectId 项目ID
     *
     * @return 返回项目详情对象
     */
    @SaCheckPermission("project:list:getDetails")
    @GetMapping("/getDetails")
    public R<ProjectDetailsVO> getProjectDetails(@RequestParam @NotNull Long projectId) {
        return R.ok(projectService.getProjectDetails(projectId));
    }

//    /**
//     * 根据项目id新增项目指标
//     *
//     * @param projectTargets the project targets
//     * @return the r
//     */
////    @SaCheckPermission("project:list:addtargetlist")
//    @Log(title = "新增项目指标列表",businessType = BusinessType.INSERT)
//    @PostMapping("/targetadd")
//    public R<Void> addTargetList(@RequestBody List<ProjectTarget> projectTargets){
//        return toAjax(projectTargetService.insertProjectTargetList(projectTargets));
//    }

//    /**
//     * 根据项目id删除项目指标
//     *
//     * @param projectId the project id
//     * @return the r
//     */
////    @SaCheckPermission("project:list:deletetargetlist")
//    @Log(title = "删除项目指标列表",businessType = BusinessType.DELETE)
//    @DeleteMapping("/targetdelete")
//    public R<Void> deleteTargetList(@RequestParam Long projectId){
//        return toAjax(projectTargetService.deleteTargetByProjectId(projectId));
//    }

    /**
     * 根据项目id查询项目大事纪
     *
     * @param projectMilestoneBo
     *
     * @return 结果
     */
    @SaCheckPermission("project:list:queryMilestone")
    @PostMapping("/milestonequery")
    public R<List<ProjectMilestoneVo>> queryMilestone(@RequestBody ProjectMilestoneBo projectMilestoneBo){
        return R.ok(projectMilestoneService.queryMilestoneList(projectMilestoneBo));
    }

    /**
     * 获取大事记分类选择框列表
     * */
    @GetMapping("/milestoneCategorySelect")
    public R<List<ProjectmilestoneCategoryEnum>> milestoneCategorySelect() {
        List<ProjectmilestoneCategoryEnum> projectmilestoneCategoryEnums = projectMilestoneService.selectCategoryAll();
        return R.ok(projectmilestoneCategoryEnums);
    }



}
