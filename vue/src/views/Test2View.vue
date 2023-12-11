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
            userWatchlist: [],
            isOnWatchlist: false,
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
        this.getWatchlist();
        // this.isOnWatchlist = this.checkWatchlist();
    },
    // computed: {
    //     isOnWatchlist() {
    //         // if (this.userWatchlist == []) {
    //         //     this.isOnWatchlist = false;
    //         // }
    //         this.userWatchlist.forEach((item) => {
    //             if (item.movieId == this.movieId) {
    //                 return true;
    //             }
    //         })
    //         return false;
    //     }
    // },
    methods: {
        getWatchlist() {
            watchlistService
                .getWatchlistByUserId(this.$store.state.user.id)
                .then(response => {
                    this.userWatchlist = response.data;
                })
                .catch(error => {
                    console.log(error.response);
                })
        },
        // checkWatchlist() {
        //     // if (this.userWatchlist == []) {
        //     //     this.isOnWatchlist = false;
        //     // }
        //     this.userWatchlist.forEach((item) => {
        //         if (item.movieId == this.movieId) {
        //             return true;
        //         }
        //     })
        //     return false;
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
            this.getWatchlist();
            // this.isOnWatchlist = this.checkWatchlist();
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
            this.getWatchlist();
            // this.isOnWatchlist = this.checkWatchlist();
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