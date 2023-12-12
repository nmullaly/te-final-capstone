<template>
    <div class="search-bar">
        <input type="text" v-model="input" placeholder="search..." @keyup.enter="searchMovies">Search Movies</input>
    </div>
</template>

<script>
import movieService from "../services/MovieService.js";

export default {
    data() {
      return {
        movies: {},
        movie: {},
        input: ''
      };
    },

    methods: {
    async searchMovies() {
        let query = this.input.trim();
        let movie = await movieService.searchMoviesByName(query);
        console.log(JSON.stringify(movie.data.results[0].id));
        if (movie) {
          let firstMovie = movie.data.results[0];
          this.$router.push({ name: 'Movie', params: { id: firstMovie.id } });
        } else {
          console.error('Javascript is asshole.  Why Addie hate? https://youtu.be/2utk-uiaZlc?si=DBraYTxWVbq74Drs&t=42');
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