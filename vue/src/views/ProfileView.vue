<template>
	<div>
		<header-bar />
		<profile v-bind:profile="profile"/>
		<footer-bar />
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

</style>