package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Transient;

import java.util.Date;
import java.util.List;

public class MovieReview {
    private int id;
    private int movieID;
    private int fatherID;
    private int userIDF;
    private String userNameT;
    private String userNameF;
    private int userIDT;
    private String review;
    private int state;
    @JsonFormat(pattern ="yyyy-MM-dd",timezone = "GMT+8")
    private Date time;

    @Transient
    private List<MovieReview> children;
    private int likeCount;

    public int getLikeCount() {
        return likeCount;
    }

    public MovieReview setLikeCount(int likeCount) {
        this.likeCount = likeCount;
        return this;
    }

    public int getId() {
        return id;
    }

    public int getState() {
        return state;
    }

    public MovieReview setState(int state) {
        this.state = state;
        return this;
    }

    public String getUserNameT() {
        return userNameT;
    }

    public MovieReview setUserNameT(String userNameT) {
        this.userNameT = userNameT;
        return this;
    }

    public String getUserNameF() {
        return userNameF;
    }

    public MovieReview setUserNameF(String userNameF) {
        this.userNameF = userNameF;
        return this;
    }

    public int getFatherID() {
        return fatherID;
    }

    public MovieReview setFatherID(int fatherID) {
        this.fatherID = fatherID;
        return this;
    }

    public MovieReview setId(int id) {
        this.id = id;
        return this;
    }

    public int getMovieID() {
        return movieID;
    }

    public MovieReview setMovieID(int movieID) {
        this.movieID = movieID;
        return this;
    }

    public int getUserIDF() {
        return userIDF;
    }

    public MovieReview setUserIDF(int userIDF) {
        this.userIDF = userIDF;
        return this;
    }

    public int getUserIDT() {
        return userIDT;
    }

    public MovieReview setUserIDT(int userIDT) {
        this.userIDT = userIDT;
        return this;
    }

    public String getReview() {
        return review;
    }

    public MovieReview setReview(String review) {
        this.review = review;
        return this;
    }


    public Date getTime() {
        return time;
    }

    public MovieReview setTime(Date time) {
        this.time = time;
        return this;
    }

    public List<MovieReview> getChildren() {
        return children;
    }

    public MovieReview setChildren(List<MovieReview> children) {
        this.children = children;
        return this;
    }

    @Override
    public String toString() {
        return "MovieReview{" +
                "id=" + id +
                ", movieID=" + movieID +
                ", fatherID=" + fatherID +
                ", userIDF=" + userIDF +
                ", userNameT='" + userNameT + '\'' +
                ", userNameF='" + userNameF + '\'' +
                ", userIDT=" + userIDT +
                ", review='" + review + '\'' +
                ", state=" + state +
                ", time=" + time +
                ", children=" + children +
                '}';
    }
}
