package com.chushiy.standard.i18n;

import com.chushiy.standard.constant.ResponseConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/13 下午 7:32
 * @Description i18n信息配置
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.i18n
 * @ClassName I18nMessageConfig.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Slf4j
public class I18nMessageConfig {

    /**
     * 国际化信息map
     * key为语言 value为message为key i18nMessage为值的map
     */
    private static final Map<String, Map<String, String>> internationalizationMap = new ConcurrentHashMap<>();

    /**
     * 初始化国际化信息map
     * TODO 扩展 配置文件 硬编码
     */
    static {
        // 中文
        Map<String, String> zhCNmessageMap = new HashMap<>();
        zhCNmessageMap.put("success!", ResponseConstant.SUCCESS_MESSAGE);
        zhCNmessageMap.put("fail!", "失败!");
        internationalizationMap.put(ResponseConstant.DEFAULT_LANGUAGE.toString(), zhCNmessageMap);

        // 英文
        Map<String, String> enUSmessageMap = new HashMap<>();
        enUSmessageMap.put(ResponseConstant.SUCCESS_MESSAGE, "success!");
        enUSmessageMap.put("失败!", "fail!");
        // 美国英文
        internationalizationMap.put(Locale.US.toString(), enUSmessageMap);
    }

    /**
     * 默认信息 如果找不到 则返回原信息
     *
     * @param language      语言
     * @param originMessage 原信息
     * @return 国际化信息
     */
    public static String getI18nMessage(Locale language, String originMessage) {
        return I18nMessageConfig.getI18nMessage(language, originMessage, originMessage);
    }

    /**
     * @param language       语言
     * @param originMessage  原信息
     * @param defaultMessage 默认信息 如果找不到 则返回这个
     * @return 国际化信息
     */
    public static String getI18nMessage(Locale language, String originMessage, String defaultMessage) {
        Map<String, String> messageMap = internationalizationMap.get(language.toString());
        if (MapUtils.isEmpty(messageMap)) {
            if (log.isDebugEnabled()) {
                log.warn("language: {} not found, use default language: {}", language, ResponseConstant.DEFAULT_LANGUAGE);
            }
            return defaultMessage;
        }
        String i18Message = messageMap.get(originMessage);
        if (StringUtils.isBlank(i18Message)) {
            return defaultMessage;
        }
        return i18Message;
    }
}
