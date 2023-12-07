package com.techelevator.model;

public class WatchlistItem {

    private int profileId;
    private int movieId;

    public WatchlistItem() {};

    public WatchlistItem(int profileId, int movieId) {
        this.profileId = profileId;
        this.movieId = movieId;
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
}
