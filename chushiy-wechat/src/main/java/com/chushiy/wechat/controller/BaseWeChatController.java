package com.chushiy.wechat.controller;

import com.chushiy.wechat.service.IWeChatService;
import lombok.RequiredArgsConstructor;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/8/23 19:12
 * @Description 微信
 * @ProjectName chushiy-wechat
 * @PackageName com.chushiy.wechat.controller
 * @ClassName BaseWeChatController.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@RequiredArgsConstructor
public abstract class BaseWeChatController {

    private final IWeChatService weChatService;

    /**
     * 微信小程序登录
     * @param code 登录时获取的 code，可通过wx.login获取
     * @return
     */
    // public Result appletLogin(String code) {
    //     this.weChatService.appletLogin(code);
    //     return null;
    // }
}
