package com.ruoyi.ip.domain.vo;

import com.ruoyi.common.enums.IntellectualPropertyStatusEnum;
import com.ruoyi.common.enums.IntellectualPropertyTypeEnum;
import lombok.Data;

import java.time.LocalDate;

/**
 * 知识产权VO
 *
 * @author bailingnan
 * @date 2024/1/4
 */
@Data
public class IntellectualPropertyVO {
    /**
     * 知识产权id
     */
    private Long ipId;
    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 关联项目名称
     */
    private String assignedSubjectName;

    /**
     * 知识产权名
     */
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
}
