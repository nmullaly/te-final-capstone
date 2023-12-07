package com.techelevator.dao;

import com.techelevator.model.Profile;
import com.techelevator.exception.DaoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcProfileDao implements ProfileDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcProfileDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Profile> getProfiles() {
        List<Profile> profiles = new ArrayList<>();
        String sql = "SELECT * FROM profiles;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Profile profile = mapRowToProfile(results);
                profiles.add(profile);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return profiles;
    }

    @Override
    public Profile getProfileById(int profileId) {
        Profile profile = null;
        String sql = "SELECT * FROM profiles WHERE profile_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, profileId);
            if (results.next()) {
                profile = mapRowToProfile(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server", e);
        }
        return profile;
    }

    @Override
    public Profile getProfileByUsername(String username) {
        Profile profile = null;
        String sql = "SELECT * FROM profiles WHERE username ILIKE ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
            if(results.next()) {
                profile = mapRowToProfile(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return profile;
    }

    @Override
    public Profile updateProfile(Profile profile) {
        Profile updatedProfile = null;
        String sql = "UPDATE profiles SET username = ?, points = ?, bio = ?, favorite_film = ?, favorite_snack = ?, favorite_genres = ? " +
                "WHERE profile_id = ?;";

        try {
            int numberOfRows = jdbcTemplate.update(sql, profile.getUsername(), profile.getPoints(), profile.getBio(), profile.getFavoriteFilm(),
                    profile.getFavoriteSnack(), profile.getFavoriteGenres(), profile.getProfileId());
            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected one");
            } else {
                updatedProfile = getProfileById(profile.getProfileId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return updatedProfile;
    }

    @Override
    public Profile createProfile(Profile profile) {
        Profile returnedProfile = null;
        String sql = "INSERT INTO profiles (username, bio, favorite_film, favorite_snack, favorite_genres) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING profile_id;";

        try {
            int newProfileId = jdbcTemplate.queryForObject(sql, int.class, profile.getUsername(), profile.getBio(),
                    profile.getFavoriteFilm(), profile.getFavoriteSnack(), profile.getFavoriteGenres());
            returnedProfile = getProfileById(newProfileId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        } catch (NullPointerException e) {
            throw new DaoException("Transfer Unsuccessful", e);
        }

        return returnedProfile;
    }

    private Profile mapRowToProfile(SqlRowSet rs) {
        Profile profile = new Profile();
        profile.setProfileId(rs.getInt("profile_id"));
        profile.setUsername(rs.getString("username"));
        if (rs.getString("bio") != null) {
            profile.setBio(rs.getString("bio"));
        } else {
            profile.setBio(null);
        }
        if (rs.getString("favorite_film") != null) {
            profile.setFavoriteFilm(rs.getString("favorite_film"));
        } else {
            profile.setFavoriteFilm(null);
        }
        if (rs.getString("favorite_snack") != null) {
            profile.setFavoriteSnack(rs.getString("favorite_snack"));
        } else {
            profile.setFavoriteSnack(null);
        }
        if (rs.getString("favorite_genres") != null) {
            profile.setFavoriteGenres(rs.getString("favorite_genres"));
        } else {
            profile.setFavoriteGenres(null);
        }
        profile.setAvatarId(rs.getInt("avatar_id"));
        return profile;
    }


}
