<template>
	<form v-on:submit.prevent="saveChanges" class="profileForm">
		<div class="form-item">
			<label for="bio-field">Bio:</label>
			<input id="bio-field" type="text" v-model="editProfile.bio" autocomplete="off" />
			<p class="error-msg" v-bind:hidden="isBioErrorHidden">Error: Bio cannot be more than 200 characters</p>
		</div>
		<div class="form-item">
			<label for="fav-film-field">Favorite Film:</label>
			<input id="fav-film-field" type="text" v-model="editProfile.film">
			<p class="error-msg" v-bind:hidden="isFilmErrorHidden">Error: This field cannot be more than 50 characters</p>
		</div>
		<div class="form-item">
			<label for="fav-genres-field">Favorite Genres:</label>
			<input id="fav-genres-field" type="text" v-model="editProfile.genres">
			<p class="error-msg" v-bind:hidden="isGenresErrorHidden">Error: This field cannot be more than 100 characters</p>
		</div>
		<div class="form-item">
			<label for="fav-snack-field">Favorite Snack:</label>
			<input id="fav-snack-field" type="text" v-model="editProfile.snack">
			<p class="error-msg" v-bind:hidden="isSnackErrorHidden">Error: This field cannot be more than 50 characters</p>
		</div>
		<button class="btn btn-submit">Save Changes</button>
		<button class="btn btn-cancel" v-on:click="discardChanges">Discard Changes</button>
	</form>
</template>

<script>
import profileService from '../services/ProfileService.js';

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
				id: this.profile.id,
				bio: this.profile.bio,
				film: this.profile.film,
				genres: this.profile.genres,
				snack: this.profile.snack
			},
			isBioErrorHidden: true,
			isFilmErrorHidden: true,
			isGenresErrorHidden: true,
			isSnackErrorHidden: true,
		}
	},
	methods: {
		saveChanges() {
			if (!this.validateForm()) {
				return;
			}
			// TODO: This method should save changes and update the profile in the store/DB as well as display a message reporting the success/failure
			profileService
				.updateProfile(this.editProfile)
				.then(response => {
					if (response.status === 200) {
						this.$router.push({ name: 'ProfileView', params: { id: this.profile.id } });
					}
				})
				.catch(error => {
					alert('Error updating profile.');
				})
		},
		discardChanges() {
			let confirmed = (
				confirm('Are you sure you want to discard your changes?')
			)
			if (confirmed) {
				this.$router.push({ name: 'ProfileView', params: { id: this.profile.id } });
			}
		},
		validateForm() {
			let isValid = true;
			if (this.editProfile.bio.length > 200) {
				this.isBioErrorHidden = false;
				isValid = false;
			}
			if (this.editProfile.film.length > 50) {
				this.isFilmErrorHidden = false;
				isValid = false;
			}
			if (this.editProfile.genres.length > 100) {
				this.isGenresErrorHidden = false;
				isValid = false;
			}
			if (this.editProfile.snack.length > 50) {
				this.isSnackErrorHidden = false;
				isValid = false;
			}
			return isValid;
		}
	}
}

</script>

<style>

</style>