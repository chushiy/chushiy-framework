package com.chushiy.standard.util;

import com.chushiy.standard.ThreadContext;
import com.chushiy.standard.pojo.LoginUser;

import java.util.Set;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/5/17 下午 1:24
 * @Description 安全相关工具类
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.util
 * @ClassName SecurityUtils.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class SecurityUtils {

    /**
     * @Author 初时y
     * @DateTime 2024/5/30 下午 4:44
     * @Description 获取登录的用户
     * @Return com.chushiy.standard.pojo.LoginUser
     **/
    public static LoginUser getLoginUser() {
        return ThreadContext.getLoginUser();
    }

    /**
     * @Author 初时y
     * @DateTime 2024/5/30 下午 4:44
     * @Description 获取登录的用户名称
     * @Return java.lang.String
     **/
    public static String getUserName() {
        return getLoginUser().getUserName();
    }

    /**
     * @Author 初时y
     * @DateTime 2024/5/30 下午 4:47
     * @Description 获取用户id
     * @Return java.lang.Long
     **/
    public static Long getUserId() {
        return getLoginUser().getUserId();
    }

    /**
     * @Author 初时y
     * @DateTime 2024/5/30 下午 4:47
     * @Description 获取用户权限
     * @Return java.util.Set<java.lang.String>
     **/
    public static Set<String> getPermissions() {
        return getLoginUser().getPermissions();
    }
}
