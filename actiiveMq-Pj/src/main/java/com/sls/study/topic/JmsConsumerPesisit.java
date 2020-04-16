package com.sls.study.topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumerPesisit {

    private  static  final Logger logger = LoggerFactory.getLogger(JmsConsumerPesisit.class);

    private  static final String ACTIVE_CONN = "tcp://192.168.1.11:61616";
    private static final String TOPIC_NAME = "topic—persist";
    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("topic1");
        // 根据连接工厂创建
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVE_CONN);

        //获取连接
        Connection connection = connectionFactory.createConnection();

        /*持久化设置一个名称*/
        connection.setClientID("topic1");

        //获取会话2  事务/签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic(TOPIC_NAME);

        /*创建消费者持久化对象*/
        TopicSubscriber subscriber = session.createDurableSubscriber(topic, "model...");

        /*开启连接*/
        connection.start();

        subscriber.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage message1 = (TextMessage) message;
                try {
                    logger.info("get topic message"+ message1.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();
        subscriber.close();
        session.close();
        connection.close();
    }
}
