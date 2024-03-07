package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.PaidFieldDescription;
import com.ruoyi.common.annotation.UnPaidFieldDescription;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 项目余额表（单位：万元）
 *
 * @author bailingnan
 * @TableName project_balance
 * @date 2024/03/06
 */
@TableName(value ="project_balance")
@Data
public class ProjectBalance implements Serializable {
    /**
     * 余额id
     */
    @TableId(type = IdType.AUTO)
    private Long balanceId;

    /**
     * 经费id
     */
    private Long fundsId;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 项目经费总额_已支付
     */
    @PaidFieldDescription("项目经费总额")
    private BigDecimal totalFundsAllPaid;

    /**
     * 项目经费总额
     */
    @UnPaidFieldDescription("项目经费总额")
    private BigDecimal totalFundsAllUnpaid;

    /**
     * 专项经费总额_已支付
     */
    @PaidFieldDescription("专项经费总额")
    private BigDecimal totalFundsZxPaid;

    /**
     * 专项经费总额
     */
    @UnPaidFieldDescription("专项经费总额")
    private BigDecimal totalFundsZxUnpaid;

    /**
     * 专项设备费_已支付
     */
    @PaidFieldDescription("专项设备费")
    private BigDecimal sbfZxPaid;

    /**
     * 专项设备费
     */
    @UnPaidFieldDescription("专项设备费")
    private BigDecimal sbfZxUnpaid;

    /**
     * 专项直接费用_已支付
     */
    @PaidFieldDescription("专项直接费用")
    private BigDecimal totalFundsZxZjPaid;

    /**
     * 专项直接费用
     */
    @UnPaidFieldDescription("专项直接费用")
    private BigDecimal totalFundsZxZjUnpaid;

    /**
     * 专项间接费用_已支付
     */
    @PaidFieldDescription("专项间接费用")
    private BigDecimal totalFundsZxJjPaid;

    /**
     * 专项间接费用
     */
    @UnPaidFieldDescription("专项间接费用")
    private BigDecimal totalFundsZxJjUnpaid;

    /**
     * 自筹经费总额_已支付
     */
    @PaidFieldDescription("自筹经费总额")
    private BigDecimal totalFundsZcPaid;

    /**
     * 自筹经费总额
     */
    @UnPaidFieldDescription("自筹经费总额")
    private BigDecimal totalFundsZcUnpaid;

    /**
     * 自筹设备费_已支付
     */
    @PaidFieldDescription("自筹设备费")
    private BigDecimal sbfZcPaid;

    /**
     * 自筹设备费
     */
    @UnPaidFieldDescription("自筹设备费")
    private BigDecimal sbfZcUnpaid;

    /**
     * 自筹直接费用_已支付
     */
    @PaidFieldDescription("自筹直接费用")
    private BigDecimal totalFundsZcZjPaid;

    /**
     * 自筹直接费用
     */
    @UnPaidFieldDescription("自筹直接费用")
    private BigDecimal totalFundsZcZjUnpaid;

    /**
     * 自筹间接费用_已支付
     */
    @PaidFieldDescription("自筹间接费用")
    private BigDecimal totalFundsZcJjPaid;

    /**
     * 自筹间接费用
     */
    @UnPaidFieldDescription("自筹间接费用")
    private BigDecimal totalFundsZcJjUnpaid;

    /**
     * 设备费_专项_直接_已支付
     */
    @PaidFieldDescription("设备费_专项_直接")
    private BigDecimal sbfZxZjPaid;

    /**
     * 设备费_专项_直接
     */
    @UnPaidFieldDescription("设备费_专项_直接")
    private BigDecimal sbfZxZjUnpaid;

    /**
     * 设备费_自筹_直接_已支付
     */
    @PaidFieldDescription("设备费_自筹_直接")
    private BigDecimal sbfZcZjPaid;

    /**
     * 设备费_自筹_直接
     */
    @UnPaidFieldDescription("设备费_自筹_直接")
    private BigDecimal sbfZcZjUnpaid;

    /**
     * 设备费_购置设备费_专项_直接_已支付
     */
    @PaidFieldDescription("设备费_购置设备费_专项_直接")
    private BigDecimal sbfGzsbZxZjPaid;

    /**
     * 设备费_购置设备费_专项_直接
     */
    @UnPaidFieldDescription("设备费_购置设备费_专项_直接")
    private BigDecimal sbfGzsbZxZjUnpaid;

    /**
     * 设备费_购置设备费_自筹_直接_已支付
     */
    @PaidFieldDescription("设备费_购置设备费_自筹_直接")
    private BigDecimal sbfGzsbZcZjPaid;

    /**
     * 设备费_试制设备费_专项_直接
     */
    @UnPaidFieldDescription("设备费_试制设备费_专项_直接")
    private BigDecimal sbfSzsbZxZjUnpaid;

