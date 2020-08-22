package com.sls.mybatis.service.impl;

import com.sls.mybatis.bean.Person;
import com.sls.mybatis.dao.IPersonDao;
import com.sls.mybatis.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPersonServiceImpl implements IPersonService {

    @Autowired
    IPersonDao personDao;

    @Override
    public List<Person> getAllPeople() {
        return personDao.getAll();
    }
}
