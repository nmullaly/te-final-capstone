<template>
    <footer class="footyboi">
        <h1 id = "logo" v-on:click="redirectToHome">Call of Movie</h1>
        <h2 >Copyright 2024</h2>
        <h3 v-on:click="redirectToAbout">About Us</h3>
    </footer> 
</template>

<script>
export default{
    methods: {
      redirectToHome(){
          this.$router.push({name: 'home'});
        },redirectToAbout() {
            window.open('https://www.youtube.com/watch?v=7i0XToRoc34', '_blank');
        },
    }
        
}</script>


<style>
.footyboi {
  display: flex;
  flex-direction: row; /* Make the children stack vertically */
  justify-content: center; /* Center vertically */
  align-items: center; /* Center horizontally */
  background-color: #DC8A8A;
  background: linear-gradient(to bottom, #f72a06, #DC8A8A);
  /* border: 2px solid #000000; */
  font-size: medium;
  margin-bottom: 0;
  text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2);
}
.footyboi > * {
  font-size: 18px; /* Adjust the font size as needed */
  flex-grow: 1;
  justify-content: center; 
  text-align: center;
}
#logo{
  color:aliceblue;
  text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2);
}

h2{
  color:aliceblue;
  text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2);
}

h3{
  color:aliceblue;
  cursor: pointer;
  text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2);
}


</style>