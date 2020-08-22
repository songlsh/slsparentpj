package com.sls.mybatis.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Teacher {

    private String course;

    private int sex;

    private String name;

    private Classes classes;

    private List<Student> studentList;

}