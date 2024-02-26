package com.ruoyi.web.controller.project;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.excel.ExcelResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.domain.vo.ProjectExpenditureImportVO;
import com.ruoyi.project.listener.ProjectFundsImportListener;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
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
}
