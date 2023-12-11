package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

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
     * 项目名称
     */
    @NotBlank(message = "项目名称不能为空")
    @Size(max = 100, message = "项目名称长度不能超过100个字符")
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
    @Size(max = 500, message = "项目描述长度不能超过500个字符")
    private String projectInfo;

    /**
     * 项目类型
     */
    private String projectType;

    /**
     * 立项日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate establishTime;

    /**
     * 中期检查日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate midtermDate;

    /**
     * 结项日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate completedDate;

    /**
     * 是否删除，2删除，0未删除
     */
    @TableLogic
    @TableField(select = false)
    private Integer deleted;
}
