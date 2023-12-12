<template>
	<header class = "header" id = "header">
	<header-bar/></header>
	<div id="searchResults">
		<MovieCardWSearch v-for="movie in this.movieIds" :key="movie.id" :film="movie" />
	</div>
	<div id="moar" v-on:click="redirectToMovies">
			<h2>Encounter More Movies</h2>
			<button class = "newMovieButton" v-on:click="redirectToMovies">&#8658;</button>
	</div>
	<footer-bar/>
</template>


<script>
import HeaderBar from "../components/HeaderBar.vue";
import MovieCardWSearch from "../components/MovieCardWSearch.vue";
import FooterBar from "../components/FooterBar.vue";
import movieService from "../services/MovieService";

export default {
	components: {
		HeaderBar,
		MovieCardWSearch,
		FooterBar,
	},
	data() {
		return {
			movies: [],
			movieIds: [],
			query: this.$route.params.query,
		}
	},
	created() {
		this.fetchResults();
	},
	mounted() {
		window.scrollTo(0, 0);
	},
	methods: {
		fetchResults() {
      movieService
				.searchMoviesByName(this.query)
				.then(response => {
					this.movies = response.data.results.filter((movie) => {
						if (movie.poster_path == null) {
							return false;
						} else {
							return true;
						}
					});
					
					this.movies.forEach((movie => {
						this.movieIds.push({movieId:movie.id})
					}))
				})
				.catch(error => {
          console.log(error.response);
        });
		},
		redirectToMovies() {
			window.location.reload();
			window.scrollTo(0, 0);
		},
	}
};
</script>


<style>
#searchResults {
	display: flex;
	flex-wrap: wrap;
}

.display{
	margin-top: 30px;
	margin-bottom: 50px;
}
#moar{
	display:flex;
	justify-content: flex-end;
	background-image: url("../assets/Banner2.jpg");
	margin-top:120px;
	/* font-family: 'Courier New', Courier, monospace; */
	cursor: pointer;
	background-color: rgba(0, 0, 0, 0.1);
}

#moar:hover {
	outline: 3px solid whitesmoke;
	transform: scale(1.03);
}

#search{
	display:flex;
	background-image:url("../assets/curtain2.jpg");
	justify-content: center;
	align-content: center;
	margin-top: 30px;
	margin-bottom: 30px;
	/* font-family: 'Courier New', Courier, monospace; */
}
.newMovieButton{
margin-right: 30px;
}
</style>