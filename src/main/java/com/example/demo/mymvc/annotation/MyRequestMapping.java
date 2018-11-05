package com.example.demo.mymvc.annotation;

import java.lang.annotation.*;

/**
 * @author wxq
 * @date 2018-09-29
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestMapping {
    /**
     * 表示访问该方法的url
     * @return
     */
    String value() default "";

}