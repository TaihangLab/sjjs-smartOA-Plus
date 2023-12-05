package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.xss.Xss;
import com.ruoyi.system.domain.SysOss;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@TableName("project_milestone")
public class ProjectMilestone {

    /**
     * 大事纪ID
     */
    @TableId(value = "milestone_id",type = IdType.AUTO)
    private Long milestoneId;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 大事记名称
     */
    @Xss(message = "大事记名称不能包含脚本字符")
    @NotBlank(message = "大事记名称不能为空")
    @Size(min = 0, max = 50, message = "大事记名称不能超过{max}个字符")
    private String milestoneTitle;

    /**
     * 大事记描述
     */
    @NotBlank(message = "大事记描述不能为空")
    @Size(min = 0, max = 100, message = "大事记描述不能超过{max}个字符")
    private String milestoneRemark;

    /**
     * 大事记时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate milestoneDate;

}
