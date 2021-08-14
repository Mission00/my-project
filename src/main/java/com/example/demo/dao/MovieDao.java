package com.example.demo.dao;



import com.example.demo.pojo.Indexmovie;
import com.example.demo.pojo.Movie;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MovieDao {
    @Select("SELECT * FROM `index`")
    @Results({
            @Result(id = true,column = "index_id",property = "indexid"),
            @Result(column = "img_src",property = "src"),
            @Result(column = "movie_id",property = "movieid"),
            @Result(column = "name1",property = "name1"),
            @Result(column = "name2",property = "name2"),
    })
    List<Indexmovie> selectIndexMovie();

    @Select("SELECT * FROM movie WHERE movie_id=#{movieid}")
    @Results({
            @Result(id = true,column = "movie_id",property = "movie_id"),
            @Result(column = "movie_id",property = "tagList",
                    many = @Many(select = "com.example.demo.dao.TagDao.getTagByMovieId",fetchType = FetchType.LAZY))
    })
    Movie selectMovieById(int movieid);

    @Select("SELECT * FROM movie WHERE category=#{Category}")
    @Results({
            @Result(id = true,column = "movie_id",property = "movie_id"),
            @Result(column = "name1",property = "name1"),
            @Result(column = "name2",property = "name2"),
            @Result(column = "movie_id",property = "tagList",
                    many = @Many(select = "com.example.demo.dao.TagDao.getTagByMovieId",fetchType = FetchType.LAZY))
    })
    List<Movie> selectMovieByCategory(String Category);

    @Select("SELECT * FROM movie")
    @Results({
            @Result(id = true,column = "movie_id",property = "movie_id"),
            @Result(column = "movie_id",property = "tagList",
                    many = @Many(select = "com.example.demo.dao.TagDao.getTagByMovieId",fetchType = FetchType.LAZY))
    })
    List<Movie> selectAllMovie();

    @Select("select * from movie WHERE name1 LIKE concat('%',#{searchMsg},'%') or name2 LIKE concat('%',#{searchMsg},'%')")
    List<Movie> searchMovieBySearchMsg(String SearchMsg);

//    @Select("<script>"
//            +"select * from movie"
//            +"<if test='searchMsg!=null'>"
//            +"WHERE name1 LIKE concat('%',#{searchMsg},'%') or name2 LIKE concat('%',#{searchMsg},'%')"
//            +"</if>"
//            +"limit #{star},#{pageSize}"
//            +"</script>")

    @Select("<script>"
            +"SELECT * FROM movie "
            +"where 1=1"
            +"<if test='searchMsg!=null'>"
            +"and ${searchType} LIKE concat('%',#{searchMsg},'%')"
            +"</if>" +
            "<if test='language_id!=-1'>" +
            "and language=#{language_id}" +
            "</if>"+
            "<if test='category_id!=-1'>" +
            "and category=#{category_id}" +
            "</if>"
            +"limit #{star},#{pageSize}"
            +"</script>")
    @Results({
            @Result(id = true,column = "movie_id",property = "movie_id"),
            @Result(column = "language" ,property = "language",
                    one = @One(select = "com.example.demo.dao.LanguageDao.getLanguageById",fetchType = FetchType.LAZY)),
            @Result(column = "category" ,property = "category",
                    one = @One(select = "com.example.demo.dao.CategoryDao.getCategoryById",fetchType = FetchType.LAZY)),
            @Result(column = "movie_id",property = "tagList",
                    many = @Many(select = "com.example.demo.dao.TagDao.getTagByMovieId",fetchType = FetchType.LAZY))
    })
    List<Movie> selectMovie(int pageSize,int star,@Param("searchMsg")String searchMsg,
                            @Param("searchType")String searchType,
                            @Param("language_id")int language_id,
                            @Param("category_id")int category_id);


    @Select("<script>"
            +"select count(1) from movie"
            +"<if test='searchMsg!=null'>"
            +"WHERE name1 LIKE concat('%',#{searchMsg},'%') or name2 LIKE concat('%',#{searchMsg},'%')"
            +"</if>"
            +"</script>")
    int getTotal(@Param("searchMsg")String searchMsg);

    @Insert("insert into movie (name1,name2,director,screenwriter,actot,type,country,language,premiere,num,movie_length,introduction,category,posttime,img_src) " +
            "values (#{name1},#{name2},#{director},#{screenwriter},#{actot},#{type},#{country},#{language.id}" +
            ",#{premiere},#{num},#{movie_length},#{introduction},#{category.id},#{posttime},#{img_src})")
    void insertMovie(Movie movie);

    @Update("UPDATE movie set name1=#{name1},director=#{director},screenwriter=#{screenwriter}," +
            "actot=#{actot},type=#{type},country=#{country},language=#{language.id}," +
            "premiere=#{premiere},num=#{num},movie_length=#{movie_length},introduction=#{introduction}," +
            "category=#{category.id},posttime=#{posttime},img_src=#{img_src} " +
            "where movie_id = #{movie_id}")
    void updateMovie(Movie movie);

    @Delete("delete from movie where movie_id = #{movie_id}")
    void deleteMovie(int movie_id);
}
