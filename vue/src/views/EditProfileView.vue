<template>
<header class="header" id="header">
		<header-bar />
	</header>
	<edit-profile-form v-bind:profile="profile" v-if="isCurrentUser"/>
	<p v-else>Log in to edit this profile</p>
	<footer-bar />
</template>

<script>

import EditProfileForm from '../components/EditProfileForm.vue';
import HeaderBar from '../components/HeaderBar.vue';
import FooterBar from '../components/FooterBar.vue';
import profileService from '../services/ProfileService.js';


export default {
	components: {
		EditProfileForm,
		HeaderBar,
		FooterBar,
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
	},
	computed: {
		isCurrentUser() {
			if (this.$route.params.id == this.$store.state.user.id) {
				return true;
			} else {
				return false;
			}
		}
	}
}

</script>

<style>

</style>