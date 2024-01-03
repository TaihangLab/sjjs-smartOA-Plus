package com.ruoyi.web.controller.project;

import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.project.domain.ProjectMilestoneOss;
import com.ruoyi.project.domain.bo.ProjectMilestoneBo;
import com.ruoyi.project.domain.bo.ProjectUserBo;
import com.ruoyi.project.domain.vo.ProjectUserVo;
import com.ruoyi.project.service.ProjectMilestoneService;
import com.ruoyi.system.domain.vo.SysOssVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目附件管理（大事记文件）
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/milestone/oss")
public class MilestoneOssController {

    private final ProjectMilestoneService projectMilestoneService;


    /**
     * 分页查询项目附件列表
     * @param projectMilestoneBo
     * @param pageQuery
     * @return
     */
    //@SaCheckPermission("project:user:getAllList")
    @PostMapping("/getAllList")
    public TableDataInfo<SysOssVo> getAllProjectList(@RequestBody @Validated(QueryGroup.class) ProjectMilestoneBo projectMilestoneBo,
                                                     PageQuery pageQuery) {
        return projectMilestoneService.queryPageAllList(projectMilestoneBo, pageQuery);
    }
}
