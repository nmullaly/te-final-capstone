<template>
    <img
        src="../assets/Popcorn.svg.png"
        id = "logo"
      />
    <h1>Project Name Working Title</h1>
        <button class="movies">movies</button>
        <button class="users">users</button>
        <button class="scoreboard">scoreboard</button>
        <button class="login" v-on:click="redirectToLogin">log in</button>
        <button class="register">register</button>

</template>

<script>
export default{
    methods: {
        redirectToLogin() {
         this.$router.push({ name: 'login' });
         }
    }
    
}
</script>

<style>
.header{
  display: flex;
  background-color: #DC8A8A;
  border: 2px solid #000000;
  flex-direction: row; 
  justify-content: left;
  align-items: center; 
  font-size: medium;
}
.header img#logo {
  width: 50px; 
  height: auto; 
}
</style>
