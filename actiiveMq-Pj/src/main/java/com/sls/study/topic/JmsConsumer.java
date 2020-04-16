package com.sls.study.topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumer {

    private  static  final Logger logger = LoggerFactory.getLogger(JmsConsumer.class);

    private  static final String ACTIVE_CONN = "tcp://192.168.1.11:61616";
    private static final String TOPIC_NAME = "topic";
    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("topic1");
        // 根据连接工厂创建
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVE_CONN);

        //获取连接
        Connection connection = connectionFactory.createConnection();
        // 开启连接
        connection.start();

        //获取会话2  事务/签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 创建目的地
        Topic topic = session.createTopic(TOPIC_NAME);
        // 创建消费者
        MessageConsumer consumer = session.createConsumer(topic);

    /*
    利用receive 同步阻塞
    for (; ;) {
            TextMessage textMessage = (TextMessage) consumer.receive();
            if(null != textMessage){
                logger.info("消费者"+textMessage.getText());
            }else {
                break;
            }
        }
        consumer.close();
        session.close();
        connection.close();
        logger.info("消费者结束了" + Thread.currentThread().getName());*/

    /*使用监听器*/
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                if (null != message && message instanceof TextMessage) {
                    try {
                        logger.info("消费者消费信息： " + ((TextMessage) message).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }
}
