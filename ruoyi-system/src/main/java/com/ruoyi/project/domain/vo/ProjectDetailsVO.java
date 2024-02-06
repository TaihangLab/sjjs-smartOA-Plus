package com.ruoyi.project.domain.vo;

import com.ruoyi.system.domain.vo.SysOssVo;
import lombok.Data;

import java.util.List;

/**
 * 项目详情VO(包含ProjectInfoVO)
 *
 * @author bailingnan
 * @date 2023/12/14
 */
@Data
public class ProjectDetailsVO {

    /**
     * 项目信息
     */
    private ProjectInfoVO projectInfoVO;

    /**
     * 成员信息
     */
    private List<ProjectUserVo> projectUserVoList;

    /**
     * 经费信息
     */
    private ProjectFundsVO projectFundsVO;

    /**
     * 指标信息
     */
    private List<ProjectTargetVO> projectTargetVOList;

    /**
     * 附件信息
     */
    private List<SysOssVo> projectAttachmentVOList;

    /**
     * 计划信息
     */
    private List<ProjectPlanVO> projectPlanVOList;
}
