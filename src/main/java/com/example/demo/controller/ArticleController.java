package com.example.demo.controller;

import com.example.demo.pojo.Article;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;


@CrossOrigin
@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping(value = "api/savearticle")
    @ResponseBody
    public void saveArticle(@RequestBody Article  article){
        article.setArticleDate(new Date());
        articleService.saveArticle(article);
    }


    @PostMapping(value = "api/articleList")
    @ResponseBody
    public List<Article> getArticleList(){
        return articleService.getArticleList();
    }

    @CrossOrigin
    @GetMapping(value = "api/getArticle")
    @ResponseBody
    public Article getArticle(@RequestParam("id") int id){
        return articleService.getArticleById(id);
    }
}
