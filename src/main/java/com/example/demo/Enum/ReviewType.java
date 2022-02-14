package com.example.demo.Enum;


import lombok.Getter;

@Getter
public enum  ReviewType {
    MOVIE_REVIEW(0),
    ARTICLE_REVIEW(1),
    ;


    private final int Review_Type;

    ReviewType(int review_Type) {
        Review_Type = review_Type;
    }
}
