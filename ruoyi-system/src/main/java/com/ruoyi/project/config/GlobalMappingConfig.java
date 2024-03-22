package com.ruoyi.project.config;

import com.ruoyi.common.annotation.FundsFieldDescription;
import com.ruoyi.common.annotation.PaidFieldDescription;
import com.ruoyi.common.annotation.UnPaidFieldDescription;
import com.ruoyi.common.enums.*;
import com.ruoyi.project.domain.ProjectBalance;
import com.ruoyi.project.domain.ProjectFunds;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * 全局Mapping配置
 *
 * @author bailingnan
 * @date 2024/03/04
 */
@Configuration
public class GlobalMappingConfig {

    private final ConcurrentMap<String, ConcurrentMap<String, String>> mappingCache = new ConcurrentHashMap<>();
    private final ConcurrentMap<String, ConcurrentMap<String, String>> reverseMappingCache = new ConcurrentHashMap<>();
    private static final ConcurrentMap<TypeKey, String> expenditureMapping = new ConcurrentHashMap<>();

    static {
        //直接经费支出
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.EQUIPMENT_FEE,
                SecondLevelSubjectEnum.PURCHASE_EQUIPMENT_FEE, ThirdLevelSubjectEnum.NONE),
            "设备费_购置设备费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.EQUIPMENT_FEE,
                SecondLevelSubjectEnum.PURCHASE_EQUIPMENT_FEE, ThirdLevelSubjectEnum.NONE),
            "设备费_购置设备费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.EQUIPMENT_FEE,
                SecondLevelSubjectEnum.TRIAL_EQUIPMENT_FEE, ThirdLevelSubjectEnum.NONE), "设备费_试制设备费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.EQUIPMENT_FEE,
                SecondLevelSubjectEnum.TRIAL_EQUIPMENT_FEE, ThirdLevelSubjectEnum.NONE), "设备费_试制设备费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.EQUIPMENT_FEE,
                SecondLevelSubjectEnum.DEVICE_UPGRADE_COST, ThirdLevelSubjectEnum.NONE),
            "设备费_设备升级改造费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.EQUIPMENT_FEE,
                SecondLevelSubjectEnum.DEVICE_UPGRADE_COST, ThirdLevelSubjectEnum.NONE),
            "设备费_设备升级改造费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.EQUIPMENT_FEE,
                SecondLevelSubjectEnum.EQUIPMENT_LEASE_FEE, ThirdLevelSubjectEnum.NONE), "设备费_设备租赁费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.EQUIPMENT_FEE,
                SecondLevelSubjectEnum.EQUIPMENT_LEASE_FEE, ThirdLevelSubjectEnum.NONE), "设备费_设备租赁费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.MATERIAL_FEE, ThirdLevelSubjectEnum.NONE), "业务费_材料费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.MATERIAL_FEE, ThirdLevelSubjectEnum.NONE), "业务费_材料费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.DOCUMENTATION_FEE, ThirdLevelSubjectEnum.NONE), "业务费_资料费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.DOCUMENTATION_FEE, ThirdLevelSubjectEnum.NONE), "业务费_资料费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.DATA_SAMPLE_COLLECTION_FEE, ThirdLevelSubjectEnum.NONE),
            "业务费_数据样本采集费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.DATA_SAMPLE_COLLECTION_FEE, ThirdLevelSubjectEnum.NONE),
            "业务费_数据样本采集费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.TEST_ASSAY_PROCESSING_FEE, ThirdLevelSubjectEnum.NONE),
            "业务费_测试化验加工费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.TEST_ASSAY_PROCESSING_FEE, ThirdLevelSubjectEnum.NONE),
            "业务费_测试化验加工费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.FUEL_POWER_FEE, ThirdLevelSubjectEnum.NONE), "业务费_燃料动力费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.FUEL_POWER_FEE, ThirdLevelSubjectEnum.NONE), "业务费_燃料动力费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.OFFICE_FEE, ThirdLevelSubjectEnum.NONE), "业务费_办公费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.OFFICE_FEE, ThirdLevelSubjectEnum.NONE), "业务费_办公费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.PRINTING_PUBLISHING_FEE, ThirdLevelSubjectEnum.NONE),
            "业务费_印刷出版费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.PRINTING_PUBLISHING_FEE, ThirdLevelSubjectEnum.NONE),
            "业务费_印刷出版费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.INTELLECTUAL_PROPERTY_AFFAIRS_FEE, ThirdLevelSubjectEnum.NONE),
            "业务费_知识产权事务费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.INTELLECTUAL_PROPERTY_AFFAIRS_FEE, ThirdLevelSubjectEnum.NONE),
            "业务费_知识产权事务费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.VEHICLE_USAGE_FEE, ThirdLevelSubjectEnum.NONE), "业务费_车辆使用费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.VEHICLE_USAGE_FEE, ThirdLevelSubjectEnum.NONE), "业务费_车辆使用费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.TRAVEL_FEE, ThirdLevelSubjectEnum.NONE), "业务费_差旅费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.TRAVEL_FEE, ThirdLevelSubjectEnum.NONE), "业务费_差旅费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.MEETING_SERVICE_FEE, ThirdLevelSubjectEnum.NONE), "业务费_会议会务费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.MEETING_SERVICE_FEE, ThirdLevelSubjectEnum.NONE), "业务费_会议会务费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.DOMESTIC_COOPERATION_FEE, ThirdLevelSubjectEnum.NONE),
            "业务费_国内协作费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.DOMESTIC_COOPERATION_FEE, ThirdLevelSubjectEnum.NONE),
            "业务费_国内协作费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.INTERNATIONAL_COOPERATION_EXCHANGE_FEE, ThirdLevelSubjectEnum.NONE),
            "业务费_国际合作交流费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.INTERNATIONAL_COOPERATION_EXCHANGE_FEE, ThirdLevelSubjectEnum.NONE),
            "业务费_国际合作交流费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.PUBLISHING_LITERATURE_INFORMATION_TRANSMISSION_INTELLECTUAL_PROPERTY_AFFAIRS_FEE,
                ThirdLevelSubjectEnum.INTELLECTUAL_PROPERTY_AFFAIRS_FEE),
            "业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.PUBLISHING_LITERATURE_INFORMATION_TRANSMISSION_INTELLECTUAL_PROPERTY_AFFAIRS_FEE,
                ThirdLevelSubjectEnum.INTELLECTUAL_PROPERTY_AFFAIRS_FEE),
            "业务费_出版/文献/信息传播/知识产权事务费_知识产权事务费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.PUBLISHING_LITERATURE_INFORMATION_TRANSMISSION_INTELLECTUAL_PROPERTY_AFFAIRS_FEE,
                ThirdLevelSubjectEnum.PRINTING_AND_PRODUCTION_FEE),
            "业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.PUBLISHING_LITERATURE_INFORMATION_TRANSMISSION_INTELLECTUAL_PROPERTY_AFFAIRS_FEE,
                ThirdLevelSubjectEnum.PRINTING_AND_PRODUCTION_FEE),
            "业务费_出版/文献/信息传播/知识产权事务费_印刷打印制作费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.PUBLISHING_LITERATURE_INFORMATION_TRANSMISSION_INTELLECTUAL_PROPERTY_AFFAIRS_FEE,
                ThirdLevelSubjectEnum.LITERATURE_DATABASE_FEE),
            "业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.PUBLISHING_LITERATURE_INFORMATION_TRANSMISSION_INTELLECTUAL_PROPERTY_AFFAIRS_FEE,
                ThirdLevelSubjectEnum.LITERATURE_DATABASE_FEE),
            "业务费_出版/文献/信息传播/知识产权事务费_文献数据库费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.PUBLISHING_LITERATURE_INFORMATION_TRANSMISSION_INTELLECTUAL_PROPERTY_AFFAIRS_FEE,
                ThirdLevelSubjectEnum.INFORMATION_DISSEMINATION_FEE),
            "业务费_出版/文献/信息传播/知识产权事务费_信息传播费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.PUBLISHING_LITERATURE_INFORMATION_TRANSMISSION_INTELLECTUAL_PROPERTY_AFFAIRS_FEE,
                ThirdLevelSubjectEnum.INFORMATION_DISSEMINATION_FEE),
            "业务费_出版/文献/信息传播/知识产权事务费_信息传播费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.CONFERENCE_TRAVEL_INTERNATIONAL_COOPERATION_COMMUNICATION_FEE,
                ThirdLevelSubjectEnum.CONFERENCE_FEE), "业务费_会议/差旅/国际合作与交流费_会议费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.CONFERENCE_TRAVEL_INTERNATIONAL_COOPERATION_COMMUNICATION_FEE,
                ThirdLevelSubjectEnum.CONFERENCE_FEE), "业务费_会议/差旅/国际合作与交流费_会议费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.CONFERENCE_TRAVEL_INTERNATIONAL_COOPERATION_COMMUNICATION_FEE,
                ThirdLevelSubjectEnum.TRAVEL_FEE), "业务费_会议/差旅/国际合作与交流费_差旅费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.CONFERENCE_TRAVEL_INTERNATIONAL_COOPERATION_COMMUNICATION_FEE,
                ThirdLevelSubjectEnum.TRAVEL_FEE), "业务费_会议/差旅/国际合作与交流费_差旅费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.CONFERENCE_TRAVEL_INTERNATIONAL_COOPERATION_COMMUNICATION_FEE,
                ThirdLevelSubjectEnum.INTERNATIONAL_COOPERATION_FEE),
            "业务费_会议/差旅/国际合作与交流费_国际合作费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.BUSINESS_FEE,
                SecondLevelSubjectEnum.CONFERENCE_TRAVEL_INTERNATIONAL_COOPERATION_COMMUNICATION_FEE,
                ThirdLevelSubjectEnum.INTERNATIONAL_COOPERATION_FEE),
            "业务费_会议/差旅/国际合作与交流费_国际合作费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.LABOR_FEE,
                SecondLevelSubjectEnum.EXPERT_CONSULTATION_FEE, ThirdLevelSubjectEnum.NONE),
            "劳务费_专家咨询费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.LABOR_FEE,
                SecondLevelSubjectEnum.EXPERT_CONSULTATION_FEE, ThirdLevelSubjectEnum.NONE),
            "劳务费_专家咨询费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.LABOR_FEE,
                SecondLevelSubjectEnum.PERSONNEL_SERVICE_FEE, ThirdLevelSubjectEnum.NONE),
            "劳务费_人员劳务费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.LABOR_FEE,
                SecondLevelSubjectEnum.PERSONNEL_SERVICE_FEE, ThirdLevelSubjectEnum.NONE),
            "劳务费_人员劳务费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.MATERIAL_FEE,
                SecondLevelSubjectEnum.MATERIAL_FEE, ThirdLevelSubjectEnum.NONE), "材料费_材料费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.MATERIAL_FEE,
                SecondLevelSubjectEnum.MATERIAL_FEE, ThirdLevelSubjectEnum.NONE), "材料费_材料费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_ACTIVITY_FEE,
                SecondLevelSubjectEnum.DOCUMENTATION_FEE, ThirdLevelSubjectEnum.NONE), "科研活动费_资料费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_ACTIVITY_FEE,
                SecondLevelSubjectEnum.DOCUMENTATION_FEE, ThirdLevelSubjectEnum.NONE), "科研活动费_资料费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_ACTIVITY_FEE,
                SecondLevelSubjectEnum.TEST_ASSAY_PROCESSING_FEE, ThirdLevelSubjectEnum.NONE),
            "科研活动费_测试化验加工费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_ACTIVITY_FEE,
                SecondLevelSubjectEnum.TEST_ASSAY_PROCESSING_FEE, ThirdLevelSubjectEnum.NONE),
            "科研活动费_测试化验加工费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_ACTIVITY_FEE,
                SecondLevelSubjectEnum.OFFICE_FEE, ThirdLevelSubjectEnum.NONE), "科研活动费_办公费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_ACTIVITY_FEE,
                SecondLevelSubjectEnum.OFFICE_FEE, ThirdLevelSubjectEnum.NONE), "科研活动费_办公费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_ACTIVITY_FEE,
                SecondLevelSubjectEnum.DATA_SAMPLE_COLLECTION_FEE, ThirdLevelSubjectEnum.NONE),
            "科研活动费_数据/样本采集费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_ACTIVITY_FEE,
                SecondLevelSubjectEnum.DATA_SAMPLE_COLLECTION_FEE, ThirdLevelSubjectEnum.NONE),
            "科研活动费_数据/样本采集费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_ACTIVITY_FEE,
                SecondLevelSubjectEnum.PRINTING_PUBLISHING_FEE, ThirdLevelSubjectEnum.NONE),
            "科研活动费_印刷/出版费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_ACTIVITY_FEE,
                SecondLevelSubjectEnum.PRINTING_PUBLISHING_FEE, ThirdLevelSubjectEnum.NONE),
            "科研活动费_印刷/出版费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_ACTIVITY_FEE,
                SecondLevelSubjectEnum.INTELLECTUAL_PROPERTY_AFFAIRS_FEE, ThirdLevelSubjectEnum.NONE),
            "科研活动费_知识产权事务费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_ACTIVITY_FEE,
                SecondLevelSubjectEnum.INTELLECTUAL_PROPERTY_AFFAIRS_FEE, ThirdLevelSubjectEnum.NONE),
            "科研活动费_知识产权事务费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_ACTIVITY_FEE,
                SecondLevelSubjectEnum.FUEL_POWER_FEE, ThirdLevelSubjectEnum.NONE), "科研活动费_燃料动力费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_ACTIVITY_FEE,
                SecondLevelSubjectEnum.FUEL_POWER_FEE, ThirdLevelSubjectEnum.NONE), "科研活动费_燃料动力费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_ACTIVITY_FEE,
                SecondLevelSubjectEnum.VEHICLE_USAGE_FEE, ThirdLevelSubjectEnum.NONE),
            "科研活动费_车辆使用费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_ACTIVITY_FEE,
                SecondLevelSubjectEnum.VEHICLE_USAGE_FEE, ThirdLevelSubjectEnum.NONE),
            "科研活动费_车辆使用费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_SERVICE_FEE,
                SecondLevelSubjectEnum.EXPERT_CONSULTATION_FEE, ThirdLevelSubjectEnum.NONE),
            "科研服务费_专家咨询费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_SERVICE_FEE,
                SecondLevelSubjectEnum.EXPERT_CONSULTATION_FEE, ThirdLevelSubjectEnum.NONE),
            "科研服务费_专家咨询费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_SERVICE_FEE,
                SecondLevelSubjectEnum.TRAVEL_FEE, ThirdLevelSubjectEnum.NONE), "科研服务费_差旅费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_SERVICE_FEE,
                SecondLevelSubjectEnum.TRAVEL_FEE, ThirdLevelSubjectEnum.NONE), "科研服务费_差旅费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_SERVICE_FEE,
                SecondLevelSubjectEnum.MEETING_SERVICE_FEE, ThirdLevelSubjectEnum.NONE),
            "科研服务费_会议/会务费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_SERVICE_FEE,
                SecondLevelSubjectEnum.MEETING_SERVICE_FEE, ThirdLevelSubjectEnum.NONE),
            "科研服务费_会议/会务费_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_SERVICE_FEE,
                SecondLevelSubjectEnum.INTERNATIONAL_COOPERATION_EXCHANGE_FEE, ThirdLevelSubjectEnum.NONE),
            "科研服务费_国际合作交流_自筹_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_SERVICE_FEE,
                SecondLevelSubjectEnum.INTERNATIONAL_COOPERATION_EXCHANGE_FEE, ThirdLevelSubjectEnum.NONE),
            "科研服务费_国际合作交流_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_SERVICE_FEE,
                SecondLevelSubjectEnum.DOMESTIC_COOPERATION_FEE, ThirdLevelSubjectEnum.NONE),
            "科研服务费_国内协作费_专项_直接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE, FirstLevelSubjectEnum.RESEARCH_SERVICE_FEE,
                SecondLevelSubjectEnum.DOMESTIC_COOPERATION_FEE, ThirdLevelSubjectEnum.NONE),
            "科研服务费_国内协作费_自筹_直接");
        expenditureMapping.put(new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.DIRECT_EXPENSE,
            FirstLevelSubjectEnum.PERSONNEL_AND_SERVICE_SUBSIDY_FEE, SecondLevelSubjectEnum.PERSONNEL_SERVICE_FEE,
            ThirdLevelSubjectEnum.NONE), "人员和劳务补助费_人员劳务费_自筹_直接");
        expenditureMapping.put(new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.DIRECT_EXPENSE,
            FirstLevelSubjectEnum.PERSONNEL_AND_SERVICE_SUBSIDY_FEE, SecondLevelSubjectEnum.PERSONNEL_SERVICE_FEE,
            ThirdLevelSubjectEnum.NONE), "人员和劳务补助费_人员劳务费_专项_直接");
        //间接经费支出
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.PERFORMANCE_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "绩效支出_专项_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.PERFORMANCE_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "绩效支出_自筹_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.OTHER_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "其他支出_自筹_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.OTHER_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "其他支出_专项_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.EQUIPMENT_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "设备费_专项_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.EQUIPMENT_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "设备费_自筹_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.MATERIAL_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "材料费_自筹_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.MATERIAL_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "材料费_专项_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.MANAGEMENT_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "管理费_专项_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.MANAGEMENT_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "管理费_自筹_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.HOUSE_RENTAL_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "房屋租赁费_自筹_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.HOUSE_RENTAL_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "房屋租赁费_专项_间接");
        expenditureMapping.put(new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE,
            FirstLevelSubjectEnum.DAILY_WATER_ELECTRICITY_HEATING_FEE, SecondLevelSubjectEnum.NONE,
            ThirdLevelSubjectEnum.NONE), "日常水电暖费_专项_间接");
        expenditureMapping.put(new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE,
            FirstLevelSubjectEnum.DAILY_WATER_ELECTRICITY_HEATING_FEE, SecondLevelSubjectEnum.NONE,
            ThirdLevelSubjectEnum.NONE), "日常水电暖费_自筹_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.DOCUMENTATION_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "资料费_自筹_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.DOCUMENTATION_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "资料费_专项_间接");
        expenditureMapping.put(new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE,
                FirstLevelSubjectEnum.DATA_SAMPLE_COLLECTION_FEE, SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE),
            "数据样本采集费_专项_间接");
        expenditureMapping.put(new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE,
                FirstLevelSubjectEnum.DATA_SAMPLE_COLLECTION_FEE, SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE),
            "数据样本采集费_自筹_间接");
        expenditureMapping.put(new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE,
                FirstLevelSubjectEnum.TEST_ASSAY_PROCESSING_FEE, SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE),
            "测试化验加工费_自筹_间接");
        expenditureMapping.put(new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE,
                FirstLevelSubjectEnum.TEST_ASSAY_PROCESSING_FEE, SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE),
            "测试化验加工费_专项_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.FUEL_POWER_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "燃料动力费_专项_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.FUEL_POWER_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "燃料动力费_自筹_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.OFFICE_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "办公费_自筹_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.OFFICE_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "办公费_专项_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.PRINTING_PUBLISHING_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "印刷出版费_专项_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.PRINTING_PUBLISHING_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "印刷出版费_自筹_间接");
        expenditureMapping.put(new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE,
            FirstLevelSubjectEnum.INTELLECTUAL_PROPERTY_AFFAIRS_FEE, SecondLevelSubjectEnum.NONE,
            ThirdLevelSubjectEnum.NONE), "知识产权事务费_自筹_间接");
        expenditureMapping.put(new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE,
            FirstLevelSubjectEnum.INTELLECTUAL_PROPERTY_AFFAIRS_FEE, SecondLevelSubjectEnum.NONE,
            ThirdLevelSubjectEnum.NONE), "知识产权事务费_专项_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.VEHICLE_USAGE_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "车辆使用费_专项_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.VEHICLE_USAGE_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "车辆使用费_自筹_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.TRAVEL_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "差旅费_自筹_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.TRAVEL_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "差旅费_专项_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.MEETING_SERVICE_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "会议会务费_专项_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.MEETING_SERVICE_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "会议会务费_自筹_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SELF_RAISED, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.EXPERT_CONSULTATION_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "专家咨询费_自筹_间接");
        expenditureMapping.put(
            new TypeKey(ZxZcEnum.SPECIAL_ITEM, ZjJjEnum.INDIRECT_EXPENSE, FirstLevelSubjectEnum.EXPERT_CONSULTATION_FEE,
                SecondLevelSubjectEnum.NONE, ThirdLevelSubjectEnum.NONE), "专家咨询费_专项_间接");

    }

    @Bean
    public ConcurrentMap<String, String> fundsMapping() {
        return getMapping("funds", ProjectFunds.class, FundsFieldDescription.class);
    }

    private <T extends Annotation> ConcurrentMap<String, String> getMapping(String key, Class<?> clazz,
        Class<T> annotationClass) {
        return mappingCache.computeIfAbsent(key, k -> {
            ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(annotationClass)) {
                    T description = field.getAnnotation(annotationClass);
                    try {
                        Method valueMethod = annotationClass.getMethod("value");
                        String value = (String)valueMethod.invoke(description);
                        map.put(field.getName(), value);
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            return map;
        });
    }

    @Bean
    public ConcurrentMap<String, String> fundsReverseMapping() {
        return getReverseMapping("funds");
    }

    private ConcurrentMap<String, String> getReverseMapping(String key) {
        return reverseMappingCache.computeIfAbsent(key, k -> {
            ConcurrentMap<String, String> map = mappingCache.getOrDefault(k, new ConcurrentHashMap<>());
            return map.entrySet().stream().collect(Collectors.toConcurrentMap(Map.Entry::getValue, Map.Entry::getKey));
        });
    }

    @Bean
    public ConcurrentMap<String, String> paidMapping() {
        return getMapping("paid", ProjectBalance.class, PaidFieldDescription.class);
    }

    @Bean
    public ConcurrentMap<String, String> paidReverseMapping() {
        return getReverseMapping("paid");
    }

    @Bean
    public ConcurrentMap<String, String> unpaidMapping() {
        return getMapping("unpaid", ProjectBalance.class, UnPaidFieldDescription.class);
    }

    @Bean
    public ConcurrentMap<String, String> unpaidReverseMapping() {
        return getReverseMapping("unpaid");
    }

    public static String getObjectByTags(ZxZcEnum zxZcEnum, ZjJjEnum zjJjEnum,
        FirstLevelSubjectEnum firstLevelSubjectEnum, SecondLevelSubjectEnum secondLevelSubjectEnum,
        ThirdLevelSubjectEnum thirdLevelSubjectEnum) {
        TypeKey key =
            new TypeKey(zxZcEnum, zjJjEnum, firstLevelSubjectEnum, secondLevelSubjectEnum, thirdLevelSubjectEnum);
        return expenditureMapping.get(key); // 根据标签组合查找并返回对象类型
    }
}

