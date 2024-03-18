package com.ruoyi.web.controller.project;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.common.enums.ProjectMilestoneCategoryEnum;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.bo.ProjectMilestoneBo;
import com.ruoyi.project.domain.vo.ProjectBaseInfoVO;
import com.ruoyi.project.domain.vo.ProjectDetailsVO;
import com.ruoyi.project.domain.vo.ProjectMilestoneVo;
import com.ruoyi.project.service.ProjectBaseInfoService;
import com.ruoyi.project.service.ProjectMilestoneService;
import com.ruoyi.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


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
     * 新增大事记时获取大事记分类选择框列表
     * */
    @GetMapping("/milestoneCategorySelect")
    public R<List<ProjectMilestoneCategoryEnum>> milestoneCategorySelect() {
        return R.ok(projectMilestoneService.selectCategoryAll());
    }

}
