package com.example.demo.dao;



import com.example.demo.pojo.indexmovie;
import com.example.demo.pojo.movie;
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
    List<indexmovie> selectIndexMovie();

    @Select("SELECT * FROM movie WHERE movie_id=#{movieid}")
    movie selectMovieById(int movieid);

    @Select("SELECT * FROM movie WHERE category=#{Category}")
    List<movie> selectMovieByCategory(String Category);

    @Select("SELECT * FROM movie")
    List<movie> selectAllMovie();

    @Select("SELECT * FROM movie WHERE name1 LIKE concat('%',#{searchMesg},'%') or name2 LIKE concat('%',#{searchMesg},'%')")
    List<movie> searchMovieByName(String searchMesg);
}
