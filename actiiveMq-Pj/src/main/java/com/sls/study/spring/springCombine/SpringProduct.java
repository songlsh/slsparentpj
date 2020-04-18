package com.sls.study.spring.springCombine;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class SpringProduct {

    @Autowired
    @Qualifier("jmsTemplateName")
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        // 读取配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("appliction.xml");

        SpringProduct product = (SpringProduct) ac.getBean("springProduct");

        product.jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("生产者 发送topic。。。");
            }
        });

        System.out.println("生产者发送成功");
    }

}
