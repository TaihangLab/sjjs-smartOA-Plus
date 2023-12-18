package com.ruoyi.project.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 经费
 *
 * @author bailingnan
 * @date 2023/12/11
 */
@Data
public class ProjectFundsVO {
    /**
     * 设备费_购置设备费_专项_直接
     */
    private BigDecimal sbfGzsbZxZj;

    /**
     * 设备费_购置设备费_自筹_直接
     */
    private BigDecimal sbfGzsbZcZj;

    /**
     * 设备费_试制设备费_专项_直接
     */
    private BigDecimal sbfSzsbZxZj;

    /**
     * 设备费_试制设备费_自筹_直接
     */
    private BigDecimal sbfSzsbZcZj;

    /**
     * 设备费_设备改造与租赁费_专项_直接
     */
    private BigDecimal sbfSbgzyzlZxZj;

    /**
     * 设备费_设备改造与租赁费_自筹_直接
     */
    private BigDecimal sbfSbgzyzlZcZj;

    /**
     * 材料费_专项_直接
     */
    private BigDecimal clfZxZj;

    /**
     * 材料费_自筹_直接
     */
    private BigDecimal clfZcZj;

    /**
     * 科研活动费_资料费_专项_直接
     */
    private BigDecimal kyhdfZlZxZj;

    /**
     * 科研活动费_资料费_自筹_直接
     */
    private BigDecimal kyhdfZlZcZj;

    /**
     * 科研活动_测试化验加工费_专项_直接
     */
    private BigDecimal kyhdfCshyjgZxZj;

    /**
     * 科研活动_测试化验加工费_自筹_直接
     */
    private BigDecimal kyhdfCshyjgZcZj;

    /**
     * 科研活动费_办公费_专项_直接
     */
    private BigDecimal kyhdfBgZxZj;

    /**
     * 科研活动费_办公费_自筹_直接
     */
    private BigDecimal kyhdfBgZcZj;

    /**
     * 科研活动费_数据/样本采集费_专项_直接
     */
    private BigDecimal kyhdfSjybcjZxZj;

    /**
     * 科研活动费_数据/样本采集费_自筹_直接
     */
    private BigDecimal kyhdfSjybcjZcZj;

    /**
     * 科研活动费_印刷/出版费_专项_直接
     */
    private BigDecimal kyhdfYscbZxZj;

    /**
     * 科研活动费_印刷/出版费_自筹_直接
     */
    private BigDecimal kyhdfYscbZcZj;

    /**
     * 科研活动费_知识产权事务费_专项_直接
     */
    private BigDecimal kyhdfZscqswZxZj;

    /**
     * 科研活动费_知识产权事务费_自筹_直接
     */
    private BigDecimal kyhdfZscqswZcZj;

    /**
     * 科研活动费_燃料动力费_专项_直接
     */
    private BigDecimal kyhdfRldlZxZj;

    /**
     * 科研活动费_燃料动力费_自筹_直接
     */
    private BigDecimal kyhdfRldlZcZj;

    /**
     * 科研活动费_车辆使用费_专项_直接
     */
    private BigDecimal kyhdfClsyZxZj;

    /**
     * 科研活动费_车辆使用费_自筹_直接
     */
    private BigDecimal kyhdfClsyZcZj;

    /**
     * 科研服务费_专家咨询费_专项_直接
     */
    private BigDecimal kyfwfZjzxZxZj;

    /**
     * 科研服务费_专家咨询费_自筹_直接
     */
    private BigDecimal kyfwfZjzxZcZj;

    /**
     * 科研服务费_差旅费_专项_直接
     */
    private BigDecimal kyfwfClZxZj;

    /**
     * 科研服务费_差旅费_自筹_直接
     */
    private BigDecimal kyfwfClZcZj;

    /**
     * 科研服务费_国际合作交流_直接
     */
    private BigDecimal kyfwfGjhzjlZxZj;

    /**
     * 科研服务费_国际合作交流_自筹_直接
     */
    private BigDecimal kyfwfGjhzjlZcZj;

    /**
     * 科研服务费_国内协作费_专项_直接
     */
    private BigDecimal kyfwfGnxzZxZj;

    /**
     * 科研服务费_国内协作费_自筹_直接
     */
    private BigDecimal kyfwfGnxzZcZj;

    /**
     * 人员和劳务补助费_专项_直接
     */
    private BigDecimal ryhlwbzfZxZj;

    /**
     * 人员和劳务补助费_自筹_直接
     */
    private BigDecimal ryhlwbzfZcZj;

    /**
     * 间接费用_绩效支出_专项
     */
    private BigDecimal jxzcZx;

