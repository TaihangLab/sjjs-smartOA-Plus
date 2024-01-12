package com.ruoyi.project.domain.bo;

import com.ruoyi.common.core.validate.AddGroup;
import com.ruoyi.common.core.validate.EditGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author bailingnan
 * @date 2023/12/15
 */
@Data
public class ProjectTargetBO {
    /**
     * 项目ID
     */
    private Long projectId;
    /**
     * 指标名称
     */
    @NotBlank(message = "指标名称不能为空", groups = {AddGroup.class, EditGroup.class})
    @Size(min = 0, max = 50, message = "指标描述不能超过{max}个字符")
    private String targetName;

    /**
     * 中期指标值/状态
     */
    @NotBlank(message = "中期指标不能为空", groups = {AddGroup.class, EditGroup.class})
    @Size(min = 0, max = 200, message = "中期指标不能超过{max}个字符")
    private String midtermTarget;

    /**
     * 完成时指标值/状态
     */
    @NotBlank(message = "完成时指标不能为空", groups = {AddGroup.class, EditGroup.class})
    @Size(min = 0, max = 200, message = "完成时指标不能超过{max}个字符")
    private String endTarget;
}
