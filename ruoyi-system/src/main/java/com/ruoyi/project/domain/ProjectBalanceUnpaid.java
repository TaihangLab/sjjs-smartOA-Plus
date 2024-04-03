package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.UnPaidFieldDescription;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 项目未支付余额表（单位：万元）
 *
 * @author bailingnan
 * @TableName project_balance_unpaid
 * @date 2024/04/02
 */
@TableName(value = "project_balance_unpaid")
@Data
public class ProjectBalanceUnpaid implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * 未支付id
     */
    @TableId(type = IdType.AUTO)
    private Long unpaidId;
    /**
     * 经费id
     */
    private Long fundsId;
    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 项目经费总额_未支付
     */
    @UnPaidFieldDescription("项目经费总额")
    private BigDecimal totalFundsAllUnpaid;
    /**
     * 直接经费总额_未支付
     */
    @UnPaidFieldDescription("直接经费总额")
    private BigDecimal totalFundsZjUnpaid;
    /**
     * 间接经费总额_未支付
     */
    @UnPaidFieldDescription("间接经费总额")
    private BigDecimal totalFundsJjUnpaid;
    /**
     * 专项经费总额_未支付
     */
    @UnPaidFieldDescription("专项经费总额")
    private BigDecimal totalFundsZxUnpaid;
    /**
     * 专项设备费_未支付
     */
    @UnPaidFieldDescription("专项设备费")
    private BigDecimal sbfZxUnpaid;
    /**
     * 设备费_直接_未支付
     */
    @UnPaidFieldDescription("设备费")
    private BigDecimal sbfZjUnpaid;
    /**
     * 专项直接费用_未支付
     */
    @UnPaidFieldDescription("专项直接费用")
    private BigDecimal totalFundsZxZjUnpaid;
    /**
     * 专项间接费用_未支付
     */
    @UnPaidFieldDescription("专项间接费用")
    private BigDecimal totalFundsZxJjUnpaid;
    /**
     * 自筹经费总额_未支付
     */
    @UnPaidFieldDescription("自筹经费总额")
    private BigDecimal totalFundsZcUnpaid;
    /**
     * 自筹设备费_未支付
     */
    @UnPaidFieldDescription("自筹设备费")
    private BigDecimal sbfZcUnpaid;
    /**
     * 自筹直接费用_未支付
     */
    @UnPaidFieldDescription("自筹直接费用")
    private BigDecimal totalFundsZcZjUnpaid;
    /**
     * 自筹间接费用_未支付
     */
    @UnPaidFieldDescription("自筹间接费用")
    private BigDecimal totalFundsZcJjUnpaid;
    /**
     * 设备费_专项_直接_未支付
     */
    @UnPaidFieldDescription("设备费_专项_直接")
    private BigDecimal sbfZxZjUnpaid;
    /**
     * 设备费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("设备费_自筹_直接")
    private BigDecimal sbfZcZjUnpaid;
    /**
     * 设备费_购置设备费_直接_未支付
     */
    @UnPaidFieldDescription("设备费_购置设备费_直接")
    private BigDecimal sbfGzsbZjUnpaid;
    /**
     * 设备费_购置设备费_专项_直接_未支付
     */
    @UnPaidFieldDescription("设备费_购置设备费_专项_直接")
    private BigDecimal sbfGzsbZxZjUnpaid;
    /**
     * 设备费_购置设备费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("设备费_购置设备费_自筹_直接")
    private BigDecimal sbfGzsbZcZjUnpaid;
    /**
     * 设备费_试制设备费_直接_未支付
     */
    @UnPaidFieldDescription("设备费_试制设备费_直接")
    private BigDecimal sbfSzsbZjUnpaid;
    /**
     * 设备费_试制设备费_专项_直接_未支付
     */
    @UnPaidFieldDescription("设备费_试制设备费_专项_直接")
    private BigDecimal sbfSzsbZxZjUnpaid;
    /**
     * 设备费_试制设备费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("设备费_试制设备费_自筹_直接")
    private BigDecimal sbfSzsbZcZjUnpaid;
    /**
     * 设备费_设备升级改造费_直接_未支付
     */
    @UnPaidFieldDescription("设备费_设备升级改造费_直接")
    private BigDecimal sbfSbsjgzZjUnpaid;
    /**
     * 设备费_设备升级改造费_专项_直接_未支付
     */
    @UnPaidFieldDescription("设备费_设备升级改造费_专项_直接")
    private BigDecimal sbfSbsjgzZxZjUnpaid;
    /**
     * 设备费_设备升级改造费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("设备费_设备升级改造费_自筹_直接")
    private BigDecimal sbfSbsjgzZcZjUnpaid;
    /**
     * 设备费_设备租赁费_直接_未支付
     */
    @UnPaidFieldDescription("设备费_设备租赁费_直接")
    private BigDecimal sbfSbzlZjUnpaid;
    /**
     * 设备费_设备租赁费_专项_直接_未支付
     */
    @UnPaidFieldDescription("设备费_设备租赁费_专项_直接")
    private BigDecimal sbfSbzlZxZjUnpaid;
    /**
     * 设备费_设备租赁费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("设备费_设备租赁费_自筹_直接")
    private BigDecimal sbfSbzlZcZjUnpaid;
    /**
     * 业务费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_直接")
    private BigDecimal ywfZjUnpaid;
    /**
     * 业务费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_专项_直接")
    private BigDecimal ywfZxZjUnpaid;
    /**
     * 业务费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_自筹_直接")
    private BigDecimal ywfZcZjUnpaid;
    /**
     * 业务费_材料费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_材料费_直接")
    private BigDecimal ywfClfZjUnpaid;
    /**
     * 业务费_材料费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_材料费_专项_直接")
    private BigDecimal ywfClfZxZjUnpaid;
    /**
     * 业务费_材料费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_材料费_自筹_直接")
    private BigDecimal ywfClfZcZjUnpaid;
    /**
     * 业务费_资料费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_资料费_直接")
    private BigDecimal ywfZlfZjUnpaid;
    /**
     * 业务费_资料费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_资料费_专项_直接")
    private BigDecimal ywfZlfZxZjUnpaid;
    /**
     * 业务费_资料费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_资料费_自筹_直接")
    private BigDecimal ywfZlfZcZjUnpaid;
    /**
     * 业务费_数据样本采集费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_数据样本采集费_直接")
    private BigDecimal ywfSjybcjfZjUnpaid;
    /**
     * 业务费_数据样本采集费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_数据样本采集费_专项_直接")
    private BigDecimal ywfSjybcjfZxZjUnpaid;
    /**
     * 业务费_数据样本采集费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_数据样本采集费_自筹_直接")
    private BigDecimal ywfSjybcjfZcZjUnpaid;
    /**
     * 业务费_测试化验加工费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_测试化验加工费_直接")
    private BigDecimal ywfCshyjgfZjUnpaid;
    /**
     * 业务费_测试化验加工费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_测试化验加工费_专项_直接")
    private BigDecimal ywfCshyjgfZxZjUnpaid;
    /**
     * 业务费_测试化验加工费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_测试化验加工费_自筹_直接")
    private BigDecimal ywfCshyjgfZcZjUnpaid;
    /**
     * 业务费_燃料动力费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_燃料动力费_直接")
    private BigDecimal ywfRldlfZjUnpaid;
    /**
     * 业务费_燃料动力费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_燃料动力费_专项_直接")
    private BigDecimal ywfRldlfZxZjUnpaid;
    /**
     * 业务费_燃料动力费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_燃料动力费_自筹_直接")
    private BigDecimal ywfRldlfZcZjUnpaid;
    /**
     * 业务费_办公费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_办公费_直接")
    private BigDecimal ywfBgfZjUnpaid;
    /**
     * 业务费_办公费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_办公费_专项_直接")
    private BigDecimal ywfBgfZxZjUnpaid;
    /**
     * 业务费_办公费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_办公费_自筹_直接")
    private BigDecimal ywfBgfZcZjUnpaid;
    /**
     * 业务费_印刷出版费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_印刷出版费_直接")
    private BigDecimal ywfYscbfZjUnpaid;
    /**
     * 业务费_印刷出版费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_印刷出版费_专项_直接")
    private BigDecimal ywfYscbfZxZjUnpaid;
    /**
     * 业务费_印刷出版费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_印刷出版费_自筹_直接")
    private BigDecimal ywfYscbfZcZjUnpaid;
    /**
     * 业务费_知识产权事务费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_知识产权事务费_直接")
    private BigDecimal ywfZscqswfZjUnpaid;
    /**
     * 业务费_知识产权事务费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_知识产权事务费_专项_直接")
    private BigDecimal ywfZscqswfZxZjUnpaid;
    /**
     * 业务费_知识产权事务费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_知识产权事务费_自筹_直接")
    private BigDecimal ywfZscqswfZcZjUnpaid;
    /**
     * 业务费_车辆使用费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_车辆使用费_直接")
    private BigDecimal ywfClsyfZjUnpaid;
    /**
     * 业务费_车辆使用费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_车辆使用费_专项_直接")
    private BigDecimal ywfClsyfZxZjUnpaid;
    /**
     * 业务费_车辆使用费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_车辆使用费_自筹_直接")
    private BigDecimal ywfClsyfZcZjUnpaid;
    /**
     * 业务费_差旅费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_差旅费_直接")
    private BigDecimal ywfChlfZjUnpaid;
    /**
     * 业务费_差旅费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_差旅费_专项_直接")
    private BigDecimal ywfChlfZxZjUnpaid;
    /**
     * 业务费_差旅费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_差旅费_自筹_直接")
    private BigDecimal ywfChlfZcZjUnpaid;
    /**
     * 业务费_会议会务费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_会议会务费_直接")
    private BigDecimal ywfHyhwfZjUnpaid;
    /**
     * 业务费_会议会务费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_会议会务费_专项_直接")
    private BigDecimal ywfHyhwfZxZjUnpaid;
    /**
     * 业务费_会议会务费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_会议会务费_自筹_直接")
    private BigDecimal ywfHyhwfZcZjUnpaid;
    /**
     * 业务费_国内协作费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_国内协作费_直接")
    private BigDecimal ywfGnxzfZjUnpaid;
    /**
     * 业务费_国内协作费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_国内协作费_专项_直接")
    private BigDecimal ywfGnxzfZxZjUnpaid;
    /**
     * 业务费_国内协作费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_国内协作费_自筹_直接")
    private BigDecimal ywfGnxzfZcZjUnpaid;
    /**
     * 业务费_国际合作交流费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_国际合作交流费_直接")
    private BigDecimal ywfGjhzjlfZjUnpaid;
    /**
     * 业务费_国际合作交流费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_国际合作交流费_专项_直接")
    private BigDecimal ywfGjhzjlfZxZjUnpaid;
    /**
     * 业务费_国际合作交流费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_国际合作交流费_自筹_直接")
    private BigDecimal ywfGjhzjlfZcZjUnpaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_直接")
    private BigDecimal ywfHyclgjhzyjlfZjUnpaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfZxZjUnpaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfZcZjUnpaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_会议费_直接")
    private BigDecimal ywfHyclgjhzyjlfHyfZjUnpaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_会议费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfHyfZxZjUnpaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_会议费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfHyfZcZjUnpaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_差旅费_直接")
    private BigDecimal ywfHyclgjhzyjlfClfZjUnpaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_差旅费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfClfZxZjUnpaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_差旅费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfClfZcZjUnpaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_国际合作费_直接")
    private BigDecimal ywfHyclgjhzyjlfGjhzfZjUnpaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_国际合作费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfGjhzfZxZjUnpaid;
    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_会议/差旅/国际合作与交流费_国际合作费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfGjhzfZcZjUnpaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZjUnpaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZxZjUnpaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZcZjUnpaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZjUnpaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZxZjUnpaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZcZjUnpaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_直接")
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZjUnpaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZxZjUnpaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZcZjUnpaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_直接")
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZjUnpaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZxZjUnpaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZcZjUnpaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_直接_未支付
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_信息传播费_直接")
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZjUnpaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_专项_直接_未支付
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_信息传播费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZxZjUnpaid;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_信息传播费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZcZjUnpaid;
    /**
     * 劳务费_直接_未支付
     */
    @UnPaidFieldDescription("劳务费_直接")
    private BigDecimal lwfZjUnpaid;
    /**
     * 劳务费_专项_直接_未支付
     */
    @UnPaidFieldDescription("劳务费_专项_直接")
    private BigDecimal lwfZxZjUnpaid;
    /**
     * 劳务费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("劳务费_自筹_直接")
    private BigDecimal lwfZcZjUnpaid;
    /**
     * 劳务费_专家咨询费_直接_未支付
     */
    @UnPaidFieldDescription("劳务费_专家咨询费_直接")
    private BigDecimal lwfZjzxfZjUnpaid;
    /**
     * 劳务费_专家咨询费_专项_直接_未支付
     */
    @UnPaidFieldDescription("劳务费_专家咨询费_专项_直接")
    private BigDecimal lwfZjzxfZxZjUnpaid;
    /**
     * 劳务费_专家咨询费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("劳务费_专家咨询费_自筹_直接")
    private BigDecimal lwfZjzxfZcZjUnpaid;
    /**
     * 劳务费_人员劳务费_直接_未支付
     */
    @UnPaidFieldDescription("劳务费_人员劳务费_直接")
    private BigDecimal lwfRylwfZjUnpaid;
    /**
     * 劳务费_人员劳务费_专项_直接_未支付
     */
    @UnPaidFieldDescription("劳务费_人员劳务费_专项_直接")
    private BigDecimal lwfRylwfZxZjUnpaid;
    /**
     * 劳务费_人员劳务费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("劳务费_人员劳务费_自筹_直接")
    private BigDecimal lwfRylwfZcZjUnpaid;
    /**
     * 材料费_直接_未支付
     */
    @UnPaidFieldDescription("材料费_直接")
    private BigDecimal clfZjUnpaid;
    /**
     * 材料费_专项_直接_未支付
     */
    @UnPaidFieldDescription("材料费_专项_直接")
    private BigDecimal clfZxZjUnpaid;
    /**
     * 材料费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("材料费_自筹_直接")
    private BigDecimal clfZcZjUnpaid;
    /**
     * 材料费_材料费_直接_未支付
     */
    @UnPaidFieldDescription("材料费_材料费_直接")
    private BigDecimal clfClfZjUnpaid;
    /**
     * 材料费_材料费_专项_直接_未支付
     */
    @UnPaidFieldDescription("材料费_材料费_专项_直接")
    private BigDecimal clfClfZxZjUnpaid;
    /**
     * 材料费_材料费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("材料费_材料费_自筹_直接")
    private BigDecimal clfClfZcZjUnpaid;
    /**
     * 科研活动费_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_直接")
    private BigDecimal kyhdfZjUnpaid;
    /**
     * 科研活动费_专项_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_专项_直接")
    private BigDecimal kyhdfZxZjUnpaid;
    /**
     * 科研活动费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_自筹_直接")
    private BigDecimal kyhdfZcZjUnpaid;
    /**
     * 科研活动费_资料费_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_资料费_直接")
    private BigDecimal kyhdfZlZjUnpaid;
    /**
     * 科研活动费_资料费_专项_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_资料费_专项_直接")
    private BigDecimal kyhdfZlZxZjUnpaid;
    /**
     * 科研活动费_资料费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_资料费_自筹_直接")
    private BigDecimal kyhdfZlZcZjUnpaid;
    /**
     * 科研活动费_测试化验加工费_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_测试化验加工费_直接")
    private BigDecimal kyhdfCshyjgZjUnpaid;
    /**
     * 科研活动费_测试化验加工费_专项_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_测试化验加工费_专项_直接")
    private BigDecimal kyhdfCshyjgZxZjUnpaid;
    /**
     * 科研活动费_测试化验加工费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_测试化验加工费_自筹_直接")
    private BigDecimal kyhdfCshyjgZcZjUnpaid;
    /**
     * 科研活动费_办公费_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_办公费_直接")
    private BigDecimal kyhdfBgZjUnpaid;
    /**
     * 科研活动费_办公费_专项_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_办公费_专项_直接")
    private BigDecimal kyhdfBgZxZjUnpaid;
    /**
     * 科研活动费_办公费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_办公费_自筹_直接")
    private BigDecimal kyhdfBgZcZjUnpaid;
    /**
     * 科研活动费_数据/样本采集费_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_数据/样本采集费_直接")
    private BigDecimal kyhdfSjybcjZjUnpaid;
    /**
     * 科研活动费_数据/样本采集费_专项_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_数据/样本采集费_专项_直接")
    private BigDecimal kyhdfSjybcjZxZjUnpaid;
    /**
     * 科研活动费_数据/样本采集费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_数据/样本采集费_自筹_直接")
    private BigDecimal kyhdfSjybcjZcZjUnpaid;
    /**
     * 科研活动费_印刷/出版费_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_印刷/出版费_直接")
    private BigDecimal kyhdfYscbZjUnpaid;
    /**
     * 科研活动费_印刷/出版费_专项_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_印刷/出版费_专项_直接")
    private BigDecimal kyhdfYscbZxZjUnpaid;
    /**
     * 科研活动费_印刷/出版费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_印刷/出版费_自筹_直接")
    private BigDecimal kyhdfYscbZcZjUnpaid;
    /**
     * 科研活动费_知识产权事务费_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_知识产权事务费_直接")
    private BigDecimal kyhdfZscqswZjUnpaid;
    /**
     * 科研活动费_知识产权事务费_专项_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_知识产权事务费_专项_直接")
    private BigDecimal kyhdfZscqswZxZjUnpaid;
    /**
     * 科研活动费_知识产权事务费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_知识产权事务费_自筹_直接")
    private BigDecimal kyhdfZscqswZcZjUnpaid;
    /**
     * 科研活动费_燃料动力费_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_燃料动力费_直接")
    private BigDecimal kyhdfRldlZjUnpaid;
    /**
     * 科研活动费_燃料动力费_专项_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_燃料动力费_专项_直接")
    private BigDecimal kyhdfRldlZxZjUnpaid;
    /**
     * 科研活动费_燃料动力费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_燃料动力费_自筹_直接")
    private BigDecimal kyhdfRldlZcZjUnpaid;
    /**
     * 科研活动费_车辆使用费_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_车辆使用费_直接")
    private BigDecimal kyhdfClsyZjUnpaid;
    /**
     * 科研活动费_车辆使用费_专项_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_车辆使用费_专项_直接")
    private BigDecimal kyhdfClsyZxZjUnpaid;
    /**
     * 科研活动费_车辆使用费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("科研活动费_车辆使用费_自筹_直接")
    private BigDecimal kyhdfClsyZcZjUnpaid;
    /**
     * 科研服务费_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_直接")
    private BigDecimal kyfwfZjUnpaid;
    /**
     * 科研服务费_专项_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_专项_直接")
    private BigDecimal kyfwfZxZjUnpaid;
    /**
     * 科研服务费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_自筹_直接")
    private BigDecimal kyfwfZcZjUnpaid;
    /**
     * 科研服务费_专家咨询费_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_专家咨询费_直接")
    private BigDecimal kyfwfZjzxZjUnpaid;
    /**
     * 科研服务费_专家咨询费_专项_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_专家咨询费_专项_直接")
    private BigDecimal kyfwfZjzxZxZjUnpaid;
    /**
     * 科研服务费_专家咨询费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_专家咨询费_自筹_直接")
    private BigDecimal kyfwfZjzxZcZjUnpaid;
    /**
     * 科研服务费_差旅费_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_差旅费_直接")
    private BigDecimal kyfwfClZjUnpaid;
    /**
     * 科研服务费_差旅费_专项_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_差旅费_专项_直接")
    private BigDecimal kyfwfClZxZjUnpaid;
    /**
     * 科研服务费_差旅费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_差旅费_自筹_直接")
    private BigDecimal kyfwfClZcZjUnpaid;
    /**
     * 科研服务费_会议/会务费_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_会议/会务费_直接")
    private BigDecimal kyfwfHyhwZjUnpaid;
    /**
     * 科研服务费_会议/会务费_专项_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_会议/会务费_专项_直接")
    private BigDecimal kyfwfHyhwZxZjUnpaid;
    /**
     * 科研服务费_会议/会务费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_会议/会务费_自筹_直接")
    private BigDecimal kyfwfHyhwZcZjUnpaid;
    /**
     * 科研服务费_国际合作交流_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_国际合作交流_直接")
    private BigDecimal kyfwfGjhzjlZjUnpaid;
    /**
     * 科研服务费_国际合作交流_专项_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_国际合作交流_专项_直接")
    private BigDecimal kyfwfGjhzjlZxZjUnpaid;
    /**
     * 科研服务费_国际合作交流_自筹_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_国际合作交流_自筹_直接")
    private BigDecimal kyfwfGjhzjlZcZjUnpaid;
    /**
     * 科研服务费_国内协作费_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_国内协作费_直接")
    private BigDecimal kyfwfGnxzZjUnpaid;
    /**
     * 科研服务费_国内协作费_专项_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_国内协作费_专项_直接")
    private BigDecimal kyfwfGnxzZxZjUnpaid;
    /**
     * 科研服务费_国内协作费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("科研服务费_国内协作费_自筹_直接")
    private BigDecimal kyfwfGnxzZcZjUnpaid;
    /**
     * 人员和劳务补助费_直接_未支付
     */
    @UnPaidFieldDescription("人员和劳务补助费_直接")
    private BigDecimal ryhlwbzfZjUnpaid;
    /**
     * 人员和劳务补助费_专项_直接_未支付
     */
    @UnPaidFieldDescription("人员和劳务补助费_专项_直接")
    private BigDecimal ryhlwbzfZxZjUnpaid;
    /**
     * 人员和劳务补助费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("人员和劳务补助费_自筹_直接")
    private BigDecimal ryhlwbzfZcZjUnpaid;
    /**
     * 人员和劳务补助费_人员劳务费_直接_未支付
     */
    @UnPaidFieldDescription("人员和劳务补助费_人员劳务费_直接")
    private BigDecimal ryhlwbzfRylwZjUnpaid;
    /**
     * 人员和劳务补助费_人员劳务费_专项_直接_未支付
     */
    @UnPaidFieldDescription("人员和劳务补助费_人员劳务费_专项_直接")
    private BigDecimal ryhlwbzfRylwZxZjUnpaid;
    /**
     * 人员和劳务补助费_人员劳务费_自筹_直接_未支付
     */
    @UnPaidFieldDescription("人员和劳务补助费_人员劳务费_自筹_直接")
    private BigDecimal ryhlwbzfRylwZcZjUnpaid;
    /**
     * 绩效支出_间接_未支付
     */
    @UnPaidFieldDescription("绩效支出_间接")
    private BigDecimal jxzcJjUnpaid;
    /**
     * 绩效支出_专项_间接_未支付
     */
    @UnPaidFieldDescription("绩效支出_专项_间接")
    private BigDecimal jxzcZxJjUnpaid;
    /**
     * 绩效支出_自筹_间接_未支付
     */
    @UnPaidFieldDescription("绩效支出_自筹_间接")
    private BigDecimal jxzcZcJjUnpaid;
    /**
     * 其他支出_间接_未支付
     */
    @UnPaidFieldDescription("其他支出_间接")
    private BigDecimal othersJjUnpaid;
    /**
     * 间接费用_其他支出_专项_未支付
     */
    @UnPaidFieldDescription("间接费用_其他支出_专项")
    private BigDecimal othersZxUnpaid;
    /**
     * 间接费用_其他支出_自筹_未支付
     */
    @UnPaidFieldDescription("间接费用_其他支出_自筹")
    private BigDecimal othersZcUnpaid;
    /**
     * 设备费_间接_未支付
     */
    @UnPaidFieldDescription("设备费_间接")
    private BigDecimal sbfJjUnpaid;
    /**
     * 设备费_专项_间接_未支付
     */
    @UnPaidFieldDescription("设备费_专项_间接")
    private BigDecimal sbfZxJjUnpaid;
    /**
     * 设备费_自筹_间接_未支付
     */
    @UnPaidFieldDescription("设备费_自筹_间接")
    private BigDecimal sbfZcJjUnpaid;
    /**
     * 材料费_间接_未支付
     */
    @UnPaidFieldDescription("材料费_间接")
    private BigDecimal clfJjUnpaid;
    /**
     * 材料费_专项_间接_未支付
     */
    @UnPaidFieldDescription("材料费_专项_间接")
    private BigDecimal clfZxJjUnpaid;
    /**
     * 材料费_自筹_间接_未支付
     */
    @UnPaidFieldDescription("材料费_自筹_间接")
    private BigDecimal clfZcJjUnpaid;
    /**
     * 管理费_间接_未支付
     */
    @UnPaidFieldDescription("管理费_间接")
    private BigDecimal glfJjUnpaid;
    /**
     * 管理费_专项_间接_未支付
     */
    @UnPaidFieldDescription("管理费_专项_间接")
    private BigDecimal glfZxJjUnpaid;
    /**
     * 管理费_自筹_间接_未支付
     */
    @UnPaidFieldDescription("管理费_自筹_间接")
    private BigDecimal glfZcJjUnpaid;
    /**
     * 房屋租赁费_间接_未支付
     */
    @UnPaidFieldDescription("房屋租赁费_间接")
    private BigDecimal fwzjfJjUnpaid;
    /**
     * 房屋租赁费_专项_间接_未支付
     */
    @UnPaidFieldDescription("房屋租赁费_专项_间接")
    private BigDecimal fwzjfZxJjUnpaid;
    /**
     * 房屋租赁费_自筹_间接_未支付
     */
    @UnPaidFieldDescription("房屋租赁费_自筹_间接")
    private BigDecimal fwzjfZcJjUnpaid;
    /**
     * 日常水电暖费_间接_未支付
     */
    @UnPaidFieldDescription("日常水电暖费_间接")
    private BigDecimal rcsdnfJjUnpaid;
    /**
     * 日常水电暖费_专项_间接_未支付
     */
    @UnPaidFieldDescription("日常水电暖费_专项_间接")
    private BigDecimal rcsdnfZxJjUnpaid;
    /**
     * 日常水电暖费_自筹_间接_未支付
     */
    @UnPaidFieldDescription("日常水电暖费_自筹_间接")
    private BigDecimal rcsdnfZcJjUnpaid;
    /**
     * 资料费_间接_未支付
     */
    @UnPaidFieldDescription("资料费_间接")
    private BigDecimal zlfJjUnpaid;
    /**
     * 资料费_专项_间接_未支付
     */
    @UnPaidFieldDescription("资料费_专项_间接")
    private BigDecimal zlfZxJjUnpaid;
    /**
     * 资料费_自筹_间接_未支付
     */
    @UnPaidFieldDescription("资料费_自筹_间接")
    private BigDecimal zlfZcJjUnpaid;
    /**
     * 数据样本采集费_间接_未支付
     */
    @UnPaidFieldDescription("数据样本采集费_间接")
    private BigDecimal sjybcjfJjUnpaid;
    /**
     * 数据样本采集费_专项_间接_未支付
     */
    @UnPaidFieldDescription("数据样本采集费_专项_间接")
    private BigDecimal sjybcjfZxJjUnpaid;
    /**
     * 数据样本采集费_自筹_间接_未支付
     */
    @UnPaidFieldDescription("数据样本采集费_自筹_间接")
    private BigDecimal sjybcjfZcJjUnpaid;
    /**
     * 测试化验加工费_间接_未支付
     */
    @UnPaidFieldDescription("测试化验加工费_间接")
    private BigDecimal cshyjgfJjUnpaid;
    /**
     * 测试化验加工费_专项_间接_未支付
     */
    @UnPaidFieldDescription("测试化验加工费_专项_间接")
    private BigDecimal cshyjgfZxJjUnpaid;
    /**
     * 测试化验加工费_自筹_间接_未支付
     */
    @UnPaidFieldDescription("测试化验加工费_自筹_间接")
    private BigDecimal cshyjgfZcJjUnpaid;
    /**
     * 燃料动力费_间接_未支付
     */
    @UnPaidFieldDescription("燃料动力费_间接")
    private BigDecimal rldlfJjUnpaid;
    /**
     * 燃料动力费_专项_间接_未支付
     */
    @UnPaidFieldDescription("燃料动力费_专项_间接")
    private BigDecimal rldlfZxJjUnpaid;
    /**
     * 燃料动力费_自筹_间接_未支付
     */
    @UnPaidFieldDescription("燃料动力费_自筹_间接")
    private BigDecimal rldlfZcJjUnpaid;
    /**
     * 办公费_间接_未支付
     */
    @UnPaidFieldDescription("办公费_间接")
    private BigDecimal bgfJjUnpaid;
    /**
     * 办公费_专项_间接_未支付
     */
    @UnPaidFieldDescription("办公费_专项_间接")
    private BigDecimal bgfZxJjUnpaid;
    /**
     * 办公费_自筹_间接_未支付
     */
    @UnPaidFieldDescription("办公费_自筹_间接")
    private BigDecimal bgfZcJjUnpaid;
    /**
     * 印刷出版费_间接_未支付
     */
    @UnPaidFieldDescription("印刷出版费_间接")
    private BigDecimal yscbfJjUnpaid;
    /**
     * 印刷出版费_专项_间接_未支付
     */
    @UnPaidFieldDescription("印刷出版费_专项_间接")
    private BigDecimal yscbfZxJjUnpaid;
    /**
     * 印刷出版费_自筹_间接_未支付
     */
    @UnPaidFieldDescription("印刷出版费_自筹_间接")
    private BigDecimal yscbfZcJjUnpaid;
    /**
     * 知识产权事务费_间接_未支付
     */
    @UnPaidFieldDescription("知识产权事务费_间接")
    private BigDecimal zscqswfJjUnpaid;
    /**
     * 知识产权事务费_专项_间接_未支付
     */
    @UnPaidFieldDescription("知识产权事务费_专项_间接")
    private BigDecimal zscqswfZxJjUnpaid;
    /**
     * 知识产权事务费_自筹_间接_未支付
     */
    @UnPaidFieldDescription("知识产权事务费_自筹_间接")
    private BigDecimal zscqswfZcJjUnpaid;
    /**
     * 车辆使用费_间接_未支付
     */
    @UnPaidFieldDescription("车辆使用费_间接")
    private BigDecimal clsyfJjUnpaid;
    /**
     * 车辆使用费_专项_间接_未支付
     */
    @UnPaidFieldDescription("车辆使用费_专项_间接")
    private BigDecimal clsyfZxJjUnpaid;
    /**
     * 车辆使用费_自筹_间接_未支付
     */
    @UnPaidFieldDescription("车辆使用费_自筹_间接")
    private BigDecimal clsyfZcJjUnpaid;
    /**
     * 差旅费_间接_未支付
     */
    @UnPaidFieldDescription("差旅费_间接")
    private BigDecimal chlfJjUnpaid;
    /**
     * 差旅费_专项_间接_未支付
     */
    @UnPaidFieldDescription("差旅费_专项_间接")
    private BigDecimal chlfZxJjUnpaid;
    /**
     * 差旅费_自筹_间接_未支付
     */
    @UnPaidFieldDescription("差旅费_自筹_间接")
    private BigDecimal chlfZcJjUnpaid;
    /**
     * 会议会务费_间接_未支付
     */
    @UnPaidFieldDescription("会议会务费_间接")
    private BigDecimal hyhwfJjUnpaid;
    /**
     * 会议会务费_专项_间接_未支付
     */
    @UnPaidFieldDescription("会议会务费_专项_间接")
    private BigDecimal hyhwfZxJjUnpaid;
    /**
     * 会议会务费_自筹_间接_未支付
     */
    @UnPaidFieldDescription("会议会务费_自筹_间接")
    private BigDecimal hyhwfZcJjUnpaid;
    /**
     * 专家咨询费_间接_未支付
     */
    @UnPaidFieldDescription("专家咨询费_间接")
    private BigDecimal zjzxfJjUnpaid;
    /**
     * 专家咨询费_专项_间接_未支付
     */
    @UnPaidFieldDescription("专家咨询费_专项_间接")
    private BigDecimal zjzxfZxJjUnpaid;
    /**
     * 专家咨询费_自筹_间接_未支付
     */
    @UnPaidFieldDescription("专家咨询费_自筹_间接")
    private BigDecimal zjzxfZcJjUnpaid;
}
