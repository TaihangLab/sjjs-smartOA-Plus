package com.ruoyi.project.domain.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author bailingnan
 * @date 2024/04/12
 */
@Data
public class ProjectBalanceVO {
    /**
     * 项目经费总额_已支付
     */
    private BigDecimal totalFundsAllPaid;

    /**
     * 项目经费总额_未支付
     */
    private BigDecimal totalFundsAllUnpaid;

    /**
     * 直接经费总额_已支付
     */
    private BigDecimal totalFundsZjPaid;

    /**
     * 直接经费总额_未支付
     */
    private BigDecimal totalFundsZjUnpaid;

    /**
     * 间接经费总额_已支付
     */
    private BigDecimal totalFundsJjPaid;

    /**
     * 间接经费总额_未支付
     */
    private BigDecimal totalFundsJjUnpaid;

    /**
     * 专项经费总额_已支付
     */
    private BigDecimal totalFundsZxPaid;

    /**
     * 专项经费总额_未支付
     */
    private BigDecimal totalFundsZxUnpaid;

    /**
     * 专项设备费_已支付
     */
    private BigDecimal sbfZxPaid;

    /**
     * 专项设备费_未支付
     */
    private BigDecimal sbfZxUnpaid;

    /**
     * 设备费_直接_已支付
     */
    private BigDecimal sbfZjPaid;

    /**
     * 设备费_直接_未支付
     */
    private BigDecimal sbfZjUnpaid;

    /**
     * 专项直接费用_已支付
     */
    private BigDecimal totalFundsZxZjPaid;

    /**
     * 专项直接费用_未支付
     */
    private BigDecimal totalFundsZxZjUnpaid;

    /**
     * 专项间接费用_已支付
     */
    private BigDecimal totalFundsZxJjPaid;

    /**
     * 专项间接费用_未支付
     */
    private BigDecimal totalFundsZxJjUnpaid;

    /**
     * 自筹经费总额_已支付
     */
    private BigDecimal totalFundsZcPaid;

    /**
     * 自筹经费总额_未支付
     */
    private BigDecimal totalFundsZcUnpaid;

    /**
     * 自筹设备费_已支付
     */
    private BigDecimal sbfZcPaid;

    /**
     * 自筹设备费_未支付
     */
    private BigDecimal sbfZcUnpaid;

    /**
     * 自筹直接费用_已支付
     */
    private BigDecimal totalFundsZcZjPaid;

    /**
     * 自筹直接费用_未支付
     */
    private BigDecimal totalFundsZcZjUnpaid;

    /**
     * 自筹间接费用_已支付
     */
    private BigDecimal totalFundsZcJjPaid;

    /**
     * 自筹间接费用_未支付
     */
    private BigDecimal totalFundsZcJjUnpaid;

    /**
     * 设备费_专项_直接_已支付
     */
    private BigDecimal sbfZxZjPaid;

    /**
     * 设备费_专项_直接_未支付
     */
    private BigDecimal sbfZxZjUnpaid;

    /**
     * 设备费_自筹_直接_已支付
     */
    private BigDecimal sbfZcZjPaid;

    /**
     * 设备费_自筹_直接_未支付
     */
    private BigDecimal sbfZcZjUnpaid;

    /**
     * 设备费_购置设备费_直接_已支付
     */
    private BigDecimal sbfGzsbZjPaid;

    /**
     * 设备费_购置设备费_直接_未支付
     */
    private BigDecimal sbfGzsbZjUnpaid;

    /**
     * 设备费_购置设备费_专项_直接_已支付
     */
    private BigDecimal sbfGzsbZxZjPaid;

    /**
     * 设备费_购置设备费_专项_直接_未支付
     */
    private BigDecimal sbfGzsbZxZjUnpaid;

    /**
     * 设备费_购置设备费_自筹_直接_已支付
     */
    private BigDecimal sbfGzsbZcZjPaid;

    /**
     * 设备费_购置设备费_自筹_直接_未支付
     */
    private BigDecimal sbfGzsbZcZjUnpaid;

    /**
     * 设备费_试制设备费_直接_未支付
     */
    private BigDecimal sbfSzsbZjUnpaid;

    /**
     * 设备费_试制设备费_直接_已支付
     */
    private BigDecimal sbfSzsbZjPaid;

    /**
     * 设备费_试制设备费_专项_直接_未支付
     */
    private BigDecimal sbfSzsbZxZjUnpaid;

    /**
     * 设备费_试制设备费_专项_直接_已支付
     */
    private BigDecimal sbfSzsbZxZjPaid;

    /**
     * 设备费_试制设备费_自筹_直接_已支付
     */
    private BigDecimal sbfSzsbZcZjPaid;

    /**
     * 设备费_试制设备费_自筹_直接_未支付
     */
    private BigDecimal sbfSzsbZcZjUnpaid;

    /**
     * 设备费_设备升级改造费_直接_已支付
     */
    private BigDecimal sbfSbsjgzZjPaid;

    /**
     * 设备费_设备升级改造费_直接_未支付
     */
    private BigDecimal sbfSbsjgzZjUnpaid;

    /**
     * 设备费_设备升级改造费_专项_直接_已支付
     */
    private BigDecimal sbfSbsjgzZxZjPaid;

    /**
     * 设备费_设备升级改造费_专项_直接_未支付
     */
    private BigDecimal sbfSbsjgzZxZjUnpaid;

    /**
     * 设备费_设备升级改造费_自筹_直接_已支付
     */
    private BigDecimal sbfSbsjgzZcZjPaid;

    /**
     * 设备费_设备升级改造费_自筹_直接_未支付
     */
    private BigDecimal sbfSbsjgzZcZjUnpaid;

    /**
     * 设备费_设备租赁费_直接_已支付
     */
    private BigDecimal sbfSbzlZjPaid;

    /**
     * 设备费_设备租赁费_直接_未支付
     */
    private BigDecimal sbfSbzlZjUnpaid;

    /**
     * 设备费_设备租赁费_专项_直接_已支付
     */
    private BigDecimal sbfSbzlZxZjPaid;

    /**
     * 设备费_设备租赁费_专项_直接_未支付
     */
    private BigDecimal sbfSbzlZxZjUnpaid;

    /**
     * 设备费_设备租赁费_自筹_直接_已支付
     */
    private BigDecimal sbfSbzlZcZjPaid;

    /**
     * 设备费_设备租赁费_自筹_直接_未支付
     */
    private BigDecimal sbfSbzlZcZjUnpaid;

