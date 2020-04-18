package com.sls.springboot.study.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Topic {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private javax.jms.Topic topic;

    public  void  sendTopic(){
        jmsMessagingTemplate.convertAndSend(topic,"send topic :"+ UUID.randomUUID().toString().substring(0,6));
    }
}
