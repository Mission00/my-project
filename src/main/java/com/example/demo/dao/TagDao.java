package com.example.demo.dao;

import com.example.demo.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TagDao {

    @Select("select t.* from movie m left join movie_tag mt on m.movie_id = mt.movie_id join tag t on mt.tag_id = t.tag_id WHERE m.movie_id = #{id}")
    List<Tag> getTagByMovieId(int id);
}
