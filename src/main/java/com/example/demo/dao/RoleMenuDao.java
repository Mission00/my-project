package com.example.demo.dao;


import com.example.demo.pojo.Role;
import com.example.demo.pojo.RoleMenu;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMenuDao {

    @Select("select * from role_menu where rid = #{rid}")
    List<RoleMenu> findAllByRid(int rid);

    @Select("<script>" +
            "select * from role_menu where rid in("
            +"<foreach collection='rids' separator=',' item='id'>"
            + "#{id} "
            + "</foreach> "
            +")</script>")
    List<RoleMenu> findAllByRids(@Param("rids") List<Integer> rids);

    @Delete("delete from role where rid = #{rid}")
    void deleteAllByRid(int rid);
}