    /**
     * 业务费_直接_已支付
     */
    private BigDecimal ywfZjPaid;

    /**
     * 业务费_直接_未支付
     */
    private BigDecimal ywfZjUnpaid;

    /**
     * 业务费_专项_直接_已支付
     */
    private BigDecimal ywfZxZjPaid;

    /**
     * 业务费_专项_直接_未支付
     */
    private BigDecimal ywfZxZjUnpaid;

    /**
     * 业务费_自筹_直接_已支付
     */
    private BigDecimal ywfZcZjPaid;

    /**
     * 业务费_自筹_直接_未支付
     */
    private BigDecimal ywfZcZjUnpaid;

    /**
     * 业务费_材料费_直接_已支付
     */
    private BigDecimal ywfClfZjPaid;

    /**
     * 业务费_材料费_直接_未支付
     */
    private BigDecimal ywfClfZjUnpaid;

    /**
     * 业务费_材料费_专项_直接_已支付
     */
    private BigDecimal ywfClfZxZjPaid;

    /**
     * 业务费_材料费_专项_直接_未支付
     */
    private BigDecimal ywfClfZxZjUnpaid;

    /**
     * 业务费_材料费_自筹_直接_已支付
     */
    private BigDecimal ywfClfZcZjPaid;

    /**
     * 业务费_材料费_自筹_直接_未支付
     */
    private BigDecimal ywfClfZcZjUnpaid;

    /**
     * 业务费_资料费_直接_已支付
     */
    private BigDecimal ywfZlfZjPaid;

    /**
     * 业务费_资料费_直接_未支付
     */
    private BigDecimal ywfZlfZjUnpaid;

    /**
     * 业务费_资料费_专项_直接_已支付
     */
    private BigDecimal ywfZlfZxZjPaid;

    /**
     * 业务费_资料费_专项_直接_未支付
     */
    private BigDecimal ywfZlfZxZjUnpaid;

    /**
     * 业务费_资料费_自筹_直接_已支付
     */
    private BigDecimal ywfZlfZcZjPaid;

    /**
     * 业务费_资料费_自筹_直接_未支付
     */
    private BigDecimal ywfZlfZcZjUnpaid;

    /**
     * 业务费_数据样本采集费_直接_已支付
     */
    private BigDecimal ywfSjybcjfZjPaid;

    /**
     * 业务费_数据样本采集费_直接_未支付
     */
    private BigDecimal ywfSjybcjfZjUnpaid;

    /**
     * 业务费_数据样本采集费_专项_直接_已支付
     */
    private BigDecimal ywfSjybcjfZxZjPaid;

    /**
     * 业务费_数据样本采集费_专项_直接_未支付
     */
    private BigDecimal ywfSjybcjfZxZjUnpaid;

    /**
     * 业务费_数据样本采集费_自筹_直接_已支付
     */
    private BigDecimal ywfSjybcjfZcZjPaid;

    /**
     * 业务费_数据样本采集费_自筹_直接_未支付
     */
    private BigDecimal ywfSjybcjfZcZjUnpaid;

    /**
     * 业务费_测试化验加工费_直接_已支付
     */
    private BigDecimal ywfCshyjgfZjPaid;

    /**
     * 业务费_测试化验加工费_直接_未支付
     */
    private BigDecimal ywfCshyjgfZjUnpaid;

    /**
     * 业务费_测试化验加工费_专项_直接_已支付
     */
    private BigDecimal ywfCshyjgfZxZjPaid;

    /**
     * 业务费_测试化验加工费_专项_直接_未支付
     */
    private BigDecimal ywfCshyjgfZxZjUnpaid;

    /**
     * 业务费_测试化验加工费_自筹_直接_已支付
     */
    private BigDecimal ywfCshyjgfZcZjPaid;

    /**
     * 业务费_测试化验加工费_自筹_直接_未支付
     */
    private BigDecimal ywfCshyjgfZcZjUnpaid;

    /**
     * 业务费_燃料动力费_直接_已支付
     */
    private BigDecimal ywfRldlfZjPaid;

    /**
     * 业务费_燃料动力费_直接_未支付
     */
    private BigDecimal ywfRldlfZjUnpaid;

    /**
     * 业务费_燃料动力费_专项_直接_已支付
     */
    private BigDecimal ywfRldlfZxZjPaid;

    /**
     * 业务费_燃料动力费_专项_直接_未支付
     */
    private BigDecimal ywfRldlfZxZjUnpaid;

    /**
     * 业务费_燃料动力费_自筹_直接_已支付
     */
    private BigDecimal ywfRldlfZcZjPaid;

    /**
     * 业务费_燃料动力费_自筹_直接_未支付
     */
    private BigDecimal ywfRldlfZcZjUnpaid;

    /**
     * 业务费_办公费_直接_已支付
     */
    private BigDecimal ywfBgfZjPaid;

    /**
     * 业务费_办公费_直接_未支付
     */
    private BigDecimal ywfBgfZjUnpaid;

    /**
     * 业务费_办公费_专项_直接_已支付
     */
    private BigDecimal ywfBgfZxZjPaid;

    /**
     * 业务费_办公费_专项_直接_未支付
     */
    private BigDecimal ywfBgfZxZjUnpaid;

    /**
     * 业务费_办公费_自筹_直接_已支付
     */
    private BigDecimal ywfBgfZcZjPaid;

    /**
     * 业务费_办公费_自筹_直接_未支付
     */
    private BigDecimal ywfBgfZcZjUnpaid;

    /**
     * 业务费_印刷出版费_直接_已支付
     */
    private BigDecimal ywfYscbfZjPaid;

    /**
     * 业务费_印刷出版费_直接_未支付
     */
    private BigDecimal ywfYscbfZjUnpaid;

    /**
     * 业务费_印刷出版费_专项_直接_已支付
     */
    private BigDecimal ywfYscbfZxZjPaid;

    /**
     * 业务费_印刷出版费_专项_直接_未支付
     */
    private BigDecimal ywfYscbfZxZjUnpaid;

    /**
     * 业务费_印刷出版费_自筹_直接_已支付
     */
    private BigDecimal ywfYscbfZcZjPaid;

    /**
     * 业务费_印刷出版费_自筹_直接_未支付
     */
    private BigDecimal ywfYscbfZcZjUnpaid;

    /**
     * 业务费_知识产权事务费_直接_已支付
     */
    private BigDecimal ywfZscqswfZjPaid;

    /**
     * 业务费_知识产权事务费_直接_未支付
     */
    private BigDecimal ywfZscqswfZjUnpaid;

