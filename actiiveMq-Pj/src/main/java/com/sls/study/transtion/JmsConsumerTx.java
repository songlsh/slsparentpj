package com.sls.study.transtion;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumerTx {

    private  static  final Logger logger = LoggerFactory.getLogger(JmsConsumerTx.class);

    private  static final String ACTIVE_CONN = "tcp://192.168.1.11:61616";
    private  static final String QUEUE_NAME = "tcp://localhost:61616";
    public static void main(String[] args) throws JMSException, IOException {
        System.out.println("tx");
        // 根据连接工厂创建
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVE_CONN);

        //获取连接
        Connection connection = connectionFactory.createConnection();
        // 开启连接
        connection.start();

        //获取会话2  事务/签收

        /*
        *
        * 签收更偏消费者方    如果是Session.CLIENT_ACKNOWLEDGE 需要在接受到消息以后进行 message.acknowledge();
        *
        * */
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

        // 创建目的地
        Queue queue = session.createQueue(QUEUE_NAME);
        // 创建生产者
        MessageConsumer consumer = session.createConsumer(queue);

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
                        message.acknowledge();
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
