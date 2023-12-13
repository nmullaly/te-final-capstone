<template>
    <footer class="footyboi">
        <h1 id = "logo" v-on:click="redirectToHome">Call of Movie</h1>
        <h2 id = "copyright">Copyright 2024</h2>
        <h3 id = "ocatc" v-on:click="redirectToAbout">About Us</h3>
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
  flex-direction: row; 
  justify-content: center; 
  align-items: center; 
  background-color: #DC8A8A;
  background: linear-gradient(to bottom, #f72a06, #DC8A8A);
  font-size: medium;
  margin-bottom: 0;
  text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2);
  border-radius: 5px;
}
.footyboi > * {
  font-size: 18px;
  flex-grow: 1;
  justify-content: center; 
  text-align: center;
}
#logo{
  color:aliceblue;
  text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2);
}

#copyright{
  color:aliceblue;
  text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2);
}

#ocatc{
  color:aliceblue;
  cursor: pointer;
  text-shadow: 2px 2px 2px rgba(0, 0, 0, 0.2);
}


</style>