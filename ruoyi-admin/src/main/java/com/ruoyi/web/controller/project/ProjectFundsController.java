package com.ruoyi.web.controller.project;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.excel.ExcelResult;
import com.ruoyi.common.utils.BeanCopyUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.domain.ProjectExpenditure;
import com.ruoyi.project.domain.ProjectFundsReceived;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.bo.ProjectExpenditureBO;
import com.ruoyi.project.domain.vo.*;
import com.ruoyi.project.listener.ProjectFundsImportListener;
import com.ruoyi.project.service.ProjectExpenditureService;
import com.ruoyi.project.service.ProjectFundsManagementService;
import com.ruoyi.project.service.ProjectFundsReceivedService;
import com.ruoyi.project.service.ProjectFundsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * 项目经费
 *
 * @author bailingnan
 * @date 2024/2/26
 */
@Validated
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/project/funds")
public class ProjectFundsController {

    private final ProjectFundsReceivedService projectFundsReceivedService;
    private final ProjectFundsService projectFundsService;
    private final ProjectFundsManagementService projectFundsManagementService;
    private final ProjectExpenditureService projectExpenditureService;

    /**
     * 经费管理列表
     *
     * @param projectBaseInfoBO
     * @param pageQuery
     *
     * @return {@link TableDataInfo}<{@link ProjectFundsManagementVO}>
     */
    @SaCheckPermission("project:expense:getAllList")
    @PostMapping("/getProjectList")
    public TableDataInfo<ProjectFundsManagementVO> getProjectList(@RequestBody@Validated(
        QueryGroup.class) ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery){
        return projectFundsManagementService.queryPageList(projectBaseInfoBO, pageQuery);
    }

    /**
     * 导入数据
     *
     * @param file 导入文件
     *
     * @return {@link R}<{@link List}<{@link ProjectExpenditureImportVO}>>
     *
     * @throws Exception
     */
    @Log(title = "经费支出导入", businessType = BusinessType.IMPORT)
    @SaCheckPermission("project:expense:import")
    @PostMapping(value = "/importData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public R<List<ProjectExpenditureImportVO>> importData(@RequestPart("file") MultipartFile file) throws Exception {
        ExcelResult<ProjectExpenditureImportVO> result =
            ExcelUtil.importExcel(file.getInputStream(), ProjectExpenditureImportVO.class,
                new ProjectFundsImportListener());
        return R.ok(result.getList());
    }

    /**
     * 导出数据
     *
     * @param projectExpenditureBO 支出ID
     *
     * @param response
     */
    @Log(title = "经费支出导出", businessType = BusinessType.EXPORT)
    @SaCheckPermission("project:expense:export")
    @PostMapping("/exportData")
    public void export(ProjectExpenditureBO projectExpenditureBO, HttpServletResponse response) {
        List<ProjectExpenditure> projectExpenditures = projectExpenditureService.getProjectExpenditureByProId(projectExpenditureBO);
        List<ProjectExpenditureExportVO> projectExpenditureExportVOS = BeanCopyUtils.copyList(projectExpenditures, ProjectExpenditureExportVO.class);
        ExcelUtil.exportExcel(projectExpenditureExportVOS, "支出明细数据", ProjectExpenditureExportVO.class, response);
    }

    /**
     * 新增支出记录
     *
     * @param projectExpenditureBOList
     *
     * @return {@link R}<{@link Void}>
     */
    @Log(title = "新增支出记录", businessType = BusinessType.INSERT)
    @SaCheckPermission("project:expense:add")
    @PostMapping(value = "/add")
    public R<Void> addProjectExpenditureList(
        @RequestBody @Validated(EditGroup.class) List<ProjectExpenditureBO> projectExpenditureBOList) {
        projectExpenditureService.addProjectExpenditureList(projectExpenditureBOList);
        return R.ok();
    }

    /**
     * 支出记录回滚
     *
     * @param expenditureId
     *
     * @return {@link R}<{@link Void}>
     *
     * @throws IllegalAccessException
     */
    @Log(title = "支出记录回滚", businessType = BusinessType.DELETE)
    @SaCheckPermission("project:expense:cancel")
    @GetMapping(value = "/rollback")
    public R<Void> rollBackProjectExpenditure(@RequestParam @NotNull Long expenditureId) throws IllegalAccessException {
        projectExpenditureService.rollBackProjectExpenditureById(expenditureId);
        return R.ok();
    }

    /**
     * 新增专项经费到账记录
     * @param projectFundsReceived 经费到账信息
     * @return
     */
    @Log(title = "新增专项经费到账记录", businessType = BusinessType.INSERT)
    @SaCheckPermission("project:expense:receivedAdd")
    @PostMapping(value = "/addFundsReceived")
    public R<Void> addProjectFundsReceived(@RequestBody @Validated(AddGroup.class) ProjectFundsReceived projectFundsReceived) {
        projectFundsReceivedService.addFundsReceived(projectFundsReceived);
        return R.ok();
    }

    /**
     * 修改专项经费到账记录
     * @param projectFundsReceived 修改后的经费到账信息
     * @return
     */
    @Log(title = "修改专项经费到账记录", businessType = BusinessType.UPDATE)
    @SaCheckPermission("project:expense:receivedEdit")
    @PostMapping(value = "/updateFundsReceived")
    public R<Void> updateFundsReceived(@RequestBody @Validated(AddGroup.class) ProjectFundsReceived projectFundsReceived) {
        projectFundsReceivedService.updateFundsReceived(projectFundsReceived);
        return R.ok();
    }

    /**
     * 删除专项经费到账记录
     * @param receivedId 经费到账ID
     * @return
     */
    @Log(title = "删除专项经费到账记录", businessType = BusinessType.DELETE)
    @SaCheckPermission("project:expense:receivedDelete")
    @GetMapping(value = "/deleteFundsReceived")
    public R<Void> deleteFundsReceivedById(@RequestParam @Validated(AddGroup.class) Long receivedId) {
        projectFundsReceivedService.deleteFundsReceivedById(receivedId);
        return R.ok();
    }

    /**
     * 查询某个项目的专项经费到账记录
     * @param projectId 项目ID
     * @return
     */
    @GetMapping(value = "/getFundsReceived")
    public R<List<ProjectFundsReceivedVo>> getFundsReceivedByProId(@RequestParam @NotNull Long projectId) {
        List<ProjectFundsReceivedVo> fundsReceivedVoList = projectFundsReceivedService.getFundsReceivedByProId(projectId);
        return R.ok(fundsReceivedVoList);
    }

    /**
     * 查询支出明细
     * @param projectExpenditureBO
     *
     * @return {@link R }<{@link List }<{@link ProjectExpenditureVO }>>
     */
    @SaCheckPermission("project:expense:view")
    @PostMapping(value = "/getProjectExpenditure")
    public TableDataInfo<ProjectExpenditureVO> getProjectExpenditureListByProId(
        @RequestBody @Validated(QueryGroup.class) ProjectExpenditureBO projectExpenditureBO, PageQuery pageQuery) {
        return projectExpenditureService.getProjectExpenditureByProId(projectExpenditureBO, pageQuery);
    }
}
