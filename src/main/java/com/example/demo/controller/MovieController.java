package com.example.demo.controller;

import com.example.demo.pojo.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
@CrossOrigin
@Controller
public class MovieController {
    @Autowired
    MovieService movieService;
    @GetMapping(value = "/api/movies")
    @ResponseBody
    public List<Movie> listMovies(@RequestParam("Category")String Category)
    {
        List<Movie> list = null;
        if(!Category.equals("全部"))
        {
            list = movieService.selectMovieByCategory(Category);
        }
        else
        {
            list = movieService.selectAllMovie();
        }
        return list;
    }
}
