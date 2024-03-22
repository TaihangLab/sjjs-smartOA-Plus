package com.ruoyi.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import com.ruoyi.common.utils.EnumCacheUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 一级科目
 *
 * @author bailingnan
 * @date 2024/2/23
 */
@Getter
@AllArgsConstructor
@ToString
public enum FirstLevelSubjectEnum implements IEnum<Integer> {
    /**
     * 设备费
     */
    EQUIPMENT_FEE(0, "设备费"),
    /**
     * 业务费
     */
    BUSINESS_FEE(1, "业务费"),
    /**
     * 劳务费
     */
    LABOR_FEE(2, "劳务费"),
    /**
     * 材料费
     */
    MATERIAL_FEE(3, "材料费"),
    /**
     * 科研活动费
     */
    RESEARCH_ACTIVITY_FEE(4, "科研活动费"),
    /**
     * 科研服务费
     */
    RESEARCH_SERVICE_FEE(5, "科研服务费"),
    /**
     * 人员和劳务补助费
     */
    PERSONNEL_AND_SERVICE_SUBSIDY_FEE(6, "人员和劳务补助费"),
    /**
     * 绩效支出
     */
    PERFORMANCE_FEE(7, "绩效支出"),
    /**
     * 管理费
     */
    MANAGEMENT_FEE(8, "管理费"),
    /**
     * 房屋租赁费
     */
    HOUSE_RENTAL_FEE(9, "房屋租赁费"),
    /**
     * 日常水电暖费
     */
    DAILY_WATER_ELECTRICITY_HEATING_FEE(10, "日常水电暖费"),
    /**
     * 资料费
     */
    DOCUMENTATION_FEE(11, "资料费"),
    /**
     * 数据样本采集费
     */
    DATA_SAMPLE_COLLECTION_FEE(12, "数据样本采集费"),
    /**
     * 测试化验加工费
     */
    TEST_ASSAY_PROCESSING_FEE(13, "测试化验加工费"),
    /**
     * 燃料动力费
     */
    FUEL_POWER_FEE(14, "燃料动力费"),
    /**
     * 办公费
     */
    OFFICE_FEE(15, "办公费"),
    /**
     * 印刷/出版费
     */
    PRINTING_PUBLISHING_FEE(16, "印刷/出版费"),
    /**
     * 知识产权事务费
     */
    INTELLECTUAL_PROPERTY_AFFAIRS_FEE(17, "知识产权事务费"),
    /**
     * 车辆使用费
     */
    VEHICLE_USAGE_FEE(18, "车辆使用费"),
    /**
     * 差旅费
     */
    TRAVEL_FEE(19, "差旅费"),
    /**
     * 会议/会务费
     */
    MEETING_SERVICE_FEE(20, "会议/会务费"),
    /**
     * 专家咨询费
     */
    EXPERT_CONSULTATION_FEE(21, "专家咨询费"),
    /**
     * 其他费用
     */
    OTHER_FEE(22, "其他费用");



    static {
        // 通过名称构建缓存,通过EnumCache.findByName(StatusEnum.class,"SUCCESS",null);调用能获取枚举
        EnumCacheUtils.registerByName(FirstLevelSubjectEnum.class, FirstLevelSubjectEnum.values());
        // 通过code构建缓存,通过EnumCache.findByValue(StatusEnum.class,"S",null);调用能获取枚举
        EnumCacheUtils.registerByValue(FirstLevelSubjectEnum.class, FirstLevelSubjectEnum.values(),
            FirstLevelSubjectEnum::getDescription);
    }

    @EnumValue
    @JsonValue
    private final Integer value;
    private final String description;

}
