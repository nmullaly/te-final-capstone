<template>
	<header class = "header" id = "header">
    <header-bar/></header>
    <div id = "movieInfo">
      <p id="movieTitle">{{  this.movie.title }}</p>
      <p id="yearAndGenre">{{ formattedReleaseYear }},  {{  formattedGenres }}</p>
      <div id="middleContent">
        <img :src="'https://www.themoviedb.org/t/p/w300_and_h450_bestv2/' + this.movie.poster_path" id="poster"/>
        <img :src="`/src/assets/Reviews/FakeReview${generateRandomReview()}.png`" id="randomReview"/>
      </div>
      <p id="overview">{{  this.movie.overview  }}</p>
    </div>
    <button>Add film to watchlist</button>
    <MovieReview id = "mr"/>
    <footer-bar/>
</template>


<script>
import HeaderBar from "../components/HeaderBar.vue";
import MovieSearchBar from "../components/MovieSearchBar.vue";
import MovieReview from "../components/MovieReview.vue";
import movieService from "../services/MovieService.js";
import ProfileService from "../services/ProfileService.js";
import FooterBar from "../components/FooterBar.vue";

export default {
	components: {
		HeaderBar,
		MovieSearchBar,
		MovieReview,
    FooterBar,
	},
	data() {
    return {
      movie: {},
      newReview: {},
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
    setReviewData(){
      this.newReview.reviewer = this.user.username;
      this.newReview.title = this.movie.title;
    },
    generateRandomReview() {
      let validIds = [1,2,3,4,5]
      let movieId = validIds[Math.floor(Math.random() * validIds.length)];
      return movieId;
    },
  },

}

</script>


<style>
#movieTitle{
  /* font-family: 'Courier New', Courier, monospace; */
  font-weight: bold;
  font-size: 35px;
  display:flex;
  justify-self: start;
  margin: 0px;
  margin-top: 2.5rem;
  margin-left: 5px;
}
#yearAndGenre{
  /* font-family: 'Courier New', Courier, monospace; */
  font-size: 15px;
  display:flex;
  justify-self: start;
  margin: 0px;
  margin-left: 5px;
}
#middleContent{
  display:flex;
  justify-self:space-between;
  align-items: center;
  margin-left: 5px;
}
#randomReview{
  margin-left: auto;
  margin-right: 5px;
}
#overview{
  /* font-family: 'Courier New', Courier, monospace; */
  font-size: 20px;
  display:flex;
  justify-self: start;
  margin: 0px;
  margin-left: 5px;
}
#movieInfo {
  margin-left: 15%;
  margin-right: 15%;
  background-color: rgba(128, 128, 128, 0.35);
  border-radius: 12px;
  margin-bottom: 2.5rem;
}
footer-bar {
  position: fixed;
  bottom: 0;
  width: 100%;
  background-color: #333; /* You can set the background color as needed */
  color: white; /* You can set the text color as needed */
  padding: 10px;
  margin-top: 2.5rem;
}
#mr {
  margin-bottom: 2.5rem;
}
</style>