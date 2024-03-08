package com.ruoyi.project.config;

import com.ruoyi.common.annotation.FundsFieldDescription;
import com.ruoyi.common.annotation.PaidFieldDescription;
import com.ruoyi.common.annotation.UnPaidFieldDescription;
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
}

