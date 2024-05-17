package com.chushiy.standard.ip;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取地址类
 *
 * @author 初时y
 */
public class AddressUtils {
    /**
     * The constant IP_URL.
     * IP地址查询
     */
    public static final String IP_URL = "http://whois.pconline.com.cn/ipJson.jsp";
    /**
     * The constant UNKNOWN.
     * 未知地址
     */
    public static final String UNKNOWN = "XX XX";

    private static final Logger log = LoggerFactory.getLogger(AddressUtils.class);

    /**
     * 获取真实ip地址
     *
     * @param ip ip
     * @return String real address by ip
     */
    public static String getRealAddressByIP(String ip) {
        String address = UNKNOWN;
        // 内网不查询
        if (IpUtils.internalIp(ip)) {
            return "内网IP";
        }
        try {
            String rspStr = HttpUtils.sendGet(IP_URL, "ip=" + ip + "&json=true", "GBK");
            if (StringUtils.isEmpty(rspStr)) {
                log.error("获取地理位置异常 {}", ip);
                return UNKNOWN;
            }
            JSONObject obj = JSONObject.parseObject(rspStr);
            String region = obj.getString("pro");
            String city = obj.getString("city");
            return String.format("%s %s", region, city);
        } catch (Exception e) {
            log.error("获取地理位置异常 {}", ip);
        }
        return address;
    }
}
