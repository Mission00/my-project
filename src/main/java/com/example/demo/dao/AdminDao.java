package com.example.demo.dao;

import com.example.demo.pojo.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AdminDao {

    @Select("SELECT * FROM admin WHERE name=#{adminname} and password=#{password}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "adminname"),
            @Result(column = "password",property = "password"),
            @Result(column = "remarks",property = "remarks"),
    })
    Admin selectAdminByNameAndPassword(String adminname, String password);


    @Select("SELECT * FROM admin WHERE name=#{adminName}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "adminname"),
            @Result(column = "password",property = "password"),
            @Result(column = "remarks",property = "remarks"),
    })
    Admin selectAdminByName(String adminName);

    @Select("select * from admin limit #{star},#{pageSize}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "adminname"),
            @Result(column = "password",property = "password"),
            @Result(column = "remarks",property = "remarks"),
    })
    List<Admin> selectAdmin(int pageSize,int star);

    @Select("select count(1) from admin")
    int getAdminTotol();

    @Select("delete from admin where id = #{id}")
    void deleteAdmin(int id);

    @Insert("insert into admin (name,password,remarks) values (#{adminname},#{password},#{remarks})")
    void insertAdmin(Admin admin);
}
