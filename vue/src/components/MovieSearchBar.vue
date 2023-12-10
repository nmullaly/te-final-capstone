<template>
    <div class="search-bar">
        <input type="text" v-model="input" placeholder="search..."/>
        <button v-on:click="searchMovies">Search Films</button>
    </div>
</template>

<script>
import movieService from "../services/MovieService.js";


// TODO: Import search by Movie from movieService
//  Get it to work
export default {
    data() {
      return {
        input: ''
      };
    },
    methods: {
      searchMovies() {
        let movieId = this.input.trim();
        if (movieId !== '') {
          this.$router.push({ name: 'Movie', params: { id: movieId } });
        }
      }
    }
  }
</script>

<style>
.search-bar{
    display: flex;
    /* margin-top: 0; */
    align-items: center;
    justify-items: center;
    justify-content: center;
    margin-bottom: 20px;
}

.search-bar input {
  padding: 5px;
  margin-right: 5px;
}

.search-bar button {
  padding: 5px 10px;
}
</style>