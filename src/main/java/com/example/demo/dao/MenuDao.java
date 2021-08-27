package com.example.demo.dao;

import com.example.demo.pojo.Menu;
import com.example.demo.pojo.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuDao {

    @Select("select * from menu where id = #{id}")
    Menu findById(int id);

    @Select("select * from menu where parentId = #{parentId}")
    List<Menu> findAllByParentId(int parentId);

    @Select("<script>" +
            "select * from menu where id in("
            +"<foreach collection='menuIds' separator=',' item='id'>"
            + "#{id} "
            + "</foreach> "
            +")</script>")
    List<Menu> findAllByIds(@Param("menuIds") List<Integer> menuIds);
}
