package com.ruoyi.ip.domin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 知识产权和存储对象关联表
 *
 * @TableName ip_oss
 */
@TableName(value = "ip_oss")
@Data
public class IpOss implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 知识产权id
     */
    @TableId
    private Long ipId;
    /**
     * 存储对象id
     */
    private Long ossId;
}
