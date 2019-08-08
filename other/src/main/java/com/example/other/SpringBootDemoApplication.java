package com.example.other;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author wxq
 * @date 2018-10-30
 */
@SpringBootApplication
@EnableCaching
/**
 * 以下两个注解开启jetcache
 */
//@EnableMethodCache(basePackages = "com.example.cache")
//@EnableCreateCacheAnnotation
public class SpringBootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
