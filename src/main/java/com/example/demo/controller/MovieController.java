package com.example.demo.controller;

import com.example.demo.pojo.Movie;
import com.example.demo.pojo.User;
import com.example.demo.result.Result;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@CrossOrigin
@Controller
public class MovieController {
    @Autowired
    MovieService movieService;

    @Autowired
    RedisTemplate redisTemplate;
    @GetMapping(value = "/api/movies")
    @ResponseBody
    public List<Movie> listMovies(@RequestParam("Category")int Category,@RequestParam("currentPage") int currentPage)
    {
        List<Movie> list = null;
        int star = (currentPage-1)*18;
        if(Category!=0)
        {
            list = movieService.selectMovieByCategory(Category,star);
        }
        else
        {
            list = movieService.selectAllMovie(star);
        }
        return list;
    }
//    public List<Movie> listMovies(@RequestParam("Category")String Category)
//    {
//        List<Movie> list = null;
//        if(!Category.equals("全部"))
//        {
//            list = movieService.selectMovieByCategory(Category);
//        }
//        else
//        {
//            list = movieService.selectAllMovie();
//        }
//        return list;
//    }

    @GetMapping(value = "/api/admin/movielist")
    @ResponseBody
    public Result getMovieList(@RequestParam("pageSize") int pageSize
            ,@RequestParam("currentPage") int currentPage
            ,@RequestParam("searchMsg") String searchMsg
            ,@RequestParam("searchType") String searchType
            ,@RequestParam("language") int language_id
            ,@RequestParam("category") int category_id)
    {
        searchType = searchMsg.equals("name")?null:searchType;
        System.out.println(searchType);
        List<Movie> movieList = movieService.selectMovie(pageSize,currentPage,searchMsg,
                searchType,language_id,category_id);
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

    @GetMapping(value = "/api/movielist")
    @ResponseBody
    public Result getMovieList2(@RequestParam("pageSize") int pageSize
            ,@RequestParam("currentPage") int currentPage
            ,@RequestParam("searchMsg") String searchMsg
            ,@RequestParam("searchType") String searchType
            ,@RequestParam("language") int language_id
            ,@RequestParam("category") int category_id)
    {
        System.out.println(searchType);
        searchType = searchMsg.equals("name")?null:searchType;
        System.out.println(searchType);
        List<Movie> movieList = movieService.selectMovie(pageSize,currentPage,searchMsg,
                searchType,language_id,category_id);
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

    @PostMapping(value = "/api/admin/insertmovie")
    @ResponseBody
    public Result insertMovie(@RequestBody Movie movie)
    {

        System.out.println(movie);
        movie.setPosttime(new Date());
        System.out.println(movie.getPosttime());
        try {
            movieService.insertMovie(movie);
        }catch (Exception e){
            Result result = new Result(202);
            result.setData(e.getMessage());
            return result;
        }
        System.out.println(1);
        return new Result(200);
    }

    @PostMapping(value = "/api/admin/updatemovie")
    @ResponseBody
    public Result updateMovie(@RequestBody Movie movie)
    {

        System.out.println(movie);
        movie.setPosttime(new Date());
        System.out.println(movie.getPosttime());
        try {
            movieService.updateMovie(movie);
        }catch (Exception e){
            Result result = new Result(202);
            result.setData(e.getMessage());
            return result;
        }
        System.out.println(1);
        return new Result(200);
    }

    @GetMapping(value = "/api/admin/deleteMovie")
    @ResponseBody
    public Result deleteMovie(@RequestParam("movie_id") int movie_id)
    {

        System.out.println(movie_id);
        try {
            movieService.deleteMovie(movie_id);
        }catch (Exception e){
            Result result = new Result(202);
            result.setData(e.getMessage());
            return result;
        }
        return new Result(200);
    }





}
