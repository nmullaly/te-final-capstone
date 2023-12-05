package com.techelevator.dao;

import com.techelevator.model.Profile;
import java.util.List;

public interface ProfileDao {

    List<Profile> getProfiles();
    Profile getProfileById(int profileId);
    Profile getProfileByUsername(String username);
    Profile updateBio(int id, String bio);
    Profile updateFavoriteFilm(int id, String favoriteFilm);
    Profile updateFavoriteSnack(int id, String favoriteSnack);

}
