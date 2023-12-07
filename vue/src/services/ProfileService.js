import axios from 'axios';


export default {

	getProfiles() {
		return axios.get('/profiles');
	},

	getProfileByUsername(profileName) {
		return axios.get(`/profiles/${profileName}`)
	},

	getProfileById(id) {
		return axios.get(`/profiles/${id}`)
	},

	createProfile(profile) {
		return axios.post('/register', profile)
	},

	updateProfile(profile) {
		return axios.put(`/profiles/${profile.profileId}`, profile);
	},

}