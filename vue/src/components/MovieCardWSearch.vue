<template>
  <div>
    <div id="holdThisBox">
      <img :src="'https://www.themoviedb.org/t/p/w300_and_h450_bestv2/' + this.movie.poster_path" v-on:click="routeToMovie" id="movie1" class="movieCard" />
    </div>
  </div>
</template>

<script>
import movieService from "../services/MovieService.js";
import reviewService from "../services/ReviewService.js";
import ProfileService from "../services/ProfileService.js";

export default {
  props: ['film'],

  data() {
    return {
      movie: {},
      newReview: {},
      hoveredRating: false,
    };
  },
  created() {
    this.fetchMovie();
  },
  methods: {
    fetchMovie() {
      movieService
							.getMovieById(this.film.movieId)
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
    routeToMovie() {
      this.$router.push({ name: "Movie", params: { id: this.movie.movieId } });
    },
  },
};
</script>

<style>
#holdThisBox {
  display: flex;
  justify-content: center;
  flex-direction: column;
}

.movieCard {
  margin-left: 10px;
  margin-right: 10px;
  border: 1px solid #CBD1DA;
  border-radius: 4px;
  height: 350px;
  width: auto;
  cursor: url("../assets/hm3.jpg"), pointer;
}

#holdThisBox:hover {
  outline: 3px solid whitesmoke;
  transform: scale(1.03);
}
</style>
