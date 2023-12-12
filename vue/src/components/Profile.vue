<template>
	<div class="profile">
		<h1 id="profile-head">{{ this.profile.username }} | {{ this.profile.points }} points</h1>
		<p id="bio">{{ this.profile.bio }}</p>
		<p id="fav-film">Favorite Movie: {{ this.profile.favoriteFilm }}</p>
		<p id="fav-genres">Favorite Genre: {{ this.profile.favoriteGenres }}</p>
		<p id="fav-snack">Favorite Snack: {{ this.profile.favoriteSnack }}</p>
		<button id="edit-profile-btn" v-on:click="routeToEdit" v-show="isCurrentUser">Edit Profile</button>
	</div>
	<div v-if="profile.watchlist && profile.watchlist.length > 0">
      <h2>My Watchlist:</h2>
      <ul>
        <li v-for="film in profile.watchlist" :key="film.id">
          {{ film.title }}
        </li>
		</ul>
		</div>
		<div v-if ="reviewList && reviewList.length > 0">
			<h2>My Reviews:</h2>
			<review v-for="item in reviewList" :key="item.reviewId" :review="item"/>

		</div>
</template>

<script>
import EditProfileForm from '../components/EditProfileForm.vue';
import profileService from '../services/ProfileService.js';


export default {
	props: ['profile'],
	// components: {
	// 	EditProfileForm,
	// },
	data() {
		return {
			isFormShown: false,
		}
	},
	computed: {
		isCurrentUser() {
			if (this.$route.params.id == this.$store.state.user.id) {
				return true;
			} else {
				return false;
			}
		}
	},
	methods: {
		routeToEdit() {
			this.$router.push({ name: 'EditProfile', params: { id: this.$store.state.user.id } });
		}
	}
}

</script>

<style>
.profile {

padding: 0px 10px;
}
</style>