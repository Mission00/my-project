package com.example.demo.controller;

import com.example.demo.pojo.MovieReview;
import com.example.demo.service.MovieReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class MovieReviewController {


    @Autowired
    MovieReviewService movieReviewService;

    @PostMapping(value = "/api/addMovieReview")
    @ResponseBody
    public void addMovieReview(@RequestBody MovieReview movieReview){

        movieReview.setTime(new Date());
        System.out.println(movieReview);
        movieReviewService.addMovieReviewService(movieReview);
    }

    @GetMapping(value = "/api/getMovieReviewList")
    @ResponseBody
    public List<MovieReview> getMovieReviewList(@RequestParam("movieID") int movieID){
        System.out.println(">>>>>>>>>>>>>>"+movieID);
        return movieReviewService.getReviewList(movieID);
    }
}
