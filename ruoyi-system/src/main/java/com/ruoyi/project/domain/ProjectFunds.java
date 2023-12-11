package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 项目经费表
 * @TableName project_funds
 */
@TableName(value ="project_funds")
@Data
public class ProjectFunds implements Serializable {
    /**
     * 经费id
     */
    @TableId(type = IdType.AUTO)
    private Long fundsId;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 设备费_购置设备费_专项
     */
    private BigDecimal sbfGzsbZx;

    /**
     * 设备费_购置设备费_自筹
     */
    private BigDecimal sbfGzsbZc;

    /**
     * 设备费_试制设备费_专项
     */
    private BigDecimal sbfSzsbZx;

    /**
     * 设备费_试制设备费_自筹
     */
    private BigDecimal sbfSzsbZc;

    /**
     * 设备费_设备改造与租赁费_专项
     */
    private BigDecimal sbfSbgzyzlZx;

    /**
     * 设备费_设备改造与租赁费_自筹
     */
    private BigDecimal sbfSbgzyzlZc;

    /**
     * 材料费_专项
     */
    private BigDecimal clfZx;

    /**
     * 材料费_自筹
     */
    private BigDecimal clfZc;

    /**
     * 科研活动费_资料费_专项
     */
    private BigDecimal kyhdfZlZx;

    /**
     * 科研活动费_资料费_自筹
     */
    private BigDecimal kyhdfZlZc;

    /**
     * 科研活动_测试化验加工费_专项
     */
    private BigDecimal addkyhdfCshyjgZx;

    /**
     * 科研活动_测试化验加工费_自筹
     */
    private BigDecimal kyhdfCshyjgZc;

    /**
     * 科研活动费_办公费_专项
     */
    private BigDecimal kyhdfBgZx;

    /**
     * 科研活动费_办公费_自筹
     */
    private BigDecimal kyhdfBgZc;

    /**
     * 科研活动费_数据/样本采集费_专项
     */
    private BigDecimal kyhdfSjybcjZx;

    /**
     * 科研活动费_数据/样本采集费_自筹
     */
    private BigDecimal kyhdfSjybcjZc;

    /**
     * 科研活动费_印刷/出版费_专项
     */
    private BigDecimal kyhdfYscbZx;

    /**
     * 科研活动费_印刷/出版费_自筹
     */
    private BigDecimal kyhdfYscbZc;

    /**
     * 科研活动费_知识产权事务费_专项
     */
    private BigDecimal kyhdfZscqswZx;

    /**
     * 科研活动费_知识产权事务费_自筹
     */
    private BigDecimal kyhdfZscqswZc;

    /**
     * 科研活动费_燃料动力费_专项
     */
    private BigDecimal kyhdfRldlZx;

    /**
     * 科研活动费_燃料动力费_自筹
     */
    private BigDecimal kyhdfRldlZc;

    /**
     * 科研活动费_车辆使用费_专项
     */
    private BigDecimal kyhdfClsyZx;

    /**
     * 科研活动费_车辆使用费_自筹
     */
    private BigDecimal kyhdfClsyZc;

    /**
     * 科研服务费_专家咨询费_专项
     */
    private BigDecimal kyfwfZjzxZx;

    /**
     * 科研服务费_专家咨询费_自筹
     */
    private BigDecimal kyfwfZjzxZc;

    /**
     * 科研服务费_差旅费_专项
     */
    private BigDecimal kyfwfClZx;

    /**
     * 科研服务费_差旅费_自筹
     */
    private BigDecimal kyfwfClZc;

    /**
     * 科研服务费_国际合作交流_专项
     */
    private BigDecimal kyfwfGjhzjlZx;

    /**
     * 科研服务费_国际合作交流_自筹
     */
    private BigDecimal kyfwfGjhzjlZc;

    /**
     * 科研服务费_国内协作费_专项
     */
    private BigDecimal kyfwfGnxzZx;

    /**
     * 科研服务费_国内协作费_自筹
     */
    private BigDecimal kyfwfGnxzZc;

    /**
     * 人员和劳务补助费_专项
     */
    private BigDecimal ryhlwbzfZx;

    /**
     * 人员和劳务补助费_自筹
     */
    private BigDecimal ryhlwbzfZc;

    /**
     * 间接费用_绩效支出_专项
     */
    private BigDecimal jxzcZx;

    /**
     * 间接费用_绩效支出_自筹
     */
    private BigDecimal jxzcZc;

    /**
     * 经费来源_专项
     */
    private BigDecimal jflyZx;

    /**
     * 经费来源_其他财政拨款_自筹
     */
    private BigDecimal jflyQtczbkZc;

    /**
     * 经费来源_单位自有货币资金_自筹
     */
    private BigDecimal jflyDwzyhbzjZc;

    /**
     * 经费来源_其他资金_自筹
     */
    private BigDecimal jflyQtzjZc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}