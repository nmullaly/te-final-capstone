<template>
	<div class="profile">
		<h1 id="profile-name">{{ profile.username }}</h1>
		<p id="profile-points">{{ profile.points }} points</p>
		<p id="bio">{{ profile.bio }}</p>
		<p id="fav-film">{{ profile.film }}</p>
		<p id="fav-genres">{{ profile.genres }}</p>
		<p id="fav-snack">{{ profile.snack }}</p>
		<button id="edit-profile-btn" v-on:click="showForm">Edit Profile</button>
		<edit-profile-form v-bind:profile="profile" v-show="isFormShown" />
	</div>
</template>

<script>
import EditProfileForm from '../components/EditProfileForm.vue';
import profileService from '../services/ProfileService.js';

export default {
	components: {
		EditProfileForm
	},
	data() {
		return {
			profile: {},
			isFormShown: false,
		}
	},
	methods: {
		showForm() {
			this.isFormShown = true;
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
			})
	}
}

</script>

<style>

</style>