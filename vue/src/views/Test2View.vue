<template>
    <p>{{ this.movies }}</p>
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
        movies: movieService.searchMoviesByName('trolls')
    }
},
// created() {
//     let movieId = 550;
//     movieService.getMovieById(movieId)
// 			.then(response => {
// 				this.movie = response.data;
// 			})
// 			.catch((error) => {
// 				if(error.response) {
// 					console.log(error.response.status);
// 				} else if (error.request) {
// 					console.log("Server error");
// 				} else {
// 					console.log("Front-end error");
// 				}
// 			});
// }
};
</script>

<style>
</style>