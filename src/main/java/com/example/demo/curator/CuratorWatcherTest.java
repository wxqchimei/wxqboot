package com.example.demo.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.RetryNTimes;

/**
 * @author wxq
 * @date 2018-08-23
 * Curator提供了三种Watcher(Cache)来监听结点的变化：

Path Cache：监视一个路径下1）孩子结点的创建、2）删除，3）以及结点数据的更新。产生的事件会传递给注册的PathChildrenCacheListener。
Node Cache：监视一个结点的创建、更新、删除，并将结点的数据缓存在本地。
Tree Cache：Path Cache和Node Cache的“合体”，监视路径下的创建、更新、删除事件，并缓存路径下所有孩子结点的数据。
下面就测试一下最简单的Path Watcher：
 */
public class CuratorWatcherTest {
    private static final String ZK_ADDRESS = "127.0.0.1:2181";
    private static final String ZK_PATH = "/zk_test";

    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient(ZK_ADDRESS, new RetryNTimes(5, 5000));
        client.start();

        System.out.println("zk client start successfully!");

        PathChildrenCache watcher = new PathChildrenCache(client, ZK_ADDRESS, true);
        watcher.getListenable().addListener((client1,event) ->{
            ChildData data = event.getData();
            if (data == null) {
                System.out.println("No data in event[" + event + "]");
            } else {
                System.out.println("Receive event: "
                        + "type=[" + event.getType() + "]"
                        + ", path=[" + data.getPath() + "]"
                        + ", data=[" + new String(data.getData()) + "]"
                        + ", stat=[" + data.getStat() + "]");
            }
        });

       watcher.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
        System.out.println("Register zk watcher successfully!");

        Thread.sleep(Integer.MAX_VALUE);
    }
}
