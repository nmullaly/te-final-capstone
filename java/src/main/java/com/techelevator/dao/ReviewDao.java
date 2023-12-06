package com.techelevator.dao;

import com.techelevator.model.Review;
import java.util.List;

public interface ReviewDao {

    List<Review> getReviews();
    List<Review> getReviewsByProfile(int profileId);
    List<Review> getReviewsByMovie(int movieId);
    Review getReviewById(int id);
    Review createReview(Review review);
    Review updateReview(Review review);


}
