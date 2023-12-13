<template>
	<div>
		<header class="header" id="header">
			<header-bar />
		</header>
		<div class="content-container">
			<div class="main-content">
				<SideBar :profile="profile" id="sidebar" />
				<div class="watchlist-reviews-container">
					<!-- <profile v-bind:profile="profile" /> -->
					<!-- <div id="watchlist">
					<div v-for ="movie in profile.watchlist" :key="movie.id">
					<img :src="'https://www.themoviedb.org/t/p/w300_and_h450_bestv2/' + movie.poster_path" />
					<h3>{{ movie.title }}</h3>
					</div>
					</div> -->
					<!-- <add-film v-on:film-added="handleFilmAdded" /> -->
					<div id="reviewList">
						<h1 id="my-reviews">My Reviews</h1>
						<p id="noReviewsText" v-if="this.reviewList.length == 0">No Reviews Yet!</p>
						<review v-for="item in this.reviewList" v-bind:key="item.reviewId" v-bind:review="item" />
					</div>
					<div id="profileWatchlist" v-show="isCurrentUser">
						<watchlist />
					</div>
				</div>
			</div>
		</div>
		<footer-bar />
	</div>
</template>

<script>
// import Profile from '../components/Profile.vue';
import HeaderBar from '../components/HeaderBar.vue';
import FooterBar from '../components/FooterBar.vue';
import AddFilm from '../components/AddFilm.vue';
import profileService from '../services/ProfileService.js';
import reviewService from "../services/ReviewService.js";
import movieService from "../services/MovieService.js";
import Review from "../components/Review.vue";
import SideBar from "../components/SideBar.vue";
import Watchlist from '../components/Watchlist.vue';

export default {
	components: {
		// Profile,
		HeaderBar,
		FooterBar,
		Review,
		// AddFilm,
		SideBar,
		Watchlist,
	},
	data() {
		return {
			profile: {},
			reviewList: [],
		}
	},
	computed: {
		isCurrentUser() {
			if (this.$route.params.id == this.$store.state.user.id) {
				return true;
			} else {
				return false;
			}
		},
	},
	created() {
		let profileId = parseInt(this.$route.params.id);
		profileService.getProfileById(profileId)
			.then(response => {
				this.profile = response.data;
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
		this.fetchReviews();
	},
	methods: { 
		showForm() {
			this.isFormShown = true;
		},
		fetchReviews() {
			let userId = this.$route.params.id;

			reviewService
				.getReviewsByUser(userId)
				.then((response) => {
					this.reviewList = response.data;

					this.reviewList.forEach(review => {
						profileService
							.getProfileById(review.profileId)
							.then((response) => {
								review.username = response.data.username;
								review.profileId = response.data.profileId;
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
						movieService
							.getMovieById(review.movieId)
							.then((response) => {
								review.title = response.data.title;
								review.movieId = response.data.id;
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
		handleFilmAdded(movie) {
      
      this.profile.watchlist = this.profile.watchlist || [];
      this.profile.watchlist.push(movie);

      
      profileService.updateProfile(this.profile)
        .then(() => {
          console.log('Film added to profile successfully');
        })
        .catch((error) => {
          console.error('Error updating user profile', error);
        });
	},
},
};
</script>

<style>

#noReviewsText {
	/* background-image: linear-gradient(#333333, #3333336c);
  border-radius: 12px;
  border: 1px solid white; */
	width: 500px;
	height: 211px;
}

.content-container {
  display: grid;
	width: 99%;
}

#sidebarSpace {
	/* width: 1fr; */
}

#sidebar {
  /* margin-top: 32px; */
	/* width: 400px; */
	/* width: 1fr; */
}

.main-content {
  /* flex-wrap: wrap; */
	display: grid;
	grid-template-columns: 2fr 6fr;
	width: 100%;
}

.watchlist-reviews-container {
  display: flex;
	grid-template-columns: 1fr 1fr;
	width: 100%;
	/* grid-column-gap: 5%; */
}

/* #watchlist {
	flex-wrap: wrap;
	display: block;
} */

#reviewList {
	display: flex;
	flex-direction: column;
	height: auto;
	width: 1fr;
	background-image: linear-gradient(#333333, #3333336c);
  border-radius: 12px;
  border: 1px solid white;
	padding: 0px 43px;
	align-self: start;
}

#profileWatchlist {
	width: 100%;
	height: auto;
	background-image: linear-gradient(#333333, #3333336c);
  border-radius: 12px;
  border: 1px solid white;
	align-self: start;
}

#my-reviews {
	text-align: center;
	/* position: absolute; */
	/* margin-top: -0.5%; */
	/* margin-left: 12%; */
	justify-content: space-around;
}

</style>