<template>
	<header-bar class="header" id="header"/>
	<add-film/>
</template>

<script>
import movieService from "../services/MovieService.js";
import AddFilm from "../components/AddFilm.vue";
import HeaderBar from "../components/HeaderBar.vue";

export default {
components: {
	HeaderBar,
	AddFilm,
},
};
</script>

<style>
</style>