//for reviews
import axios from 'axios';

export default {

	getReviews() {
		return axios.get('/reviews');
	},

	getReviewsByUser(id) {
		return axios.get(`profile/${id}/reviews`);
	},

	getReviewsByMovie(id) {
		return axios.get(`movie/${id}/reviews`);
	},

	getReviewById(id) {
		return axios.get(`reviews/${id}`);
	},

	createReview(review) {
		return axios.post('/reviews', review);
	},

	updateReview(review) {
		return axios.put(`/reviews/${review.review.id}`, review);
	}

}