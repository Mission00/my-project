package com.example.demo.controller;

import com.example.demo.pojo.Indexmovie;
import com.example.demo.service.IndexMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexMovieController
{
    @Autowired
    private IndexMovieService indexMovieService;
    @CrossOrigin
    @GetMapping(value = "/api/index")
    @ResponseBody
    public List<Indexmovie> getIndexMovies()
    {

        List<Indexmovie> list = null;
        list= indexMovieService.selectIndexMovie();
        return list;
    }
}
