package com.example.demo.dao;

import com.example.demo.pojo.Admin;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
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
            @Result(column = "id",property = "roles",
                many = @Many(select = "com.example.demo.dao.RoleDao.getRoleByAid",fetchType = FetchType.DEFAULT))
    })
    Admin selectAdminByNameAndPassword(String adminname, String password);


    @Select("SELECT * FROM admin WHERE name=#{adminName}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "adminname"),
            @Result(column = "password",property = "password"),
            @Result(column = "remarks",property = "remarks"),
            @Result(column = "id",property = "roles",
                    many = @Many(select = "com.example.demo.dao.RoleDao.getRoleByAid",fetchType = FetchType.DEFAULT))
    })
    Admin selectAdminByName(String adminName);

    @Select("<script>"
            +"select * from admin"
            +"<if test='searchMsg!=null'>"
            +"where name LIKE concat('%',#{searchMsg},'%')"
            +"</if>"
            +"limit #{star},#{pageSize}"
            +"</script>")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "adminname"),
            @Result(column = "password",property = "password"),
            @Result(column = "remarks",property = "remarks"),
            @Result(column = "id",property = "roles",
                    many = @Many(select = "com.example.demo.dao.RoleDao.getRoleByAid",fetchType = FetchType.DEFAULT))
    })
    List<Admin> selectAdmin(int pageSize,int star,@Param("searchMsg")String searchMsg);


    @Select("delete from admin where id = #{id}")
    void deleteAdmin(int id);

    @Insert("insert into admin (name,password,remarks,isUsed) " +
            "values (#{adminname},#{password},#{remarks},#{isUsed})")
    void insertAdmin(Admin admin);

    @Select("<script>"
            +"select count(1) from admin"
            +"<if test='searchMsg!=null'>"
            +"where name LIKE concat('%',#{searchMsg},'%')"
            +"</if>"
            +"</script>")
    int getTotal(@Param("searchMsg")String searchMsg);

    @Update("update admin set name = #{adminname},password=#{password},remarks=#{remarks} where id=#{id}")
    void updateAdmin(Admin admin);

    @Update("update admin set isUsed=${isUsed} where id=#{id}")
    void banAdmin(int id,boolean isUsed);

    @Select("select * from admin where name=#{name}")
    Admin getAdminByName(String name);

}
