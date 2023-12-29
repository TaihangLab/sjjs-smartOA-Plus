package com.ruoyi.project.domain.vo;

import com.ruoyi.project.domain.ProjectBaseInfo;
import lombok.Data;

import java.util.List;

@Data
public class ProjectUserDetailVo {

    /**
     * 当前参与的国家级项目详情
     */
    private List<ProjectBaseInfo> nationProjectBaseInfos;

    /**
     * 当前参与的省级项目详情
     */
    private List<ProjectBaseInfo> provincialProjectBaseInfos;

    /**
     * 当前参与的自建项目详情
     */
    private List<ProjectBaseInfo> enterpriseProjectBaseInfos;


}
