package com.example.demo.controller;

import com.example.demo.pojo.Article;
import com.example.demo.service.ArticleService;
import com.example.demo.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
    @Autowired
    RedisTemplate redisTemplate;

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
        redisTemplate.opsForZSet().incrementScore(RedisKeyUtil.ARTICLE_HOT,id,1);
        return articleService.getArticleById(id);
    }
}
