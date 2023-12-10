<template>
    <header class = "header" id = "header">
    <header-bar/></header>
    <h1>Some Wild Movies Appeared!</h1>
    <movie-display class="display"/>
    <movie-display class="display"/>
    <movie-display class="display"/>
    <div id="moar" v-on:click="redirectToMovies">
        <h2>Encounter More Movies</h2>
        <button class = "newMovieButton" v-on:click="redirectToMovies">&#8658;</button>
    </div>
    <div id = "search">
        <h2>Search Movies By Id:  </h2>
        <movie-search-bar/>
    </div>
    <footer-bar/>
</template>


<script>
import HeaderBar from "../components/HeaderBar.vue";
import MovieDisplay from "../components/MovieDisplay.vue";
import FooterBar from "../components/FooterBar.vue";
import MovieSearchBar from "../components/MovieSearchBar.vue"

export default {
components: {
    HeaderBar,
	MovieDisplay,
    FooterBar,
    MovieSearchBar
},
mounted(){
    window.scrollTo(0, 0);
  },
methods: {
redirectToMovies() {
    window.location.reload();
    window.scrollTo(0, 0);
         },
        }
};
</script>


<style>
.display{
    margin-top: 30px;
    margin-bottom: 30px;
}
#moar{
    display:flex;
    justify-content: flex-end;
    background-image: url("../assets/Banner2.jpg");
    margin-top:120px;
    font-family: 'Courier New', Courier, monospace;
    cursor: pointer;
    background-color: rgba(0, 0, 0, 0.1);
}

#moar:hover {
    outline: 3px solid whitesmoke;
    transform: scale(1.03);
}

#search{
    display:flex;
    background-image:url("../assets/curtain2.jpg");
    justify-content: center;
    align-content: center;
    margin-top: 30px;
    margin-bottom: 30px;
    font-family: 'Courier New', Courier, monospace;
}
.newMovieButton{
margin-right: 30px;
}
</style>