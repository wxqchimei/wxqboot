package com.example.demo.cache;

import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;

/**
 * @author wxq
 * @date 2018-11-26
 */
public interface JetCacheDemo {
    @Cached(name = "UserService.getUserById", expire = 3600,cacheType = CacheType.BOTH)
    String getUserById(Long userId);
}
