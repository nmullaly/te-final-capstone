<template>
    <img
        src="../assets/Popcorn.svg.png"
        id = "logo"
      />
    <h1>Project Name Working Title</h1>
        <button class="movies">movies</button>
        <button class="users">users</button>
        <button class="scoreboard">scoreboard</button>
        <!-- We can v-if to switch redirect to login to redirect to logout based on if the user is logged in -->
        <button class="login" v-on:click="redirectToLogin">log in</button>
        <button class="register" v-on:click="redirectToRegister">register</button>
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
    }
    
}</script>

<style>
.header{
  display: flex;
  background: linear-gradient(to bottom, #DC8A8A, #151618);
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
h1{
  margin: left 100px;
}
button {
  margin-left:5px
}
.movies{
  margin-left: auto;
}

</style>
