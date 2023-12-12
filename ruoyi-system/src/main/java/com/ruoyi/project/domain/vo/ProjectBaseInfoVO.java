package com.ruoyi.project.domain.vo;

import com.ruoyi.common.enums.ProjectType;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author bailingnan
 * @date 2023/12/12
 */
@Data
public class ProjectBaseInfoVO {
    private String projectName;

    private String projectManager;

    private String projectStatus;

    private String projectInfo;

    private ProjectType projectType;

    private LocalDate startTime;

    private LocalDate establishTime;
}
