package com.sls.mybatis.dao;

import com.sls.mybatis.bean.Teacher;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface ITeacherDao {


    Teacher getOnbyTwo(Map<String,Object> map);

    Teacher getOnebyOne(Map<String,Object> map);
}
