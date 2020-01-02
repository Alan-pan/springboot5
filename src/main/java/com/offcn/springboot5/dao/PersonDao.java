package com.offcn.springboot5.dao;

import com.offcn.springboot5.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface PersonDao extends JpaRepository<Person, Long> {
    public List<Person> findByNameAndAgeBetween(String name, Integer min, Integer max);

    public List<Person> findByNameContaining(String name);

    public List<Person> findByNameLike(String name);
    //自定义查询
    @Query("select p from Person p where p.name=:name")
    @RestResource(path = "/getPerson")
    public Person getPerson(@Param("name") String name);
    //用户登录验证
    @Query("select p from Person p where p.name=?1 and p.age=?2")
    public Person login(@Param("name") String name, @Param("password") Integer age);
}