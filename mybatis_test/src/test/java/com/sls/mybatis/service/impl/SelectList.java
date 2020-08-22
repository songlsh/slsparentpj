package com.sls.mybatis.service.impl;

import com.sls.mybatis.bean.Person;
import com.sls.mybatis.dao.IPersonDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SelectList {
    @Autowired
    IPersonDao dao;

    @Test
    public void getAll() {
        System.out.println(dao.getAll());
    }

    @Test
    public void getAllMap() {
        System.out.println(dao.getAllMap());
    }

    @Test
    public void getLikeMap() {
        Map<String, Object> pe = new HashMap<>();
       pe.put("keyword","%wu%");
       List<Person> person =  dao.getLike(pe);
        System.out.println(person);
    }

    @Test
    public void getLikeConcatMap() {
        Map<String, Object> pe = new HashMap<>();
        pe.put("keyword","wu");
        List<Person> person =  dao.getLikeConcat(pe);
        person.stream().forEach(pe1->{
        System.out.println(pe1);
        });
    }

    @Test
    public void dynamicSelect() {
        Map<String, Object> pe = new HashMap<>();
        pe.put("nickname","%liu%");
        pe.put("id",1);
        List<Person> person =  dao.dynamicSqlGet(pe);
        person.stream().forEach(pe1->{
            System.out.println(pe1);
        });
    }

    @Test
    public void dynamicTrimSqlGet() {
        Map<String, Object> pe = new HashMap<>();
        pe.put("nickname","%liu%");
        pe.put("id",1);
        List<Person> person =  dao.dynamicTrimSqlGet(pe);
        person.stream().forEach(pe1->{
            System.out.println(pe1);
        });
    }

    @Test
    public void dynamicChooseSqlGet() {
        Map<String, Object> pe = new HashMap<>();
        pe.put("nickname","%liu%");
        pe.put("id",1);
        List<Person> person =  dao.dynamicChooseSqlGet(pe);
        person.stream().forEach(pe1->{
            System.out.println(pe1);
        });
    }
}
