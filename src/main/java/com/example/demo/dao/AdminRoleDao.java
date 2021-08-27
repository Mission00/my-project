package com.example.demo.dao;


import com.example.demo.pojo.AdminRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminRoleDao {
    @Select("select * from admin_role where aid = #{aid}")
    List<AdminRole> findAllByAid(int aid);
    @Delete("delete from admin_role where aid = #{aid}")
    void deleteAllByAid(int aid);
}
