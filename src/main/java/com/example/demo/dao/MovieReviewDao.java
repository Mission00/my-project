package com.example.demo.dao;

import com.example.demo.pojo.MovieReview;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface MovieReviewDao {


    @Insert("insert into movie_review (movieID,fatherID,userIDF,userIDT,review,time,state,userNameF,userNameT) " +
            "values(#{movieID},#{fatherID},#{userIDF},#{userIDT},#{review},#{time},#{state},#{userNameF},#{userNameT})")
    void addMovieReviewDao(MovieReview movieReview);


    @Select("select * from movie_review where fatherID = 0 and movieID = #{movieID}")
    List<MovieReview> getReviewListByMovieID(int MovieID);

    @Select("select * from movie_review where fatherID = #{fatherID}")
    List<MovieReview> getReviewListByFatherID(@Param("fatherID") int fatherID);
}
