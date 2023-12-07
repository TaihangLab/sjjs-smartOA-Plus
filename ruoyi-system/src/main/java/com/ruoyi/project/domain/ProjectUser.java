package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 * 项目和用户关联 project_user
 *
 * @author JiaXing Fan
 */
@Data
@TableName("project_user")
public class ProjectUser {

    /**
     * 项目ID
     */
    @TableId(type = IdType.INPUT)
    private Long projectId;

    /**
     * 人员id
     */
    private Long userId;

}
