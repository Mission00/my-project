package com.example.demo.controller;

import com.example.demo.pojo.movie;
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
public class SearchController {
    @Autowired
    MovieService movieService;
    @GetMapping(value = "/api/search")
    @ResponseBody
    public List<movie> getDetails(@RequestParam("searchMesg")String searchMesg)
    {
        return movieService.searchMovieByName(searchMesg);
    }
}
