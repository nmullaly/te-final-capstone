<template>
	<profile-test v-bind:profile="profile"/>
</template>

<script>

import ProfileTest from '../components/ProfileTest.vue';
import profileService from '../services/ProfileService.js';


export default {
	components: {
		ProfileTest,
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
			.catch(error => {
				console.log('error retrieving profile');
			})
	}
}

</script>

<style>

</style>