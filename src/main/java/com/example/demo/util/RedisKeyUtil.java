package com.example.demo.util;

public class RedisKeyUtil {
    //保存Review点赞数据的key
    public static final String REVIEW_LIKE_KEY = "reviewLike:";
    //保存Article点赞数据的key
    public static final String ARTICLE_LIKE_KEY = "articleLike:";
    //
    public static final String MOVIE_HOT = "MHOT";
    public static final String ARTICLE_HOT = "AHOT";

    public static String getReviewLikeKey(int reviewID){
        StringBuilder builder = new StringBuilder();
        builder.append(REVIEW_LIKE_KEY);
        builder.append(":");
        builder.append(reviewID);
        return builder.toString();
    }

}
