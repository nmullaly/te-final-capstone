<template>
    <img
        src="../assets/Popcorn.svg.png"
        id = "logo"
        width ="200"
        height="200"
        v-on:click="redirectToHome"
      />
     
    <h1 v-on:click="redirectToHome" id="name">Call of Movie</h1>
    <div v-if="!$store.state.token" class = "signInRotato" id = "SheepleDisplay" v-on:click="redirectToRegister"><p>REGISTER, SHEEPLE!</p>
      <img src = "../assets/Sheeple\Savant/Sheeple.png"/>
    </div>
    <div v-if="$store.state.token" class = "signInRotato" id = "SavantDisplay" v-on:click="redirectToProfile"><p>Welcome, Fellow Savant</p>
      <img src = "../assets/Sheeple\Savant/OoS_Golden_Sage_Sprite.png"/>
    </div>
        <button class="home" v-on:click="redirectToHome">Home</button>
        <button v-if="!$store.state.token" class="login" v-on:click="redirectToLogin">Log In</button>
        <button v-if="!$store.state.token" class="register" v-on:click="redirectToRegister">Register</button>
        <button class="movies" v-on:click="redirectToMovies">Movies</button>
        <!-- <button class="users">Users</button> -->
        <!-- <button class="scoreboard">Scoreboard</button> -->
        <button v-if="$store.state.token" v-bind:to="{ name: 'logout' }" class="logout" v-on:click="logout">Log Out</button>
        <button v-if="$store.state.token" class="profile" v-on:click="redirectToProfile">Profile</button>
        <movie-search-bar/>
        <!-- <img src = "src/assets/hm3.jpg"/> -->
</template>

<script>
import MovieSearchBar from "../components/MovieSearchBar.vue"

export default {
components: {
    MovieSearchBar
},
    methods: {
        redirectToLogin() {
         
         this.$router.push({ name: 'login' });
         },
        redirectToRegister() {
         this.$router.push({ name: 'register' });
         },
        redirectToHome(){
          this.$router.push({name: 'home'});
        },
        redirectToProfile(){
          this.$router.push({ name: 'ProfileView', params: { id: this.$store.state.user.id } });
        },
        redirectToMovies(){
          this.$router.push({ name: 'MovieHome' });
        },
        logout(){
          this.$router.push({ name: 'logout' });
        }
    }
    
}</script>

<style>
.header{
  display: flex;
  background: linear-gradient(to bottom, #DC8A8A, #f01607);
  flex-direction: row; 
  text-align: center;
  text-justify: center;
  align-items: center; 
  font-size: medium;
}
.header img#logo {
  width: 50px; 
  height: auto; 
}
#movie{
  margin: left 100px;
}
button {
  margin-left:5px;
  text-decoration-style: white;
  cursor: url("../assets/hm3.jpg"), pointer;
}

div.form-input-group {
text-decoration-color: rgb(0, 0, 0);
}
#logo{
cursor: url("../assets/hm3.jpg"), pointer;
}
#name{
  display: flex;
  flex-direction: column;
  margin-left: 15px;
  cursor: url("../assets/hm3.jpg"), pointer;
  text-shadow: 2px 2px 2px rgba(0, 0, 0, 1.5);
  font-size: 50px;
  width: 200px;
}
.signInRotato{

  margin-right:auto;
  cursor: url("../assets/hm3.jpg"), pointer;
  text-shadow: 2px 2px 2px rgba(0, 0, 0, 10.8);
}
.signInRotato:hover {
  outline: 2px solid white;
  transform: scale(1.08);
}
#SheepleDisplay{
  margin-left: 36.75rem;
}
#SavantDisplay{
  margin-left: 36.1rem;
}
</style>
