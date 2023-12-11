<template>
    <div id="main">
        <div id="poster">
            <img :src="'https://www.themoviedb.org/t/p/w300_and_h450_bestv2/' + this.movie.poster_path"/>
        </div>
        <div id="info">
        <h1>{{ this.movie.title }}</h1>
        <button id="addBtn" v-if="isOnWatchlist" v-on:click="addToWatchlist">Add Film to Watchlist</button>
        <button id="removeBtn" v-else v-on:click="removeFromWatchlist">Remove Film from Watchlist</button>
        </div>
    </div>
</template>

<script>
import UserProfilePic from "../components/UserProfilePic.vue";
import movieService from "../services/MovieService.js";
import watchlistService from "../services/WatchlistService.js";

export default {
    components: {
        // UserProfilePic,
    },
    data() {
        return {
            movie: {}
        }
    },
    computed: {
        isOnWatchlist() {
            watchlistService.getWatchlistByUserId(this.$store.state.user.id)
            .then

            return false;
        }
    },
    created() {
        let movieId = 579974;
        movieService.getMovieById(movieId)
            .then(response => {
                this.movie = response.data;
            })
            .catch((error) => {
                if (error.response) {
                    console.log(error.response.status);
                } else if (error.request) {
                    console.log("Server error");
                } else {
                    console.log("Front-end error");
                }
            });
    },
    methods: {
        addToWatchlist() {
            let item = {
                profileId: this.$store.state.user.id,
                movieId: this.movie.id
            };
            watchlistService
            .addItemToWatchlist(item)
            .then(response => {
                if (response.status === 200) {
                    console.log('Success');
                }
            })
            .catch(error => {
                console.log(error.response)
            })
        },
        removeFromWatchlist() {
            let item = {
                profileId: this.$store.state.user.id,
                movieId: this.movie.id
            };
            watchlistService
            .removeItemFromWatchlist(item)
            .then(response => {
                if (response.status === 200) {
                    console.log('Success');
                }
            })
            .catch(error => {
                console.log(error.response)
            })
        }
    }
};
</script>

<style>

#main {
    display: flex;
    align-content: center;
    justify-content: center;
}

#info {
    display: flex;
    justify-content: center;
    align-content: center;
    flex-direction: column;
}

</style>