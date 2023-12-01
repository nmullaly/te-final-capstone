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
			editProfile: {
				bio: this.profile.bio,
				film: this.profile.film,
				snack: this.profile.snack
			}
		}
	},
	methods: {
		saveChanges() {
			
		}
	}
}

</script>

<style>

</style>