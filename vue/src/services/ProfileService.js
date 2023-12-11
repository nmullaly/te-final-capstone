import axios from 'axios';


export default {

	getProfiles() {
		return axios.get('/profiles');
	},

	getProfileByUsername(profileName) {
		return axios.get(`/profile/${profileName}`)
	},

	getProfileById(id) {
		return axios.get(`/profile/${id}`)
	},

	createProfile(profile) {
		return axios.post('/register', profile)
	},

	updateProfile(profile) {
		return axios.put(`/profile/${profile.profileId}`, profile);
	},

}