package com.sls.study.transtion;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

public class JmsProductorTx {

    private  static  final Logger logger = LoggerFactory.getLogger(JmsProductorTx.class);

    private static final String ACTIVE_CONN = "tcp://192.168.1.11:61616";
    private static final String QUEUE_NAME = "tcp://localhost:61616";
    public static void main(String[] args) throws JMSException {
        // 根据连接工厂创建
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ACTIVE_CONN);

        //获取连接
        Connection connection = connectionFactory.createConnection();
        // 开启连接
        connection.start();

        //获取会话2  事务/签收
        /*
        * 生产者更偏事务  事务为true  则需要对应的session.commit  =》 如果出现多个方法执行 其中一个出错可以使用sessio.rollback回滚
        *
        * */
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

        // 创建目的地
        Queue queue = session.createQueue(QUEUE_NAME);
        // 创建生产者
        MessageProducer producer = session.createProducer(queue);

        for (int i = 1; i <= 3; i++) {
            //创建消息
            TextMessage textMessage = session.createTextMessage();


            textMessage.setText("***生产者生产"+i);

            producer.send(textMessage);
        }
        producer.close();
        session.commit();
        session.close();
        connection.close();
        logger.info("生产者结束了" + Thread.currentThread().getName());

    }
}