    /**
     * 业务费_知识产权事务费_专项_直接_已支付
     */
    private BigDecimal ywfZscqswfZxZjPaid;

    /**
     * 业务费_知识产权事务费_专项_直接_未支付
     */
    private BigDecimal ywfZscqswfZxZjUnpaid;

    /**
     * 业务费_知识产权事务费_自筹_直接_已支付
     */
    private BigDecimal ywfZscqswfZcZjPaid;

    /**
     * 业务费_知识产权事务费_自筹_直接_未支付
     */
    private BigDecimal ywfZscqswfZcZjUnpaid;

    /**
     * 业务费_车辆使用费_直接_已支付
     */
    private BigDecimal ywfClsyfZjPaid;

    /**
     * 业务费_车辆使用费_直接_已支付
     */
    private BigDecimal ywfClsyfZjUnpaid;

    /**
     * 业务费_车辆使用费_专项_直接_已支付
     */
    private BigDecimal ywfClsyfZxZjPaid;

    /**
     * 业务费_车辆使用费_专项_直接_未支付
     */
    private BigDecimal ywfClsyfZxZjUnpaid;

    /**
     * 业务费_车辆使用费_自筹_直接_已支付
     */
    private BigDecimal ywfClsyfZcZjPaid;

    /**
     * 业务费_车辆使用费_自筹_直接_未支付
     */
    private BigDecimal ywfClsyfZcZjUnpaid;

    /**
     * 业务费_差旅费_直接_已支付
     */
    private BigDecimal ywfChlfZjPaid;

    /**
     * 业务费_差旅费_直接_未支付
     */
    private BigDecimal ywfChlfZjUnpaid;

    /**
     * 业务费_差旅费_专项_直接_已支付
     */
    private BigDecimal ywfChlfZxZjPaid;

    /**
     * 业务费_差旅费_专项_直接_未支付
     */
    private BigDecimal ywfChlfZxZjUnpaid;

    /**
     * 业务费_差旅费_自筹_直接_已支付
     */
    private BigDecimal ywfChlfZcZjPaid;

    /**
     * 业务费_差旅费_自筹_直接_未支付
     */
    private BigDecimal ywfChlfZcZjUnpaid;

    /**
     * 业务费_会议会务费_直接_已支付
     */
    private BigDecimal ywfHyhwfZjPaid;

    /**
     * 业务费_会议会务费_直接_未支付
     */
    private BigDecimal ywfHyhwfZjUnpaid;

    /**
     * 业务费_会议会务费_专项_直接_已支付
     */
    private BigDecimal ywfHyhwfZxZjPaid;

    /**
     * 业务费_会议会务费_专项_直接_未支付
     */
    private BigDecimal ywfHyhwfZxZjUnpaid;

    /**
     * 业务费_会议会务费_自筹_直接_已支付
     */
    private BigDecimal ywfHyhwfZcZjPaid;

    /**
     * 业务费_会议会务费_自筹_直接_未支付
     */
    private BigDecimal ywfHyhwfZcZjUnpaid;

    /**
     * 业务费_国内协作费_直接_已支付
     */
    private BigDecimal ywfGnxzfZjPaid;

    /**
     * 业务费_国内协作费_直接_未支付
     */
    private BigDecimal ywfGnxzfZjUnpaid;

    /**
     * 业务费_国内协作费_专项_直接_已支付
     */
    private BigDecimal ywfGnxzfZxZjPaid;

    /**
     * 业务费_国内协作费_专项_直接_未支付
     */
    private BigDecimal ywfGnxzfZxZjUnpaid;

    /**
     * 业务费_国内协作费_自筹_直接_已支付
     */
    private BigDecimal ywfGnxzfZcZjPaid;

    /**
     * 业务费_国内协作费_自筹_直接_未支付
     */
    private BigDecimal ywfGnxzfZcZjUnpaid;

    /**
     * 业务费_国际合作交流费_直接_已支付
     */
    private BigDecimal ywfGjhzjlfZjPaid;

    /**
     * 业务费_国际合作交流费_直接_未支付
     */
    private BigDecimal ywfGjhzjlfZjUnpaid;

    /**
     * 业务费_国际合作交流费_专项_直接_已支付
     */
    private BigDecimal ywfGjhzjlfZxZjPaid;

    /**
     * 业务费_国际合作交流费_专项_直接_未支付
     */
    private BigDecimal ywfGjhzjlfZxZjUnpaid;

    /**
     * 业务费_国际合作交流费_自筹_直接_已支付
     */
    private BigDecimal ywfGjhzjlfZcZjPaid;

    /**
     * 业务费_国际合作交流费_自筹_直接_未支付
     */
    private BigDecimal ywfGjhzjlfZcZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_直接_已支付
     */
    private BigDecimal ywfHyclgjhzyjlfZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_直接_未支付
     */
    private BigDecimal ywfHyclgjhzyjlfZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_专项_直接_已支付
     */
    private BigDecimal ywfHyclgjhzyjlfZxZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_专项_直接_未支付
     */
    private BigDecimal ywfHyclgjhzyjlfZxZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_自筹_直接_已支付
     */
    private BigDecimal ywfHyclgjhzyjlfZcZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_自筹_直接_未支付
     */
    private BigDecimal ywfHyclgjhzyjlfZcZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_直接_已支付
     */
    private BigDecimal ywfHyclgjhzyjlfHyfZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_直接_未支付
     */
    private BigDecimal ywfHyclgjhzyjlfHyfZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_专项_直接_已支付
     */
    private BigDecimal ywfHyclgjhzyjlfHyfZxZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_专项_直接_未支付
     */
    private BigDecimal ywfHyclgjhzyjlfHyfZxZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_自筹_直接_已支付
     */
    private BigDecimal ywfHyclgjhzyjlfHyfZcZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_自筹_直接_未支付
     */
    private BigDecimal ywfHyclgjhzyjlfHyfZcZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_直接_已支付
     */
    private BigDecimal ywfHyclgjhzyjlfClfZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_直接_未支付
     */
    private BigDecimal ywfHyclgjhzyjlfClfZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_专项_直接_已支付
     */
    private BigDecimal ywfHyclgjhzyjlfClfZxZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_专项_直接_未支付
     */
    private BigDecimal ywfHyclgjhzyjlfClfZxZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_自筹_直接_已支付
     */
    private BigDecimal ywfHyclgjhzyjlfClfZcZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_自筹_直接_未支付
     */
    private BigDecimal ywfHyclgjhzyjlfClfZcZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_直接_已支付
     */
    private BigDecimal ywfHyclgjhzyjlfGjhzfZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_直接_未支付
     */
    private BigDecimal ywfHyclgjhzyjlfGjhzfZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_专项_直接_已支付
     */
    private BigDecimal ywfHyclgjhzyjlfGjhzfZxZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_专项_直接_未支付
     */
    private BigDecimal ywfHyclgjhzyjlfGjhzfZxZjUnpaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_自筹_直接_已支付
     */
    private BigDecimal ywfHyclgjhzyjlfGjhzfZcZjPaid;

    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_自筹_直接_未支付
     */
    private BigDecimal ywfHyclgjhzyjlfGjhzfZcZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_直接_已支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_直接_未支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_专项_直接_已支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfZxZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_专项_直接_未支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfZxZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_自筹_直接_已支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfZcZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_自筹_直接_未支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfZcZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_直接_已支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_直接_未支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_专项_直接_已支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZxZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_专项_直接_未支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZxZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_自筹_直接_已支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZcZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_自筹_直接_未支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZcZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_直接_已支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_直接_未支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_专项_直接_已支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZxZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_专项_直接_未支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZxZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_自筹_直接_已支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZcZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_自筹_直接_未支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZcZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_直接_已支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_直接_未支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_专项_直接_已支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZxZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_专项_直接_未支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZxZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_自筹_直接_已支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZcZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_自筹_直接_未支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZcZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_直接_已支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_直接_未支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_专项_直接_已支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZxZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_专项_直接_未支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZxZjUnpaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_自筹_直接_已支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZcZjPaid;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_自筹_直接_未支付
     */
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZcZjUnpaid;

