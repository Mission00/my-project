package com.example.demo.dao;

import com.example.demo.pojo.Menu;
import com.example.demo.pojo.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Repository
public interface MenuDao {

    @Select("select * from menu where id = #{id}")
    Menu findById(int id);

    @Select("select * from menu")
    List<Menu> getAllMenu();

    @Select("select * from menu where parentId = #{parentId}")
    List<Menu> findAllByParentId(int parentId);

    @Select("<script>" +
            "select * from menu where id in("
            +"<foreach collection='menuIds' separator=',' item='id'>"
            + "#{id} "
            + "</foreach> "
            +")</script>")
    List<Menu> findAllByIds(@Param("menuIds") List<Integer> menuIds);


    @Select("<script>" +
            "select m.* from role r " +
            "left join role_menu rm " +
            "on r.id = rm.rid " +
            "join menu m " +
            "on rm.mid = m.id " +
            "where r.id = #{rid}" +
            "</script>")
    List<Menu> getMenusByRid(@Param("rid") int rid);
}