    /**
     * 设备费_试制设备费_自筹_直接_已支付
     */
    @PaidFieldDescription("设备费_试制设备费_自筹_直接")
    private BigDecimal sbfSzsbZcZjPaid;

    /**
     * 设备费_试制设备费_自筹_直接
     */
    @UnPaidFieldDescription("设备费_试制设备费_自筹_直接")
    private BigDecimal sbfSzsbZcZjUnpaid;

    /**
     * 设备费_设备升级改造费_专项_直接_已支付
     */
    @PaidFieldDescription("设备费_设备升级改造费_专项_直接")
    private BigDecimal sbfSbsjgzZxZjPaid;

    /**
     * 设备费_设备升级改造费_专项_直接
     */
    @UnPaidFieldDescription("设备费_设备升级改造费_专项_直接")
    private BigDecimal sbfSbsjgzZxZjUnpaid;

    /**
     * 设备费_设备升级改造费_自筹_直接_已支付
     */
    @PaidFieldDescription("设备费_设备升级改造费_自筹_直接")
    private BigDecimal sbfSbsjgzZcZjPaid;

    /**
     * 设备费_设备升级改造费_自筹_直接
     */
    @UnPaidFieldDescription("设备费_设备升级改造费_自筹_直接")
    private BigDecimal sbfSbsjgzZcZjUnpaid;

    /**
     * 设备费_设备租赁费_专项_直接_已支付
     */
    @PaidFieldDescription("设备费_设备租赁费_专项_直接")
    private BigDecimal sbfSbzlZxZjPaid;

    /**
     * 设备费_设备租赁费_专项_直接
     */
    @UnPaidFieldDescription("设备费_设备租赁费_专项_直接")
    private BigDecimal sbfSbzlZxZjUnpaid;

    /**
     * 设备费_设备租赁费_自筹_直接_已支付
     */
    @PaidFieldDescription("设备费_设备租赁费_自筹_直接")
    private BigDecimal sbfSbzlZcZjPaid;

    /**
     * 设备费_设备租赁费_自筹_直接
     */
    @UnPaidFieldDescription("设备费_设备租赁费_自筹_直接")
    private BigDecimal sbfSbzlZcZjUnpaid;

    /**
     * 业务费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_专项_直接")
    private BigDecimal ywfZxZjPaid;

    /**
     * 业务费_专项_直接
     */
    @UnPaidFieldDescription("业务费_专项_直接")
    private BigDecimal ywfZxZjUnpaid;

    /**
     * 业务费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_自筹_直接")
    private BigDecimal ywfZcZjPaid;

    /**
     * 业务费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_自筹_直接")
    private BigDecimal ywfZcZjUnpaid;

    /**
     * 业务费_材料费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_材料费_专项_直接")
    private BigDecimal ywfClfZxZjPaid;

    /**
     * 业务费_材料费_专项_直接
     */
    @UnPaidFieldDescription("业务费_材料费_专项_直接")
    private BigDecimal ywfClfZxZjUnpaid;

    /**
     * 业务费_材料费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_材料费_自筹_直接")
    private BigDecimal ywfClfZcZjPaid;

    /**
     * 业务费_材料费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_材料费_自筹_直接")
    private BigDecimal ywfClfZcZjUnpaid;

    /**
     * 业务费_资料费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_资料费_专项_直接")
    private BigDecimal ywfZlfZxZjPaid;

    /**
     * 业务费_资料费_专项_直接
     */
    @UnPaidFieldDescription("业务费_资料费_专项_直接")
    private BigDecimal ywfZlfZxZjUnpaid;

    /**
     * 业务费_资料费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_资料费_自筹_直接")
    private BigDecimal ywfZlfZcZjPaid;

    /**
     * 业务费_资料费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_资料费_自筹_直接")
    private BigDecimal ywfZlfZcZjUnpaid;

    /**
     * 业务费_数据样本采集费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_数据样本采集费_专项_直接")
    private BigDecimal ywfSjybcjfZxZjPaid;

    /**
     * 业务费_数据样本采集费_专项_直接
     */
    @UnPaidFieldDescription("业务费_数据样本采集费_专项_直接")
    private BigDecimal ywfSjybcjfZxZjUnpaid;

    /**
     * 业务费_数据样本采集费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_数据样本采集费_自筹_直接")
    private BigDecimal ywfSjybcjfZcZjPaid;

    /**
     * 业务费_数据样本采集费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_数据样本采集费_自筹_直接")
    private BigDecimal ywfSjybcjfZcZjUnpaid;

    /**
     * 业务费_测试化验加工费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_测试化验加工费_专项_直接")
    private BigDecimal ywfCshyjgfZxZjPaid;

    /**
     * 业务费_测试化验加工费_专项_直接
     */
    @UnPaidFieldDescription("业务费_测试化验加工费_专项_直接")
    private BigDecimal ywfCshyjgfZxZjUnpaid;

