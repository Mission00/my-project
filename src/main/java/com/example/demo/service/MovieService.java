package com.example.demo.service;

import com.example.demo.dao.MovieDao;
import com.example.demo.pojo.Movie;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieDao movieDao;

    public List<Movie> selectMovieByCategory (String Category)
    {
        List<Movie> list=null;
        list = movieDao.selectMovieByCategory(Category);
        return list;
    }

    public List<Movie> selectAllMovie ()
    {
        return movieDao.selectAllMovie();
    }

    public Movie selectMovieByID (int movieid)
    {
        return movieDao.selectMovieById(movieid);
    }

    public List<Movie> searchMovieByName (String searchMesg)
    {
        return movieDao.searchMovieBySearchMsg(searchMesg);
    }

    public int getTotal(String searchMsg){
        return movieDao.getTotal(searchMsg);
    }

    public List<Movie> selectMovie(int pageSize, int currentPage, String searchMsg)
    {
        List<Movie> movieList = null;

        System.out.println("test:"+pageSize+currentPage+searchMsg);
        movieList = movieDao.selectMovie(pageSize,(currentPage-1)*pageSize,searchMsg);
        return movieList;
    }

}
