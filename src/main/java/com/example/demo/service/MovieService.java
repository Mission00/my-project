package com.example.demo.service;

import com.example.demo.dao.MovieDao;
import com.example.demo.pojo.movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieDao movieDao;

    public List<movie> selectMovieByCategory (String Category)
    {
        List<movie> list=null;
        list = movieDao.selectMovieByCategory(Category);
        return list;
    }

    public List<movie> selectAllMovie ()
    {
        return movieDao.selectAllMovie();
    }

    public movie selectMovieByID (int movieid)
    {
        return movieDao.selectMovieById(movieid);
    }

    public List<movie> searchMovieByName (String searchMesg)
    {
        return movieDao.searchMovieByName(searchMesg);
    }

}
