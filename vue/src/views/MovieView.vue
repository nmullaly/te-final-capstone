<template>
	<header class = "header" id = "header">
    <header-bar/></header>
    <div id = "movieInfo">
      <p id="movieTitle">{{  this.movie.title }}</p>
      <p id="yearAndGenre">{{ formattedReleaseYear }},  {{  formattedGenres }}</p>
      <div id="middleContent">
        <img :src="'https://www.themoviedb.org/t/p/w300_and_h450_bestv2/' + this.movie.poster_path" id="poster"/>
        <div id="reviewList">
         <review v-for="item in this.reviewList" v-bind:key="item.reviewId" v-bind:review="item" id="headlineReview"/>
        </div>
      </div>
      <p id="overview">{{  this.movie.overview  }}</p>
    <div id="movieButtons">
      <div id="watchlistBtn">
        <button id="removeBtn" v-if="isOnWatchlist" v-on:click="removeFromWatchlist">Remove Film from Watchlist</button>
        <button id="addBtn" v-else v-on:click="addToWatchlist">Add Film to Watchlist</button>
      </div>
      <button id="reviewBtn" v-on:click="redirectToReviewForm">Review This Film</button>
    </div>
    <!-- <img :src="`/src/assets/Reviews/FakeReview${generateRandomReview()}.png`" id="randomReview"/> -->
  </div>
    <footer-bar/>
</template>


<script>
import HeaderBar from "../components/HeaderBar.vue";
import MovieSearchBar from "../components/MovieSearchBar.vue";
import MovieReview from "../components/MovieReview.vue";
import movieService from "../services/MovieService.js";
import watchlistService from "../services/WatchlistService.js";
import profileService from "../services/ProfileService.js";
import reviewService from "../services/ReviewService.js";
import Review from "../components/Review.vue";
// import ReviewCopy from "../components/ReviewCopy.vue";
import FooterBar from "../components/FooterBar.vue";

export default {
	components: {
		HeaderBar,
		// MovieSearchBar,
		// MovieReview,
    Review,
    // ReviewCopy,
    FooterBar,
	},
	data() {
    return {
      movie: {},
      // newReview: {},
      item: {
        profileId: this.$store.state.user.id,
        movieId: this.$route.params.id
      },
      reviewList: [],
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
    isOnWatchlist() {
      let isOn = false;
      this.$store.state.watchlist.forEach(item => {
        if (this.$route.params.id == item.movieId) {
          isOn = true;
        }
      });
      return isOn;
    }
  },
  created() {
    this.fetchMovie();
    this.fetchReviews();
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
    fetchReviews() {
      let movieId = this.$route.params.id;

      reviewService
        .getReviewsByMovie(movieId)
        .then((response) => {
          this.reviewList = response.data;

          this.reviewList.forEach(review => {
            movieService
							.getMovieById(review.movieId)
							.then((response) => {
								review.title = response.data.title;
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
            profileService
              .getProfileById(review.profileId)
              .then((response) => {
                review.username = response.data.username;
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
          })
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
    addToWatchlist() {
      let item = {
        profileId: this.$store.state.user.id,
        movieId: this.movie.id
      };
      console.log(item)
      watchlistService
        .addItemToWatchlist(item)
        .then(response => {
          if (response.status === 200) {
            console.log('Success');
          }
        })
        .catch(error => {
          console.log(error.response.data);
        });
      this.$store.commit("ADD_TO_WATCHLIST", item);
    },
    removeFromWatchlist() {
      let item = {
        profileId: this.$store.state.user.id,
        movieId: this.movie.id
      };
      console.log(item)
      watchlistService
        .removeItemFromWatchlist(item)
        .then(response => {
          if (response.status === 200) {
            console.log('Success');
          }
        })
        .catch(error => {
          console.log(error.response.data)
        });
      this.$store.commit("REMOVE_FROM_WATCHLIST", item);
    },
    redirectToReviewForm() {
      this.$router.push({name: 'AddReview', params: { id: this.$route.params.id }});
    }
  },

}

</script>


<style>
#headlineReview{
  background-color: #A0A59B;
  border-radius: 5px;
  border: 2px solid black;
  margin-left: 15rem;
  width: 500px;
	height:auto;
}
#reviewList {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

#movieButtons {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 45px;
}

#movieTitle{
  /* font-family: 'Courier New', Courier, monospace; */
  font-weight: bold;
  font-size: 35px;
  display:flex;
  justify-self: start;
  margin: 0px;
  margin-top: 2.5rem;
  margin-left: 5px;
  text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.8);
}
#yearAndGenre{
  /* font-family: 'Courier New', Courier, monospace; */
  font-size: 15px;
  display:flex;
  justify-self: start;
  margin: 0px;
  margin-left: 5px;
  text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.5);
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
  text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.8);
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