    /**
     * 业务费_测试化验加工费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_测试化验加工费_自筹_直接")
    private BigDecimal ywfCshyjgfZcZjPaid;

    /**
     * 业务费_测试化验加工费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_测试化验加工费_自筹_直接")
    private BigDecimal ywfCshyjgfZcZjUnpaid;

    /**
     * 业务费_燃料动力费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_燃料动力费_专项_直接")
    private BigDecimal ywfRldlfZxZjPaid;

    /**
     * 业务费_燃料动力费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_燃料动力费_专项_直接")
    private BigDecimal ywfRldlfZxZjUnpaid;

    /**
     * 业务费_燃料动力费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_燃料动力费_自筹_直接")
    private BigDecimal ywfRldlfZcZjPaid;

    /**
     * 业务费_燃料动力费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_燃料动力费_自筹_直接")
    private BigDecimal ywfRldlfZcZjUnpaid;

    /**
     * 业务费_办公费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_办公费_专项_直接")
    private BigDecimal ywfBgfZxZjPaid;

    /**
     * 业务费_办公费_专项_直接
     */
    @UnPaidFieldDescription("业务费_办公费_专项_直接")
    private BigDecimal ywfBgfZxZjUnpaid;

    /**
     * 业务费_办公费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_办公费_自筹_直接")
    private BigDecimal ywfBgfZcZjPaid;

    /**
     * 业务费_办公费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_办公费_自筹_直接")
    private BigDecimal ywfBgfZcZjUnpaid;

    /**
     * 业务费_印刷出版费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_印刷出版费_专项_直接")
    private BigDecimal ywfYscbfZxZjPaid;

    /**
     * 业务费_印刷出版费_专项_直接
     */
    @UnPaidFieldDescription("业务费_印刷出版费_专项_直接")
    private BigDecimal ywfYscbfZxZjUnpaid;

    /**
     * 业务费_印刷出版费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_印刷出版费_自筹_直接")
    private BigDecimal ywfYscbfZcZjPaid;

    /**
     * 业务费_印刷出版费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_印刷出版费_自筹_直接")
    private BigDecimal ywfYscbfZcZjUnpaid;

    /**
     * 业务费_知识产权事务费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_知识产权事务费_专项_直接")
    private BigDecimal ywfZscqswfZxZjPaid;

    /**
     * 业务费_知识产权事务费_专项_直接
     */
    @UnPaidFieldDescription("业务费_知识产权事务费_专项_直接")
    private BigDecimal ywfZscqswfZxZjUnpaid;

    /**
     * 业务费_知识产权事务费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_知识产权事务费_自筹_直接")
    private BigDecimal ywfZscqswfZcZjPaid;

    /**
     * 业务费_知识产权事务费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_知识产权事务费_自筹_直接")
    private BigDecimal ywfZscqswfZcZjUnpaid;

    /**
     * 业务费_车辆使用费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_车辆使用费_专项_直接")
    private BigDecimal ywfClsyfZxZjPaid;

    /**
     * 业务费_车辆使用费_专项_直接
     */
    @UnPaidFieldDescription("业务费_车辆使用费_专项_直接")
    private BigDecimal ywfClsyfZxZjUnpaid;

    /**
     * 业务费_车辆使用费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_车辆使用费_自筹_直接")
    private BigDecimal ywfClsyfZcZjPaid;

    /**
     * 业务费_车辆使用费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_车辆使用费_自筹_直接")
    private BigDecimal ywfClsyfZcZjUnpaid;

    /**
     * 业务费_差旅费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_差旅费_专项_直接")
    private BigDecimal ywfChlfZxZjPaid;

    /**
     * 业务费_差旅费_专项_直接
     */
    @UnPaidFieldDescription("业务费_差旅费_专项_直接")
    private BigDecimal ywfChlfZxZjUnpaid;

    /**
     * 业务费_差旅费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_差旅费_自筹_直接")
    private BigDecimal ywfChlfZcZjPaid;

    /**
     * 业务费_差旅费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_差旅费_自筹_直接")
    private BigDecimal ywfChlfZcZjUnpaid;

    /**
     * 业务费_会议会务费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_会议会务费_专项_直接")
    private BigDecimal ywfHyhwfZxZjPaid;

    /**
     * 业务费_会议会务费_专项_直接
     */
    @UnPaidFieldDescription("业务费_会议会务费_专项_直接")
    private BigDecimal ywfHyhwfZxZjUnpaid;

    /**
     * 业务费_会议会务费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_会议会务费_自筹_直接")
    private BigDecimal ywfHyhwfZcZjPaid;

    /**
     * 业务费_会议会务费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_会议会务费_自筹_直接")
    private BigDecimal ywfHyhwfZcZjUnpaid;

    /**
     * 业务费_国内协作费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_国内协作费_专项_直接")
    private BigDecimal ywfGnxzfZxZjPaid;

    /**
     * 业务费_国内协作费_专项_直接
     */
    @UnPaidFieldDescription("业务费_国内协作费_专项_直接")
    private BigDecimal ywfGnxzfZxZjUnpaid;

