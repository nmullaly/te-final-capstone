<template>
    <div id="main">
        <div id="poster">
            <img :src="'https://www.themoviedb.org/t/p/w300_and_h450_bestv2/' + this.movie.poster_path"/>
        </div>
        <div id="info">
        <h1>{{ this.movie.title }}</h1>
        <button id="removeBtn" v-if="isOnWatchlist" v-on:click="removeFromWatchlist">Remove Film from Watchlist</button>
        <button id="addBtn" v-else v-on:click="addToWatchlist">Add Film to Watchlist</button>
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
            movie: {},
            movieId: 579974,
            // for watchlist purposes
            item: {
                profileId: this.$store.state.user.id
            },
        }
    },
    created() {
        movieService.getMovieById(this.movieId)
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
        this.item.movieId = this.movieId;
    },
    computed: {
        isOnWatchlist() {
            let isOn = false;
            // this.$store.state.watchlist.forEach(item => {console.log(item)})
            this.$store.state.watchlist.forEach(item => {
                if (this.movieId == item.movieId) {
                    isOn = true;
                }
            });
            return isOn;
        }
    },
    methods: {
        // getWatchlist() {
        //     watchlistService
        //         .getWatchlistByUserId(this.$store.state.user.id)
        //         .then(response => {
        //             this.userWatchlist = response.data;
        //         })
        //         .catch(error => {
        //             console.log(error.response);
        //         })
        // },
        addToWatchlist() {
            let item = {
                profileId: this.$store.state.user.id,
                movieId: this.movie.id
            };
            console.log(item)
            watchlistService
            .addItemToWatchlist(item)
            .then(response => {
                if (response.status === 200) {
                    console.log('Success');
                }
            })
            .catch(error => {
                console.log(error.response.data);
            });  
            this.$store.commit("ADD_TO_WATCHLIST", item);            
        },
        removeFromWatchlist() {
            let item = {
                profileId: this.$store.state.user.id,
                movieId: this.movie.id
            };
            console.log(item)
            watchlistService
            .removeItemFromWatchlist(item)
            .then(response => {
                if (response.status === 200) {
                    console.log('Success');
                }
            })
            .catch(error => {
                console.log(error.response.data)
            });
            this.$store.commit("REMOVE_FROM_WATCHLIST", item);
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