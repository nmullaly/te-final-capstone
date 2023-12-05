package com.techelevator.dao;

import com.techelevator.model.Profile;

public interface ProfileDao {

    Profile getProfileById(int profileId);
    Profile getProfileByUsername(String username);
    Profile updateBio(int id, String bio);
    Profile updateFavoriteFilm(int id, String favoriteFilm);
    Profile updateFavoriteSnack(int id, String favoriteSnack);

}
