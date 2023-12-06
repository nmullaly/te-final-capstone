<template>
    <img
        src="../assets/Popcorn.svg.png"
        id = "logo"
        width ="200"
        height="200"
      />
     
    <h1>Project Name Working Title</h1>
        <button class="movies">Films</button>
        <button class="users">Users</button>
        <button class="scoreboard">Scoreboard</button>
        <!-- We can v-if to switch redirect to login to redirect to logout based on if the user is logged in -->
        <button class="login" v-on:click="redirectToLogin">Log In</button>
        <button class="register" v-on:click="redirectToRegister">Register</button>
        <button class="home" v-on:click="redirectToHome">Home</button>
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

</style>
