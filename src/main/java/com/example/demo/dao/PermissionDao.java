package com.example.demo.dao;


import com.example.demo.pojo.Permission;
import com.example.demo.pojo.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface PermissionDao {

    @Select("<script>" +
            "select * from permission where id in("
            +"<foreach collection='ids' separator=',' item='id'>"
            + "#{id} "
            + "</foreach> "
            +")</script>")
    List<Permission> findAllByIds(@Param("ids") List<Integer> ids);

    @Select("select * from permission")
    List<Permission> findAll();

    @Select("select p.* from " +
            "role r " +
            "left join role_permission rp " +
            "on r.id = rp.rid " +
            "join permission p " +
            "on rp.pid = p.id " +
            "WHERE r.id = #{Rid}")
    List<Permission> getPermissionByRid(int Rid);


//    @Update("update permission set name = #{name},desc = #{desc},url = #{url}"+
//            "where id = #{id}")
    @Update("update permission set `desc`=#{desc},name=#{name},url=#{url}"+
            "where id = #{id}")
    void updatePermission(Permission permission);

    @Insert("insert into permission (name,`desc`,url) values (#{name},#{desc},#{url})")
    void addPermission(Permission permission);

    @Delete("delete from permission where id=#{id}")
    void deletePermission(Permission permission);
}
