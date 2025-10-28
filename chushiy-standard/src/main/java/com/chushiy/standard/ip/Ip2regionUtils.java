package com.chushiy.standard.ip;

import cn.hutool.core.io.resource.NoResourceException;
import cn.hutool.core.io.resource.ResourceUtil;
import com.chushiy.standard.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.lionsoul.ip2region.xdb.Searcher;

/**
 * @Author 初时y
 * @Email chushiy@qq.com
 * @DateTime 2025/9/8 18:29
 * @Description 离线IP地址定位库和IP定位数据
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.ip
 * @ClassName Ip2regionUtils.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Slf4j
public class Ip2regionUtils {

    private static Searcher SEARCHER;

    /**
     * IP地址库文件路径
     */
    private static final String IP2REGION_DB_PATH = "ip2region/ip2region.xdb";

    static {
        try {
            // 1、将 ip2region 数据库文件 xdb 从 ClassPath 加载到内存。
            // 2、基于加载到内存的 xdb 数据创建一个 Searcher 查询对象。
            SEARCHER = Searcher.newWithBuffer(ResourceUtil.readBytes(IP2REGION_DB_PATH));
            log.info("Ip2regionUtils初始化成功，加载IP地址库数据成功！");
        } catch (NoResourceException e) {
            throw BizException.of("RegionUtils初始化失败，原因：IP地址库数据不存在！");
        } catch (Exception e) {
            throw BizException.of("Ip2regionUtils初始化失败，原因：" + e.getMessage());
        }
    }

    /**
     * 获取IP地址
     *
     * @param ip ip
     * @return IP地址
     */
    public static String getIp2Region(String ip) {
        try {
            // 3、执行查询
            String region = SEARCHER.search(StringUtils.trim(ip));
            return region.replace("0|", "").replace("|0", "");
        } catch (Exception e) {
            log.error("IP地址离线获取城市异常 {}", ip);
            return "未知";
        }
    }

    public static void main(String[] args) {
        System.out.println(getIp2Region("119.130.132.148"));
    }
}
