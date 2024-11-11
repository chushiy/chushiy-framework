package com.chushiy.crypto;

import cn.hutool.crypto.digest.MD5;
import org.junit.Test;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/11 17:18
 * @Description TestMD5
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.crypto
 * @ClassName TestMD5.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
public class TestMD5 {

    @Test
    public void test(){
        String salt = "chushiy11080";
        // MD5 md5 = new MD5(salt.getBytes());
        MD5 md5 = MD5.create();
        System.out.println(md5.digestHex16("初时y"));
    }
}
