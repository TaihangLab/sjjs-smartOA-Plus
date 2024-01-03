package com.ruoyi.web.controller.project;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.ip.domin.bo.IntellectualPropertyBO;
import com.ruoyi.ip.service.IntellectualPropertyService;
import com.ruoyi.project.service.ProjectBaseInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 知识产权管理
 *
 * @author bailingnan
 * @date 2023/12/29
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/project/ip")
public class IntellectualPropertyController {
    private final ProjectBaseInfoService projectBaseInfoService;
    private final IntellectualPropertyService intellectualPropertyService;

    //@SaCheckPermission("project:ip:add")
    @PostMapping("/add")
    public R<Void> addIntellectualProperty(@RequestBody @Validated(AddGroup.class) IntellectualPropertyBO intellectualPropertyBO) {
        intellectualPropertyService.addIntellectualProperty(intellectualPropertyBO);
        return R.ok();
    }

    //@SaCheckPermission("project:ip:getProjectMap")
    @GetMapping("/getProjectMapping")
    public R<List<Map<String, Object>>> getProjectIdAndNameMapping() {
        return R.ok(projectBaseInfoService.getProjectIdAndNameMapping());
    }
}
