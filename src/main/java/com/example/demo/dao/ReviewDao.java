package com.example.demo.dao;

import com.example.demo.pojo.Review;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface ReviewDao {


    @Insert("insert into review (itemID,fatherID,userIDF,userIDT,review,time,state,userNameF,userNameT,type) " +
            "values(#{itemID},#{fatherID},#{userIDF},#{userIDT},#{review},#{time},#{state},#{userNameF},#{userNameT},#{type})")
    void addReviewByType(Review movieReview);


    @Select("select * from review where fatherID = 0 and itemID = #{id} and type=#{type}")
    List<Review> getReviewListByIdAndType(@Param("id")int id, @Param("type")int type);

    @Select("select * from review where fatherID = #{fatherID}")
    List<Review> getReviewListByFatherID(@Param("fatherID") int fatherID);
}
