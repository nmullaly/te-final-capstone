package com.techelevator.controller;

import com.techelevator.dao.ReviewDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
public class ReviewController {

    private ReviewDao reviewDao;

    public ReviewController(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public List<Review> getReviews() {
        return reviewDao.getReviews();
    }

    @RequestMapping(path = "/profile/{id}/reviews", method = RequestMethod.GET)
    public List<Review> getReviewsByProfile(@PathVariable int id) {
        return reviewDao.getReviewsByProfile(id);
    }

    @RequestMapping(path = "/movie/{id}/reviews", method = RequestMethod.GET)
    public List<Review> getReviewsByMovie(@PathVariable int id) {
        return reviewDao.getReviewsByMovie(id);
    }

    @RequestMapping(path = "/reviews/{id}", method = RequestMethod.GET)
    public Review getReviewById(@PathVariable int id) {
        return reviewDao.getReviewById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public Review createReview(@RequestBody Review review) {
        return reviewDao.createReview(review);
    }

    @RequestMapping(path = "/reviews/{id}", method = RequestMethod.PUT)
    public Review updateReview(@PathVariable int id, @RequestBody Review review) {
        if (id != review.getReviewId()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Resource id does not match url.");
        }
        review.setReviewId(id);
        try {
            Review updatedReview = reviewDao.updateReview(review);
            return updatedReview;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Request not found.");
        }
    }

}
