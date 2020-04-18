package com.sls.study.spring.springCombine;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


// 启动注解扫描
@Component(value = "myMessage")
public class MyMessageListener implements MessageListener {
    public void onMessage(Message message) {
        if(null != message && message instanceof TextMessage){
            try {
                System.out.println("消费到的消息："+ ((TextMessage) message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
