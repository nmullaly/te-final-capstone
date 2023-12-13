<template>
  <head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=VT323&display=swap" rel="stylesheet">
  </head>
  <div id="capstone-app">
    <div id="nav">
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
      <!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
      <!-- <audio ref="audioPlayer" src="../assets/322640__aruscio28__hitmarker-sound-effect.mp3"></audio>
      <img id="customCursor" src="src/assets/hm3.jpg" alt="Custom Cursor"
      v-on:click="handleClick" /> -->
    </div>
    <router-view />
  </div>
</template>
<script>
  export default {
    created() {
      this.$store.commit("GET_WATCHLIST");
    }
  }
// export default {
// methods: {
//   handleClick() {
//       this.$refs.audioPlayer.play(event);
//       const customCursor = document.getElementById('customCursor');
//       customCursor.style.left = `${event.clientX}px`;
//       customCursor.style.top = `${event.clientY}px`;
//     },
// },
// };
</script>
<style>

  * {
    font-family: "VT323";
    font-weight: normal;
  }

  #login {
    color: black;
  }

</style>