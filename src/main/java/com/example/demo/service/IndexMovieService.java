package com.example.demo.service;

import com.example.demo.dao.MovieDao;
import com.example.demo.pojo.Indexmovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexMovieService {
    @Autowired
    private MovieDao movieDao;

    public List<Indexmovie> selectIndexMovie()
    {
        List<Indexmovie> list = null;
        list=movieDao.selectIndexMovie();
        return list;
    }
}