    /**
     * 间接费用_绩效支出_自筹
     */
    private BigDecimal jxzcZc;

    /**
     * 间接费用_其他支出_专项
     */
    private BigDecimal othersZx;

    /**
     * 间接费用_其他支出_自筹
     */
    private BigDecimal othersZc;

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

    /**
     * 设备费_购置设备费_专项_间接
     */
    private BigDecimal sbfGzsbZxJj;

    /**
     * 设备费_购置设备费_自筹_间接
     */
    private BigDecimal sbfGzsbZcJj;

    /**
     * 设备费_试制设备费_专项_间接
     */
    private BigDecimal sbfSzsbZxJj;

    /**
     * 设备费_试制设备费_自筹_间接
     */
    private BigDecimal sbfSzsbZcJj;

    /**
     * 设备费_设备改造与租赁费_专项_间接
     */
    private BigDecimal sbfSbgzyzlZxJj;

    /**
     * 设备费_设备改造与租赁费_自筹_间接
     */
    private BigDecimal sbfSbgzyzlZcJj;

    /**
     * 材料费_专项_间接
     */
    private BigDecimal clfZxJj;

    /**
     * 材料费_自筹_间接
     */
    private BigDecimal clfZcJj;

    /**
     * 科研活动费_资料费_专项_间接
     */
    private BigDecimal kyhdfZlZxJj;

    /**
     * 科研活动费_资料费_自筹_间接
     */
    private BigDecimal kyhdfZlZcJj;

    /**
     * 科研活动_测试化验加工费_专项_间接
     */
    private BigDecimal kyhdfCshyjgZxJj;

    /**
     * 科研活动_测试化验加工费_自筹_间接
     */
    private BigDecimal kyhdfCshyjgZcJj;

    /**
     * 科研活动费_办公费_专项_间接
     */
    private BigDecimal kyhdfBgZxJj;

    /**
     * 科研活动费_办公费_自筹_间接
     */
    private BigDecimal kyhdfBgZcJj;

    /**
     * 科研活动费_数据/样本采集费_专项_间接
     */
    private BigDecimal kyhdfSjybcjZxJj;

    /**
     * 科研活动费_数据/样本采集费_自筹_间接
     */
    private BigDecimal kyhdfSjybcjZcJj;

    /**
     * 科研活动费_印刷/出版费_专项_间接
     */
    private BigDecimal kyhdfYscbZxJj;

    /**
     * 科研活动费_印刷/出版费_自筹_间接
     */
    private BigDecimal kyhdfYscbZcJj;

    /**
     * 科研活动费_知识产权事务费_专项_间接
     */
    private BigDecimal kyhdfZscqswZxJj;

    /**
     * 科研活动费_知识产权事务费_自筹_间接
     */
    private BigDecimal kyhdfZscqswZcJj;

    /**
     * 科研活动费_燃料动力费_专项_间接
     */
    private BigDecimal kyhdfRldlZxJj;

    /**
     * 科研活动费_燃料动力费_自筹_间接
     */
    private BigDecimal kyhdfRldlZcJj;

    /**
     * 科研活动费_车辆使用费_专项_间接
     */
    private BigDecimal kyhdfClsyZxJj;

    /**
     * 科研活动费_车辆使用费_自筹_间接
     */
    private BigDecimal kyhdfClsyZcJj;

    /**
     * 科研服务费_专家咨询费_专项_间接
     */
    private BigDecimal kyfwfZjzxZxJj;

    /**
     * 科研服务费_专家咨询费_自筹_间接
     */
    private BigDecimal kyfwfZjzxZcJj;

    /**
     * 科研服务费_差旅费_专项_间接
     */
    private BigDecimal kyfwfClZxJj;

    /**
     * 科研服务费_差旅费_自筹_间接
     */
    private BigDecimal kyfwfClZcJj;

    /**
     * 科研服务费_国际合作交流_间接
     */
    private BigDecimal kyfwfGjhzjlZxJj;

    /**
     * 科研服务费_国际合作交流_自筹_间接
     */
    private BigDecimal kyfwfGjhzjlZcJj;

    /**
     * 科研服务费_国内协作费_专项_间接
     */
    private BigDecimal kyfwfGnxzZxJj;

    /**
     * 科研服务费_国内协作费_自筹_间接
     */
    private BigDecimal kyfwfGnxzZcJj;

    /**
     * 人员和劳务补助费_专项_间接
     */
    private BigDecimal ryhlwbzfZxJj;

    /**
     * 人员和劳务补助费_自筹_间接
     */
    private BigDecimal ryhlwbzfZcJj;
}
