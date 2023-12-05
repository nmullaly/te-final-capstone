<template>
	<form v-on:submit.prevent="saveChanges" class="profileForm">
		<div class="form-item">
			<label for="bio">Bio:</label>
			<input id="bio" type="text" v-model="editProfile.bio" autocomplete="off" />
		</div>
		<div class="form-item">
			<label for="fav-film">Favorite Film:</label>
			<input id="fav-film" type="text" v-model="editProfile.film">
		</div>
		<div class="form-item">
			<label for="fav-snack">Favorite Snack:</label>
			<input id="fav-snack" type="text" v-model="editProfile.snack">
		</div>
	</form>
</template>

<script>

export default {
	props: {
		profile: {
			type: Object,
			required: true
		}
	},
	data() {
		return {
			// Temporary profile object for editing
			editProfile: {
				bio: this.profile.bio,
				film: this.profile.film,
				snack: this.profile.snack
			}
		}
	},
	methods: {
		saveChanges() {
			// TODO: This method should save changes and update the profile in the store/DB as well as display a message reporting the success/failure
		}
	}
}

</script>

<style>

</style>