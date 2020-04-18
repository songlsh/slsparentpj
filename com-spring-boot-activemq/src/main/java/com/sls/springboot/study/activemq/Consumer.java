package com.sls.springboot.study.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;

@Component
public class Consumer {

   @JmsListener(destination = "${myQueue}")
    public void getMeessage(Message message) throws JMSException {
       System.out.println("监听。。。。。");
       if(null != message && message instanceof TextMessage){
           System.out.println(((TextMessage) message).getText());
       }
    }
}
