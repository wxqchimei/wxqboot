package com.example.demo.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;

/**
 * @author wxq
 * @date 2018-10-11
 */
public class QueueSender {
    private JmsTemplate jmsTemplate;

    public QueueSender(JmsTemplate jmsTemplate) {
        jmsTemplate.setPubSubDomain(false);
        this.jmsTemplate = jmsTemplate;
    }

    public void send(String queueName, final String message) {
        Destination destination = new ActiveMQQueue(queueName);
        jmsTemplate.send(destination,(session)-> session.createTextMessage(message));
    }
}
