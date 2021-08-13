package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = {"handler"})
public class Movie {
    private int movie_id;
    private String name1;
    private String name2;
    private String director;
    private String screenwriter;
    private String actot;
    private List<Tag> tagList;
    private String type;
    private String country;
    private Language language;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date premiere;
    private int num;
    private int movie_length;
    private String introduction;
    private Category category;
    private String img_src;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date posttime;


    public Date getPremiere() {
        return premiere;
    }

    public void setPremiere(Date premiere) {
        this.premiere = premiere;
    }

    public Date getPosttime() {
        return posttime;
    }

    public void setPosttime(Date posttime) {
        this.posttime = posttime;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScreenwriter() {
        return screenwriter;
    }

    public void setScreenwriter(String screenwriter) {
        this.screenwriter = screenwriter;
    }

    public String getActot() {
        return actot;
    }

    public void setActot(String actot) {
        this.actot = actot;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMovie_length() {
        return movie_length;
    }

    public void setMovie_length(int movie_length) {
        this.movie_length = movie_length;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                ", director='" + director + '\'' +
                ", screenwriter='" + screenwriter + '\'' +
                ", actot='" + actot + '\'' +
                ", tagList=" + tagList +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                ", language=" + language +
                ", premiere=" + premiere +
                ", num=" + num +
                ", movie_length=" + movie_length +
                ", introduction='" + introduction + '\'' +
                ", category=" + category +
                ", img_src='" + img_src + '\'' +
                ", posttime=" + posttime +
                '}';
    }
}
