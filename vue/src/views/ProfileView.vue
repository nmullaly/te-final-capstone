<template>
	<div>
		<header class = "header" id = "header">
			<header-bar/>
		</header>
		<profile v-bind:profile="profile"/>
		<add-film v-on:film-added="handleFilmAdded" />
		<footer-bar />
	</div>
</template>

<script>
import Profile from '../components/Profile.vue';
import HeaderBar from '../components/HeaderBar.vue';
import FooterBar from '../components/FooterBar.vue';
import AddFilm from '../components/AddFilm.vue';
import profileService from '../services/ProfileService.js';

export default {
	components: {
		Profile,
		HeaderBar,
		FooterBar,
		AddFilm,
	},
	data() {
		return {
			profile: {},
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
	},
	methods: { 
		showForm() {
			this.isFormShown = true;
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
.profile {
	
}
</style>