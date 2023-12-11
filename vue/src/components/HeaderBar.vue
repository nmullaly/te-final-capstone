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
        <button class="users">Users</button>
        <button class="scoreboard">Scoreboard</button>
        <button v-if="$store.state.token" v-bind:to="{ name: 'logout' }" class="logout" v-on:click="logout">Log Out</button>
        <button v-if="$store.state.token" class="profile" v-on:click="redirectToProfile">Profile</button>
        <audio ref="audioPlayer" src="../assets/322640__aruscio28__hitmarker-sound-effect.mp3"></audio>
        <!-- <img src = "src/assets/hm3.jpg"/> -->
</template>

<script>
export default{
    methods: {
        redirectToLogin() {
         this.$refs.audioPlayer.play();
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
  /* font-style: courier-new; */
}
.header img#logo {
  width: 50px; 
  height: auto; 
}
h1{
  margin: left 100px;
  /* font-family: 'Courier New', Courier, monospace; */
}
button {
  margin-left:5px;
  text-decoration-style: white;
  /* font-family: courier-new; */
  cursor: url("../assets/hm3.jpg"), pointer;
}

div.form-input-group {
text-decoration-color: aliceblue;
}
#logo{
cursor: url("../assets/hm3.jpg"), pointer;
}
#name{
  cursor: url("../assets/hm3.jpg"), pointer;
}
.signInRotato{
  margin-left:35.5rem;
  margin-right:auto;
  cursor: url("../assets/hm3.jpg"), pointer;
}
</style>
