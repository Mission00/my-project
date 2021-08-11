package com.example.demo.dao;

import com.example.demo.pojo.Category;
import com.example.demo.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryDao {

    @Select("SELECT * FROM category")
    List<Category> getCategory();

    @Select("SELECT * FROM category where id = #{id}")
    Category getCategoryById(int id);
}
