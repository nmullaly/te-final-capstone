<template>
<div>
    <MovieCardWSearch v-for="item in this.watchlist" :key="item.id" :film="item"/>
    <div class = "watchlist-section">
    <h1 class ="my-watchlist"></h1>
    
    </div>
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
  display: flex;
 justify-content: space-around;
}

div  {  
   display: flex;
 justify-content: space-around;
 flex-wrap: wrap;
}


</style>