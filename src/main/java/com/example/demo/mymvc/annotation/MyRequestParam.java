package com.example.demo.mymvc.annotation;

import java.lang.annotation.*;

/**
 * @author wxq
 * @date 2018-09-29
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestParam {
    /**
     * 表示参数的别名，必填
     * @return
     */
    String value();

}
