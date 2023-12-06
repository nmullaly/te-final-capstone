package com.techelevator.controller;

import com.techelevator.dao.ProfileDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class ProfileController {

    private ProfileDao profileDao;

    public ProfileController(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @RequestMapping(path = "/profiles", method = RequestMethod.GET)
    public List<Profile> getProfiles() {
        return profileDao.getProfiles();
    }

    @RequestMapping(path = "/profiles/{id}", method = RequestMethod.GET)
    public Profile getProfileById(@PathVariable int id) {
        Profile profile = profileDao.getProfileById(id);
        if (profile == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        } else {
            return profile;
        }
    }

    // getProfileByUsername - going by id is preferable, but I'm keeping this in case we change our mind
//    @RequestMapping(path = "/profiles/{name}", method = RequestMethod.GET)
//    public Profile getProfileByUsername(@PathVariable String name) {
//        Profile profile = profileDao.getProfileByUsername(name);
//        if (profile == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
//        } else {
//            return profile;
//        }
//    }

    @RequestMapping(path = "/profiles/{id}", method = RequestMethod.PUT)
    public Profile updateProfile(@RequestBody int id, @RequestBody Profile profile) {
        if (id != profile.getProfileId()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Resource id does not match url.");
        }
        profile.setProfileId(id);
        try {
            Profile updatedProfile = profileDao.updateProfile(profile);
            return updatedProfile;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Request not found.");
        }
    }

//    @ResponseStatus(HttpStatus.CREATED)
//    @RequestMapping(path = "/register", method = RequestMethod.POST)
//    public Profile createProfile(@RequestBody Profile profile) {
//        Profile returnedProfile = profileDao.createProfile(profile);
//        return returnedProfile;
//    }

}
