<template>
	<div>
	<header class="header" id="header">
		<header-bar />
	</header>
	<div class="content-container">
		<SideBar :profile="profile" id="sidebar"/>
		<div class="main-content">
		<!-- <profile v-bind:profile="profile" /> -->
		<div id="watchlist">
			<div v-for ="movie in profile.watchlist" :key="movie.id">
				<img :src="'https://www.themoviedb.org/t/p/w300_and_h450_bestv2/' + movie.poster_path" />
				<h3>{{ movie.title }}</h3>
				</div>
				</div>
 <!-- <add-film v-on:film-added="handleFilmAdded" /> -->
  <div id="reviewList">
			<review v-for="item in this.reviewList" v-bind:key="item.reviewId" v-bind:review="item"	/>
  </div>
		</div>
 </div>
 <footer-bar />
	</div>
  </template>

<script>
import Profile from '../components/Profile.vue';
import HeaderBar from '../components/HeaderBar.vue';
import FooterBar from '../components/FooterBar.vue';
import AddFilm from '../components/AddFilm.vue';
import profileService from '../services/ProfileService.js';
import reviewService from "../services/ReviewService.js";
import movieService from "../services/MovieService.js";
import Review from "../components/Review.vue";
import SideBar from "../components/SideBar.vue";

export default {
	components: {
		// Profile,
		HeaderBar,
		FooterBar,
		Review,
		// AddFilm,
		SideBar,
	},
	data() {
		return {
			profile: {},
			reviewList: [],
		}
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
.content-container {
	display: flex;

}

#sidebar {
	width: 40%;
}

.main-content {
	flex-grow: 1;
	padding: 20px;
}

</style>