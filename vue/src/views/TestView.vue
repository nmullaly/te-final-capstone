<template>
    test view
    <div>Maybe the real bizarre adventure was the friends we made along the way</div>
	<!-- <profile></profile> -->
    <p>{{  this.movie.title }}</p>
    <p>{{  this.movie.release_date }}</p>
    <p>{{  this.movie.tagline }}</p>
</template>

<script>
// import Profile from "../components/Profile.vue";
import movieService from "../services/MovieService.js";

export default {
components: {
	// Profile
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
					console.log("Issue retrieving film information");
				} else {
					console.log("Issue requesting film information");
				}
			});
}
};
</script>

<style>
</style>
<!-- <template>
	<div>
		<header-bar />
		<img src="src/assets/Zoldo/55px-OoS_Cap'n_Sprite.png"/>
		<profile v-bind:profile="profile"/>
		<footer-bar id="footerBar"/>
	</div>
</template>

<script>
import Profile from '../components/Profile.vue';
import HeaderBar from '../components/HeaderBar.vue';
import FooterBar from '../components/FooterBar.vue';
import profileService from '../services/ProfileService.js';

export default {
	components: {
		Profile,
		HeaderBar,
		FooterBar
	},
	data() {
		return {
			profile: {}
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
	}
}

</script>

<style>

body {
  margin: 0;
  padding: 0;
}

.footerBar {
  position: fixed;
  margin-top: 10vw;
}
</style> -->