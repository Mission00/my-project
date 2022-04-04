package com.example.demo.dao;

import com.example.demo.pojo.Review;
import org.apache.ibatis.annotations.*;
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

    @Select("select * from review where type=#{type} limit #{star},10")
    List<Review> getAllReview(int star,int type);

    @Select("select * from review where fatherID = #{fatherID}")
    List<Review> getReviewListByFatherID(@Param("fatherID") int fatherID);

    @Delete("delete from review where id=#{id} or fatherId=#{id}")
    int deleteReviewBYId(int id);

    @Update("update review set type=1 where id = #{id}")
    int passReviewById(int id);
}
