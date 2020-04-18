package com.sls.springboot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class ApplictionMain {

    public static void main(String[] args) {
        SpringApplication.run(ApplictionMain.class,args);
    }
}
