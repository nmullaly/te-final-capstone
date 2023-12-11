<template>
	<div class="profile">
		<h1 id="profile-name">{{ this.profile.username }}</h1>
		<p id="profile-points">{{ this.profile.points }} points</p>
		<p id="bio">{{ this.profile.bio }}</p>
		<p id="fav-film">{{ this.profile.favoriteFilm }}</p>
		<p id="fav-genres">{{ this.profile.favoriteGenres }}</p>
		<p id="fav-snack">{{ this.profile.favoriteSnack }}</p>
		<button id="edit-profile-btn" v-on:click="routeToEdit" v-show="isCurrentUser">Edit Profile</button>
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
		showForm() {
			this.isFormShown = true;
		},
	}
}

</script>

<style>

</style>