    /**
     * 业务费_国内协作费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_国内协作费_自筹_直接")
    private BigDecimal ywfGnxzfZcZjPaid;

    /**
     * 业务费_国内协作费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_国内协作费_自筹_直接")
    private BigDecimal ywfGnxzfZcZjUnpaid;

    /**
     * 业务费_国际合作交流费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_国际合作交流费_专项_直接")
    private BigDecimal ywfGjhzjlfZxZjPaid;

    /**
     * 业务费_国际合作交流费_专项_直接
     */
    @UnPaidFieldDescription("业务费_国际合作交流费_专项_直接")
    private BigDecimal ywfGjhzjlfZxZjUnpaid;

    /**
     * 业务费_国际合作交流费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_国际合作交流费_自筹_直接")
    private BigDecimal ywfGjhzjlfZcZjPaid;

    /**
     * 业务费_国际合作交流费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_国际合作交流费_自筹_直接")
    private BigDecimal ywfGjhzjlfZcZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfZxZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_专项_直接
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfZxZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfZcZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfZcZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_会议费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfHyfZxZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_专项_直接
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_会议费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfHyfZxZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_会议费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfHyfZcZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_会议费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfHyfZcZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_差旅费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfClfZxZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_专项_直接
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_差旅费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfClfZxZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_差旅费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfClfZcZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_差旅费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfClfZcZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_国际合作费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfGjhzfZxZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_专项_直接
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_国际合作费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfGjhzfZxZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_国际合作费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfGjhzfZcZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_国际合作费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfGjhzfZcZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZxZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_专项_直接
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZxZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZcZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZcZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZxZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_专项_直接
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZxZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZcZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZcZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZxZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_专项_直接
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZxZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZcZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZcZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZxZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_专项_直接
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZxZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZcZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZcZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_信息传播费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZxZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_专项_直接
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_信息传播费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZxZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_信息传播费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZcZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_自筹_直接
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_信息传播费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZcZjUnpaid;

    /**
     * 劳务费_专项_直接_已支付
     */
    @PaidFieldDescription("劳务费_专项_直接")
    private BigDecimal lwfZxZjPaid;

    /**
     * 劳务费_专项_直接
     */
    @UnPaidFieldDescription("劳务费_专项_直接")
    private BigDecimal lwfZxZjUnpaid;

    /**
     * 劳务费_自筹_直接_已支付
     */
    @PaidFieldDescription("劳务费_自筹_直接")
    private BigDecimal lwfZcZjPaid;

    /**
     * 劳务费_自筹_直接
     */
    @UnPaidFieldDescription("劳务费_自筹_直接")
    private BigDecimal lwfZcZjUnpaid;

    /**
     * 劳务费_专家咨询费_专项_直接_已支付
     */
    @PaidFieldDescription("劳务费_专家咨询费_专项_直接")
    private BigDecimal lwfZjzxfZxZjPaid;

    /**
     * 劳务费_专家咨询费_专项_直接
     */
    @UnPaidFieldDescription("劳务费_专家咨询费_专项_直接")
    private BigDecimal lwfZjzxfZxZjUnpaid;

    /**
     * 劳务费_专家咨询费_自筹_直接_已支付
     */
    @PaidFieldDescription("劳务费_专家咨询费_自筹_直接")
    private BigDecimal lwfZjzxfZcZjPaid;

    /**
     * 劳务费_专家咨询费_自筹_直接
     */
    @UnPaidFieldDescription("劳务费_专家咨询费_自筹_直接")
    private BigDecimal lwfZjzxfZcZjUnpaid;

    /**
     * 劳务费_人员劳务费_专项_直接_已支付
     */
    @PaidFieldDescription("劳务费_人员劳务费_专项_直接")
    private BigDecimal lwfRylwfZxZjPaid;

    /**
     * 劳务费_人员劳务费_专项_直接
     */
    @UnPaidFieldDescription("劳务费_人员劳务费_专项_直接")
    private BigDecimal lwfRylwfZxZjUnpaid;

    /**
     * 劳务费_人员劳务费_自筹_直接_已支付
     */
    @PaidFieldDescription("劳务费_人员劳务费_自筹_直接")
    private BigDecimal lwfRylwfZcZjPaid;

    /**
     * 劳务费_人员劳务费_自筹_直接
     */
    @UnPaidFieldDescription("劳务费_人员劳务费_自筹_直接")
    private BigDecimal lwfRylwfZcZjUnpaid;

    /**
     * 材料费_专项_直接_已支付
     */
    @PaidFieldDescription("材料费_专项_直接")
    private BigDecimal clfZxZjPaid;

    /**
     * 材料费_专项_直接
     */
    @UnPaidFieldDescription("材料费_专项_直接")
    private BigDecimal clfZxZjUnpaid;

