package com.example.demo.dao;


import com.example.demo.pojo.Role;
import com.example.demo.pojo.RoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.websocket.server.ServerEndpoint;
import java.util.List;

@Mapper
@Repository
public interface RoleDao {

    @Select("select * from role where id = #{id}")
    Role findById(int id);

    @Select("select * from role")
    List<Role> findAll();

    @Select("<script>" +
            "select * from role where rid in("
            +"<foreach collection='rids' separator=',' item='id'>"
            + "#{id} "
            + "</foreach> "
            +")</script>")
    List<Role> findAllByRid(@Param("rids") List<Integer> rids);
}
