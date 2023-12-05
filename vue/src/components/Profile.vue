<template>
	<div class="profile">
		<h1 id="profile-name">{{ profile.username }}</h1>
		<p id="profile-points">{{ profile.points }}</p>
		<edit-profile-form v-show="isFormShown" />
		<p id="bio">{{ profile.bio }}</p>
		<p id="fav-film">{{ profile.film }}</p>
		<p id="fav-snack">{{ profile.snack }}</p>
	</div>
</template>

<script>
import EditProfileForm from '../components/EditProfileForm.vue';

export default {
	props: ['profile'],
	components: {
		EditProfileForm
	},
	data() {
		return {
			isFormShown: false,
		}
	}

}

</script>

<style>

</style>