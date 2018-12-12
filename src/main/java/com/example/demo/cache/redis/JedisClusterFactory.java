package com.example.demo.cache.redis;

import com.google.common.collect.Sets;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import redis.clients.jedis.*;
import redis.clients.util.JedisClusterCRC16;

import java.text.ParseException;
import java.util.*;

/**
 * @author chenlongfei
 * redis集群
 */
public class JedisClusterFactory implements FactoryBean<JedisCluster>, InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(JedisClusterFactory.class);
    private GenericObjectPoolConfig genericObjectPoolConfig;
    private JedisCluster jedisCluster;
    private int connectionTimeout = 2000;
    private int soTimeout = 3000;
    private int maxRedirections = 5;
    private Set<String> jedisClusterNodes;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (jedisClusterNodes == null || jedisClusterNodes.size() == 0) {
            throw new NullPointerException("jedisClusterNodes is null.");
        }
        Set<HostAndPort> haps = new HashSet<HostAndPort>();
        for (String node : jedisClusterNodes) {
            String[] arr = node.split(":");
            if (arr.length != 2) {
                throw new ParseException("node address error !", node.length() - 1);
            }
            haps.add(new HostAndPort(arr[0], Integer.valueOf(arr[1])));
        }
        jedisCluster = new JedisCluster(haps, connectionTimeout, soTimeout, maxRedirections, genericObjectPoolConfig);
    }

    @Override
    public JedisCluster getObject() throws Exception {
        return jedisCluster;
    }

    @Override
    public Class<?> getObjectType() {
        return (this.jedisCluster != null ? this.jedisCluster.getClass() : JedisCluster.class);
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
