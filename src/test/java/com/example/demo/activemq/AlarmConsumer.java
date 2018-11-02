package com.example.demo.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author wxq
 * @date 2018-10-11
 */
@Component
public class AlarmConsumer {

    @JmsListener(destination = "mytest.topic", containerFactory = "jmsListenerContainerTopic")
    public void consumeTopic(String text) {
        System.out.println("消费者发布订阅受到消息1" + text);
    }

    //    @JmsListener(destination = "mytest.queue", containerFactory = "jmsListenerContainerQueue")
    @JmsListener(destination = "mytest.queue")
    public void consumeQueue(String text) {
        System.out.println("消费者点对点受到消息1" + text);
    }
}
