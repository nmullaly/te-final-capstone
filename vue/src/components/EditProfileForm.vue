<template>
	<form class="profileForm">
		<div class="form-item">
			<label for="bio-field">Bio:</label>
			<textarea id="bio-field" type="text" v-model="editProfile.bio" autocomplete="off" />
			<p class="error-msg" v-bind:hidden="isBioErrorHidden">Error: Bio cannot be more than 200 characters</p>
		</div>
		<div class="form-item">
			<label for="fav-film-field">Favorite Film:</label>
			<input id="fav-film-field" type="text" v-model="editProfile.favoriteFilm">
			<p class="error-msg" v-bind:hidden="isFilmErrorHidden">Error: This field cannot be more than 50 characters</p>
		</div>
		<div class="form-item">
			<label for="fav-genres-field">Favorite Genres:</label>
			<input id="fav-genres-field" type="text" v-model="editProfile.favoriteGenres">
			<p class="error-msg" v-bind:hidden="isGenresErrorHidden">Error: This field cannot be more than 100 characters</p>
		</div>
		<div class="form-item">
			<label for="fav-snack-field">Favorite Snack:</label>
			<input id="fav-snack-field" type="text" v-model="editProfile.favoriteSnack">
			<p class="error-msg" v-bind:hidden="isSnackErrorHidden">Error: This field cannot be more than 50 characters</p>
		</div>
		<button id="save" class="btn btn-save" v-on:click.prevent="saveChanges">Save Changes</button>
		<button id="cancel" class="btn btn-cancel" v-on:click.prevent="discardChanges">Discard Changes</button>
	</form>
</template>

<script>
import profileService from '../services/ProfileService.js';

export default {
	props: ['profile'],
	data() {
		return {
			// editProfile: {}
		}
	},
	created() {
		// this.editProfile = this.profile;
	},
	methods: {
		saveChanges() {
			if (!this.isFormValid()) {
				return;
			}
			// TODO: This method should save changes and update the profile in the store/DB as well as display a message reporting the success/failure
			profileService
				.updateProfile(this.editProfile)
				.then(response => {
					if (response.status === 200) {
						console.log('success')
						this.$router.push({ name: 'ProfileView', params: { id: this.$route.params.id } });
					}
				})
				.catch(error => {
					alert('Error updating profile.');
				})
		},
		discardChanges() {
			this.$router.push({ name: 'ProfileView', params: { id: this.$route.params.id } });
		},
		isFormValid() {
			let isValid = false;
			if (
				this.isBioErrorHidden &&
				this.isFilmErrorHidden &&
				this.isGenresErrorHidden &&
				this.isSnackErrorHidden
			) {
				isValid = true;
			}
			return isValid;
		}
	},
	computed: {
		isBioErrorHidden() {
			if (this.editProfile.bio == null) {
				return true;
			}
			if (this.editProfile.bio.length >= 200) {
				return false;
			} else {
				return true;
			}
		},
		isFilmErrorHidden() {
			if (this.editProfile.favoriteFilm == null) {
				return true;
			}
			if (this.editProfile.favoriteFilm.length > 50) {
				return false;
			} else {
				return true;
			}
		},
		isGenresErrorHidden() {
			if (this.editProfile.favoriteGenres == null) {
				return true;
			}
			if (this.editProfile.favoriteGenres.length > 100) {
				return false;
			} else {
				return true;
			}
		},
		isSnackErrorHidden() {
			if (this.editProfile.favoriteSnack == null) {
				return true;
			}
			if (this.editProfile.favoriteSnack.length > 50) {
				return false;
			} else {
				return true;
			}
		},
		editProfile() {
			return this.profile;
		}
	}
}

</script>

<style>
  * {
    margin: 5px;
  }

  .form-item {
    margin-bottom: 20px;
  }

  label {
    display: block;
    margin-bottom: 5px;
  }

  input {
    width: 70%; 
    padding: 10px;
    box-sizing: border-box;
    border-radius: 8px; 
    border: 1px solid #000000;
  }
  #bio-field {
    width: 70%;
    font-size: 16px;
    height: 100px; 
	border-radius: 8px; 
    vertical-align: top; 
    white-space: pre-wrap; 
}

  .error-msg {
    margin-top: 5px;
    margin-bottom: 20px;
    color: red;
  }

  .btn {
    margin-top: 10px;
    padding: 10px;
    font-size: 16px;
    border-radius: 8px; 
    cursor: pointer;
  }

  #save {
    background-color: green;
    color: white;
  }

  #cancel {
    background-color: gray;
    color: white;
  }
</style>

