package com.example.demo.controller;

import com.example.demo.pojo.Movie;
import com.example.demo.pojo.User;
import com.example.demo.result.Result;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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


        System.out.println(list.get(0));
        return list;
    }

    @GetMapping(value = "/api/movielist")
    @ResponseBody
    public Result getMovieList(@RequestParam("pageSize") int pageSize
            ,@RequestParam("currentPage") int currentPage
            ,@RequestParam("searchMsg") String searchMsg)
    {
        List<Movie> movieList = movieService.selectMovie(pageSize,currentPage,searchMsg);
        Result result;
        if(movieList == null){
            result = new Result(400);
        }else{
            result = new Result(200);
            result.setData(movieList);
            result.setTotal(movieService.getTotal(searchMsg));
        }
        System.out.println(movieList);
        return result;
    }


}
