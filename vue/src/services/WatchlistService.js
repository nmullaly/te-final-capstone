import axios from 'axios';

// const movieApi = axios.create({
// 	baseURL: "https://api.themoviedb.org/3/"
// });

// const apiKey = "?api_key=971c339ba0468ee012b9d13073c7f4f4";

export default {

    getWatchlistByUserId(id) {
        return axios.get(`/profile/${id}/watchlist`);
    },

    // item is an object that contains the current user's Id
    // as profileId, and the movie Id as movieId
    addItemToWatchlist(item) {
        return axios.post(`profile/${item.profileId}/watchlist`, item);
    },

    // item is an object that contains the current user's Id
    // as profileId, and the movie Id as movieId
    removeItemFromWatchlist(item) {
        return axios.delete(`profile/${item.profileId}/watchlist`, item);
    }

}

