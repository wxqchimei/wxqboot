package com.example.demo.activemq;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;

/**
 * @author wxq
 * @date 2018-10-11
 */
public class TopicSender {
    private JmsTemplate jmsTemplate;

    public TopicSender(JmsTemplate jmsTemplate) {
        jmsTemplate.setPubSubDomain(true);
        this.jmsTemplate = jmsTemplate;
    }

    public void send(String queueName, final String message) {
        Destination destination = new ActiveMQTopic(queueName);
        jmsTemplate.convertAndSend(destination, message);
    }
}
