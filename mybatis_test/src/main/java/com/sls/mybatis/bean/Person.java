package com.sls.mybatis.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
//@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class Person {

    private int id;

    private int sex;

    private String race;  //种族

    private String nickname;

}
