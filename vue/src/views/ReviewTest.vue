<template>
	<review v-bind:review="review"/>
</template>

<script>
import Review from '../components/Review.vue';
import MovieService from '../services/MovieService';
import ReviewService from '../services/ReviewService';
import ProfileService from '../services/ProfileService';

export default {
	components: {
		Review
	},
	data() {
		return {
			review: {},
			movie: {},
			profile: {},
		}
	},
	created() {
		let reviewId = 1
		ReviewService.getReviewById(reviewId)
			.then(response => {
				this.review = response.data;
				let movieId = parseInt(this.review.movieId);
				MovieService.getMovieById(movieId)
				.then(response => {
					this.movie = response.data;
					this.review.movieName = this.movie.title;
				})
				.catch((error) => {
					if(error.response) {
						console.log(error.response.status);
					} else if (error.request) {
						console.log("Server error");
					} else {
						console.log("Front-end error");
					}
				});
				let profileId = parseInt(this.review.profileId);
				ProfileService.getProfileById(profileId)
					.then(response => {
						this.profile = response.data;
						this.review.username = this.profile.username;
					})
					.catch((error) => {
						if(error.response) {
							console.log(error.response.status);
						} else if (error.request) {
							console.log("Server error");
						} else {
							console.log("Front-end error");
						}
					});
			})
			.catch(error => {
				if (error.response) {
					console.log(error.response.status);
				} else if (error.request) {
					console.log("Server error");
				} else {
					console.log("Front-end error");
				}
			});
		

	}
}
</script>