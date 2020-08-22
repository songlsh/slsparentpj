package com.sls.mybatis.service.impl;

import com.sls.mybatis.bean.Teacher;
import com.sls.mybatis.dao.ITeacherDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class selectTeacher {

    @Autowired
    ITeacherDao teacherDao;


    @Test
    public void testOnebytwo() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);

        Teacher one = teacherDao.getOnbyTwo(map);

        System.out.println(one);
    }
    @Test
    public void testOnebyOne() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);

        Teacher one = teacherDao.getOnebyOne(map);

        System.out.println(one);
    }


}
