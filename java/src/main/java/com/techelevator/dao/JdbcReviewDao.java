package com.techelevator.dao;

import com.techelevator.model.Review;
import com.techelevator.exception.DaoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewDao implements ReviewDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Review> getReviews() {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Review review = mapRowToReview(results);
                reviews.add(review);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return reviews;
    }

    @Override
    public List<Review> getReviewsByProfile(int profileId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews WHERE profile_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, profileId);
            while (results.next()) {
                Review review = mapRowToReview(results);
                reviews.add(review);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return reviews;
    }

    @Override
    public List<Review> getReviewsByMovie(int movieId) {
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM reviews WHERE movie_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, movieId);
            while (results.next()) {
                Review review = mapRowToReview(results);
                reviews.add(review);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return reviews;
    }

    @Override
    public Review getReviewById(int id) {
        Review review = null;
        String sql = "SELECT * FROM reviews WHERE review_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                review = mapRowToReview(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server", e);
        }
        return review;
    }

    @Override
    public Review createReview(Review review) {
        Review createdReview = new Review();
        String sql = "INSERT INTO reviews (profile_id, movie_id, body, rating) " +
                "VALUES (?, ?, ?, ?) RETURNING review_id;";
        try {
            int newReviewId = jdbcTemplate.queryForObject(sql, int.class, review.getProfileId(),
                    review.getMovieId(), review.getBody(), review.getRating());
            createdReview = getReviewById(newReviewId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        } catch (NullPointerException e) {
            throw new DaoException("Transfer Unsuccessful", e);
        }
        return createdReview;
    }

    @Override
    public Review updateReview(Review review) {
        Review updatedReview = new Review();
        String sql = "UPDATE reviews SET body = ?, rating = ? WHERE review_id = ?;";
        try {
            int numberOfRows = jdbcTemplate.update(sql, review.getBody(),
                    review.getRating(), review.getReviewId());
            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected one");
            } else {
                updatedReview = getReviewById(review.getReviewId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedReview;
    }

    private Review mapRowToReview(SqlRowSet rs) {
        Review review = new Review();
        review.setReviewId(rs.getInt("review_id"));
        review.setProfileId(rs.getInt("profile_id"));
        review.setMovieId(rs.getInt("movie_id"));
        review.setBody(rs.getString("body"));
        review.setRating(rs.getInt("rating"));
        return review;
    }

}
