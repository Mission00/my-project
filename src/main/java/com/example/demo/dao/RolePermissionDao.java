package com.example.demo.dao;

import com.example.demo.pojo.RolePermission;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RolePermissionDao {

    @Select("<script>" +
            "select * from role_permission where rid in("
            +"<foreach collection='rids' separator=',' item='id'>"
            + "#{id} "
            + "</foreach> "
            +")</script>")
    List<RolePermission> findAllByRid(@Param("rids") List<Integer> rids);

    @Delete("delete from role_permission where rid = #{rid}")
    void deleteRolePermissionByRid(int rid);

    @Select("<script>" +
            "insert into role_permission (rid,pid) values "
            +"<foreach collection='rps' separator=',' item='rp'>"
            + "(#{rp.rid},#{rp.pid} )"
            + "</foreach> "
            +"</script>")
    void insertRolePermissionByRps(@Param("rps") List<RolePermission> rps);
}