    /**
     * 材料费_自筹_直接_已支付
     */
    @PaidFieldDescription("材料费_自筹_直接")
    private BigDecimal clfZcZjPaid;

    /**
     * 材料费_自筹_直接
     */
    @UnPaidFieldDescription("材料费_自筹_直接")
    private BigDecimal clfZcZjUnpaid;

    /**
     * 材料费_材料费_专项_直接_已支付
     */
    @PaidFieldDescription("材料费_材料费_专项_直接")
    private BigDecimal clfClfZxZjPaid;

    /**
     * 材料费_材料费_专项_直接
     */
    @UnPaidFieldDescription("材料费_材料费_专项_直接")
    private BigDecimal clfClfZxZjUnpaid;

    /**
     * 材料费_材料费_自筹_直接_已支付
     */
    @PaidFieldDescription("材料费_材料费_自筹_直接")
    private BigDecimal clfClfZcZjPaid;

    /**
     * 材料费_材料费_自筹_直接
     */
    @UnPaidFieldDescription("材料费_材料费_自筹_直接")
    private BigDecimal clfClfZcZjUnpaid;

    /**
     * 科研活动费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_专项_直接")
    private BigDecimal kyhdfZxZjPaid;

    /**
     * 科研活动费_专项_直接
     */
    @UnPaidFieldDescription("科研活动费_专项_直接")
    private BigDecimal kyhdfZxZjUnpaid;

    /**
     * 科研活动费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_自筹_直接")
    private BigDecimal kyhdfZcZjPaid;

    /**
     * 科研活动费_自筹_直接
     */
    @UnPaidFieldDescription("科研活动费_自筹_直接")
    private BigDecimal kyhdfZcZjUnpaid;

    /**
     * 科研活动费_资料费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_资料费_专项_直接")
    private BigDecimal kyhdfZlZxZjPaid;

    /**
     * 科研活动费_资料费_专项_直接
     */
    @UnPaidFieldDescription("科研活动费_资料费_专项_直接")
    private BigDecimal kyhdfZlZxZjUnpaid;

    /**
     * 科研活动费_资料费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_资料费_自筹_直接")
    private BigDecimal kyhdfZlZcZjPaid;

    /**
     * 科研活动费_资料费_自筹_直接
     */
    @UnPaidFieldDescription("科研活动费_资料费_自筹_直接")
    private BigDecimal kyhdfZlZcZjUnpaid;

    /**
     * 科研活动费_测试化验加工费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_测试化验加工费_专项_直接")
    private BigDecimal kyhdfCshyjgZxZjPaid;

    /**
     * 科研活动费_测试化验加工费_专项_直接
     */
    @UnPaidFieldDescription("科研活动费_测试化验加工费_专项_直接")
    private BigDecimal kyhdfCshyjgZxZjUnpaid;

    /**
     * 科研活动费_测试化验加工费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_测试化验加工费_自筹_直接")
    private BigDecimal kyhdfCshyjgZcZjPaid;

    /**
     * 科研活动费_测试化验加工费_自筹_直接
     */
    @UnPaidFieldDescription("科研活动费_测试化验加工费_自筹_直接")
    private BigDecimal kyhdfCshyjgZcZjUnpaid;

    /**
     * 科研活动费_办公费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_办公费_专项_直接")
    private BigDecimal kyhdfBgZxZjPaid;

    /**
     * 科研活动费_办公费_专项_直接
     */
    @UnPaidFieldDescription("科研活动费_办公费_专项_直接")
    private BigDecimal kyhdfBgZxZjUnpaid;

    /**
     * 科研活动费_办公费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_办公费_自筹_直接")
    private BigDecimal kyhdfBgZcZjPaid;

    /**
     * 科研活动费_办公费_自筹_直接
     */
    @UnPaidFieldDescription("科研活动费_办公费_自筹_直接")
    private BigDecimal kyhdfBgZcZjUnpaid;

    /**
     * 科研活动费_数据/样本采集费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_数据/样本采集费_专项_直接")
    private BigDecimal kyhdfSjybcjZxZjPaid;

    /**
     * 科研活动费_数据/样本采集费_专项_直接
     */
    @UnPaidFieldDescription("科研活动费_数据/样本采集费_专项_直接")
    private BigDecimal kyhdfSjybcjZxZjUnpaid;

    /**
     * 科研活动费_数据/样本采集费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_数据/样本采集费_自筹_直接")
    private BigDecimal kyhdfSjybcjZcZjPaid;

    /**
     * 科研活动费_数据/样本采集费_自筹_直接
     */
    @UnPaidFieldDescription("科研活动费_数据/样本采集费_自筹_直接")
    private BigDecimal kyhdfSjybcjZcZjUnpaid;

    /**
     * 科研活动费_印刷/出版费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_印刷/出版费_专项_直接")
    private BigDecimal kyhdfYscbZxZjPaid;

    /**
     * 科研活动费_印刷/出版费_专项_直接
     */
    @UnPaidFieldDescription("科研活动费_印刷/出版费_专项_直接")
    private BigDecimal kyhdfYscbZxZjUnpaid;

