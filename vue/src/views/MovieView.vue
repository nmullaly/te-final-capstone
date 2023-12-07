<template>
	<header class = "header" id = "header">
    <header-bar/>
  </header>
	<movie-search-bar/>
    <p>{{  this.movie.title }}</p>
    <!-- <MovieReview/> -->
</template>


<script>
import HeaderBar from "../components/HeaderBar.vue"
import MovieSearchBar from "../components/MovieSearchBar.vue"
// import MovieReview from "../components/MovieReview.vue";
import movieService from "../services/MovieService.js";

export default {
	components: {
		HeaderBar,
		MovieSearchBar,
		// MovieReview,
	},
	data() {
    return {
      movie: {},
    };
  },

  created() {
    this.fetchMovie();
  },

  watch: {
    '$route.params.id': 'fetchMovie',
  },

  methods: {
    fetchMovie() {
      let movieId = this.$route.params.id;

      movieService
        .getMovieById(movieId)
        .then((response) => {
          this.movie = response.data;
        })
        .catch((error) => {
          if (error.response) {
            console.log(error.response.status);
          } else if (error.request) {
            console.log("Server error");
          } else {
            console.log("Front-end error");
          }
        });
    },
  },
}

</script>


<style>

</style>