<template>
    <form class="new-movie-form" v-on:submit.prevent="saveFilm">
      <input class="title-input" name="title-input" type="text" placeholder="Title" v-model="film.title" />
    
      <button>Add a film T your Watchlist</button>
    </form>
  </template>
  
  <script>
  export default {
    name: "new-movie-form",
    data() {
      return {
        film: {
            title: ''
        }
      }
    },
    methods: {
      saveFilm() {
        this.$emit('film-added', this.film);
        this.film = {
            title: ''
        };
        
      }
    }
  }
  </script>
  
  <style>
  
  </style>
  