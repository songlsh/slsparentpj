package com.sls.springboot.study.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class Productor {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void send(){
        jmsMessagingTemplate.convertAndSend(queue,"send to consumer");
    }

    @Scheduled(fixedDelay = 3000L)
    public void sendScheduled(){
        jmsMessagingTemplate.convertAndSend(queue,"send to consumer");
        System.out.println("scheduled*****");
    }
}