    /**
     * 劳务费_直接_已支付
     */
    private BigDecimal lwfZjPaid;

    /**
     * 劳务费_直接_未支付
     */
    private BigDecimal lwfZjUnpaid;

    /**
     * 劳务费_专项_直接_已支付
     */
    private BigDecimal lwfZxZjPaid;

    /**
     * 劳务费_专项_直接_未支付
     */
    private BigDecimal lwfZxZjUnpaid;

    /**
     * 劳务费_自筹_直接_已支付
     */
    private BigDecimal lwfZcZjPaid;

    /**
     * 劳务费_自筹_直接_未支付
     */
    private BigDecimal lwfZcZjUnpaid;

    /**
     * 劳务费_专家咨询费_直接_已支付
     */
    private BigDecimal lwfZjzxfZjPaid;

    /**
     * 劳务费_专家咨询费_直接_未支付
     */
    private BigDecimal lwfZjzxfZjUnpaid;

    /**
     * 劳务费_专家咨询费_专项_直接_已支付
     */
    private BigDecimal lwfZjzxfZxZjPaid;

    /**
     * 劳务费_专家咨询费_专项_直接_未支付
     */
    private BigDecimal lwfZjzxfZxZjUnpaid;

    /**
     * 劳务费_专家咨询费_自筹_直接_已支付
     */
    private BigDecimal lwfZjzxfZcZjPaid;

    /**
     * 劳务费_专家咨询费_自筹_直接_未支付
     */
    private BigDecimal lwfZjzxfZcZjUnpaid;

    /**
     * 劳务费_人员劳务费_直接_已支付
     */
    private BigDecimal lwfRylwfZjPaid;

    /**
     * 劳务费_人员劳务费_直接_未支付
     */
    private BigDecimal lwfRylwfZjUnpaid;

    /**
     * 劳务费_人员劳务费_专项_直接_已支付
     */
    private BigDecimal lwfRylwfZxZjPaid;

    /**
     * 劳务费_人员劳务费_专项_直接_未支付
     */
    private BigDecimal lwfRylwfZxZjUnpaid;

    /**
     * 劳务费_人员劳务费_自筹_直接_已支付
     */
    private BigDecimal lwfRylwfZcZjPaid;

    /**
     * 劳务费_人员劳务费_自筹_直接_未支付
     */
    private BigDecimal lwfRylwfZcZjUnpaid;

    /**
     * 材料费_直接_已支付
     */
    private BigDecimal clfZjPaid;

    /**
     * 材料费_直接_未支付
     */
    private BigDecimal clfZjUnpaid;

    /**
     * 材料费_专项_直接_已支付
     */
    private BigDecimal clfZxZjPaid;

    /**
     * 材料费_专项_直接_未支付
     */
    private BigDecimal clfZxZjUnpaid;

    /**
     * 材料费_自筹_直接_已支付
     */
    private BigDecimal clfZcZjPaid;

    /**
     * 材料费_自筹_直接_未支付
     */
    private BigDecimal clfZcZjUnpaid;

    /**
     * 材料费_材料费_直接_已支付
     */
    private BigDecimal clfClfZjPaid;

    /**
     * 材料费_材料费_直接_未支付
     */
    private BigDecimal clfClfZjUnpaid;

    /**
     * 材料费_材料费_专项_直接_已支付
     */
    private BigDecimal clfClfZxZjPaid;

    /**
     * 材料费_材料费_专项_直接_未支付
     */
    private BigDecimal clfClfZxZjUnpaid;

    /**
     * 材料费_材料费_自筹_直接_已支付
     */
    private BigDecimal clfClfZcZjPaid;

    /**
     * 材料费_材料费_自筹_直接_未支付
     */
    private BigDecimal clfClfZcZjUnpaid;

    /**
     * 科研活动费_直接_已支付
     */
    private BigDecimal kyhdfZjPaid;

    /**
     * 科研活动费_直接_未支付
     */
    private BigDecimal kyhdfZjUnpaid;

    /**
     * 科研活动费_专项_直接_已支付
     */
    private BigDecimal kyhdfZxZjPaid;

    /**
     * 科研活动费_专项_直接_未支付
     */
    private BigDecimal kyhdfZxZjUnpaid;

    /**
     * 科研活动费_自筹_直接_已支付
     */
    private BigDecimal kyhdfZcZjPaid;

    /**
     * 科研活动费_自筹_直接_未支付
     */
    private BigDecimal kyhdfZcZjUnpaid;

    /**
     * 科研活动费_资料费_直接_已支付
     */
    private BigDecimal kyhdfZlZjPaid;

    /**
     * 科研活动费_资料费_直接_未支付
     */
    private BigDecimal kyhdfZlZjUnpaid;

    /**
     * 科研活动费_资料费_专项_直接_已支付
     */
    private BigDecimal kyhdfZlZxZjPaid;

