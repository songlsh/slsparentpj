package com.sls.mybatis.service.impl;

import com.sls.mybatis.bean.Person;
import com.sls.mybatis.dao.IPersonDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SelectOne {

    @Autowired
    private IPersonDao dao;

    @Test
    public void getOne() {
        System.out.println(dao.getOne(1));
    }
    @Test
    public void getOnebyMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("id",2);
        System.out.println(dao.getOneByMap(map));
    }

    @Test
    public void getOneByPerson() {
        Person person = Person.of();
        person.setId(2);
        System.out.println(dao.getOneByPerson(person));
    }
    @Test
    public void remove() {
        System.out.println(dao.deletePerson(1));
    }
}