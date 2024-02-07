package com.ruoyi.project.domain.bo;

import lombok.Data;

/**
 * 项目附件BO
 *
 * @author bailingnan
 * @date 2023/12/15
 */
@Data
public class ProjectAttachmentBO {
    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 文件oss_id
     */
    private Long ossId;
}
