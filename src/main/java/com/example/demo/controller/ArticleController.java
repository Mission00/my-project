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

    @PostMapping(value = "api/admin/savearticle")
    @ResponseBody
    public void saveArticle1(@RequestBody Article  article){
        article.setArticleDate(new Date());
        articleService.saveArticle(article);
    }


    @GetMapping(value = "api/articleList")
    @ResponseBody
    public List<Article> getArticleList(@RequestParam int type){
        return articleService.getArticleList(type);
    }

    @GetMapping(value = "api/admin/articleList")
    @ResponseBody
    public List<Article> getArticleListByTypeAndState(@RequestParam("type") int type,@RequestParam("state") int state,
                                                      @RequestParam("currentPage") int currentPage){
        System.out.println(currentPage);
        int star = (currentPage-1)*10;
        System.out.println(star);
        return articleService.getArticleByTypeAndState(type,state,star);
    }

    @GetMapping(value = "api/admin/passarticle")
    @ResponseBody
    public void passArticleById(int id){
        articleService.passArticleById(id);
    }

    @GetMapping(value = "api/admin/deletearticle")
    @ResponseBody
    public void deleteArticleById(int id){
        articleService.deleteArticleById(id);
    }

    @CrossOrigin
    @GetMapping(value = "api/getArticle")
    @ResponseBody
    public Article getArticle(@RequestParam("id") int id){
        redisTemplate.opsForZSet().incrementScore(RedisKeyUtil.ARTICLE_HOT,id,1);
        return articleService.getArticleById(id);
    }
}
