package com.techelevator.dao;

import com.techelevator.model.Profile;
import java.util.List;

public interface ProfileDao {

    List<Profile> getProfiles();
    Profile getProfileById(int profileId);
    Profile getProfileByUsername(String username);
    Profile updateProfile(Profile profile);
    Profile createProfile(Profile profile);

}
