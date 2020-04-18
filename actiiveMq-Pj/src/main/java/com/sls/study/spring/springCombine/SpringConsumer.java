package com.sls.study.spring.springCombine;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@Component
public class SpringConsumer {

    @Autowired
    @Qualifier("jmsTemplateName")
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) throws JMSException {
        // 读取配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("appliction.xml");

        SpringConsumer product = (SpringConsumer) ac.getBean("springConsumer");

        String o = (String) product.jmsTemplate.receiveAndConvert();

        System.out.println("消费的消息为： "+o);


    }
}