    /**
     * 科研活动费_资料费_专项_直接_未支付
     */
    private BigDecimal kyhdfZlZxZjUnpaid;

    /**
     * 科研活动费_资料费_自筹_直接_已支付
     */
    private BigDecimal kyhdfZlZcZjPaid;

    /**
     * 科研活动费_资料费_自筹_直接_未支付
     */
    private BigDecimal kyhdfZlZcZjUnpaid;

    /**
     * 科研活动费_测试化验加工费_直接_已支付
     */
    private BigDecimal kyhdfCshyjgZjPaid;

    /**
     * 科研活动费_测试化验加工费_直接_未支付
     */
    private BigDecimal kyhdfCshyjgZjUnpaid;

    /**
     * 科研活动费_测试化验加工费_专项_直接_已支付
     */
    private BigDecimal kyhdfCshyjgZxZjPaid;

    /**
     * 科研活动费_测试化验加工费_专项_直接_未支付
     */
    private BigDecimal kyhdfCshyjgZxZjUnpaid;

    /**
     * 科研活动费_测试化验加工费_自筹_直接_已支付
     */
    private BigDecimal kyhdfCshyjgZcZjPaid;

    /**
     * 科研活动费_测试化验加工费_自筹_直接_未支付
     */
    private BigDecimal kyhdfCshyjgZcZjUnpaid;

    /**
     * 科研活动费_办公费_直接_已支付
     */
    private BigDecimal kyhdfBgZjPaid;

    /**
     * 科研活动费_办公费_直接_未支付
     */
    private BigDecimal kyhdfBgZjUnpaid;

    /**
     * 科研活动费_办公费_专项_直接_已支付
     */
    private BigDecimal kyhdfBgZxZjPaid;

    /**
     * 科研活动费_办公费_专项_直接_未支付
     */
    private BigDecimal kyhdfBgZxZjUnpaid;

    /**
     * 科研活动费_办公费_自筹_直接_已支付
     */
    private BigDecimal kyhdfBgZcZjPaid;

    /**
     * 科研活动费_办公费_自筹_直接_未支付
     */
    private BigDecimal kyhdfBgZcZjUnpaid;

    /**
     * 科研活动费_数据/样本采集费_直接_已支付
     */
    private BigDecimal kyhdfSjybcjZjPaid;

    /**
     * 科研活动费_数据/样本采集费_直接_未支付
     */
    private BigDecimal kyhdfSjybcjZjUnpaid;

    /**
     * 科研活动费_数据/样本采集费_专项_直接_已支付
     */
    private BigDecimal kyhdfSjybcjZxZjPaid;

    /**
     * 科研活动费_数据/样本采集费_专项_直接_未支付
     */
    private BigDecimal kyhdfSjybcjZxZjUnpaid;

    /**
     * 科研活动费_数据/样本采集费_自筹_直接_已支付
     */
    private BigDecimal kyhdfSjybcjZcZjPaid;

    /**
     * 科研活动费_数据/样本采集费_自筹_直接_未支付
     */
    private BigDecimal kyhdfSjybcjZcZjUnpaid;

    /**
     * 科研活动费_印刷/出版费_直接_已支付
     */
    private BigDecimal kyhdfYscbZjPaid;

    /**
     * 科研活动费_印刷/出版费_直接_未支付
     */
    private BigDecimal kyhdfYscbZjUnpaid;

    /**
     * 科研活动费_印刷/出版费_专项_直接_已支付
     */
    private BigDecimal kyhdfYscbZxZjPaid;

    /**
     * 科研活动费_印刷/出版费_专项_直接_未支付
     */
    private BigDecimal kyhdfYscbZxZjUnpaid;

    /**
     * 科研活动费_印刷/出版费_自筹_直接_已支付
     */
    private BigDecimal kyhdfYscbZcZjPaid;

    /**
     * 科研活动费_印刷/出版费_自筹_直接_未支付
     */
    private BigDecimal kyhdfYscbZcZjUnpaid;

    /**
     * 科研活动费_知识产权事务费_直接_已支付
     */
    private BigDecimal kyhdfZscqswZjPaid;

    /**
     * 科研活动费_知识产权事务费_直接_未支付
     */
    private BigDecimal kyhdfZscqswZjUnpaid;

    /**
     * 科研活动费_知识产权事务费_专项_直接_已支付
     */
    private BigDecimal kyhdfZscqswZxZjPaid;

    /**
     * 科研活动费_知识产权事务费_专项_直接_未支付
     */
    private BigDecimal kyhdfZscqswZxZjUnpaid;

    /**
     * 科研活动费_知识产权事务费_自筹_直接_已支付
     */
    private BigDecimal kyhdfZscqswZcZjPaid;

    /**
     * 科研活动费_知识产权事务费_自筹_直接_未支付
     */
    private BigDecimal kyhdfZscqswZcZjUnpaid;

    /**
     * 科研活动费_燃料动力费_直接_已支付
     */
    private BigDecimal kyhdfRldlZjPaid;

    /**
     * 科研活动费_燃料动力费_直接_未支付
     */
    private BigDecimal kyhdfRldlZjUnpaid;

    /**
     * 科研活动费_燃料动力费_专项_直接_已支付
     */
    private BigDecimal kyhdfRldlZxZjPaid;

    /**
     * 科研活动费_燃料动力费_专项_直接_未支付
     */
    private BigDecimal kyhdfRldlZxZjUnpaid;

    /**
     * 科研活动费_燃料动力费_自筹_直接_已支付
     */
    private BigDecimal kyhdfRldlZcZjPaid;

    /**
     * 科研活动费_燃料动力费_自筹_直接_未支付
     */
    private BigDecimal kyhdfRldlZcZjUnpaid;

    /**
     * 科研活动费_车辆使用费_直接_已支付
     */
    private BigDecimal kyhdfClsyZjPaid;

    /**
     * 科研活动费_车辆使用费_直接_未支付
     */
    private BigDecimal kyhdfClsyZjUnpaid;

    /**
     * 科研活动费_车辆使用费_专项_直接_已支付
     */
    private BigDecimal kyhdfClsyZxZjPaid;

    /**
     * 科研活动费_车辆使用费_专项_直接_未支付
     */
    private BigDecimal kyhdfClsyZxZjUnpaid;

    /**
     * 科研活动费_车辆使用费_自筹_直接_已支付
     */
    private BigDecimal kyhdfClsyZcZjPaid;

