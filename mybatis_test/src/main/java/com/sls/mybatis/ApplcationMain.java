package com.sls.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@MapperScan("com.sls.mybatis.dao")
public class ApplcationMain {

    public static void main(String[] args) {

    SpringApplication.run(ApplcationMain.class, args);
    }
}
