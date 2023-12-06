package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 * 项目大事纪文件oss关联 project_milestone_oss
 *
 * @author JiaXing Fan
 */
@Data
@TableName("project_milestone_oss")
public class ProjectMilestoneOss {
    /**
     * 项目大事纪ID
     */
    @TableId
    private Long milestoneId;

    /**
     * ossID
     */

    private Long ossId;
}
