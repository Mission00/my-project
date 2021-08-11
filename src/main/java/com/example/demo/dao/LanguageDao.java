package com.example.demo.dao;

import com.example.demo.pojo.Category;
import com.example.demo.pojo.Language;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LanguageDao {

    @Select("SELECT * FROM language")
    List<Language> getLanguage();

    @Select("SELECT * FROM language where id = #{id}")
    Language getLanguageById(int id);
}
