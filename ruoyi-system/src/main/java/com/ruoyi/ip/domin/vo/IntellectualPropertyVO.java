package com.ruoyi.ip.domin.vo;

import com.ruoyi.common.enums.IntellectualPropertyStatus;
import com.ruoyi.common.enums.IntellectualPropertyType;
import lombok.Data;

import java.time.LocalDate;

/**
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
     * 知识产权名
     */
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
