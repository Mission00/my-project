package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Transient;

import java.util.Date;
import java.util.List;
@ToString
@Data
public class Review {

    private int id;
    private int itemID;
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
    private List<Review> children;
    private int likeCount;
    private int type;


}
