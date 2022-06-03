package com.movie.ratingdataservice.models;

import java.util.List;

public class UserRating {

    private List<Rating> ratings;
    private String userId;

    public UserRating(){

    }

    public UserRating(List<Rating> ratings, String userId) {
        this.ratings = ratings;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