    /**
     * 科研活动费_印刷/出版费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_印刷/出版费_自筹_直接")
    private BigDecimal kyhdfYscbZcZjPaid;

    /**
     * 科研活动费_印刷/出版费_自筹_直接
     */
    @UnPaidFieldDescription("科研活动费_印刷/出版费_自筹_直接")
    private BigDecimal kyhdfYscbZcZjUnpaid;

    /**
     * 科研活动费_知识产权事务费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_知识产权事务费_专项_直接")
    private BigDecimal kyhdfZscqswZxZjPaid;

    /**
     * 科研活动费_知识产权事务费_专项_直接
     */
    @UnPaidFieldDescription("科研活动费_知识产权事务费_专项_直接")
    private BigDecimal kyhdfZscqswZxZjUnpaid;

    /**
     * 科研活动费_知识产权事务费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_知识产权事务费_自筹_直接")
    private BigDecimal kyhdfZscqswZcZjPaid;

    /**
     * 科研活动费_知识产权事务费_自筹_直接
     */
    @UnPaidFieldDescription("科研活动费_知识产权事务费_自筹_直接")
    private BigDecimal kyhdfZscqswZcZjUnpaid;

    /**
     * 科研活动费_燃料动力费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_燃料动力费_专项_直接")
    private BigDecimal kyhdfRldlZxZjPaid;

    /**
     * 科研活动费_燃料动力费_专项_直接
     */
    @UnPaidFieldDescription("科研活动费_燃料动力费_专项_直接")
    private BigDecimal kyhdfRldlZxZjUnpaid;

    /**
     * 科研活动费_燃料动力费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_燃料动力费_自筹_直接")
    private BigDecimal kyhdfRldlZcZjPaid;

    /**
     * 科研活动费_燃料动力费_自筹_直接
     */
    @UnPaidFieldDescription("科研活动费_燃料动力费_自筹_直接")
    private BigDecimal kyhdfRldlZcZjUnpaid;

    /**
     * 科研活动费_车辆使用费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_车辆使用费_专项_直接")
    private BigDecimal kyhdfClsyZxZjPaid;

    /**
     * 科研活动费_车辆使用费_专项_直接
     */
    @UnPaidFieldDescription("科研活动费_车辆使用费_专项_直接")
    private BigDecimal kyhdfClsyZxZjUnpaid;

    /**
     * 科研活动费_车辆使用费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_车辆使用费_自筹_直接")
    private BigDecimal kyhdfClsyZcZjPaid;

    /**
     * 科研活动费_车辆使用费_自筹_直接
     */
    @UnPaidFieldDescription("科研活动费_车辆使用费_自筹_直接")
    private BigDecimal kyhdfClsyZcZjUnpaid;

    /**
     * 科研服务费_专项_直接_已支付
     */
    @PaidFieldDescription("科研服务费_专项_直接")
    private BigDecimal kyfwfZxZjPaid;

    /**
     * 科研服务费_专项_直接
     */
    @UnPaidFieldDescription("科研服务费_专项_直接")
    private BigDecimal kyfwfZxZjUnpaid;

    /**
     * 科研服务费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研服务费_自筹_直接")
    private BigDecimal kyfwfZcZjPaid;

    /**
     * 科研服务费_自筹_直接
     */
    @UnPaidFieldDescription("科研服务费_自筹_直接")
    private BigDecimal kyfwfZcZjUnpaid;

    /**
     * 科研服务费_专家咨询费_专项_直接_已支付
     */
    @PaidFieldDescription("科研服务费_专家咨询费_专项_直接")
    private BigDecimal kyfwfZjzxZxZjPaid;

    /**
     * 科研服务费_专家咨询费_专项_直接
     */
    @UnPaidFieldDescription("科研服务费_专家咨询费_专项_直接")
    private BigDecimal kyfwfZjzxZxZjUnpaid;

    /**
     * 科研服务费_专家咨询费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研服务费_专家咨询费_自筹_直接")
    private BigDecimal kyfwfZjzxZcZjPaid;

    /**
     * 科研服务费_专家咨询费_自筹_直接
     */
    @UnPaidFieldDescription("科研服务费_专家咨询费_自筹_直接")
    private BigDecimal kyfwfZjzxZcZjUnpaid;

    /**
     * 科研服务费_差旅费_专项_直接_已支付
     */
    @PaidFieldDescription("科研服务费_差旅费_专项_直接")
    private BigDecimal kyfwfClZxZjPaid;

    /**
     * 科研服务费_差旅费_专项_直接
     */
    @UnPaidFieldDescription("科研服务费_差旅费_专项_直接")
    private BigDecimal kyfwfClZxZjUnpaid;

