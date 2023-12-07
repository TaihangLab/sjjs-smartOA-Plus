package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 项目表
 * @TableName project_base_info
 */
@TableName(value ="project_base_info")
@Data
public class ProjectBaseInfo{
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
     * 创建时间
     */
    private Date createTime;

    /**
     * 立项日期
     */
    private Date establishTime;

    /**
     * 中期检查日期
     */
    private Date midtermDate;

    /**
     * 结项日期
     */
    private Date completedDate;

    /**
     * 修改时间
     */
    private Date updateTime;
}
