package com.example.demo.service;

import com.example.demo.dao.ReviewDao;
import com.example.demo.pojo.Review;
import com.example.demo.util.RedisKeyUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
public class ReviewService {

    @Autowired
    ReviewDao reviewDao;
    @Autowired
    RedisTemplate redisTemplate;
    public void addReview(Review movieReview){
        System.out.println(movieReview);
        reviewDao.addReviewByType(movieReview);
    }


    @Transactional
    public List<Review> getReviewListByID(int id, int type){
        List<Review> list = reviewDao.getReviewListByIdAndType(id,type);
        for(Review movieReview:list){
            long count = redisTemplate.opsForSet().size(RedisKeyUtil.getReviewLikeKey(movieReview.getId()));
            movieReview.setLikeCount((int)count);
            movieReview.setChildren(getReviewListByFatherID(movieReview.getId()));
        }
        return list;
    }

    public List<Review> getReviewListByFatherID(int fatherID){
        return reviewDao.getReviewListByFatherID(fatherID);
    }
}
