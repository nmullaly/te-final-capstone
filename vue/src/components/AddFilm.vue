<template>
  <head>
    <link href="https://fonts.googleapis.com/css2?family=VT323&display=swap" rel="stylesheet">
  </head>
    <form class="new-movie-form" v-on:submit.prevent="saveFilm">
      <input class="title-input" name="title-input" type="text" placeholder="Title" v-model="film.title" />
    
      <button v-on:click = "saveFilm"> Add a film to Your Watchlist</button>
      <movie-card-w-search :film="film" />
    </form>
  </template>
  
  <script>
  import MovieService from '../services/MovieService';
  import MovieCardWSearch from '../components/MovieCardWSearch.vue'; 
  
  export default {
    components:{
      MovieCardWSearch,
    },
    name: "new-movie-form",
    data() {
      return {
        film: {
            title: '',
            id: '',
            poster_path: '',
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
    /* font-family: 'Courier New', Courier, monospace; */
    font-family: "VT323";
    font-size: 18px;
  }
  </style>
  