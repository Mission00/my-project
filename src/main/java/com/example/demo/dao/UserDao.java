package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserDao {

    @Select("SELECT * FROM USER WHERE name=#{username} and password=#{password}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "username"),
            @Result(column = "password",property = "password"),
    })
    User selectUserByNameAndPassword(String username,String password);

    @Select("INSERT INTO USER (name,password) VALUES (#{username},#{password})")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "username"),
            @Result(column = "password",property = "password"),
    })
    User insertUser(String username,String password);

    @Select("SELECT * FROM USER WHERE name=#{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "username"),
            @Result(column = "password",property = "password"),
    })
    User selectUserByName(String username);
}
