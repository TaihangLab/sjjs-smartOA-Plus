package com.ruoyi.project.domain.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.xss.Xss;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectMilestoneBo extends BaseEntity {

    /**
     * 大事记ID
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
    @Size(min = 0, max = 200, message = "大事记描述不能超过{max}个字符")
    private String milestoneRemark;

    /**
     * 大事记时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate milestoneDate;

    /**
     * 大事记对应ossID列表
     */
    private List<Long> ossIds;
}
