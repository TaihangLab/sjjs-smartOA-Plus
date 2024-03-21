package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.FundsFieldDescription;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 项目经费表（单位：万元）
 * @TableName project_funds
 */
@TableName(value = "project_funds")
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
     * 项目经费总额
     */
    @FundsFieldDescription("项目经费总额")
    private BigDecimal totalFundsAll;

    /**
     * 直接经费总额
     */
    @FundsFieldDescription("直接经费总额")
    private BigDecimal totalFundsZj;

    /**
     * 间接经费总额
     */
    @FundsFieldDescription("间接经费总额")
    private BigDecimal totalFundsJj;

    /**
     * 专项经费总额
     */
    @FundsFieldDescription("专项经费总额")
    private BigDecimal totalFundsZx;

    /**
     * 专项到款总额
     */
    @FundsFieldDescription("专项到款总额")
    private BigDecimal totalFundsZxDk;

    /**
     * 已完成自筹投资
     */
    private BigDecimal zctzDone;

    /**
     * 已完成专项投资
     */
    private BigDecimal zxtzDone;

    /**
     * 自筹经费公司配套
     */
    private BigDecimal zcGspt;

    /**
     * 专项经费公司留存（计划）
     */
    private BigDecimal zxGslc;

    /**
     * 专项设备费
     */
    @FundsFieldDescription("专项设备费")
    private BigDecimal sbfZx;

    /**
     * 设备费_直接
     */
    @FundsFieldDescription("设备费_直接")
    private BigDecimal sbfZj;

    /**
     * 专项直接费用
     */
    @FundsFieldDescription("专项直接费用")
    private BigDecimal totalFundsZxZj;

    /**
     * 专项间接费用
     */
    @FundsFieldDescription("专项间接费用")
    private BigDecimal totalFundsZxJj;

    /**
     * 自筹经费总额
     */
    @FundsFieldDescription("自筹经费总额")
    private BigDecimal totalFundsZc;

    /**
     * 自筹设备费
     */
    @FundsFieldDescription("自筹设备费")
    private BigDecimal sbfZc;

    /**
     * 自筹直接费用
     */
    @FundsFieldDescription("自筹直接费用")
    private BigDecimal totalFundsZcZj;

    /**
     * 自筹间接费用
     */
    @FundsFieldDescription("自筹间接费用")
    private BigDecimal totalFundsZcJj;

    /**
     * 设备费_专项_直接
     */
    @FundsFieldDescription("设备费_专项_直接")
    private BigDecimal sbfZxZj;

    /**
     * 设备费_自筹_直接
     */
    @FundsFieldDescription("设备费_自筹_直接")
    private BigDecimal sbfZcZj;

    /**
     * 设备费_购置设备费_专项_直接
     */
    @FundsFieldDescription("设备费_购置设备费_专项_直接")
    private BigDecimal sbfGzsbZxZj;

    /**
     * 设备费_购置设备费_自筹_直接
     */
    @FundsFieldDescription("设备费_购置设备费_自筹_直接")
    private BigDecimal sbfGzsbZcZj;
    /**
     * 设备费_购置设备费_直接
     */
    @FundsFieldDescription("设备费_购置设备费_直接")
    private BigDecimal sbfGzsbZj;

    /**
     * 设备费_试制设备费_专项_直接
     */
    @FundsFieldDescription("设备费_试制设备费_专项_直接")
    private BigDecimal sbfSzsbZxZj;

    /**
     * 设备费_试制设备费_自筹_直接
     */
    @FundsFieldDescription("设备费_试制设备费_自筹_直接")
    private BigDecimal sbfSzsbZcZj;
    /**
     * 设备费_试制设备费_直接
     */
    @FundsFieldDescription("设备费_试制设备费_直接")
    private BigDecimal sbfSzsbZj;

    /**
     * 设备费_设备升级改造费_专项_直接
     */
    @FundsFieldDescription("设备费_设备升级改造费_专项_直接")
    private BigDecimal sbfSbsjgzZxZj;

    /**
     * 设备费_设备升级改造费_自筹_直接
     */
    @FundsFieldDescription("设备费_设备升级改造费_自筹_直接")
    private BigDecimal sbfSbsjgzZcZj;
    /**
     * 设备费_设备升级改造费_直接
     */
    @FundsFieldDescription("设备费_设备升级改造费_直接")
    private BigDecimal sbfSbsjgzZj;

    /**
     * 设备费_设备租赁费_专项_直接
     */
    @FundsFieldDescription("设备费_设备租赁费_专项_直接")
    private BigDecimal sbfSbzlZxZj;

    /**
     * 设备费_设备租赁费_自筹_直接
     */
    @FundsFieldDescription("设备费_设备租赁费_自筹_直接")
    private BigDecimal sbfSbzlZcZj;

    /**
     * 业务费_直接
     */
    @FundsFieldDescription("业务费_直接")
    private BigDecimal ywfZj;

    /**
     * 业务费_专项_直接
     */
    @FundsFieldDescription("业务费_专项_直接")
    private BigDecimal ywfZxZj;

    /**
     * 业务费_自筹_直接
     */
    @FundsFieldDescription("业务费_自筹_直接")
    private BigDecimal ywfZcZj;
    /**
     * 设备费_设备租赁费_直接
     */
    @FundsFieldDescription("设备费_设备租赁费_直接")
    private BigDecimal sbfSbzlZj;

    /**
     * 业务费_材料费_专项_直接
     */
    @FundsFieldDescription("业务费_材料费_专项_直接")
    private BigDecimal ywfClfZxZj;

    /**
     * 业务费_材料费_自筹_直接
     */
    @FundsFieldDescription("业务费_材料费_自筹_直接")
    private BigDecimal ywfClfZcZj;
    /**
     * 业务费_材料费_直接
     */
    @FundsFieldDescription("业务费_材料费_直接")
    private BigDecimal ywfClfZj;

    /**
     * 业务费_资料费_专项_直接
     */
    @FundsFieldDescription("业务费_资料费_专项_直接")
    private BigDecimal ywfZlfZxZj;

    /**
     * 业务费_资料费_自筹_直接
     */
    @FundsFieldDescription("业务费_资料费_自筹_直接")
    private BigDecimal ywfZlfZcZj;
    /**
     * 业务费_资料费_直接
     */
    @FundsFieldDescription("业务费_资料费_直接")
    private BigDecimal ywfZlfZj;

    /**
     * 业务费_数据样本采集费_专项_直接
     */
    @FundsFieldDescription("业务费_数据样本采集费_专项_直接")
    private BigDecimal ywfSjybcjfZxZj;

    /**
     * 业务费_数据样本采集费_自筹_直接
     */
    @FundsFieldDescription("业务费_数据样本采集费_自筹_直接")
    private BigDecimal ywfSjybcjfZcZj;
    /**
     * 业务费_数据样本采集费_直接
     */
    @FundsFieldDescription("业务费_数据样本采集费_直接")
    private BigDecimal ywfSjybcjfZj;

    /**
     * 业务费_测试化验加工费_专项_直接
     */
    @FundsFieldDescription("业务费_测试化验加工费_专项_直接")
    private BigDecimal ywfCshyjgfZxZj;

    /**
     * 业务费_测试化验加工费_自筹_直接
     */
    @FundsFieldDescription("业务费_测试化验加工费_自筹_直接")
    private BigDecimal ywfCshyjgfZcZj;
    /**
     * 业务费_测试化验加工费_直接
     */
    @FundsFieldDescription("业务费_测试化验加工费_直接")
    private BigDecimal ywfCshyjgfZj;

    /**
     * 业务费_燃料动力费_专项_直接
     */
    @FundsFieldDescription("业务费_燃料动力费_专项_直接")
    private BigDecimal ywfRldlfZxZj;

    /**
     * 业务费_燃料动力费_自筹_直接
     */
    @FundsFieldDescription("业务费_燃料动力费_自筹_直接")
    private BigDecimal ywfRldlfZcZj;
    /**
     * 业务费_燃料动力费_直接
     */
    @FundsFieldDescription("业务费_燃料动力费_直接")
    private BigDecimal ywfRldlfZj;

    /**
     * 业务费_办公费_专项_直接
     */
    @FundsFieldDescription("业务费_办公费_专项_直接")
    private BigDecimal ywfBgfZxZj;

    /**
     * 业务费_办公费_自筹_直接
     */
    @FundsFieldDescription("业务费_办公费_自筹_直接")
    private BigDecimal ywfBgfZcZj;
    /**
     * 业务费_办公费_直接
     */
    @FundsFieldDescription("业务费_办公费_直接")
    private BigDecimal ywfBgfZj;

    /**
     * 业务费_印刷出版费_专项_直接
     */
    @FundsFieldDescription("业务费_印刷出版费_专项_直接")
    private BigDecimal ywfYscbfZxZj;

    /**
     * 业务费_印刷出版费_自筹_直接
     */
    @FundsFieldDescription("业务费_印刷出版费_自筹_直接")
    private BigDecimal ywfYscbfZcZj;
    /**
     * 业务费_印刷出版费_直接
     */
    @FundsFieldDescription("业务费_印刷出版费_直接")
    private BigDecimal ywfYscbfZj;

    /**
     * 业务费_知识产权事务费_专项_直接
     */
    @FundsFieldDescription("业务费_知识产权事务费_专项_直接")
    private BigDecimal ywfZscqswfZxZj;

    /**
     * 业务费_知识产权事务费_自筹_直接
     */
    @FundsFieldDescription("业务费_知识产权事务费_自筹_直接")
    private BigDecimal ywfZscqswfZcZj;
    /**
     * 业务费_知识产权事务费_直接
     */
    @FundsFieldDescription("业务费_知识产权事务费_直接")
    private BigDecimal ywfZscqswfZj;

    /**
     * 业务费_车辆使用费_专项_直接
     */
    @FundsFieldDescription("业务费_车辆使用费_专项_直接")
    private BigDecimal ywfClsyfZxZj;

    /**
     * 业务费_车辆使用费_自筹_直接
     */
    @FundsFieldDescription("业务费_车辆使用费_自筹_直接")
    private BigDecimal ywfClsyfZcZj;
    /**
     * 业务费_车辆使用费_直接
     */
    @FundsFieldDescription("业务费_车辆使用费_直接")
    private BigDecimal ywfClsyfZj;

    /**
     * 业务费_差旅费_专项_直接
     */
    @FundsFieldDescription("业务费_差旅费_专项_直接")
    private BigDecimal ywfChlfZxZj;

    /**
     * 业务费_差旅费_自筹_直接
     */
    @FundsFieldDescription("业务费_差旅费_自筹_直接")
    private BigDecimal ywfChlfZcZj;
    /**
     * 业务费_差旅费_直接
     */
    @FundsFieldDescription("业务费_差旅费_直接")
    private BigDecimal ywfChlfZj;

    /**
     * 业务费_会议会务费_专项_直接
     */
    @FundsFieldDescription("业务费_会议会务费_专项_直接")
    private BigDecimal ywfHyhwfZxZj;

    /**
     * 业务费_会议会务费_自筹_直接
     */
    @FundsFieldDescription("业务费_会议会务费_自筹_直接")
    private BigDecimal ywfHyhwfZcZj;
    /**
     * 业务费_会议会务费_直接
     */
    @FundsFieldDescription("业务费_会议会务费_直接")
    private BigDecimal ywfHyhwfZj;

    /**
     * 业务费_国内协作费_专项_直接
     */
    @FundsFieldDescription("业务费_国内协作费_专项_直接")
    private BigDecimal ywfGnxzfZxZj;

    /**
     * 业务费_国内协作费_自筹_直接
     */
    @FundsFieldDescription("业务费_国内协作费_自筹_直接")
    private BigDecimal ywfGnxzfZcZj;

    /**
     * 业务费_国际合作交流费_直接
     */
    @FundsFieldDescription("业务费_国际合作交流费_直接")
    private BigDecimal ywfGjhzjlfZj;

    /**
     * 业务费_国际合作交流费_专项_直接
     */
    @FundsFieldDescription("业务费_国际合作交流费_专项_直接")
    private BigDecimal ywfGjhzjlfZxZj;
    /**
     * 业务费_国内协作费_直接
     */
    @FundsFieldDescription("业务费_国内协作费_直接")
    private BigDecimal ywfGnxzfZj;

    /**
     * 业务费_会议/差旅/国际合作与交流费_直接
     */
    @FundsFieldDescription("业务费_会议/差旅/国际合作与交流费_直接")
    private BigDecimal ywfHyclgjhzyjlfZj;

    /**
     * 业务费_会议/差旅/国际合作与交流费_专项_直接
     */
    @FundsFieldDescription("业务费_会议/差旅/国际合作与交流费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfZxZj;

    /**
     * 业务费_会议/差旅/国际合作与交流费_自筹_直接
     */
    @FundsFieldDescription("业务费_会议/差旅/国际合作与交流费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfZcZj;
    /**
     * 业务费_国际合作交流费_自筹_直接
     */
    @FundsFieldDescription("业务费_国际合作交流费_自筹_直接")
    private BigDecimal ywfGjhzjlfZcZj;

    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_专项_直接
     */
    @FundsFieldDescription("业务费_会议/差旅/国际合作与交流费_会议费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfHyfZxZj;

    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_自筹_直接
     */
    @FundsFieldDescription("业务费_会议/差旅/国际合作与交流费_会议费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfHyfZcZj;
    /**
     * 业务费_会议/差旅/国际合作与交流费_会议费_直接
     */
    @FundsFieldDescription("业务费_会议/差旅/国际合作与交流费_会议费_直接")
    private BigDecimal ywfHyclgjhzyjlfHyfZj;

    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_专项_直接
     */
    @FundsFieldDescription("业务费_会议/差旅/国际合作与交流费_差旅费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfClfZxZj;

    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_自筹_直接
     */
    @FundsFieldDescription("业务费_会议/差旅/国际合作与交流费_差旅费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfClfZcZj;
    /**
     * 业务费_会议/差旅/国际合作与交流费_差旅费_直接
     */
    @FundsFieldDescription("业务费_会议/差旅/国际合作与交流费_差旅费_直接")
    private BigDecimal ywfHyclgjhzyjlfClfZj;

    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_专项_直接
     */
    @FundsFieldDescription("业务费_会议/差旅/国际合作与交流费_国际合作费_专项_直接")
    private BigDecimal ywfHyclgjhzyjlfGjhzfZxZj;

    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_自筹_直接
     */
    @FundsFieldDescription("业务费_会议/差旅/国际合作与交流费_国际合作费_自筹_直接")
    private BigDecimal ywfHyclgjhzyjlfGjhzfZcZj;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_直接
     */
    @FundsFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZj;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_专项_直接
     */
    @FundsFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZxZj;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_自筹_直接
     */
    @FundsFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZcZj;
    /**
     * 业务费_会议/差旅/国际合作与交流费_国际合作费_直接
     */
    @FundsFieldDescription("业务费_会议/差旅/国际合作与交流费_国际合作费_直接")
    private BigDecimal ywfHyclgjhzyjlfGjhzfZj;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_专项_直接
     */
    @FundsFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZxZj;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_自筹_直接
     */
    @FundsFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZcZj;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_直接
     */
    @FundsFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_直接")
    private BigDecimal ywfCbwxxxcbzscqswfZscqswfZj;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_专项_直接
     */
    @FundsFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZxZj;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_自筹_直接
     */
    @FundsFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZcZj;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_直接
     */
    @FundsFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_直接")
    private BigDecimal ywfCbwxxxcbzscqswfYsdyzzfZj;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_专项_直接
     */
    @FundsFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZxZj;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_自筹_直接
     */
    @FundsFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZcZj;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_直接
     */
    @FundsFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_直接")
    private BigDecimal ywfCbwxxxcbzscqswfWxsjkfZj;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_专项_直接
     */
    @FundsFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_信息传播费_专项_直接")
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZxZj;

    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_自筹_直接
     */
    @FundsFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_信息传播费_自筹_直接")
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZcZj;

    /**
     * 劳务费_直接
     */
    @FundsFieldDescription("劳务费_直接")
    private BigDecimal lwfZj;

    /**
     * 劳务费_专项_直接
     */
    @FundsFieldDescription("劳务费_专项_直接")
    private BigDecimal lwfZxZj;

    /**
     * 劳务费_自筹_直接
     */
    @FundsFieldDescription("劳务费_自筹_直接")
    private BigDecimal lwfZcZj;
    /**
     * 业务费_出版/文献/信息传播/知识产权事务费_信息传播费_直接
     */
    @FundsFieldDescription("业务费_出版/文献/信息传播/知识产权事务费_信息传播费_直接")
    private BigDecimal ywfCbwxxxcbzscqswfXxcbfZj;

    /**
     * 劳务费_专家咨询费_专项_直接
     */
    @FundsFieldDescription("劳务费_专家咨询费_专项_直接")
    private BigDecimal lwfZjzxfZxZj;

    /**
     * 劳务费_专家咨询费_自筹_直接
     */
    @FundsFieldDescription("劳务费_专家咨询费_自筹_直接")
    private BigDecimal lwfZjzxfZcZj;
    /**
     * 劳务费_专家咨询费_直接
     */
    @FundsFieldDescription("劳务费_专家咨询费_直接")
    private BigDecimal lwfZjzxfZj;

    /**
     * 劳务费_人员劳务费_专项_直接
     */
    @FundsFieldDescription("劳务费_人员劳务费_专项_直接")
    private BigDecimal lwfRylwfZxZj;

    /**
     * 劳务费_人员劳务费_自筹_直接
     */
    @FundsFieldDescription("劳务费_人员劳务费_自筹_直接")
    private BigDecimal lwfRylwfZcZj;

    /**
     * 材料费_直接
     */
    @FundsFieldDescription("材料费_直接")
    private BigDecimal clfZj;

    /**
     * 材料费_专项_直接
     */
    @FundsFieldDescription("材料费_专项_直接")
    private BigDecimal clfZxZj;

    /**
     * 材料费_自筹_直接
     */
    @FundsFieldDescription("材料费_自筹_直接")
    private BigDecimal clfZcZj;
    /**
     * 劳务费_人员劳务费_直接
     */
    @FundsFieldDescription("劳务费_人员劳务费_直接")
    private BigDecimal lwfRylwfZj;

    /**
     * 材料费_材料费_专项_直接
     */
    @FundsFieldDescription("材料费_材料费_专项_直接")
    private BigDecimal clfClfZxZj;

    /**
     * 材料费_材料费_自筹_直接
     */
    @FundsFieldDescription("材料费_材料费_自筹_直接")
    private BigDecimal clfClfZcZj;

    /**
     * 科研活动费_直接
     */
    @FundsFieldDescription("科研活动费_直接")
    private BigDecimal kyhdfZj;

    /**
     * 科研活动费_专项_直接
     */
    @FundsFieldDescription("科研活动费_专项_直接")
    private BigDecimal kyhdfZxZj;

    /**
     * 科研活动费_自筹_直接
     */
    @FundsFieldDescription("科研活动费_自筹_直接")
    private BigDecimal kyhdfZcZj;
    /**
     * 材料费_材料费_直接
     */
    @FundsFieldDescription("材料费_材料费_直接")
    private BigDecimal clfClfZj;

    /**
     * 科研活动费_资料费_专项_直接
     */
    @FundsFieldDescription("科研活动费_资料费_专项_直接")
    private BigDecimal kyhdfZlZxZj;

    /**
     * 科研活动费_资料费_自筹_直接
     */
    @FundsFieldDescription("科研活动费_资料费_自筹_直接")
    private BigDecimal kyhdfZlZcZj;
    /**
     * 科研活动费_资料费_直接
     */
    @FundsFieldDescription("科研活动费_资料费_直接")
    private BigDecimal kyhdfZlZj;

    /**
     * 科研活动费_测试化验加工费_专项_直接
     */
    @FundsFieldDescription("科研活动费_测试化验加工费_专项_直接")
    private BigDecimal kyhdfCshyjgZxZj;

    /**
     * 科研活动费_测试化验加工费_自筹_直接
     */
    @FundsFieldDescription("科研活动费_测试化验加工费_自筹_直接")
    private BigDecimal kyhdfCshyjgZcZj;
    /**
     * 科研活动费_测试化验加工费_直接
     */
    @FundsFieldDescription("科研活动费_测试化验加工费_直接")
    private BigDecimal kyhdfCshyjgZj;

    /**
     * 科研活动费_办公费_专项_直接
     */
    @FundsFieldDescription("科研活动费_办公费_专项_直接")
    private BigDecimal kyhdfBgZxZj;

    /**
     * 科研活动费_办公费_自筹_直接
     */
    @FundsFieldDescription("科研活动费_办公费_自筹_直接")
    private BigDecimal kyhdfBgZcZj;
    /**
     * 科研活动费_办公费_直接
     */
    @FundsFieldDescription("科研活动费_办公费_直接")
    private BigDecimal kyhdfBgZj;

    /**
     * 科研活动费_数据/样本采集费_专项_直接
     */
    @FundsFieldDescription("科研活动费_数据/样本采集费_专项_直接")
    private BigDecimal kyhdfSjybcjZxZj;

    /**
     * 科研活动费_数据/样本采集费_自筹_直接
     */
    @FundsFieldDescription("科研活动费_数据/样本采集费_自筹_直接")
    private BigDecimal kyhdfSjybcjZcZj;
    /**
     * 科研活动费_数据/样本采集费_直接
     */
    @FundsFieldDescription("科研活动费_数据/样本采集费_直接")
    private BigDecimal kyhdfSjybcjZj;

    /**
     * 科研活动费_印刷/出版费_专项_直接
     */
    @FundsFieldDescription("科研活动费_印刷/出版费_专项_直接")
    private BigDecimal kyhdfYscbZxZj;

    /**
     * 科研活动费_印刷/出版费_自筹_直接
     */
    @FundsFieldDescription("科研活动费_印刷/出版费_自筹_直接")
    private BigDecimal kyhdfYscbZcZj;
    /**
     * 科研活动费_印刷/出版费_直接
     */
    @FundsFieldDescription("科研活动费_印刷/出版费_直接")
    private BigDecimal kyhdfYscbZj;

    /**
     * 科研活动费_知识产权事务费_专项_直接
     */
    @FundsFieldDescription("科研活动费_知识产权事务费_专项_直接")
    private BigDecimal kyhdfZscqswZxZj;

    /**
     * 科研活动费_知识产权事务费_自筹_直接
     */
    @FundsFieldDescription("科研活动费_知识产权事务费_自筹_直接")
    private BigDecimal kyhdfZscqswZcZj;
    /**
     * 科研活动费_知识产权事务费_直接
     */
    @FundsFieldDescription("科研活动费_知识产权事务费_直接")
    private BigDecimal kyhdfZscqswZj;

    /**
     * 科研活动费_燃料动力费_专项_直接
     */
    @FundsFieldDescription("科研活动费_燃料动力费_专项_直接")
    private BigDecimal kyhdfRldlZxZj;

    /**
     * 科研活动费_燃料动力费_自筹_直接
     */
    @FundsFieldDescription("科研活动费_燃料动力费_自筹_直接")
    private BigDecimal kyhdfRldlZcZj;
    /**
     * 科研活动费_燃料动力费_直接
     */
    @FundsFieldDescription("科研活动费_燃料动力费_直接")
    private BigDecimal kyhdfRldlZj;

    /**
     * 科研活动费_车辆使用费_专项_直接
     */
    @FundsFieldDescription("科研活动费_车辆使用费_专项_直接")
    private BigDecimal kyhdfClsyZxZj;

    /**
     * 科研活动费_车辆使用费_自筹_直接
     */
    @FundsFieldDescription("科研活动费_车辆使用费_自筹_直接")
    private BigDecimal kyhdfClsyZcZj;

    /**
     * 科研服务费_直接
     */
    @FundsFieldDescription("科研服务费_直接")
    private BigDecimal kyfwfZj;

    /**
     * 科研服务费_专项_直接
     */
    @FundsFieldDescription("科研服务费_专项_直接")
    private BigDecimal kyfwfZxZj;

    /**
     * 科研服务费_自筹_直接
     */
    @FundsFieldDescription("科研服务费_自筹_直接")
    private BigDecimal kyfwfZcZj;
    /**
     * 科研活动费_车辆使用费_直接
     */
    @FundsFieldDescription("科研活动费_车辆使用费_直接")
    private BigDecimal kyhdfClsyZj;

    /**
     * 科研服务费_专家咨询费_专项_直接
     */
    @FundsFieldDescription("科研服务费_专家咨询费_专项_直接")
    private BigDecimal kyfwfZjzxZxZj;

    /**
     * 科研服务费_专家咨询费_自筹_直接
     */
    @FundsFieldDescription("科研服务费_专家咨询费_自筹_直接")
    private BigDecimal kyfwfZjzxZcZj;
    /**
     * 科研服务费_专家咨询费_直接
     */
    @FundsFieldDescription("科研服务费_专家咨询费_直接")
    private BigDecimal kyfwfZjzxZj;

    /**
     * 科研服务费_差旅费_专项_直接
     */
    @FundsFieldDescription("科研服务费_差旅费_专项_直接")
    private BigDecimal kyfwfClZxZj;

    /**
     * 科研服务费_差旅费_自筹_直接
     */
    @FundsFieldDescription("科研服务费_差旅费_自筹_直接")
    private BigDecimal kyfwfClZcZj;
    /**
     * 科研服务费_差旅费_直接
     */
    @FundsFieldDescription("科研服务费_差旅费_直接")
    private BigDecimal kyfwfClZj;

    /**
     * 科研服务费_会议/会务费_专项_直接
     */
    @FundsFieldDescription("科研服务费_会议/会务费_专项_直接")
    private BigDecimal kyfwfHyhwZxZj;

    /**
     * 科研服务费_会议/会务费_自筹_直接
     */
    @FundsFieldDescription("科研服务费_会议/会务费_自筹_直接")
    private BigDecimal kyfwfHyhwZcZj;

    /**
     * 科研服务费_国际合作交流_直接
     */
    @FundsFieldDescription("科研服务费_国际合作交流_直接")
    private BigDecimal kyfwfGjhzjlZj;
    /**
     * 科研服务费_会议/会务费_直接
     */
    @FundsFieldDescription("科研服务费_会议/会务费_直接")
    private BigDecimal kyfwfHyhwZj;

    /**
     * 科研服务费_国际合作交流_自筹_直接
     */
    @FundsFieldDescription("科研服务费_国际合作交流_自筹_直接")
    private BigDecimal kyfwfGjhzjlZcZj;
    /**
     * 科研服务费_国际合作交流_专项_直接
     */
    @FundsFieldDescription("科研服务费_国际合作交流_专项_直接")
    private BigDecimal kyfwfGjhzjlZxZj;

    /**
     * 科研服务费_国内协作费_专项_直接
     */
    @FundsFieldDescription("科研服务费_国内协作费_专项_直接")
    private BigDecimal kyfwfGnxzZxZj;

    /**
     * 科研服务费_国内协作费_自筹_直接
     */
    @FundsFieldDescription("科研服务费_国内协作费_自筹_直接")
    private BigDecimal kyfwfGnxzZcZj;

    /**
     * 人员和劳务补助费_直接
     */
    @FundsFieldDescription("人员和劳务补助费_直接")
    private BigDecimal ryhlwbzfZj;

    /**
     * 人员和劳务补助费_专项_直接
     */
    @FundsFieldDescription("人员和劳务补助费_专项_直接")
    private BigDecimal ryhlwbzfZxZj;

    /**
     * 人员和劳务补助费_自筹_直接
     */
    @FundsFieldDescription("人员和劳务补助费_自筹_直接")
    private BigDecimal ryhlwbzfZcZj;
    /**
     * 科研服务费_国内协作费_直接
     */
    @FundsFieldDescription("科研服务费_国内协作费_直接")
    private BigDecimal kyfwfGnxzZj;

    /**
     * 人员和劳务补助费_人员劳务费_专项_直接
     */
    @FundsFieldDescription("人员和劳务补助费_人员劳务费_专项_直接")
    private BigDecimal ryhlwbzfRylwZxZj;

    /**
     * 人员和劳务补助费_人员劳务费_自筹_直接
     */
    @FundsFieldDescription("人员和劳务补助费_人员劳务费_自筹_直接")
    private BigDecimal ryhlwbzfRylwZcZj;

    /**
     * 绩效支出_间接
     */
    @FundsFieldDescription("绩效支出_间接")
    private BigDecimal jxzcJj;

    /**
     * 绩效支出_专项_间接
     */
    @FundsFieldDescription("绩效支出_专项_间接")
    private BigDecimal jxzcZxJj;
    /**
     * 人员和劳务补助费_人员劳务费_直接
     */
    @FundsFieldDescription("人员和劳务补助费_人员劳务费_直接")
    private BigDecimal ryhlwbzfRylwZj;
    /**
     * 绩效支出_自筹_间接
     */
    @FundsFieldDescription("绩效支出_自筹_间接")
    private BigDecimal jxzcZcJj;
    /**
     * 其他支出_间接
     */
    @FundsFieldDescription("其他支出_间接")
    private BigDecimal othersJj;
    /**
     * 其他支出_专项_间接
     */
    @FundsFieldDescription("其他支出_专项_间接")
    private BigDecimal othersZxJj;

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
     * 其他支出_自筹_间接
     */
    @FundsFieldDescription("其他支出_自筹_间接")
    private BigDecimal othersZcJj;

    /**
     * 设备费_专项_间接
     */
    @FundsFieldDescription("设备费_专项_间接")
    private BigDecimal sbfZxJj;

    /**
     * 设备费_自筹_间接
     */
    @FundsFieldDescription("设备费_自筹_间接")
    private BigDecimal sbfZcJj;
    /**
     * 设备费_间接
     */
    @FundsFieldDescription("设备费_间接")
    private BigDecimal sbfJj;

    /**
     * 材料费_专项_间接
     */
    @FundsFieldDescription("材料费_专项_间接")
    private BigDecimal clfZxJj;

    /**
     * 材料费_自筹_间接
     */
    @FundsFieldDescription("材料费_自筹_间接")
    private BigDecimal clfZcJj;
    /**
     * 材料费_间接
     */
    @FundsFieldDescription("材料费_间接")
    private BigDecimal clfJj;
    /**
     * 管理费_间接
     */
    @FundsFieldDescription("管理费_间接")
    private BigDecimal glfJj;
    /**
     * 管理费_专项_间接
     */
    @FundsFieldDescription("管理费_专项_间接")
    private BigDecimal glfZxJj;
    /**
     * 管理费_自筹_间接
     */
    @FundsFieldDescription("管理费_自筹_间接")
    private BigDecimal glfZcJj;
    /**
     * 房屋租赁费_间接
     */
    @FundsFieldDescription("房屋租赁费_间接")
    private BigDecimal fwzjfJj;
    /**
     * 房屋租赁费_自筹_间接
     */
    @FundsFieldDescription("房屋租赁费_自筹_间接")
    private BigDecimal fwzjfZcJj;
    /**
     * 房屋租赁费_专项_间接
     */
    @FundsFieldDescription("房屋租赁费_专项_间接")
    private BigDecimal fwzjfZxJj;
    /**
     * 日常水电暖费_间接
     */
    @FundsFieldDescription("日常水电暖费_间接")
    private BigDecimal rcsdnfJj;
    /**
     * 日常水电暖费_专项_间接
     */
    @FundsFieldDescription("日常水电暖费_专项_间接")
    private BigDecimal rcsdnfZxJj;
    /**
     * 日常水电暖费_自筹_间接
     */
    @FundsFieldDescription("日常水电暖费_自筹_间接")
    private BigDecimal rcsdnfZcJj;
    /**
     * 资料费_间接
     */
    @FundsFieldDescription("资料费_间接")
    private BigDecimal zlfJj;
    /**
     * 资料费_专项_间接
     */
    @FundsFieldDescription("资料费_专项_间接")
    private BigDecimal zlfZxJj;
    /**
     * 资料费_自筹_间接
     */
    @FundsFieldDescription("资料费_自筹_间接")
    private BigDecimal zlfZcJj;
    /**
     * 数据样本采集费_间接
     */
    @FundsFieldDescription("数据样本采集费_间接")
    private BigDecimal sjybcjfJj;
    /**
     * 数据样本采集费_专项_间接
     */
    @FundsFieldDescription("数据样本采集费_专项_间接")
    private BigDecimal sjybcjfZxJj;
    /**
     * 数据样本采集费_自筹_间接
     */
    @FundsFieldDescription("数据样本采集费_自筹_间接")
    private BigDecimal sjybcjfZcJj;
    /**
     * 测试化验加工费_间接
     */
    @FundsFieldDescription("测试化验加工费_间接")
    private BigDecimal cshyjgfJj;
    /**
     * 测试化验加工费_专项_间接
     */
    @FundsFieldDescription("测试化验加工费_专项_间接")
    private BigDecimal cshyjgfZxJj;
    /**
     * 测试化验加工费_自筹_间接
     */
    @FundsFieldDescription("测试化验加工费_自筹_间接")
    private BigDecimal cshyjgfZcJj;
    /**
     * 燃料动力费_间接
     */
    @FundsFieldDescription("燃料动力费_间接")
    private BigDecimal rldlfJj;
    /**
     * 燃料动力费_专项_间接
     */
    @FundsFieldDescription("燃料动力费_专项_间接")
    private BigDecimal rldlfZxJj;
    /**
     * 燃料动力费_自筹_间接
     */
    @FundsFieldDescription("燃料动力费_自筹_间接")
    private BigDecimal rldlfZcJj;
    /**
     * 办公费_间接
     */
    @FundsFieldDescription("办公费_间接")
    private BigDecimal bgfJj;
    /**
     * 办公费_专项_间接
     */
    @FundsFieldDescription("办公费_专项_间接")
    private BigDecimal bgfZxJj;
    /**
     * 办公费_自筹_间接
     */
    @FundsFieldDescription("办公费_自筹_间接")
    private BigDecimal bgfZcJj;
    /**
     * 印刷出版费_间接
     */
    @FundsFieldDescription("印刷出版费_间接")
    private BigDecimal yscbfJj;
    /**
     * 印刷出版费_专项_间接
     */
    @FundsFieldDescription("印刷出版费_专项_间接")
    private BigDecimal yscbfZxJj;
    /**
     * 印刷出版费_自筹_间接
     */
    @FundsFieldDescription("印刷出版费_自筹_间接")
    private BigDecimal yscbfZcJj;
    /**
     * 知识产权事务费_间接
     */
    @FundsFieldDescription("知识产权事务费_间接")
    private BigDecimal zscqswfJj;
    /**
     * 知识产权事务费_专项_间接
     */
    @FundsFieldDescription("知识产权事务费_专项_间接")
    private BigDecimal zscqswfZxJj;
    /**
     * 知识产权事务费_自筹_间接
     */
    @FundsFieldDescription("知识产权事务费_自筹_间接")
    private BigDecimal zscqswfZcJj;
    /**
     * 车辆使用费_间接
     */
    @FundsFieldDescription("车辆使用费_间接")
    private BigDecimal clsyfJj;
    /**
     * 车辆使用费_专项_间接
     */
    @FundsFieldDescription("车辆使用费_专项_间接")
    private BigDecimal clsyfZxJj;
    /**
     * 车辆使用费_自筹_间接
     */
    @FundsFieldDescription("车辆使用费_自筹_间接")
    private BigDecimal clsyfZcJj;
    /**
     * 差旅费_间接
     */
    @FundsFieldDescription("差旅费_间接")
    private BigDecimal chlfJj;
    /**
     * 差旅费_专项_间接
     */
    @FundsFieldDescription("差旅费_专项_间接")
    private BigDecimal chlfZxJj;
    /**
     * 差旅费_自筹_间接
     */
    @FundsFieldDescription("差旅费_自筹_间接")
    private BigDecimal chlfZcJj;
    /**
     * 会议会务费_间接
     */
    @FundsFieldDescription("会议会务费_间接")
    private BigDecimal hyhwfJj;
    /**
     * 会议会务费_专项_间接
     */
    @FundsFieldDescription("会议会务费_专项_间接")
    private BigDecimal hyhwfZxJj;
    /**
     * 会议会务费_自筹_间接
     */
    @FundsFieldDescription("会议会务费_自筹_间接")
    private BigDecimal hyhwfZcJj;
    /**
     * 专家咨询费_间接
     */
    @FundsFieldDescription("专家咨询费_间接")
    private BigDecimal zjzxfJj;
    /**
     * 专家咨询费_专项_间接
     */
    @FundsFieldDescription("专家咨询费_专项_间接")
    private BigDecimal zjzxfZxJj;
    /**
     * 专家咨询费_自筹_间接
     */
    @FundsFieldDescription("专家咨询费_自筹_间接")
    private BigDecimal zjzxfZcJj;
}
