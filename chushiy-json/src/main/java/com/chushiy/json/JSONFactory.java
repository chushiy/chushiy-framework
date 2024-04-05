package com.chushiy.json;

import com.chushiy.standard.json.JSON;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 上午 11:38
 * @Description 工厂模式 返回支持的JSON对象
 * @ProjectName chushiy
 * @PackageName com.chushiy.json
 * @ClassName JSONFactory.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class JSONFactory {

    private volatile static JSON json;

    public static JSON getJSON() {
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
                return json;
            }
            // 默认提供的JSON实现
            String defaultJSON = "com.chushiy.json.FastJSON";
            try {
                Class<?> jsonClazz = Class.forName(defaultJSON);
                json = (JSON) jsonClazz.newInstance();
                return json;
            } catch (Exception x) {
                throw new RuntimeException(
                        "DEFAULT_JSON " + defaultJSON + " could not be instantiated: " + x,
                        x);
            }
        }
    }
}