    /**
     * 科研服务费_差旅费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研服务费_差旅费_自筹_直接")
    private BigDecimal kyfwfClZcZjPaid;

    /**
     * 科研服务费_差旅费_自筹_直接
     */
    @UnPaidFieldDescription("科研服务费_差旅费_自筹_直接")
    private BigDecimal kyfwfClZcZjUnpaid;

    /**
     * 科研服务费_会议/会务费_专项_直接_已支付
     */
    @PaidFieldDescription("科研服务费_会议/会务费_专项_直接")
    private BigDecimal kyfwfHyhwZxZjPaid;

    /**
     * 科研服务费_会议/会务费_专项_直接
     */
    @UnPaidFieldDescription("科研服务费_会议/会务费_专项_直接")
    private BigDecimal kyfwfHyhwZxZjUnpaid;

    /**
     * 科研服务费_会议/会务费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研服务费_会议/会务费_自筹_直接")
    private BigDecimal kyfwfHyhwZcZjPaid;

    /**
     * 科研服务费_会议/会务费_自筹_直接
     */
    @UnPaidFieldDescription("科研服务费_会议/会务费_自筹_直接")
    private BigDecimal kyfwfHyhwZcZjUnpaid;

    /**
     * 科研服务费_国际合作交流_专项_直接_已支付
     */
    @PaidFieldDescription("科研服务费_国际合作交流_专项_直接")
    private BigDecimal kyfwfGjhzjlZxZjPaid;

    /**
     * 科研服务费_国际合作交流_专项_直接
     */
    @UnPaidFieldDescription("科研服务费_国际合作交流_专项_直接")
    private BigDecimal kyfwfGjhzjlZxZjUnpaid;

    /**
     * 科研服务费_国际合作交流_自筹_直接_已支付
     */
    @PaidFieldDescription("科研服务费_国际合作交流_自筹_直接")
    private BigDecimal kyfwfGjhzjlZcZjPaid;

    /**
     * 科研服务费_国际合作交流_自筹_直接
     */
    @UnPaidFieldDescription("科研服务费_国际合作交流_自筹_直接")
    private BigDecimal kyfwfGjhzjlZcZjUnpaid;

    /**
     * 科研服务费_国内协作费_专项_直接_已支付
     */
    @PaidFieldDescription("科研服务费_国内协作费_专项_直接")
    private BigDecimal kyfwfGnxzZxZjPaid;

    /**
     * 科研服务费_国内协作费_专项_直接
     */
    @UnPaidFieldDescription("科研服务费_国内协作费_专项_直接")
    private BigDecimal kyfwfGnxzZxZjUnpaid;

    /**
     * 科研服务费_国内协作费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研服务费_国内协作费_自筹_直接")
    private BigDecimal kyfwfGnxzZcZjPaid;

    /**
     * 科研服务费_国内协作费_自筹_直接
     */
    @UnPaidFieldDescription("科研服务费_国内协作费_自筹_直接")
    private BigDecimal kyfwfGnxzZcZjUnpaid;

    /**
     * 人员和劳务补助费_专项_直接_已支付
     */
    @PaidFieldDescription("人员和劳务补助费_专项_直接")
    private BigDecimal ryhlwbzfZxZjPaid;

    /**
     * 人员和劳务补助费_专项_直接
     */
    @UnPaidFieldDescription("人员和劳务补助费_专项_直接")
    private BigDecimal ryhlwbzfZxZjUnpaid;

    /**
     * 人员和劳务补助费_自筹_直接_已支付
     */
    @PaidFieldDescription("人员和劳务补助费_自筹_直接")
    private BigDecimal ryhlwbzfZcZjPaid;

    /**
     * 人员和劳务补助费_自筹_直接
     */
    @UnPaidFieldDescription("人员和劳务补助费_自筹_直接")
    private BigDecimal ryhlwbzfZcZjUnpaid;

    /**
     * 人员和劳务补助费_人员劳务费_专项_直接_已支付
     */
    @PaidFieldDescription("人员和劳务补助费_人员劳务费_专项_直接")
    private BigDecimal ryhlwbzfRylwZxZjPaid;

    /**
     * 人员和劳务补助费_人员劳务费_专项_直接
     */
    @UnPaidFieldDescription("人员和劳务补助费_人员劳务费_专项_直接")
    private BigDecimal ryhlwbzfRylwZxZjUnpaid;

    /**
     * 人员和劳务补助费_人员劳务费_自筹_直接_已支付
     */
    @PaidFieldDescription("人员和劳务补助费_人员劳务费_自筹_直接")
    private BigDecimal ryhlwbzfRylwZcZjPaid;

    /**
     * 人员和劳务补助费_人员劳务费_自筹_直接
     */
    @UnPaidFieldDescription("人员和劳务补助费_人员劳务费_自筹_直接")
    private BigDecimal ryhlwbzfRylwZcZjUnpaid;

    /**
     * 绩效支出_专项_直接_已支付
     */
    @PaidFieldDescription("绩效支出_专项_直接")
    private BigDecimal jxzcZxZjPaid;

