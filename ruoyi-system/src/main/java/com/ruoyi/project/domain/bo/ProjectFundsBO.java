package com.ruoyi.project.domain.bo;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

/**
 * 项目经费BO
 *
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
    @DecimalMax(value = "999999.999999", message = "项目经费总额不能超过{value}万元")
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsAll = BigDecimal.ZERO;

    /**
     * 直接经费总额
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsZj = BigDecimal.ZERO;

    /**
     * 间接经费总额
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsJj = BigDecimal.ZERO;

    /**
     * 专项经费总额
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsZx = BigDecimal.ZERO;

    /**
     * 专项到款总额
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsZxDk = BigDecimal.ZERO;

    /**
     * 已完成自筹投资
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal zctzDone = BigDecimal.ZERO;

    /**
     * 已完成专项投资
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal zxtzDone = BigDecimal.ZERO;

    /**
     * 自筹经费公司配套
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal zcGspt = BigDecimal.ZERO;

    /**
     * 专项经费公司留存（计划）
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal zxGslc = BigDecimal.ZERO;

    /**
     * 专项设备费
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfZx = BigDecimal.ZERO;

    /**
     * 设备费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfZj = BigDecimal.ZERO;

    /**
     * 专项直接费用
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsZxZj = BigDecimal.ZERO;

    /**
     * 专项间接费用
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsZxJj = BigDecimal.ZERO;

    /**
     * 自筹经费总额
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsZc = BigDecimal.ZERO;

    /**
     * 自筹设备费
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfZc = BigDecimal.ZERO;

    /**
     * 自筹直接费用
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsZcZj = BigDecimal.ZERO;

    /**
     * 自筹间接费用
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal totalFundsZcJj = BigDecimal.ZERO;

    /**
     * 设备费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfZxZj = BigDecimal.ZERO;

    /**
     * 设备费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfZcZj = BigDecimal.ZERO;

    /**
     * 设备费_购置设备费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfGzsbZj = BigDecimal.ZERO;

    /**
     * 设备费_购置设备费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfGzsbZxZj = BigDecimal.ZERO;

    /**
     * 设备费_购置设备费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfGzsbZcZj = BigDecimal.ZERO;

    /**
     * 设备费_试制设备费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSzsbZj = BigDecimal.ZERO;

    /**
     * 设备费_试制设备费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSzsbZxZj = BigDecimal.ZERO;

    /**
     * 设备费_试制设备费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSzsbZcZj = BigDecimal.ZERO;

    /**
     * 设备费_设备升级改造费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSbsjgzZj = BigDecimal.ZERO;

    /**
     * 设备费_设备升级改造费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSbsjgzZxZj = BigDecimal.ZERO;

    /**
     * 设备费_设备升级改造费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSbsjgzZcZj = BigDecimal.ZERO;

    /**
     * 设备费_设备租赁费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSbzlZj = BigDecimal.ZERO;

    /**
     * 设备费_设备租赁费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSbzlZxZj = BigDecimal.ZERO;

    /**
     * 设备费_设备租赁费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfSbzlZcZj = BigDecimal.ZERO;

    /**
     * 业务费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfZj = BigDecimal.ZERO;

    /**
     * 业务费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_材料费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfClfZj = BigDecimal.ZERO;

    /**
     * 业务费_材料费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfClfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_材料费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfClfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_资料费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfZlfZj = BigDecimal.ZERO;

    /**
     * 业务费_资料费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfZlfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_资料费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfZlfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_数据样本采集费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfSjybcjfZj = BigDecimal.ZERO;

    /**
     * 业务费_数据样本采集费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfSjybcjfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_数据样本采集费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfSjybcjfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_测试化验加工费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCshyjgfZj = BigDecimal.ZERO;

    /**
     * 业务费_测试化验加工费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCshyjgfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_测试化验加工费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCshyjgfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_燃料动力费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfRldlfZj = BigDecimal.ZERO;

    /**
     * 业务费_燃料动力费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfRldlfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_燃料动力费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfRldlfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_办公费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfBgfZj = BigDecimal.ZERO;

    /**
     * 业务费_办公费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfBgfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_办公费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfBgfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_印刷出版费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfYscbfZj = BigDecimal.ZERO;

    /**
     * 业务费_印刷出版费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfYscbfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_印刷出版费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfYscbfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_知识产权事务费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfZscqswfZj = BigDecimal.ZERO;

    /**
     * 业务费_知识产权事务费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfZscqswfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_知识产权事务费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfZscqswfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_车辆使用费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfClsyfZj = BigDecimal.ZERO;

    /**
     * 业务费_车辆使用费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfClsyfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_车辆使用费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfClsyfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_差旅费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfChlfZj = BigDecimal.ZERO;

    /**
     * 业务费_差旅费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfChlfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_差旅费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfChlfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_会议会务费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfHyhwfZj = BigDecimal.ZERO;

    /**
     * 业务费_会议会务费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfHyhwfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_会议会务费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfHyhwfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_国内协作费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfGnxzfZj = BigDecimal.ZERO;

    /**
     * 业务费_国内协作费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfGnxzfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_国内协作费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfGnxzfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_国际合作交流费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfGjhzjlfZj = BigDecimal.ZERO;

    /**
     * 业务费_国际合作交流费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfGjhzjlfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_国际合作交流费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfGjhzjlfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_会议/差旅/国际合作与交流费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfHyclgjhzyjlfZj = BigDecimal.ZERO;

    /**
     * 业务费_会议/差旅/国际合作与交流费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfHyclgjhzyjlfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_会议/差旅/国际合作与交流费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfHyclgjhzyjlfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfHyclgjhzyjlfHyfZj = BigDecimal.ZERO;

    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfHyclgjhzyjlfHyfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfHyclgjhzyjlfHyfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfHyclgjhzyjlfClfZj = BigDecimal.ZERO;

    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfHyclgjhzyjlfClfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfHyclgjhzyjlfClfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfHyclgjhzyjlfGjhzfZj = BigDecimal.ZERO;

    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfHyclgjhzyjlfGjhzfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfHyclgjhzyjlfGjhzfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCbwxxxcbzscqswfZj = BigDecimal.ZERO;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCbwxxxcbzscqswfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCbwxxxcbzscqswfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZj = BigDecimal.ZERO;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZj = BigDecimal.ZERO;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZj = BigDecimal.ZERO;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZcZj = BigDecimal.ZERO;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZj = BigDecimal.ZERO;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZxZj = BigDecimal.ZERO;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZcZj = BigDecimal.ZERO;

    /**
     * 劳务费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal lwfZj = BigDecimal.ZERO;

    /**
     * 劳务费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal lwfZxZj = BigDecimal.ZERO;

    /**
     * 劳务费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal lwfZcZj = BigDecimal.ZERO;

    /**
     * 劳务费_专家咨询费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal lwfZjzxfZj = BigDecimal.ZERO;

    /**
     * 劳务费_专家咨询费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal lwfZjzxfZxZj = BigDecimal.ZERO;

    /**
     * 劳务费_专家咨询费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal lwfZjzxfZcZj = BigDecimal.ZERO;

    /**
     * 劳务费_人员劳务费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal lwfRylwfZj = BigDecimal.ZERO;

    /**
     * 劳务费_人员劳务费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal lwfRylwfZxZj = BigDecimal.ZERO;

    /**
     * 劳务费_人员劳务费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal lwfRylwfZcZj = BigDecimal.ZERO;

    /**
     * 材料费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal clfZj = BigDecimal.ZERO;

    /**
     * 材料费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal clfZxZj = BigDecimal.ZERO;

    /**
     * 材料费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal clfZcZj = BigDecimal.ZERO;

    /**
     * 材料费_材料费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal clfClfZj = BigDecimal.ZERO;

    /**
     * 材料费_材料费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal clfClfZxZj = BigDecimal.ZERO;

    /**
     * 材料费_材料费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal clfClfZcZj = BigDecimal.ZERO;

    /**
     * 科研活动费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZj = BigDecimal.ZERO;

    /**
     * 科研活动费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZxZj = BigDecimal.ZERO;

    /**
     * 科研活动费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZcZj = BigDecimal.ZERO;

    /**
     * 科研活动费_资料费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZlZj = BigDecimal.ZERO;

    /**
     * 科研活动费_资料费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZlZxZj = BigDecimal.ZERO;

    /**
     * 科研活动费_资料费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZlZcZj = BigDecimal.ZERO;

    /**
     * 科研活动费_测试化验加工费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfCshyjgZj = BigDecimal.ZERO;

    /**
     * 科研活动费_测试化验加工费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfCshyjgZxZj = BigDecimal.ZERO;

    /**
     * 科研活动费_测试化验加工费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfCshyjgZcZj = BigDecimal.ZERO;

    /**
     * 科研活动费_办公费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfBgZj = BigDecimal.ZERO;

    /**
     * 科研活动费_办公费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfBgZxZj = BigDecimal.ZERO;

    /**
     * 科研活动费_办公费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfBgZcZj = BigDecimal.ZERO;

    /**
     * 科研活动费_数据/样本采集费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfSjybcjZj = BigDecimal.ZERO;

    /**
     * 科研活动费_数据/样本采集费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfSjybcjZxZj = BigDecimal.ZERO;

    /**
     * 科研活动费_数据/样本采集费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfSjybcjZcZj = BigDecimal.ZERO;

    /**
     * 科研活动费_印刷/出版费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfYscbZj = BigDecimal.ZERO;

    /**
     * 科研活动费_印刷/出版费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfYscbZxZj = BigDecimal.ZERO;

    /**
     * 科研活动费_印刷/出版费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfYscbZcZj = BigDecimal.ZERO;

    /**
     * 科研活动费_知识产权事务费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZscqswZj = BigDecimal.ZERO;

    /**
     * 科研活动费_知识产权事务费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZscqswZxZj = BigDecimal.ZERO;

    /**
     * 科研活动费_知识产权事务费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfZscqswZcZj = BigDecimal.ZERO;

    /**
     * 科研活动费_燃料动力费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfRldlZj = BigDecimal.ZERO;

    /**
     * 科研活动费_燃料动力费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfRldlZxZj = BigDecimal.ZERO;

    /**
     * 科研活动费_燃料动力费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfRldlZcZj = BigDecimal.ZERO;

    /**
     * 科研活动费_车辆使用费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfClsyZj = BigDecimal.ZERO;

    /**
     * 科研活动费_车辆使用费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfClsyZxZj = BigDecimal.ZERO;

    /**
     * 科研活动费_车辆使用费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyhdfClsyZcZj = BigDecimal.ZERO;

    /**
     * 科研服务费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfZj = BigDecimal.ZERO;

    /**
     * 科研服务费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfZxZj = BigDecimal.ZERO;

    /**
     * 科研服务费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfZcZj = BigDecimal.ZERO;

    /**
     * 科研服务费_专家咨询费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfZjzxZj = BigDecimal.ZERO;

    /**
     * 科研服务费_专家咨询费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfZjzxZxZj = BigDecimal.ZERO;

    /**
     * 科研服务费_专家咨询费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfZjzxZcZj = BigDecimal.ZERO;

    /**
     * 科研服务费_差旅费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfClZj = BigDecimal.ZERO;

    /**
     * 科研服务费_差旅费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfClZxZj = BigDecimal.ZERO;

    /**
     * 科研服务费_差旅费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfClZcZj = BigDecimal.ZERO;

    /**
     * 科研服务费_会议/会务费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfHyhwZj = BigDecimal.ZERO;

    /**
     * 科研服务费_会议/会务费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfHyhwZxZj = BigDecimal.ZERO;

    /**
     * 科研服务费_会议/会务费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfHyhwZcZj = BigDecimal.ZERO;

    /**
     * 科研服务费_国际合作交流_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfGjhzjlZj = BigDecimal.ZERO;

    /**
     * 科研服务费_国际合作交流_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfGjhzjlZxZj = BigDecimal.ZERO;

    /**
     * 科研服务费_国际合作交流_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfGjhzjlZcZj = BigDecimal.ZERO;

    /**
     * 科研服务费_国内协作费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfGnxzZj = BigDecimal.ZERO;

    /**
     * 科研服务费_国内协作费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfGnxzZxZj = BigDecimal.ZERO;

    /**
     * 科研服务费_国内协作费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal kyfwfGnxzZcZj = BigDecimal.ZERO;

    /**
     * 人员和劳务补助费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ryhlwbzfZj = BigDecimal.ZERO;

    /**
     * 人员和劳务补助费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ryhlwbzfZxZj = BigDecimal.ZERO;

    /**
     * 人员和劳务补助费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ryhlwbzfZcZj = BigDecimal.ZERO;

    /**
     * 人员和劳务补助费_人员劳务费_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ryhlwbzfRylwZj = BigDecimal.ZERO;

    /**
     * 人员和劳务补助费_人员劳务费_专项_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ryhlwbzfRylwZxZj = BigDecimal.ZERO;

    /**
     * 人员和劳务补助费_人员劳务费_自筹_直接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal ryhlwbzfRylwZcZj = BigDecimal.ZERO;

    /**
     * 绩效支出_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal jxzcJj = BigDecimal.ZERO;

    /**
     * 绩效支出_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal jxzcZxJj = BigDecimal.ZERO;

    /**
     * 绩效支出_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal jxzcZcJj = BigDecimal.ZERO;

    /**
     * 其他支出_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal othersJj = BigDecimal.ZERO;

    /**
     * 其他支出_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal othersZxJj = BigDecimal.ZERO;

    /**
     * 其他支出_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal othersZcJj = BigDecimal.ZERO;

    /**
     * 经费来源_专项
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal jflyZx = BigDecimal.ZERO;

    /**
     * 经费来源_自筹
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal jflyZc = BigDecimal.ZERO;

    /**
     * 经费来源_其他财政拨款_自筹
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal jflyQtczbkZc = BigDecimal.ZERO;

    /**
     * 经费来源_单位自有货币资金_自筹
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal jflyDwzyhbzjZc = BigDecimal.ZERO;

    /**
     * 经费来源_其他资金_自筹
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal jflyQtzjZc = BigDecimal.ZERO;

    /**
     * 设备费_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfJj = BigDecimal.ZERO;

    /**
     * 设备费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfZxJj = BigDecimal.ZERO;

    /**
     * 设备费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sbfZcJj = BigDecimal.ZERO;

    /**
     * 材料费_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal clfJj = BigDecimal.ZERO;

    /**
     * 材料费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal clfZxJj = BigDecimal.ZERO;

    /**
     * 材料费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal clfZcJj = BigDecimal.ZERO;

    /**
     * 管理费_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal glfJj = BigDecimal.ZERO;

    /**
     * 管理费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal glfZxJj = BigDecimal.ZERO;

    /**
     * 管理费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal glfZcJj = BigDecimal.ZERO;

    /**
     * 房屋租赁费_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal fwzjfJj = BigDecimal.ZERO;

    /**
     * 房屋租赁费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal fwzjfZcJj = BigDecimal.ZERO;

    /**
     * 房屋租赁费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal fwzjfZxJj = BigDecimal.ZERO;

    /**
     * 日常水电暖费_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal rcsdnfJj = BigDecimal.ZERO;

    /**
     * 日常水电暖费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal rcsdnfZxJj = BigDecimal.ZERO;

    /**
     * 日常水电暖费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal rcsdnfZcJj = BigDecimal.ZERO;

    /**
     * 资料费_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal zlfJj = BigDecimal.ZERO;

    /**
     * 资料费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal zlfZxJj = BigDecimal.ZERO;

    /**
     * 资料费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal zlfZcJj = BigDecimal.ZERO;

    /**
     * 数据样本采集费_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sjybcjfJj = BigDecimal.ZERO;

    /**
     * 数据样本采集费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sjybcjfZxJj = BigDecimal.ZERO;

    /**
     * 数据样本采集费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal sjybcjfZcJj = BigDecimal.ZERO;

    /**
     * 测试化验加工费_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal cshyjgfJj = BigDecimal.ZERO;

    /**
     * 测试化验加工费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal cshyjgfZxJj = BigDecimal.ZERO;

    /**
     * 测试化验加工费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal cshyjgfZcJj = BigDecimal.ZERO;

    /**
     * 燃料动力费_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal rldlfJj = BigDecimal.ZERO;

    /**
     * 燃料动力费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal rldlfZxJj = BigDecimal.ZERO;

    /**
     * 燃料动力费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal rldlfZcJj = BigDecimal.ZERO;

    /**
     * 办公费_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal bgfJj = BigDecimal.ZERO;

    /**
     * 办公费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal bgfZxJj = BigDecimal.ZERO;

    /**
     * 办公费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal bgfZcJj = BigDecimal.ZERO;

    /**
     * 印刷出版费_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal yscbfJj = BigDecimal.ZERO;

    /**
     * 印刷出版费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal yscbfZxJj = BigDecimal.ZERO;

    /**
     * 印刷出版费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal yscbfZcJj = BigDecimal.ZERO;

    /**
     * 知识产权事务费_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal zscqswfJj = BigDecimal.ZERO;

    /**
     * 知识产权事务费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal zscqswfZxJj = BigDecimal.ZERO;

    /**
     * 知识产权事务费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal zscqswfZcJj = BigDecimal.ZERO;

    /**
     * 车辆使用费_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal clsyfJj = BigDecimal.ZERO;

    /**
     * 车辆使用费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal clsyfZxJj = BigDecimal.ZERO;

    /**
     * 车辆使用费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal clsyfZcJj = BigDecimal.ZERO;

    /**
     * 差旅费_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal chlfJj = BigDecimal.ZERO;

    /**
     * 差旅费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal chlfZxJj = BigDecimal.ZERO;

    /**
     * 差旅费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal chlfZcJj = BigDecimal.ZERO;

    /**
     * 会议会务费_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal hyhwfJj = BigDecimal.ZERO;

    /**
     * 会议会务费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal hyhwfZxJj = BigDecimal.ZERO;

    /**
     * 会议会务费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal hyhwfZcJj = BigDecimal.ZERO;

    /**
     * 专家咨询费_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal zjzxfJj = BigDecimal.ZERO;

    /**
     * 专家咨询费_专项_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal zjzxfZxJj = BigDecimal.ZERO;

    /**
     * 专家咨询费_自筹_间接
     */
    @DecimalMin(value = "0.000000", message = "金额不能为负数")
    private BigDecimal zjzxfZcJj = BigDecimal.ZERO;
}
