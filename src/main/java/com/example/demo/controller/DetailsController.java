package com.example.demo.controller;

import com.example.demo.pojo.indexmovie;
import com.example.demo.pojo.movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DetailsController {
    @Autowired
    MovieService movieService;
    @CrossOrigin
    @GetMapping(value = "/api/details")
    @ResponseBody
    public movie getDetails(@RequestParam("movieid")String movieid)
    {
        int id = Integer.parseInt(movieid);
        return movieService.selectMovieByID(id);
    }
}
