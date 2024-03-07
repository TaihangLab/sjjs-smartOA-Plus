package com.ruoyi.project.config;

import com.ruoyi.common.annotation.FundsFieldDescription;
import com.ruoyi.common.annotation.PaidFieldDescription;
import com.ruoyi.common.annotation.UnPaidFieldDescription;
import com.ruoyi.common.enums.FirstLevelSubjectEnum;
import com.ruoyi.common.enums.SecondLevelSubjectEnum;
import com.ruoyi.common.enums.ZxZcEnum;
import com.ruoyi.project.domain.ProjectBalance;
import com.ruoyi.project.domain.ProjectFunds;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;
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
    private ConcurrentMap<String, String> fundsMappingCache = null;
    private ConcurrentMap<String, String> fundsReverseMappingCache = null;

    private ConcurrentMap<String, String> paidMappingCache = null;
    private ConcurrentMap<String, String> paidReverseMappingCache = null;

    private ConcurrentMap<String, String> unpaidMappingCache = null;
    private ConcurrentMap<String, String> unpaidReverseMappingCache = null;

    private ConcurrentMap<ZxZcEnum, ConcurrentHashMap<FirstLevelSubjectEnum, ConcurrentHashMap<SecondLevelSubjectEnum, String>>>
        expenditureMappingCache = null;

    @Bean
    public ConcurrentMap<String, String> fundsReverseMapping() {
        if (fundsReverseMappingCache == null) {
            fundsReverseMappingCache = fundsMapping().entrySet().stream()
                .collect(Collectors.toConcurrentMap(Map.Entry::getValue, Map.Entry::getKey));
        }
        return fundsReverseMappingCache;
    }

    @Bean
    public ConcurrentMap<String, String> fundsMapping() {
        if (fundsMappingCache == null) {
            ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
            mapFundsFieldDescriptions(ProjectFunds.class, map);
            // 这里添加你的映射关系
            //            map.put("totalFundsAll", "项目经费总额");
            //            map.put("totalFundsZx", "专项经费总额");
            //            map.put("sbfZx", "专项设备费");
            //            map.put("totalFundsZxZj", "专项直接费用");
            //            map.put("totalFundsZxJj", "专项间接费用");
            //            map.put("totalFundsZc", "自筹经费总额");
            //            map.put("sbfZc", "自筹设备费");
            //            map.put("totalFundsZcZj", "自筹直接费用");
            //            map.put("totalFundsZcJj", "自筹间接费用");
            //            map.put("sbfZxZj", "设备费_专项_直接");
            //            map.put("sbfZcZj", "设备费_自筹_直接");
            //            map.put("sbfGzsbZxZj", "设备费_购置设备费_专项_直接");
            //            map.put("sbfGzsbZcZj", "设备费_购置设备费_自筹_直接");
            //            map.put("sbfSzsbZxZj", "设备费_试制设备费_专项_直接");
            //            map.put("sbfSzsbZcZj", "设备费_试制设备费_自筹_直接");
            //            map.put("sbfSbsjgzZxZj", "设备费_设备升级改造费_专项_直接");
            //            map.put("sbfSbsjgzZcZj", "设备费_设备升级改造费_自筹_直接");
            //            map.put("sbfSbzlZxZj", "设备费_设备租赁费_专项_直接");
            //            map.put("sbfSbzlZcZj", "设备费_设备租赁费_自筹_直接");
            //            map.put("ywfZxZj", "业务费_专项_直接");
            //            map.put("ywfZcZj", "业务费_自筹_直接");
            //            map.put("ywfClfZxZj", "业务费_材料费_专项_直接");
            //            map.put("ywfClfZcZj", "业务费_材料费_自筹_直接");
            //            map.put("ywfZlfZxZj", "业务费_资料费_专项_直接");
            //            map.put("ywfZlfZcZj", "业务费_资料费_自筹_直接");
            //            map.put("ywfSjybcjfZxZj", "业务费_数据样本采集费_专项_直接");
            //            map.put("ywfSjybcjfZcZj", "业务费_数据样本采集费_自筹_直接");
            //            map.put("ywfCshyjgfZxZj", "业务费_测试化验加工费_专项_直接");
            //            map.put("ywfCshyjgfZcZj", "业务费_测试化验加工费_自筹_直接");
            //            map.put("ywfRldlfZxZj", "业务费_燃料动力费_专项_直接");
            //            map.put("ywfRldlfZcZj", "业务费_燃料动力费_自筹_直接");
            //            map.put("ywfBgfZxZj", "业务费_办公费_专项_直接");
            //            map.put("ywfBgfZcZj", "业务费_办公费_自筹_直接");
            //            map.put("ywfYscbfZxZj", "业务费_印刷出版费_专项_直接");
            //            map.put("ywfYscbfZcZj", "业务费_印刷出版费_自筹_直接");
            //            map.put("ywfZscqswfZxZj", "业务费_知识产权事务费_专项_直接");
            //            map.put("ywfZscqswfZcZj", "业务费_知识产权事务费_自筹_直接");
            //            map.put("ywfClsyfZxZj", "业务费_车辆使用费_专项_直接");
            //            map.put("ywfClsyfZcZj", "业务费_车辆使用费_自筹_直接");
            //            map.put("ywfChlfZxZj", "业务费_差旅费_专项_直接");
            //            map.put("ywfChlfZcZj", "业务费_差旅费_自筹_直接");
            //            map.put("ywfHyhwfZxZj", "业务费_会议会务费_专项_直接");
            //            map.put("ywfHyhwfZcZj", "业务费_会议会务费_自筹_直接");
            //            map.put("ywfGnxzfZxZj", "业务费_国内协作费_专项_直接");
            //            map.put("ywfGnxzfZcZj", "业务费_国内协作费_自筹_直接");
            //            map.put("ywfGjhzjlfZxZj", "业务费_国内合作交流费_专项_直接");
            //            map.put("ywfGjhzjlfZcZj", "业务费_国内合作交流费_自筹_直接");
            //            map.put("ywfHyclgjhzyjlfZxZj", "业务费_会议/差旅/国际合作与交流费_专项_直接");
            //            map.put("ywfHyclgjhzyjlfZxZj", "业务费_会议/差旅/国际合作与交流费_专项_直接");
            // 根据需要添加更多映射关系
            fundsMappingCache = map;
        }
        return fundsMappingCache;
    }

    private void mapFundsFieldDescriptions(Class<?> clazz, ConcurrentHashMap<String, String> map) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FundsFieldDescription.class)) {
                FundsFieldDescription description = field.getAnnotation(FundsFieldDescription.class);
                map.put(field.getName(), description.value());
            }
        }

    }

    @Bean
    public ConcurrentMap<String, String> paidReverseMapping() {
        if (paidReverseMappingCache == null) {
            paidReverseMappingCache = paidMapping().entrySet().stream()
                .collect(Collectors.toConcurrentMap(Map.Entry::getValue, Map.Entry::getKey));
        }
        return paidReverseMappingCache;
    }

    @Bean
    public ConcurrentMap<String, String> paidMapping() {
        if (paidMappingCache == null) {
            ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
            mapPaidFieldDescriptions(ProjectBalance.class, map);
            // 根据需要添加更多映射关系
            paidMappingCache = map;
        }
        return paidMappingCache;
    }

    private void mapPaidFieldDescriptions(Class<?> clazz, ConcurrentHashMap<String, String> map) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(PaidFieldDescription.class)) {
                PaidFieldDescription description = field.getAnnotation(PaidFieldDescription.class);
                map.put(field.getName(), description.value());
            }
        }

    }

    @Bean
    public ConcurrentMap<String, String> unpaidReverseMapping() {
        if (unpaidReverseMappingCache == null) {
            unpaidReverseMappingCache = unpaidMapping().entrySet().stream()
                .collect(Collectors.toConcurrentMap(Map.Entry::getValue, Map.Entry::getKey));
        }
        return unpaidReverseMappingCache;
    }

    @Bean
    public ConcurrentMap<String, String> unpaidMapping() {
        if (unpaidMappingCache == null) {
            ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
            mapUnPaidFieldDescriptions(ProjectBalance.class, map);
            // 根据需要添加更多映射关系
            unpaidMappingCache = map;
        }
        return unpaidMappingCache;
    }

    private void mapUnPaidFieldDescriptions(Class<?> clazz, ConcurrentHashMap<String, String> map) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(UnPaidFieldDescription.class)) {
                UnPaidFieldDescription description = field.getAnnotation(UnPaidFieldDescription.class);
                map.put(field.getName(), description.value());
            }
        }

    }

    @Bean
    public ConcurrentMap<ZxZcEnum, ConcurrentHashMap<FirstLevelSubjectEnum, ConcurrentHashMap<SecondLevelSubjectEnum, String>>> expenditureMapping() {
        if (expenditureMappingCache == null) {
            ConcurrentHashMap<ZxZcEnum, ConcurrentHashMap<FirstLevelSubjectEnum, ConcurrentHashMap<SecondLevelSubjectEnum, String>>>
                map = new ConcurrentHashMap<>();
            // 这里添加你的映射关系
            map.put(ZxZcEnum.SELF_RAISED, new ConcurrentHashMap<>());
            map.put(ZxZcEnum.SPECIAL_ITEM, new ConcurrentHashMap<>());
            // 根据需要添加更多映射关系
            expenditureMappingCache = map;
        }
        return expenditureMappingCache;
    }
}
