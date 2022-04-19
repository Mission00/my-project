package com.example.demo.dao;

import com.example.demo.pojo.Admin;
import com.example.demo.pojo.User;
import lombok.Setter;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


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
    User insertUser(User user);

    @Select("SELECT * FROM USER WHERE name=#{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "username"),
            @Result(column = "password",property = "password"),
    })
    User selectUserByName(String username);

    @Select("<script>"
            +"select * from user"
            +"<if test='searchMsg!=null'>"
            +"where name LIKE concat('%',#{searchMsg},'%')"
            +"</if>"
            +"limit #{star},#{pageSize}"
            +"</script>")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "username"),
            @Result(column = "password",property = "password"),
    })
    List<User> selectUser(int pageSize, int star, @Param("searchMsg")String searchMsg);

    @Select("<script>"
            +"select count(1) from user"
            +"<if test='searchMsg!=null'>"
            +"where name LIKE concat('%',#{searchMsg},'%')"
            +"</if>"
            +"</script>")
    int getTotal(@Param("searchMsg")String searchMsg);

    @Delete("delete from user where id = #{id}")
    void deleteUser(int id);

    @Update("update user set name = #{username},password=#{password},head=#{head} where id=#{id}")
    void updateUser(User user);

    @Select("select * from user where id = #{id}")
    @Results(@Result(column = "name",property = "username"))
    User getUserByID(int id);
}
