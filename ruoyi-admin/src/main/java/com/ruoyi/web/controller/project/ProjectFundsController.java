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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.domain.ProjectFundsReceived;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.bo.ProjectExpenditureBO;
import com.ruoyi.project.domain.vo.ProjectExpenditureImportVO;
import com.ruoyi.project.domain.vo.ProjectExpenditureVO;
import com.ruoyi.project.domain.vo.ProjectFundsManagementVO;
import com.ruoyi.project.domain.vo.ProjectFundsReceivedVo;
import com.ruoyi.project.listener.ProjectFundsImportListener;
import com.ruoyi.project.service.ProjectExpenditureService;
import com.ruoyi.project.service.ProjectFundsManagementService;
import com.ruoyi.project.service.ProjectFundsReceivedService;
import com.ruoyi.project.service.ProjectFundsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 项目经费
 *
 * @author bailingnan
 * @date 2024/2/26
 */
@Validated
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
    @SaCheckPermission("project:funds:getAllList")
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
    //    @SaCheckPermission("project:funds:import")
    @PostMapping(value = "/importData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public R<List<ProjectExpenditureImportVO>> importData(@RequestPart("file") MultipartFile file) throws Exception {
        ExcelResult<ProjectExpenditureImportVO> result =
            ExcelUtil.importExcel(file.getInputStream(), ProjectExpenditureImportVO.class,
                new ProjectFundsImportListener());
        return R.ok(result.getList());
    }

    /**
     * 新增支出记录
     *
     * @param projectExpenditureBOList
     *
     * @return {@link R}<{@link Void}>
     */
    @Log(title = "新增支出记录", businessType = BusinessType.INSERT)
    //    @SaCheckPermission("project:funds:add")
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
    //    @SaCheckPermission("project:funds:add")
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
    //    @SaCheckPermission("project:funds:addReceived")
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
    //    @SaCheckPermission("project:funds:editReceived")
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
    //    @SaCheckPermission("project:funds:deleteReceived")
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
     * 查询项目支出明细
     * @param projectId 项目ID
     * @return
     */
    @GetMapping(value = "/getProjectExpenditure")
    public R<List<ProjectExpenditureVO>> getProjectExpenditureListByProId(@RequestParam @NotNull Long projectId) {
        List<ProjectExpenditureVO> projectExpenditureList =
            projectExpenditureService.getProjectExpenditureByProId(projectId);
        return R.ok(projectExpenditureList);
    }

}
