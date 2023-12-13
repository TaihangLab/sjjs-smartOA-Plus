package com.ruoyi.project.domain.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import com.ruoyi.common.enums.ProjectType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * @author bailingnan
 * @date 2023/12/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectBaseInfoBO extends BaseEntity {

    /**
     * 项目id
     */
    @TableId(type = IdType.AUTO)
    @NotNull(message ="项目id不能为空",groups={AddGroup.class})
    private Long projectId;
    /**
     * 项目名称
     */
    @NotBlank(message = "项目名称不能为空",groups={AddGroup.class, EditGroup.class})
    @Size(max = 100, message = "项目名称长度不能超过100个字符",groups={AddGroup.class, EditGroup.class})
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
    @Size(max = 500, message = "项目描述长度不能超过500个字符",groups={AddGroup.class, EditGroup.class})
    private String projectInfo;

    /**
     * 项目类型
     */
    private ProjectType projectType;

    /**
     * 开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startTime;

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

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate establishTimeSta;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate establishTimeEnd;

    private Long userId;
}
