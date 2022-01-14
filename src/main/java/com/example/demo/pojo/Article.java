package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Article {
    private int id;
    private String articleTitle;
    private String articleContentMd;
    private String articleContentHtml;
    private String articleAbstract;
    private String articleCover;
    @JsonFormat(pattern ="yyyy-MM-dd",timezone = "GMT+8")
    private Date articleDate;
    private int state;
    private String authorName;
    private int authorID;
    private int movieID;

    public int getMovieID() {
        return movieID;
    }

    public Article setMovieID(int movieID) {
        this.movieID = movieID;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Article setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public int getAuthorID() {
        return authorID;
    }

    public Article setAuthorID(int authorID) {
        this.authorID = authorID;
        return this;
    }

    public int getId() {
        return id;
    }

    public Article setId(int id) {
        this.id = id;
        return this;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public Article setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
        return this;
    }

    public String getArticleContentMd() {
        return articleContentMd;
    }

    public Article setArticleContentMd(String articleContentMd) {
        this.articleContentMd = articleContentMd;
        return this;
    }

    public String getArticleContentHtml() {
        return articleContentHtml;
    }

    public Article setArticleContentHtml(String articleContentHtml) {
        this.articleContentHtml = articleContentHtml;
        return this;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public Article setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
        return this;
    }

    public String getArticleCover() {
        return articleCover;
    }

    public Article setArticleCover(String articleCover) {
        this.articleCover = articleCover;
        return this;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public Article setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
        return this;
    }

    public int getState() {
        return state;
    }

    public Article setState(int state) {
        this.state = state;
        return this;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContentMd='" + articleContentMd + '\'' +
                ", articleContentHtml='" + articleContentHtml + '\'' +
                ", articleAbstract='" + articleAbstract + '\'' +
                ", articleCover='" + articleCover + '\'' +
                ", articleDate='" + articleDate + '\'' +
                ", state=" + state +
                '}';
    }
}
