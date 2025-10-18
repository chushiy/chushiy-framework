package com.chushiy.standard.pojo;

import com.chushiy.json.JSONFactory;
import com.chushiy.jsonapi.JSON;

import java.io.Serializable;

/**
 * @Author 初时y
 * @DateTime 2023/11/28 下午 11:17
 * @Description pojo基类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.pojo
 * @ClassName POJO.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public interface POJO extends Serializable {

    static final long serialVersionUID = 1L;

    /**
     * 将当前对象属性复制到目标对象中
     * 默认实现
     *
     * @param target 目标
     * @param <T>    目标对象类型
     * @return 目标对象
     */
    default <T> T copyProperties(Class<T> target) {
        JSON json = JSONFactory.getJSONProvider();
        return json.parse(json.toJSONString(this), target);
    }
}
