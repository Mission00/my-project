package com.example.demo.service;

import com.example.demo.dao.MovieDao;
import com.example.demo.pojo.Movie;
import com.example.demo.pojo.User;
import com.example.demo.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieDao movieDao;

    @Autowired
    private RedisTemplate redisTemplate;

    public List<Movie> selectMovieByCategory (int Category,int star)
    {
        List<Movie> list=null;
        list = movieDao.selectMovieByCategory(Category,star);
        return list;
    }

    public List<Movie> getNewMovies ()
    {
        List<Movie> list=null;
        list = movieDao.getNewMovies();
        return list;
    }

    public List<Movie> selectAllMovie (int star)
    {
        return movieDao.selectAllMovie(star);
    }

    public Movie selectMovieByID (int movieid)
    {
        redisTemplate.opsForZSet().incrementScore(RedisKeyUtil.MOVIE_HOT,movieid,1);
        return movieDao.selectMovieById(movieid);
    }
    public Movie getMovieByID (int movieid)
    {
        //redisTemplate.opsForZSet().incrementScore(RedisKeyUtil.MOVIE_HOT,movieid,1);
        return movieDao.selectMovieById(movieid);
    }

    public List<Movie> searchMovieByName (String searchMesg)
    {
        return movieDao.searchMovieBySearchMsg(searchMesg);
    }

    public int getTotal(String searchMsg){
        return movieDao.getTotal(searchMsg);
    }

    public List<Movie> selectMovie(int pageSize, int currentPage,
                                   String searchMsg,
                                   String searchType,
                                   int language_id,
                                   int category_id) {
        List<Movie> movieList = null;

        System.out.println("test:"+pageSize+currentPage+searchMsg);
        movieList = movieDao.selectMovie(pageSize,(currentPage-1)*pageSize,searchMsg,searchType,language_id,category_id);
        return movieList;
    }

    public void insertMovie(Movie movie){
        movieDao.insertMovie(movie);
    }

    public void updateMovie(Movie movie){
        movieDao.updateMovie(movie);
    }

    public void deleteMovie(int movie_id){
        movieDao.deleteMovie(movie_id);
    }
}
