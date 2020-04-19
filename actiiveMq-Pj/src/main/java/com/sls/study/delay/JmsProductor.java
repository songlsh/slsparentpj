package com.sls.study.delay;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;
import org.apache.activemq.ScheduledMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import java.util.UUID;

public class JmsProductor {

    private  static  final Logger logger = LoggerFactory.getLogger(JmsProductor.class);

    private static final String ACTIVE_CONN = "tcp://192.168.1.11:61616";
    private static final String QUEUE_NAME = "delayQueue";
    public static void main(String[] args) throws JMSException {
        // 根据连接工厂创建
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVE_CONN);
        //获取连接
        Connection connection = connectionFactory.createConnection();
        // 开启连接
        connection.start();



        //获取会话2  事务/签收
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 创建目的地
        Queue queue = session.createQueue(QUEUE_NAME);
        // 创建生产者
        MessageProducer producer = session.createProducer(queue);

        for (int i = 1; i <= 3; i++) {
            //创建消息
            TextMessage textMessage = session.createTextMessage();

            textMessage.setText("***生产者生产"+i);

            long delay = 30*1000L;
            long period = 1*1000L;
            int  repeat = 5;
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY,delay);
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD,delay);
            textMessage.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT,repeat);
            producer.send(textMessage);
        }
        producer.close();
        session.close();
        connection.close();
        logger.info("生产者结束了" + Thread.currentThread().getName());

    }
}
