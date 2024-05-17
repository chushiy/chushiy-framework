package com.chushiy.standard;

import com.chushiy.standard.pojo.ClientInformation;
import com.chushiy.standard.pojo.LoginUser;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 下午 5:26
 * @Description 线程上下文
 * @ProjectName chushiy
 * @PackageName com.chushiy.standard
 * @ClassName ThreadContext.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
public class ThreadContext {

    /**
     * 登录用户
     */
    private static InheritableThreadLocal<LoginUser> loginUserThreadLocal = new InheritableThreadLocal<>();

    /**
     * 客户端信息 clientInformationThreadLocal
     */
    private static InheritableThreadLocal<ClientInformation> clientInformationThreadLocal = new InheritableThreadLocal<>();

    public static void removeClientInformation() {
        clientInformationThreadLocal.remove();
    }

    public static void removeLoginUser() {
        loginUserThreadLocal.remove();
    }

    public static LoginUser getLoginUser() {
        return loginUserThreadLocal.get();
    }

    public static void setLoginUser(LoginUser loginUser) {
        loginUserThreadLocal.set(loginUser);
    }

    public static ClientInformation getClientInformation() {
        return clientInformationThreadLocal.get();
    }

    public static void setClientInformation(ClientInformation clientInformation) {
        clientInformationThreadLocal.set(clientInformation);
    }
}
