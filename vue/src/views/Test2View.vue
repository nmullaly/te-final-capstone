<template>
    test view 2
    <div>Maybe the real bizarre adventure was the friends we made along the way</div>
    <p>{{  this.movie.title }}</p>
    <p>{{  this.movie.release_date }}</p>
    <p>{{  this.movie.tagline }}</p>
</template>

<script>
import UserProfilePic from "../components/UserProfilePic.vue";

import movieService from "../services/MovieService.js";

export default {
components: {
    // UserProfilePic,
},
data() {
    return {
        movie: {}
    }
},
created() {
    let movieId = 550;
    movieService.getMovieById(movieId)
			.then(response => {
				this.movie = response.data;
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
}
};
</script>

<style>
</style>