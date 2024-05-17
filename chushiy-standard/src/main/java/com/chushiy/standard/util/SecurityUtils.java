package com.chushiy.standard.util;

import com.chushiy.standard.ThreadContext;
import com.chushiy.standard.pojo.LoginUser;

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

    public static LoginUser getLoginUser() {
        return ThreadContext.getLoginUser();
    }
}
