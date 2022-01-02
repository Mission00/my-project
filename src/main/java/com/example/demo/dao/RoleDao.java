package com.example.demo.dao;


import com.example.demo.pojo.Role;
import com.example.demo.pojo.RoleMenu;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import javax.websocket.server.ServerEndpoint;
import java.util.List;

@Mapper
@Repository
public interface RoleDao {

    @Select("select * from role where id = #{id}")
    Role findById(int id);

    @Select("select * from role")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "id", property = "perms",
                    many = @Many(select = "com.example.demo.dao.PermissionDao.getPermissionByRid", fetchType = FetchType.DEFAULT)),
    })
    List<Role> findAll();

    @Select("<script>" +
            "select * from role where id in("
            +"<foreach collection='rids' separator=',' item='id'>"
            + "#{id} "
            + "</foreach> "
            +")</script>")
    List<Role> findAllByRid(@Param("rids") List<Integer> rids);


    @Select("select r.* from admin a " +
            "left join admin_role ar " +
            "on a.id = ar.aid " +
            "join role r " +
            "on ar.rid = r.id " +
            "WHERE a.id = #{Aid}")
    List<Role> getRoleByAid(int Aid);

    @Update("update role set name = #{name},name_zh = #{name_zh} " +
            "where id = #{id}")
    void updateRole(Role role);

    @Insert("insert into role (name,name_zh) values (#{name},#{name_zh})")
    void addRole(Role role);
    @Delete("delete from role where id = #{id}")
    void deleteRole(Role role);
}
