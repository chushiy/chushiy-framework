package com.chushiy.standard.pojo;

import com.chushiy.standard.enums.PlatformEnum;
import lombok.Data;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 下午 5:33
 * @Description 客户端详细信息
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.pojo
 * @ClassName ClientInformation.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Data
public class ClientInformation implements POJO {

    /**
     * 子站域名
     */
    private String website;
    /**
     * 注册ip
     */
    private String ip;
    /**
     * 注册设备 iphone/三星/华为/浏览器
     */
    private String device;
    /**
     * unique id
     */
    private String deviceId;

    /**
     * 设备型号 iphone 5s/小米5
     */
    private String deviceModel;

    /**
     * app id
     */
    private int appId;

    /**
     * app version e.g 7.02
     */
    private float appVersion;

    /**
     * os platform
     */
    private PlatformEnum platform;

    /**
     * 操作系统
     */
    private String os;

    private String userAgent;

    /**
     * os version not app version
     */
    private String clientVersion;

    /**
     * 渠道
     */
    private String channel;

    /**
     * 经度
     */
    private double longitude;

    /**
     * 纬度
     */
    private double latitude;

    /**
     * 中国移动 中国联通 wifi
     */
    private String network;

    /**
     * 是否模拟机
     */
    private Boolean simulate;

    /**
     * International Mobile Equipment Identity
     */
    private String imei;

    private String bssid;

    private String ssid;

    /**
     * for apple unique id
     */
    private String idfa;

    /**
     * 启动时间
     */
    private long startTime;

    /**
     * 重启时间
     */
    private long resumeTime;
}
