<template>
    <img
        src="../assets/Popcorn.svg.png"
        id = "logo"
        width ="200"
        height="200"
      />
     
    <h1>SilverScreenSavants</h1>
    <div v-if="!$store.state.token" id = "SheepleDisplay"><p>REGISTER, SHEEPLE!</p>
      <img src = "../assets/Sheeple\Savant/Sheeple.png"/>
    </div>
    <div v-if="$store.state.token" id = "SavantDisplay"><p>Welcome, Fellow Savant</p>
      <img src = "../assets/Sheeple\Savant/OoS_Golden_Sage_Sprite.png"/>
    </div>
        <button class="movies">Films</button>
        <button class="users">Users</button>
        <button class="scoreboard">Scoreboard</button>
        <button v-if="!$store.state.token" class="login" v-on:click="redirectToLogin">log in</button>
        <button v-if="$store.state.token" v-bind:to="{ name: 'logout' }" class="logout" v-on:click="logout">log out</button>
        <button v-if="!$store.state.token" class="register" v-on:click="redirectToRegister">register</button>
        <button v-if="$store.state.token" class="profile" v-on:click="redirectToProfile">profile</button>
        <button class="home" v-on:click="redirectToHome">home</button>
</template>

<script>
export default{
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
  font-style: courier-new;
}
.header img#logo {
  width: 50px; 
  height: auto; 
}
h1{
  margin: left 100px;
  font-family: sans-serif;
}
button {
  margin-left:5px;
  text-decoration-style: white;
  font-family: courier-new;
}
.movies{
  margin-left: auto;
}
div.form-input-group {
text-decoration-color: aliceblue;
}
/* #SheepleDisplay{
display: none;
}
#SavantDisplay{
display: none;
} */
</style>
