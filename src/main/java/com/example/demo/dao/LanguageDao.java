package com.example.demo.dao;

import com.example.demo.pojo.Language;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LanguageDao {

    @Select("SELECT * FROM language")
    List<Language> getLanguage();

    @Select("SELECT * FROM language where id = #{id}")
    Language getLanguageById(int id);

    @Delete("delete from language where id = #{id}")
    void deleteLanguage(int id);

    @Insert("insert into language language= #{language}")
    void insertLanguage(String language);

    @Update("update language set language = #{language} where id= #{id}")
    void updateLanguage(Language language);

    @Select("select count(1) from movie where language = #{id}")
    int isUsed(int id);
}
