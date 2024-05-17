package com.chushiy.spring.boot.autoconfigure.converter;

import com.chushiy.spring.boot.autoconfigure.properties.ChuShiYProperties;
import com.chushiy.standard.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.time.LocalDate;

/**
 * @Author 初时y
 * @Email 2283873481@qq.com
 * @DateTime 2024/4/8 下午 8:54
 * @Description string转LocalDate转换器
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.spring.boot.autoconfigure.converter
 * @ClassName StringToLocalDateConverter.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0
 */
@RequiredArgsConstructor
public class StringToLocalDateConverter implements Converter<String, LocalDate> {

    private final ChuShiYProperties chuShiYProperties;

    @Override
    public LocalDate convert(String source) {
        try {
            return DateUtils.parse(source, this.chuShiYProperties.getDateParsePatterns());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
