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
    /**
     * 在redis中会以 wxq:test::1这样的方式存储
     * @param s
     * @return
     */
    @Cacheable(value = "wxq:test", key = "#p0")
    public String getStr(String s) {
        return String.valueOf(System.currentTimeMillis());
    }
}
