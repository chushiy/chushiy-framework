package com.chushiy.json;

import com.chushiy.standard.json.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 上午 11:38
 * @Description 工厂模式 返回支持的JSON对象 系统默认只支持一种json（对外包装数据时） 使用时随意
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.json
 * @ClassName JSONFactory.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Slf4j
public class JSONFactory {

    private static JSON json;

    /**
     * @Author 初时y
     * @DateTime 2024/5/29 下午 6:46
     * @Description 获取JSON提供者
     * @Deprecated 方法内部调用的就是 {@link #getJSONProvider()} 方法名不是很规范 不推荐<br>
     * 推荐使用 {@link #getJSONProvider()} <br>
     * @Return com.chushiy.standard.json.JSON
     **/
    @Deprecated
    public static JSON getJSON() {
        return getJSONProvider();
    }

    /**
     * @Author 初时y
     * @DateTime 2024/5/29 下午 6:46
     * @Description 获取JSON提供者
     * @Return com.chushiy.standard.json.JSON
     **/
    public static JSON getJSONProvider() {
        if (json != null) {
            return json;
        }
        synchronized (JSONFactory.class) {
            if (json != null) {
                return json;
            }

            ServiceLoader<JSON> loader = ServiceLoader.load(JSON.class);
            Iterator<JSON> it = loader.iterator();
            if (it.hasNext()) {
                json = it.next();
                log.info("使用系统提供的JSON:{}", json.getClass());
                return json;
            }
            // 默认提供的JSON实现
            String defaultJSON = "com.chushiy.json.FastJSON";
            try {
                Class<?> jsonClazz = Class.forName(defaultJSON);
                json = (JSON) jsonClazz.newInstance();
                log.info("使用默认提供的JSON:{}", json.getClass());
                return json;
            } catch (Exception x) {
                throw new RuntimeException(
                        "DEFAULT_JSON " + defaultJSON + " could not be instantiated: " + x,
                        x);
            }
        }
    }
}
