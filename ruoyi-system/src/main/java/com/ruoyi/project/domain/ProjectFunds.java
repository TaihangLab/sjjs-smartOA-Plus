package com.ruoyi.project.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.FundsFieldDescription;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 项目经费表（单位：万元）
 *
 * @TableName project_funds
 */
@TableName(value = "project_funds")
@Data
public class ProjectFunds implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
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
    @FundsFieldDescription(value = "项目经费总额")
    private BigDecimal totalFundsAll;
    /**
     * 直接经费总额
     */
    @FundsFieldDescription(value = "直接经费总额")
    private BigDecimal totalFundsZj;
    /**
     * 间接经费总额
     */
    @FundsFieldDescription(value = "间接经费总额")
    private BigDecimal totalFundsJj;
    /**
     * 专项经费总额
     */
    @FundsFieldDescription(value = "专项经费总额")
    private BigDecimal totalFundsZx;
    /**
     * 专项到款总额
     */
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
     * 业务费_国内合作交流费_专项_直接
     */
    @FundsFieldDescription("业务费_国内合作交流费_专项_直接")
    private BigDecimal ywfGjhzjlfZxZj;
    /**
     * 业务费_国内合作交流费_自筹_直接
     */
    @FundsFieldDescription("业务费_国内合作交流费_自筹_直接")
    private BigDecimal ywfGjhzjlfZcZj;
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
    private BigDecimal kyfwfGjhzjlZxZj;
    /**
     * 科研服务费_国际合作交流_自筹_直接
     */
    @FundsFieldDescription("科研服务费_国际合作交流_自筹_直接")
    private BigDecimal kyfwfGjhzjlZcZj;
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
     * 绩效支出_直接
     */
    @FundsFieldDescription("绩效支出_直接")
    private BigDecimal jxzcZj;
    /**
     * 绩效支出_专项_直接
     */
    @FundsFieldDescription("绩效支出_专项_直接")
    private BigDecimal jxzcZxZj;
    /**
     * 绩效支出_自筹_直接
     */
    @FundsFieldDescription("绩效支出_自筹_直接")
    private BigDecimal jxzcZcZj;
    /**
     * 间接费用_其他支出_专项
     */
    @FundsFieldDescription("间接费用_其他支出_专项")
    private BigDecimal othersZx;
    /**
     * 间接费用_其他支出_自筹
     */
    @FundsFieldDescription("间接费用_其他支出_自筹")
    private BigDecimal othersZc;
    /**
     * 经费来源_专项
     */
    @FundsFieldDescription("经费来源_专项")
    private BigDecimal jflyZx;
    /**
     * 经费来源_自筹
     */
    @FundsFieldDescription("经费来源_自筹")
    private BigDecimal jflyZc;
    /**
     * 经费来源_其他财政拨款_自筹
     */
    @FundsFieldDescription("经费来源_其他财政拨款_自筹")
    private BigDecimal jflyQtczbkZc;
    /**
     * 经费来源_单位自有货币资金_自筹
     */
    @FundsFieldDescription("经费来源_单位自有货币资金_自筹")
    private BigDecimal jflyDwzyhbzjZc;
    /**
     * 经费来源_其他资金_自筹
     */
    @FundsFieldDescription("经费来源_其他资金_自筹")
    private BigDecimal jflyQtzjZc;
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
     * 设备费_购置设备费_专项_间接
     */
    @FundsFieldDescription("设备费_购置设备费_专项_间接")
    private BigDecimal sbfGzsbZxJj;
    /**
     * 设备费_购置设备费_自筹_间接
     */
    @FundsFieldDescription("设备费_购置设备费_自筹_间接")
    private BigDecimal sbfGzsbZcJj;
    /**
     * 设备费_试制设备费_专项_间接
     */
    @FundsFieldDescription("设备费_试制设备费_专项_间接")
    private BigDecimal sbfSzsbZxJj;
    /**
     * 设备费_试制设备费_自筹_间接
     */
    @FundsFieldDescription("设备费_试制设备费_自筹_间接")
    private BigDecimal sbfSzsbZcJj;
    /**
     * 设备费_设备升级改造费_专项_间接
     */
    @FundsFieldDescription("设备费_设备升级改造费_专项_间接")
    private BigDecimal sbfSbsjgzZxJj;
    /**
     * 设备费_设备升级改造费_自筹_间接
     */
    @FundsFieldDescription("设备费_设备升级改造费_自筹_间接")
    private BigDecimal sbfSbsjgzZcJj;
    /**
     * 设备费_设备租赁费_专项_间接
     */
    @FundsFieldDescription("设备费_设备租赁费_专项_间接")
    private BigDecimal sbfSbzlZxJj;
    /**
     * 设备费_设备租赁费_自筹_间接
     */
    @FundsFieldDescription("设备费_设备租赁费_自筹_间接")
    private BigDecimal sbfSbzlZcJj;
    /**
     * 劳务费_专项_间接
     */
    @FundsFieldDescription("劳务费_专项_间接")
    private BigDecimal lwfZxJj;
    /**
     * 劳务费_自筹_间接
     */
    @FundsFieldDescription("劳务费_自筹_间接")
    private BigDecimal lwfZcJj;
    /**
     * 劳务费_专家咨询费_专项_间接
     */
    @FundsFieldDescription("劳务费_专家咨询费_专项_间接")
    private BigDecimal lwfZjzxfZxJj;
    /**
     * 劳务费_专家咨询费_自筹_间接
     */
    @FundsFieldDescription("劳务费_专家咨询费_自筹_间接")
    private BigDecimal lwfZjzxfZcJj;
    /**
     * 劳务费_人员劳务费_专项_间接
     */
    @FundsFieldDescription("劳务费_人员劳务费_专项_间接")
    private BigDecimal lwfRylwfZxJj;
    /**
     * 劳务费_人员劳务费_自筹_间接
     */
    @FundsFieldDescription("劳务费_人员劳务费_自筹_间接")
    private BigDecimal lwfRylwfZcJj;
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
     * 材料费_材料费_专项_间接
     */
    @FundsFieldDescription("材料费_材料费_专项_间接")
    private BigDecimal clfClfZxJj;
    /**
     * 材料费_材料费_自筹_间接
     */
    @FundsFieldDescription("材料费_材料费_自筹_间接")
    private BigDecimal clfClfZcJj;
    /**
     * 科研活动费_专项_间接
     */
    @FundsFieldDescription("科研活动费_专项_间接")
    private BigDecimal kyhdfZxJj;
    /**
     * 科研活动费_自筹_间接
     */
    @FundsFieldDescription("科研活动费_自筹_间接")
    private BigDecimal kyhdfZcJj;
    /**
     * 科研活动费_资料费_专项_间接
     */
    @FundsFieldDescription("科研活动费_资料费_专项_间接")
    private BigDecimal kyhdfZlZxJj;
    /**
     * 科研活动费_资料费_自筹_间接
     */
    @FundsFieldDescription("科研活动费_资料费_自筹_间接")
    private BigDecimal kyhdfZlZcJj;
    /**
     * 科研活动费_测试化验加工费_专项_间接
     */
    @FundsFieldDescription("科研活动费_测试化验加工费_专项_间接")
    private BigDecimal kyhdfCshyjgZxJj;
    /**
     * 科研活动费_测试化验加工费_自筹_间接
     */
    @FundsFieldDescription("科研活动费_测试化验加工费_自筹_间接")
    private BigDecimal kyhdfCshyjgZcJj;
    /**
     * 科研活动费_办公费_专项_间接
     */
    @FundsFieldDescription("科研活动费_办公费_专项_间接")
    private BigDecimal kyhdfBgZxJj;
    /**
     * 科研活动费_办公费_自筹_间接
     */
    @FundsFieldDescription("科研活动费_办公费_自筹_间接")
    private BigDecimal kyhdfBgZcJj;
    /**
     * 科研活动费_数据/样本采集费_专项_间接
     */
    @FundsFieldDescription("科研活动费_数据/样本采集费_专项_间接")
    private BigDecimal kyhdfSjybcjZxJj;
    /**
     * 科研活动费_数据/样本采集费_自筹_间接
     */
    @FundsFieldDescription("科研活动费_数据/样本采集费_自筹_间接")
    private BigDecimal kyhdfSjybcjZcJj;
    /**
     * 科研活动费_印刷/出版费_专项_间接
     */
    @FundsFieldDescription("科研活动费_印刷/出版费_专项_间接")
    private BigDecimal kyhdfYscbZxJj;
    /**
     * 科研活动费_印刷/出版费_自筹_间接
     */
    @FundsFieldDescription("科研活动费_印刷/出版费_自筹_间接")
    private BigDecimal kyhdfYscbZcJj;
    /**
     * 科研活动费_知识产权事务费_专项_间接
     */
    @FundsFieldDescription("科研活动费_知识产权事务费_专项_间接")
    private BigDecimal kyhdfZscqswZxJj;
    /**
     * 科研活动费_知识产权事务费_自筹_间接
     */
    @FundsFieldDescription("科研活动费_知识产权事务费_自筹_间接")
    private BigDecimal kyhdfZscqswZcJj;
    /**
     * 科研活动费_燃料动力费_专项_间接
     */
    @FundsFieldDescription("科研活动费_燃料动力费_专项_间接")
    private BigDecimal kyhdfRldlZxJj;
    /**
     * 科研活动费_燃料动力费_自筹_间接
     */
    @FundsFieldDescription("科研活动费_燃料动力费_自筹_间接")
    private BigDecimal kyhdfRldlZcJj;
    /**
     * 科研活动费_车辆使用费_专项_间接
     */
    @FundsFieldDescription("科研活动费_车辆使用费_专项_间接")
    private BigDecimal kyhdfClsyZxJj;
    /**
     * 科研活动费_车辆使用费_自筹_间接
     */
    @FundsFieldDescription("科研活动费_车辆使用费_自筹_间接")
    private BigDecimal kyhdfClsyZcJj;
    /**
     * 科研服务费_专项_间接
     */
    @FundsFieldDescription("科研服务费_专项_间接")
    private BigDecimal kyfwfZxJj;
    /**
     * 科研服务费_自筹_间接
     */
    @FundsFieldDescription("科研服务费_自筹_间接")
    private BigDecimal kyfwfZcJj;
    /**
     * 科研服务费_专家咨询费_专项_间接
     */
    @FundsFieldDescription("科研服务费_专家咨询费_专项_间接")
    private BigDecimal kyfwfZjzxZxJj;
    /**
     * 科研服务费_专家咨询费_自筹_间接
     */
    @FundsFieldDescription("科研服务费_专家咨询费_自筹_间接")
    private BigDecimal kyfwfZjzxZcJj;
    /**
     * 科研服务费_差旅费_专项_间接
     */
    @FundsFieldDescription("科研服务费_差旅费_专项_间接")
    private BigDecimal kyfwfClZxJj;
    /**
     * 科研服务费_差旅费_自筹_间接
     */
    @FundsFieldDescription("科研服务费_差旅费_自筹_间接")
    private BigDecimal kyfwfClZcJj;
    /**
     * 科研服务费_会议/会务费_专项_间接
     */
    @FundsFieldDescription("科研服务费_会议/会务费_专项_间接")
    private BigDecimal kyfwfHyhwZxJj;
    /**
     * 科研服务费_会议/会务费_自筹_间接
     */
    @FundsFieldDescription("科研服务费_会议/会务费_自筹_间接")
    private BigDecimal kyfwfHyhwZcJj;
    /**
     * 科研服务费_国际合作交流_间接
     */
    @FundsFieldDescription("科研服务费_国际合作交流_间接")
    private BigDecimal kyfwfGjhzjlZxJj;
    /**
     * 科研服务费_国际合作交流_自筹_间接
     */
    @FundsFieldDescription("科研服务费_国际合作交流_自筹_间接")
    private BigDecimal kyfwfGjhzjlZcJj;
    /**
     * 科研服务费_国内协作费_专项_间接
     */
    @FundsFieldDescription("科研服务费_国内协作费_专项_间接")
    private BigDecimal kyfwfGnxzZxJj;
    /**
     * 科研服务费_国内协作费_自筹_间接
     */
    @FundsFieldDescription("科研服务费_国内协作费_自筹_间接")
    private BigDecimal kyfwfGnxzZcJj;
    /**
     * 人员和劳务补助费_专项_间接
     */
    @FundsFieldDescription("人员和劳务补助费_专项_间接")
    private BigDecimal ryhlwbzfZxJj;
    /**
     * 人员和劳务补助费_自筹_间接
     */
    @FundsFieldDescription("人员和劳务补助费_自筹_间接")
    private BigDecimal ryhlwbzfZcJj;
    /**
     * 人员和劳务补助费_人员劳务费_专项_间接
     */
    @FundsFieldDescription("人员和劳务补助费_人员劳务费_专项_间接")
    private BigDecimal ryhlwbzfRylwZxJj;
    /**
     * 人员和劳务补助费_人员劳务费_自筹_间接
     */
    @FundsFieldDescription("人员和劳务补助费_人员劳务费_自筹_间接")
    private BigDecimal ryhlwbzfRylwZcJj;
    /**
     * 绩效支出_专项_间接
     */
    @FundsFieldDescription("绩效支出_专项_间接")
    private BigDecimal jxzcZxJj;
    /**
     * 绩效支出_自筹_间接
     */
    @FundsFieldDescription("绩效支出_自筹_间接")
    private BigDecimal jxzcZcJj;
}
