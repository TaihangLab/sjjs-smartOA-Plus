package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.PaidFieldDescription;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 项目已支付余额表（单位：万元）
 *
 * @author bailingnan
 * @TableName project_balance_paid
 * @date 2024/04/02
 */
@TableName(value = "project_balance_paid")
@Data
public class ProjectBalancePaid implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 已支付id
     */
    @TableId(type = IdType.AUTO)
    private Long paidId;
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
     * 直接经费总额_已支付
     */
    @PaidFieldDescription("直接经费总额")
    private BigDecimal totalFundsZjPaid;
    /**
     * 间接经费总额_已支付
     */
    @PaidFieldDescription("间接经费总额")
    private BigDecimal totalFundsJjPaid;
    /**
     * 专项经费总额_已支付
     */
    @PaidFieldDescription("专项经费总额")
    private BigDecimal totalFundsZxPaid;
    /**
     * 专项设备费_已支付
     */
    @PaidFieldDescription("专项设备费")
    private BigDecimal sbfZxPaid;
    /**
     * 设备费_直接_已支付
     */
    @PaidFieldDescription("设备费")
    private BigDecimal sbfZjPaid;
    /**
     * 专项直接费用_已支付
     */
    @PaidFieldDescription("专项直接费用")
    private BigDecimal totalFundsZxZjPaid;
    /**
     * 专项间接费用_已支付
     */
    @PaidFieldDescription("专项间接费用")
    private BigDecimal totalFundsZxJjPaid;
    /**
     * 自筹经费总额_已支付
     */
    @PaidFieldDescription("自筹经费总额")
    private BigDecimal totalFundsZcPaid;
    /**
     * 自筹设备费_已支付
     */
    @PaidFieldDescription("自筹设备费")
    private BigDecimal sbfZcPaid;
    /**
     * 自筹直接费用_已支付
     */
    @PaidFieldDescription("自筹直接费用")
    private BigDecimal totalFundsZcZjPaid;
    /**
     * 自筹间接费用_已支付
     */
    @PaidFieldDescription("自筹间接费用")
    private BigDecimal totalFundsZcJjPaid;
    /**
     * 设备费_专项_直接_已支付
     */
    @PaidFieldDescription("设备费_专项_直接")
    private BigDecimal sbfZxZjPaid;
    /**
     * 设备费_自筹_直接_已支付
     */
    @PaidFieldDescription("设备费_自筹_直接")
    private BigDecimal sbfZcZjPaid;
    /**
     * 设备费_购置设备费_直接_已支付
     */
    @PaidFieldDescription("设备费_购置设备费_直接")
    private BigDecimal sbfGzsbZjPaid;
    /**
     * 设备费_购置设备费_专项_直接_已支付
     */
    @PaidFieldDescription("设备费_购置设备费_专项_直接")
    private BigDecimal sbfGzsbZxZjPaid;
    /**
     * 设备费_购置设备费_自筹_直接_已支付
     */
    @PaidFieldDescription("设备费_购置设备费_自筹_直接")
    private BigDecimal sbfGzsbZcZjPaid;
    /**
     * 设备费_试制设备费_直接_已支付
     */
    @PaidFieldDescription("设备费_试制设备费_直接")
    private BigDecimal sbfSzsbZjPaid;
    /**
     * 设备费_试制设备费_专项_直接_已支付
     */
    @PaidFieldDescription("设备费_试制设备费_专项_直接")
    private BigDecimal sbfSzsbZxZjPaid;
    /**
     * 设备费_试制设备费_自筹_直接_已支付
     */
    @PaidFieldDescription("设备费_试制设备费_自筹_直接")
    private BigDecimal sbfSzsbZcZjPaid;
    /**
     * 设备费_设备升级改造费_直接_已支付
     */
    @PaidFieldDescription("设备费_设备升级改造费_直接")
    private BigDecimal sbfSbsjgzZjPaid;
    /**
     * 设备费_设备升级改造费_专项_直接_已支付
     */
    @PaidFieldDescription("设备费_设备升级改造费_专项_直接")
    private BigDecimal sbfSbsjgzZxZjPaid;
    /**
     * 设备费_设备升级改造费_自筹_直接_已支付
     */
    @PaidFieldDescription("设备费_设备升级改造费_自筹_直接")
    private BigDecimal sbfSbsjgzZcZjPaid;
    /**
     * 设备费_设备租赁费_直接_已支付
     */
    @PaidFieldDescription("设备费_设备租赁费_直接")
    private BigDecimal sbfSbzlZjPaid;
    /**
     * 设备费_设备租赁费_专项_直接_已支付
     */
    @PaidFieldDescription("设备费_设备租赁费_专项_直接")
    private BigDecimal sbfSbzlZxZjPaid;
    /**
     * 设备费_设备租赁费_自筹_直接_已支付
     */
    @PaidFieldDescription("设备费_设备租赁费_自筹_直接")
    private BigDecimal sbfSbzlZcZjPaid;
    /**
     * 业务费_直接_已支付
     */
    @PaidFieldDescription("业务费_直接")
    private BigDecimal ywfZjPaid;
    /**
     * 业务费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_专项_直接")
    private BigDecimal ywfZxZjPaid;
    /**
     * 业务费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_自筹_直接")
    private BigDecimal ywfZcZjPaid;
    /**
     * 业务费_材料费_直接_已支付
     */
    @PaidFieldDescription("业务费_材料费_直接")
    private BigDecimal ywfClfZjPaid;
    /**
     * 业务费_材料费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_材料费_专项_直接")
    private BigDecimal ywfClfZxZjPaid;
    /**
     * 业务费_材料费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_材料费_自筹_直接")
    private BigDecimal ywfClfZcZjPaid;
    /**
     * 业务费_资料费_直接_已支付
     */
    @PaidFieldDescription("业务费_资料费_直接")
    private BigDecimal ywfZlfZjPaid;
    /**
     * 业务费_资料费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_资料费_专项_直接")
    private BigDecimal ywfZlfZxZjPaid;
    /**
     * 业务费_资料费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_资料费_自筹_直接")
    private BigDecimal ywfZlfZcZjPaid;
    /**
     * 业务费_数据样本采集费_直接_已支付
     */
    @PaidFieldDescription("业务费_数据样本采集费_直接")
    private BigDecimal ywfSjybcjfZjPaid;
    /**
     * 业务费_数据样本采集费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_数据样本采集费_专项_直接")
    private BigDecimal ywfSjybcjfZxZjPaid;
    /**
     * 业务费_数据样本采集费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_数据样本采集费_自筹_直接")
    private BigDecimal ywfSjybcjfZcZjPaid;
    /**
     * 业务费_测试化验加工费_直接_已支付
     */
    @PaidFieldDescription("业务费_测试化验加工费_直接")
    private BigDecimal ywfCshyjgfZjPaid;
    /**
     * 业务费_测试化验加工费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_测试化验加工费_专项_直接")
    private BigDecimal ywfCshyjgfZxZjPaid;
    /**
     * 业务费_测试化验加工费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_测试化验加工费_自筹_直接")
    private BigDecimal ywfCshyjgfZcZjPaid;
    /**
     * 业务费_燃料动力费_直接_已支付
     */
    @PaidFieldDescription("业务费_燃料动力费_直接")
    private BigDecimal ywfRldlfZjPaid;
    /**
     * 业务费_燃料动力费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_燃料动力费_专项_直接")
    private BigDecimal ywfRldlfZxZjPaid;
    /**
     * 业务费_燃料动力费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_燃料动力费_自筹_直接")
    private BigDecimal ywfRldlfZcZjPaid;
    /**
     * 业务费_办公费_直接_已支付
     */
    @PaidFieldDescription("业务费_办公费_直接")
    private BigDecimal ywfBgfZjPaid;
    /**
     * 业务费_办公费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_办公费_专项_直接")
    private BigDecimal ywfBgfZxZjPaid;
    /**
     * 业务费_办公费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_办公费_自筹_直接")
    private BigDecimal ywfBgfZcZjPaid;
    /**
     * 业务费_印刷出版费_直接_已支付
     */
    @PaidFieldDescription("业务费_印刷出版费_直接")
    private BigDecimal ywfYscbfZjPaid;
    /**
     * 业务费_印刷出版费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_印刷出版费_专项_直接")
    private BigDecimal ywfYscbfZxZjPaid;
    /**
     * 业务费_印刷出版费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_印刷出版费_自筹_直接")
    private BigDecimal ywfYscbfZcZjPaid;
    /**
     * 业务费_知识产权事务费_直接_已支付
     */
    @PaidFieldDescription("业务费_知识产权事务费_直接")
    private BigDecimal ywfZscqswfZjPaid;
    /**
     * 业务费_知识产权事务费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_知识产权事务费_专项_直接")
    private BigDecimal ywfZscqswfZxZjPaid;
    /**
     * 业务费_知识产权事务费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_知识产权事务费_自筹_直接")
    private BigDecimal ywfZscqswfZcZjPaid;
    /**
     * 业务费_车辆使用费_直接_已支付
     */
    @PaidFieldDescription("业务费_车辆使用费_直接")
    private BigDecimal ywfClsyfZjPaid;
    /**
     * 业务费_车辆使用费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_车辆使用费_专项_直接")
    private BigDecimal ywfClsyfZxZjPaid;
    /**
     * 业务费_车辆使用费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_车辆使用费_自筹_直接")
    private BigDecimal ywfClsyfZcZjPaid;
    /**
     * 业务费_差旅费_直接_已支付
     */
    @PaidFieldDescription("业务费_差旅费_直接")
    private BigDecimal ywfChlfZjPaid;
    /**
     * 业务费_差旅费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_差旅费_专项_直接")
    private BigDecimal ywfChlfZxZjPaid;
    /**
     * 业务费_差旅费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_差旅费_自筹_直接")
    private BigDecimal ywfChlfZcZjPaid;
    /**
     * 业务费_会议会务费_直接_已支付
     */
    @PaidFieldDescription("业务费_会议会务费_直接")
    private BigDecimal ywfHyhwfZjPaid;
    /**
     * 业务费_会议会务费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_会议会务费_专项_直接")
    private BigDecimal ywfHyhwfZxZjPaid;
    /**
     * 业务费_会议会务费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_会议会务费_自筹_直接")
    private BigDecimal ywfHyhwfZcZjPaid;
    /**
     * 业务费_国内协作费_直接_已支付
     */
    @PaidFieldDescription("业务费_国内协作费_直接")
    private BigDecimal ywfGnxzfZjPaid;
    /**
     * 业务费_国内协作费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_国内协作费_专项_直接")
    private BigDecimal ywfGnxzfZxZjPaid;
    /**
     * 业务费_国内协作费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_国内协作费_自筹_直接")
    private BigDecimal ywfGnxzfZcZjPaid;
    /**
     * 业务费_国际合作交流费_直接_已支付
     */
    @PaidFieldDescription("业务费_国际合作交流费_直接")
    private BigDecimal ywfGjhzjlfZjPaid;
    /**
     * 业务费_国际合作交流费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_国际合作交流费_专项_直接")
    private BigDecimal ywfGjhzjlfZxZjPaid;
    /**
     * 业务费_国际合作交流费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_国际合作交流费_自筹_直接")
    private BigDecimal ywfGjhzjlfZcZjPaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_直接")
    private BigDecimal ywfHyclgjhzyjlfZjPaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfZxZjPaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfZcZjPaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_会议费_直接")
    private BigDecimal ywfHyclgjhzyjlfHyfZjPaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_会议费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfHyfZxZjPaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_会议费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfHyfZcZjPaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_差旅费_直接")
    private BigDecimal ywfHyclgjhzyjlfClfZjPaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_差旅费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfClfZxZjPaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_差旅费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfClfZcZjPaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_国际合作费_直接")
    private BigDecimal ywfHyclgjhzyjlfGjhzfZjPaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_国际合作费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfGjhzfZxZjPaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_会议/差旅/国际合作与交流费_国际合作费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfGjhzfZcZjPaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZjPaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZxZjPaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZcZjPaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZjPaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZxZjPaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZcZjPaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_直接")
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZjPaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZxZjPaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZcZjPaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_直接")
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZjPaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZxZjPaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZcZjPaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_信息传播费_直接")
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZjPaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_专项_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_信息传播费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZxZjPaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_自筹_直接_已支付
     */
    @PaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_信息传播费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZcZjPaid;
    /**
     * 劳务费_直接_已支付
     */
    @PaidFieldDescription("劳务费_直接")
    private BigDecimal lwfZjPaid;
    /**
     * 劳务费_专项_直接_已支付
     */
    @PaidFieldDescription("劳务费_专项_直接")
    private BigDecimal lwfZxZjPaid;
    /**
     * 劳务费_自筹_直接_已支付
     */
    @PaidFieldDescription("劳务费_自筹_直接")
    private BigDecimal lwfZcZjPaid;
    /**
     * 劳务费_专家咨询费_直接_已支付
     */
    @PaidFieldDescription("劳务费_专家咨询费_直接")
    private BigDecimal lwfZjzxfZjPaid;
    /**
     * 劳务费_专家咨询费_专项_直接_已支付
     */
    @PaidFieldDescription("劳务费_专家咨询费_专项_直接")
    private BigDecimal lwfZjzxfZxZjPaid;
    /**
     * 劳务费_专家咨询费_自筹_直接_已支付
     */
    @PaidFieldDescription("劳务费_专家咨询费_自筹_直接")
    private BigDecimal lwfZjzxfZcZjPaid;
    /**
     * 劳务费_人员劳务费_直接_已支付
     */
    @PaidFieldDescription("劳务费_人员劳务费_直接")
    private BigDecimal lwfRylwfZjPaid;
    /**
     * 劳务费_人员劳务费_专项_直接_已支付
     */
    @PaidFieldDescription("劳务费_人员劳务费_专项_直接")
    private BigDecimal lwfRylwfZxZjPaid;
    /**
     * 劳务费_人员劳务费_自筹_直接_已支付
     */
    @PaidFieldDescription("劳务费_人员劳务费_自筹_直接")
    private BigDecimal lwfRylwfZcZjPaid;
    /**
     * 材料费_直接_已支付
     */
    @PaidFieldDescription("材料费_直接")
    private BigDecimal clfZjPaid;
    /**
     * 材料费_专项_直接_已支付
     */
    @PaidFieldDescription("材料费_专项_直接")
    private BigDecimal clfZxZjPaid;
    /**
     * 材料费_自筹_直接_已支付
     */
    @PaidFieldDescription("材料费_自筹_直接")
    private BigDecimal clfZcZjPaid;
    /**
     * 材料费_材料费_直接_已支付
     */
    @PaidFieldDescription("材料费_材料费_直接")
    private BigDecimal clfClfZjPaid;
    /**
     * 材料费_材料费_专项_直接_已支付
     */
    @PaidFieldDescription("材料费_材料费_专项_直接")
    private BigDecimal clfClfZxZjPaid;
    /**
     * 材料费_材料费_自筹_直接_已支付
     */
    @PaidFieldDescription("材料费_材料费_自筹_直接")
    private BigDecimal clfClfZcZjPaid;
    /**
     * 科研活动费_直接_已支付
     */
    @PaidFieldDescription("科研活动费_直接")
    private BigDecimal kyhdfZjPaid;
    /**
     * 科研活动费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_专项_直接")
    private BigDecimal kyhdfZxZjPaid;
    /**
     * 科研活动费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_自筹_直接")
    private BigDecimal kyhdfZcZjPaid;
    /**
     * 科研活动费_资料费_直接_已支付
     */
    @PaidFieldDescription("科研活动费_资料费_直接")
    private BigDecimal kyhdfZlZjPaid;
    /**
     * 科研活动费_资料费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_资料费_专项_直接")
    private BigDecimal kyhdfZlZxZjPaid;
    /**
     * 科研活动费_资料费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_资料费_自筹_直接")
    private BigDecimal kyhdfZlZcZjPaid;
    /**
     * 科研活动费_测试化验加工费_直接_已支付
     */
    @PaidFieldDescription("科研活动费_测试化验加工费_直接")
    private BigDecimal kyhdfCshyjgZjPaid;
    /**
     * 科研活动费_测试化验加工费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_测试化验加工费_专项_直接")
    private BigDecimal kyhdfCshyjgZxZjPaid;
    /**
     * 科研活动费_测试化验加工费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_测试化验加工费_自筹_直接")
    private BigDecimal kyhdfCshyjgZcZjPaid;
    /**
     * 科研活动费_办公费_直接_已支付
     */
    @PaidFieldDescription("科研活动费_办公费_直接")
    private BigDecimal kyhdfBgZjPaid;
    /**
     * 科研活动费_办公费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_办公费_专项_直接")
    private BigDecimal kyhdfBgZxZjPaid;
    /**
     * 科研活动费_办公费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_办公费_自筹_直接")
    private BigDecimal kyhdfBgZcZjPaid;
    /**
     * 科研活动费_数据/样本采集费_直接_已支付
     */
    @PaidFieldDescription("科研活动费_数据/样本采集费_直接")
    private BigDecimal kyhdfSjybcjZjPaid;
    /**
     * 科研活动费_数据/样本采集费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_数据/样本采集费_专项_直接")
    private BigDecimal kyhdfSjybcjZxZjPaid;
    /**
     * 科研活动费_数据/样本采集费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_数据/样本采集费_自筹_直接")
    private BigDecimal kyhdfSjybcjZcZjPaid;
    /**
     * 科研活动费_印刷/出版费_直接_已支付
     */
    @PaidFieldDescription("科研活动费_印刷/出版费_直接")
    private BigDecimal kyhdfYscbZjPaid;
    /**
     * 科研活动费_印刷/出版费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_印刷/出版费_专项_直接")
    private BigDecimal kyhdfYscbZxZjPaid;
    /**
     * 科研活动费_印刷/出版费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_印刷/出版费_自筹_直接")
    private BigDecimal kyhdfYscbZcZjPaid;
    /**
     * 科研活动费_知识产权事务费_直接_已支付
     */
    @PaidFieldDescription("科研活动费_知识产权事务费_直接")
    private BigDecimal kyhdfZscqswZjPaid;
    /**
     * 科研活动费_知识产权事务费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_知识产权事务费_专项_直接")
    private BigDecimal kyhdfZscqswZxZjPaid;
    /**
     * 科研活动费_知识产权事务费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_知识产权事务费_自筹_直接")
    private BigDecimal kyhdfZscqswZcZjPaid;
    /**
     * 科研活动费_燃料动力费_直接_已支付
     */
    @PaidFieldDescription("科研活动费_燃料动力费_直接")
    private BigDecimal kyhdfRldlZjPaid;
    /**
     * 科研活动费_燃料动力费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_燃料动力费_专项_直接")
    private BigDecimal kyhdfRldlZxZjPaid;
    /**
     * 科研活动费_燃料动力费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_燃料动力费_自筹_直接")
    private BigDecimal kyhdfRldlZcZjPaid;
    /**
     * 科研活动费_车辆使用费_直接_已支付
     */
    @PaidFieldDescription("科研活动费_车辆使用费_直接")
    private BigDecimal kyhdfClsyZjPaid;
    /**
     * 科研活动费_车辆使用费_专项_直接_已支付
     */
    @PaidFieldDescription("科研活动费_车辆使用费_专项_直接")
    private BigDecimal kyhdfClsyZxZjPaid;
    /**
     * 科研活动费_车辆使用费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研活动费_车辆使用费_自筹_直接")
    private BigDecimal kyhdfClsyZcZjPaid;
    /**
     * 科研服务费_直接_已支付
     */
    @PaidFieldDescription("科研服务费_直接")
    private BigDecimal kyfwfZjPaid;
    /**
     * 科研服务费_专项_直接_已支付
     */
    @PaidFieldDescription("科研服务费_专项_直接")
    private BigDecimal kyfwfZxZjPaid;
    /**
     * 科研服务费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研服务费_自筹_直接")
    private BigDecimal kyfwfZcZjPaid;
    /**
     * 科研服务费_专家咨询费_直接_已支付
     */
    @PaidFieldDescription("科研服务费_专家咨询费_直接")
    private BigDecimal kyfwfZjzxZjPaid;
    /**
     * 科研服务费_专家咨询费_专项_直接_已支付
     */
    @PaidFieldDescription("科研服务费_专家咨询费_专项_直接")
    private BigDecimal kyfwfZjzxZxZjPaid;
    /**
     * 科研服务费_专家咨询费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研服务费_专家咨询费_自筹_直接")
    private BigDecimal kyfwfZjzxZcZjPaid;
    /**
     * 科研服务费_差旅费_直接_已支付
     */
    @PaidFieldDescription("科研服务费_差旅费_直接")
    private BigDecimal kyfwfClZjPaid;
    /**
     * 科研服务费_差旅费_专项_直接_已支付
     */
    @PaidFieldDescription("科研服务费_差旅费_专项_直接")
    private BigDecimal kyfwfClZxZjPaid;
    /**
     * 科研服务费_差旅费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研服务费_差旅费_自筹_直接")
    private BigDecimal kyfwfClZcZjPaid;
    /**
     * 科研服务费_会议/会务费_直接_已支付
     */
    @PaidFieldDescription("科研服务费_会议/会务费_直接")
    private BigDecimal kyfwfHyhwZjPaid;
    /**
     * 科研服务费_会议/会务费_专项_直接_已支付
     */
    @PaidFieldDescription("科研服务费_会议/会务费_专项_直接")
    private BigDecimal kyfwfHyhwZxZjPaid;
    /**
     * 科研服务费_会议/会务费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研服务费_会议/会务费_自筹_直接")
    private BigDecimal kyfwfHyhwZcZjPaid;
    /**
     * 科研服务费_国际合作交流_直接_已支付
     */
    @PaidFieldDescription("科研服务费_国际合作交流_直接")
    private BigDecimal kyfwfGjhzjlZjPaid;
    /**
     * 科研服务费_国际合作交流_专项_直接_已支付
     */
    @PaidFieldDescription("科研服务费_国际合作交流_专项_直接")
    private BigDecimal kyfwfGjhzjlZxZjPaid;
    /**
     * 科研服务费_国际合作交流_自筹_直接_已支付
     */
    @PaidFieldDescription("科研服务费_国际合作交流_自筹_直接")
    private BigDecimal kyfwfGjhzjlZcZjPaid;
    /**
     * 科研服务费_国内协作费_直接_已支付
     */
    @PaidFieldDescription("科研服务费_国内协作费_直接")
    private BigDecimal kyfwfGnxzZjPaid;
    /**
     * 科研服务费_国内协作费_专项_直接_已支付
     */
    @PaidFieldDescription("科研服务费_国内协作费_专项_直接")
    private BigDecimal kyfwfGnxzZxZjPaid;
    /**
     * 科研服务费_国内协作费_自筹_直接_已支付
     */
    @PaidFieldDescription("科研服务费_国内协作费_自筹_直接")
    private BigDecimal kyfwfGnxzZcZjPaid;
    /**
     * 人员和劳务补助费_直接_已支付
     */
    @PaidFieldDescription("人员和劳务补助费_直接")
    private BigDecimal ryhlwbzfZjPaid;
    /**
     * 人员和劳务补助费_专项_直接_已支付
     */
    @PaidFieldDescription("人员和劳务补助费_专项_直接")
    private BigDecimal ryhlwbzfZxZjPaid;
    /**
     * 人员和劳务补助费_自筹_直接_已支付
     */
    @PaidFieldDescription("人员和劳务补助费_自筹_直接")
    private BigDecimal ryhlwbzfZcZjPaid;
    /**
     * 人员和劳务补助费_人员劳务费_直接_已支付
     */
    @PaidFieldDescription("人员和劳务补助费_人员劳务费_直接")
    private BigDecimal ryhlwbzfRylwZjPaid;
    /**
     * 人员和劳务补助费_人员劳务费_专项_直接_已支付
     */
    @PaidFieldDescription("人员和劳务补助费_人员劳务费_专项_直接")
    private BigDecimal ryhlwbzfRylwZxZjPaid;
    /**
     * 人员和劳务补助费_人员劳务费_自筹_直接_已支付
     */
    @PaidFieldDescription("人员和劳务补助费_人员劳务费_自筹_直接")
    private BigDecimal ryhlwbzfRylwZcZjPaid;
    /**
     * 绩效支出_间接_已支付
     */
    @PaidFieldDescription("绩效支出_间接")
    private BigDecimal jxzcJjPaid;
    /**
     * 绩效支出_专项_间接_已支付
     */
    @PaidFieldDescription("绩效支出_专项_间接")
    private BigDecimal jxzcZxJjPaid;
    /**
     * 绩效支出_自筹_间接_已支付
     */
    @PaidFieldDescription("绩效支出_自筹_间接")
    private BigDecimal jxzcZcJjPaid;
    /**
     * 其他支出_间接_已支付
     */
    @PaidFieldDescription("其他支出_间接")
    private BigDecimal othersJjPaid;
    /**
     * 间接费用_其他支出_专项_已支付
     */
    @PaidFieldDescription("其他支出_专项_间接")
    private BigDecimal othersZxPaid;
    /**
     * 间接费用_其他支出_自筹_已支付
     */
    @PaidFieldDescription("其他支出_自筹_间接")
    private BigDecimal othersZcPaid;
    /**
     * 设备费_间接_已支付
     */
    @PaidFieldDescription("设备费_间接")
    private BigDecimal sbfJjPaid;
    /**
     * 设备费_专项_间接_已支付
     */
    @PaidFieldDescription("设备费_专项_间接")
    private BigDecimal sbfZxJjPaid;
    /**
     * 设备费_自筹_间接_已支付
     */
    @PaidFieldDescription("设备费_自筹_间接")
    private BigDecimal sbfZcJjPaid;
    /**
     * 材料费_间接_已支付
     */
    @PaidFieldDescription("材料费_间接")
    private BigDecimal clfJjPaid;
    /**
     * 材料费_专项_间接_已支付
     */
    @PaidFieldDescription("材料费_专项_间接")
    private BigDecimal clfZxJjPaid;
    /**
     * 材料费_自筹_间接_已支付
     */
    @PaidFieldDescription("材料费_自筹_间接")
    private BigDecimal clfZcJjPaid;
    /**
     * 管理费_间接_已支付
     */
    @PaidFieldDescription("管理费_间接")
    private BigDecimal glfJjPaid;
    /**
     * 管理费_专项_间接_已支付
     */
    @PaidFieldDescription("管理费_专项_间接")
    private BigDecimal glfZxJjPaid;
    /**
     * 管理费_自筹_间接_已支付
     */
    @PaidFieldDescription("管理费_自筹_间接")
    private BigDecimal glfZcJjPaid;
    /**
     * 房屋租赁费_间接_已支付
     */
    @PaidFieldDescription("房屋租赁费_间接")
    private BigDecimal fwzjfJjPaid;
    /**
     * 房屋租赁费_专项_间接_已支付
     */
    @PaidFieldDescription("房屋租赁费_专项_间接")
    private BigDecimal fwzjfZxJjPaid;
    /**
     * 房屋租赁费_自筹_间接_已支付
     */
    @PaidFieldDescription("房屋租赁费_自筹_间接")
    private BigDecimal fwzjfZcJjPaid;
    /**
     * 日常水电暖费_间接_已支付
     */
    @PaidFieldDescription("日常水电暖费_间接")
    private BigDecimal rcsdnfJjPaid;
    /**
     * 日常水电暖费_专项_间接_已支付
     */
    @PaidFieldDescription("日常水电暖费_专项_间接")
    private BigDecimal rcsdnfZxJjPaid;
    /**
     * 日常水电暖费_自筹_间接_已支付
     */
    @PaidFieldDescription("日常水电暖费_自筹_间接")
    private BigDecimal rcsdnfZcJjPaid;
    /**
     * 资料费_间接_已支付
     */
    @PaidFieldDescription("资料费_间接")
    private BigDecimal zlfJjPaid;
    /**
     * 资料费_专项_间接_已支付
     */
    @PaidFieldDescription("资料费_专项_间接")
    private BigDecimal zlfZxJjPaid;
    /**
     * 资料费_自筹_间接_已支付
     */
    @PaidFieldDescription("资料费_自筹_间接")
    private BigDecimal zlfZcJjPaid;
    /**
     * 数据样本采集费_间接_已支付
     */
    @PaidFieldDescription("数据样本采集费_间接")
    private BigDecimal sjybcjfJjPaid;
    /**
     * 数据样本采集费_专项_间接_已支付
     */
    @PaidFieldDescription("数据样本采集费_专项_间接")
    private BigDecimal sjybcjfZxJjPaid;
    /**
     * 数据样本采集费_自筹_间接_已支付
     */
    @PaidFieldDescription("数据样本采集费_自筹_间接")
    private BigDecimal sjybcjfZcJjPaid;
    /**
     * 测试化验加工费_间接_已支付
     */
    @PaidFieldDescription("测试化验加工费_间接")
    private BigDecimal cshyjgfJjPaid;
    /**
     * 测试化验加工费_专项_间接_已支付
     */
    @PaidFieldDescription("测试化验加工费_专项_间接")
    private BigDecimal cshyjgfZxJjPaid;
    /**
     * 测试化验加工费_自筹_间接_已支付
     */
    @PaidFieldDescription("测试化验加工费_自筹_间接")
    private BigDecimal cshyjgfZcJjPaid;
    /**
     * 燃料动力费_间接_已支付
     */
    @PaidFieldDescription("燃料动力费_间接")
    private BigDecimal rldlfJjPaid;
    /**
     * 燃料动力费_专项_间接_已支付
     */
    @PaidFieldDescription("燃料动力费_专项_间接")
    private BigDecimal rldlfZxJjPaid;
    /**
     * 燃料动力费_自筹_间接_已支付
     */
    @PaidFieldDescription("燃料动力费_自筹_间接")
    private BigDecimal rldlfZcJjPaid;
    /**
     * 办公费_间接_已支付
     */
    @PaidFieldDescription("办公费_间接")
    private BigDecimal bgfJjPaid;
    /**
     * 办公费_专项_间接_已支付
     */
    @PaidFieldDescription("办公费_专项_间接")
    private BigDecimal bgfZxJjPaid;
    /**
     * 办公费_自筹_间接_已支付
     */
    @PaidFieldDescription("办公费_自筹_间接")
    private BigDecimal bgfZcJjPaid;
    /**
     * 印刷出版费_间接_已支付
     */
    @PaidFieldDescription("印刷出版费_间接")
    private BigDecimal yscbfJjPaid;
    /**
     * 印刷出版费_专项_间接_已支付
     */
    @PaidFieldDescription("印刷出版费_专项_间接")
    private BigDecimal yscbfZxJjPaid;
    /**
     * 印刷出版费_自筹_间接_已支付
     */
    @PaidFieldDescription("印刷出版费_自筹_间接")
    private BigDecimal yscbfZcJjPaid;
    /**
     * 知识产权事务费_间接_已支付
     */
    @PaidFieldDescription("知识产权事务费_间接")
    private BigDecimal zscqswfJjPaid;
    /**
     * 知识产权事务费_专项_间接_已支付
     */
    @PaidFieldDescription("知识产权事务费_专项_间接")
    private BigDecimal zscqswfZxJjPaid;
    /**
     * 知识产权事务费_自筹_间接_已支付
     */
    @PaidFieldDescription("知识产权事务费_自筹_间接")
    private BigDecimal zscqswfZcJjPaid;
    /**
     * 车辆使用费_间接_已支付
     */
    @PaidFieldDescription("车辆使用费_间接")
    private BigDecimal clsyfJjPaid;
    /**
     * 车辆使用费_专项_间接_已支付
     */
    @PaidFieldDescription("车辆使用费_专项_间接")
    private BigDecimal clsyfZxJjPaid;
    /**
     * 车辆使用费_自筹_间接_已支付
     */
    @PaidFieldDescription("车辆使用费_自筹_间接")
    private BigDecimal clsyfZcJjPaid;
    /**
     * 差旅费_间接_已支付
     */
    @PaidFieldDescription("差旅费_间接")
    private BigDecimal chlfJjPaid;
    /**
     * 差旅费_专项_间接_已支付
     */
    @PaidFieldDescription("差旅费_专项_间接")
    private BigDecimal chlfZxJjPaid;
    /**
     * 差旅费_自筹_间接_已支付
     */
    @PaidFieldDescription("差旅费_自筹_间接")
    private BigDecimal chlfZcJjPaid;
    /**
     * 会议会务费_间接_已支付
     */
    @PaidFieldDescription("会议会务费_间接")
    private BigDecimal hyhwfJjPaid;
    /**
     * 会议会务费_专项_间接_已支付
     */
    @PaidFieldDescription("会议会务费_专项_间接")
    private BigDecimal hyhwfZxJjPaid;
    /**
     * 会议会务费_自筹_间接_已支付
     */
    @PaidFieldDescription("会议会务费_自筹_间接")
    private BigDecimal hyhwfZcJjPaid;
    /**
     * 专家咨询费_间接_已支付
     */
    @PaidFieldDescription("专家咨询费_间接")
    private BigDecimal zjzxfJjPaid;
    /**
     * 专家咨询费_专项_间接_已支付
     */
    @PaidFieldDescription("专家咨询费_专项_间接")
    private BigDecimal zjzxfZxJjPaid;
    /**
     * 专家咨询费_自筹_间接_已支付
     */
    @PaidFieldDescription("专家咨询费_自筹_间接")
    private BigDecimal zjzxfZcJjPaid;
}
