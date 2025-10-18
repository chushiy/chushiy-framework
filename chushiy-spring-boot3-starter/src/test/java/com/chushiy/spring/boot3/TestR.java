package com.chushiy.spring.boot3;

import com.chushiy.standard.pojo.R;
import com.chushiy.standard.pojo.Result;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/11/10 16:09
 * @Description TestR
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot
 * @ClassName TestR.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
public class TestR {

    public static void main(String[] args) {
        System.out.println(R.ok() instanceof Result);
        System.out.println(Result.ok() instanceof Result);
    }
}
