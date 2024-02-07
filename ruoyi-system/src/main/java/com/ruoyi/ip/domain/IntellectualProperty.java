package com.ruoyi.ip.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.enums.IntellectualPropertyStatusEnum;
import com.ruoyi.common.enums.IntellectualPropertyTypeEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * 知识产权表
 *
 * @author bailingnan
 * @TableName intellectual_property
 * @date 2024/02/06
 */
@TableName(value = "intellectual_property")
@Data
public class IntellectualProperty extends BaseEntity implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 知识产权id
     */
    @TableId(type = IdType.AUTO)
    private Long ipId;
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
    private IntellectualPropertyTypeEnum ipType;
    /**
     * 知识产权状态,专利受理0，专利授权1，软著已获取2，标准正在申报3，标准已通过4，论文已发表5
     */
    private IntellectualPropertyStatusEnum ipStatus;
    /**
     * 获得日期
     */
    private LocalDate ipDate;
    /**
     * 是否删除
     */
    @TableLogic
    @TableField(select = false)
    private Integer deleted;
}
