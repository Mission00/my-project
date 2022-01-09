package com.example.demo.dao;

import com.example.demo.pojo.Category;
import com.example.demo.pojo.Language;
import com.example.demo.pojo.Tag;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryDao {

    @Select("SELECT * FROM category")
    List<Category> getCategory();

    @Select("SELECT * FROM category where id = #{id}")
    Category getCategoryById(int id);

    @Delete("delete from category where id = #{id}")
    void deleteCategory(int id);

    @Insert("insert into category (category) values (#{category})")
    void insertCategory(String category);

    @Update("update category set category = #{category} where id= #{id}")
    void updateCategory(Category category);

    @Select("select count(1) from movie where category = #{id}")
    int isUsed(int id);
}
