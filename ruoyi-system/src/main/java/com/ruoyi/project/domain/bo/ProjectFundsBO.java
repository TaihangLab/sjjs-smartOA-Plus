package com.ruoyi.project.domain.bo;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

/**
 * @author bailingnan
 * @date 2023/12/15
 */
@Data
public class ProjectFundsBO {

    /**
     * 项目ID
     */
    private Long projectId;
    /**
     * 项目经费总额
     */
    @DecimalMax(value = "999999.999999", message = "项目经费总额不能超过999999.999999万元")
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsAll;

    /**
     * 专项经费总额
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsZx;

    /**
     * 专项设备费
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfZx;

    /**
     * 专项直接费用
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsZxZj;

    /**
     * 专项间接费用
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsZxJj;

    /**
     * 自筹经费总额
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsZc;

    /**
     * 自筹设备费
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfZc;

    /**
     * 自筹直接费用
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsZcZj;

    /**
     * 自筹间接费用
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsZcJj;

    /**
     * 设备费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfZxZj;

    /**
     * 设备费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfZcZj;

    /**
     * 设备费_购置设备费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfGzsbZxZj;

    /**
     * 设备费_购置设备费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfGzsbZcZj;

    /**
     * 设备费_试制设备费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSzsbZxZj;

    /**
     * 设备费_试制设备费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSzsbZcZj;

    /**
     * 设备费_设备改造与租赁费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSbgzyzlZxZj;

    /**
     * 设备费_设备改造与租赁费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSbgzyzlZcZj;

    /**
     * 材料费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal clfZxZj;

    /**
     * 材料费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal clfZcZj;

    /**
     * 科研活动费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZxZj;

    /**
     * 科研活动费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZcZj;

    /**
     * 科研活动费_资料费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZlZxZj;

    /**
     * 科研活动费_资料费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZlZcZj;

    /**
     * 科研活动_测试化验加工费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfCshyjgZxZj;

    /**
     * 科研活动_测试化验加工费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfCshyjgZcZj;

    /**
     * 科研活动费_办公费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfBgZxZj;

    /**
     * 科研活动费_办公费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfBgZcZj;

    /**
     * 科研活动费_数据/样本采集费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfSjybcjZxZj;

    /**
     * 科研活动费_数据/样本采集费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfSjybcjZcZj;

    /**
     * 科研活动费_印刷/出版费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfYscbZxZj;

    /**
     * 科研活动费_印刷/出版费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfYscbZcZj;

    /**
     * 科研活动费_知识产权事务费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZscqswZxZj;

    /**
     * 科研活动费_知识产权事务费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZscqswZcZj;

    /**
     * 科研活动费_燃料动力费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfRldlZxZj;

    /**
     * 科研活动费_燃料动力费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfRldlZcZj;

    /**
     * 科研活动费_车辆使用费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfClsyZxZj;

    /**
     * 科研活动费_车辆使用费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfClsyZcZj;

    /**
     * 科研服务费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfZxZj;

    /**
     * 科研服务费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfZcZj;

    /**
     * 科研服务费_专家咨询费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfZjzxZxZj;

    /**
     * 科研服务费_专家咨询费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfZjzxZcZj;

    /**
     * 科研服务费_差旅费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfClZxZj;

    /**
     * 科研服务费_差旅费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfClZcZj;

    /**
     * 科研服务费_会议/会务费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfHyhwZxZj;

    /**
     * 科研服务费_会议/会务费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfHyhwZcZj;

    /**
     * 科研服务费_国际合作交流_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfGjhzjlZxZj;

    /**
     * 科研服务费_国际合作交流_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfGjhzjlZcZj;

    /**
     * 科研服务费_国内协作费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfGnxzZxZj;

    /**
     * 科研服务费_国内协作费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfGnxzZcZj;

    /**
     * 人员和劳务补助费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ryhlwbzfZxZj;

    /**
     * 人员和劳务补助费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ryhlwbzfZcZj;

    /**
     * 间接费用_绩效支出_专项
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal jxzcZx;

    /**
     * 间接费用_绩效支出_自筹
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal jxzcZc;

    /**
     * 间接费用_其他支出_专项
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal othersZx;

    /**
     * 间接费用_其他支出_自筹
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal othersZc;

    /**
     * 经费来源_专项
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal jflyZx;

    /**
     * 经费来源_自筹
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal jflyZc;

    /**
     * 经费来源_其他财政拨款_自筹
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal jflyQtczbkZc;

    /**
     * 经费来源_单位自有货币资金_自筹
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal jflyDwzyhbzjZc;

    /**
     * 经费来源_其他资金_自筹
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal jflyQtzjZc;

    /**
     * 设备费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfZxJj;

    /**
     * 设备费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfZcJj;

    /**
     * 设备费_购置设备费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfGzsbZxJj;

    /**
     * 设备费_购置设备费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfGzsbZcJj;

    /**
     * 设备费_试制设备费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSzsbZxJj;

    /**
     * 设备费_试制设备费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSzsbZcJj;

    /**
     * 设备费_设备改造与租赁费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSbgzyzlZxJj;

    /**
     * 设备费_设备改造与租赁费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSbgzyzlZcJj;

    /**
     * 材料费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal clfZxJj;

    /**
     * 材料费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal clfZcJj;

    /**
     * 科研活动费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZxJj;

    /**
     * 科研活动费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZcJj;

    /**
     * 科研活动费_资料费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZlZxJj;

    /**
     *
     * 科研活动费_资料费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZlZcJj;

    /**
     * 科研活动_测试化验加工费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfCshyjgZxJj;

    /**
     * 科研活动_测试化验加工费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfCshyjgZcJj;

    /**
     * 科研活动费_办公费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfBgZxJj;

    /**
     * 科研活动费_办公费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfBgZcJj;

    /**
     * 科研活动费_数据/样本采集费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfSjybcjZxJj;

    /**
     * 科研活动费_数据/样本采集费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfSjybcjZcJj;

    /**
     * 科研活动费_印刷/出版费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfYscbZxJj;

    /**
     * 科研活动费_印刷/出版费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfYscbZcJj;

    /**
     * 科研活动费_知识产权事务费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZscqswZxJj;

    /**
     * 科研活动费_知识产权事务费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZscqswZcJj;

    /**
     * 科研活动费_燃料动力费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfRldlZxJj;

    /**
     * 科研活动费_燃料动力费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfRldlZcJj;

    /**
     * 科研活动费_车辆使用费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfClsyZxJj;

    /**
     * 科研活动费_车辆使用费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfClsyZcJj;

    /**
     * 科研服务费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfZxJj;

    /**
     * 科研服务费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfZcJj;

    /**
     * 科研服务费_专家咨询费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfZjzxZxJj;

    /**
     * 科研服务费_专家咨询费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfZjzxZcJj;

    /**
     * 科研服务费_差旅费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfClZxJj;

    /**
     * 科研服务费_差旅费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfClZcJj;

    /**
     * 科研服务费_会议/会务费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfHyhwZxJj;

    /**
     * 科研服务费_会议/会务费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfHyhwZcJj;

    /**
     * 科研服务费_国际合作交流_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfGjhzjlZxJj;

    /**
     * 科研服务费_国际合作交流_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfGjhzjlZcJj;

    /**
     * 科研服务费_国内协作费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfGnxzZxJj;

    /**
     * 科研服务费_国内协作费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfGnxzZcJj;

    /**
     * 人员和劳务补助费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ryhlwbzfZxJj;

    /**
     * 人员和劳务补助费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ryhlwbzfZcJj;
}
