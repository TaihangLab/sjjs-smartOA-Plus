package com.ruoyi.web.controller.project;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.ip.domin.bo.IntellectualPropertyBO;
import com.ruoyi.ip.service.IntellectualPropertyService;
import com.ruoyi.project.service.ProjectBaseInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
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

    /**
     * 添加知识产权
     * POST /add 接口路径
     * 请求参数需满足 AddGroup 验证规则
     *
     * @param intellectualPropertyBO 知识产权实体对象
     * @return 成功返回 R<Void>
     */
    //@SaCheckPermission("project:ip:add")
    @PostMapping("/add")
    public R<Void> addIntellectualProperty(@RequestBody @Validated(AddGroup.class) IntellectualPropertyBO intellectualPropertyBO) {
        intellectualPropertyService.insertIntellectualProperty(intellectualPropertyBO);
        return R.ok();
    }

    /**
     * 删除知识产权
     *
     * @param ipId 知识产权ID
     * @return 操作结果
     */
    //@SaCheckPermission("project:ip:delete")
    @GetMapping("/delete")
    public R<Void> deleteIntellectualProperty(@RequestParam @NotNull Long ipId) {
        intellectualPropertyService.deleteIntellectualProperty(ipId);
        return R.ok();
    }

    /**
     * 更新知识产权
     *
     * @param intellectualPropertyBO 知识产权BO对象
     * @return 更新结果
     */
    //@SaCheckPermission("project:ip:update")
    @PostMapping("/update")
    public R<Void> updateIntellectualProperty(@RequestBody @Validated(EditGroup.class) IntellectualPropertyBO intellectualPropertyBO) {
        intellectualPropertyService.updateIntellectualProperty(intellectualPropertyBO);
        return R.ok();
    }

    /**
     * 获取项目ID和名称映射关系
     *
     * @return 映射关系列表
     */
    //@SaCheckPermission("project:ip:getProjectMap")
    @GetMapping("/getProjectMapping")
    public R<List<Map<String, Object>>> getProjectIdAndNameMapping() {
        return R.ok(projectBaseInfoService.getProjectIdAndNameMapping());
    }
}