    /**
     * 绩效支出_专项_直接
     */
    @UnPaidFieldDescription("绩效支出_专项_直接")
    private BigDecimal jxzcZxZjUnpaid;

    /**
     * 绩效支出_自筹_直接_已支付
     */
    @PaidFieldDescription("绩效支出_自筹_直接")
    private BigDecimal jxzcZcZjPaid;

    /**
     * 绩效支出_自筹_直接
     */
    @UnPaidFieldDescription("绩效支出_自筹_直接")
    private BigDecimal jxzcZcZjUnpaid;

    /**
     * 间接费用_其他支出_专项_已支付
     */
    @PaidFieldDescription("间接费用_其他支出_专项")
    private BigDecimal othersZxPaid;

    /**
     * 间接费用_其他支出_专项
     */
    @UnPaidFieldDescription("间接费用_其他支出_专项")
    private BigDecimal othersZxUnpaid;

    /**
     * 间接费用_其他支出_自筹_已支付
     */
    @PaidFieldDescription("间接费用_其他支出_自筹")
    private BigDecimal othersZcPaid;

    /**
     * 间接费用_其他支出_自筹
     */
    @UnPaidFieldDescription("间接费用_其他支出_自筹")
    private BigDecimal othersZcUnpaid;

    /**
     * 经费来源_专项
     */
    private BigDecimal jflyZx;

    /**
     * 经费来源_自筹
     */
    private BigDecimal jflyZc;

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
     * 设备费_专项_间接
     */
    private BigDecimal sbfZxJj;

    /**
     * 设备费_自筹_间接
     */
    private BigDecimal sbfZcJj;

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
     * 设备费_设备升级改造费_专项_间接
     */
    private BigDecimal sbfSbsjgzZxJj;

    /**
     * 设备费_设备升级改造费_自筹_间接
     */
    private BigDecimal sbfSbsjgzZcJj;

    /**
     * 设备费_设备租赁费_专项_间接
     */
    private BigDecimal sbfSbzlZxJj;

    /**
     * 设备费_设备租赁费_自筹_间接
     */
    private BigDecimal sbfSbzlZcJj;

    /**
     * 劳务费_专项_间接
     */
    private BigDecimal lwfZxJj;

    /**
     * 劳务费_自筹_间接
     */
    private BigDecimal lwfZcJj;

    /**
     * 劳务费_专家咨询费_专项_间接
     */
    private BigDecimal lwfZjzxfZxJj;

    /**
     * 劳务费_专家咨询费_自筹_间接
     */
    private BigDecimal lwfZjzxfZcJj;

    /**
     * 劳务费_人员劳务费_专项_间接
     */
    private BigDecimal lwfRylwfZxJj;

    /**
     * 劳务费_人员劳务费_自筹_间接
     */
    private BigDecimal lwfRylwfZcJj;

    /**
     * 材料费_专项_间接
     */
    private BigDecimal clfZxJj;

    /**
     * 材料费_自筹_间接
     */
    private BigDecimal clfZcJj;

    /**
     * 材料费_材料费_专项_间接
     */
    private BigDecimal clfClfZxJj;

    /**
     * 材料费_材料费_自筹_间接
     */
    private BigDecimal clfClfZcJj;

    /**
     * 科研活动费_专项_间接
     */
    private BigDecimal kyhdfZxJj;

    /**
     * 科研活动费_自筹_间接
     */
    private BigDecimal kyhdfZcJj;

    /**
     * 科研活动费_资料费_专项_间接
     */
    private BigDecimal kyhdfZlZxJj;

    /**
     * 科研活动费_资料费_自筹_间接
     */
    private BigDecimal kyhdfZlZcJj;

    /**
     * 科研活动费_测试化验加工费_专项_间接
     */
    private BigDecimal kyhdfCshyjgZxJj;

    /**
     * 科研活动费_测试化验加工费_自筹_间接
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
     * 科研服务费_专项_间接
     */
    private BigDecimal kyfwfZxJj;

    /**
     * 科研服务费_自筹_间接
     */
    private BigDecimal kyfwfZcJj;

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
     * 科研服务费_会议/会务费_专项_间接
     */
    private BigDecimal kyfwfHyhwZxJj;

    /**
     * 科研服务费_会议/会务费_自筹_间接
     */
    private BigDecimal kyfwfHyhwZcJj;

    /**
     * 科研服务费_国际合作交流_专项_间接
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

    /**
     * 人员和劳务补助费_人员劳务费_专项_间接
     */
    private BigDecimal ryhlwbzfRylwZxJj;

    /**
     * 人员和劳务补助费_人员劳务费_自筹_间接
     */
    private BigDecimal ryhlwbzfRylwZcJj;

    /**
     * 绩效支出_专项_间接
     */
    private BigDecimal jxzcZxJj;

    /**
     * 绩效支出_自筹_间接
     */
    private BigDecimal jxzcZcJj;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
