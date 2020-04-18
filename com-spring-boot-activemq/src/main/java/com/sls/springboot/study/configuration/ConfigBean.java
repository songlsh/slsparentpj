package com.sls.springboot.study.configuration;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

@Component
@EnableJms
public class ConfigBean {

    @Value("${myQueue}")
    private  String  queue;

    @Value("${myTopic}")
    private  String  topic;

    @Bean
    public Queue getQueue(){
        System.out.println("myqueue");
        return  new ActiveMQQueue(queue);
    }

    @Bean
    public Topic getTopic(){
        System.out.println("myTopic");
        return  new ActiveMQTopic(topic);
    }


}
