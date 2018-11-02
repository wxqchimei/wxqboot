package com.example.demo.fastdfs;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * @author wxq
 * @date 2018-11-02
 * TrackerServer 工厂类，创建对象池需要 BasePooledObjectFactory 对象或子类.
 */
public class TrackerServerFactory extends BasePooledObjectFactory<TrackerServer> {
    @Override
    public TrackerServer create() throws Exception {
        // TrackerClient
        TrackerClient trackerClient = new TrackerClient();
        // TrackerServer
        return trackerClient.getConnection();
    }

    @Override
    public PooledObject<TrackerServer> wrap(TrackerServer trackerServer) {
        return new DefaultPooledObject<>(trackerServer);
    }
}
