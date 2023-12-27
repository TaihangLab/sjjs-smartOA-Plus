package com.ruoyi.web.controller.project;

import com.ruoyi.common.core.domain.PageQuery;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.validate.QueryGroup;
import com.ruoyi.project.domain.bo.ProjectBaseInfoBO;
import com.ruoyi.project.domain.bo.ProjectUserBo;
import com.ruoyi.project.domain.vo.ProjectBaseInfoVO;
import com.ruoyi.project.domain.vo.ProjectUserVo;
import com.ruoyi.project.service.ProjectUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/project/user")
public class ProjectUserController {

    private final ProjectUserService projectUserService;

    /**
     * 获取全部用户列表
     * @param projectUserBo 成员基本信息
     * @param pageQuery 分页信息
     * @return
     */
    @PostMapping("/getAllList")
    public TableDataInfo<ProjectUserVo> getAllProjectList(@RequestBody @Validated(QueryGroup.class) ProjectUserBo projectUserBo, PageQuery pageQuery){
        return projectUserService.queryPageAllList(projectUserBo, pageQuery);
    }
}
