package com.example.demo.cache;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author wxq
 * @date 2018-10-31
 */
@CacheConfig
@Component
public class RedisCacheDemo {
    @Cacheable(value = "wxq:test", key = "#p0")
    public String getStr(String s) {
        return String.valueOf(System.currentTimeMillis());
    }
}
