package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 知识产权和用户关联表
 *
 * @TableName ip_user
 */
@TableName(value = "ip_user")
@Data
public class IpUser implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 知识产权id
     */
    @TableId
    private Long ipId;
    /**
     * 成员id
     */
    private Long userId;
}
