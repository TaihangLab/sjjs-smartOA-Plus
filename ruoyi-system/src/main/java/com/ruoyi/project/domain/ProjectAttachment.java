package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("project_attachments")
public class ProjectAttachment {

    /**
     * 主键id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 文件oss_id
     */
    private Long ossId;

    /**
     * 项目附件或其他附件
     */
    private String attachmentType;

    /**
     * 是否为模版文件
     */
    private boolean template;

}
