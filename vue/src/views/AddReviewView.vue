<template>
	<header class = "header" id = "header">
    <header-bar/>
	</header>
	<movie-review />
	<footer-bar />
</template>

<script>
import HeaderBar from "../components/HeaderBar.vue";
import FooterBar from "../components/FooterBar.vue";
import MovieReview from "../components/MovieReview.vue";

export default {
	components: {
		HeaderBar,
		FooterBar,
		MovieReview
	}
}

</script>

<style>

footer-bar {
  position: fixed;
  bottom: 0;
  width: 100%;
  background-color: #333; /* You can set the background color as needed */
  color: white; /* You can set the text color as needed */
  padding: 10px;
  margin-top: 2.5rem;
}

</style>