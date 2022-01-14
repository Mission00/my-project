package com.example.demo.dao;

import com.example.demo.pojo.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleDao {
    @Insert("insert into article" +
            "(article_title,article_content_html,article_content_md," +
            "article_abstract,article_cover,article_date,state,authorName,authorID,movieID,type)" +
            "values(#{articleTitle},#{articleContentHtml},#{articleContentMd}," +
            "#{articleAbstract},#{articleCover},#{articleDate},#{state},#{authorName},#{authorID},#{movieID},0)")
    void saveArticle(Article article);

    @Select("select * from article where state>0")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "articleTitle",column = "article_title"),
            @Result(property = "articleContentMd",column = "article_content_md"),
            @Result(property = "articleContentHtml",column = "article_content_html"),
            @Result(property = "articleAbstract",column = "article_abstract"),
            @Result(property = "articleCover",column = "article_cover"),
            @Result(property = "articleDate",column = "article_date")
    })
    List<Article> getArticleList();


    @Select("select * from article where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "articleTitle",column = "article_title"),
            @Result(property = "articleContentMd",column = "article_content_md"),
            @Result(property = "articleContentHtml",column = "article_content_html"),
            @Result(property = "articleAbstract",column = "article_abstract"),
            @Result(property = "articleCover",column = "article_cover"),
            @Result(property = "articleDate",column = "article_date")
    })
    Article getArticleById(@Param("id") int id);
}
