<template>
    <form class="new-movie-form" v-on:submit.prevent="saveFilm">
      <input class="title-input" name="title-input" type="text" placeholder="Title" v-model="film.title" />
    
      <button>Add a film to Your Watchlist</button>
    </form>
  </template>
  
  <script>
  import MovieService from '../services/MovieService';
  export default {
    name: "new-movie-form",
    data() {
      return {
        film: {
            title: '',
        },
      };
    },
    methods: {
      async saveFilm() {
        try {
            const response = await MovieService.searchMoviesByName(this.film.title);
        if (response.data.results.length > 0) {
            const selectedMovie = response.data.results[0];
            this.$emit('film-added', selectedMovie);
        
        this.film = {
            title: ''
        };
        
      } else {
        console.warn('No movies found with the title:', this.film.title);
      }
    } catch (error) {
        console.error('Error adding movie', error);
    }
  },
},
  };
  </script>
  
  <style>
  button {
    font-family: 'Courier New', Courier, monospace;
  }
  </style>
  