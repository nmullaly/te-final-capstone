import { createStore as _createStore } from 'vuex';
import axios from 'axios';
import watchlistService from '../services/WatchlistService';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      watchlist: [],
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
        // this.$store.commit("GET_WATCHLIST");
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        // localStorage.removeItem('profile');
        state.token = '';
        state.user = {};
        state.watchlist = [];
        // state.profile = {};
        axios.defaults.headers.common = {};
      },
      GET_WATCHLIST(state) {
        watchlistService
          .getWatchlistByUserId(state.user.id)
            .then(response => {
              state.watchlist = response.data;
              localStorage.addItem('watchlist', response.data);
            })
            .catch(error => {
              console.log(error.response);
            });
      }
    },
  });
  return store;
}
