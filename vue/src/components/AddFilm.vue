<template>
  <head>
    <link href="https://fonts.googleapis.com/css2?family=VT323&display=swap" rel="stylesheet">
  </head>
    <form class="new-movie-form" v-on:submit.prevent="saveFilm">
      <input class="title-input" name="title-input" type="text" placeholder="Title" v-model="film.title" />
    
      <button v-on:click = "searchMovies"> Add a film to Your Watchlist</button>
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
  async searchMovies() {
        let query = this.film.title.trim();
        let movie = await MovieService.searchMoviesByName(query);
        console.log(JSON.stringify(movie.data.results[0].id));
        if (movie) {
          let firstMovie = movie.data.results[0];
          this.$router.push({ name: 'Movie', params: { id: firstMovie.id } });
        } else {
          console.error('Javascript is asshole.  Why Addie hate? https://youtu.be/2utk-uiaZlc?si=DBraYTxWVbq74Drs&t=42');
        }
      }
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
  