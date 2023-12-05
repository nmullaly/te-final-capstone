package com.techelevator.model;

public class Profile {

    private int profileId;
    private String username;
    private String bio;
    private String favoriteFilm;
    private String favoriteSnack;

    public Profile() {}

    public Profile(int id, String username, String bio,
                   String favoriteFilm, String favoriteSnack) {
        this.profileId = id;
        this.username = username;
        this.bio = bio;
        this.favoriteFilm = favoriteFilm;
        this.favoriteSnack = favoriteSnack;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int id) {
        this.profileId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFavoriteFilm() {
        return favoriteFilm;
    }

    public void setFavoriteFilm(String favoriteFilm) {
        this.favoriteFilm = favoriteFilm;
    }

    public String getFavoriteSnack() {
        return favoriteSnack;
    }

    public void setFavoriteSnack(String favoriteSnack) {
        this.favoriteSnack = favoriteSnack;
    }
}
