package com.example.demo.service;

import com.example.demo.dao.MovieReviewDao;
import com.example.demo.pojo.Movie;
import com.example.demo.pojo.MovieReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieReviewService {

    @Autowired
    MovieReviewDao movieReviewDao;
    public void addMovieReviewService(MovieReview movieReview){
        movieReviewDao.addMovieReviewDao(movieReview);
    }


    @Transactional
    public List<MovieReview> getReviewList(int movieID){
        List<MovieReview> list = movieReviewDao.getReviewListByMovieID(movieID);
        for(MovieReview movieReview:list){
            movieReview.setChildren(getReviewListByFatherID(movieReview.getId()));
        }
        return list;
    }

    public List<MovieReview> getReviewListByFatherID(int fatherID){
        return movieReviewDao.getReviewListByFatherID(fatherID);
    }
}
