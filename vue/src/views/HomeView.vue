<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  </div>
<body>
  <header class = "header" id = "header">
    <!-- I want the below code to be the header component but may have to do some renaming-->
    <header-bar></header-bar>
  </header>
  <main>
  <div class = "navigation">
    Todo navigation
  </div>
  <div>
      <movie-display></movie-display>
  </div>
</main>
  <footer-bar></footer-bar>
</body>
</template>

<script>
import HeaderBar from '../components/HeaderBar.vue';
import FooterBar from '../components/FooterBar.vue';
import MovieDisplay from '../components/MovieDisplay.vue';

export default {
  components: {
    HeaderBar,
    FooterBar,
    MovieDisplay,
  }
};
</script>

<style>
</style> 