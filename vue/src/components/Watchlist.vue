<template>
  <div>
      <h1 class ="my-watchlist">My Watchlist</h1>
      <p v-if="watchlist.length==0">No Movies Yet!</p>
      <MovieCardWSearch v-for="item in this.watchlist" :key="item.id" :film="item"/>
      <!-- <div class = "watchlist-section">
      </div> -->
  </div>
  </template>
  <script>
  import MovieCardWSearch from './MovieCardWSearch.vue';
  import ProfileService from '../services/ProfileService';
  import WatchlistService from '../services/WatchlistService';
  import MovieService from '../services/MovieService';
  export default {
    components: { MovieCardWSearch },
    data() {
      return {
        profileId: parseInt(this.$route.params.id),
        watchlist: []
      }
    },
    created() {
      this.getWatchlist();
    },
    methods: {
      getWatchlist() {
        WatchlistService
          .getWatchlistByUserId(this.profileId)
          .then(response => {
            this.watchlist = response.data;
          })
          .catch(error => {
            console.log(error.response);
          });
      }
    }
  }
  </script>
<style scoped>
.my-watchlist {
  text-align: center;
  justify-content: space-evenly;
  margin-bottom: 20px;
  width: 100%;
}

div {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}

h1 {
  /* margin-top: -1%; */
  /* position: absolute; */
  text-align: center;
}
</style>