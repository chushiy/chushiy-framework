package com.chushiy.wechat.service;

import org.springframework.web.client.RestTemplate;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/8/23 19:47
 * @Description 微信业务接口
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.wechat.service
 * @ClassName IWeChatService.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
public interface IWeChatService {

    /**
     * 微信小程序登录
     *
     * @param code 微信小程序code
     * @return 请求微信微信小程序登录接口响应
     * @throws IllegalArgumentException 参数错误
     */
    String appletLogin(String code) throws IllegalArgumentException;

    /**
     * 微信小程序登录
     *
     * @param restTemplate RestTemplate
     * @param code 微信小程序code
     * @return 请求微信微信小程序登录接口响应
     * @throws IllegalArgumentException 参数错误
     */
    String appletLogin(RestTemplate restTemplate, String code) throws IllegalArgumentException;
}
