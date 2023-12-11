import { createStore as _createStore } from 'vuex';
import axios from 'axios';
import profileService from '../services/ProfileService';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      profiles: profileService.getProfiles,
      profile: profileService.getProfileById(currentUser.id) || {}
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
        // this.UPDATE_PROFILE(state, profileService.getProfileByUsername(user.username));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        localStorage.removeItem('profile');
        state.token = '';
        state.user = {};
        state.profile = {};
        axios.defaults.headers.common = {};
      },
      UPDATE_PROFILE(state, profile) {
        state.profile = profile;
      }
    },
  });
  return store;
}
