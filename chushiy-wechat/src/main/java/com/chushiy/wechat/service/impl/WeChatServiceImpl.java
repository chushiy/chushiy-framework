package com.chushiy.wechat.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.chushiy.standard.util.Assert;
import com.chushiy.wechat.constant.WeChatConstants;
import com.chushiy.wechat.properties.WeChatProperties;
import com.chushiy.wechat.service.IWeChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/8/23 19:50
 * @Description 微信业务接口实现
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.wechat.service.impl
 * @ClassName WeChatServiceImpl.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class WeChatServiceImpl implements IWeChatService {

    private final WeChatProperties weChatProperties;

    @Override
    public String appletLogin(String code) throws IllegalArgumentException {
        String appId = weChatProperties.getApplet().getAppId();
        Assert.isNotBlank(appId, "appId不能为空");
        String secret = weChatProperties.getApplet().getSecret();
        Assert.isNotBlank(secret, "secret不能为空");
        return HttpUtil.get(StrUtil.format(WeChatConstants.APPLET_LOGIN_URL, appId, secret, code));
    }

    @Override
    public String appletLogin(RestTemplate restTemplate, String code) throws IllegalArgumentException {
        String appId = weChatProperties.getApplet().getAppId();
        Assert.isNotBlank(appId, "appId不能为空");
        String secret = weChatProperties.getApplet().getSecret();
        Assert.isNotBlank(secret, "secret不能为空");
        return restTemplate.getForObject(StrUtil.format(WeChatConstants.APPLET_LOGIN_URL, appId, secret, code), String.class);
    }
}
