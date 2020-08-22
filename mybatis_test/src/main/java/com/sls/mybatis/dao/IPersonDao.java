package com.sls.mybatis.dao;

import com.sls.mybatis.bean.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface IPersonDao {
    /**
     * 获取所有
     * @return
     */
    List<Person> getAll();

    /**
     * 获取任一
     * @return
     */
    Person getOne(int id );

    /**
     * 获取任一
     * @return
     */
    Person getOneByMap(Map<String,Object> map);

    /**
     * 更新操作
     * @param id
     */
    void updatePerson(int id);

    /**
     * 删除操作
     * @param id
     * @return
     */
    int deletePerson(int id);

    /**
     *
     * @param person
     * @return
     */
    Person getOneByPerson(Person person);

    List<Map<String, Object>> getAllMap();

    /**
     * 模糊查询
     * @param pe
     * @return
     */
    List<Person> getLike(Map<String, Object> pe);

    List<Person> getLikeConcat(Map<String, Object> pe);

    /*动态查询 where  if*/
    List<Person> dynamicSqlGet(Map<String,Object> map);

    /*动态查询 trim */
    List<Person> dynamicTrimSqlGet(Map<String,Object> map);

    /*动态查询 choose when otherwise*/
    List<Person> dynamicChooseSqlGet(Map<String,Object> map);


}
