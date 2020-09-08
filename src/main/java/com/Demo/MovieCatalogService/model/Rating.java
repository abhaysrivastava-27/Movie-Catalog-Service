package com.Demo.MovieCatalogService.model;

public class Rating {
    int movieId;
    int rating;

    public  Rating(){}
    public Rating(int movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
