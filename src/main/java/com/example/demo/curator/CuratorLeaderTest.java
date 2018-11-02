package com.example.demo.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.state.ConnectionState;
import org.apache.curator.retry.RetryNTimes;

/**
 * @author wxq
 * @date 2018-08-23
 *
 * 当集群里的某个服务down机时，我们可能要从slave结点里选出一个作为新的master，这时就需要一套能在分布式环境中自动协调的Leader选举方法。
 * Curator提供了LeaderSelector监听器实现Leader选举功能。同一时刻，只有一个Listener会进入takeLeadership()方法，
 * 说明它是当前的Leader。注意：当Listener从takeLeadership()退出时就说明它放弃了“Leader身份”，
 * 这时Curator会利用Zookeeper再从剩余的Listener中选出一个新的Leader。autoRequeue()方法使放弃Leadership的Listener有机会
 * 重新获得Leadership，如果不设置的话放弃了的Listener是不会再变成Leader的
 */
public class CuratorLeaderTest {
    private static final String ZK_ADDRESS = "127.0.0.1:2181";
    private static final String ZK_PATH = "/zk_test";

    public static void main(String[] args) throws InterruptedException {
        LeaderSelectorListener listener = new LeaderSelectorListener() {
            @Override
            public void takeLeadership(CuratorFramework client) throws Exception {
                System.out.println(Thread.currentThread().getName() + " take leadership!");

                Thread.sleep(5000L);

                System.out.println(Thread.currentThread().getName() + " relinquish leadership!");
            }

            @Override
            public void stateChanged(CuratorFramework curatorFramework, ConnectionState connectionState) {

            }
        };
        new Thread(() -> {
            registerListener(listener);
        }).start();

        new Thread(() -> {
            registerListener(listener);
        }).start();

        new Thread(() -> {
            registerListener(listener);
        }).start();

        Thread.sleep(Integer.MAX_VALUE);
    }

    private static void registerListener(LeaderSelectorListener listener) {
        // 1.Connect to zk
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                ZK_ADDRESS,
                new RetryNTimes(10, 5000)
        );
        client.start();

        // 2.Ensure path
        try {
//            new EnsurePath(ZK_PATH).ensure(client.getZookeeperClient());
            client.checkExists().creatingParentContainersIfNeeded();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3.Register listener
        LeaderSelector selector = new LeaderSelector(client, ZK_PATH, listener);
        selector.autoRequeue();
        selector.start();
    }
}
