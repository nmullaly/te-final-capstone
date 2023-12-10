import axios from 'axios';

const movieApi = axios.create({
	baseURL: "https://api.themoviedb.org/3/"
});

const apiKey = "?api_key=971c339ba0468ee012b9d13073c7f4f4";

export default {

	getMovieById(id) {
		return movieApi.get(`movie/${id}${apiKey}`);
	},

	searchMoviesByName(query) {
		return movieApi.get(`search/movie?query=${query}&include_adult=false`);
	},
}