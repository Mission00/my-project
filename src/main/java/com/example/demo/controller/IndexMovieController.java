package com.example.demo.controller;

import com.example.demo.pojo.Indexmovie;
import com.example.demo.pojo.Movie;
import com.example.demo.service.IndexMovieService;
import com.example.demo.service.MovieService;
import com.example.demo.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Controller
public class IndexMovieController
{
    @Autowired
    private IndexMovieService indexMovieService;
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    MovieService movieService;

    @CrossOrigin
    @GetMapping(value = "/api/index")
    @ResponseBody
    public List<Indexmovie> getIndexMovies()
    {

        List<Indexmovie> list = null;
        list= indexMovieService.selectIndexMovie();
        return list;
    }

    @CrossOrigin
    @GetMapping(value = "/api/getHotMovies")
    @ResponseBody
    public List<Movie> getHotMovies()
    {
        Set<Integer> set = redisTemplate.opsForZSet().reverseRange(RedisKeyUtil.MOVIE_HOT, 0, 10);
        List<Movie> list = new ArrayList<>();
        Iterator iterator = set.iterator();
        int count=0;
        while(iterator.hasNext()){
            int id = (int)iterator.next();
            Movie m = movieService.getMovieByID(id);
            list.add(m);
            count++;
            if(count==8){
                break;
            }
        }
        return list;
    }

    @CrossOrigin
    @GetMapping(value = "/api/getNewMovies")
    @ResponseBody
    public List<Movie> getNewMovies()
    {
        return movieService.getNewMovies();
    }
}