    /**
     * 科研活动费_车辆使用费_自筹_直接_未支付
     */
    private BigDecimal kyhdfClsyZcZjUnpaid;

    /**
     * 科研服务费_直接_已支付
     */
    private BigDecimal kyfwfZjPaid;

    /**
     * 科研服务费_直接_未支付
     */
    private BigDecimal kyfwfZjUnpaid;

    /**
     * 科研服务费_专项_直接_已支付
     */
    private BigDecimal kyfwfZxZjPaid;

    /**
     * 科研服务费_专项_直接_未支付
     */
    private BigDecimal kyfwfZxZjUnpaid;

    /**
     * 科研服务费_自筹_直接_已支付
     */
    private BigDecimal kyfwfZcZjPaid;

    /**
     * 科研服务费_自筹_直接_未支付
     */
    private BigDecimal kyfwfZcZjUnpaid;

    /**
     * 科研服务费_专家咨询费_直接_已支付
     */
    private BigDecimal kyfwfZjzxZjPaid;

    /**
     * 科研服务费_专家咨询费_直接_未支付
     */
    private BigDecimal kyfwfZjzxZjUnpaid;

    /**
     * 科研服务费_专家咨询费_专项_直接_已支付
     */
    private BigDecimal kyfwfZjzxZxZjPaid;

    /**
     * 科研服务费_专家咨询费_专项_直接_未支付
     */
    private BigDecimal kyfwfZjzxZxZjUnpaid;

    /**
     * 科研服务费_专家咨询费_自筹_直接_已支付
     */
    private BigDecimal kyfwfZjzxZcZjPaid;

    /**
     * 科研服务费_专家咨询费_自筹_直接_未支付
     */
    private BigDecimal kyfwfZjzxZcZjUnpaid;

    /**
     * 科研服务费_差旅费_直接_已支付
     */
    private BigDecimal kyfwfClZjPaid;

    /**
     * 科研服务费_差旅费_直接_未支付
     */
    private BigDecimal kyfwfClZjUnpaid;

    /**
     * 科研服务费_差旅费_专项_直接_已支付
     */
    private BigDecimal kyfwfClZxZjPaid;

    /**
     * 科研服务费_差旅费_专项_直接_未支付
     */
    private BigDecimal kyfwfClZxZjUnpaid;

    /**
     * 科研服务费_差旅费_自筹_直接_已支付
     */
    private BigDecimal kyfwfClZcZjPaid;

    /**
     * 科研服务费_差旅费_自筹_直接_未支付
     */
    private BigDecimal kyfwfClZcZjUnpaid;

    /**
     * 科研服务费_会议/会务费_直接_已支付
     */
    private BigDecimal kyfwfHyhwZjPaid;

    /**
     * 科研服务费_会议/会务费_直接_未支付
     */
    private BigDecimal kyfwfHyhwZjUnpaid;

    /**
     * 科研服务费_会议/会务费_专项_直接_已支付
     */
    private BigDecimal kyfwfHyhwZxZjPaid;

    /**
     * 科研服务费_会议/会务费_专项_直接_未支付
     */
    private BigDecimal kyfwfHyhwZxZjUnpaid;

    /**
     * 科研服务费_会议/会务费_自筹_直接_已支付
     */
    private BigDecimal kyfwfHyhwZcZjPaid;

    /**
     * 科研服务费_会议/会务费_自筹_直接_未支付
     */
    private BigDecimal kyfwfHyhwZcZjUnpaid;

    /**
     * 科研服务费_国际合作交流_直接_已支付
     */
    private BigDecimal kyfwfGjhzjlZjPaid;

    /**
     * 科研服务费_国际合作交流_直接_未支付
     */
    private BigDecimal kyfwfGjhzjlZjUnpaid;

    /**
     * 科研服务费_国际合作交流_专项_直接_已支付
     */
    private BigDecimal kyfwfGjhzjlZxZjPaid;

    /**
     * 科研服务费_国际合作交流_专项_直接_未支付
     */
    private BigDecimal kyfwfGjhzjlZxZjUnpaid;

    /**
     * 科研服务费_国际合作交流_自筹_直接_已支付
     */
    private BigDecimal kyfwfGjhzjlZcZjPaid;

    /**
     * 科研服务费_国际合作交流_自筹_直接_未支付
     */
    private BigDecimal kyfwfGjhzjlZcZjUnpaid;

    /**
     * 科研服务费_国内协作费_直接_已支付
     */
    private BigDecimal kyfwfGnxzZjPaid;

    /**
     * 科研服务费_国内协作费_直接_未支付
     */
    private BigDecimal kyfwfGnxzZjUnpaid;

    /**
     * 科研服务费_国内协作费_专项_直接_已支付
     */
    private BigDecimal kyfwfGnxzZxZjPaid;

    /**
     * 科研服务费_国内协作费_专项_直接_未支付
     */
    private BigDecimal kyfwfGnxzZxZjUnpaid;

    /**
     * 科研服务费_国内协作费_自筹_直接_已支付
     */
    private BigDecimal kyfwfGnxzZcZjPaid;

    /**
     * 科研服务费_国内协作费_自筹_直接_未支付
     */
    private BigDecimal kyfwfGnxzZcZjUnpaid;

    /**
     * 人员和劳务补助费_直接_已支付
     */
    private BigDecimal ryhlwbzfZjPaid;

    /**
     * 人员和劳务补助费_直接_未支付
     */
    private BigDecimal ryhlwbzfZjUnpaid;

    /**
     * 人员和劳务补助费_专项_直接_已支付
     */
    private BigDecimal ryhlwbzfZxZjPaid;

    /**
     * 人员和劳务补助费_专项_直接_未支付
     */
    private BigDecimal ryhlwbzfZxZjUnpaid;

    /**
     * 人员和劳务补助费_自筹_直接_已支付
     */
    private BigDecimal ryhlwbzfZcZjPaid;

    /**
     * 人员和劳务补助费_自筹_直接_未支付
     */
    private BigDecimal ryhlwbzfZcZjUnpaid;

    /**
     * 人员和劳务补助费_人员劳务费_直接_已支付
     */
    private BigDecimal ryhlwbzfRylwZjPaid;

    /**
     * 人员和劳务补助费_人员劳务费_直接_未支付
     */
    private BigDecimal ryhlwbzfRylwZjUnpaid;

    /**
     * 人员和劳务补助费_人员劳务费_专项_直接_已支付
     */
    private BigDecimal ryhlwbzfRylwZxZjPaid;

    /**
     * 人员和劳务补助费_人员劳务费_专项_直接_未支付
     */
    private BigDecimal ryhlwbzfRylwZxZjUnpaid;

