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
            "#{articleAbstract},#{articleCover},#{articleDate},#{state},#{authorName},#{authorID},#{movieID},#{type})")
    void saveArticle(Article article);

    @Select("select * from article where state=1 and type=#{type}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "articleTitle",column = "article_title"),
            @Result(property = "articleContentMd",column = "article_content_md"),
            @Result(property = "articleContentHtml",column = "article_content_html"),
            @Result(property = "articleAbstract",column = "article_abstract"),
            @Result(property = "articleCover",column = "article_cover"),
            @Result(property = "articleDate",column = "article_date")
    })
    List<Article> getArticleList(int type);


    @Select("select * from article where state=#{state} and type=#{type} limit #{star},10")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "articleTitle",column = "article_title"),
            @Result(property = "articleContentMd",column = "article_content_md"),
            @Result(property = "articleContentHtml",column = "article_content_html"),
            @Result(property = "articleAbstract",column = "article_abstract"),
            @Result(property = "articleCover",column = "article_cover"),
            @Result(property = "articleDate",column = "article_date")
    })
    List<Article> getArticleByTypeAndState(int type,int state,int star);


    @Delete("delete from article where id = #{id}")
    void deleteArticleByID(int id);

    @Select("select * from article where authorID = #{id} limit #{star},8")
    @ResultMap("articleMap")
    List<Article> getArticleByAuthorID(int id,int star);

    @Update("update article set state=1 where id = #{id}")
    void passArticleByID(int id);


    @Select("select * from article where id=#{id}")
    @Results(id="articleMap",value={
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
