package com.example.demo.dao;



import com.example.demo.pojo.Indexmovie;
import com.example.demo.pojo.Movie;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
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
    Movie selectMovieById(int movieid);

    @Select("SELECT * FROM movie WHERE category=#{Category}")
    @Results({
            @Result(id = true,column = "movie_id",property = "movie_id"),
            @Result(column = "name1",property = "name1"),
            @Result(column = "name2",property = "name2"),
            @Result(column = "movie_id",property = "tagList",many = @Many(select = "com.example.demo.dao.TagDao.getTagByMovieId",fetchType = FetchType.LAZY))
    })
    List<Movie> selectMovieByCategory(String Category);

    @Select("SELECT * FROM movie")
    List<Movie> selectAllMovie();

    @Select("SELECT * FROM movie WHERE name1 LIKE concat('%',#{searchMesg},'%') or name2 LIKE concat('%',#{searchMesg},'%')")
    List<Movie> searchMovieByName(String searchMesg);
}
