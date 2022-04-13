package com.example.demo.service;

import com.example.demo.dao.ArticleDao;
import com.example.demo.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleDao articleDao;

    public void saveArticle(Article article){
        articleDao.saveArticle(article);
    }

    public List<Article> getArticleList(int type){
        return articleDao.getArticleList(type);
    }

    public List<Article> getArticleByTypeAndState(int type,int state,int star){
        return articleDao.getArticleByTypeAndState(type,state,star);
    }

    public void deleteArticleById(int id){
        articleDao.deleteArticleByID(id);
    }

    public void passArticleById(int id){
        articleDao.passArticleByID(id);
    }

    public Article getArticleById(int id){
        return articleDao.getArticleById(id);
    }
}
