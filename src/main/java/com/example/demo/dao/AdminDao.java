package com.example.demo.dao;

import com.example.demo.pojo.User;
import com.example.demo.pojo.admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminDao {

    @Select("SELECT * FROM USER WHERE name=#{username} and password=#{password}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "username"),
            @Result(column = "password",property = "password"),
    })
    admin selectAdminByNameAndPassword(String username, String password);
}
