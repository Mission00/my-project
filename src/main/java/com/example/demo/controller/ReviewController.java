package com.example.demo.controller;

import com.example.demo.Enum.ReviewType;
import com.example.demo.pojo.Review;
import com.example.demo.service.ReviewService;
import com.example.demo.util.RedisKeyUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@Log4j2
public class ReviewController {


    @Autowired
    ReviewService reviewService;

    @Autowired
    RedisTemplate redisTemplate;

    @PostMapping(value = "/api/addReview")
    @ResponseBody
    public void addMovieReview(@RequestBody Review movieReview){//
        movieReview.setTime(new Date());
        System.out.println(movieReview);
        reviewService.addReview(movieReview);
    }

    //type代表Review的type 0：影片评论 1：文章评论
    @GetMapping(value = "/api/getReviewList")
    @ResponseBody
    public List<Review> getReviewList(@RequestParam("id") int id, @RequestParam("type") int type){
        List<Review> list =  reviewService.getReviewListByID(id,type);
        return list;
    }

    @GetMapping(value = "/api/reviewlike")
    @ResponseBody
    public String reviewLike(@RequestParam("reviewid")int reviewid,@RequestParam("userid")int userid){
        System.out.println(reviewid);
        String result = "";
        try {
            String key = RedisKeyUtil.getReviewLikeKey(reviewid);
            long object = redisTemplate.opsForSet().add(key,userid);
            if(object == 1){
                result = "点赞成功";
            }else{
                result = "重复点赞";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "/api/reviewUnlike")
    @ResponseBody
    public String reviewUnLike(int reviewid,int userid){
        String result = "";
        try {
            String key = RedisKeyUtil.getReviewLikeKey(reviewid);
            long object = redisTemplate.opsForSet().remove(key,userid);
            if(object == 1){
                result = "取消成功";
            }else{
                result = "您已取消";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "/api/reviewlikecount")
    @ResponseBody
    public Map reviewLikeCount(int reviewid,int userid){
        Map map = new HashMap();
        try{
           String key = RedisKeyUtil.getReviewLikeKey(reviewid);
           long count = redisTemplate.opsForSet().size(key);
           boolean isliked = redisTemplate.opsForSet().isMember(key,userid);
           map.put("count",count);
           map.put("isliked",isliked);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }



//    @PostMapping(value = "/api/replyMoviceReview")
//    @ResponseBody
//    public void replyMoviceReview(@RequestBody MovieReview movieReview){
//
//        movieReview.setTime(new Date());
//        System.out.println(movieReview);
////        movieReviewService.addMovieReviewService(movieReview);
//    }
}
