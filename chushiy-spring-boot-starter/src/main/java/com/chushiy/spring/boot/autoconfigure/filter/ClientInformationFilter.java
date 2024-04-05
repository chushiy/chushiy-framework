package com.chushiy.spring.boot.autoconfigure.filter;

import com.chushiy.standard.ThreadContext;
import com.chushiy.standard.enums.PlatformEnum;
import com.chushiy.standard.ip.IpUtils;
import com.chushiy.standard.pojo.ClientInformation;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.BrowserType;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.web.servlet.filter.OrderedFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/3/24 下午 5:18
 * @Description 客户端信息
 * @ProjectName chushiy
 * @PackageName com.chushiy.spring.boot.autoconfigure.filter
 * @ClassName ClientInformationFilter.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@Slf4j
public class ClientInformationFilter implements OrderedFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        ClientInformation clientInformation = new ClientInformation();
        clientInformation.setIp(IpUtils.getIpAddr(request));
        log.info("client ip {}", clientInformation.getIp());
        String appId = request.getHeader("APP_ID");
        if (StringUtils.isNotBlank(appId)) {
            clientInformation.setAppId(Integer.parseInt(appId));
        }

        String appVersion = request.getHeader("APP_VERSION");
        if (StringUtils.isNotBlank(appVersion)) {
            clientInformation.setAppVersion(Float.parseFloat(appVersion));
        }

        clientInformation.setBssid(request.getHeader("BSSID"));
        clientInformation.setChannel(request.getHeader("CHANNEL"));
        clientInformation.setClientVersion(request.getHeader("CLIENT_VERSION"));
        clientInformation.setDevice(request.getHeader("DEVICE"));
        clientInformation.setDeviceId(request.getHeader("DEVICE_ID"));
        clientInformation.setDeviceModel(request.getHeader("DEVICE_MODEL"));
        clientInformation.setIdfa(request.getHeader("IDFA"));
        clientInformation.setImei(request.getHeader("IMEI"));
        String latitude = request.getHeader("LATITUDE");
        if (StringUtils.isNotBlank(latitude)) {
            clientInformation.setLatitude(Double.parseDouble(request.getHeader("LATITUDE")));
        }

        String longitude = request.getHeader("LONGITUDE");
        if (StringUtils.isNotBlank(longitude)) {
            clientInformation.setLongitude(Double.parseDouble(request.getHeader("LONGITUDE")));
        }

        clientInformation.setOs(request.getHeader("OS"));
        clientInformation.setNetwork(request.getHeader("NETWORK"));
        String startTime = request.getHeader("START_TIME");
        if (StringUtils.isNotBlank(startTime)) {
            clientInformation.setStartTime(Long.parseLong(startTime));
        }

        String resumeTime = request.getHeader("RESUME_TIME");
        if (StringUtils.isNotBlank(resumeTime)) {
            clientInformation.setResumeTime(Long.parseLong(resumeTime));
        }

        clientInformation.setUserAgent(request.getHeader("User-Agent"));
        UserAgent userAgent = UserAgent.parseUserAgentString(clientInformation.getUserAgent());
        OperatingSystem os = userAgent.getOperatingSystem();
        Browser browser = userAgent.getBrowser();
        log.info("device type {},browser type {}", os.getDeviceType(), browser.getBrowserType());
        if (os.getDeviceType().equals(DeviceType.COMPUTER) || BrowserType.MOBILE_BROWSER.equals(browser.getBrowserType())) {
            clientInformation.setOs(os.getGroup().getName());
            clientInformation.setPlatform(PlatformEnum.PC);
            clientInformation.setDevice(browser.getName());
            clientInformation.setDeviceId(clientInformation.getIp());
        }

        String simulate = request.getHeader("SIMULATE");
        if (StringUtils.isNotBlank(simulate)) {
            clientInformation.setSimulate(Boolean.valueOf(simulate));
        }

        ThreadContext.setClientInformation(clientInformation);
        chain.doFilter(request, response);
        ThreadContext.removeClientInformation();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
