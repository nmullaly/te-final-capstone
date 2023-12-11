<template>
  <!-- <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  </div> -->
<body>
  <header class = "header" id = "header">
    <header-bar></header-bar>
  </header>
  <main>
  <div id = "buffer">
  </div>
  <div id = "content">
    <h1>Movies</h1>
      <h2>Encounter and Review Films to Increase Your Buff Score</h2>
    <div class = "navigation">
      <movie-search-bar id = "movieSearchBar"></movie-search-bar>
    </div>
      <movie-display></movie-display>   
        <p id = "movieText">
          <!-- Search our database of movies Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. -->
          On our website, you will encounter movies.  If you watch these movies, review them, and leave a suggested snack pairing you will increase your film buff score.  Fight against your fellow movie savants and claim the pinnacle of buffhood.  Search TMDB's API for movies by ID.
        </p>
    <h1>Social</h1>
      <h2>Flex Your Film Buff Score</h2>
    <div class = "navigation">
        <user-search-bar></user-search-bar>
    </div>
      <user-display></user-display>
        <p id = "movieText">
          <!-- Search our users for opinions on what movies to see and even what movies to stay away from. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. -->
          Search our users for opinions on what movies to see and even what movies to stay away from.  See how much bigger your buff score is than theirs, and know that their opinion mathematically doesn't matter as much yours.
        </p>
    <div id="griddy">
      <p class = "buffMessage" id = "mfof">A Message From Our Founder</p>
        <img src = "../assets/Ben.jpg" id = "Ben"/>
        <p class = "buffMessage">From the moment I understood the inadequacy of the general public's film knowledge I was disgusted.  Film is the most important and enjoyable art form, more than the lesser arts like music, books, or even TV shows.  People who disagree are wrong and will be referred on this website as "Sheeple".  You may even be a Sheeple now.  But do not fear!  The first step to Savant-hood is to create an account on our website and start reviewing films.  Only then can Film Buff status be achieved. </p>
    </div>
  </div>
</main>
  <footer-bar></footer-bar>
</body>
</template>

<script>
import HeaderBar from '../components/HeaderBar.vue';
import FooterBar from '../components/FooterBar.vue';
import MovieDisplay from '../components/MovieDisplay.vue';
import MovieSearchBar from '../components/MovieSearchBar.vue';
import UserSearchBar from '../components/UserSearchBar.vue';
import UserDisplay from '../components/UserDisplay.vue'

export default {
  components: {
    HeaderBar,
    FooterBar,
    MovieDisplay,
    MovieSearchBar,
    UserSearchBar,
    UserDisplay,
  },
  mounted(){
    window.scrollTo(0, 0);
  }
};
</script>

<style>
body{
  /* background-color: #788796; */
  /* background-color: #303439; */
  background-color: #151618;
  margin: 0;
  flex-direction: column;
  min-height: 100vh;
  align-items: center;
}

#buffer{
height: 20px;
background-color: #151618;
width: 80vw;
margin-left: auto;
margin-right: auto;
 /* this is here because the margins on the search bar make the page look ugly otherwise -Addie */
}

#content{
  /* background: linear-gradient(to bottom, #303439, #151618); */
  background-color: #151618;
  width: 80vw;
  height: 100vw;
  margin-left: auto;
  margin-right: auto;
}

footer{
  margin-top: auto;
}

#movieText{
  margin-top:5rem;
  margin-bottom: 2vw;
  font-size: 18px;
}

#movieSearchBar{
  margin-top: 1vw;
  margin-bottom: 3vw;
}

h1{
  color:aliceblue
}

h2{
  color:aliceblue
}

p{
  color:aliceblue
}

#Ben{
  margin-top: 20px;
  margin-bottom: 20px;
}

.buffMessage{
  font-size: 25px;
  color:black;
  background-color: rgba(128, 128, 128, 0.75);
  border-radius: 12px;
  /* font-family: 'Courier New', Courier, monospace; */
}

#mfof{
  font-size: 35px;
  margin-top:2vw;
}

#griddy{
  /* background-image: url("../assets/CinemaOrange.jpg"); */
  background-image: url("../assets/Cinema.jpg");
  background-size: cover; 
  background-repeat: no-repeat; 
  margin-top: 60px;
  border-radius: 12px;
  font-weight: bold;
}
</style>