package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @author wxq
 * @date 2018-09-29
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyController {
    String value() default "";
}
