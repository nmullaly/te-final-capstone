package com.techelevator.model;

public class Review {

    private int reviewId;
    private int profileId;
    private int movieId;
    private String body;
    private int rating;

    public Review() {};

    public Review(int reviewId, int profileId, int movieId, String body, int rating) {
        this.reviewId = reviewId;
        this.profileId = profileId;
        this.movieId = movieId;
        this.body = body;
        this.rating = rating;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
