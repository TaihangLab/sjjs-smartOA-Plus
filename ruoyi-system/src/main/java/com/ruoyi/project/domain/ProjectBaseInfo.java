package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 项目表
 * @author bailingnan
 * @TableName project_base_info
 */
@TableName(value ="project_base_info")
@Data
public class ProjectBaseInfo extends BaseEntity {
    /**
     * 项目id
     */
    @TableId(type = IdType.AUTO)
    private Long projectId;

    /**
     * 创建人ID
     */
    private Long creatorId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目负责人
     */
    private String projectManager;

    /**
     * 项目状态
     */
    private String projectStatus;

    /**
     * 项目描述
     */
    private String projectInfo;

    /**
     * 项目类型
     */
    private String projectType;

    /**
     * 立项日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date establishTime;

    /**
     * 中期检查日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date midtermDate;

    /**
     * 结项日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date completedDate;

}
