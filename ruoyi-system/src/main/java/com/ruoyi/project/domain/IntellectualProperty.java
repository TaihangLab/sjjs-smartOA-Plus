package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.enums.IntellectualPropertyStatus;
import com.ruoyi.common.enums.IntellectualPropertyType;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * 知识产权表
 *
 * @TableName intellectual_property
 */
@TableName(value = "intellectual_property")
@Data
public class IntellectualProperty implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 知识产权id
     */
    @TableId(type = IdType.AUTO)
    private Long ipId;
    /**
     * 对象存储id
     */
    private Long ossId;
    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 知识产权名
     */
    @NotBlank(message = "知识产权名称不能为空")
    private String ipName;
    /**
     * 知识产权类别,国内发明专利0、软件著作权1、论文2、标准3
     */
    private IntellectualPropertyType ipType;
    /**
     * 知识产权状态,专利受理0，专利授权1，软著已获取2，标准正在申报3，标准已通过4，论文已发表5
     */
    private IntellectualPropertyStatus ipStatus;
    /**
     * 获得日期
     */
    private LocalDate ipDate;
}
