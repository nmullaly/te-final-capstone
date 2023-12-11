<!-- This component has a bunch of movies now for simplicity but in the future should be a template with just one -->
<template>
    <div>
        <div id="dontHoldThisBox">
        <movie-card id = "movie1" class="movieCard"/>
        <movie-card id = "movie2" class="movieCard"/>
        <movie-card id = "movie3" class="movieCard"/>
        <movie-card id = "movie4" class="movieCard"/>
        <movie-card id = "movie5" class="movieCard"/>
        <movie-card id = "movie6" class="movieCard"/>
        </div>
    </div>
</template>

<script>
import MovieCard from "../components/MovieCard.vue";

export default {
components: {
	MovieCard,
},
};
</script>

<style>
#dontHoldThisBox{
    display: flex;
    justify-content: center;
}
/* .movieCard{
    margin-left: 10px;
    margin-right: 10px;
    border: 1px solid #CBD1DA;
    border-radius: 4px;
} */
</style>
