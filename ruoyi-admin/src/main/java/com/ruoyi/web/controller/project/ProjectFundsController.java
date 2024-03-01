package com.ruoyi.web.controller.project;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.excel.ExcelResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.domain.ProjectFundsReceived;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.bo.ProjectInfoBO;
import com.ruoyi.project.domain.vo.ProjectBaseInfoVO;
import com.ruoyi.project.domain.vo.ProjectExpenditureImportVO;
import com.ruoyi.project.domain.vo.ProjectFundsManagementVO;
import com.ruoyi.project.listener.ProjectFundsImportListener;
import com.ruoyi.project.service.ProjectFundsReceivedService;
import com.ruoyi.project.service.ProjectFundsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @SaCheckPermission("project:funds:getAllList")
    @PostMapping("/getProjectList")
    public TableDataInfo<ProjectFundsManagementVO> getProjectList(@RequestBody@Validated(
        QueryGroup.class) ProjectBaseInfoBO projectBaseInfoBO, PageQuery pageQuery){
        return projectFundsService.queryPageList(projectBaseInfoBO, pageQuery);
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
     * 新增专项经费到账记录
     * @param projectFundsReceived
     * @return
     */
    @Log(title = "新增专项经费到账记录", businessType = BusinessType.INSERT)
    //    @SaCheckPermission("project:funds:addReceived")
    @PostMapping(value = "/addFundsReceived")
    public R<Void> addProjectFundsReceived(@RequestBody @Validated(AddGroup.class) ProjectFundsReceived projectFundsReceived) {
        projectFundsReceivedService.addFundsReceived(projectFundsReceived);
        return R.ok();
    }

}
