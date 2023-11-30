package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("project_user")
public class ProjectMember {

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 人员id
     */
    private Long userId;

}
