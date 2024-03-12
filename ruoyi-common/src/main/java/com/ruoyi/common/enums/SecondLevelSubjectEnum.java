package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ruoyi.common.utils.EnumCacheUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 二级科目
 *
 * @author bailingnan
 * @date 2024/2/23
 */
@Getter
@AllArgsConstructor
@ToString
public enum SecondLevelSubjectEnum implements IEnum<Integer> {
    /**
     * 购置设备费
     */
    PURCHASE_EQUIPMENT_FEE(0, "购置设备费"),
    /**
     * 试制设备费
     */
    TRIAL_EQUIPMENT_FEE(1, "试制设备费"),
    /**
     * 设备升级改造费
     */
    DEVICE_UPGRADE_COST(2, "设备升级改造费"),
    /**
     * 设备租赁费
     */
    EQUIPMENT_LEASE_FEE(3, "设备租赁费"),
    /**
     * 材料费
     */
    MATERIAL_FEE(4, "材料费"),
    /**
     * 资料费
     */
    DOCUMENTATION_FEE(5, "资料费"),
    /**
     * 数据样本采集费
     */
    DATA_SAMPLE_COLLECTION_FEE(6, "数据样本采集费"),
    /**
     * 测试化验加工费
     */
    TEST_ASSAY_PROCESSING_FEE(7, "测试化验加工费"),
    /**
     * 燃料动力费
     */
    FUEL_POWER_FEE(8, "燃料动力费"),
    /**
     * 办公费
     */
    OFFICE_FEE(9, "办公费"),
    /**
     * 印刷/出版费
     */
    PRINTING_PUBLISHING_FEE(10, "印刷/出版费"),
    /**
     * 知识产权事务费
     */
    INTELLECTUAL_PROPERTY_AFFAIRS_FEE(11, "知识产权事务费"),
    /**
     * 车辆使用费
     */
    VEHICLE_USAGE_FEE(12, "车辆使用费"),
    /**
     * 出版/文献/信息传播/知识产权事务费
     */
    PUBLISHING_LITERATURE_INFORMATION_TRANSMISSION_INTELLECTUAL_PROPERTY_AFFAIRS_FEE(13,
        "出版/文献/信息传播/知识产权事务费"),
    /**
     * 差旅费
     */
    TRAVEL_FEE(14, "差旅费"),
    /**
     * 会议/会务费
     */
    MEETING_SERVICE_FEE(15, "会议/会务费"),
    /**
     * 国内协作费
     */
    DOMESTIC_COOPERATION_FEE(16, "国内协作费"),
    /**
     * 国际合作交流费
     */
    INTERNATIONAL_COOPERATION_EXCHANGE_FEE(17, "国际合作交流费"),
    /**
     * 专家咨询费
     */
    EXPERT_CONSULTATION_FEE(18, "专家咨询费"),
    /**
     * 人员劳务费
     */
    PERSONNEL_SERVICE_FEE(19, "人员劳务费"),
    /**
     * 无
     */
    NONE(20, "无");

    static {
        // 通过名称构建缓存,通过EnumCache.findByName(StatusEnum.class,"SUCCESS",null);调用能获取枚举
        EnumCacheUtils.registerByName(SecondLevelSubjectEnum.class, SecondLevelSubjectEnum.values());
        // 通过code构建缓存,通过EnumCache.findByValue(StatusEnum.class,"S",null);调用能获取枚举
        EnumCacheUtils.registerByValue(SecondLevelSubjectEnum.class, SecondLevelSubjectEnum.values(),
            SecondLevelSubjectEnum::getDescription);
    }

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String description;
}