    /**
     * 人员和劳务补助费_人员劳务费_自筹_直接_已支付
     */
    private BigDecimal ryhlwbzfRylwZcZjPaid;

    /**
     * 人员和劳务补助费_人员劳务费_自筹_直接_未支付
     */
    private BigDecimal ryhlwbzfRylwZcZjUnpaid;

    /**
     * 绩效支出_间接_已支付
     */
    private BigDecimal jxzcJjPaid;

    /**
     * 绩效支出_间接_未支付
     */
    private BigDecimal jxzcJjUnpaid;

    /**
     * 绩效支出_专项_间接_已支付
     */
    private BigDecimal jxzcZxJjPaid;

    /**
     * 绩效支出_专项_间接_未支付
     */
    private BigDecimal jxzcZxJjUnpaid;

    /**
     * 绩效支出_自筹_间接_已支付
     */
    private BigDecimal jxzcZcJjPaid;

    /**
     * 绩效支出_自筹_间接_未支付
     */
    private BigDecimal jxzcZcJjUnpaid;

    /**
     * 其他支出_间接_已支付
     */
    private BigDecimal othersJjPaid;

    /**
     * 其他支出_间接_未支付
     */
    private BigDecimal othersJjUnpaid;

    /**
     * 间接费用_其他支出_专项_已支付
     */
    private BigDecimal othersZxPaid;

    /**
     * 间接费用_其他支出_专项_未支付
     */
    private BigDecimal othersZxUnpaid;

    /**
     * 间接费用_其他支出_自筹_已支付
     */
    private BigDecimal othersZcPaid;

    /**
     * 间接费用_其他支出_自筹_未支付
     */
    private BigDecimal othersZcUnpaid;

    /**
     * 设备费_间接_已支付
     */
    private BigDecimal sbfJjPaid;

    /**
     * 设备费_间接_未支付
     */
    private BigDecimal sbfJjUnpaid;

    /**
     * 设备费_专项_间接_已支付
     */
    private BigDecimal sbfZxJjPaid;

    /**
     * 设备费_专项_间接_未支付
     */
    private BigDecimal sbfZxJjUnpaid;

    /**
     * 设备费_自筹_间接_已支付
     */
    private BigDecimal sbfZcJjPaid;

    /**
     * 设备费_自筹_间接_未支付
     */
    private BigDecimal sbfZcJjUnpaid;

    /**
     * 材料费_间接_已支付
     */
    private BigDecimal clfJjPaid;

    /**
     * 材料费_间接_未支付
     */
    private BigDecimal clfJjUnpaid;

    /**
     * 材料费_专项_间接_已支付
     */
    private BigDecimal clfZxJjPaid;

    /**
     * 材料费_专项_间接_未支付
     */
    private BigDecimal clfZxJjUnpaid;

    /**
     * 材料费_自筹_间接_已支付
     */
    private BigDecimal clfZcJjPaid;

    /**
     * 材料费_自筹_间接_未支付
     */
    private BigDecimal clfZcJjUnpaid;

    /**
     * 管理费_间接_已支付
     */
    private BigDecimal glfJjPaid;

    /**
     * 管理费_间接_未支付
     */
    private BigDecimal glfJjUnpaid;

    /**
     * 管理费_专项_间接_已支付
     */
    private BigDecimal glfZxJjPaid;

    /**
     * 管理费_专项_间接_未支付
     */
    private BigDecimal glfZxJjUnpaid;

    /**
     * 管理费_自筹_间接_已支付
     */
    private BigDecimal glfZcJjPaid;

    /**
     * 管理费_自筹_间接_未支付
     */
    private BigDecimal glfZcJjUnpaid;

    /**
     * 房屋租赁费_间接_已支付
     */
    private BigDecimal fwzjfJjPaid;

    /**
     * 房屋租赁费_间接_未支付
     */
    private BigDecimal fwzjfJjUnpaid;

    /**
     * 房屋租赁费_专项_间接_已支付
     */
    private BigDecimal fwzjfZxJjPaid;

    /**
     * 房屋租赁费_专项_间接_未支付
     */
    private BigDecimal fwzjfZxJjUnpaid;

    /**
     * 房屋租赁费_自筹_间接_未支付
     */
    private BigDecimal fwzjfZcJjUnpaid;

    /**
     * 房屋租赁费_自筹_间接_已支付
     */
    private BigDecimal fwzjfZcJjPaid;

    /**
     * 日常水电暖费_间接_未支付
     */
    private BigDecimal rcsdnfJjUnpaid;

    /**
     * 日常水电暖费_间接_已支付
     */
    private BigDecimal rcsdnfJjPaid;

    /**
     * 日常水电暖费_专项_间接_未支付
     */
    private BigDecimal rcsdnfZxJjUnpaid;

    /**
     * 日常水电暖费_专项_间接_已支付
     */
    private BigDecimal rcsdnfZxJjPaid;

    /**
     * 日常水电暖费_自筹_间接_已支付
     */
    private BigDecimal rcsdnfZcJjPaid;

    /**
     * 日常水电暖费_自筹_间接_未支付
     */
    private BigDecimal rcsdnfZcJjUnpaid;

    /**
     * 资料费_间接_已支付
     */
    private BigDecimal zlfJjPaid;

    /**
     * 资料费_间接_未支付
     */
    private BigDecimal zlfJjUnpaid;

    /**
     * 资料费_专项_间接_已支付
     */
    private BigDecimal zlfZxJjPaid;

    /**
     * 资料费_专项_间接_未支付
     */
    private BigDecimal zlfZxJjUnpaid;

    /**
     * 资料费_自筹_间接_已支付
     */
    private BigDecimal zlfZcJjPaid;

    /**
     * 资料费_自筹_间接_未支付
     */
    private BigDecimal zlfZcJjUnpaid;

    /**
     * 数据样本采集费_间接_已支付
     */
    private BigDecimal sjybcjfJjPaid;

    /**
     * 数据样本采集费_间接_未支付
     */
    private BigDecimal sjybcjfJjUnpaid;

    /**
     * 数据样本采集费_专项_间接_已支付
     */
    private BigDecimal sjybcjfZxJjPaid;

    /**
     * 数据样本采集费_专项_间接_未支付
     */
    private BigDecimal sjybcjfZxJjUnpaid;

    /**
     * 数据样本采集费_自筹_间接_已支付
     */
    private BigDecimal sjybcjfZcJjPaid;

