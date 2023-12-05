package com.techelevator.controller;

import com.techelevator.dao.ProfileDao;
import com.techelevator.model.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ProfileController {

    private ProfileDao profileDao;

    public ProfileController(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @RequestMapping(path = "/profiles", method = RequestMethod.GET)
    public List<Profile> getProfiles() {
        return profileDao.getProfiles();
    }

    @RequestMapping(path = "/profiles/id={id}", method = RequestMethod.GET)
    public Profile getProfileById(@PathVariable int id) {
        Profile profile = profileDao.getProfileById(id);
        if (profile == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        } else {
            return profile;
        }
    }

    @RequestMapping(path = "/profiles/{name}", method = RequestMethod.GET)
    public Profile getProfileByUsername(@PathVariable String name) {
        Profile profile = profileDao.getProfileByUsername(name);
        if (profile == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        } else {
            return profile;
        }
    }

}
