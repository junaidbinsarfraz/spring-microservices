package com.movie.ratingdataservice.models;

public class Rating {

    private Integer rating;
    private String movieId;

    public Rating() {

    }

    public Rating(Integer rating, String movieId) {
        this.rating = rating;
        this.movieId = movieId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
