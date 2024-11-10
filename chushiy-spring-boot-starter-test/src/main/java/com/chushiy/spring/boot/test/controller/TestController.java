package com.chushiy.spring.boot.test.controller;

import com.chushiy.crypto.AES;
import com.chushiy.crypto.DES;
import com.chushiy.crypto.util.CryptoUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 18:34
 * @Description TODO
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.test.controller
 * @ClassName TestController.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {

    // @Autowired
    // private CryptoUtils cryptoUtils;

    private final DES aes;


    @GetMapping("/testCryptoUtils")
    public String testCryptoUtils() {
        // log.info(testCryptoUtils);
        log.info(aes.toString());
        return "success";
    }
}
