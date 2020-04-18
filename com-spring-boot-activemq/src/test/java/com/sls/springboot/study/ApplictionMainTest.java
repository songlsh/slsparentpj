package com.sls.springboot.study;

import com.sls.springboot.study.activemq.Consumer;
import com.sls.springboot.study.activemq.Productor;
import com.sls.springboot.study.topic.Topic;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringBootTest(classes = ApplictionMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public  class ApplictionMainTest {

    @Autowired
    private Productor productor;

    @Autowired
    private Topic topic;

//    @Autowired
//    private Consumer consumer;

    @Test
    public void test(){
       productor.send();
    }

    @Test
    public  void test1(){
        topic.sendTopic();
    }

}