    /**
     * 数据样本采集费_自筹_间接_未支付
     */
    private BigDecimal sjybcjfZcJjUnpaid;

    /**
     * 测试化验加工费_间接_已支付
     */
    private BigDecimal cshyjgfJjPaid;

    /**
     * 测试化验加工费_间接_未支付
     */
    private BigDecimal cshyjgfJjUnpaid;

    /**
     * 测试化验加工费_专项_间接_已支付
     */
    private BigDecimal cshyjgfZxJjPaid;

    /**
     * 测试化验加工费_专项_间接_未支付
     */
    private BigDecimal cshyjgfZxJjUnpaid;

    /**
     * 测试化验加工费_自筹_间接_已支付
     */
    private BigDecimal cshyjgfZcJjPaid;

    /**
     * 测试化验加工费_自筹_间接_未支付
     */
    private BigDecimal cshyjgfZcJjUnpaid;

    /**
     * 燃料动力费_间接_已支付
     */
    private BigDecimal rldlfJjPaid;

    /**
     * 燃料动力费_间接_未支付
     */
    private BigDecimal rldlfJjUnpaid;

    /**
     * 燃料动力费_专项_间接_已支付
     */
    private BigDecimal rldlfZxJjPaid;

    /**
     * 燃料动力费_专项_间接_未支付
     */
    private BigDecimal rldlfZxJjUnpaid;

    /**
     * 燃料动力费_自筹_间接_已支付
     */
    private BigDecimal rldlfZcJjPaid;

    /**
     * 燃料动力费_自筹_间接_未支付
     */
    private BigDecimal rldlfZcJjUnpaid;

    /**
     * 办公费_间接_已支付
     */
    private BigDecimal bgfJjPaid;

    /**
     * 办公费_间接_未支付
     */
    private BigDecimal bgfJjUnpaid;

    /**
     * 办公费_专项_间接_已支付
     */
    private BigDecimal bgfZxJjPaid;

    /**
     * 办公费_专项_间接_未支付
     */
    private BigDecimal bgfZxJjUnpaid;

    /**
     * 办公费_自筹_间接_已支付
     */
    private BigDecimal bgfZcJjPaid;

    /**
     * 办公费_自筹_间接_未支付
     */
    private BigDecimal bgfZcJjUnpaid;

    /**
     * 印刷出版费_间接_已支付
     */
    private BigDecimal yscbfJjPaid;

    /**
     * 印刷出版费_间接_未支付
     */
    private BigDecimal yscbfJjUnpaid;

    /**
     * 印刷出版费_专项_间接_已支付
     */
    private BigDecimal yscbfZxJjPaid;

    /**
     * 印刷出版费_专项_间接_未支付
     */
    private BigDecimal yscbfZxJjUnpaid;

    /**
     * 印刷出版费_自筹_间接_已支付
     */
    private BigDecimal yscbfZcJjPaid;

    /**
     * 印刷出版费_自筹_间接_未支付
     */
    private BigDecimal yscbfZcJjUnpaid;

    /**
     * 知识产权事务费_间接_已支付
     */
    private BigDecimal zscqswfJjPaid;

    /**
     * 知识产权事务费_间接_未支付
     */
    private BigDecimal zscqswfJjUnpaid;

    /**
     * 知识产权事务费_专项_间接_已支付
     */
    private BigDecimal zscqswfZxJjPaid;

    /**
     * 知识产权事务费_专项_间接_未支付
     */
    private BigDecimal zscqswfZxJjUnpaid;

    /**
     * 知识产权事务费_自筹_间接_已支付
     */
    private BigDecimal zscqswfZcJjPaid;

    /**
     * 知识产权事务费_自筹_间接_未支付
     */
    private BigDecimal zscqswfZcJjUnpaid;

    /**
     * 车辆使用费_间接_已支付
     */
    private BigDecimal clsyfJjPaid;

    /**
     * 车辆使用费_间接_未支付
     */
    private BigDecimal clsyfJjUnpaid;

    /**
     * 车辆使用费_专项_间接_已支付
     */
    private BigDecimal clsyfZxJjPaid;

    /**
     * 车辆使用费_专项_间接_未支付
     */
    private BigDecimal clsyfZxJjUnpaid;

    /**
     * 车辆使用费_自筹_间接_已支付
     */
    private BigDecimal clsyfZcJjPaid;

    /**
     * 车辆使用费_自筹_间接_未支付
     */
    private BigDecimal clsyfZcJjUnpaid;

    /**
     * 差旅费_间接_已支付
     */
    private BigDecimal chlfJjPaid;

    /**
     * 差旅费_间接_未支付
     */
    private BigDecimal chlfJjUnpaid;

    /**
     * 差旅费_专项_间接_已支付
     */
    private BigDecimal chlfZxJjPaid;

    /**
     * 差旅费_专项_间接_未支付
     */
    private BigDecimal chlfZxJjUnpaid;

    /**
     * 差旅费_自筹_间接_已支付
     */
    private BigDecimal chlfZcJjPaid;

    /**
     * 差旅费_自筹_间接_未支付
     */
    private BigDecimal chlfZcJjUnpaid;

    /**
     * 会议会务费_间接_已支付
     */
    private BigDecimal hyhwfJjPaid;

    /**
     * 会议会务费_间接_未支付
     */
    private BigDecimal hyhwfJjUnpaid;

    /**
     * 会议会务费_专项_间接_已支付
     */
    private BigDecimal hyhwfZxJjPaid;

    /**
     * 会议会务费_专项_间接_未支付
     */
    private BigDecimal hyhwfZxJjUnpaid;

    /**
     * 会议会务费_自筹_间接_已支付
     */
    private BigDecimal hyhwfZcJjPaid;

    /**
     * 会议会务费_自筹_间接_未支付
     */
    private BigDecimal hyhwfZcJjUnpaid;

    /**
     * 专家咨询费_间接_已支付
     */
    private BigDecimal zjzxfJjPaid;

    /**
     * 专家咨询费_间接_未支付
     */
    private BigDecimal zjzxfJjUnpaid;

    /**
     * 专家咨询费_专项_间接_已支付
     */
    private BigDecimal zjzxfZxJjPaid;

    /**
     * 专家咨询费_专项_间接_未支付
     */
    private BigDecimal zjzxfZxJjUnpaid;

    /**
     * 专家咨询费_自筹_间接_已支付
     */
    private BigDecimal zjzxfZcJjPaid;

    /**
     * 专家咨询费_自筹_间接_未支付
     */
    private BigDecimal zjzxfZcJjUnpaid;
}
