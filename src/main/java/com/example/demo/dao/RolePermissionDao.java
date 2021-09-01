package com.example.demo.dao;

import com.example.demo.pojo.Permission;
import com.example.demo.pojo.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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
}
