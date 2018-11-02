package com.example.demo.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Message;

/**
 * @author wxq
 * @date 2018-10-11
 */
@Configuration
@ConditionalOnClass({ Message.class, JmsTemplate.class })
@EnableConfigurationProperties(JmsProperties.class)
public class ActivemqConfiguration {

    @Bean
    public QueueSender queueSender(JmsTemplate jmsTemplate) {
        return new QueueSender(jmsTemplate);
    }

    @Bean
    public TopicSender topicSender(JmsTemplate jmsTemplate) {
        return new TopicSender(jmsTemplate);
    }

    @Bean(value = "jmsListenerContainerTopic")
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ActiveMQConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }

    @Bean(value = "jmsListenerContainerQueue")
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(false);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
}
