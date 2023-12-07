<template>
	<header class = "header" id = "header">
    <header-bar/></header>
	<movie-search-bar/>
    <p>{{  this.movie.title }}</p>
	<p>{{ formattedReleaseYear }}</p>
	<p>{{  formattedGenres }}</p>
	<img :src="'https://www.themoviedb.org/t/p/w300_and_h450_bestv2/' + this.movie.poster_path" />
	<p>{{  this.movie.overview  }}</p>
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
  computed: {
    formattedReleaseYear() {
      if (this.movie.release_date) {
        return this.movie.release_date.substring(0, 4);
      }
      return '';
    },
	formattedGenres() {
		let genreList = [];
		if (this.movie.genres) {
			this.movie.genres.forEach((genre) => {
				genreList.push(genre.name);
			});
		}
		return genreList.join(', ');
	},
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

// 	const options = {method: 'GET', headers: {accept: 'application/json'}};

// fetch('https://api.themoviedb.org/3/collection/collection_id/images', options)
//   .then(response => response.json())
//   .then(response => console.log(response))
//   .catch(err => console.error(err));
  },

}

</script>


<style>

</style>